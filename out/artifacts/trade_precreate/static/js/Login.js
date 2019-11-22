jQuery(document).ready(function () {
    jQuery(".log_c").on("click", ".log_btn", function () {
        var mobile = jQuery(".l_user").val();
        var password = jQuery(".l_pwd").val();
        console.log(mobile);
        console.log(password);
        jQuery.ajax({
            "url": "/login",
            "type": "post",
            async: false,
            "data": {
                'password': password,
                'mobile': mobile
            }
        });
    });
});