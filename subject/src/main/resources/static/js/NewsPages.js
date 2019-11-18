jQuery(document).ready(function () {
    function newsPages() {
        jQuery.getJSON("servlet/NewsPageServlet", page);

        function page(data) {
            var $newPages = jQuery(".mem_tab").empty();
            var news = data.newsList
            $newPages.append("<tr>"
                + "<td width=\"500\" style=\"text-align: center;\">文章标题</td><td width=\"430\" style=\"text-align: center;\">创建时间</td>"
            )

            for (var a = 0; a < news.length; a++) {
                $newPages.append("<tr>"
                    + "<td width=\"500\" style=\"text-align: center;\"><a class='dian' id='" + news[a].id + "' href='javascript:;'>" + news[a].title + "</a></td>"
                    + "<td width=\"430\" style=\"text-align: center;\">" + news[a].createTime + "</td>"
                    + "</tr>");
            }
            var $page = jQuery(".pages").empty();
            $first = jQuery("<a href=\"javascirpt:;\" class=\"p_pre\">上一页</a>").click(function () {
                jQuery.getJSON("servlet/NewsPageServlet", "pageIndex=" + ((data.currPageNo - 1) < 0 ? 1 : (data.currPageNo - 1)), page);
            });
            $page.append($first);
            for (var i = 1; i <= data.totalPageCount; i++) {
                $middle = jQuery("<a href=\"javascirpt:;\" id = \"" + i + "\">" + i + "</a>").click(function () {
                    jQuery.getJSON("servlet/NewsPageServlet", "pageIndex=" + this.id, page);
                });
                $page.append($middle)
            }
            $last = jQuery("<a href=\"javascirpt:;\" class=\"p_pre\">下一页</a>").click(function () {
                jQuery.getJSON("servlet/NewsPageServlet", "pageIndex=" + ((data.currPageNo + 1) > (data.totalPageCount) ? (data.totalPageCount) : (data.currPageNo + 1)), page);
            });

            $page.append($last);
        }
    }

    newsPages();
    jq(".m_right").on("click", ".dian", function () {
        var aa = this.id
        var $newPages = jQuery(".m_right").empty();
        jQuery.getJSON("servlet/NewsPageServlet", "id=" + aa, page);

        function page(data) {
            $newPages.append("<h3>" + data[0].title + "</h3><div>" + data[0].content + "</div>");
        }
    });
    jq(".p_cl li").click(function () {
        jq(this).toggleClass("checked")
    });

});