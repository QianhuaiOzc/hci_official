package org.scauhci.official.dao;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.scauhci.official.bean.Member;

@IocBean(args = {"refer:dao"})
public class MemberDao extends BasicDao<Member> {

	public MemberDao(Dao dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

}
