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
            draw(data, {title:"Estado de pago de participantes preregistrados"});
      }
      

      google.setOnLoadCallback(drawVisualization);
    </script>
    
    <div id="visualization" style="width: 600px; height: 400px;"></div>
    
    
<%@ include file="/WEB-INF/jsp/contenido_despues.jsp" %>