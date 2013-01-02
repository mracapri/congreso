package edu.mx.utvm.congreso.controlador;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mx.utvm.congreso.controlador.formbeans.FormPaymentData;
import edu.mx.utvm.congreso.service.PreRegisterInformationService;

@Controller
@RequestMapping("/payment")
public class PaymentController {
	protected final Log log = LogFactory.getLog(getClass());	
	
	
	@Autowired
	private PreRegisterInformationService registerInformationService;
	
    @RequestMapping(value="/save", method = RequestMethod.GET)
	public String saveGet(@ModelAttribute("formPaymentData") FormPaymentData formPaymentData) {
    	return "redirect:form/" + formPaymentData.getToken();
    }

    @RequestMapping(value="/form/{token}", method = RequestMethod.GET)
	public ModelAndView formGet(@PathVariable("token") String token, 
			@ModelAttribute("formPaymentData") FormPaymentData formPaymentData,
			HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	boolean paymentStatus = registerInformationService.getPaymentStatus(token);
    	formPaymentData.setToken(token);
    	formPaymentData.setStatus(paymentStatus);
    	
    	ModelAndView modelAndView = new ModelAndView("payment/payment");
    	return modelAndView;
    }
    
    
    @RequestMapping(value="/payment_ticket", method = RequestMethod.GET)
	public ModelAndView paymentTicket(Principal principal, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    	    	
    	ModelAndView modelAndView = new ModelAndView("payment/payment_ticket");
    	log.debug("PRINCIPAL: " + principal.getName());
    	return modelAndView;
    }    
    
    @RequestMapping(value="/save", method = RequestMethod.POST)
	public String savePost(
			@ModelAttribute("formPaymentData") FormPaymentData formPaymentData,
			HttpServletRequest request, HttpServletResponse response)    		
					throws ServletException, IOException {
    	registerInformationService.changePaymentStatus(formPaymentData.getStatus(), formPaymentData.getToken());
    	return "redirect:/resolver/register/list_user_preregistered";
    }
    
	@InitBinder("formPaymentData")
	protected void initBinder(WebDataBinder webDataBinder) {
	}
	
}