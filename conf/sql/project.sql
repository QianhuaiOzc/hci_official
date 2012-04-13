/* project.free */
select * from project as p where p.id not in (select pm.project_id from project_member as pm ,member as m where m.id= pm.member_id and m.state =1) and p.state=1

/* project.free.count */
select count(p.id) from project as p where p.id not in (select pm.project_id from project_member as pm ,member as m where m.id= pm.member_id and m.state =1) and p.state=1

/* project.list.by.member */
select * from project where id in (select pm.project_id from project_member as pm where pm.member_id= @memberId ) and state= @state