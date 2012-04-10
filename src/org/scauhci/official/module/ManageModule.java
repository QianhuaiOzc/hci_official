package org.scauhci.official.module;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

@IocBean
@At("/mana-")
public class ManageModule {
	
	@At("main")
	@Ok("jsp:page.manage.main")
	public void main(){
				
	}
	
	@At("menu")
	@Ok("jsp:page.manage.left_menu")
	public void menu(){
				
	}
	
	

}
