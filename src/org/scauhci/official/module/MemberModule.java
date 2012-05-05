package org.scauhci.official.module;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nutz.dao.Cnd;
import org.nutz.ioc.aop.Aop;
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
import org.scauhci.official.Config;
import org.scauhci.official.bean.DepartmentMember;
import org.scauhci.official.bean.Member;
import org.scauhci.official.bean.MemberExtend;
import org.scauhci.official.bean.Project;
import org.scauhci.official.lucene.MemberLucene;
import org.scauhci.official.service.DepartmentService;
import org.scauhci.official.service.MemberService;
import org.scauhci.official.util.GetInfoUtil;
import org.scauhci.official.util.ImageZip;
import org.scauhci.official.util.PrintImage;
import org.scauhci.official.util.Utils;

@IocBean
public class MemberModule {

	@Inject
	MemberService memberService;
	@Inject
	DepartmentService departmentService;

//	MemberLucene memberLucene=MemberLucene.getInstance();

	@At("/member/new")
	@Ok("jsp:page.manage.member.add")
	public void toAdd(HttpServletRequest req) {
		req.setAttribute("departmentList", departmentService.getAll());
	}

	@At("/member/edit/?")
	@Ok("jsp:page.manage.member.edit")
	public void toEdit(int id, HttpServletRequest req) {
		Member member = memberService.getMember(id);
		MemberExtend me = member.getExtend();
		DepartmentMember dm = departmentService.getDepartmentMember(member.getId());
		req.setAttribute("member", member);
		req.setAttribute("extend", me);
		req.setAttribute("departmentList", departmentService.getAll());
		req.setAttribute("departmentMember", dm);
	}

	@POST
	@At("/member/?")
	@Ok("json")
	@Aop("transactionInterceptor")
	public Map<String, Object> edit(int id, @Param("::member.") final Member member,
			@Param("::extend.") final MemberExtend me,
			@Param("::departmentMember.") final DepartmentMember dm,
			HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
			
			if (id == 0) {

				member.setExtend(me);
				memberService.insertMember(member);
				dm.setMemberId(member.getId());
				departmentService.addMember(dm);
				memberService.addPassword(member.getId(),Utils.getMD5(Config.INIT_PASSWORD));

			} else {

				member.setExtend(me);
				member.setExtendId(me.getId());
				dm.setMemberId(member.getId());
				departmentService.updateMember(dm);
				memberService.updateAll(member);

			}
		} catch (Exception e) {
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
	public Map<String, Object> get(int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		Member m = memberService.getMember(id);
		map.put("member", m);
		map.put("extend", m.getExtend());
		return map;
	}

	@At("/member/delete/?")
	@Ok("json")
	public Map<String, Object> delete(final int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			Member m = memberService.fetch(id);
			m.setState(Member.STATE_LEAVE);
			memberService.update(m);

		} catch (Exception e) {
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
	@AdaptBy(type = UploadAdaptor.class, args = { "ioc:myUpload" })
	public void upload(String id, @Param("avatar") TempFile avatar,
			HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		if (avatar == null || id == null || "".equals(id)) {

			out.write("<script> alert('fail')</script>");
			return;

		}
		File tempFile = avatar.getFile();
		File newFile = new File(Config.avatarPath + "/" + id
				+ avatar.getMeta().getFileExtension());
		try {

			Files.deleteFile(newFile);
			Files.move(tempFile, newFile);
			ImageZip.zipImageFile(newFile.getAbsolutePath(), Config.avatarPath,
					"thumb_" + id + ".jpg");

		} catch (IOException ex) {
			out.write("<script> alert('fail');</script>");
			return;
		}

		out.write("<script> alert('ok');</script>");
	}

	@GET
	@At("/member/avatar/?")
	public void avatar(String id, @Param("thumb") boolean thumb,
			HttpServletRequest req, HttpServletResponse res) {
		PrintImage.writePhoto(Config.avatarPath, id, thumb,
				Config.defaultAvatar, req, res);
	}

	@At("/members/state/?")
	@Ok("jsp:page.manage.member.list")
	public Map<String, Object> stateList(int state, @Param("page") int page) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (page < 1)
			page = 1;
		map.put("list", memberService.listByState(state, memberService.dao().createPager(page, Config.MANAGER_PAGE_SIZE)));
		map.put("count", memberService.countByState(state));
		map.put("size", Config.MANAGER_PAGE_SIZE);
		map.put("page", page);
		return map;
	}

	@At("/members/type/?")
	@Ok("jsp:page.manage.member.list")
	public Map<String, Object> typeList(int type, @Param("page") int page) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (page < 1)
			page = 1;
		map.put("list",
				memberService.listByType(
						type,
						memberService.dao().createPager(page,
								Config.MANAGER_PAGE_SIZE)));
		map.put("count", memberService.countByType(type));
		map.put("size", Config.MANAGER_PAGE_SIZE);
		map.put("page", page);
		return map;
	}

	@At("/members/admin")
	@Ok("jsp:page.manage.member.list")
	public Map<String, Object> adminList(@Param("page") int page) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (page < 1)
			page = 1;
		map.put("list",
				memberService.listAdmin(memberService.dao().createPager(page,
						Config.MANAGER_PAGE_SIZE)));
		map.put("count", memberService.countByRole(Member.ROLE_ADMIN));
		map.put("size", Config.MANAGER_PAGE_SIZE);
		map.put("page", page);
		return map;
	}

	@At("/members/free")
	@Ok("jsp:page.manage.member.list")
	public Map<String, Object> freeList(@Param("page") int page) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (page < 1)
			page = 1;
		map.put("list",
				memberService.listByFree(memberService.dao().createPager(page,
						Config.MANAGER_PAGE_SIZE)));
		map.put("count", memberService.countByFree());
		map.put("size", Config.MANAGER_PAGE_SIZE);
		map.put("page", page);
		return map;
	}

	@At("/member/projects/?")
	@Ok("jsp:page.manage.member.projects")
	public Map<String, Object> projectList(int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("finishedList",
				memberService.project(id, Project.STATE_FINISHED));
		map.put("developingList",
				memberService.project(id, Project.STATE_DEVELOPING));
		return map;
	}

	@POST
	@At("/member/password")
	public Map<String, Object> updatePassword(@Param("id") int id,@Param("password") String password){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			memberService.addPassword(id,password);
		}catch(Exception e){
			e.printStackTrace();
			map.put("state", "fail");
			map.put("message", "更新密码失败");
			return map;
		}
		map.put("state", "ok");
		return map;
	}
	
	@GET
	@At("/member/password")
	@Ok("json")
	public Map<String, Object> resetPassword(@Param("id") int id){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			memberService.addPassword(id,Utils.getMD5(Config.INIT_PASSWORD));
		}catch(Exception e){
			e.printStackTrace();
			map.put("state", "fail");
			map.put("message", "重置密码失败");
			return map;
		}
		map.put("state", "ok");
		return map;
	}
	
	@At("/login")
	@Ok("json")
	public Map<String, Object> login(@Param("username") String account, @Param("password") String password, HttpSession session) {
		Map<String, Object> result = new HashMap<String, Object>();
		System.out.println("account: " + account + "\npassword: " + password);
		Member member = memberService.authentication(account, password);
		System.out.println(member);
		if(member == null) {
			result.put("state", 300);
		} else {
			session.setAttribute("member", member);
			result.put("state", 200);
			result.put("member", member);
		}
		return result;
	}

	@At("/member/checkout/?")
	@Ok("json")
	public Member checkout(@Param("id") String id){
		return GetInfoUtil.getMember(id);
	}

	@At("/member/search/")
	@Ok("jsp:page.manage.member.list")
	public Map<String, Object> search(@Param("wd") String s, @Param("page") int page){
		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("list", memberLucene.searchIndex(s,memberService.dao().createPager(page,Config.MANAGER_PAGE_SIZE)));
//		map.put("count", memberLucene.countSearchIndex(s));
		map.put("size", Config.MANAGER_PAGE_SIZE);
		map.put("page", page);
		return map;
	}
	
	
}
