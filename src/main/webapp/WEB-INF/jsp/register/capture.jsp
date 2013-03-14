<%@ include file="/WEB-INF/jsp/contenido_antes.jsp" %>
<form:form action="save_capture" method="post" modelAttribute="formRegister" id="formRegister" name="formRegister">
	<div class="row">
		<div class="span12">		    		    
		    <div class="alert alert-info">
		    Ventana de captura 	
		    </div>
		</div>
	</div>
	<fieldset>		
		<div class="row">
			<div class="span9">			
			
				<label>Instituci&oacuten de procedencia</label>
				<span class="obligatorio">*</span>
				<form:select path="idInstitucionProcedencia">
					<form:option value="" label="--- Seleccione ---"/>
					<form:options items="${universities}" itemValue="id" itemLabel="name" />
				</form:select>
				<spring:hasBindErrors name="formRegister">
					<span class="label label-important">
						<form:errors path="idInstitucionProcedencia" />
					</span>
				</spring:hasBindErrors>
				
				<label>Nombre</label>
				<span class="obligatorio">*</span>																
				<form:input path="nombre"/>
				<spring:hasBindErrors name="formRegister">
					<span class="label label-important">
						<form:errors path="nombre" />
					</span>
				</spring:hasBindErrors>

				<label>Apellido paterno</label>
				<span class="obligatorio">*</span>
				<form:input path="apellidoPaterno"/>
				<spring:hasBindErrors name="formRegister">
					<span class="label label-important">
						<form:errors path="apellidoPaterno" />
					</span>
				</spring:hasBindErrors>
				
				<label>Apellido materno</label>
				<span class="obligatorio">*</span>
				<form:input path="apellidoMaterno"/>
				<spring:hasBindErrors name="formRegister">
					<span class="label label-important">
						<form:errors path="apellidoMaterno" />
					</span>
				</spring:hasBindErrors>
								
				<label>Ocupaci&oacuten</label>
				<span class="obligatorio">*</span>
				<form:select path="idOcupacion">
					<form:option value="" label="--- Seleccione ---"/>
					<form:options items="${ocupations}" itemValue="id" itemLabel="name" />
				</form:select>
				<spring:hasBindErrors name="formRegister">
					<span class="label label-important">
						<form:errors path="idOcupacion" />
					</span>
				</spring:hasBindErrors>
			</div>
			
			<div class="span9">
				<button class="btn btn-info" type="submit">Registrar</button>
			</div>
		</div>
	</fieldset>				
</form:form>

<%@ include file="/WEB-INF/jsp/contenido_despues.jsp" %>
<script type='text/javascript' src='${pageContext.request.contextPath}/recursos/js/register.js'></script>