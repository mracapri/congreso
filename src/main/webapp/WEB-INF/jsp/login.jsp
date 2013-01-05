<%@ include file="/WEB-INF/jsp/contenido_antes.jsp" %>
<form id="loginForm" action="${pageContext.request.contextPath}/j_spring_security_check" method="post">
	<div class="row">
		<div class="span12">		    		    
		    <div class="alert alert-info">
		    	<strong>Inicie sesi&oacuten</strong>
		    </div>
		    Introduzca sus crendenciales de acceso		    
		</div>
	</div>
	<fieldset>
		<div class="row">
			<div class="span9">
				<c:if test="${param['message'] != null }">
				    <div class="alert">
				    	<button type="button" class="close" data-dismiss="alert">&times;</button>
				    	<strong>
							${param['message']}
				    	</strong>
				    </div>
			    </c:if>
			</div>
			<div class="span9">

				<label>Usuario</label> <span class="obligatorio">*</span>
				<input id="j_username" name="j_username" type="text" />
				<label>Clave</label> <span class="obligatorio">*</span>
				<input id="j_password" name="j_password" type="password" />
				${recaptchaHtml}
			</div>
			<div class="span9">
				<button class="btn btn-info" type="submit">Entrar</button>
			</div>
		</div>
	</fieldset>		
</form>
<%@ include file="/WEB-INF/jsp/contenido_despues.jsp" %>
<script type="text/javascript">
var RecaptchaOptions = {
   lang : 'es',
};
</script>