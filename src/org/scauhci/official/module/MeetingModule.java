package org.scauhci.official.module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.GET;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.POST;
import org.nutz.mvc.annotation.Param;
import org.scauhci.official.bean.Meeting;
import org.scauhci.official.bean.Member;
import org.scauhci.official.bean.Message;
import org.scauhci.official.bean.Project;
import org.scauhci.official.service.MeetingService;
import org.scauhci.official.service.MemberService;
import org.scauhci.official.service.MessageService;
import org.scauhci.official.service.ProjectService;

@At("/meeting")
@IocBean
@Fail("json")
public class MeetingModule {

	@Inject
	private MeetingService meetingService;
	@Inject
	private ProjectService projectService;
	@Inject
	private MemberService memberService;
	@Inject
	private MessageService messageService;

	@At("/new")
	@POST
	@Ok("jsp:page.manage.meeting.new_meeting_add_projects")
	public Map<String, Object> addAMeeting(@Param("..") Meeting meeting,
			HttpSession session) {
		if (session.getAttribute("newMeeting") == null) {
			session.setAttribute("meeting", meeting);
		}
		System.out.println(meeting);
		List<Project> freeProjects = projectService.listByState(
				Project.STATE_DEVELOPING, null);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("projects", freeProjects);
		return resultMap;
	}

	@At("/new/projects")
	@POST
	@Ok("jsp:page.manage.meeting.new_meeting_add_members")
	public Map<String, Object> addProjectsToNewMeeting(
			@Param("projectsId") int[] projectsId, HttpSession session) {
		if (projectsId != null && projectsId.length != 0) {
			session.setAttribute("newMeetingProjectsId", projectsId);
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Member> members = memberService.listByState(
				Member.STATE_ON_THE_JOB, null);
		resultMap.put("members", members);
		return resultMap;
	}

	@At("/new/members")
	@POST
	@Ok("redirect:/meeting/list")
	@Aop("transactionInterceptor")
	public Map<String, Object> addMembersToNewMeeting(
			@Param("membersId") int[] membersId, HttpSession session) {
		Meeting newMeeting = (Meeting) session.getAttribute("meeting");
		meetingService.add(newMeeting);
		int[] projectsId = (int[]) session.getAttribute("newMeetingProjectsId");
		if (projectsId != null && projectsId.length != 0) {
			meetingService.addMeetingProjects(newMeeting.getId(), projectsId);
		}
		if(membersId != null && membersId.length != 0) {
			meetingService.addMeetingMembers(newMeeting.getId(), membersId);
		}
		messageService.createMessage(Message.TYPE_MEETING_NOTICE, "");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		return resultMap;
	}

	@At("/list")
	@Ok("jsp:page.manage.meeting.meeting_list")
	public Map<String, Object> getMeetings() {
		List<Meeting> meetings = meetingService.query(null, null);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("meetings", meetings);
		return resultMap;
	}

	@At("/new")
	@GET
	@Ok("jsp:page.manage.meeting.new_meeting_step1")
	public void requestToAddMeeting() {
	}

}