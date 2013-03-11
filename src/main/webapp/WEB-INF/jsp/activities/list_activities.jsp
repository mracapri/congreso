<%@ include file="/WEB-INF/jsp/contenido_antes.jsp"%>
<style>
	.label-wrap, .label-wrap-button, .label-wrap-day{
		width:130px;
		display:block;
		word-wrap:break-word;
	}
	.label-wrap-button{
		width:80px;
	}
	
	.label-wrap-day{
		width:30px;
		font-weight: bold;
	}
	
	#activities tr:nth-child(2n) {
	    /*background-color: #999999;
	    color: #000;*/
	    border: 1px solid;
	}
</style>

<table id="activities" class="table">
	<thead>
		<tr>
			<th>Dia</th>
			<th>Lugar</th>
			<th>Seccion</th>
			<th>Actividad</th>
			<th>Hora</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="activitie" items="${activities}">
			<tr>			
				<td>
					<span class="label-wrap-day">
						${activitie.day}
					</span>					
				</td>
				<td>
					<span class="label-wrap">
						${activitie.placeSection.place.place}
					</span>
				</td>
				<td>
					<span class="label-wrap">
						${activitie.placeSection.placeSection}
					</span>
				</td>
				<td>
					<span class="label-wrap">
						${activitie.activitie}
					</span>
				</td>
				<td>
					${activitie.hour}
				</td>
				<td>
					<span class="label-wrap-button">
						<c:choose>
						    <c:when test="${activitie.asignacion == 0}">
								<button class="btn btn-info btn-assist" id="${activitie.id}">Asistir</button>
						    </c:when>
						    <c:when test="${activitie.asignacion != 0}">
								<button class="btn btn-danger btn-deassist" id="${activitie.id}">Retirarse</button>
						    </c:when>
						</c:choose>
					</span>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<script type="text/javascript">
$(document).ready(function(){
	$(".btn-assist").click(function(){
		var id = $(this).attr("id");
		$.getJSON("${pageContext.request.contextPath}/resolver/activitie/assist?idActivitie=" + id,function(result){
			alert(result.result);
			$("body").load("/congreso/resolver/activitie/list");
		});
	});
	
	$(".btn-deassist").click(function(){
		var id = $(this).attr("id");
		$.getJSON("${pageContext.request.contextPath}/resolver/activitie/deassist?idActivitie=" + id,function(result){			
			$("body").load("/congreso/resolver/activitie/list");
		});
	});
});
</script>
<%@ include file="/WEB-INF/jsp/contenido_despues.jsp"%>