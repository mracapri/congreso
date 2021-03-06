package edu.mx.utvm.congreso.controlador;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pages")
public class PagesInfoController {
	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value="/foro_egresados")
    public ModelAndView handleForoEgresados(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        Map<String, Object> modelo = new HashMap<String, Object>();
        
    	return new ModelAndView("content/foro_egresados", "modelo", modelo);
    }
	
	@RequestMapping(value="/conferencias")
    public ModelAndView handleConferencias(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        Map<String, Object> modelo = new HashMap<String, Object>();
        
    	return new ModelAndView("content/conferencias", "modelo", modelo);
    }

	@RequestMapping(value="/como_llegar")
    public ModelAndView handleComoLLegar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        Map<String, Object> modelo = new HashMap<String, Object>();
        
    	return new ModelAndView("content/como_llegar", "modelo", modelo);
    }
	@RequestMapping(value="/sede")
    public ModelAndView handleSede(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        Map<String, Object> modelo = new HashMap<String, Object>();
        
    	return new ModelAndView("content/sede", "modelo", modelo);
    }
	@RequestMapping(value="/contacto")
    public ModelAndView handleContacto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        Map<String, Object> modelo = new HashMap<String, Object>();
        
    	return new ModelAndView("content/contacto", "modelo", modelo);
    }

	
	@RequestMapping(value="/reuniones")
    public ModelAndView handleReuniones(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        Map<String, Object> modelo = new HashMap<String, Object>();
        
    	return new ModelAndView("content/reuniones", "modelo", modelo);
    }
	
	@RequestMapping(value="/ponencias")
    public ModelAndView handlePonencias(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        Map<String, Object> modelo = new HashMap<String, Object>();
        
    	return new ModelAndView("content/ponencias", "modelo", modelo);
    }

	@RequestMapping(value = "/carteles")
	public ModelAndView handleCarteles(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Map<String, Object> modelo = new HashMap<String, Object>();

		return new ModelAndView("content/carteles", "modelo", modelo);
	}
	
	@RequestMapping(value = "/actividades_culturales")
	public ModelAndView handleActividadesCulturales(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Map<String, Object> modelo = new HashMap<String, Object>();

		return new ModelAndView("content/actividades_culturales", "modelo", modelo);
	}
	
	@RequestMapping(value = "/talleres")
	public ModelAndView handleTalleres(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Map<String, Object> modelo = new HashMap<String, Object>();

		return new ModelAndView("content/talleres", "modelo", modelo);
	}
		
	@RequestMapping(value = "/concursos")
	public ModelAndView handleConcursos(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Map<String, Object> modelo = new HashMap<String, Object>();

		return new ModelAndView("content/concursos", "modelo", modelo);
	}
		
	@RequestMapping(value = "/servicio_hospedaje")
	public ModelAndView handleServicioHospedaje(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Map<String, Object> modelo = new HashMap<String, Object>();

		return new ModelAndView("content/servicio_hospedaje", "modelo", modelo);
	}
	
	@RequestMapping(value = "/galeria_imagenes")
	public ModelAndView handleGaleriaImagenes(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ModelAndView model = new ModelAndView("content/galeria_imagenes");
		return model;
	}
	
	@RequestMapping(value = "/sala_prensa")
	public ModelAndView handleSalaDePrensa(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ModelAndView model = new ModelAndView("content/sala_prensa");
		return model;
	}
	
	@RequestMapping(value = "/turismo")
	public ModelAndView handleTurismo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ModelAndView model = new ModelAndView("content/turismo");
		return model;
	}
	
	@RequestMapping(value = "/palabras_rector")
	public ModelAndView handlePalabrasRectorTurismo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ModelAndView model = new ModelAndView("content/palabras_rector");
		return model;
	}
	
	@RequestMapping(value = "/programa_general")
	public ModelAndView handleProgramaGeneral(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ModelAndView model = new ModelAndView("content/programa_general");
		return model;
	}	
}
