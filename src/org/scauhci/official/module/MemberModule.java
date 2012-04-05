package org.scauhci.official.module;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Files;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.GET;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.POST;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;
import org.nutz.trans.Atom;
import org.nutz.trans.Trans;
import org.scauhci.official.Config;
import org.scauhci.official.bean.Member;
import org.scauhci.official.bean.MemberExtend;
import org.scauhci.official.service.MemberService;
import org.scauhci.official.util.ImageZip;
import org.scauhci.official.util.PrintImage;
import org.scauhci.official.util.TokenUtil;
import org.scauhci.official.util.Utils;

@IocBean
public class MemberModule {
	
	@Inject
	MemberService memberService;
	
	@At("/member/new")
	@Ok("jsp:page.manage.member.add")
	public void toAdd(HttpServletRequest req){
		
	}
	
	@At("/member/edit/?")
	@Ok("jsp:page.manage.member.edit")
	public void toEidt(int id, HttpServletRequest req){
		 Member member=memberService.getMember(id);
		 MemberExtend me=member.getExtend();
		 req.setAttribute("member", member);
		 req.setAttribute("extend", me);
	}
	
	@POST
	@At("/member/?")
	@Ok("json")
	public Map eidt(int id, @Param("::member.") final Member member,@Param("::extend.") final MemberExtend me,  HttpServletRequest req){
		Map<String,Object> map=new HashMap<String,Object>();
		try{
		if(id==0){
			 Trans.exec(new Atom() {
                 @Override
                 public void run() {
                	member.setPassword(Utils.getMD5(Config.INIT_PASSWORD));
                    member.setExtend(me);
                    memberService.insertMember(member);
                 }
             });		
		}else{			
			 Trans.exec(new Atom() {
                 @Override
                 public void run() {
                    member.setExtend(me);
                    memberService.updateAll(member);
                 }
             });
		}
		}catch(Exception e){
			e.printStackTrace();
			map.put("state", "fail");
			map.put("message", "操作失败");
			return map;
		}
		map.put("state", "ok");
		return map;
		
	}
	
	@GET
	@At("/member/?")
	@Ok("json")
	public Map get(int id){
		Map<String,Object> map=new HashMap<String,Object>();
		Member m=memberService.getMember(id);
		map.put("member", m);
		map.put("extend", m.getExtend());
		return map;
	}
	
	@At("/member/delete/?")
	@Ok("json")
	public Map delete(final int id){
		Map<String,Object> map=new HashMap<String,Object>();
		try{
			Trans.exec(new Atom() {
                @Override
                public void run() {
                  memberService.deleteMember(id);
                }
            });		
		}catch(Exception e){
			e.printStackTrace();
			map.put("state", "fail");
			map.put("message", "删除失败");
			return map;
		}
		map.put("state", "ok");
		return map;
		
	}
	
	@POST
	@At("/member/avatar/?")
	@AdaptBy(type = UploadAdaptor.class, args = {"ioc:myUpload"})
	public void upload(String id ,@Param("avatar") TempFile avatar,HttpServletResponse res ) throws IOException{
		PrintWriter out = res.getWriter();
        if (avatar == null || id == null || "".equals(id)) {

            out.write("<script> alert('fail')</script>");
            return;

        }
        File tempFile = avatar.getFile();
        File newFile = new File(Config.avatarPath + "/" + id +avatar.getMeta().getFileExtension());
        try {

            Files.deleteFile(newFile);
            Files.move(tempFile, newFile);
            ImageZip.zipImageFile(newFile.getAbsolutePath(), Config.avatarPath, "thumb_"+id+".jpg");

        } catch (IOException ex) {
            out.write("<script> alert('fail');</script>");
            return;
        }

        out.write("<script> alert('ok');</script>");
	}
	
	@GET
	@At("/member/avatar/?")
	public void avatar(String id,@Param("thumb") boolean thumb,HttpServletRequest req,HttpServletResponse res){
		PrintImage.writePhoto(Config.avatarPath, id, thumb, req, res);
	}
	
	@At("/members/state/?")
	@Ok("jsp:page.manage.member.list")
	public Map stateList(int state,int page){			
		Map<String,Object> map = new HashMap<String,Object>();	
		if(page<1)
			page=1;
		map.put("list", memberService.listByState(state, memberService.dao().createPager(page, Config.MANAGER_PAGE_SIZE)));	
		map.put("count", memberService.countByState(state));
	    map.put("size", Config.MANAGER_PAGE_SIZE);
	    map.put("page", page);
	    return map;
	}
	
	@At("/members/type/?")
	@Ok("jsp:page.manage.member.list")
	public Map typeList(int type,int page){
		Map<String,Object> map = new HashMap<String,Object>();
		if(page<1)
			page=1;
		map.put("list", memberService.listBytype(type, memberService.dao().createPager(page, Config.MANAGER_PAGE_SIZE)));	
		map.put("count", memberService.countByType(type));
	    map.put("size", Config.MANAGER_PAGE_SIZE);
	    map.put("page", page);
	    return map;
	}
	
	@At("/members/admin")
	@Ok("jsp:page.manage.member.list")
	public Map adminList(int page){
		Map<String,Object> map = new HashMap<String,Object>();	
		if(page<1)
			page=1;
		map.put("list", memberService.listAdmin( memberService.dao().createPager(page, Config.MANAGER_PAGE_SIZE)));	
		map.put("count", memberService.countByRole(Member.ROLE_ADMIN));
	    map.put("size", Config.MANAGER_PAGE_SIZE);
	    map.put("page", page);
	    return map;
	}
	

}
