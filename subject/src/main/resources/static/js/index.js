jQuery(function () {
    var userName = jQuery(".username").val();
    var uid = jQuery(".uid").val();
    // alert(userName)
    if (userName == "null" || userName == "") {
        // alert(userName)
        jQuery(".sou").prepend(' <span class="fl">你好，请<a href="/login">登录</a>&nbsp; <a href="/registerUser" style="color:#ff4e00;">免费注册</a>&nbsp;|&nbsp;<a href="#">我的订单</a>&nbsp;|</span>');
        jQuery(".car_bg").prepend('<div class="un_login">还未登录！<a th:href="@{/login}" style="color:#ff4e00;">马上登录</a> 查看购物车！</div>\n')
    } else {
        jQuery(".car_bg").prepend(' <ul class="cars">\n' +
            '                        <li>\n' +
            '                            <div class="img"><a href="#"><img src="/static/images/car1.jpg" width="58" height="58"/></a>\n' +
            '                            </div>\n' +
            '                            <div class="name"><a href="#">法颂浪漫梦境50ML 香水女士持久清新淡香 送2ML小样3只</a></div>\n' +
            '                            <div class="price"><font color="#ff4e00">￥399</font> X1</div>\n' +
            '                        </li>\n' +
            '                        <li>\n' +
            '                            <div class="img"><a href="#"><img src="/static/images/car2.jpg" width="58" height="58"/></a>\n' +
            '                            </div>\n' +
            '                            <div class="name"><a href="#">香奈儿（Chanel）邂逅活力淡香水50ml</a></div>\n' +
            '                            <div class="price"><font color="#ff4e00">￥399</font> X1</div>\n' +
            '                        </li>\n' +
            '                    </ul>\n' +
            '                    <div class="price_sum">共计&nbsp; <font color="#ff4e00">￥</font><span>1058</span></div>\n' +
            '                    <div class="price_a"><a href="BuyCar.html">去购物车结算</a></div>\n' +
            '                    <!--End 购物车已登录 End-->')
        jQuery(".sou").prepend(" <span class='fl'>欢迎:<a th:href='@{/personage}' >" + userName + "</span></a>&nbsp;|&nbsp;<a href='#'>我的订单</a>&nbsp;|</span>");

    }

});