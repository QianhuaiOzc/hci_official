package org.scauhci.official.service;

import org.nutz.dao.Dao;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.loader.annotation.IocBean;
import org.scauhci.official.bean.Meeting;

@IocBean(args = {"refer:dao"})
public class MeetingService extends BasicMysqlService<Meeting>{

	public MeetingService(Dao dao) {
		super(dao);
	}
	
	public void addMeetingProjects(int meetingId, int[] projectsId) {
		Sql sql = dao().sqls().create("meeting.addMeetingProjects");
		for (int projectId : projectsId) {
			sql.params().set("meetingId", meetingId).set("projectId", projectId);
			sql.addBatch();
		}
		dao().execute(sql);
	}
	
	public void addMeetingMembers(int meetingId, int[] membersId) {
		Sql sql = dao().sqls().create("meeting.addMeetingMembers");
		for (int memberId : membersId) {
			sql.params().set("meetingId", meetingId).set("memberId", memberId);
			sql.addBatch();
		}
		dao().execute(sql);
	}

}
