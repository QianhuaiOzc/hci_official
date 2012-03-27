/**
 * 
 */
package org.scauhci.official.mvc;

import org.nutz.mvc.ActionContext;
import org.nutz.mvc.ActionFilter;
import org.nutz.mvc.View;

/**
 * 权限验证的过滤器
 * 
 * @author clarenceau
 *
 */
public class AuthFilter implements ActionFilter {
	
	private String name;

	/* (non-Javadoc)
	 * @see org.nutz.mvc.ActionFilter#match(org.nutz.mvc.ActionContext)
	 */
	@Override
	public View match(ActionContext ac) {
		Auth auth = ac.getMethod().getAnnotation(Auth.class);
		auth.value();
		ac.getRequest().getSession().getAttribute(name);
		return null;
	}

}
