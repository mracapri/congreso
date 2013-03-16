<%@ include file="/WEB-INF/jsp/contenido_antes.jsp" %>
<form:form action="save_modification" method="post" modelAttribute="formModification" id="formModification" name="formModification">
	<div class="row">
		<div class="span12">		    		    
		    <div class="alert alert-info">
		    Ventana de Modificaci&oacuten de Nombre 	
		    </div>
		    <div class="alert alert-danger">
		    Es de suma importancia corregir tus datos personales, ya que con ellos se imprimiran las contancias del congreso	
		    </div>
		</div>
	</div>
	<fieldset>		
		<div class="row">
			<div class="span9">			
			
				
				<label>Nombre</label>
				<span class="obligatorio">*</span>																
				<form:input path="nombre"/>
				<spring:hasBindErrors name="formModification">
					<span class="label label-important">
						<form:errors path="nombre" />
					</span>
				</spring:hasBindErrors>

				<label>Apellido paterno</label>
				<span class="obligatorio">*</span>
				<form:input path="apellidoPaterno"/>
				<spring:hasBindErrors name="formModification">
					<span class="label label-important">
						<form:errors path="apellidoPaterno" />
					</span>
				</spring:hasBindErrors>
				
				<label>Apellido materno</label>
				<span class="obligatorio">*</span>
				<form:input path="apellidoMaterno"/>
				<spring:hasBindErrors name="formModification">
					<span class="label label-important">
						<form:errors path="apellidoMaterno" />
					</span>
				</spring:hasBindErrors>
				
			</div>
			
			<div class="span9">
				<button class="btn btn-info" type="submit">Modificar</button>
			</div>
		</div>
	</fieldset>				
</form:form>

<%@ include file="/WEB-INF/jsp/contenido_despues.jsp" %>
<script type='text/javascript' src='${pageContext.request.contextPath}/recursos/js/register.js'></script>