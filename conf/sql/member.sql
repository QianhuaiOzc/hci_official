/* member.free */
select * from member as m where m.id not in (select pm.member_id from project_member as pm ,project as p where p.id= pm.project_id and p.state =1) and m.state=1 and m.type=3

/* member.free.count */
select count(m.id) from member as m where m.id not in (select pm.member_id from project_member as pm ,project as p where p.id= pm.project_id and p.state =1) and m.state=1 and m.type=3


/* member.department.state */
select * from member where id not in(select member_id from department_member where department_id = @departmentId ) and state = @state

/* member.department.state.count */
select count(id) from member where id not in(select member_id from department_member where department_id = @departmentId ) and state = @state

/* member.projects */
select * from project where id in (select pm.project_id from project_member as pm where pm.member_id= @memberId ) and state= @state

/* member.password.add */
INSERT INTO password (member_id, password) VALUES (@memberId , @password)

/* member.password.update */
update password set password = @password where member_id = @memberId 

/* member.password.get*/
select password from password where member_id = @memberId 

/* member.authentication */
select 