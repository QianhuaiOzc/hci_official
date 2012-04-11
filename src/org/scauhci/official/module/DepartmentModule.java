package org.scauhci.official.module;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.jndi.java.javaNameParser;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.GET;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.POST;
import org.nutz.mvc.annotation.Param;
import org.nutz.trans.Atom;
import org.nutz.trans.Trans;
import org.scauhci.official.Config;
import org.scauhci.official.bean.Department;
import org.scauhci.official.bean.Member;
import org.scauhci.official.bean.Project;
import org.scauhci.official.bean.ProjectMember;
import org.scauhci.official.service.DepartmentService;
import org.scauhci.official.service.MemberService;
import org.scauhci.official.service.ProjectService;
import org.scauhci.official.util.Utils;

@IocBean
public class DepartmentModule {
	
	@Inject
	MemberService memberService;
	@Inject
	ProjectService projectService;
	@Inject
	DepartmentService departmentService;
	
	@At("/department/new")
	@Ok("jsp:page.manage.department.add")
	public void toAdd(HttpServletRequest req){
		
	}
	
	@At("/department/edit/?")
	@Ok("jsp:page.manage.department.edit")
	public void toEidt(int id, HttpServletRequest req){
		Department d=departmentService.fetch(id);
		req.setAttribute("department", d);
	}
	
	@POST
	@At("/department/?")
	@Ok("json")
	public Map eidt(int id,@Param("::department.") final Department department){
		Map<String,Object> map=new HashMap<String,Object>();
		try{
		if(id==0){
			 Trans.exec(new Atom() {
                 @Override
                 public void run() {
                	departmentService.add(department);
                 }
             });		
		}else{			
			 Trans.exec(new Atom() {
                 @Override
                 public void run() {
                	departmentService.update(department);
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
	@At("/department/?")
	@Ok("json")
	public Map get(int id){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("department", departmentService.fetch(id));
		return map;
	}
	
	@At("/departments")
	@Ok("jsp:page.manage.department.list")
	public Map list(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("list", departmentService.getAll());
		return map;
	}
	
	@At("/department/members/?")
	public Map memberList(int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list",departmentService.membersByState(id, Member.STATE_ON_THE_JOB));
		return map;
	}

	@POST
	@At("/department/member/?")
	public Map editMember(int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (id == 0) {
				Trans.exec(new Atom() {
					@Override
					public void run() {
						
					}
				});
			} else {
				Trans.exec(new Atom() {
					@Override
					public void run() {
						
					}
				});
			}
		} catch (Exception e) {

		}

		return map;
	}

	@At("/department/member/remove/?")
	public Map removeMember(final int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Trans.exec(new Atom() {
				@Override
				public void run() {
					
				}
			});
		} catch (Exception e) {

		}

		return map;
	}
	
}
