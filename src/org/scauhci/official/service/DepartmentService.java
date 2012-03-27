package org.scauhci.official.service;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.scauhci.official.dao.DepartmentDao;
import org.scauhci.official.dao.MemberDao;
import org.scauhci.official.dao.ProjectDao;

@IocBean
public class DepartmentService {
	@Inject
	MemberDao memberDao;
	@Inject
	ProjectDao projectDao;
	@Inject
	DepartmentDao departmentDao;
}
