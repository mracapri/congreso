<%@ include file="/WEB-INF/jsp/contenido_antes.jsp" %>
<div class="row">
	<div class="span12">
	    <div class="alert alert-info">
	    	<strong>Informaci&oacuten Fiscal</strong><br/><br/>
			<p>
				El siguiente formulario, permitir&aacute registrar su informaci&oacuten fiscal en caso de que
				requiera se le factura 
			</p>
	    </div>
	</div>
</div>
<form:form action="save" method="post" modelAttribute="formFiscalData" id="formFiscalData" name="formFiscalData">
	<fieldset>
		<div class="row">
			<div class="span9">			
			
				<label>Nombre fiscal</label>
				<span class="obligatorio">*</span>
				<form:input path="nombreFiscal"/>
				<spring:hasBindErrors name="formFiscalData">
					<span class="label label-important">
						<form:errors path="nombreFiscal" />
					</span>
				</spring:hasBindErrors>
				
				<label>RFC</label>
				<span class="obligatorio">*</span>
				<form:input path="rfc"/>
				<spring:hasBindErrors name="formFiscalData">
					<span class="label label-important">
						<form:errors path="rfc" />
					</span>
				</spring:hasBindErrors>
				
				<label>Direcci&oacuten</label>
				<span class="obligatorio">*</span>
				<form:textarea path="direccion" rows="8" cols="30"/>
				<spring:hasBindErrors name="formFiscalData">
					<span class="label label-important">
						<form:errors path="direccion" />
					</span>
				</spring:hasBindErrors>
			</div>
			
			<div class="span9">
				<button class="btn btn-info" type="submit">Guardar</button>
			</div>
		</div>
	</fieldset>				
</form:form>

<%@ include file="/WEB-INF/jsp/contenido_despues.jsp" %>
<script type='text/javascript' src='${pageContext.request.contextPath}/recursos/js/register.js'></script>