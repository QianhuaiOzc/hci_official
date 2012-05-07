/**
 * 
 */
package org.scauhci.official.service;

import java.util.HashMap;
import java.util.Map;

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
		message.setMemberId(1);
		this.add(message);
		return message;
	}
	
	public void send(int messageId, int[] memberId) {
		
	}

	public int queryForNewMessage(String studentId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("studentId", studentId);
		return fetchInt(map);
	}
	
}
