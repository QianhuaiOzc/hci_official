/**
 * 
 */
package org.scauhci.official.module;

import java.util.Map;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

/**
 * @author clarenceau
 *
 */
@IocBean
public class FrontModule {
	
	@At("/index")
	@Ok("jsp:page.front.index")
	public Map<String, Object> index() {
		return null;
	}
}
