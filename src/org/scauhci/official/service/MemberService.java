package org.scauhci.official.service;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
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
		// TODO Auto-generated constructor stub
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
	
	public void deleteMember(int id){
		Member m=this.fetch(id);
		m.setState(Member.STATE_LEAVE);
		this.update(m);
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
	
}
