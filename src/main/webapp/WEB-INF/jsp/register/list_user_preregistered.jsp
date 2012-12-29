<%@ include file="/WEB-INF/jsp/contenido_antes.jsp"%>
<table class="table">
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
			<tr>
				<td style="color: blue;">${preRegister.name} ${preRegister.secondName} ${preRegister.thirdName}</td>
				<td>${preRegister.informationAccount.email}</td>
				<td>${preRegister.ocupation.name}</td>
				<td>${preRegister.university.name}</td>								
				<c:choose>
				    <c:when test="${preRegister.paymentStatus=='NO_PAGADO'}">
				       <td><a href="#" class="btn btn-danger btn-block">NO-PAGADO</a></td>
				    </c:when>
				    <c:when test="${preRegister.paymentStatus=='PAGADO'}">
				        <td><a href="#" class="btn btn-success btn-block">PAGADO</a></td>
				    </c:when>
				</c:choose>
			</tr>
		</c:forEach>
	</tbody>
</table>
<%@ include file="/WEB-INF/jsp/contenido_despues.jsp"%>