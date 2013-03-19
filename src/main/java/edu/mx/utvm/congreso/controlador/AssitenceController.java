package edu.mx.utvm.congreso.controlador;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import edu.mx.utvm.congreso.dominio.PreRegisterInformation;
import edu.mx.utvm.congreso.service.PreRegisterInformationService;

@Controller
@RequestMapping("/register")
public class AssitenceController {
	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private PreRegisterInformationService preRegisterInformationService;
	
	@Autowired
	protected MessageSource source;
	
	@RequestMapping(value="/list_assistence")
	public ModelAndView presentarListaDeAsistencia(
			HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		String searchParameter = request.getParameter("search-param");		
		log.debug("PARAMETRO DE BUSQUEDA: " + searchParameter);
		
		List<PreRegisterInformation> findAllPreRegisters;
		if(searchParameter != null && !searchParameter.equals("")){
			findAllPreRegisters = preRegisterInformationService.findAllPreRegistersByParamSearch(searchParameter);				
		}else{
			findAllPreRegisters = preRegisterInformationService.findAllPreRegisters();
		}
    	ModelAndView modelAndView = new ModelAndView("register/list_user_preregistered_assistence");
    	modelAndView.addObject("preRegisters", findAllPreRegisters);
    	return modelAndView;
    }
	
	
    @RequestMapping(value="/confirm-assistence/{token}", method = RequestMethod.GET)
	public ModelAndView confirmaRegistro(@PathVariable("token") String token, HttpServletRequest request)
            throws ServletException, IOException {
    	ModelAndView modelAndView = new ModelAndView("jsonView");
    	modelAndView.addObject("result", "");
    	log.debug("Obteniendo el token: " + token);
		
		//fetching locale
		LocaleResolver resolver = RequestContextUtils.getLocaleResolver(request);
		Locale loc = resolver.resolveLocale(request);
    	
		int messageCode = 0;
    	if(preRegisterInformationService.getPaymentStatus(token)){
    		// pagado
    		messageCode = preRegisterInformationService.setAssistence(token);
    	}
    	
		//fetching message json to view		
        String mensaje = source.getMessage("json.assistence." + messageCode, null,
			"Message not found", loc);
        
    	modelAndView.addObject("result", mensaje);
    	
    	return modelAndView;
    }
	
}
