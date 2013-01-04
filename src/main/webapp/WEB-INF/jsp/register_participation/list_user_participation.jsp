<%@ include file="/WEB-INF/jsp/contenido_antes.jsp"%>
<form class="form-search" action="${pageContext.request.contextPath}/resolver/register_participation/list_user_participation">
	<input name="search-param" type="text" class="input-medium search-query" placeholder="nombre, correo" value="${param['search-param']}"/>
	<button type="submit" class="btn">Buscar registro</button>
</form>
<table class="table">
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Correo</th>
			<th>Oupacion</th>
			<th>Universidad</th>
			<th>Telefono</th>
			<th>PDF</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="participant" items="${participants}">
			<tr>
				<td style="color: blue;">${participant.name} ${participant.secondName} ${participant.thirdName}</td>
				<td>${participant.informationAccount.email}</td>
				<td>${participant.ocupation.name}</td>
				<td>${participant.university.name}</td>
				<td>${participant.phone}</td>
				<td>
					<a class="btn popup-detail" 
						data-content="
							<p style='word-wrap: break-word;'>
								<strong>Nombre participaci&oacuten:</strong>
								${participant.participationName}
							</p>
							<br/>
							<p style='word-wrap: break-word;'>
								<strong>Nombre archivo:</strong>
								${participant.participationFileName}
							</p>
							<br/>						
							<a class='btn btn-success' target='_blank' href='${pageContext.request.contextPath}/resolver/register_participation/show_pdf_file/${participant.informationAccount.token}'>
								Decargar
							<a/>" 
						rel="popover" 
						data-original-title="Detalles del archivo">
						<i class="icon-file">
						</i>
					</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<script type="text/javascript">
	$(document).ready(function(){	
		$('.popup-detail').popover({placement:"bottom"});
	});
</script>
<%@ include file="/WEB-INF/jsp/contenido_despues.jsp"%>