<%@ include file="/WEB-INF/jsp/contenido_antes.jsp" %>

<form:form action="${pageContext.request.contextPath}/resolver/payment/save" method="post"
	modelAttribute="formPaymentData" id="formPaymentData"
	name="formPaymentData">
	<div class="alert alert-block">
		<button type="button" class="close" data-dismiss="alert">&times;</button>
		<h4>Atenci&oacuten!</h4>
		Para cambiar el estado de pago del participante, hagalo cambiando en
		los botones debajo y seleccione aceptar
	</div>	
	<form:hidden path="token"/>
	<label class="checkbox">
		<form:radiobutton path="status" value="true"/>
	  	Pagado
	</label>
	
	<label class="checkbox">
		<form:radiobutton path="status" value="false"/>		
		No pagado
	</label>
	<br/>
	<button type="submit" class="btn btn-info">Cambiar estado del pago</button>
</form:form>

<%@ include file="/WEB-INF/jsp/contenido_despues.jsp" %>
<script type='text/javascript' src='${pageContext.request.contextPath}/recursos/js/register.js'></script>