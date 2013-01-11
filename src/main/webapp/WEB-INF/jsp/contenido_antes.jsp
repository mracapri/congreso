<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/jsp/resources.jsp" %>
	<script type="text/javascript">
		$(document).ready(function(){
			$('a[rel*=tooltip]').tooltip({animation:true, placement:'bottom'});
		});
	</script>
</head>
<body>	
	<!-- wrapper-->
	<div id="wrapper">
		<!-- banner-->
		<div id="banner">
			<img src="${pageContext.request.contextPath}/recursos/images/encabezado.jpg" />
			<img src="${pageContext.request.contextPath}/recursos/images/FOTOS.jpg" />
		</div>
		<!-- fin banner-->
		<div class="row-fluid">
			<div class="navbar">
				<div class="navbar-inner">
					<a class="brand" href="${pageContext.request.contextPath}/resolver/index.htm?unshow-message">Inicio</a>
					<ul class="nav">
		
						<sec:authorize access="!isAuthenticated()">
							<li>
								<a href="${pageContext.request.contextPath}/resolver/login.htm">
								Iniciar Sesi&oacuten
								</a>
							</li>
						</sec:authorize>
						
						<li>
							<sec:authorize access="isAuthenticated()">
								<a href="#">
								 	<span class="label">
								 		<c:out value="${pageContext.request.userPrincipal.name}"/>
								 	</span>
								</a>
							</sec:authorize>
						</li>
						
						<sec:authorize access="hasRole('ROLE_PREREGISTERED_SUCCESS')">
							<li>
								<a href="${pageContext.request.contextPath}/resolver/register_fiscal_data/form">
									Informaci&oacuten fiscal
								</a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/resolver/payment/payment_ticket" target="_blank">Generar ficha de pago</a>
							</li>

						</sec:authorize>
						
						<sec:authorize access="hasRole('ROLE_PREREGISTERED_SUCCESS_PAYMENT')">
							<li>
								<a href="${pageContext.request.contextPath}/resolver/register_fiscal_data/form">
									Informaci&oacuten fiscal
								</a>
							</li>
							<li>
								<a rel="tooltip" 
									data-original-title="Funcionalidad activada hasta el 1 de Marzo"
									href="#">
									Armar agenda
								</a>
							</li>
						</sec:authorize>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<li>
								<a href="${pageContext.request.contextPath}/resolver/register/list_user_preregistered">Usuarios de PreRegistro</a>
							</li>
						</sec:authorize>
						<sec:authorize access="hasRole('ROLE_ADMIN_PARTICIPATION')">
							<li>
								<a href="${pageContext.request.contextPath}/resolver/register_participation/list_user_participation">Lista de participantes</a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/resolver/register_academy/list_academic">Cuerpos academicos registrados</a>
							</li>
						</sec:authorize>
						<sec:authorize access="isAuthenticated()">
							<li>
								<a href="${pageContext.request.contextPath}/j_spring_security_logout">
										Cerrar Sesi&oacuten
								</a>
							</li>
						</sec:authorize>
					</ul>
				</div>
			</div>
		</div>	
		<div class="row-fluid">
			<div class="span3">
				<%@ include file="/WEB-INF/jsp/menu.jsp" %>
			</div>
			<div class="span9" id="contenido_principal">