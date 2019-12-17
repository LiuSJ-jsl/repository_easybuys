// JavaScript Document

function ShowDiv(show_div, bg_div, id) {
	document.getElementById(show_div).style.display = 'block';
	document.getElementById(bg_div).style.display = 'block';
	var bgdiv = document.getElementById(bg_div);
	bgdiv.style.width = document.body.scrollWidth;
	// bgdiv.style.height = $(document).height();
	jQuery("#" + bg_div).height(jQuery(document).height());
	jQuery(".notice_c").on("click", ".b_sure", function() {
		document.getElementById(show_div).style.display = 'none';
		document.getElementById(bg_div).style.display = 'none';
		jQuery.ajax({
			"url" : "servlet/BuyCarServlet",
			"type" : "get",
			"data" : "opr=del&id=" + id,
			"dataType" : "text",
			"success" : delBuy
		});
		function delBuy(data) {
			if (data > 0) {
				window.location.reload();
				alert("删除成功！");
			} else {
				alert("删除失败！");
			}
		};
	});
	jQuery(".notice_c").on("click", ".b_buy", function() {
		document.getElementById(show_div).style.display = 'none';
		document.getElementById(bg_div).style.display = 'none';
	});
};

 function CloseDiv(show_div, bg_div) {
	document.getElementById(show_div).style.display = 'none';
	document.getElementById(bg_div).style.display = 'none';
};

function ShowDiv_1(show_div, bg_div) {
	document.getElementById(show_div).style.display = 'block';
	document.getElementById(bg_div).style.display = 'block';
	var bgdiv = document.getElementById(bg_div);
	bgdiv.style.width = document.body.scrollWidth;
	// bgdiv.style.height = $(document).height();
	jQuery("#" + bg_div).height($(document).height());
};

function CloseDiv_1(show_div, bg_div) {
	document.getElementById(show_div).style.display = 'none';
	document.getElementById(bg_div).style.display = 'none';
};