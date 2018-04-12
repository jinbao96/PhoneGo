/**
 * 分页效果
 */
var pagination=function (pageNum,allPage) {
		//如果当前页为第一页
		if(pageNum<=1){
			//禁用上一页
			jQuery("li:contains('上一页')").click(function() {
				return false;
			}).addClass("disabled");
		}
		//如果当前也为最后一页
		if(pageNum>=allPage){
			//禁用下一页
			jQuery("li:contains('下一页')").click(function() {
				return false;
			}).addClass("disabled");
		}
		//设置激活样式
		jQuery("li:contains("+pageNum+")").addClass("active");
}