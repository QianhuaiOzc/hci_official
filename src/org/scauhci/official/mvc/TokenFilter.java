package org.scauhci.official.mvc;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.nutz.mvc.ActionContext;
import org.nutz.mvc.ActionFilter;
import org.nutz.mvc.View;
import org.nutz.mvc.view.ServerRedirectView;
import org.nutz.mvc.view.VoidView;

public class TokenFilter implements ActionFilter {

	@Override
	public View match(ActionContext ac) {
		// TODO Auto-generated method stub
		 HttpServletRequest req = ac.getRequest();
	     HttpSession session=req.getSession();
	     
	     @SuppressWarnings("unchecked")
		 Set<String> tokens = (Set<String>) session.getAttribute("TOKEN");
	     String token = req.getParameter("TOKEN");
	     if (token == null) {
	    	 
	     }
	     if (tokens.contains(token)) {
	    	 tokens.remove(token);
	    	 return null;
	     }else{
	    	 return new VoidView();
	     }
	     

	}

}
