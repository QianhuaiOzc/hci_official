package org.scauhci.official.service;

import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.scauhci.official.bean.Member;
import org.scauhci.official.bean.Project;
import org.scauhci.official.dao.MemberDao;
import org.scauhci.official.dao.ProjectDao;
import org.scauhci.official.dao.ProjectMemberDao;


@IocBean
public class ProjectService {
	@Inject
	MemberDao memberDao;
	@Inject
	ProjectDao projectDao;
	@Inject
	ProjectMemberDao projectMemberDao;
	
	public Project get(int id){
		return projectDao.fetch(id);
	}
	
	public void add(Project project){
		projectDao.add(project);
	}
	
	public void update(Project project){
		projectDao.update(project);
	}
	
	public void delete(int id){
		
	}
	
	public void addMember(int projectId,int memberId){
		
	}
	
	public void deleteMember(int projectId,int memberId){
		
	}
	
	public List<Member> getMemberList(){
		return null;
	}
	
}
