package org.scauhci.official.dao;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.scauhci.official.bean.ReportMember;

@IocBean(args = {"refer:dao"})
public class ReportMemberDao extends BasicDao<ReportMember> {

	public ReportMemberDao(Dao dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

}
