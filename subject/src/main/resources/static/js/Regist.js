$(document).ready(function() {
	//注册ajax
	var port = "http://2745ye4169.wicp.vip";
	$(".reg_c").on("blur", ".l_user", function() {
		var userName = $("#l_user").val();
		if (userName == null || userName == "") {
			alert("用户名不能为空");
		} else {
//			$.ajax({
//				"url" : "Servlet/UserServlet",
//				"type" : "post",
//				"data" : "opr=userName&l_user=" + userName,
//				"dataType" : "JSON",
//				"success" : user
//			});
//			function user(data) {
//				if (data[0].status == "error") {
//					alert(data[0].hint);
//					$(".l_user").css("border-color","red");
//					$("#l_user").val("");
//				} else if (data[0].status == "success") {
//
//				}
//			}
		}

	});
	$(".reg_c").on("blur", "#l_pwd2", function() {
		var pwd = $("#l_pwd").val();
		var pwd2 = $("#l_pwd2").val();
		if (pwd == null || pwd == "") {
			alert("密码不能为空");
			
		} else {
			if (pwd != pwd2) {
				alert("两次输入密码不相同");
			}	
		}
	});
	$(".reg_c").on("blur", ".l_email", function() {
		var email = $(".l_email").val();
		if (email == null || email == "") {
			alert("邮箱不能为空");
		} 
	});
	$(".reg_c").on("blur", ".l_tel", function() {
		var tel = $(".l_tel").val();
		if (tel == null || tel == "") {
			alert("手机号不能为空");
		} 
	});
//	$.ajax({
//  url : SITE_PATH + "/userLogRecord/getList3?name1=name&name2=name2",
//  type : 'GET',
//  dataType : 'json',
//  data:{name3:"name3"},
//  success : function(data) {
//      console.log(111111);
//  },
//  error : function(msg) {
//  }
//});
$(".reg_c").on("click", ".verify", function() {
	var mobile = $(".l_tel").val();
	$.ajax({
			type:"post",
			url:port+"/verify?mobile="+mobile,
			async:true
		});

});
	$(".reg_c").on("click",".log_btn",function(){
		var pwd = $("#l_pwd").val();
		var email = $("#l_email").val();
		var userName = $("#l_user").val();
		var mobile = $(".l_tel").val();
			$.ajax({
		type:"post",
		url:port+"/registerUser?userName="+userName+"&password="+pwd+"&email="+email+"&mobile="+mobile,
//		data:{userName='',password='',email='',mobile=''}
		async:true,
		"contentType": "application/json;charset=utf-8"
	});
	})

});
