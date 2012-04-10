package org.scauhci.official.module;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.scauhci.official.service.ProjectService;
import org.scauhci.official.util.ImageZip;
import org.scauhci.official.util.PrintImage;
import org.scauhci.official.util.Utils;

@IocBean
public class ProjectModule {
	@Inject
	MemberService memberService;
	@Inject
	ProjectService projectService;
	
	@At("/project/new")
	@Ok("jsp:page.manage.project.add")
	public void toAdd(HttpServletRequest req){
		
	}
	
	@At("/project/edit/?")
	@Ok("jsp:page.manage.project.edit")
	public void toEidt(int id, HttpServletRequest req){
		
	}
	
	@POST
	@At("/project/?")
	@Ok("json")
	public Map eidt(int id ){
		Map<String,Object> map=new HashMap<String,Object>();
		
		return map;
		
	}
	
	@GET
	@At("/project/?")
	@Ok("json")
	public Map get(int id){
		Map<String,Object> map=new HashMap<String,Object>();
		
		return map;
	}
	
	@At("/project/delete/?")
	@Ok("json")
	public Map delete(final int id){
		Map<String,Object> map=new HashMap<String,Object>();
		
		return map;
		
	}
	
	@POST
	@At("/project/avatar/?")
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
	@At("/project/avatar/?")
	public void avatar(String id,@Param("thumb") boolean thumb,HttpServletRequest req,HttpServletResponse res){
		PrintImage.writePhoto(Config.avatarPath, id, thumb, req, res);
	}
	
	@At("/projects/state/?")
	@Ok("jsp:page.manage.project.list")
	public Map stateList(int state,int page){			
		Map<String,Object> map = new HashMap<String,Object>();	
		if(page<1)
			page=1;

	    return map;
	}
	

	@At("/project/members/?")
	public void memberList(int id){
		
	}
	
	@At("/project/member/?")
	public void editMember(){
		
	}
	
	@At("/project/member/remove/?")
	public void removeMember(){
		
	}
	
	
}
