package org.scauhci.official.dao;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.scauhci.official.bean.Meeting;

@IocBean(args = {"refer:dao"})
public class MeetingDao extends BasicDao<Meeting> {

	public MeetingDao(Dao dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

}
