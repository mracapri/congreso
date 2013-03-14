package edu.mx.utvm.congreso.controlador;

import java.io.IOException;
import java.security.Principal;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import edu.mx.utvm.congreso.service.ActivitieService;

@Controller
@RequestMapping("/activitie")
public class ActivitieController {
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	protected MessageSource source;
	
	@Autowired
	private ActivitieService activitieService;
	
	@RequestMapping(value="/list")
	public ModelAndView showAllActivities(
			HttpServletRequest request, HttpServletResponse response, Principal principal)
            throws ServletException, IOException {
		
    	ModelAndView modelAndView = new ModelAndView("activities/list_activities");
    	modelAndView.addObject("activities", activitieService.findAllByEmail(principal.getName()));
    	return modelAndView;
    }
	
	@RequestMapping(value="/list/me")
	public ModelAndView showActivitiesSelected(
			HttpServletRequest request, HttpServletResponse response, Principal principal)
            throws ServletException, IOException {
		
    	ModelAndView modelAndView = new ModelAndView("activities/list_me");
    	modelAndView.addObject("activities", activitieService.findActivitiesSelectedByEmail(principal.getName()));
    	return modelAndView;
    }
	
	@RequestMapping(value="/report/count")
	public ModelAndView reportActivitiesCount(
			HttpServletRequest request, HttpServletResponse response, Principal principal)
            throws ServletException, IOException {
		
    	ModelAndView modelAndView = new ModelAndView("activities/report_count");
    	modelAndView.addObject("activities", activitieService.reportStateCountAllActivities());
    	return modelAndView;
    }
	
	@RequestMapping(value="/assist")
	public ModelAndView assist(@RequestParam int idActivitie, 
			HttpServletRequest request, HttpServletResponse response, Principal principal)
            throws ServletException, IOException {		
		
		int asist = activitieService.asist(idActivitie, principal.getName());
		
		//fetching locale
		LocaleResolver resolver = RequestContextUtils.getLocaleResolver(request);
		Locale loc = resolver.resolveLocale(request);
		
		//fetching message json to view		
        String mensaje = source.getMessage("json.activitie." + asist, null,
			"Message not found", loc);
        
    	ModelAndView modelAndView = new ModelAndView("jsonView");
    	modelAndView.addObject("result", mensaje);
    	return modelAndView;
    }
	
	@RequestMapping(value="/deassist")
	public ModelAndView deassist(@RequestParam int idActivitie, 
			HttpServletRequest request, HttpServletResponse response, Principal principal)
            throws ServletException, IOException {
		activitieService.deasist(idActivitie, principal.getName());
    	ModelAndView modelAndView = new ModelAndView("jsonView");
    	modelAndView.addObject("result", "OK");
    	return modelAndView;
    }

}
