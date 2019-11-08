jQuery(document).ready(function(){
	function shouAllUser(){
		jQuery.ajax({
			"url" : "Servlet/UserServlet",
			"type" : "get",
			"data" : "opr=getPageUser",
			"dataType" : "JSON",
			"success" : AN
		});
		function AN(data){
			var $a = jQuery(".order_tab").empty();
			$a.append("<tr>"
						+"<td width=\"30%\">用户名称</td>"
						+"<td width=\"30%\">真实姓名</td>"
						+"<td width=\"10%\">性别</td>"
						+"<td width=\"10%\">类型</td>"
						+"<td width=\"20%\" colspan = 2>操作</td>"
					+"</tr>")
			var user = data.userList  
			
			for (var i = 0; i < user.length; i++) {
				$a.append("<tr><td>"+user[i].loginName+"</td><td>"+user[i].uaerName+"</td><td>"+(parseInt(user[i].sex)==1?"男":"女")+"</td><td>"+(parseInt(user[i].type)==1?"管理员":"普通用户")+"</td><td><a onclick = \"ShowDiv('MyDiv','fade',id="+user[i].id+")\">修改</a></td><td><a href = \"javascript:;\" onclick=\"showDivUser('MyDivUser','fadeUser',id="+user[i].id+")\" >删除</a></td></tr>")
			}
			var $page = jQuery(".pages").empty();
			$first=jQuery("<a href=\"javascirpt:;\" class=\"p_pre\">上一页</a>").click(function(){
				jQuery.getJSON("Servlet/UserServlet","opr=getPageUser&pageIndex="+((data.currPageNo-1)<0?1:(data.currPageNo-1)),AN);
			});
			
			$page.append($first);
			if(data.totalPageCount<=4){
				for (var i = 1; i<=data.totalPageCount; i++) {
					$middle = jQuery("<a href=\"javascirpt:;\" id = \""+i+"\">"+i+"</a>").click(function(){
						jQuery.getJSON("Servlet/UserServlet","opr=getPageUser&pageIndex="+this.id,AN);
					});
					$page.append($middle)
				}
			}
			$last = jQuery("<a href=\"javascirpt:;\" class=\"p_pre\">下一页</a>").click(function(){
				jQuery.getJSON("Servlet/UserServlet","opr=getPageUser&pageIndex="+((data.currPageNo+1)>(data.totalPageCount)?(data.totalPageCount):(data.currPageNo+1)),AN);
			});
			$page.append($last);
		}
	};
	shouAllUser();
});