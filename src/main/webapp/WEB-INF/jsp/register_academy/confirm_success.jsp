<%@ include file="/WEB-INF/jsp/contenido_antes.jsp" %>		
<div class="well">
	Cuerpo Academico <b>${academyRegisterInformation.name}</b>, 
	de la <b>${academyRegisterInformation.university.name}</b>, 
	la cuenta ha sido confirmada con esta direccion de correo 
	electronico <b>${academyRegisterInformation.informationAccount.email}</b>
	<br/><br/> 	 
	Puede iniciar la sesion <a href="${pageContext.request.contextPath}/resolver/login.htm">aqui</a>
	<br/><br/>
	<b>Muchas gracias!</b>
	<br/><br/>	    
	<a class="btn btn-info" href="${pageContext.request.contextPath}">Aceptar</a>
</div>
<%@ include file="/WEB-INF/jsp/contenido_despues.jsp" %>