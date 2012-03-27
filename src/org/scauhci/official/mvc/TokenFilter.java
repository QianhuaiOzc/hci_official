package org.scauhci.official.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.nutz.mvc.ActionContext;
import org.nutz.mvc.ActionFilter;
import org.nutz.mvc.View;

public class TokenFilter implements ActionFilter {

	@Override
	public View match(ActionContext ac) {
		// TODO Auto-generated method stub
		 HttpServletRequest req = ac.getRequest();
	     HttpSession session=req.getSession();
	     
	     
		
		return null;
	}

}
