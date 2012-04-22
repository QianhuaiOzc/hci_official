// JavaScript Document
window.onload=function(){
  var ele=document.getElementById("middle");
  var w=ele.clientWidth;/*获得客户区域(浏览器窗口,不包括菜单栏和状态栏,就是内容窗口)的宽度*/
  var n=20,t=20;
  var timers=new Array(n);
  var c=document.getElementById("navigation").getElementsByTagName("li");
  for(var i=0;i<c.length;i++){
    c[i].index=i;
    c[i].onmouseover=doSlide;
  }
  c=null;
  function doSlide(){
    var x=ele.scrollLeft;
    var d=this.index*w-x;
    if(!d) return;
    for(var i=0;i<n;i++)(function(){
      if(timers[i])
        clearTimeout(timers[i]);
      var j=i;
      timers[i]=setTimeout(function(){
        ele.scrollLeft=x+Math.round(d*Math.sin(Math.PI*(j+1)/(2*n)));
      },(i+1)*t);
    })();
  }
}


		 function func1(){
			 	var source="images/water2.jpg";
	var placeholder=document.getElementById("placeholder");
	placeholder.setAttribute("src",source);
		 }
		  function func2(){
			 	var source="images/water1.jpg";
	var placeholder=document.getElementById("placeholder");
	placeholder.setAttribute("src",source);
		 }
		  function func3(){
			 	var source="images/book2.jpg";
	var placeholder=document.getElementById("placeholder2");
	placeholder.setAttribute("src",source);
		 }
		  function func4(){
			 	var source="images/book1.jpg";
	var placeholder=document.getElementById("placeholder2");
	placeholder.setAttribute("src",source);
		 }
		