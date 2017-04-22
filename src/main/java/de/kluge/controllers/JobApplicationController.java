package de.kluge.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.kluge.entities.JobApplication;
import de.kluge.model.repositories.JobApplicationRepository;

@Controller
public class JobApplicationController {

	@Autowired
	private JobApplicationRepository jobRepo;
	
	@RequestMapping("/jobs/view")
	public String view(@RequestParam(value = "id", required = false) String id, Model model) {

		model.addAttribute("headings", headingsForTable());
		
		Iterable<JobApplication> jobs = jobRepo.findAll();
		
		model.addAttribute("jobs", jobs);

		return "jobapplication/index";
	}

    @PostMapping("/jobs/add")
    public String greetingSubmit(@ModelAttribute JobApplication greeting) {
        return "jobapplication/result";
    }
	
	private List<String> headingsForTable() {
		List<String> headings = new ArrayList<>();
		headings.add("Jobtitel");
		headings.add("Bewerbung bis");
		headings.add("Stellenreferenz");
		headings.add("Standort");
		headings.add("Bewerbungsstatus");
		return headings;
	}

}
