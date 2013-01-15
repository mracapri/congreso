package edu.mx.utvm.congreso.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.mx.utvm.congreso.controlador.formbeans.FormPreRegister;
import edu.mx.utvm.congreso.service.ChartService;

@Controller
@RequestMapping("/chart")
public class ChartController {
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private ChartService chartService;	
	
	@RequestMapping(value="/chart_preregister_status")
	public ModelAndView showChartPreRegisterStatus(
			@ModelAttribute("formRegister") FormPreRegister formRegister,
			HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
    	ModelAndView modelAndView = new ModelAndView("chart/chart_preregister_status");
    	modelAndView.addObject("dataChart", chartService.getDataToChartPreregisterStatus());
    	return modelAndView;
    }	

	@RequestMapping(value="/chart_participants_academics")
	public ModelAndView showChartParticipantsAcademic(
			@ModelAttribute("formRegister") FormPreRegister formRegister,
			HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
    	ModelAndView modelAndView = new ModelAndView("chart/chart_participants_academics");
    	modelAndView.addObject("dataChart", chartService.getDataToChartParticipationRegister());
    	return modelAndView;
    }
}
