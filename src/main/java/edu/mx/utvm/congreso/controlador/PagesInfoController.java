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
}
