// JavaScript Document

function addUpdate(jia) {
	var c = jia.parent().find(".n_ipt").val();
	c = parseInt(c) + 1;
	jia.parent().find(".n_ipt").val(c);
}

function jianUpdate(jian) {
	var c = jian.parent().find(".n_ipt").val();
	if (c == 1) {
		c = 1;
	} else {
		c = parseInt(c) - 1;
		jian.parent().find(".n_ipt").val(c);
	}
}

function addUpdate1(jia, id) {
	var c = jia.parent().find(".car_ipt").val();
	c = parseInt(c) + 1;
	var pr = jia.parent().parent().next().text().substring(1) / (c - 1) * c;
	jia.parent().find(".car_ipt").val(c);
	jia.parent().parent().next().text("￥" + pr);
	var a = jQuery(".dp").text().substring(1);
		a = parseInt(a) + (pr/c);
	jQuery(".dp").text("￥" + a);
	jQuery.ajax({
		"url" : "servlet/BuyCarServlet",
		"data" : "opr=ss&c=" + c + "&id=" + id + "&price=" + pr,
		"Type" : "get",
		"dataType" : "text",
		"success" : prpc
	});
	function prpc(data) {
		if (data == "true") {
		} else {
			alert("修改失败,请稍候再试！");
		}

	}

}

function jianUpdate1(jian, id) {
	var c = jian.parent().find(".car_ipt").val();
	if (c == 1) {
		c = 1;
	} else {
		c = parseInt(c) - 1;
		var pr = jian.parent().parent().next().text().substring(1) / (c + 1)
				* c;
		jian.parent().find(".car_ipt").val(c);
		jian.parent().parent().next().text("￥" + pr);
		var a = jQuery(".dp").text().substring(1);
		a = parseInt(a) - (pr/c);
	    jQuery(".dp").text("￥" + a);
	}
	jQuery.ajax({
		"url" : "servlet/BuyCarServlet",
		"data" : "opr=ss&c=" + c + "&id=" + id + "&price=" + pr,
		"Type" : "get",
		"dataType" : "text",
		"success" : prpc
	});
	function prpc(data) {
		if (data == "true") {
		} else {
			alert("修改失败,请稍候再试！");
		}

	}
}
jQuery(document).ready(function() {
function zprice(){
	jQuery.ajax({
		"url" : "servlet/BuyCarServlet",
		"type" : "get",
		"data" : "opr=userName",
		"dataType" : "text",
		"success" : zp
	});
	function zp(data){
		var $zp = jQuery(".zp");
		$zp.append("<td colspan=\"6\"style=\"font-family:'Microsoft YaHei'; border-bottom:0;\"><label class=\"r_rad\"><input type=\"checkbox\" name=\"clear\"checked=\"checked\" /></label><label class=\"r_txt\">清空购物车</label> <span class=\"fr\">商品总价：<b style=\"font-size:22px; color:#ff4e00;\" class = \"dp\">￥"+data+"</b></span></td>");
		var $op = jQuery(".op");
		$op.append("商品总价：￥"+data+"； 返还积分56R");
	}
}
zprice();
});

