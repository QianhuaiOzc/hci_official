package org.scauhci.official.dao;

import java.util.List;

import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;
import org.nutz.service.IdEntityService;

public class BasicDao<T> extends IdEntityService<T> {
	 public BasicDao(Dao dao) {
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
	    
}
