/**
 * 
 */
package org.scauhci.official.module;

import java.util.Map;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

/**
 * @author <a href="mailto://188480548@qq.com">ClarenceAu</a>
 *
 */
@IocBean
public class DisplayModule {

	@At("index")
	@Ok("jsp:page.front.index")
	public Map<String, Object> index() {
		return null;
	}
}
