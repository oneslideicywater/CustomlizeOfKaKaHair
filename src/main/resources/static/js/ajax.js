// 全局变量
   var gender = 0
   var stature = 0
   var weight = 0
   var complexion = 0
   var somatotype = 0
   var feature = 0
   var styleId = 0
   var styleDescription = 0

var it_bot2 = document.getElementsByClassName('it_bot2')[0]
var all1 = document.getElementsByClassName('all1')

var it_bot21 = document.getElementsByClassName('it_bot2')[1]
var all2 = document.getElementsByClassName('all2')

it_bot2.onclick = function (){
	all1[0].style.display = "block"
}
all1[0].onclick = function (){
	all1[0].style.display = "none"
}

it_bot21.onclick = function (){
	all2[0].style.display = "block"
}
all2[0].onclick = function (){
	all2[0].style.display = "none"
}

function events(x,y){
for(var i = 0; i<x.length; i++){
        x[i].onclick = function(n){
    　　　　return function(){
                y = n;
                console.log(y)
            }
    　　}(i)
    }
}
//皮肤
var se_item1 = document.getElementsByClassName('se_item1')
events(se_item1,complexion)

//体型
var se_img = document.getElementsByClassName('se_img')
events(se_img,somatotype)



function requset(str)
{
  var xmlhttp;    
  if (window.XMLHttpRequest)
  {
    // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
    xmlhttp=new XMLHttpRequest();
  }
  else
  {
    // IE6, IE5 浏览器执行代码
    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
  xmlhttp.onreadystatechange=function()
  {
    if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
      document.getElementById("txtHint").innerHTML=xmlhttp.responseText;
    }
  }
  xmlhttp.open("GET","/try/ajax/getcustomer.php?q="+str,true);//连接需要修改
  xmlhttp.send();
}
