<%@ include file="/WEB-INF/jsp/contenido_antes.jsp" %>

    <script type="text/javascript" src="http://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load('visualization', '1');
    </script>
    <script type="text/javascript">
      function drawVisualization() {
        var wrapper = new google.visualization.ChartWrapper({
          chartType: 'ColumnChart',
          dataTable: [['', 'Participantes', 'Cuerpos Academicos'], ['', ${dataChart.numberOfParticipants}, ${dataChart.numberOfAcademicBodies} ]],
          options: {'title': 'Participación y cuerpos academicos'},
          containerId: 'visualization'
        });
        wrapper.draw();
      }
      
      

      google.setOnLoadCallback(drawVisualization);
    </script>
    
    <div id="visualization" style="width: 600px; height: 400px;"></div>
    
    
<%@ include file="/WEB-INF/jsp/contenido_despues.jsp" %>