<%@ include file="/WEB-INF/jsp/contenido_antes.jsp" %>

    <script type="text/javascript" src="http://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load('visualization', '1', {packages: ['corechart']});
    </script>
    <script type="text/javascript">
      function drawVisualization() {
        // Create and populate the data table.
        var data = google.visualization.arrayToDataTable([
          ['Estado', 'Total'],
          ['Pagado', ${dataChart.pay}],
          ['No Pagado', ${dataChart.noPay}]
        ]);
      
        // Create and draw the visualization.
        new google.visualization.PieChart(document.getElementById('visualization')).
            draw(data, {});
      }
      

      google.setOnLoadCallback(drawVisualization);
    </script>      
 
 	<h4>
		Estado de pago de participantes preregistrados
 	</h4>
 	<hr/>
    <div class="row">
	    <div class="span12">	    	
			<div class="span2">
				<br/><br/><br/>
			    <p>
			    	<small>
			    		<b>#Pagado: </b> ${dataChart.pay}
			    	</small>
			    </p>
			    <p>
			    	<small>
			    		<b>#No pagado: </b> ${dataChart.noPay}
			    	</small>
			    </p>
			    <p>
			    	<small>
			    		<b>Total: </b> ${dataChart.pay + dataChart.noPay}
			    	</small>
			    </p>
			</div>
			<div class="span6">
				<div id="visualization" style="width: 400px; height: 400px;"></div>
			</div>
	    </div>	    
    </div>

<%@ include file="/WEB-INF/jsp/contenido_despues.jsp" %>