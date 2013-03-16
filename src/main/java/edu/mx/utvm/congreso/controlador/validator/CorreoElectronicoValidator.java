package edu.mx.utvm.congreso.controlador.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import edu.mx.utvm.congreso.controlador.formbeans.FormCapture;
import edu.mx.utvm.congreso.controlador.formbeans.FormPreRegister;
import edu.mx.utvm.congreso.controlador.formbeans.FormRegisterAcademy;
import edu.mx.utvm.congreso.controlador.formbeans.FormRegisterAccount;
import edu.mx.utvm.congreso.controlador.formbeans.FormRegisterParticipation;
import edu.mx.utvm.congreso.service.InformationAccountService;

@Component
public class CorreoElectronicoValidator extends LocalValidatorFactoryBean implements Validator{

	@Autowired
	private InformationAccountService accountService;
	
	@Override
	public void validate(Object object, Errors error) {
		FormRegisterAccount register = (FormRegisterAccount) object;
		if(!register.getCorreoElectronico().equals(register.getConfirmarcorreoElectronico())){
			error.rejectValue("correoElectronico", "correo.confirmacion.validation");
		}else if(accountService.existEmailAccount(register.getCorreoElectronico())){
			error.rejectValue("correoElectronico", "correo.unico.validation");
		}
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(FormRegisterAccount.class)
				|| clazz.isAssignableFrom(FormPreRegister.class)
				|| clazz.isAssignableFrom(FormRegisterParticipation.class)
				|| clazz.isAssignableFrom(FormRegisterAcademy.class) 
				|| clazz.isAssignableFrom(FormCapture.class);
	}

}
