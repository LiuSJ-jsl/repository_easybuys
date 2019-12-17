jQuery(function () {
    jQuery(".verify").click(function () {
        var mobile = jQuery(".l_tel").val();
        jQuery.ajax({
            type: "post",
            url: "/verify",
            data: {"mobile": mobile},
            // async: true
        });
    });
    jQuery(".reg_c").on("click", ".log_btn", function () {
        var pwd = jQuery("#l_pwd").val();
        var email = jQuery("#l_email").val();
        var userName = jQuery("#l_user").val();
        var mobile = jQuery(".l_tel").val();
        var sex = jQuery(".l_sex").val();
        jQuery.ajax({
            type: 'post',
            url: "/registerUser",
            data: {
                'userName': userName,
                "password  ": pwd,
                "email  ": email,
                'mobile': mobile,
                'sex': sex
            },
            async: false,
            "contentType":
                "application/json;charset=utf-8",
            success: function (data) {
                conseole.log(data);
            }
        });
    })
});
