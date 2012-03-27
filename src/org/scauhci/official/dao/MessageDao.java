package org.scauhci.official.dao;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.scauhci.official.bean.Message;

@IocBean(args = {"refer:dao"})
public class MessageDao extends BasicDao<Message> {

	public MessageDao(Dao dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

}
