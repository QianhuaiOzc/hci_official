package org.scauhci.official.dao;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.scauhci.official.bean.Report;

@IocBean(args = {"refer:dao"})
public class ReportDao extends BasicDao<Report> {

	public ReportDao(Dao dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

}
