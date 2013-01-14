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
import edu.mx.utvm.congreso.controlador.validator.MainValidator;
import edu.mx.utvm.congreso.dominio.InformationAccount;
import edu.mx.utvm.congreso.dominio.Ocupation;
import edu.mx.utvm.congreso.dominio.PreRegisterInformation;
import edu.mx.utvm.congreso.dominio.University;
import edu.mx.utvm.congreso.dominio.UserRole;
import edu.mx.utvm.congreso.service.CatalogService;
import edu.mx.utvm.congreso.service.InformationAccountService;
import edu.mx.utvm.congreso.service.PreRegisterInformationService;
import edu.mx.utvm.congreso.service.UserRoleService;

@Controller
@RequestMapping("/register")
public class PreRegisterInformationController {
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
	
    @RequestMapping(value="/save", method = RequestMethod.GET)
	public String regresaFormulario() {
    	return "redirect:form";
    }
    
    @RequestMapping(value="/confirm/{token}", method = RequestMethod.GET)
	public ModelAndView confirmaRegistro(@PathVariable("token") String token)
            throws ServletException, IOException {
    	ModelAndView modelAndView = new ModelAndView("register/confirm_success");
		PreRegisterInformation byToken = preRegisterInformationService
				.findPreRegisterInformationByToken(token);
		
    	if(byToken!=null){
    		
        	StringBuffer name = new StringBuffer();
        	name.append(byToken.getName()).append(" ");
        	name.append(byToken.getSecondName()).append(" ");
        	name.append(byToken.getThirdName()).append(" ");
    		
        	Map<String, String> model = new HashMap<String, String>();
        	model.put("nombre", name.toString());
        	model.put("usuario", byToken.getInformationAccount().getEmail());
        	model.put("clave", byToken.getInformationAccount().getPassword());
        	
    		accountService.confirmToken(token, model);
    		
    		/* change role preregistered succes */
    		byToken.getUserRole().setAuthority(UserRole.ROLE_PREREGISTERED_SUCCESS);
    		roleService.update(byToken.getUserRole());
    		
    		modelAndView.addObject("preRegisterInformation", byToken);
    	}
    	
    	return modelAndView;
    }

	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView guardar(HttpServletRequest request,
			@ModelAttribute("formRegister") @Valid FormPreRegister formRegister,
			BindingResult result) {
		
    	ModelAndView modelAndView = new ModelAndView("register/register");
    	modelAndView.addObject("formRegister", formRegister);
    	modelAndView.addObject("result", result);
    	loadCatalogs(modelAndView);
    	
    	if(!result.hasErrors()){	
    		
    		// build object     		
    		InformationAccount informationAccount = new InformationAccount();
    		informationAccount.setEmail(formRegister.getCorreoElectronico());
    		informationAccount.setPassword(formRegister.getClave());
    		informationAccount.setEnabled(0);
    		
    		Ocupation ocupation = new Ocupation();
    		ocupation.setId(Integer.parseInt(formRegister.getIdOcupacion()));
    		
    		University university = new University();
    		university.setId(Integer.parseInt(formRegister.getIdInstitucionProcedencia()));
    		
    		UserRole userRole = new UserRole();
    		userRole.setAuthority(UserRole.ROLE_PREREGISTERED);
    		userRole.setUserId(formRegister.getCorreoElectronico());
    		
    		PreRegisterInformation preRegisterInformation = new PreRegisterInformation();
    		preRegisterInformation.setInformationAccount(informationAccount);
    		preRegisterInformation.setName(formRegister.getNombre());
    		preRegisterInformation.setPhone(formRegister.getTelefono());
    		preRegisterInformation.setSecondName(formRegister.getApellidoPaterno());
    		preRegisterInformation.setThirdName(formRegister.getApellidoMaterno());
    		preRegisterInformation.setOcupation(ocupation);
    		preRegisterInformation.setUniversity(university);
    		preRegisterInformation.setUserRole(userRole);
    		
    		// save object whit service    		
    		preRegisterInformationService.save(preRegisterInformation);
    		
    		modelAndView.setViewName("register/register_success");
    	}    	    			    	
    	return modelAndView;
	}    
	
	@RequestMapping(value="/form")
	public ModelAndView mostrarFormularioRegistro(
			@ModelAttribute("formRegister") FormPreRegister formRegister,
			HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
    	ModelAndView modelAndView = new ModelAndView("register/register");
    	loadCatalogs(modelAndView);	
    	return modelAndView;
    }
    
	@RequestMapping(value="/list_user_preregistered")
	public ModelAndView showListUserPreRegister(
			@ModelAttribute("formRegister") FormPreRegister formRegister,
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
		
    	ModelAndView modelAndView = new ModelAndView("register/list_user_preregistered");
    	modelAndView.addObject("preRegisters", findAllPreRegisters);
    	return modelAndView;
    }
	
	@InitBinder("formRegister")
	protected void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.setValidator(mainValidator);
	}
}
