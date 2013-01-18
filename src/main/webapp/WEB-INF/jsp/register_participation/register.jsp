<%@ include file="/WEB-INF/jsp/contenido_antes.jsp" %>
<div class="row">
	<div class="span12">
	    <div class="alert alert-info">
	    	<strong>Registro de participaci&oacuten en el Congreso</strong><br/><br/>
			<p>
				El siguiente formulario, permitir&aacute registrar su informaci&oacuten de 
				participaci&oacuten en el congreso.
			</p>
			<a target="_blank" href="${pageContext.request.contextPath}/recursos/docs/Instrucciones_presentacion_extensos.pdf">
				<i class="icon-book"></i>
				Descargar instrucciones para extensos
			</a>
			<a target="_blank" href="${pageContext.request.contextPath}/recursos/docs/Instrucciones_presentacion_resumenes_trabajos.pdf">
				<i class="icon-book"></i>
				Descargar instrucciones para res&uacutemenes
			</a>
	    </div>
	</div>
</div>
<form:form action="save" method="post"
	modelAttribute="formRegisterParticipation"
	id="formRegisterParticipation" name="formRegisterParticipation"
	enctype="multipart/form-data">
	<fieldset>
		<div class="row">
			<div class="span9">
				<label>Correo electr&oacutenico</label> <span class="obligatorio">*</span>
				<form:input path="correoElectronico" />
				<spring:hasBindErrors name="formRegisterParticipation">
					<span class="label label-important"> <form:errors
							path="correoElectronico" />
					</span>
				</spring:hasBindErrors>

				<label>Confirmar correo electr&oacutenico</label> <span
					class="obligatorio">*</span>
				<form:input path="confirmarcorreoElectronico" />
				<spring:hasBindErrors name="formRegisterParticipation">
					<span class="label label-important"> <form:errors
							path="confirmarcorreoElectronico" />
					</span>
				</spring:hasBindErrors>

				<label>Clave</label> <span class="obligatorio">*</span>
				<form:password path="clave" />
				<spring:hasBindErrors name="formRegisterParticipation">
					<span class="label label-important"> <form:errors
							path="clave" />
					</span>
				</spring:hasBindErrors>

				<label>Confirmar clave</label> <span class="obligatorio">*</span>
				<form:password path="confirmacionClave" />
				<spring:hasBindErrors name="formRegisterParticipation">
					<span class="label label-important"> <form:errors
							path="confirmacionClave" />
					</span>
				</spring:hasBindErrors>

				<spring:hasBindErrors name="formRegisterParticipation">
					<span class="label label-important"> <form:errors
							path="claveValidator" />
					</span>
				</spring:hasBindErrors>
			</div>
		</div>
		
		<div class="row">
			<div class="span9">

				<label>Institucion de procedencia</label> <span class="obligatorio">*</span>
				<form:select path="idInstitucionProcedencia">
					<form:option value="" label="--- Seleccione ---"/>
					<form:options items="${universities}" itemValue="id" itemLabel="name" />
				</form:select>
				<spring:hasBindErrors name="formRegisterParticipation">
					<span class="label label-important"> <form:errors
							path="idInstitucionProcedencia" />
					</span>
				</spring:hasBindErrors>

				<label>Nombre</label> <span class="obligatorio">*</span>
				<form:input path="nombre" />
				<spring:hasBindErrors name="formRegisterParticipation">
					<span class="label label-important"> <form:errors
							path="nombre" />
					</span>
				</spring:hasBindErrors>

				<label>Apellido paterno</label> <span class="obligatorio">*</span>
				<form:input path="apellidoPaterno" />
				<spring:hasBindErrors name="formRegisterParticipation">
					<span class="label label-important"> <form:errors
							path="apellidoPaterno" />
					</span>
				</spring:hasBindErrors>

				<label>Apellido materno</label> <span class="obligatorio">*</span>
				<form:input path="apellidoMaterno" />
				<spring:hasBindErrors name="formRegisterParticipation">
					<span class="label label-important"> <form:errors
							path="apellidoMaterno" />
					</span>
				</spring:hasBindErrors>

				<label>Tel&eacutefono</label> <span class="obligatorio">*</span>
				<form:input path="telefono" />
				<spring:hasBindErrors name="formRegisterParticipation">
					<span class="label label-important"> <form:errors
							path="telefono" />
					</span>
				</spring:hasBindErrors>

				<label>Ocupaci&oacuten</label> <span class="obligatorio">*</span>
				<form:select path="idOcupacion">
					<form:option value="" label="--- Seleccione ---"/>
					<form:options items="${ocupations}" itemValue="id" itemLabel="name" />
				</form:select>
				<spring:hasBindErrors name="formRegisterParticipation">
					<span class="label label-important"> <form:errors
							path="idOcupacion" />
					</span>
				</spring:hasBindErrors>


				<label>Nombre participaci&oacuten</label> <span class="obligatorio">*</span>
				<form:input path="nombreDeLaParticipacion" />
				<spring:hasBindErrors name="formRegisterParticipation">
					<span class="label label-important"> <form:errors
							path="nombreDeLaParticipacion" />
					</span>
				</spring:hasBindErrors>


				<label>Tipo participaci&oacuten</label> <span class="obligatorio">*</span>
				<form:select path="idTipoParticipacion">
					<form:option value="" label="--- Seleccione ---"/>
					<form:options items="${participations}" itemValue="id" itemLabel="name" />
				</form:select>
				<spring:hasBindErrors name="formRegisterParticipation">
					<span class="label label-important"> <form:errors
							path="idTipoParticipacion" />
					</span>
				</spring:hasBindErrors>
				
				<label>Archivo PDF</label> <span class="obligatorio">*</span>
				<form:input path="archivo" type="file"/>
				<spring:hasBindErrors name="formRegisterParticipation">
					<span class="label label-important"> <form:errors
							path="archivo" />
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