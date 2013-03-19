<%@ include file="/WEB-INF/jsp/include.jsp" %>
<html>
	<head>
		<%@ include file="/WEB-INF/jsp/resources.jsp" %>
	</head>
	<style>
		body{
			background-color:white !important;
			padding: 50px;
		}
		.label-wrap, .label-wrap-name{
			width:200px;
			display:block;
			word-wrap:break-word;
			color: gray;
		}
		
		.label-wrap-name{
			color: black;
			width:400px;
		}
	</style>
	<c:set var="index" scope="request" value="0"/>
	<body>
		<h2>
			${list.nameActivitie}
		</h2>
		<table id="preregistrados" class="table">
			<thead>
				<tr>
					<th>#</th>
					<th>Nombre</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach  var="name" items="${list.names}">
					<tr>
						<td>
							<c:set var="index" scope="request" value="${index + 1}"/>
							${index}
						</td>
						<td>
							<span class="label-wrap-name">
								${name}
							</span>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>

