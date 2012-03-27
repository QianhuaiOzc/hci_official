package org.scauhci.official.dao;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.scauhci.official.bean.MemberExtend;

@IocBean(args = {"refer:dao"})
public class MemberExtendDao extends BasicDao<MemberExtend> {

	public MemberExtendDao(Dao dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

}
