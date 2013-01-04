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
import edu.mx.utvm.congreso.controlador.formbeans.FormRegisterParticipation;
import edu.mx.utvm.congreso.controlador.validator.MainValidator;
import edu.mx.utvm.congreso.dominio.InformationAccount;
import edu.mx.utvm.congreso.dominio.Ocupation;
import edu.mx.utvm.congreso.dominio.Participation;
import edu.mx.utvm.congreso.dominio.ParticipationRegisterInformation;
import edu.mx.utvm.congreso.dominio.University;
import edu.mx.utvm.congreso.dominio.UserRole;
import edu.mx.utvm.congreso.service.CatalogService;
import edu.mx.utvm.congreso.service.InformationAccountService;
import edu.mx.utvm.congreso.service.ParticipationRegisterInformationService;

@Controller
@RequestMapping("/register_participation")
public class ParticipationRegisterInformationController {
	protected final Log log = LogFactory.getLog(getClass());
	
	private List<Ocupation> ocupations;
	private List<University> universities;
	private List<Participation> participations;		
	
	@Autowired
	private MainValidator mainValidator;
	
	@Autowired
	private CatalogService catalogService;
	
	@Autowired
	private InformationAccountService accountService; 
	
	@Autowired
	private ParticipationRegisterInformationService informationService; 
	
    @RequestMapping(value="/save", method = RequestMethod.GET)
	public String regresaFormulario() {
    	return "redirect:form";
    }
    
    @RequestMapping(value="/confirm/{token}", method = RequestMethod.GET)
	public ModelAndView confirmaRegistro(@PathVariable("token") String token)
            throws ServletException, IOException {
    	ModelAndView modelAndView = new ModelAndView("register_participation/confirm_success");
    	
		ParticipationRegisterInformation byToken = informationService
				.findParticipationRegisterInformationByToken(token);
    	
		if(byToken!=null){
        	StringBuffer name = new StringBuffer();
        	name.append(byToken.getName()).append(" ");
        	name.append(byToken.getSecondName()).append(" ");
        	name.append(byToken.getThirdName()).append(" ");
    	
        	Map<String, String> properties = new HashMap<String, String>();
        	properties.put("nombre", name.toString());
        	properties.put("usuario", byToken.getInformationAccount().getEmail());
        	properties.put("clave", byToken.getInformationAccount().getPassword());
        	
        	accountService.confirmToken(token, properties);
        	modelAndView.addObject("participationInformation", byToken);
		}
    	return modelAndView;
    }
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView guardar(HttpServletRequest request,
			@ModelAttribute("formRegisterParticipation") @Valid FormRegisterParticipation formRegisterParticipation,
			BindingResult result) {
		
    	ModelAndView modelAndView = new ModelAndView("register_participation/register");
    	modelAndView.addObject("formRegisterParticipation", formRegisterParticipation);
    	modelAndView.addObject("result", result);    	
    	loadCatalogs(modelAndView);    	
    	
    	if(!result.hasErrors()){	
    		
    		// build object     		
    		InformationAccount informationAccount = new InformationAccount();
    		informationAccount.setEmail(formRegisterParticipation.getCorreoElectronico());
    		informationAccount.setPassword(formRegisterParticipation.getClave());
    		informationAccount.setEnabled(0);
    		
    		Ocupation ocupation = new Ocupation();
    		ocupation.setId(Integer.parseInt(formRegisterParticipation.getIdOcupacion()));
    		
    		University university = new University();
    		university.setId(Integer.parseInt(formRegisterParticipation.getIdInstitucionProcedencia()));
    		
    		Participation participation = new Participation();
    		participation.setId(Integer.parseInt(formRegisterParticipation.getIdTipoParticipacion()));
    		
    		UserRole userRole = new UserRole();
    		userRole.setAuthority(UserRole.ROLE_REGISTER_PARTICIPATION);
    		userRole.setUserId(formRegisterParticipation.getCorreoElectronico());
    		
    		ParticipationRegisterInformation participationRegisterInformation = new ParticipationRegisterInformation();
    		participationRegisterInformation.setInformationAccount(informationAccount);
    		participationRegisterInformation.setName(formRegisterParticipation.getNombre());    		
    		participationRegisterInformation.setSecondName(formRegisterParticipation.getApellidoPaterno());
    		participationRegisterInformation.setThirdName(formRegisterParticipation.getApellidoMaterno());
    		participationRegisterInformation.setPhone(formRegisterParticipation.getTelefono());
    		participationRegisterInformation.setParticipationName(formRegisterParticipation.getNombreDeLaParticipacion());
    		participationRegisterInformation.setOcupation(ocupation);
    		participationRegisterInformation.setUniversity(university);
    		participationRegisterInformation.setParticipation(participation);
    		participationRegisterInformation.setParticipationFile(formRegisterParticipation.getArchivo().getBytes());
    		participationRegisterInformation.setParticipationFileName(formRegisterParticipation.getArchivo().getOriginalFilename());    		    		
    		participationRegisterInformation.setUserRole(userRole);
    		
    		// save object whit service    		
    		informationService.save(participationRegisterInformation);    		
    		
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
    	loadCatalogs(modelAndView);
    	return modelAndView;
    }

	@RequestMapping(value="/list_user_participation")
	public ModelAndView showListUserPreRegister(
			@ModelAttribute("formRegister") FormPreRegister formRegister,
			HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		String searchParameter = request.getParameter("search-param");		
		log.debug("PARAMETRO DE BUSQUEDA: " + searchParameter);
		
		List<ParticipationRegisterInformation> findAllParticipants;
		if(searchParameter != null && !searchParameter.equals("")){
			findAllParticipants = informationService.findAllParticipationRegistersByParamSearch(searchParameter);				
		}else{
			findAllParticipants = informationService.findAllParticipationRegisters();
		}
		
    	ModelAndView modelAndView = new ModelAndView("register_participation/list_user_participation");
    	modelAndView.addObject("participants", findAllParticipants);
    	return modelAndView;
    }
	
    @RequestMapping(value="/show_pdf_file/{token}", method = RequestMethod.GET)
	public void showPdfFile(@PathVariable("token") String token,
			HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    	
    	
		ParticipationRegisterInformation byToken = informationService
				.findParticipationRegisterInformationByToken(token);
    	
		if(byToken!=null){
	    	response.setContentType("application/pdf");
	    	response.getOutputStream().write(byToken.getParticipationFile());
		}
    }
	
	@InitBinder("formRegisterParticipation")
	protected void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.setValidator(mainValidator);
	}

	private void loadCatalogs(ModelAndView model){
		this.universities = catalogService.findAllUniversities();
		this.ocupations = catalogService.findAllOcupations();
		this.participations = catalogService.findAllParticipations();
		model.addObject("ocupations", this.ocupations);
		model.addObject("universities", this.universities);
		model.addObject("participations", this.participations);
	}
}