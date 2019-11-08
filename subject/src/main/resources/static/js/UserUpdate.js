function ShowDiv(show_div, bg_div, id) {
	document.getElementById(show_div).style.display = 'block';
	document.getElementById(bg_div).style.display = 'block';
	var bgdiv = document.getElementById(bg_div);
	bgdiv.style.width = document.body.scrollWidth;
	jQuery("#" + bg_div).height(jQuery(document).height());
	jQuery.ajax({
		"url" : "Servlet/UserServlet",
		"type" : "get",
		"data" : "opr=UserById&id=" + id,
		"dataType" : "JSON",
		"success" : userById
	});
	function userById(data) {
		var $bg = jQuery(".bg").empty();
		$bg
				.append("<tr><td width=\"40%\">用戶姓名：</td><td><input type = \"text\" class = \"loginName\" value = \""
						+ data.loginName
						+ "\"/></td></tr><tr><td width=\"40%\">真实姓名：</td><td><input type = \"text\" class=\"uaerName\" value = \""
						+ data.uaerName
						+ "\"/></td></tr><tr><td width=\"40%\">身份证：</td><td><input type = \"text\" class=\"identityCode\" value = \""
						+ data.identityCode
						+ "\"/></td></tr><tr><td width=\"40%\">电子邮箱：</td><td><input type = \"eamil\"class = \"email\" value = \""
						+ data.email
						+ "\"/></td></tr><tr><td width=\"40%\">手机：</td><td><input type = \"text\" class = \"moblie\" value = \""
						+ data.moblie
						+ "\"/></td></tr><tr><td width=\"40%\">用户类型：</td><td><select class = \"type\"><option value =\"1\""
						+ ((data.type == 1) ? 'selected' : '')
						+ ">管理员</option><option value =\"0\""
						+ ((data.type == 0) ? 'selected' : '')
						+ ">普通用户</option></select></td></tr>")
		$bg
				.append("<tr height=\"50\" valign=\"bottom\" ><td colspan = 2><a style = \"margin-left:50px\" href=\"javascript:;\" class=\"b_sure\">确定</a><a href=\"javascript:;\" class=\"b_buy\">取消</a></td></tr>")
	}
	;
	jQuery(".notice_c").on(
			"click",
			".b_sure",
			function() {
				var a = jQuery(".loginName").val();
				var b = jQuery(".uaerName").val();
				var c = jQuery(".identityCode").val();
				var d = jQuery(".email").val();
				var e = jQuery(".moblie").val();
				var f = jQuery(".type").val();
				jQuery.ajax({
					"url" : "Servlet/UserServlet",
					"type" : "post",
					"data" : "opr=UpadteUser&id=" + id + "&loginName=" + a
							+ "&userName=" + b + "&identityCode=" + c
							+ "&email=" + d + "&mobile=" + e + "&type=" + f,
					"dataType" : "text",
					"success" : Updatauser
				});
				function Updatauser(data) {
					if (data > 0) {
						window.location.reload();
					} else {
						alert("修改失败！");
					}
					;
					document.getElementById(show_div).style.display = 'none';
					document.getElementById(bg_div).style.display = 'none';
				}
				;
			});
	jQuery(".notice_c").on("click", ".b_buy", function() {
		document.getElementById(show_div).style.display = 'none';
		document.getElementById(bg_div).style.display = 'none';
	});
};
function showDivUser(show_user, bg_user, id) {
	document.getElementById(show_user).style.display = 'block';
	document.getElementById(bg_user).style.display = 'block';
	var bgdiv = document.getElementById(bg_user);
	bgdiv.style.width = document.body.scrollWidth;
	jQuery("#" + bg_user).height(jQuery(document).height());
	jQuery(".notice_u").on("click", ".b_sure", function() {
		document.getElementById(show_user).style.display = 'none';
		document.getElementById(bg_user).style.display = 'none';
		jQuery.ajax({
			"url" : "Servlet/UserServlet",
			"type" : "get",
			"data" : "opr=deleteUser&id=" + id,
			"dataType" : "text",
			"success" : delUser
		});
		function delUser(data) {
			if (data > 0) {
				window.location.reload();
			} else {
				alert("删除失败！");
			}
			;
		}
		;
	});
	jQuery(".notice_u").on("click", ".b_buy", function() {
		document.getElementById(show_user).style.display = 'none';
		document.getElementById(bg_user).style.display = 'none';
	});
};

function CloseDiv(show_div, bg_div) {
	document.getElementById(show_div).style.display = 'none';
	document.getElementById(bg_div).style.display = 'none';
};
