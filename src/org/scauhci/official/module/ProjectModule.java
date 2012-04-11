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
import org.scauhci.official.bean.Project;
import org.scauhci.official.bean.ProjectMember;
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
	public void toAdd(HttpServletRequest req) {

	}

	@At("/project/edit/?")
	@Ok("jsp:page.manage.project.edit")
	public void toEidt(int id, HttpServletRequest req) {
		Project p = projectService.fetch(id);
		req.setAttribute("project", p);
	}

	@POST
	@At("/project/?")
	@Ok("json")
	public Map eidt(final int id, @Param("::project.") final Project project) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (id == 0) {
				Trans.exec(new Atom() {
					@Override
					public void run() {
						project.setState(Project.STATE_DEVELOPING);
						project.setStateDate(new java.sql.Date(
								new java.util.Date().getTime()));
						projectService.add(project);
					}
				});
			} else {
				Trans.exec(new Atom() {
					@Override
					public void run() {
						Project p = projectService.fetch(id);
						project.setState(p.getState());
						project.setStateDate(p.getStateDate());
						project.setEndDate(p.getEndDate());
						project.setIsPublic(p.getIsPublic());
						projectService.update(project);
					}
				});
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
	@At("/project/?")
	@Ok("json")
	public Map get(int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		Project p = projectService.fetch(id);
		map.put("project", p);
		return map;
	}

	@At("/project/delete")
	@Ok("json")
	public Map delete(@Param("id") final int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Trans.exec(new Atom() {
				@Override
				public void run() {
					Project p = projectService.fetch(id);
					p.setState(Project.STATE_FAIL);
					p.setStateDate(new java.sql.Date(new java.util.Date()
							.getTime()));
					projectService.update(p);
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
			map.put("state", "fail");
			map.put("message", "操作失败");
			return map;
		}
		map.put("state", "ok");
		return map;
	}
	
	@At("/project/finish")
	@Ok("json")
	public Map finish(@Param("id") final int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Trans.exec(new Atom() {
				@Override
				public void run() {
					Project p = projectService.fetch(id);
					p.setState(Project.STATE_FINISHED);
					p.setStateDate(new java.sql.Date(new java.util.Date()
							.getTime()));
					projectService.update(p);
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
			map.put("state", "fail");
			map.put("message", "操作失败");
			return map;
		}
		map.put("state", "ok");
		return map;
	}
	
	@POST
	@At("/project/avatar/?")
	@AdaptBy(type = UploadAdaptor.class, args = { "ioc:myUpload" })
	public void upload(String id, @Param("avatar") TempFile avatar,
			HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		if (avatar == null || id == null || "".equals(id)) {

			out.write("<script> alert('fail')</script>");
			return;

		}
		File tempFile = avatar.getFile();
		File newFile = new File(Config.projectImagePath + "/" + id
				+ avatar.getMeta().getFileExtension());
		try {

			Files.deleteFile(newFile);
			Files.move(tempFile, newFile);
			ImageZip.zipImageFile(newFile.getAbsolutePath(),
					Config.projectImagePath, "thumb_" + id + ".jpg");

		} catch (IOException ex) {
			out.write("<script> alert('fail');</script>");
			return;
		}

		out.write("<script> alert('ok');</script>");
	}

	@GET
	@At("/project/avatar/?")
	public void avatar(String id, @Param("thumb") boolean thumb,
			HttpServletRequest req, HttpServletResponse res) {
		PrintImage.writePhoto(Config.projectImagePath, id, thumb,Config.defaultProjectImage, req, res);
	}

	@At("/projects/state/?")
	@Ok("jsp:page.manage.project.list")
	public Map stateList(int state, int page) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (page < 1)
			page = 1;
		map.put("list", projectService.listByState(state, memberService.dao()
				.createPager(page, Config.MANAGER_PAGE_SIZE)));
		map.put("count", projectService.countByState(state));
		map.put("size", Config.MANAGER_PAGE_SIZE);
		map.put("page", page);
		return map;
	}

	@At("/project/members/?")
	public Map memberList(int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list",projectService.projectMembers(id) );
		return map;
	}

	@POST
	@At("/project/member/?")
	public Map editMember(int id, @Param("::pm.") final ProjectMember pm) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (id == 0) {
				Trans.exec(new Atom() {
					@Override
					public void run() {
						projectService.addProjectMember(pm);
					}
				});
			} else {
				Trans.exec(new Atom() {
					@Override
					public void run() {
						projectService.updateProjectMember(pm);
					}
				});
			}
		} catch (Exception e) {

		}

		return map;
	}

	@At("/project/member/remove/?")
	public Map removeMember(final int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Trans.exec(new Atom() {
				@Override
				public void run() {
					projectService.removeProjectMember(id);
				}
			});
		} catch (Exception e) {

		}

		return map;
	}

}
