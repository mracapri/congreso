<%@ include file="/WEB-INF/jsp/contenido_antes.jsp"%>
<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&#215;</button>
		<h3 id="myModalLabel">Acceso no autorizado</h3>
	</div>
	<div class="modal-body">
		Lamentamos informarle que en esta secci&oacuten del portal, no cuenta
		con la autoridad suficiente para entrar.
	</div>
	<div class="modal-footer">
		<a class="btn btn-danger" href="${pageContext.request.contextPath}/resolver/index.htm?unshow-message">Cerrar</a>
	</div>
</div>
<%@ include file="/WEB-INF/jsp/contenido_despues.jsp"%>
<script type="text/javascript">
	$(document).ready(function(){	
		$('#myModal').modal('show');
	});
</script>