<%@ include file="/WEB-INF/jsp/contenido_antes.jsp"%>
<table class="table">
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Correo</th>
			<th>Universidad</th>
			<th>Lineas de investigaci&oacuten</th>
			<th>Contacto</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="academic" items="${academics}">
			<tr>
				<td style="color: blue;">${academic.name}</td>
				<td>${academic.informationAccount.email}</td>
				<td>${academic.university.name}</td>
				<td>
					<a class="btn popup-detail" 
						data-content="
							<p style='word-wrap: break-word;'>
								${academic.investigationLines}
							</p>"
						rel="popover" 
						data-original-title="Lineas de investigaci&oacuten">
						<i class="icon-list">
						</i>
					</a>
				</td>
				
				<td>
					<a class="btn popup-detail" 
						data-content="
							<p style='word-wrap: break-word;'>
								${academic.contact}
							</p>"
						rel="popover" 
						data-original-title="Contacto">
						<i class="icon-user">
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