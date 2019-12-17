jQuery(document).ready(function() {
	jQuery(".add_tab").hide();
	jQuery('.a_hide').hide();
	jQuery(".mem_tit").on('click',function(){
		jQuery(".add_tab").show();
		jQuery('.a_hide').show();
	}
	);
	jQuery(".empty").on("click",function(){
		jQuery('.add_ipt').val("");
		jQuery(".add_tab").hide();
		jQuery('.a_hide').hide();
	});
		var result='';
	jQuery(".add_b").on("click",function()
	{

	jQuery(".add_ipt").each(function(){
    	result=result+ jQuery(this).val()+',';
    	
	});	
	jQuery("#appe").append(' <div id="appe">\n' +
		'            \t<div class="address">\n' +
		'            \t<div class="a_close" onclick="cls(this)"><a href="#"><img src="images/a_close.png" /></a></div>\n' +
		'            \t<table border="0" class="add_t" align="center" style="width:98%; margin:10px auto;" cellspacing="0" cellpadding="0">\n' +
		'                  <tr>\n' +
		'                    <td colspan="2" style="font-size:14px; color:#ff4e00;">杨杨公司</td>\n' +
		'                  </tr>\n' +
		'                  <tr>\n' +
		'                    <td align="right" width="80">收货人姓名：</td>\n' +
		'                    <td>杨杨</td>\n' +
		'                  </tr>\n' +
		'                  <tr>\n' +
		'                    <td align="right">配送区域：</td>\n' +
		'                    <td>四川成都市武侯区三环以内</td>\n' +
		'                  </tr>\n' +
		'                  <tr>\n' +
		'                    <td align="right">详细地址：</td>\n' +
		'                    <td>科华北路66号世外桃源写字楼3楼</td>\n' +
		'                  </tr>\n' +
		'                  <tr>\n' +
		'                    <td align="right">手机：</td>\n' +
		'                    <td>12345678998</td>\n' +
		'                  </tr>\n' +
		'                  <tr>\n' +
		'                    <td align="right">电话：</td>\n' +
		'                    <td>028-12345678</td>\n' +
		'                  </tr>\n' +
		'                  <tr>\n' +
		'                    <td align="right">电子邮箱：</td>\n' +
		'                    <td>123456789@qq.com</td>\n' +
		'                  </tr>\n' +
		'                  \n' +
		'                </table>\n' +
		'\t\t\t\t\n' +
		'                <p align="right">\n' +
		'                \t<a href="#" style="color:#ff4e00;">设为默认</a>&nbsp; &nbsp; &nbsp; &nbsp; <a href="#" style="color:#ff4e00;">编辑</a>&nbsp; &nbsp; &nbsp; &nbsp; \n' +
		'                </p>\n' +
		'\n' +
		'          \t\t</div>');
	var all = new Array();
	all=result.split(',');
	console.log(all[0]);
//	console.log(result);
	});
	
	

        

	

});



function cls(ob){
	ob.parentNode.parentNode.removeChild(ob.parentNode);
};