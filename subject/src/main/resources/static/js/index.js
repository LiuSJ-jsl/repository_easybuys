jQuery(function() {
    var userName = jQuery(".username").val();

    if (userName =="null" || userName == ""){
        alert(userName)
        jQuery(".sou").append(' <span class="fl">你好，请<a href="/login">登录</a>&nbsp; <a href="regist.html" style="color:#ff4e00;">免费注册</a>&nbsp;|&nbsp;<a href="#">我的订单</a>&nbsp;|</span>');
    }else {
        alert(userName)
        jQuery(".sou").prepend(" <span class='fl'>欢迎:<a href='#' >"+ userName +"</span></a>&nbsp;|&nbsp;<a href='#'>我的订单</a>&nbsp;|</span>");

    }
});