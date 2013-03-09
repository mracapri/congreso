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
		
		<style type="text/css">
table {
    border: 2px dotted;
}
td {
    padding: 13px;
}
.label-ticket strong {
    text-decoration: underline;
    display: block;
}
		</style>
	</head>
	<body>
		<div class="container">
		
			<br/>
			Recorte la ficha
			<br/><br/>
			
			<div class="cut">
				<table>
					<tr>
						<td>
							<img alt="" src="${pageContext.request.contextPath}/recursos/images/LOGO_ficha.png" />
						</td>
						<td>
							<p style="font-size:25px;">
								<strong>
									Ficha de Dep&oacutesito
								</strong>
							</p>
							<p style="font-size:16px;">
								<strong>
									7&deg; Congreso Nacional Bioalimentario
								</strong>
							</p>
						</td>
						<td></td>
						<td></td>
						<td>
							<p class="label-ticket" style="font-size:14px;">
								<img alt="" src="${pageContext.request.contextPath}/recursos/images/banorte.jpg" />
								<strong>
									Banco:
								</strong>
								Banorte
							</p>
						</td>
					</tr>
					
					<tr>
						<td colspan="2">
							<p class="label-ticket" style="font-size:14px;">
								<strong>
									N&uacutemero empresa: 
								</strong>
								126361
							</p>
						</td>
						<td colspan="2">
							<p class="label-ticket" style="font-size:14px;">
								<strong>
									Fecha:
								</strong>
								${date}
							</p>
						</td>
						<td>
							<p class="label-ticket" style="font-size:14px;">
								<strong>
									Nombre del participante:
								</strong>
								${preRegisterInformation.name} 
								${preRegisterInformation.secondName} 
								${preRegisterInformation.thirdName}
							</p>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<p class="label-ticket" style="font-size:14px;">
								<strong>
									Clave:
								</strong>
								${preRegisterInformation.informationAccount.token}
							</p>
						</td>
						<td colspan="2">
							<p class="label-ticket" style="font-size:14px;">
								<strong>
									Importe:
								</strong>
								450.00 M.N
							</p>
						</td>
						<td></td>
					</tr>
				</table>
			</div>
			<br/>
			<button class="btn btn-info" id="btn-print">
				<li class="icon-print"></li>
				Imprimir
			</button>
		</div>
		
	</body>
</html>