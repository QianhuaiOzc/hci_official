package org.scauhci.official.service;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.scauhci.official.bean.Member;
import org.scauhci.official.dao.MemberDao;
import org.scauhci.official.dao.MemberExtendDao;

@IocBean
public class MemberService {
	
	@Inject
	MemberDao memberDao;
	@Inject
	MemberExtendDao memberExtendDao;
	
	public Member get(int id){
		return memberDao.fetch(id);
	}
	
	public void add(Member m){
		memberDao.add(m);
	}
	
	public void update(Member m){
		memberDao.update(m);
	}
	
	public void delete(int id){
		
	}
	
}
