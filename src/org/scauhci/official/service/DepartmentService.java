package org.scauhci.official.service;

import java.util.List;

import org.nutz.dao.Dao;
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
	
	public void membersByType(int dId,int type){
		
	}
	
	public List<Member> membersByState(int dId,int state){
		
		return null;
	}
	
	public void projects(int dId,int state){
		
	}
	
	public void countMember(int dId){
		
	}
	
	public void countMemberByType(int dId,int type){
		
	}
	
	public void countMemberByState(int dId,int state){
		
	}
	
	public void countProject(int dId){
		
	}
	
	public void countProject(int dId,int state){
		
	}
	
	public void addMember(DepartmentMember dm){
		
	}
	
	public void updateMember(DepartmentMember dm){
		
	}
	
	public void deleteMember(DepartmentMember dm){
		
	}
	
	
}
