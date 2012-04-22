function addLoadEvent(func){
	var oldonload=window.onload;
	if(typeof window.onload!='function')
	{
		window.onload=func;
	}
	else
	{
		window.onload=function(){
			oldonload();
			func();
		}
	}
}
function showFlower(){
		var left_nav=document.getElementById("left_nav");
		var liList=left_nav.getElementsByTagName("li");
		var i=0;
		for(i=0;i<liList.length;i++)
		{
			liList[i].onmouseover=function(){
				this.lastChild.style.display="inline";
			};
			liList[i].onmouseout=function(){
				this.lastChild.style.display="none";
			};
		}
	}
addLoadEvent(showFlower);