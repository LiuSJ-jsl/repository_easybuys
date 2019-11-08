jQuery(document).ready(function() {
	$(".cate_list").on("click", ".j_car", function() {
		var a = this.id;
		$.ajax({
			"url" : "servlet/BuyCarServlet",
			"Type" : "get",
			"data" : "opr=insert&id=" + a,
			"dataType" : "text",
			"success" : BuyAll
		});
		function BuyAll(data) {
			if (data == "true") {
				var b = $(".zs").text();
				b = parseInt(b)+1;
				 $(".zs").text(b);
				alert("添加成功！");
			} else {
				alert("添加失败！");

			}
		}
	});
	$(".i_car").on({
		mouseenter : function() {
			$.ajax({
				"url" : "servlet/BuyCarServlet",
				"type" : "get",
				"data" : "opr=sele",
				"dataType" : "JSON",
				"success" : seleBuy
			});
			function seleBuy(data) {
				var $cars = $(".cars").empty();
				var count = 0;
				for (var i = 0; i < data.length; i++) {
					$cars.append("<li><div class=\"img\"><a href=\"#\"><img src=\"images/"+data[i].fileName+"\" width=\"58\" height=\"58\" /></a></div><div class=\"name\"><a href=\"#\">"+data[i].name+"</a></div><div class=\"price\"><font color=\"#ff4e00\">"+data[i].price+"</font> X"+data[i].number+"</div></li>")
					count = count + parseInt(data[i].price);
				}
				var $price_sum = $(".price_sum").empty(); 
				$price_sum.append("共计&nbsp; <font color=\"#ff4e00\">￥</font><span>"+count+"</span>")

			}
		},
		mouseleave : function() {
		}

	});
	function lity123(){
		$.ajax({
			"url":"servlet/BuyCarServlet",
			"type":"get",
			"data":"opr=count",
			"dataType":"text",
			"success":sum123
		});
		function sum123(data){
			var $car_t = $(".i_car");
			$car_t.append("<div class=\"car_t\">购物车 [ <span class = \"zs\">"+data+"</span> ]</div>");
		};
	};
	lity123();
});