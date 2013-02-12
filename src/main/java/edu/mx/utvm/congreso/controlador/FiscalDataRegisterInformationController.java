package edu.mx.utvm.congreso.controlador;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mx.utvm.congreso.controlador.formbeans.FormFiscalData;
import edu.mx.utvm.congreso.dominio.FiscalRegisterInformation;
import edu.mx.utvm.congreso.service.FiscalRegisterInformationService;

@Controller
@RequestMapping("/register_fiscal_data")
public class FiscalDataRegisterInformationController {
	protected final Log log = LogFactory.getLog(getClass());	

	@Autowired
	private FiscalRegisterInformationService informationService;
	
    @RequestMapping(value="/save", method = RequestMethod.GET)
	public String regresaFormulario() {
    	return "redirect:form";
    }    
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView guardar(HttpServletRequest request,
			@ModelAttribute("formFiscalData") @Valid FormFiscalData formFiscalData,
			BindingResult result, Principal principal) {

    	ModelAndView modelAndView = new ModelAndView("register_fiscal_data/register");
    	modelAndView.addObject("formFiscalData", formFiscalData);
    	modelAndView.addObject("result", result);
    	if(!result.hasErrors()){
    		FiscalRegisterInformation information = new FiscalRegisterInformation();
    		information.setAddress(formFiscalData.getDireccion());
    		information.setEmail(principal.getName());
    		information.setFiscalName(formFiscalData.getNombreFiscal());
    		information.setRfc(formFiscalData.getRfc());

    		FiscalRegisterInformation fiscalData = informationService.read(principal.getName());
    		if(fiscalData == null){
    			// save
    			informationService.save(information);
    		}else{
    			// update
    			informationService.update(information);
    		}
    		
    		
    		modelAndView.setViewName("register_fiscal_data/register_success");
    	}    	    			    	
    	return modelAndView;
	}

	@RequestMapping(value="/form")
	public ModelAndView mostrarFormularioRegistro(
			@ModelAttribute("formFiscalData") FormFiscalData formFiscalData,
			HttpServletRequest request, HttpServletResponse response, 
			Principal principal)
            throws ServletException, IOException {		
		FiscalRegisterInformation fiscalData = informationService.read(principal.getName());
		if(fiscalData != null){
			formFiscalData.setDireccion(fiscalData.getAddress());
			formFiscalData.setNombreFiscal(fiscalData.getFiscalName());
			formFiscalData.setRfc(fiscalData.getRfc());			
		}
    	ModelAndView modelAndView = new ModelAndView("register_fiscal_data/register");
    	
    	return modelAndView;
    }
	
	@RequestMapping(value="/get/{token}")
	public String consultarRfc(
			HttpServletRequest request, HttpServletResponse response, 
			Principal principal, ModelMap map )
            throws ServletException, IOException {
		FiscalRegisterInformation o = new FiscalRegisterInformation();
    	map.put("rfc", o);
    	return "jsonView";
    }
    
	@InitBinder("formFiscalData")
	protected void initBinder(WebDataBinder webDataBinder) {
	}
	
}