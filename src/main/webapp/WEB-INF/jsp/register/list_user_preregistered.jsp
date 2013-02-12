<%@ include file="/WEB-INF/jsp/contenido_antes.jsp"%>
<style>
	.label-mail-wrap{
		width:200px;
		display:block;
		word-wrap:break-word;
	}
</style>
<form class="form-search" action="${pageContext.request.contextPath}/resolver/register/list_user_preregistered">
	<input name="search-param" type="text" class="input-medium search-query" placeholder="nombre, correo" value="${param['search-param']}"/>
	<button type="submit" class="btn">Buscar</button>

	<br/><br/>
	
	Universidades: 
	<select id="university">
		<option id="0">SIN FILTRO</option>
		<c:forEach var="university" items="${universities}">
			<option id="${university.id}">${university.name}</option>
		</c:forEach>
	</select>
	
	Pagado: 
	<select id="chk-pay">
		<option value="all">TODOS</option>
		<option value="pay">PAGADO</option>
		<option value="nopay">NO PAGADO</option>
	</select>
</form>
<p>
	<span id="wrapper-num-records">
		<b>rows:</b> 
		<span id="num-records"></span>
	</span>
</p>
<table id="preregistrados" class="table">
	<thead>
		<tr>
			<th>Nombre</th>
			<th>RFC</th>
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
				<td>
					<a href="${pageContext.request.contextPath}/resolver/register_fiscal_data/get/${preRegister.informationAccount.token}">
						<li class="icon-eye-open"></li>
					</a>					
				</td>
				<td>
					<span class="label-mail-wrap">
						${preRegister.informationAccount.email}
					</span>
				</td>
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
		
		$("#chk-pay").change(function(){
			$("#university").change();
		});
		
		$("#university").change(function(){
			
			var keyPaymentStatus = $("#chk-pay > option:selected").attr("value");
			var countRecords= 0;
			var idUniversity = parseInt($("#university > option:selected").attr("id"));
			var rows = {};
			
			/* adjunta filtro de pago al selector */
			if(keyPaymentStatus == 'pay'){
				rows = $("table#preregistrados tbody > tr").find("a.btn-success").parent().parent();
				$("table#preregistrados tbody > tr").find("a.btn-danger").parent().parent().hide();
			}else if(keyPaymentStatus == 'nopay'){
				rows = $("table#preregistrados tbody > tr").find("a.btn-danger").parent().parent();
				$("table#preregistrados tbody > tr").find("a.btn-success").parent().parent().hide();
			}else{
				rows = $("table#preregistrados tbody > tr");
			}
			
			/* selecciona por universidades */
			if(idUniversity == 0){
				countRecords = $(rows).size();
				$("#num-records").html(countRecords);
				$(rows).show();
			}else{
				$(rows).hide();
				$.each($(rows), function(key, value){					
					if(idUniversity == $(value).attr("id-university")){						
						$(value).show(300);
						countRecords++;
					}
				});
			}
			$("#num-records").html(countRecords);
		});
		
		$("#university").change();
	});
</script>
<%@ include file="/WEB-INF/jsp/contenido_despues.jsp"%>