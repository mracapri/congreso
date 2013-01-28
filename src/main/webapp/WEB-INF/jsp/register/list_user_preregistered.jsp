<%@ include file="/WEB-INF/jsp/contenido_antes.jsp"%>
<form class="form-search" action="${pageContext.request.contextPath}/resolver/register/list_user_preregistered">
	<input name="search-param" type="text" class="input-medium search-query" placeholder="nombre, correo" value="${param['search-param']}"/>
	<button type="submit" class="btn">Buscar registro</button>
	<select id="university">
		<option id="0">SIN FILTRO</option>
		<c:forEach var="university" items="${universities}">
			<option id="${university.id}">${university.name}</option>
		</c:forEach>
	</select>
</form>
<table id="preregistrados" class="table">
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Correo</th>
			<th>Oupacion</th>
			<th>Universidad</th>
			<th>Pago</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="preRegister" items="${preRegisters}">
			<tr id-university="${preRegister.university.id}">
				<td style="color: blue;">${preRegister.name} ${preRegister.secondName} ${preRegister.thirdName}</td>
				<td>${preRegister.informationAccount.email}</td>
				<td>${preRegister.ocupation.name}</td>
				<td>${preRegister.university.name}</td>								
				<c:choose>
				    <c:when test="${preRegister.paymentStatus=='NO_PAGADO'}">
				       <td><a href="${pageContext.request.contextPath}/resolver/payment/form/${preRegister.informationAccount.token}" class="btn btn-danger btn-block">NO</a></td>
				    </c:when>
				    <c:when test="${preRegister.paymentStatus=='PAGADO'}">
				        <td><a href="${pageContext.request.contextPath}/resolver/payment/form/${preRegister.informationAccount.token}" class="btn btn-success btn-block">SI</a></td>
				    </c:when>
				</c:choose>
			</tr>
		</c:forEach>
	</tbody>
</table>
<script type="text/javascript">
	$(document).ready(function(){
		$("#university").change(function(){
			var idUniversity = $("#university > option:selected").attr("id");
			if(idUniversity == 0){
				$("table#preregistrados tbody > tr").show();
			}else{
				$("table#preregistrados tbody > tr").hide();
				$.each($("table#preregistrados tbody > tr"), function(key, value){					
					if(idUniversity == $(value).attr("id-university")){
						$(value).show();
					}
				});
			}		
		});
	});
</script>
<%@ include file="/WEB-INF/jsp/contenido_despues.jsp"%>