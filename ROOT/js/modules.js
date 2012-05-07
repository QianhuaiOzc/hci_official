/**
 * 
 */
Core.registerModule("topBar", function(sandBox) {
	
	var container = null;
	var loginForm = null, welcomeDiv = null;
	var accountDiv = null, passwordDiv = null, loginBtn = null, nameDiv = null, logoutBtn = null;
	var cookie = null;
	
	var showLoginForm = function() {
		sandBox.hide(welcomeDiv);
		sandBox.show(loginForm);
	};
	
	var showInfoDiv = function() {
		sandBox.hide(loginForm);
		sandBox.show(welcomeDiv);
		nameDiv.innerText = cookie.name;
	};
	
	var events = {
		login: function(evt) {
			var account = accountDiv.value;
			var password = sandBox.md5(passwordDiv.value);
			sandBox.post("login.nut", {"username": account, "password": password, }, 
					function(data) {
						var state = data.state;
						if (state === 200) {
							cookie = data.member;
							sandBox.setItem("cookie", JSON.stringify(data.member));
							showInfoDiv();
						} else {
							alert("Error, " + JSON.stringify(data));
						}
					},
					function(jqXHR) {
						alert("Error, " + JSON.stringify(data));
					}
			);
		},
		
		logout: function(evt) {
			showLoginForm();
			sandBox.removeItem("cookie");
			cookie = null;
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
			logoutBtn = sandBox.find("#logout", welcomeDiv);
			loginBtn.onclick = events.login;
			logoutBtn.onclick = events.logout;
			
			var cookieStr = sandBox.getItem("cookie");
			if(cookieStr) {
				cookie = JSON.parse(cookieStr);
				showInfoDiv();
			}
		},
		destroy: function() {
			cookie = null;
		}
	};
});

Core.startAll();