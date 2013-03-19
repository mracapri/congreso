<%@ include file="/WEB-INF/jsp/contenido_antes.jsp" %>
<form:form action="save_capture" method="post" modelAttribute="formCapture" id="formCapture" name="formCapture">
	<div class="row">
		<div class="span12">		    		    
		    <div class="alert alert-info">
		    Ventana de captura 	
		    </div>
		</div>
	</div>
	
	<c:if test="${param['captured'] == 1}">
		<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&#215;</button>
				<h3 id="myModalLabel">Ventanilla de captura</h3>
			</div>
			<div class="modal-body">
				¡¡Registrado!!
			</div>
			<div class="modal-footer">
				<a class="btn btn-success" href="#" data-dismiss="modal">Cerrar</a>
			</div>
		</div>
		<script type="text/javascript">
			$(document).ready(function(){	
				$('#myModal').modal('show');
			});
		</script>
	</c:if>
	<fieldset>		
		<div class="row">
			<div class="span6">			
			
				<label>Instituci&oacuten de procedencia</label>
				<span class="obligatorio">*</span>
				<form:select path="idInstitucionProcedencia">
					<form:option value="" label="--- Seleccione ---"/>
					<form:options items="${universities}" itemValue="id" itemLabel="name" />
				</form:select>
				<spring:hasBindErrors name="formCapture">
					<span class="label label-important">
						<form:errors path="idInstitucionProcedencia" />
					</span>
				</spring:hasBindErrors>
				
				<label>Nombre</label>
				<span class="obligatorio">*</span>																
				<form:input path="nombre"/>
				<spring:hasBindErrors name="formCapture">
					<span class="label label-important">
						<form:errors path="nombre" />
					</span>
				</spring:hasBindErrors>

				<label>Apellido paterno</label>
				<span class="obligatorio">*</span>
				<form:input path="apellidoPaterno"/>
				<spring:hasBindErrors name="formCapture">
					<span class="label label-important">
						<form:errors path="apellidoPaterno" />
					</span>
				</spring:hasBindErrors>
				
				<label>Apellido materno</label>
				<span class="obligatorio">*</span>
				<form:input path="apellidoMaterno"/>
				<spring:hasBindErrors name="formCapture">
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
				<spring:hasBindErrors name="formCapture">
					<span class="label label-important">
						<form:errors path="idOcupacion" />
					</span>
				</spring:hasBindErrors>
				

				<label>Correo electr&oacutenico</label>
				<span class="obligatorio">*</span>
				<form:input path="correoElectronico"/>
				<spring:hasBindErrors name="formCapture">
					<span class="label label-important">
						<form:errors path="correoElectronico" />
					</span>
				</spring:hasBindErrors>
				<div class="span9">
					<button class="btn btn-info" type="submit">Registrar</button>
				</div>
			</div>
			<div class="span6">
				<input id="search-param" type="text" class="input-medium search-query" placeholder="nombre, correo"/>
				<button type="button" class="btn btn-inverse" id="search-assistent">Buscar asistente</button>
				<div id="list-assistence"></div>
			</div>

		</div>
	</fieldset>				
</form:form>
<script type='text/javascript' src='${pageContext.request.contextPath}/recursos/js/register.js'></script>
<script>
	$(document).ready(function(){
		$("#search-assistent").live('click',function(){
			if(!$("#search-param").val() == ''){
				$.ajax({
					url: "${pageContext.request.contextPath}/resolver/register/list_assistence",
					type: "GET",
					data: {'search-param' : $("#search-param").val()},
					dataType: "html",
					success:function(result){
						$("#list-assistence").empty();
						$("#list-assistence").html(result);	
					}
				});
			}else{
				$("#list-assistence").empty();	
			}
		});
	});
</script>
<%@ include file="/WEB-INF/jsp/contenido_despues.jsp" %>