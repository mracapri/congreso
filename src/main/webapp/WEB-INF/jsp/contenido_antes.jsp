<%@ include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/jsp/resources.jsp" %>
</head>
<body>
	<!-- wrapper-->
	<div id="wrapper">
		<!-- banner-->
		<div id="banner">
			<img src="${pageContext.request.contextPath}/recursos/images/encabezado.png" />
			<img src="${pageContext.request.contextPath}/recursos/images/FOTOS.png" />
		</div>
		<!-- fin banner-->
		<div class="row-fluid">
			<div class="span3">
				<%@ include file="/WEB-INF/jsp/menu.jsp" %>
			</div>
			<div class="span9" id="contenido_principal">