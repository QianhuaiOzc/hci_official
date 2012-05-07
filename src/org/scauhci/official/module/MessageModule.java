/**
 * 
 */
package org.scauhci.official.module;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.scauhci.official.service.MessageService;

/**
 * @author <a href="mailto://188480548@qq.com">ClarenceAu</a>
 *
 */
@IocBean
@At("/message")
@Ok("json")
public class MessageModule {
	
	@Inject
	private MessageService messageService;
	
	@At("/query")
	public int queryForNewMessage(@Param("studentId") String studentId) {
		return messageService.queryForNewMessage(studentId);
	}
}
