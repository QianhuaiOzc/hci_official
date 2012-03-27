package org.scauhci.official.dao;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.scauhci.official.bean.DepartmentMember;

@IocBean(args = {"refer:dao"})
public class DepartmentMemberDao extends BasicDao<DepartmentMember> {
	public DepartmentMemberDao(Dao dao){
		super(dao);
	}
}
