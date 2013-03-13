<%@ include file="/WEB-INF/jsp/contenido_antes.jsp"%>
<style>
	.label-wrap, .label-wrap-button, .label-wrap-day, .label-wrap-hour, .label-wrap-section{
		width:130px;
		display:block;
		word-wrap:break-word;
	    text-transform: uppercase;
	    font-size: 11px;
	}
	
	.label-wrap-section{
		width:110px;
	}
	
	.label-wrap-button{
		width:110px;
	}
	
	.label-wrap-day{
		width:15px;
		font-weight: bold;
	}

	.label-wrap-hour{
		width:60px;
		font-weight: bold;
	}
	#activities tr:nth-child(2n) {
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
					<span class="label-wrap-section">
						${activitie.placeSection.placeSection}
					</span>
				</td>
				<td>
					<span class="label-wrap">
						${activitie.activitie}
					</span>
				</td>
				<td>
					<span class="label-wrap-hour">
						${activitie.hour}
					</span>
				</td>
				<td>
					<span class="label-wrap-button">
						<button class="btn btn-danger btn-deassist" id="${activitie.id}">Retirarse</button>
					</span>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<script type="text/javascript">
$(document).ready(function(){	
	$(".btn-deassist").click(function(){
		var id = $(this).attr("id");
		$.getJSON("${pageContext.request.contextPath}/resolver/activitie/deassist?idActivitie=" + id,function(result){			
			$("body").load("/congreso/resolver/activitie/list/me");
		});
	});
});
</script>
<%@ include file="/WEB-INF/jsp/contenido_despues.jsp"%>