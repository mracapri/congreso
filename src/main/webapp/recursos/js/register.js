var register = {
	init: function(){
		$this = this;
		
		$("span[id*=errors] > br").after(" - ").remove();
		
		var etiquetasError = $(".label-important");
		$.each(etiquetasError, function(key, value){
			var etiqueta = $(value);
			if($(value).html().trim() == ''){
				etiqueta.hide();
			}
		});
	}
};

$(document).ready(function(){	
	register.init();
});