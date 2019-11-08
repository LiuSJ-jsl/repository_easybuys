$(function() {
	var _del_time_list = $("select[name='del_time_list']");
	var _del_table_name = $("select[name='del_table_name']");
	var _button = $("input[type='button']");
	var now_date = new Date();
	DelTable = function() {
		this.getTimeList = function() {
			year = now_date.getFullYear();
			month = now_date.getMonth();
			_del_time_list.html("");
			_HTML = "";
			for(mon = 1; mon <= parseInt(month); mon++) {
				if(mon < 10) {
					mon = "0" + mon;
				}
				_HTML = _HTML + "<option>" + year + mon + "</option>";
			}
			_del_time_list.html(_HTML);
		}
		this.delFun = function() {
			var data = {};
			data.table = _del_table_name.val();
			data.date = _del_time_list.find("option:selected").text();
			var successfn = function(jdata) {
				alert(jdata);
			}
			var errorfn = function(jdata) {
				alert("请求
				出错");
			}
			$.ajax({
				type: "get",
				/**data: data ajax请求的参数**/ data: data,
				url: "/DEVOPS/index.php/Monitor/delTable",
				dataType: "text",
				success: function(d) {
					successfn(d);
				},
				error: function(e) {
					errorfn(e);
				}
			});
		}
	} /*****http://192.168.32.161/DEVOPS/index.php/Monitor/delTable?table=history&date=201601 ****/
	var DelTableObj = new DelTable();
	DelTableObj.getTimeList();
	_button.on('click', function() {
		DelTableObj.delFun();
	}) _del_table_name.on('change', function() {
		DelTableObj.getTimeList();
	})
})