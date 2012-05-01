$(function(){
	$("#left_nav ul li a").bind("mouseover", function(){
			$(this).next().show();
		});
	$("#left_nav ul li a").bind("mouseout",function(){
			$(this).next().hide();
		})
})