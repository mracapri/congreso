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
<%@ include file="/WEB-INF/jsp/contenido_despues.jsp"%>