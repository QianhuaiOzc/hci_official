package org.scauhci.official.service;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.scauhci.official.bean.Member;


@IocBean(args = {"refer:dao"})
public class MemberService extends BasicMysqlService<Member>{

	public MemberService(Dao dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}
	
	
}
