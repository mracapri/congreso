package edu.mx.utvm.congreso.controlador;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
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

import edu.mx.utvm.congreso.controlador.formbeans.FormRegisterParticipation;
import edu.mx.utvm.congreso.controlador.validator.ClaveValidator;
import edu.mx.utvm.congreso.controlador.validator.CorreoElectronicoValidator;
import edu.mx.utvm.congreso.service.mail.MailService;
import edu.mx.utvm.congreso.service.mail.MailServiceImpl;

@Controller
@RequestMapping("/register_participation")
public class ParticipationRegisterInformationController {
	protected final Log log = LogFactory.getLog(getClass());
	
	private Map<String,String> ocupaciones;
	private Map<String,String> universidadesDeProcencia;
	private Map<String,String> tipoParticipacion;
	
	@Value("${URL_CONFIRM}")
	String urlConfirm;
	
	@Autowired	
	private ClaveValidator claveValidator;
	
	@Autowired
	private CorreoElectronicoValidator correoElectronicoValidator;
	
	@Autowired
	private MailService mail;
	
	public ParticipationRegisterInformationController() {
		/* Carga ocupaciones */
    	this.ocupaciones = new LinkedHashMap<String,String>();
    	this.ocupaciones.put("1", "Estudiante");
    	this.ocupaciones.put("2", "Participante");
    	
    	this.universidadesDeProcencia = new LinkedHashMap<String,String>();
    	this.universidadesDeProcencia.put("1", "UTVM");
    	this.universidadesDeProcencia.put("2", "UTTT");    

    	this.tipoParticipacion = new LinkedHashMap<String,String>();
    	this.tipoParticipacion.put("1", "Ponencia");
    	this.tipoParticipacion.put("2", "Cartel");
    	this.tipoParticipacion.put("3", "Taller");
	}	
	
    @RequestMapping(value="/save", method = RequestMethod.GET)
	public String regresaFormulario() {
    	return "redirect:form";
    }
    
    @RequestMapping(value="/confirm/{token}", method = RequestMethod.GET)
	public ModelAndView confirmaRegistro(@PathVariable("token") String token)
            throws ServletException, IOException {
    	ModelAndView modelAndView = new ModelAndView("register_participation/confirm_success");
    	log.debug("EL TOKEN ES: " + token);
    	return modelAndView;
    }
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView guardar(HttpServletRequest request,
			@ModelAttribute("formRegisterParticipation") @Valid FormRegisterParticipation formRegisterParticipation,
			BindingResult result) {

		log.debug("RESULT: " + ToStringBuilder.reflectionToString(result));
		
    	ModelAndView modelAndView = new ModelAndView("register_participation/register");
    	modelAndView.addObject("formRegisterParticipation", formRegisterParticipation);
    	modelAndView.addObject("result", result);
    	modelAndView.addObject("ocupaciones", this.ocupaciones);
    	modelAndView.addObject("sectores", this.universidadesDeProcencia);
    	modelAndView.addObject("tipoParticipacion", this.tipoParticipacion);
    	
    	if(!result.hasErrors()){	

    		/* Mapa de propiedades */
        	Map<String, String> model = new HashMap<String, String>();        	        	
			String nombre = formRegisterParticipation.getNombre() + " "
					+ formRegisterParticipation.getApellidoPaterno()
					+ formRegisterParticipation.getApellidoMaterno();
			
			String token = generateToken();
			String urlConfirm = this.urlConfirm + token;
        	model.put("nombre", nombre);
        	model.put("url", urlConfirm);
        	
    		/* Envio de correo electronico */
        	
    		mail.sendMail("mrangeles@utvm.edu.mx", formRegisterParticipation.getCorreoElectronico(),
    				"Confirmación de cuenta", model, MailServiceImpl.TEMPLATE_CONFIRMATION);
    		
    		    		
    		log.debug("CODIGO: " + token);
    		log.debug("URL_CONFIRM: " + urlConfirm);
    		
    		modelAndView.setViewName("register_participation/register_success");
    	}    	    			    	
    	return modelAndView;
	}    

	@RequestMapping(value="/form")
	public ModelAndView mostrarFormularioRegistro(
			@ModelAttribute("formRegisterParticipation") FormRegisterParticipation formRegisterParticipation,
			HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	ModelAndView modelAndView = new ModelAndView("register_participation/register");
    	modelAndView.addObject("ocupaciones", this.ocupaciones);
    	modelAndView.addObject("sectores", this.universidadesDeProcencia);
    	modelAndView.addObject("tipoParticipacion", this.tipoParticipacion);
    	return modelAndView;
    }
    
	@InitBinder("formRegisterParticipation")
	protected void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.setValidator(claveValidator);
		webDataBinder.setValidator(correoElectronicoValidator);
	}
	
	private String generateToken(){
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
	}
}
