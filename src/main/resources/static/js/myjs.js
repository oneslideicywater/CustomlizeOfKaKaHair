// 全局变量
var gender = 0 //性别
var age = 20 //年龄
var stature = 0 //身高
var weight = 0 //体重
var complexion = 1 //肤色
var somatotype = 1 //体型
var feature = 1 //脸型
var HairOilness = 1 //发质油性
var HairToughness = 1 //软硬程度
var HairVolume = 1 //发量
var FavorStyle = [] //风格

//性别
$(document).ready(function() {
	var imgs = document.getElementById("style").getElementsByTagName("img")
	var img = document.getElementById("fs")
	$("#xb").click(function() {
		$(".xb").css("display", "block");
	});
	$(".xb .col-md-6").click(function() {
		var index = $(".xb .col-md-6").index(this);
		gender = index + 1
		if(index == 0) {
			$("#xb").text("性别：男")
			imgs[0].src = "img/风格/fg_1.png"
			imgs[1].src = "img/风格/fg_2.png"
			imgs[2].src = "img/风格/fg_3.png"
			imgs[3].src = "img/风格/fg_4.png"
			imgs[4].src = "img/风格/fg_5.png"
			imgs[5].src = "img/风格/fg_6.png"
			img.innerHTML = "<img class='img' src='img/2_03.jpg'/>"
			$("#fs").css("padding", "0")

		} else {
			$("#xb").text("性别：女")
			imgs[0].src = "img/风格/fgnv1.png"
			imgs[1].src = "img/风格/fgnv2.png"
			imgs[2].src = "img/风格/fgnv3.png"
			imgs[3].src = "img/风格/fgnv4.png"
			imgs[4].src = "img/风格/fgnv5.png"
			imgs[5].src = "img/风格/fgnv6.png"
			img.innerHTML = "<img class='img' src='img/fsx.png'/>"
			$("#fs").css("padding", "0")
		}
	});
	$(".xb").click(function() {
		$(".xb").css("display", "none");
		console.log("gender:" + gender)
	});
});
$(document).ready(function() {
	var imgs = document.getElementById("style").getElementsByTagName("img")
	var img = document.getElementById("fs")
	$(document).ready(function() {
		$(".xb").css("display", "block");
	});
	$(".xb .col-md-6").click(function() {
		var index = $(".xb .col-md-6").index(this);
		gender = index
		if(index == 0) {
			$("#xb").text("性别：男")
			imgs[0].src = "img/风格/fg_1.png"
			imgs[1].src = "img/风格/fg_2.png"
			imgs[2].src = "img/风格/fg_3.png"
			imgs[3].src = "img/风格/fg_4.png"
			imgs[4].src = "img/风格/fg_5.png"
			imgs[5].src = "img/风格/fg_6.png"
			img.innerHTML = "<img class='img' src='img/2_03.jpg'/>"
			$("#fs").css("padding", "0")

		} else {
			$("#xb").text("性别：女")
			imgs[0].src = "img/风格/fgnv1.png"
			imgs[1].src = "img/风格/fgnv2.png"
			imgs[2].src = "img/风格/fgnv3.png"
			imgs[3].src = "img/风格/fgnv4.png"
			imgs[4].src = "img/风格/fgnv5.png"
			imgs[5].src = "img/风格/fgnv6.png"
			img.innerHTML = "<img class='img' src='img/fsx.png'/>"
			$("#fs").css("padding", "0")
		}
	});
	$(".xb").click(function() {
		$(".xb").css("display", "none");
		console.log("gender:" + gender)
	});
});
//年龄

var age1=[];
for(i=10;i<=60;i++){
	age1.push(i)
}
var mobileSelect1 = new MobileSelect({
    trigger: '#nl', 
    title: '选择年龄',  
    wheels: [
                {data: age1}
            ],
    position:[10], //初始化定位 打开时默认选中的哪个 如果不填默认为0
    transitionEnd:function(indexArr, data){
        age =data[0]
        $("#nl").text("年龄：" + age)
        console.log("age:" + age)
    },
    callback:function(indexArr, data){
        console.log(data);
    }
});
$("#nl").click(function() {
     $(".ensure").click(function() {
     	$("#nl").text("年龄：" + age)
     });
});
//$(document).ready(function() {
//	$("#nl").click(function() {
//		$(".nl").css("display", "block");
//	});
//	$(".nl button").click(function() {
//		$(".nl").css("display", "none");
//		if($(".nl input").val().length != 0 && $(".nl input").val().length < 3) {
//			age = parseInt($(".nl input").val())
//			$("#nl").text("年龄：" + age)
//		}
//		console.log("age:" + age)
//	});
//});
//身高体重
var stature1=[];
for(i=140;i<=200;i++){
	stature1.push(i)
}
var weight1=[];
for(i=30;i<=100;i++){
	weight1.push(i)
}
var mobileSelect2 = new MobileSelect({
    trigger: '#sgtz',
    title: '身高Cm 体重Kg',
    wheels: [
                {data: stature1},
                {data: weight1}
            ],
    position:[30, 20],
    transitionEnd:function(indexArr, data){
    	stature = data[0]
		weight = data[1]
		$("#sgtz").text(stature + "cm" + weight + "kg")
		$("#sgtz").css("font-size", "10px")
        console.log(data);
    },
    callback:function(indexArr, data){
        console.log(data);
    }
});
$("#sgtz").click(function() {
     $(".ensure").click(function() {
     	$("#sgtz").text(stature + "cm" + weight + "kg")
		$("#sgtz").css("font-size", "10px")
     });
});
//$(document).ready(function() {
//	$("#sgtz").click(function() {
//		$(".sgtz").css("display", "block");
//	});
//	$(".sgtz button").click(function() {
//		$(".sgtz").css("display", "none");
//		var inp = document.getElementsByClassName("sgtz")[0].getElementsByTagName("input")
//		if($(".sgtz input").val().length != 0 && $(".sgtz input").val().length != 0) {
//			stature = parseInt(inp[0].value)
//			weight = parseInt(inp[1].value)
//			$("#sgtz").text(stature + "cm" + weight + "kg")
//			$("#sgtz").css("font-size", "10px")
//		} else {
//			return false
//		}
//		console.log("stature:" + stature + "weight:" + weight)
//	});
//});
//选择肤色
var fs1 = $("#fs").outerWidth()*49/130
console.log(fs1)
var fslist = ["偏黑皮肤", "白皙皮肤", "泛红皮肤", "偏黄皮肤"]
$(document).ready(function() {
	$("#fs").click(function() {
		if(gender == 1) {
			$(".fsnv").css("display", "block");
			$(".fsnv .col-md-6").click(function() {
				var index = $(".fsnv .col-md-6").index(this);
				complexion = index + 1
				$("#fs").outerHeight($("#fs").outerHeight())
				$("#fs").text(fslist[index])
				$("#fs").css("padding", "11px 10px")
				$("#fs").css("height", fs1+"px")
			});
			$(".fsnv").click(function() {
				$(".fsnv").css("display", "none");
				console.log("complexion:" + complexion)
			});
		} else {
			$(".fsnan").css("display", "block");
			$(".fsnan .col-md-6").click(function() {
				var index = $(".fsnan .col-md-6").index(this);
				complexion = index + 1
				$("#fs").text(fslist[index])
				$("#fs").css("padding", "11px 10px")
				$("#fs").css("height", fs1+"px")
			});
			$(".fsnan").click(function() {
				$(".fsnan").css("display", "none");
				console.log("complexion:" + complexion)
			});
		}
	});
});
//体型
var txnanlist = ["三角形", "倒三角形", "椭圆形", "倒梯形", "长方形"]
var txnvlist = ["苹果型", "H型", "梨形", "细沙漏型", "长方形", "V型"]
$(document).ready(function() {
	$("#tx").click(function() {
		if(gender == 1) {
			$(".txnv").css("display", "block");
			$(".txnv .col-md-4").click(function() {
				var index = $(".txnv .col-md-4").index(this);
				somatotype = index + 1
				$("#tx").text(txnvlist[index])
				$("#tx").css("padding", "11.1px 10px")
				$("#tx").css("height", fs1+"px")
			});
			$(".txnv").click(function() {
				$(".txnv").css("display", "none");
				console.log("somatotype:" + somatotype)
			});
		} else {
			$(".txnan").css("display", "block");
			$(".txnan .col-md-4").click(function() {
				var index = $(".txnan .col-md-4").index(this);
				somatotype = index + 1
				$("#tx").text(txnanlist[index])
				$("#tx").css("padding", "11.1px 10px")
				$("#tx").css("height", fs1+"px")
			});
			$(".txnan").click(function() {
				$(".txnan").css("display", "none");
				console.log("somatotype:" + somatotype)
			});
		}

	});
});
//脸型
var lxnanlist = ["方脸", "长脸", "圆脸", "鹅蛋脸", "瓜子脸"]
var lxnvlist = ["倒三角形脸", "鹅蛋脸", "长脸", "圆脸", "方脸", "菱形脸", "瓜子脸"]
$(document).ready(function() {
	$("#lx").click(function() {
		if(gender == 1) {
			$(".lxnv").css("display", "block");
			$(".lxnv .col-md-4").click(function() {
				var index = $(".lxnv .col-md-4").index(this);
				feature = index + 1
				$("#lx").text(lxnvlist[index])
				$("#lx").css("padding", "11px 10px")
				$("#lx").css("height", fs1+"px")
			});
			$(".lxnv").click(function() {
				$(".lxnv").css("display", "none");
				console.log("feature:" + feature)
			});
		} else {
			$(".lxnan").css("display", "block");
			$(".lxnan .col-md-4").click(function() {
				var index = $(".lxnan .col-md-4").index(this);
				feature = index + 1
				$("#lx").text(lxnanlist[index])
				$("#lx").css("padding", "11.1px 10px")
				$("#lx").css("height", fs1+"px")
			});
			$(".lxnan").click(function() {
				$(".lxnan").css("display", "none");
				console.log("feature:" + feature)
			});
		}

	});
});
//发质
var fzyxlist = ["干性", "适中", "油性"]
var fzrylist = ["柔软", "适中", "硬"]
var fllist = ["少", "适中", "多"]
$(document).ready(function() {
	$("#fzyx").click(function() {
		$(".fzyx").css("display", "block");
	});
	$(".fzyx .col-md-4").click(function() {
		var index = $(".fzyx .col-md-4").index(this);
		HairOilness = index + 1
		$("#fzyx").text(fzyxlist[index])
	});
	$(".fzyx").click(function() {
		$(".fzyx").css("display", "none");
		console.log("HairOilness:" + HairOilness)
	});
});
//发质软硬
$(document).ready(function() {
	$("#fzry").click(function() {
		$(".fzry").css("display", "block");
	});
	$(".fzry .col-md-4").click(function() {
		var index = $(".fzry .col-md-4").index(this);
		HairToughness = index + 1
		$("#fzry").text(fzrylist[index])
	});
	$(".fzry").click(function() {
		$(".fzry").css("display", "none");
		console.log("HairToughness:" + HairToughness)
	});
});
//发量
$(document).ready(function() {
	$("#fl").click(function() {
		$(".fl").css("display", "block");
	});
	$(".fl .col-md-4").click(function() {
		var index = $(".fl .col-md-4").index(this);
		HairVolume = index + 1
		$("#fl").text(fllist[index])
	});
	$(".fl").click(function() {
		$(".fl").css("display", "none");
		console.log("HairVolume:" + HairVolume)
	});
});
//风格样式
//判断数组
function contains(arr, obj) {
	var i = arr.length;
	while(i--) {
		if(arr[i] === obj) {
			return true;
		}
	}
	return false;
}
$(document).ready(function() {
	$("#style button").click(function() {
		var index = $("#style button").index(this);
		if(!contains(FavorStyle, index)) {
			if(FavorStyle.length <= 4) {
				FavorStyle.push(index)
				$(this).css("border", "1px solid #000");
				$("#alert").text("")
			} else {
				$("#alert").text("最多选择五个！")
			}
		} else {
			$(this).css("border", "none");
			var i = FavorStyle.length;
			$("#alert").text(" ")
			while(i--) {
				if(FavorStyle[i] === index) {
					FavorStyle.splice(i, 1)
				}
			}
		}
		FavorStyle.sort()
		console.log("FavorStyle:" + FavorStyle)
	});

});
//input获得焦点内容清空
$(document).ready(function() {
	$("input").focus(function() {
		$(this).val("");
	});
});
var bool = function(data){
	if(data==0){
		return true
	}else{
		return false
	}
}
var data = {}
var gen = bool(gender)
$(document).ready(function() {
	$("#submit").click(function() {
		data = {
			"gender": bool(gender),
			"age": age,
			"stature": stature,
			"weight": weight,
			"complexion": complexion,
			"somatotype": somatotype,
			"feature": feature,
			"hairOilness": HairOilness,
			"hairToughness": HairToughness,
			"hairVolume": HairVolume,
			//"Hairquality":HairOilness.toString()+HairToughness.toString()+HairVolume.toString()
			"favorStyle": FavorStyle.join("")
		}
		
		var postArray = new Array();
		postArray.push(data);
		console.log(data)
		var receive;
		$.ajax({
			
			url: "/customize/report",
			type: "post",
			
			data:JSON.stringify(data),
			dataType:"text",
			contentType:"application/json; charset=utf-8",
			
			success: function(receive) {
				//var dataObj = JSON.parse(data);
				window.location.href="/customize/reportshow";
				console.log("sjfosn");
			},
			error:function(e){
				
				//window.location.href="/customize/showreport";
				console.log(e);
            }
		});
	});

});