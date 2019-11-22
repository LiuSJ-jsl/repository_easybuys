jQuery(document).ready(function() {
	function showAllOrder(){
		jQuery.ajax({
			"url" : "servlet/OrdeorServlet",
			"Type" : "get",
			"data" : "opr=OrderInfo",
			"dataType" : "JSON",
			"success" : adc
		});
		function adc(data){
		var $od_tr = jQuery(".od_tr");
		for (var a = 0; a < data.length; a++) {
			$od_tr.append("<tr style = \"background-color:#ff4e00;color:white\" ><td>"+data[a].loginName+"</td><td>"+data[a].userAddress+"</td><td colspan='2'>"+data[a].serialNumber+"</td></tr>");
			jQuery.ajax({
				"url" : "servlet/OrdeorServlet",
				"type" : "get",
				"async":false,
				"data" : "opr=or&orderId="+data[a].id,
				"dataType" : "JSON",
				"success" : ad
			});
			function ad(ado){
				$od_tr.append("<tr>"
								+"<td width=\"25%\">商品名称</td>"
								+"<td width=\"30%\">商品图片</td>"
								+"<td width=\"20%\">数量</td>"
								+"<td width=\"25%\">总价</td>"
							+"</tr>");
					for (var i = 0; i < ado.length; i++) {
						$od_tr.append("<tr><td>"+ado[i][2].name+"</td><td><img src=\"images/"+ado[i][2].fileName+"\" width=\"50px\" higth = \"50px\"/></td><td>"+ado[i][1].quantity+"</td><td>"+ado[i][1].cost+"</td></tr>");
					
				};
		};
		
		};
	};
}
	showAllOrder();
});