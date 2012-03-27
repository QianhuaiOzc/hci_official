package org.scauhci.official.dao;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.scauhci.official.bean.MemberMessage;

@IocBean(args = {"refer:dao"})
public class MemberMessageDao extends BasicDao<MemberMessage> {

	public MemberMessageDao(Dao dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

}
