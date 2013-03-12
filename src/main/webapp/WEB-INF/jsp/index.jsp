<%@ include file="/WEB-INF/jsp/contenido_antes.jsp" %>
    
<div class="alert alert-error">
	<button type="button" class="close" data-dismiss="alert">&times;</button>
	<h4>Atenci&oacuten!</h4>
	Recuerda que para realizar tu agenda tendr&aacutes que completar el proceso de pago
</div>
<h3>
	Bienvenida
</h3>
<div class="row">
	<div class="span3">
		<p><img src="${pageContext.request.contextPath}/recursos/images/LOGO.png"></p>
	</div>
	<div class="span9">
		<p>
			Bienvenidos al VII Congreso Nacional Agroindustrial, Alimentario y Biotecnol&oacute;gico que se 
			llevar&aacute; a cabo en la Universidad Tecnol&oacute;gica del Valle del Mezquital del 20 al 22  
			de Marzo del 2013.
			<br/><br/>
			El Congreso es un espacio para que investigadores, docentes, profesionales, estudiantes y empresarios 
			del &aacute;rea de alimentos y afines compartan el fruto de sus investigaciones y aborden temas de inter&eacute;s 
			nacional y mundial relacionados con procesos agroindustriales y biotecnol&oacute;gicos amigables con el ambiente; 
			alimentos que contribuyan a mejorar la nutrici&oacute;n y salud, y la calidad e inocuidad de los mismos.
		</p>
	</div>
</div>

<h3>
	Presentaci&oacute;n	
</h3>
<p>
	En la actualidad nos encontramos sumergidos en un mundo sumamente exigente y competitivo, que demanda tanto a los actuales como 
	a nuevos profesionales mantenerse actualizados en cada una de sus &aacute;reas, manteniendo el enfoque interdisciplinario de aquellas 
	que intervienen en su campo de especialidad, ya sean t&eacute;cnicas o administrativas. 
	<br/><br/>
	El presente de la agricultura y el sector alimentario hace necesario que se vinculen a la biotecnolog&iacute;a para mejorar sus actividades 
	productivas y acelerar estos  sectores econ&oacute;micos. Estos sectores aportan los elementos para lograr  la seguridad alimentaria la cual 
	se refiere a que todas las personas deben tener  acceso f&iacute;sico y econ&oacute;mico a suficientes alimentos inocuos y nutritivos para 
	satisfacer sus necesidades alimentarias  y sus preferencias en cuanto a alimentos. Todas las &aacute;reas involucradas desde sus &aacute;mbitos 
	desarrollan tecnolog&iacute;as y procesos tendientes a lograr este fin com&uacute;n, adem&aacute;s se pretende mejorar la calidad de vida de 
	los productores y la sociedad en su conjunto y desarrollar productos que mejoren la salud humana.
	<br/><br/>
	Por estos motivos surge en el 2006 el "I Congreso Nacional Agroindustrial, Alimentario y Biotecnol&oacute;gico", realizado en la Universidad 
	Tecnol&oacute;gica de Tecamac, mismo que se le ha dado continuidad celebr&aacute;ndose en 2008 en la Universidad Tecnol&oacute;gica de Tabasco, 
	2009 Universidad Tecnol&oacute;gica de Nayarit,  2010 Universidad Tecnol&oacute;gica de la Selva, 2011 Universidad Tecnol&oacute;gica del Suroeste 
	de Guanajuato y 2012 en la Universidad Tecnol&oacute;gica del Centro de Veracruz.
	<br/><br/>
	Hoy en d&iacute;a, la Universidad Tecnol&oacute;gica del Valle del Mezquital,  le da continuidad a este esfuerzo integrando los programas educativos 
	de T&eacute;cnico Superior Universitario en Procesos Alimentarios, TSU en Biotecnolog&iacute;a, TSU en Agrobiotecnolog&iacute;a e Ingenier&iacute;a en 
	Procesos Bioalimentarios, Alimentarios y en Tecnolog&iacute;as Bioalimentarias; ofreciendo el "VII Congreso Nacional Agroindustrial, Alimentario y 
	Biotecnol&oacute;gico". A esta idea se suman los programas de TSU en Acuicultura y de Licencia Profesional en Seguridad e Inocuidad Alimentaria, de 
	Tecnolog&iacute;a y Calidad en la Producci&oacute;n de Quesos, del Sub-Sistema de Universidades Tecnol&oacute;gicas.
	<br/><br/>
	El s&eacute;ptimo Congreso Nacional Agroindustrial, Alimentario y Biotecnol&oacute;gico Pretende ser un encuentro para la comunicaci&oacute;n e 
	intercambio de ideas entre investigadores, alumnos, maestros y p&uacute;blico interesado con un sello sustentable para que en el futuro, dichas 
	ideas sean aplicadas para mejorar el posicionamiento t&eacute;cnico-cient&iacute;fico de M&eacute;xico. De este modo se divulgar&aacute; la importancia 
	que tienen estas &aacute;reas del conocimiento en nuestra vida cotidiana. Expertos en el &aacute;rea de agrobiotecnolog&iacute;a y alimentos 
	coincidir&aacute;n en los espacios del Congreso para reflexionar en torno a la agrobiotecnolog&iacute;a y la importancia que tiene en el desarrollo y 
	tecnolog&iacute;a alimentaria que contribuyan al desarrollo sustentable.
	<br/><br/>
	El evento estar&aacute; colmado de la vasta experiencia de quienes ya se han desarrollado "en el campo profesional" o bien que han buscado soluciones 
	por medio de la investigaci&oacute;n, igualmente de los responsables de organizar estos esfuerzos para brindar respuestas sociales y empresariales. 
</p>


<h3>
	Objetivos	
</h3>
<ol>
	<li>Mantener a la vanguardia los conocimientos de la entidad acad&eacute;mica del &aacute;rea agroalimentaria y agrobiotecnol&oacute;gica.</li>
	<li>Consolidar los v&iacute;nculos con los sectores productivo, social y de servicios; al igual que con las distintas instituciones de investigaci&oacute;n.</li>
	<li>Difundir las nuevas tecnolog&iacute;as para el desarrollo de ingenier&iacute;a.</li>
	<li>Difundir los diferentes programas educativos del &aacute;rea de alimentos y biotecnolog&iacute;a.</li>
	<li>Establecer redes de colaboraci&oacute;n entre los Cuerpos Acad&eacute;micos</li>
</ol>
<c:if test="${param['unshow-message'] == null}">




<div id="myModal" class="modal hide fade in" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false" style="display: block;">
		<div class="modal-header">
			<h3 id="myModalLabel">Congreso Nacional Bioalimentario</h3>
		</div>
		<div class="modal-body">
			<div class="row-fluid">
				<div class="span12">				
					
					<div class="span12">
						<div class="row-fluid">
							<div class="span12">
								<p><b>Palabras del Rector</b></p>
								
<img src="/congreso/recursos/images/LOGO.png" style="float:left; margin:15px">

<p>Palabras dirigidas por el Rector de la UTVM.

Como cada a&ntildeo, las Universidades Tecnol&oacutegicas se re&uacutenen en un Congreso Nacional para dar a
conocer los avances y aportaciones desarrolladas en las diferentes &aacutereas del sector alimentario y
biotecnol&oacutegico.<br><br>

Para esta Casa de Estudios es satisfactorio participar en este 7 Congreso Nacional Agroindustrial
Alimentario y Biotecnol&oacutegico, un espacio propicio para la transmisi&oacuten de saberes y cuya magnitud,
se mide por la excelencia de sus ponentes, as&iacute como el inter&eacutes que nos une en torno a temas
relacionados con la producci&oacuten agroalimentaria.<br><br>

El subsistema de Universidades Tecnol&oacutegicas considera a los programas educativos de acuacultura,
biotecnolog&iacutea, procesos alimentarios y programas afines como transcendentales para el desarrollo
del pa&iacutes; esto implica desarrollar ciencia y tecnolog&iacutea de vanguardia aplicadas en este rubro
estrat&eacutegico para el crecimiento poblacional y econ&oacutemico.<br><br>

La sociedad actual otorga cada vez m&aacutes importancia a la calidad y a la seguridad de los alimentos,
es por esto una exigencia el desarrollo e innovaci&oacuten de nuevas tecnolog&iacuteas para su procesamiento.
En ese sentido, es necesario redoblar esfuerzos desde las Instituciones de Educaci&oacuten Superior, los
centros de investigaci&oacuten especializados y las comunidades cient&iacuteficas, para asegurar un alto nivel de
calidad en los productos de exportaci&oacuten y consumo nacional.<br><br>

Es necesario contar con un foro espec&iacutefico donde se intercambien y difundan los conocimientos
adquiridos y desarrollados en las aulas, laboratorios y talleres por docentes y estudiantes, con el
objetivo de transferirlos a la sociedad en general.<br><br>

Por nuestra parte, estamos haciendo lo propio al realizar proyectos de investigaci&oacuten, para desarrollar
conocimientos en la materia, adem&aacutes de signar convenios con instituciones de vanguardia, que nos
permitan contribuir a la consolidaci&oacuten de la industria alimentaria en la entidad. Asimismo nos hemos
esforzado por elevar la calidad de nuestros programas educativos afines al sector de agroalimentos,
reiterando el compromiso que tenemos con el desarrollo econ&oacutemico de la sociedad y el impulso de
nuevas tecnolog&iacuteas aplicadas a este rubro.<br><br>

Es por ello que este VII Congreso Nacional Agroindustrial, Alimentario y Biotecnol&oacutegico 2013;
representa un importante mecanismo de comunicaci&oacuten que permitir&aacute mejorar el desarrollo
tecnocient&iacutefico y que reforzar&aacute los lazos existentes de vinculaci&oacuten entre las comunidades
estudiantiles del pa&iacutes para seguir fortaleciendo la industria agroalimentaria.<br><br>

Nuevamente sean bienvenidos y esperamos que los resultados que se deriven rindan frutos y
constituyan un aporte sustancial para el progreso de esta regi&oacuten, el estado y el pa&iacutes.<br><br>

Muchas gracias y &eacutexito.

<p style="text-align: right;">
	<b>
		Lic. Marco Antonio Ocadiz Cruz
	</b>
</p>
</p><br><br>
							</div>	
						</div>
						<div class="row-fluid">
							<div class="span12">
								<p><b>Interes</b></p>
								<ul>
									<li>
										<a href="/congreso">Sala de prensa</a>
									</li>
									<li>
										<a href="/congreso">Galeria de imagenes</a>
									</li>
								</ul>
							</div>	
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<button class="btn btn-primary" data-dismiss="modal" aria-hidden="true">Cerrar</button>
		</div>
	</div>
</c:if>

<%@ include file="/WEB-INF/jsp/contenido_despues.jsp" %>
<script type='text/javascript' src='${pageContext.request.contextPath}/recursos/js/index.js'></script>
