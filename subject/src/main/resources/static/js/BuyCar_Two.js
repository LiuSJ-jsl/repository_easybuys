jQuery(document).ready(function() {
	
	jQuery(".two_t").on("click",".prUpdate",function(){
		jQuery(".allText input").removeAttr('disabled');
	});
	jQuery(".two_t").on("click",".prSave",function(){
		jQuery(".allText input").attr('disabled', 'disabled').css("border-color","red");
	});
	jQuery(".two_t").on("click",".siteUpdate",function(){
		jQuery(".site").removeAttr('disabled');
	});
	jQuery(".two_t").on("click",".siteSave",function(){
		jQuery(".site").attr('disabled', 'disabled');
	});
	function order(){
		jQuery.ajax({
			"url" : "servlet/AddressServlet",
			"type" : "post",
			"data" : "opr=adr",
			"dataType" : "JSON",
			"success" : adress
		});
		function adress(data){
			var $car_tab = jQuery(".car_address").empty();
			$car_tab.append("<tr><td class=\"car_th\" width=\"80\"></td><td class=\"car_th\" width=\"200\">收件人备注</td><td class=\"car_th\" width=\"370\">地址</td></tr>");
			var i = 0;
			for (i = 0 ; i < data.length; i++) {
				$car_tab.append("<tr><td align=\"center\"><input type=\"checkbox\" name=\"aa\" class =\"aa\"/></td><td align=\"center\" style=\"font-size:14px;\"><b class = \"loginName\">"+data[i].remark+"</b></td><td><b class = \"address\">"+data[i].address+"</b></td></tr>");
			}
			$car_tab.append("<tr height=\"70\"><td colspan = \"3\" align=\"right\"><a href=\"javaScript:;\" class = \"btn_sure\"><img src=\"images/btn_sure.gif\" /></a></td></tr>");
			
		};
	};
	order();
	jQuery(".car_address").on("click",".btn_sure",function(){
		if(jQuery(".aa").is(":checked")) {
		    var b = jQuery(".address").html();
		    var m = jQuery(".pric").html().substring(1);
		    jQuery.ajax({
				"url" : "servlet/OrdeorServlet",
				"type" : "post",
				"data" : "opr=insertAddress&userAddress="+b+"&cost="+m,
				"dataType" : "text",
				"success" : insertAdd
			});
		    function insertAdd(data){
		    	if(data>0){
		    	    var i = jQuery(".pric").html().substring(1);
		    	    var j = jQuery(".name").html().trim();
		    	    var k = jQuery(".car_ipt").val();
		    	    jQuery.ajax({
						"url" : "servlet/OrdeorServlet",
						"type" : "post",
						"data" : "opr=inserteas&cost="+i+"&name="+j+"&number="+k,
						"dataType" : "text",
						"success" : insertee
					});
		    	    function insertee(data){
		    	    	if(data>0){
		    	    		alert("添加成功！");
				    		location.href="BuyCar_Three.jsp";
		    	    	}
		    	    }
		    	}
		    }
		}
		
	});
	
});