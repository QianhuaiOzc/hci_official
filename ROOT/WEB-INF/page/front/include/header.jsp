<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>HCI Meeting-Home</title>
<link href="css/index.css" type="text/css" rel="stylesheet" />
<link rel="Shortcut Icon" href="images/avicon.png" type="image/x-icon" />
</head>
<body>
	<div id="container">
		<div id="topBar" class="topBackground">
			<div class="forSearch">
				<div id="loginForm" class="search">
					<input id="account" class="inputCss" type="text" /> 
					<input id="password" class="inputCss" type="password" /> 
					<input type="button" id="loginBtn" />
				</div>
				<div id="welcome" class="loginIn" style="display: none;">
					<p>
						欢迎您！<span id="name"></span>|<a href="javascript:void(0);" id="message">消息</a>|<a href="#">相册</a>|<a
									href="#">个人中心</a>|<a href="javascript:void(0);" id="logout">注销</a>
					</p>
				</div>
			</div>
		</div>
		<div id="top2">
			<div id="topcontent">
				<div id="logo">
					<img src="images\logo.png" alt="logo" />
				</div>
				<div id="title">
					<img src="images\HCI-SCAU.png" alt="hci" />
				</div>

				<div id="navigation">
					<ul class="nav">
						<li class="thread"><a href="#">Home</a></li>
						<li class="thread"><a href="#">About</a></li>
						<li class="thread"><a href="#">Members</a></li>
						<li><a href="#">Projects</a></li>
					</ul>

				</div>
			</div>
		</div>