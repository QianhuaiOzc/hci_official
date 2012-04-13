package org.scauhci.official.service;

import java.util.ArrayList;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.loader.annotation.IocBean;
import org.scauhci.official.bean.Member;
import org.scauhci.official.bean.Project;
import org.scauhci.official.bean.ProjectMember;

@IocBean(args = {"refer:dao"})
public class ProjectService extends BasicMysqlService<Project>{

	public ProjectService(Dao dao) {
		super(dao);
	}
	
	
	public List<Member> memberList(int id){
		Project p=this.fetch(id);
		this.dao().fetchLinks(p, "members");
		return p.getMembers();	
	}
	
	public List<Member> memberList(int id,int type){
		List<ProjectMember> l=this.dao().query(ProjectMember.class,Cnd.where("project_id", "=", id).and("type", "=", type));
		List<Member> list=new ArrayList<Member>();
		for(ProjectMember pm:l){		
				list.add(this.dao().fetch(Member.class, pm.getMemberId()));
		}
		return list;
	}
	
	public ProjectMember getProjectMember(int pId,int mId){
		return this.dao().fetch(ProjectMember.class,Cnd.where("project_id", "=", pId).and("member_id", "=", mId));
	}
	
	public void addProjectMember(ProjectMember pm){
		this.dao().insert(pm);
	}
	
	public void removeProjectMember(int id){
		this.dao().delete(ProjectMember.class, id);
	}
	
	public void updateProjectMember(ProjectMember pm){
		this.dao().update(pm);
	}
	
	public List<ProjectMember> projectMembers(int id){
		List<ProjectMember> list=this.dao().query(ProjectMember.class,Cnd.where("project_id", "=", id));
		for(ProjectMember pm:list){
			this.dao().fetchLinks(pm, "member");
		}
		return list;
	}
	
	public List<Project> listByState(int state,Pager pager){
		return getList(Cnd.where("state", "=", state), pager);
	}
	
	public  int countByFree(){
		Sql sql = dao().sqls().create("project.free.count");
		sql.setCallback(Sqls.callback.integer());
		dao().execute(sql);
		return sql.getInt();
	}
	
	public List<Project> listByFree(Pager pager){
		Sql sql = dao().sqls().create("project.free");
		sql.setCallback(Sqls.callback.entities());
		sql.setPager(pager);
		sql.setEntity(dao().getEntity(Project.class));
		dao().execute(sql);
		return sql.getList(Project.class);
	}
	
	public List<Project> listByMember(int memberId,int state){
		Sql sql = dao().sqls().create("project.list.by.member");
		sql.params().set("memberId", memberId);
        sql.params().set("state", state);
		sql.setCallback(Sqls.callback.entities());
		sql.setEntity(dao().getEntity(Project.class));
		dao().execute(sql);
		return sql.getList(Project.class);
	}
	
	public  int countByDepartment(int departmentId,int state){
		return this.count(Cnd.where("department_id", "=", departmentId).andNot("state","=", state));
	}
	
	public List<Project> listByDepartment(int departmentId,int state,Pager pager){
		return this.getList(Cnd.where("department_id", "=", departmentId).andNot("state","=", state), pager);
	}
	
	public int countByState(int state){		
		return dao().count(Project.class, Cnd.where("state", "=", state));
	}
	
}
