jQuery(document).ready(function($) {
	var $showUser = jQuery(".m_right");
	var $leftLinks = $(".m_left a");
	$leftLinks.eq(6).click(function() {
		$showUser.load("News_showAll.jsp .m_right > *")
	});
});