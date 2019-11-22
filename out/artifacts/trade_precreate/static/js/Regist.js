$(function () {
    $(".reg_c").on("blur", ".l_user", function () {
        var userName = $("#l_user").val();
        if (userName == null || userName == "") {
            alert("用户名不能为空");
        }
    });
    $(".reg_c").on("blur", "#l_pwd2", function () {
        var pwd = $("#l_pwd").val();
        var pwd2 = $("#l_pwd2").val();
        if (pwd == null || pwd == "") {
            alert("密码不能为空");

        } else {
            if (pwd != pwd2) {
                alert("两次输入密码不相同");
            }
        }
    });
    $(".reg_c").on("blur", ".l_email", function () {
        var email = $(".l_email").val();
        if (email == null || email == "") {
            alert("邮箱不能为空");
        }
    });
    $(".reg_c").on("blur", ".l_tel", function () {
        var tel = $(".l_tel").val();
        if (tel == null || tel == "") {
            alert("手机号不能为空");
        }
    });
    $(".reg_c").on("click", ".verify", function () {
        var mobile = $(".l_tel").val();
        $.ajax({
            type: "post",
            url: "/verify",
            data: "mobile=" + mobile,
            async: true
        });
    });
    $(".reg_c").on("click", ".log_btn", function () {
        var pwd = $("#l_pwd").val();
        var email = $("#l_email").val();
        var userName = $("#l_user").val();
        var mobile = $(".l_tel").val();
        var sex = $(".l_sex").val();
        $.ajax({
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
