package edu.mx.utvm.congreso.controlador;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mx.utvm.congreso.controlador.formbeans.FormPreRegister;
import edu.mx.utvm.congreso.controlador.formbeans.FormRegisterAcademy;
import edu.mx.utvm.congreso.controlador.validator.MainValidator;
import edu.mx.utvm.congreso.dominio.AcademyRegisterInformation;
import edu.mx.utvm.congreso.dominio.InformationAccount;
import edu.mx.utvm.congreso.dominio.University;
import edu.mx.utvm.congreso.service.AcademyRegisterInformationService;
import edu.mx.utvm.congreso.service.CatalogService;
import edu.mx.utvm.congreso.service.InformationAccountService;

@Controller
@RequestMapping("/register_academy")
public class AcademyRegisterInformationController {
	protected final Log log = LogFactory.getLog(getClass());
	
	private List<University> universities;
	
	@Autowired	
	private MainValidator mainValidator;
	
	@Autowired
	private CatalogService catalogService;
	
	@Autowired
	private InformationAccountService accountService; 
	
	@Autowired
	private AcademyRegisterInformationService academyRegisterInformationService;
	
	private void loadCatalogs(ModelAndView model){
		this.universities = catalogService.findAllUniversities();
		model.addObject("universities", this.universities);
	}
	
	
    @RequestMapping(value="/save", method = RequestMethod.GET)
	public String regresaFormulario() {
    	return "redirect:form";
    }
    
    @RequestMapping(value="/confirm/{token}", method = RequestMethod.GET)
	public ModelAndView confirmaRegistro(@PathVariable("token") String token)
            throws ServletException, IOException {
    	ModelAndView modelAndView = new ModelAndView("register_academy/confirm_success");
    	
		AcademyRegisterInformation byToken = academyRegisterInformationService
				.findAcademyRegisterInformationByToken(token);
		
		if(byToken != null){
	    	Map<String, String> properties = new HashMap<String, String>();
        	properties.put("nombre", byToken.getName());
        	properties.put("usuario", byToken.getInformationAccount().getEmail());
        	properties.put("clave", byToken.getInformationAccount().getPassword());
        	
	    	accountService.confirmToken(token, properties);
	    	modelAndView.addObject("academyRegisterInformation", byToken);
		}    	
    	return modelAndView;
    }
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView guardar(HttpServletRequest request,
			@ModelAttribute("formRegisterAcademy") @Valid FormRegisterAcademy formRegisterAcademy,
			BindingResult result) {
		
    	ModelAndView modelAndView = new ModelAndView("register_academy/register");
    	modelAndView.addObject("formRegisterAcademy", formRegisterAcademy);
    	modelAndView.addObject("result", result);
    	loadCatalogs(modelAndView);
    	if(!result.hasErrors()){
    		
    		InformationAccount account = new InformationAccount();
    		account.setEmail(formRegisterAcademy.getCorreoElectronico());
    		account.setPassword(formRegisterAcademy.getClave());
    		
    		University university = new University();
    		university.setId(Integer.parseInt(formRegisterAcademy.getIdInstitucionProcedencia()));
    		
    		AcademyRegisterInformation information = new AcademyRegisterInformation();
    		information.setContact(formRegisterAcademy.getContacto());
    		information.setInvestigationLines(formRegisterAcademy.getLineasDeInvestigacion());
    		information.setName(formRegisterAcademy.getNombreDelCuerpoAcademico());
    		information.setUniversity(university);
    		information.setInformationAccount(account);
    		
    		// save object whit service
    		academyRegisterInformationService.save(information);
    		
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
    	loadCatalogs(modelAndView);
    	return modelAndView;
    }
	
	@RequestMapping(value="/list_academic")
	public ModelAndView showListAcademic(
			@ModelAttribute("formRegister") FormPreRegister formRegister,
			HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		List<AcademyRegisterInformation> findAllAcademyRegisterInformation = academyRegisterInformationService
				.findAllAcademyRegisterInformation();
		
    	ModelAndView modelAndView = new ModelAndView("register_academy/list_academic");
    	modelAndView.addObject("academics", findAllAcademyRegisterInformation);
    	return modelAndView;
    }
    
	@InitBinder("formRegisterAcademy")
	protected void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.setValidator(mainValidator);
	}
	
}
