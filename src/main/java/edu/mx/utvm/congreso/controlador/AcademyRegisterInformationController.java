package edu.mx.utvm.congreso.controlador;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mx.utvm.congreso.controlador.formbeans.FormRegisterAcademy;
import edu.mx.utvm.congreso.controlador.validator.ClaveValidator;
import edu.mx.utvm.congreso.controlador.validator.CorreoElectronicoValidator;
import edu.mx.utvm.congreso.mail.MailService;
import edu.mx.utvm.congreso.mail.MailService;
import edu.mx.utvm.congreso.util.Util;

@Controller
@RequestMapping("/register_academy")
public class AcademyRegisterInformationController {
	protected final Log log = LogFactory.getLog(getClass());
	
	private Map<String,String> universidadesDeProcencia;
	
	@Value("${URL_CONFIRM_ACADEMY}")
	String urlConfirm;
	
	@Autowired	
	private ClaveValidator claveValidator;
	
	@Autowired
	private CorreoElectronicoValidator correoElectronicoValidator;
	
	@Autowired
	private MailService mail;
	
	public AcademyRegisterInformationController() {    	
    	this.universidadesDeProcencia = new LinkedHashMap<String,String>();
    	this.universidadesDeProcencia.put("1", "UTVM");
    	this.universidadesDeProcencia.put("2", "UTTT");    
	}	
	
    @RequestMapping(value="/save", method = RequestMethod.GET)
	public String regresaFormulario() {
    	return "redirect:form";
    }
    
    @RequestMapping(value="/confirm/{token}", method = RequestMethod.GET)
	public ModelAndView confirmaRegistro(@PathVariable("token") String token)
            throws ServletException, IOException {
    	ModelAndView modelAndView = new ModelAndView("register_academy/confirm_success");
    	log.debug("EL TOKEN ES: " + token);
    	return modelAndView;
    }
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView guardar(HttpServletRequest request,
			@ModelAttribute("formRegisterAcademy") @Valid FormRegisterAcademy formRegisterAcademy,
			BindingResult result) {

		log.debug("RESULT: " + ToStringBuilder.reflectionToString(result));
		
    	ModelAndView modelAndView = new ModelAndView("register_academy/register");
    	modelAndView.addObject("formRegisterAcademy", formRegisterAcademy);
    	modelAndView.addObject("result", result);
    	modelAndView.addObject("sectores", this.universidadesDeProcencia);
    	
    	if(!result.hasErrors()){	

    		/* Mapa de propiedades */
        	Map<String, String> model = new HashMap<String, String>();        	        	
			String nombre = formRegisterAcademy.getNombreDelCuerpoAcademico();
			
			String token = Util.generateToken("correo");
			String urlConfirm = this.urlConfirm + token;
        	model.put("nombre", nombre);
        	model.put("url", urlConfirm);        	
        	
    		/* Envio de correo electronico */
        	
    		mail.sendMail("mrangeles@utvm.edu.mx", formRegisterAcademy.getCorreoElectronico(),
    				"Confirmación de cuenta", model, MailService.TEMPLATE_PARTICIPATION_SUCCESS);
    		
    		    		
    		log.debug("CODIGO: " + token);
    		log.debug("URL_CONFIRM: " + urlConfirm);
    		
    		modelAndView.setViewName("register_academy/register_success");
    	}    	    			    	
    	return modelAndView;
	}    

	@RequestMapping(value="/form")
	public ModelAndView mostrarFormularioRegistro(
			@ModelAttribute("formRegisterAcademy") FormRegisterAcademy formRegisterAcademy,
			HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	ModelAndView modelAndView = new ModelAndView("register_academy/register");
    	modelAndView.addObject("sectores", this.universidadesDeProcencia);
    	return modelAndView;
    }
    
	@InitBinder("formRegisterAcademy")
	protected void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.setValidator(claveValidator);
		webDataBinder.setValidator(correoElectronicoValidator);
	}
	
}
