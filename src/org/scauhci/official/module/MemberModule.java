package org.scauhci.official.module;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.GET;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.POST;
import org.nutz.mvc.annotation.Param;
import org.scauhci.official.bean.Member;
import org.scauhci.official.bean.MemberExtend;
import org.scauhci.official.service.MemberService;
import org.scauhci.official.util.TokenUtil;

@IocBean
public class MemberModule {
	
	@Inject
	MemberService memberService;
	
	@At("/member/add")
	@Ok("jsp:page.manage.member.add")
	public void toAdd(HttpServletRequest req){
		req.setAttribute("TOKEN", TokenUtil.create(req.getSession()));
	}
	
	@At("/member/edit/?")
	@Ok("jsp:page.manage.member.edit")
	public void toEidt(int id, HttpServletRequest req){
		req.setAttribute("TOKEN", TokenUtil.create(req.getSession()));
		req.setAttribute("member", null);
		req.setAttribute("extend", null);
	}
	
	@POST
	@At("/member/?")
	@Ok("forward:/member/edit/{id}")
	public void eidt(int id, @Param("::member.") Member member,@Param("::extend.") MemberExtend me,  HttpServletRequest req){
		if(id!=0){
			
			
		}else{			
			
		}
	}
	
	@GET
	@At("/member/?")
	@Ok("json")
	public void get(int id){
		
	}
	
	@At("/member/delete/?")
	@Ok("json")
	public void delete(int id){
		
	}
	
	@POST
	@At("/member/avatar/?")
	public void upload(int id ,@Param("file") File file ){
		
	}
	
	@GET
	@At("/member/avatar/?")
	public void avatar(int id){
		
	}
	
	@At("/member/list/?/?")
	public void list(int type,int page){
		
		
	}
	
	

}
