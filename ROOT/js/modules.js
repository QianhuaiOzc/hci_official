/**
 * 
 */
Core.registerModule("topBar", function(sandBox) {
	
	var container = null;
	var loginForm = null, welcomeDiv = null;
	var accountDiv = null, passwordDiv = null, loginBtn = null;
	
	var events = {
		login: function(evt) {
			var account = accountDiv.value;
			var password = sandBox.md5(passwordDiv.value);
			sandBox.ajax({
				url : "login.nut",
				type : "post",
				dataType : "json",
				data : {
					"username" : account,
					"password" : password
				},
				success : function(data) {
					console.log(JSON.stringify(data));
					var state = data.state;
					if (state === 200) {
					} else {

					}
				},
				error : function(jqXHR) {

				}
			});
//			console.log("account: " + account + " password: " + password + " md5: " + sandBox.md5(password));
		}
	};
	
	return {
		init: function() {
			container = sandBox.container;
			sandBox.show(container);
			loginForm = sandBox.find("#loginForm", container);
			welcomeDiv = sandBox.find("#welcome", container);
			accountDiv = sandBox.find("#account", loginForm);
			passwordDiv = sandBox.find("#password", loginForm);
			loginBtn = sandBox.find("#loginBtn", loginForm);
			loginBtn.onclick = events.login;
		},
		destroy: function() {}
	};
});

Core.startAll();