package org.lab.network.diagnostic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping("/")
	public ModelAndView home(ModelMap model) {
		return new ModelAndView("redirect:/swagger-ui.html", model);
	}
}
