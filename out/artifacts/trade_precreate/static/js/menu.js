// JavaScript Document

var jq = jQuery.noConflict();
jQuery(function() {
	jq(".leftNav ul li").on({
		mouseenter : function() {
			jq(this).find(".fj").addClass("nuw");
			jq(this).find(".zj").show();
			var params = this.id;

		},
		mouseleave : function() {
			jq(this).find(".fj").removeClass("nuw");
			jq(this).find(".zj").hide();
		}
	})
})
