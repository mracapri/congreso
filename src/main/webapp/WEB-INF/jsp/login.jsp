<%@ include file="/WEB-INF/jsp/contenido_antes.jsp" %>
		
	<form id="loginForm" action="${pageContext.request.contextPath}/j_spring_security_check" method="post">		
		<fieldset>
			<legend>Acceso</legend>
			<div class="row">
				<div class="span9">
	
					<label>Usuario</label> <span class="obligatorio">*</span>
					<input id="j_username" name="j_username" type="text" />
					<label>Clave</label> <span class="obligatorio">*</span>
					<input id="j_password" name="j_password" type="password" />
				</div>
				<div class="span9">
					<button class="btn btn-info" type="submit">Registrar</button>
				</div>
			</div>
		</fieldset>		
		
		

	</form>

<%@ include file="/WEB-INF/jsp/contenido_despues.jsp" %>