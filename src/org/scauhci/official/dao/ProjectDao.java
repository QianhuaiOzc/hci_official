package org.scauhci.official.dao;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.scauhci.official.bean.Project;

@IocBean(args = {"refer:dao"})
public class ProjectDao extends BasicDao<Project> {

	public ProjectDao(Dao dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

}
