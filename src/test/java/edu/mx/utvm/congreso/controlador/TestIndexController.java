package edu.mx.utvm.congreso.controlador;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class TestIndexController {
	@Test
	public void testIndexRequest() throws Exception, Exception{
		IndexController controller = new IndexController();
		ModelAndView modelAndView = controller.handleIndexRequest(null, null);
		Assert.assertEquals("index", modelAndView.getViewName());
		Assert.assertNotNull(modelAndView.getModel());
	}
}