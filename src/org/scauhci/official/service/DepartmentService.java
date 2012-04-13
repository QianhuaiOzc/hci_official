package org.scauhci.official.service;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.loader.annotation.IocBean;
import org.scauhci.official.bean.Department;
import org.scauhci.official.bean.DepartmentMember;
import org.scauhci.official.bean.Member;
import org.scauhci.official.bean.Project;

@IocBean(args = {"refer:dao"})
public class DepartmentService extends BasicMysqlService<Department>{

	public DepartmentService(Dao dao) {
		super(dao);
	}
	
	public Department getDepartment(int memberId){
		int dId=dao().fetch(DepartmentMember.class, Cnd.where("member_id", "=", memberId)).getId();
		return this.fetch(dId);
	}
	
	public DepartmentMember getDepartmentMember(int memberId){
		return dao().fetch(DepartmentMember.class, Cnd.where("member_id", "=", memberId));
	}
	
	public void addMember(DepartmentMember dm){
		dao().insert(dm);
	}
	
	public void updateMember(DepartmentMember dm){
		dao().update(dm);
	}
	
	public void deleteMember(DepartmentMember dm){
		dao().delete(dm);
	}
	
	
}
