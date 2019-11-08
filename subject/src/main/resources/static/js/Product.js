jQuery(document).ready(function(){
	jQuery(".fj").on("click",".pdAll",function(){
		var id3 = this.id
		jQuery.ajax({
			"url":"servlet/ProductServlet",
			"type":"get",
			"data":"ID3="+id3,
			"dataType":"JSON",
			"success":pdAll
		});
		function pdAll(data){
			var prod = jQuery(".cate_list");
			cate_list.appdend("<li><div class=\"img\"><a href=\"#\"><img src=\"images/per_1.jpg\" width=\"210\" height=\"185\" /></a></div><div class=\"price\"><font>￥<span>198.00</span></font> &nbsp; 26R</div><div class=\"name\"><a href=\"#\">"+香奈儿邂逅清新淡香水50ml+"</a></div><div class=\"carbg\"><a href=\"#\" class=\"ss\">收藏</a><a href=\"#\" class=\"j_car\">加入购物车</a></div></li>");
		};
	});
	function product(){
		jQuery.ajax({
			"url":"servlet/ProductsServlet",
			"type":"get",
			"data":"opr=PageProduct",
			"dataType":"JSON",
			"success":prodAll
		});
		function prodAll(data){
			var b = data.productList;
			var $a = jQuery(".order_tab").empty();
			$a.append("<tr>"
						+"<td width=\"155\">商品名称</td>"
						+"<td width=\"155\">商品图片</td>"
						+"<td width=\"155\">商品库存</td>"
						+"<td width=\"155\">商品价格</td>"
						+"<td width=\"155\" colspan = 2>操作</td>"
					+"</tr>");
			for (var i = 0; i < b.length; i++) {
				$a.append("<tr>"
						+"<td>"+b[i].name+"</td>"
						+"<td><img src=\"images/"+b[i].fileName+"\" winth = \"50px\" height = \"50px\"/></td>"
						+"<td>"+b[i].stock+"</td>"
						+"<td>"+b[i].price+"</td>"
						+"<td><a onclick = \"ShowDiv('MyDiv','fade',id='"+b[i].categoryLevel1Id+":"+b[i].categoryLevel2Id+":"+b[i].categoryLevel3Id+":"+b[i].id+"')\">修改</a></td>"
						+"<td>删除</td>"
					+"</tr>");
			}
			var $page = jQuery(".pages").empty();
			$first=jQuery("<a href=\"javascirpt:;\" class=\"p_pre\">上一页</a>").click(function(){
				jQuery.getJSON("servlet/ProductsServlet","opr=PageProduct&pageIndex="+((data.currPageNo-1)<0?1:(data.currPageNo-1)),prodAll);
			});
			$page.append($first);
			for (var i = 1; i<=data.totalPageCount; i++) {
				$middle = jQuery("<a href=\"javascirpt:;\" id = \""+i+"\">"+i+"</a>").click(function(){
				jQuery.getJSON("servlet/ProductsServlet","opr=PageProduct&pageIndex="+this.id,prodAll);
				  });
				$page.append($middle);
				}
			
			$last = jQuery("<a href=\"javascirpt:;\" class=\"p_pre\">下一页</a>").click(function(){
				jQuery.getJSON("servlet/ProductsServlet","opr=PageProduct&pageIndex="+((data.currPageNo+1)>(data.totalPageCount)?(data.totalPageCount):(data.currPageNo+1)),prodAll);
			});
			$page.append($last);
		};
	};
	 product();
	 
});