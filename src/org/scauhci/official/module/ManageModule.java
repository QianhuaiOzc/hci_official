package org.scauhci.official.module;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

@IocBean
public class ManageModule {
	
	@At("/mana-main")
	@Ok("jsp:page.manage.main")
	public void main(){
				
	}
	
	@At("/mana-menu")
	@Ok("jsp:page.manage.left_menu")
	public void menu(){
				
	}
	
	

}
