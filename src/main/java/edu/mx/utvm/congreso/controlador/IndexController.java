package edu.mx.utvm.congreso.controlador;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.tanesha.recaptcha.ReCaptcha;
import net.tanesha.recaptcha.ReCaptchaFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Value("${CAPTCHA_PUBLIC_KEY}")
	private String captchaPublicKey;
	
	@Value("${CAPTCHA_PRIVATE_KEY}")
	private String captchaPrivateKey;
	
	@Value("${IS_PRODUCTION}")
	private boolean isProductionMode;
	
    @RequestMapping(value="/index.htm")
    public ModelAndView handleIndexRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {      
        Map<String, Object> modelo = new HashMap<String, Object>();        
    	return new ModelAndView("index", "modelo", modelo);
    }
    
	@RequestMapping("/login.htm")
	public ModelAndView getLoginPage(HttpSession session) throws Exception{
		ModelAndView model = new ModelAndView("login");
		if(isProductionMode){
			
			session.setAttribute("captchaPrivateKey", captchaPrivateKey);
			session.setAttribute("isProductionMode", isProductionMode);
			
			ReCaptcha captcha = ReCaptchaFactory.newReCaptcha(
					captchaPublicKey, 
					captchaPrivateKey, 
					false);
			String recaptchaHtml = captcha.createRecaptchaHtml(null, null);
			model.addObject("recaptchaHtml", recaptchaHtml);
			model.addObject("captchaPrivateKey", captchaPrivateKey);
			model.addObject("isProductionMode", isProductionMode);
		}		
		return model;
	}

	@RequestMapping("/user_disabled.htm")
	public ModelAndView getUserDisabledPage(ModelMap model) throws Exception{		
		return new ModelAndView("error_page/user_disabled");
	}		
	
}
