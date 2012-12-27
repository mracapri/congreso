package edu.mx.utvm.congreso.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mx.utvm.congreso.controlador.formbeans.FormFiscalData;

@Controller
@RequestMapping("/register_fiscal_data")
public class FiscalDataRegisterInformationController {
	protected final Log log = LogFactory.getLog(getClass());	
	
    @RequestMapping(value="/save", method = RequestMethod.GET)
	public String regresaFormulario() {
    	return "redirect:form";
    }    
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView guardar(HttpServletRequest request,
			@ModelAttribute("formFiscalData") @Valid FormFiscalData formFiscalData,
			BindingResult result) {

		
    	ModelAndView modelAndView = new ModelAndView("register_fiscal_data/register");
    	modelAndView.addObject("formFiscalData", formFiscalData);
    	modelAndView.addObject("result", result);
    	
    	if(!result.hasErrors()){	
    		log.debug("Guardando datos");
    		modelAndView.setViewName("register_fiscal_data/register_success");
    	}    	    			    	
    	return modelAndView;
	}    

	@RequestMapping(value="/form")
	public ModelAndView mostrarFormularioRegistro(
			@ModelAttribute("formFiscalData") FormFiscalData formFiscalData,
			HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	ModelAndView modelAndView = new ModelAndView("register_fiscal_data/register");
    	return modelAndView;
    }
    
	@InitBinder("formFiscalData")
	protected void initBinder(WebDataBinder webDataBinder) {

	}
	
}
