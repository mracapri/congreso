<%@ include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>7&deg; Congreso Nacional Bioalimentario</title>

		<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/recursos/images/favicon.ico">
			
		<!-- css bootstrap framework -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/bootstrap/css/bootstrap.min.css" type="text/css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/bootstrap/css/bootstrap-responsive.min.css" type="text/css">   
		<script src="${pageContext.request.contextPath}/recursos/js/jquery-1.8.3.js"></script>
				
		<!-- js bootstrap framework -->		
		<script type='text/javascript' src='${pageContext.request.contextPath}/recursos/bootstrap/js/bootstrap.js'></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#btn-print").click(function(){
					window.print();
				});
			});
		</script>
	</head>
	<body>
		<div class="container">
			<br/>
			Recorte la ficha
			<br/>
			<div class="row">
				<div class="span9" style="border:1px dotted; padding:20px;">
					<div class="row">
						<div class="span1">
							<img alt="" src="${pageContext.request.contextPath}/recursos/images/LOGO_ficha.png" />
						</div>
						<div class="span4">
							<p style="font-size:25px;">
								<strong>
									Ficha de Deposito
								</strong>
							</p>
							<br/>
							<p style="font-size:16px;">
								<strong>
									7&deg; Congreso Nacional Bioalimentario
								</strong>
							</p>
						</div>
						
						<div class="span2">
							<p style="font-size:14px;">
								<strong>
									Numero empresa: 
								</strong>
								126361
							</p>
						</div>
					</div>
					<br/>
					<div class="row">
						<div class="span1"></div>
						<div class="span4">
							<p style="font-size:14px;">
								<strong>
									Nombre del participante:
								</strong>
								${preRegisterInformation.name} 
								${preRegisterInformation.secondName} 
								${preRegisterInformation.thirdName}
							</p>
						</div>
						<div class="span3">

							<p style="font-size:14px;">
								<strong>
									Clave:
								</strong>
								${preRegisterInformation.informationAccount.token}
							</p>				
						</div>
					</div>
					
					<br/>
					<div class="row">
						<div class="span9">
							<div class="span4">
								<p style="font-size:14px;">
									<strong>
										Fecha:
									</strong>
									${date}
								</p>
							</div>
							<div class="span4">
								<p style="font-size:14px;">
									<strong>
										Importe:
									</strong>
									450.00 M.N
								</p>
							</div>
						</div>
					</div>		
				</div>
			</div>
			
			<br/><br/>
			
			<button class="btn btn-info" id="btn-print">
				<li class="icon-print"></li>
				Imprimir
			</button>
		</div>
		
	</body>
</html>