package org.scauhci.official.service;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.loader.annotation.IocBean;
import org.scauhci.official.bean.Member;
import org.scauhci.official.bean.Project;


@IocBean(args = {"refer:dao"})
public class MemberService extends BasicMysqlService<Member>{

	public MemberService(Dao dao) {
		super(dao);
	}
	
	public void insertMember(Member m){	
		this.insertEntity(m, "extend");
	}
	
	public void updateMember(Member m){	
		this.update(m);
	}
	
	public void updateAll(Member m){	
		this.updateEntity(m, "extend");
	}
	
	
	public int countByState(int departmentId,int state){	
		Sql sql = dao().sqls().create("member.department.state");
		sql.params().set("departmentId", departmentId);
        sql.params().set("state", state);
		sql.setCallback(Sqls.callback.integer());
		dao().execute(sql);
		return sql.getInt();
	}
	
	public int countByState(int state){		
		return dao().count(Member.class, Cnd.where("state", "=", state));
	}
	
	
	public int countByType(int type){
		return dao().count(Member.class, Cnd.where("state", "=", type));
	}
	
	public int countByRole(int role){
		return dao().count(Member.class, Cnd.where("state", "=", role));
	}
	
	public int countByFree(){
		Sql sql = dao().sqls().create("member.free");
		sql.setCallback(Sqls.callback.integer());
		dao().execute(sql);
		return sql.getInt();
	}
	
	public List<Member> listByState(int departmentId,int state,Pager pager){
		Sql sql = dao().sqls().create("member.department.state");
		sql.params().set("departmentId", departmentId);
        sql.params().set("state", state);
		sql.setCallback(Sqls.callback.entities());
		sql.setPager(pager);
		sql.setEntity(dao().getEntity(Member.class));
		dao().execute(sql);
		return sql.getList(Member.class);
	}
	
	public List<Member> listByState(int state,Pager pager){
		return this.getList(Cnd.where("state", "=", state), pager);
	}
	
	public List<Member> listByType(int type,Pager pager){
		return this.getList(Cnd.where("type", "=", type), pager);
	}
	
	public List<Member> listAdmin(Pager pager){
		return this.getList(Cnd.where("role", "=", Member.ROLE_ADMIN), pager);
	}
	
	public Member getMember(int id){
		return this.getEntity(Cnd.where("id", "=", id), "extend");
	}
	
	public List<Member> find(String s){
		return null;
	}
	
	public List<Member> listByFree(Pager pager){
		Sql sql = dao().sqls().create("member.free");
		sql.setCallback(Sqls.callback.entities());
		sql.setPager(pager);
		sql.setEntity(dao().getEntity(Member.class));
		dao().execute(sql);
		return sql.getList(Member.class);
	}
	
	public List<Project> project(int memberId,int state){
		Sql sql = dao().sqls().create("member.projects");
		sql.setCallback(Sqls.callback.entities());
		sql.params().set("state", state);
		sql.params().set("memberId", memberId);
		sql.setEntity(dao().getEntity(Project.class));
		dao().execute(sql);
		return sql.getList(Project.class);
	}
	
	public void addPassword(int memberId,String password){
		Sql sql = dao().sqls().create("member.password.add");
		sql.params().set("password", password);
		sql.params().set("memberId", memberId);
		dao().execute(sql);
	}
	
	public void updatePassword(int memberId,String password){
		Sql sql = dao().sqls().create("member.password.update");
		sql.params().set("password", password);
		sql.params().set("memberId", memberId);
		dao().execute(sql);
	}
	
	public String getPassword(int memberId){
		Sql sql = dao().sqls().create("member.password.update");
		sql.setCallback(Sqls.callback.str());
		sql.params().set("memberId", memberId);
		dao().execute(sql);
		return sql.getString();
	}
	
}
