$(document).ready(function() {
	var port = "http://2hi7446726.wicp.vip";
	$(".log_c").on("blur", ".l_user", function() {
		var userName = $(".l_user").val();
		if(userName == null || userName == "") {
			alert("用户名不能为空");
		} else {
			//			$.ajax({
			//				"url" : port+"/login",
			//				"type" : "post",
			//				"data" : "userName=" + userName,
			//				"dataType" : "JSON",
			//				"success" : login
			//			});
			//			function login(data) {
			//				if (data[0].status == "error") {
			//					alert(data[0].hint);
			//					$(".l_user").val("");
			//				} else if (data[0].status == "success") {
			//					// 添加样式
			//				}
			//			}
		}

	});
	$(".log_c").on("click", ".log_btn", function() {
			
			var mobile = $(".l_user").val();
			var password = $(".l_pwd").val();
				if(password == null || password == "") {
					alert("请输入密码");
		
				} else {
					//			alert(password);
					//			alert(mobile);
					$.ajax({
						"url": port + "/login",
						"type": "post",
						"data": "password=" + password + "&mobile=" + mobile,
						dataType: "json",
//						"contentType": "application/json;charset=utf-8",
						"success": function(data) {
							alert(data);
						},
		
					});

				}
	});	

});