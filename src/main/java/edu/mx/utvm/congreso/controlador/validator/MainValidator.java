package edu.mx.utvm.congreso.controlador.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import edu.mx.utvm.congreso.controlador.formbeans.FormPreRegister;
import edu.mx.utvm.congreso.controlador.formbeans.FormRegisterAcademy;
import edu.mx.utvm.congreso.controlador.formbeans.FormRegisterAccount;
import edu.mx.utvm.congreso.controlador.formbeans.FormRegisterParticipation;

@Component
public class MainValidator extends LocalValidatorFactoryBean implements Validator{

	@Autowired
	private ClaveValidator claveValidator;
	
	@Autowired
	private ArchivoValidator archivoValidator;
	
	@Autowired
	private CorreoElectronicoValidator electronicoValidator;	
	
	@Override
	public void validate(Object object, Errors error) {
		super.validate(object, error);
		
		if(FormPreRegister.class.isAssignableFrom(object.getClass())){
			claveValidator.validate(object, error);
			electronicoValidator.validate(object, error);	
		}else if(FormRegisterParticipation.class.isAssignableFrom(object.getClass())){
			claveValidator.validate(object, error);
			electronicoValidator.validate(object, error);
			archivoValidator.validate(object, error);
		}else if(FormRegisterAcademy.class.isAssignableFrom(object.getClass())){
			claveValidator.validate(object, error);
			electronicoValidator.validate(object, error);
		}
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(FormRegisterAccount.class)
				|| clazz.isAssignableFrom(FormPreRegister.class)
				|| clazz.isAssignableFrom(FormRegisterParticipation.class)
				|| clazz.isAssignableFrom(FormRegisterAcademy.class);
	}

}
