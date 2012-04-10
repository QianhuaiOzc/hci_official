package org.scauhci.official.service;

import java.util.List;

import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;
import org.nutz.service.IdEntityService;

public class BasicMysqlService<T> extends IdEntityService<T> {
	
	public BasicMysqlService(Dao dao) {
        super(dao);
    }
	
	public void add(T t) {
        dao().insert(t);
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
    
    
    
    
}
