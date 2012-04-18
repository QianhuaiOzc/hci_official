/**
 * 
 */
package org.scauhci.official.service;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.scauhci.official.bean.Message;

/**
 * @author clarenceau
 *
 */
@IocBean(args = {"refer:dao"})
public class MessageService extends BasicMysqlService<Message> {

	public MessageService(Dao dao) {
		super(dao);
	}
	
	public Message createMessage(int type, String content) {
		Message message = new Message();
		message.setContent(content);
		message.setType(type);
		message.setDate(new java.util.Date());
		this.add(message);
		return message;
	}

}
