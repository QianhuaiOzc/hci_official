/* member.free */
select * from member as m where m.id not in (select pm.member_id from project_member as pm ,project as p where p.id= pm.project_id and p.state =1) and m.state=1