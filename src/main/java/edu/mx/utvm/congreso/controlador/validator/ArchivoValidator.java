package edu.mx.utvm.congreso.controlador.validator;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import edu.mx.utvm.congreso.controlador.formbeans.FormRegisterParticipation;

@Component
public class ArchivoValidator extends LocalValidatorFactoryBean implements Validator{
	
	private String[] supportedFileTypes = {"PDF"};
	
	@Override
	public void validate(Object object, Errors error) {
		super.validate(object, error);
		FormRegisterParticipation register = (FormRegisterParticipation) object;
		if(register.getArchivo().getSize() == 0){
			error.rejectValue("archivo", "archivo.empty.validation");
		}
		
		if(!validateExtensionType(register.getArchivo())){
			error.rejectValue("archivo", "tipoarchivo.empty.validation");
		}
	}
		
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(FormRegisterParticipation.class);
	}

	
  
	private boolean validateExtensionType(CommonsMultipartFile multipartFile) {
		int dotPos = multipartFile.getOriginalFilename().lastIndexOf(".");
		boolean result = false;
		if (dotPos != -1) {
			String extension = multipartFile.getOriginalFilename().substring(
					dotPos + 1);
			final List<String> supportedExtensions = Arrays
					.asList(supportedFileTypes);
			for (String supportedExtension : supportedExtensions) {
				if (extension.equalsIgnoreCase(supportedExtension)) {
					result = true;
					break;
				}
			}
		}
		return result;
	}
}
