<%@ include file="/WEB-INF/jsp/include.jsp" %>
<html>
	<head>
		<%@ include file="/WEB-INF/jsp/resources.jsp" %>
	</head>
	<style>
		.label-wrap, .label-wrap-name{
			width:200px;
			display:block;
			word-wrap:break-word;
			color: gray;
			font-size: 12px;
		}
		
		.label-wrap-name{
			color: black;
		}
	</style>
	<body>
		<table id="preregistrados" class="table">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Pagado</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="preRegister" items="${preRegisters}">
					<tr id-university="${preRegister.university.id}">
						<td style="color: blue;">
							<span class="label-wrap-name">
								${preRegister.name} 
								${preRegister.secondName} 
								${preRegister.thirdName}
							</span>
							<span class="label-wrap">
								${preRegister.informationAccount.email}
							</span>
						</td>								
						<c:choose>
						    <c:when test="${preRegister.paymentStatus=='NO_PAGADO'}">
						       <td><a class="btn btn-danger btn-mini">NO</a></td>
						    </c:when>
						    <c:when test="${preRegister.paymentStatus=='PAGADO'}">
						        <td><a class="btn btn-success btn-mini">SI</a></td>
						        <td><a href="${pageContext.request.contextPath}/resolver/register/confirm-assistence/${preRegister.informationAccount.token}" class="btn btn-mini confirm-assistence">Confirmar asistencia</a></td>
						    </c:when>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
	<script>
		$(document).ready(function(){
			$(".confirm-assistence").click(function(){
				$this = this;
				$.ajax({
					url: $($this).attr("href"),
					type: "GET",
					dataType: "json",
					success:function(data){
						alert(data.result);
					}
				});
				return false;
			});
		});
	</script>
</html>

