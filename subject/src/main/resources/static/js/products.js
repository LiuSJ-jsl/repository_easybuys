jQuery(function () {
    jQuery(".p_cl li").click(function () {
        jQuery(this).siblings('li').removeClass('checked');  // 删除其他兄弟元素的样式
        jQuery(this).addClass('checked');                            // 添加当前元素的样式
        var vchecked = jQuery(this).text();
    });
    jQuery(".P_clas li").click(function () {
        jQuery(this).siblings('li').removeClass('checked');  // 删除其他兄弟元素的样式
        jQuery(this).addClass('checked');                            // 添加当前元素的样式
        var songs = jQuery(this).text();
    });
});