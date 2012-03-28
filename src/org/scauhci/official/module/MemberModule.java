package org.scauhci.official.module;

import javax.servlet.http.HttpServletRequest;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.GET;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.POST;
import org.nutz.mvc.annotation.Param;
import org.scauhci.official.service.MemberService;

@IocBean
public class MemberModule {
	
	@Inject
	MemberService memberService;
		
	@POST
	@At("/member/?")
	@Ok("jsp:page.manage.member.edit")
	public void eidt(@Param("id") Integer id, HttpServletRequest req){
		if(id!=null){
		}
	}
	
	@GET
	@At("/member/?")
	@Ok("json")
	public void get(int id){
		
	}
	

}
