package org.scauhci.official.dao;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.scauhci.official.bean.Attendance;


@IocBean(args = {"refer:dao"})
public class AttendanceDao extends BasicDao<Attendance> {
	
	public AttendanceDao(Dao dao){
		super(dao);
	}

}
