package org.scauhci.official.dao;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.scauhci.official.bean.Department;

@IocBean(args = {"refer:dao"})
public class DepartmentDao extends BasicDao<Department> {
	public DepartmentDao(Dao dao){
		super(dao);
	}
}
