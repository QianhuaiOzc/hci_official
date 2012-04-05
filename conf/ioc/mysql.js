var ioc = {
	dataSource : {
		type : "org.apache.commons.dbcp.BasicDataSource",
		events : {
			depose : 'close'
		},
		fields : {
			driverClassName : 'com.mysql.jdbc.Driver',
			url : 'jdbc:mysql://localhost:3306/official?characterEncoding=UTF-8',
			username : 'root',
			password : '12345'
		}
	},
	dao: {
		type: "org.nutz.dao.impl.NutDao",
		args: [{
			refer: "dataSource"
		}]
	}
}