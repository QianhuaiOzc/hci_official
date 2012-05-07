/* message.queryForNewMessage */
SELECT COUNT(mm.id) FROM member m, message me, member_message mm WHERE m.id=mm.member_id AND me.id=mm.message_id AND m.student_id=@studentId AND mm.state=0