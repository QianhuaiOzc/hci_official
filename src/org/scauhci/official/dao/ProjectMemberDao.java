package org.scauhci.official.dao;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.scauhci.official.bean.ProjectMember;

@IocBean(args = {"refer:dao"})
public class ProjectMemberDao extends BasicDao<ProjectMember> {

	public ProjectMemberDao(Dao dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

}
