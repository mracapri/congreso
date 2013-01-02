<%@ include file="/WEB-INF/jsp/contenido_antes.jsp" %>
<form:form action="save" method="post" modelAttribute="formRegister" id="formRegister" name="formRegister">

	<div class="row">
		<div class="span12">		    		    
		    <div class="alert alert-info">
		    	<strong>Preregistro</strong>
		    	<ul>
			    	<li>$400.00 M.N hasta el 31 de Enero del 2013</li>
			    	<li>$450.00 M.N a partir del 1 de Febrero del 2013</li>
		    	</ul>
		    
		    	<strong>Instrucciones</strong>
		    	<ol>
			    	<li>Realice su pregregistro en el siguiente formulario de captura</li>
			    	<li>Confirme su cuenta de usuario, a travez del correo electronico</li>
			    	<li>Inicie sesion en el sitio para generar su ficha de deposito</li>
			    	<li>
			    		Envie su ficha de deposito, escaneada al siguiente correo 
			    		<a href="mailto:#">finanzas@utvm.edu.mx</a> 
			    		para confirmar su pago en el sistema
			    	</li>
		    	</ol>
		    </div>
		</div>
	</div>
    
	<fieldset>
		<div class="row">
			<div class="span9">
				<label>Correo electronico</label>
				<span class="obligatorio">*</span>
				<form:input path="correoElectronico"/>								
				<spring:hasBindErrors name="formRegister">
					<span class="label label-important">
						<form:errors path="correoElectronico" />
					</span>
				</spring:hasBindErrors>
				
				<label>Confirmar correo electronico</label>
				<span class="obligatorio">*</span>								
				<form:input path="confirmarcorreoElectronico"/>								
				<spring:hasBindErrors name="formRegister">
					<span class="label label-important">
						<form:errors path="confirmarcorreoElectronico" />
					</span>
				</spring:hasBindErrors>

				<label>Clave</label>
				<span class="obligatorio">*</span>
				<form:password path="clave"/>
				<spring:hasBindErrors name="formRegister">
					<span class="label label-important">
						<form:errors path="clave" />
					</span>
				</spring:hasBindErrors>
				
				<label>Confirmar clave</label>
				<span class="obligatorio">*</span>
				<form:password path="confirmacionClave"/>
				<spring:hasBindErrors name="formRegister">
					<span class="label label-important">
						<form:errors path="confirmacionClave" />
					</span>
				</spring:hasBindErrors>
				
				<spring:hasBindErrors name="formRegister">
					<span class="label label-important">
						<form:errors path="claveValidator" />
					</span>
				</spring:hasBindErrors>
			</div>
		</div>
		
		<div class="row">
			<div class="span9">			
			
				<label>Institucion de procedencia</label>
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
				
				<label>Telefono</label>
				<span class="obligatorio">*</span>
				<form:input path="telefono"/>
				<spring:hasBindErrors name="formRegister">
					<span class="label label-important">
						<form:errors path="telefono" />
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