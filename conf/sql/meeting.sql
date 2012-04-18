/* meeting.addMeetingMembers */
INSERT INTO attendance (meeting_id, member_id, state) VALUES (@meetingId, @memberId, 0)

/* meeting.addMeetingProjects */
INSERT INTO report (meeting_id, project_id) VALUES (@meetingId, @projectId)