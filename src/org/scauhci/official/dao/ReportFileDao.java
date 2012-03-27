package org.scauhci.official.dao;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.scauhci.official.bean.ReportFile;

@IocBean(args = {"refer:dao"})
public class ReportFileDao extends BasicDao<ReportFile> {

	public ReportFileDao(Dao dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

}
