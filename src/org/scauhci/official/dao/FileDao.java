package org.scauhci.official.dao;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.scauhci.official.bean.File;

@IocBean(args = {"refer:dao"})
public class FileDao extends BasicDao<File> {

	public FileDao(Dao dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}
	
}
