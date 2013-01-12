<%@ include file="/WEB-INF/jsp/contenido_antes.jsp" %>
		
<h3>
	Galeria de imagenes	
</h3>

<!-- Start of Flickr Badge -->
<style type="text/css">

#flickr_badge_source_txt {
    color: #666666;
    font: 11px Arial,Helvetica,Sans serif;
    padding: 0;
}
#flickr_badge_icon {
    border: 1px solid #000000 !important;
    display: block !important;
    margin: 0 !important;
}
#flickr_icon_td {
    padding: 0 5px 0 0 !important;
}
.flickr_badge_image {
    text-align: center !important;
}
.flickr_badge_image img {
    border: 1px solid gray !important;
}
#flickr_badge_uber_wrapper {
    width: 150px;
}
#flickr_www {
    color: #3993FF !important;
    display: block;
    font: 11px Arial,Helvetica,Sans serif !important;
    padding: 0 10px !important;
    text-align: center;
}
#flickr_badge_uber_wrapper a:hover, #flickr_badge_uber_wrapper a:link, #flickr_badge_uber_wrapper a:active, #flickr_badge_uber_wrapper a:visited {
    background: inherit !important;
    color: #3993FF;
    text-decoration: none !important;
}
#flickr_badge_wrapper {
    background-color: #FFFFFF;
}
#flickr_badge_source {
    color: #666666 !important;
    font: 11px Arial,Helvetica,Sans serif !important;
    padding: 0 !important;
}

</style>

<script type="text/javascript">
$(document).ready(function(){
	$("a[href*='http://www.flickr.com/photos/']").attr("target", "_blank");
	var photos = $("a[href*='http://www.flickr.com/photos/']");
	$.each(photos, function(key, value){
		var url = $(value).attr("href") + "in/photostream/lightbox/";
		$(value).attr("href", url);
	});
});
</script>

<table id="flickr_badge_uber_wrapper" cellpadding="0" cellspacing="10" border="0">
	<tr>
		<td>
			<table cellpadding="0" cellspacing="10" border="0" id="flickr_badge_wrapper">
				<script type="text/javascript" src="http://www.flickr.com/badge_code_v2.gne?show_name=1&count=3&display=latest&size=s&layout=v&source=user&user=92136115%40N07"></script>
			</table>
		</td>
	</tr>
</table>
<!-- End of Flickr Badge -->

<%@ include file="/WEB-INF/jsp/contenido_despues.jsp" %>