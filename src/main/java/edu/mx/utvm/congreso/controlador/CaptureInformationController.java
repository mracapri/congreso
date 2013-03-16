package edu.mx.utvm.congreso.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mx.utvm.congreso.controlador.formbeans.FormCapture;
import edu.mx.utvm.congreso.controlador.validator.MainValidator;
import edu.mx.utvm.congreso.dominio.Ocupation;
import edu.mx.utvm.congreso.dominio.University;
import edu.mx.utvm.congreso.service.CatalogService;
import edu.mx.utvm.congreso.service.InformationAccountService;
import edu.mx.utvm.congreso.service.PreRegisterInformationService;
import edu.mx.utvm.congreso.service.UserRoleService;

@Controller
@RequestMapping("/register")
public class CaptureInformationController {
	protected final Log log = LogFactory.getLog(getClass());
	
	private List<Ocupation> ocupations;
	private List<University> universities;	
	
	@Autowired
	private MainValidator mainValidator;
	
	@Autowired
	private CatalogService catalogService;
	
	@Autowired
	private PreRegisterInformationService preRegisterInformationService;
	
	@Autowired
	private InformationAccountService accountService;
	
	@Autowired
	private UserRoleService roleService;
	
	private void loadCatalogs(ModelAndView model){
		this.universities = catalogService.findAllUniversities();
		this.ocupations = catalogService.findAllOcupations();
		model.addObject("ocupations", this.ocupations);
		model.addObject("universities", this.universities);
	} 
	
	
	@RequestMapping(value="/form_capture")
	public ModelAndView mostrarFormularioCaptura(
			@ModelAttribute("formCapture") FormCapture formCapture,
			HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
    	ModelAndView modelAndView = new ModelAndView("register/capture");
    	loadCatalogs(modelAndView);	
    	return modelAndView;
    }
	
	@RequestMapping(value="/save_capture")
	public ModelAndView mostrarFormularioCapturaSave(
			@ModelAttribute("formCapture") FormCapture formCapture,
			HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
    	ModelAndView modelAndView = new ModelAndView("register/capture");
    	loadCatalogs(modelAndView);	
    	return modelAndView;
    }
	
	@RequestMapping(value="/save_capture", method = RequestMethod.POST)
	public ModelAndView saveCaptura(
			@ModelAttribute("formCapture") @Valid FormCapture formCapture,
			BindingResult result)
            throws ServletException, IOException {
		
    	ModelAndView modelAndView = new ModelAndView("register/capture");
    	modelAndView.addObject("result", result);
    	loadCatalogs(modelAndView);	
    	return modelAndView;
    }
	
	@InitBinder("formCapture")
	protected void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.setValidator(mainValidator);
	}
}
