function ShowDiv(show_div, bg_div, id) {
	document.getElementById(show_div).style.display = 'block';
	document.getElementById(bg_div).style.display = 'block';
	var bgdiv = document.getElementById(bg_div);
	bgdiv.style.width = document.body.scrollWidth;
	jQuery("#" + bg_div).height(jQuery(document).height());
	var a = id.split(":");
	jQuery.ajax({
		"url" : "servlet/CommodityCategoryServlet",
		"type" : "get",
		"data" : "opr=1id",
		"dataType" : "JSON",
		"success" : ProudctBy1Id
	});
	function ProudctBy1Id(data) {
		var $bg = jQuery(".ba").empty();
		for (var i = 0; i < data.length; i++) {
			$bg.append("<option value=\"" + data[i].id + "\" class=\"1Id\">" + data[i].name
					+ "</option>");
			jQuery(".ba").val(a[0]);
		}
		jQuery.ajax({
			"url" : "servlet/CommodityCategoryServlet",
			"type" : "get",
			"data" : "opr=2id&1Id="+jQuery(".ba").val(),
			"dataType" : "JSON",
			"success" : ProudctBy2Id
		});
		function ProudctBy2Id(data) {
			var $bg = jQuery(".bb").empty();
			for (var i = 0; i < data.length; i++) {
				$bg.append("<option value=\"" + data[i].id + "\">" + data[i].name
						+ "</option>");
				jQuery(".bb").val(a[1]);
			}
		}
	
	jQuery.ajax({
		"url" : "servlet/CommodityCategoryServlet",
		"type" : "get",
		"data" : "opr=3id&1Id="+jQuery(".ba").val(),
		"dataType" : "JSON",
		"success" : ProudctBy3Id
	});
	function ProudctBy3Id(data) {
		var $bg = jQuery(".bc").empty();
		for (var i = 0; i < data.length; i++) {
			$bg.append("<option value=\"" + data[i].id + "\">" + data[i].name
					+ "</option>");
			jQuery(".bc").val(a[2]);
		}
	}
	}
	jQuery(".ba").change(function(){
		jQuery.ajax({
			"url" : "servlet/CommodityCategoryServlet",
			"type" : "get",
			"data" : "opr=2id&1Id="+jQuery(".ba").val(),
			"dataType" : "JSON",
			"success" : ProudctBy2Id
		});
		function ProudctBy2Id(data) {
			var $bg = jQuery(".bb").empty();
			for (var i = 0; i < data.length; i++) {
				$bg.append("<option value=\"" + data[i].id + "\">" + data[i].name
						+ "</option>");
			}
		}
	
	jQuery.ajax({
		"url" : "servlet/CommodityCategoryServlet",
		"type" : "get",
		"data" : "opr=3id&1Id="+jQuery(".ba").val(),
		"dataType" : "JSON",
		"success" : ProudctBy3Id
	});
	function ProudctBy3Id(data) {
		var $bg = jQuery(".bc").empty();
		for (var i = 0; i < data.length; i++) {
			$bg.append("<option value=\"" + data[i].id + "\">" + data[i].name
					+ "</option>");
		}
	}
	});
	
	jQuery.ajax({
		"url" : "servlet/ProductsServlet",
		"type" : "get",
		"data" : "opr=3id&id="+a[3],
		"dataType" : "JSON",
		"success" : ProudctById
	});
	function ProudctById(data) {
		var $bg = jQuery(".bd").empty();
			$bg.append("<td>商品名称</td><td><input type = \"text\" value=\""+data[0].name+"\"></td>");
			var $be = jQuery(".be").empty();
			$be.append("<td>商品图片</td><td><img id = \"previewImg\" src=\"images/"+data[0].fileName+"\"width = \"40px\" height=\"40px\"/><input type=\"file\" id=\"upload\" name=\"upload\" value=\"\" /></td>");
			$("#upload").change(function(){
				alert($("#upload").val());
				$("#previewImg").attr("src","file:///"+$("#upload").val());
			});
			var $bf = jQuery(".bf").empty();
			$bf.append("<td>商品价格</td><td><input type = \"text\" value=\""+data[0].price+"\"></td>");
			var $bh = jQuery(".bh").empty();
			$bh.append("<td>商品库存</td><td><input type = \"text\" value=\""+data[0].stock+"\"></td>");
			var $ba = jQuery(".bi").empty();
			$ba.append("<td>描述</td><td><textarea rows=\"3\" cols=\"20\">"+data[0].description+"</textarea></td>");
	}
	var aaa = jQuery(".sm").empty();
	aaa.append("<td colspan = 2><a style = \"margin-left:150px\" href=\"javascript:;\" class=\"b_sure\">确定修改</a></td>");
	jQuery(".bg").on("click", ".b_sure", function() {
		document.getElementById(show_div).style.display = 'none';
		document.getElementById(bg_div).style.display = 'none';
		var formData = new FormData(jQuery( "#uploadForm" )[0]); 
		 jQuery.ajax({ 
			"url" : "servlet/SaveProducts",
			"type" : "get",
			"data" : formData,
			"dataType" : "JSON",
			"success" : Up
	});
		 function Up(data){
			 if(data>0){
				 alert("上传成功！");
			 }
			 }
		
	});
};
function CloseDiv(show_div, bg_div) {
	document.getElementById(show_div).style.display = 'none';
	document.getElementById(bg_div).style.display = 'none';
};