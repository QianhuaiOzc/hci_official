package org.scauhci.official.module;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.scauhci.official.service.DepartmentService;
import org.scauhci.official.service.MemberService;
import org.scauhci.official.service.ProjectService;

@IocBean
public class DepartmentModule {
	
	@Inject
	MemberService memberService;
	@Inject
	ProjectService projectService;
	@Inject
	DepartmentService departmentService;
	
}
