package de.kluge.controllers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.kluge.entities.Greeting;

@Controller
public class EntryPointController {

	// value extracted from application.properties
	@Value("${spring.datasource.username}")
	private String deleteProccessedData;
	
	@PostConstruct
	private void init() {
		// Not needed, but to remember
	}

	@GetMapping("/xyz")
	public String index(@RequestParam(value = "auth", required = false, defaultValue = "0") String auth, Model model) {
        return "index";
//		return "nothing in JSON";
	}
	
	//@RequestMapping(path = "/", method = RequestMethod.GET)
	@GetMapping("/test")
    //@ResponseBody
	public String formularTest(@RequestParam(value = "auth", required = false, defaultValue = "0") String auth, Model model) {
	    model.addAttribute("greeting", new Greeting());
        return "greeting";
	}	

    @PostMapping("/")
    public String formularSubmit(@ModelAttribute Greeting greeting) {
        return "result";
    }
	
}
