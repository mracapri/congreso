package edu.mx.utvm.congreso.controlador.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import edu.mx.utvm.congreso.controlador.formbeans.FormPreRegister;

@Component
public class ClaveValidator extends LocalValidatorFactoryBean implements Validator{

	@Override
	public void validate(Object object, Errors error) {
		super.validate(object, error);
		FormPreRegister register = (FormPreRegister) object;
		if(!register.getClave().equals(register.getConfirmacionClave())){
			error.rejectValue("claveValidator", "clave.validation");
		}
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(FormPreRegister.class);
	}

}
