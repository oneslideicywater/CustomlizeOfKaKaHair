// 全局变量
var id = 5 //

var gender = 0 //性别
var age = 30 //年龄
var stature = 1.70 //身高
var weight =60 //体重
var complexion = 2 //肤色
var somatotype = 2//体型
var feature = 1 //脸型
var HairOilness=1;
var HairToughness=1
var HairVolume = 3 //发量

var style = 0

//性别
$(document).ready(function() {
	$("#xb").click(function() {
		$(".xb").css("display", "block");
	});
	$(".xb .col-md-6").click(function() {
		var index = $(".xb .col-md-6").index(this);
		gender = index
	});
	$(".xb").click(function() {
		$(".xb").css("display", "none");
		console.log("gender:" + gender)
	});
});
//年龄
$(document).ready(function() {
	$("#nl").click(function() {
		$(".nl").css("display", "block");
	});
	$(".nl button").click(function() {
		$(".nl").css("display", "none");
		if($(".nl input").val().length != 0) {
			age = parseInt($(".nl input").val())
		}
		console.log("age:" + age)
	});
});
//身高体重
$(document).ready(function() {
	$("#sgtz").click(function() {
		$(".sgtz").css("display", "block");
	});
	$(".sgtz button").click(function() {
		$(".sgtz").css("display", "none");
		var inp = document.getElementsByClassName("sgtz")[0].getElementsByTagName("input")
		if($(".sgtz input").val().length != 0 && $(".sgtz input").val().length != 0) {
			stature = parseInt(inp[0].value)
			weight = parseInt(inp[1].value)
		} else {
			return false
		}
		console.log("stature:" + stature + "weight:" + weight)
	});
});
//选择肤色
$(document).ready(function() {
	$("#fs").click(function() {
		if(gender == 1) {
			$(".fsnv").css("display", "block");
			$(".fsnv .col-md-6").click(function() {
				var index = $(".fsnv .col-md-6").index(this);
				complexion = index
			});
			$(".fsnv").click(function() {
				$(".fsnv").css("display", "none");
				console.log("complexion:" + complexion)
			});
		} else {
			$(".fsnan").css("display", "block");
			$(".fsnan .col-md-6").click(function() {
				var index = $(".fsnan .col-md-6").index(this);
				complexion = index
			});
			$(".fsnan").click(function() {
				$(".fsnan").css("display", "none");
				console.log("complexion:" + complexion)
			});
		}
	});
});
//体型
$(document).ready(function() {
	$("#tx").click(function() {
		$(".tx").css("display", "block");
	});
	$(".tx .col-md-4").click(function() {
		var index = $(".tx .col-md-4").index(this);
		somatotype = index
	});
	$(".tx").click(function() {
		$(".tx").css("display", "none");
		console.log("somatotype:" + somatotype)
	});
});
//脸型
$(document).ready(function() {
	$("#lx").click(function() {
		$(".lx").css("display", "block");
	});
	$(".lx .col-md-4").click(function() {
		var index = $(".lx .col-md-4").index(this);
		feature = index
	});
	$(".lx").click(function() {
		$(".lx").css("display", "none");
		console.log("feature:" + feature)
	});
});
//发质
$(document).ready(function() {
	$("#fz").click(function() {
		$(".fz").css("display", "block");
	});
	$(".fz .col-md-4").click(function() {
		var index = $(".fz .col-md-4").index(this);
		hairQuality = index
	});
	$(".fz").click(function() {
		$(".fz").css("display", "none");
		console.log("quality:" + hairQuality)
	});
});
//发量
$(document).ready(function() {
	$("#fl").click(function() {
		$(".fl").css("display", "block");
	});
	$(".fl .col-md-4").click(function() {
		var index = $(".fl .col-md-4").index(this);
		hairVolume = index
	});
	$(".fl").click(function() {
		$(".fl").css("display", "none");
		console.log("quantity:" + hairVolume)
	});
});
//风格样式
$(document).ready(function() {
	$("#style button").click(function() {
		$("#style button").css("border", "none")
		$(this).css("border", "1px solid #000");
		var index = $("#style button").index(this);

		style = index
		console.log("style:" + style)
	});

});
//input获得焦点内容清空
$(document).ready(function() {
	$("input").focus(function() {
		$(this).val("");
	});
});
var data = {}
$(document).ready(function() {
	$("#submit").click(function() {
		data = {
			"id":id,
			
			"gender": gender,
			"age": age,
			"stature": stature,
			"weight": weight,
			"complexion": complexion,
			"somatotype": somatotype,
			"feature": feature,
			"HairOilness":HairOilness,
			"HairToughness":HairToughness,
			"HairVolume": HairVolume,
			//"style": style
		}
		var postArray = new Array();
		postArray.push(data);
		$.ajax({
			url: "/customer/"+id+"/report",
			type: 'post',
			data: {
				data: JSON.stringify(postArray)
			},
			success: function(data) {
				console.log(data);
			}
		});
	});

});

function requset(str) {
	var xmlhttp;
	if(window.XMLHttpRequest) {
		// IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xmlhttp = new XMLHttpRequest();
	} else {
		// IE6, IE5 浏览器执行代码
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("txtHint").innerHTML = xmlhttp.responseText;
		}
	}
	xmlhttp.open("GET", "localhost:8080/customer/"+id+"/report", true);
	xmlhttp.send();
}