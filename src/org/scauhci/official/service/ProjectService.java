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
		// TODO Auto-generated constructor stub
	}
	
	public void deletePorject(int id){
		Project p=this.fetch(id);
		p.setState(Project.STATE_FAIL);
		this.update(p);
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
	
	public void removeProjectMember(ProjectMember pm){
		this.dao().delete(pm);
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
	
	public List<Project> listByFree(Pager pager){
		Sql sql = dao().sqls().create("project.free");
		sql.setCallback(Sqls.callback.entities());
		sql.setPager(pager);
		sql.setEntity(dao().getEntity(Project.class));
		dao().execute(sql);
		return sql.getList(Project.class);
	}
	
	public List<Project> listByMember(int id,int state){
		return null;
	}
	
	
	
}
