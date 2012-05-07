package org.scauhci.official.service;

import java.util.List;
import java.util.Map;

import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.sql.callback.FetchIntegerCallback;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.nutz.lang.Mirror;
import org.nutz.lang.Strings;
import org.nutz.service.IdEntityService;

public class BasicMysqlService<T> extends IdEntityService<T> {
	
	private String prefix;
	private Mirror<T> mirror = null;
	
	public BasicMysqlService(Dao dao) {
        super(dao);
        Class<T> entityClass = Mirror.getTypeParam(getClass(), 0);
        mirror = Mirror.me(entityClass);
        int begin = mirror.toString().lastIndexOf('.');
        prefix  = Strings.lowerFirst(mirror.toString().substring(begin + 1)) + ".";
    }
	
	public T add(T t) {
        return dao().insert(t);
    }

    public void update(T t) {
        dao().update(t);
    }
    
    public List<T> getAll(){
        List<T> list=this.query(null, null);
        return list;
    }
    
    public List<T> getListByPager(Pager pager){
        List<T> list=this.query(null, pager);
        return list;
    }

    protected List<T> getList( Condition cnd, Pager pager) {
        List<T> list = null;
        list = this.query( cnd, pager);
        return list;
    }
    
    protected  List<T> getList(Class<T> clazz, Condition cnd, Pager pager, String regex) {
        List<T> list = null;
        list = dao().query(clazz, cnd, pager);
        if (null != regex && !"".equals(regex)) {
            for (T obj : list) {
                dao().fetchLinks(obj, regex);
            }
        }
        return list;
    }
    
    protected  void insertEntity(T t, String regex) {

        if (regex != null && !"".equals(regex)) {
            dao().insertWith(t,regex);
        }else{
        	 dao().insert(t);
        }
 
    }
    
    protected void updateEntity(T t,String regex){
    	if (regex != null && !"".equals(regex)) {
            dao().updateWith(t,regex);
        }else{
        	 dao().update(t);
        }
    }
    
    protected  T getEntity(Condition cnd, String regex) {
        T obj = this.fetch(cnd);
        if (regex != null && !"".equals(regex)) {
            dao().fetchLinks(obj, regex);
        }
        return obj;
    }

    protected int deleteEntity(Object obj, String regex) {
        return dao().deleteWith(obj, regex);
    }
    
    protected int fetchInt(Map<String, Object> params) {
    	String sqlKey = Thread.currentThread().getStackTrace()[2].getMethodName();
    	Sql sql = dao().sqls().create(prefix + sqlKey);
    	sql.setCallback(new FetchIntegerCallback());
    	sql.params().putAll(params);
    	dao().execute(sql);
    	return sql.getInt();
    }
    
    
}
