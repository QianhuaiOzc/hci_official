/**
 * 
 */
Core.registerModule("topBar", function(sandBox) {
	
	var container = null;
	var loginForm = null, welcomeDiv = null;
	var accountDiv = null, passwordDiv = null, loginBtn = null, nameDiv = null;
	var cookie = null;
	
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
						sandBox.hide(loginForm);
						sandBox.show(welcomeDiv);
						cookie = data.member;
						sandBox.setItem("cookie", JSON.stringify(data.member));
						nameDiv.innerText = data.member.name;
					} else {
					}
				},
				error : function(jqXHR) {

				}
			});
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
			nameDiv = sandBox.find("#name", welcomeDiv);
			loginBtn.onclick = events.login;
			
			var cookieStr = sandBox.getItem("cookie");
			if(cookieStr) {
				cookie = JSON.parse(cookieStr);
				sandBox.hide(loginForm);
				sandBox.show(welcomeDiv);
				nameDiv.innerText = cookie.name;
			}
		},
		destroy: function() {}
	};
});

Core.startAll();