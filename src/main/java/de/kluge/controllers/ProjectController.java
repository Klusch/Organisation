package de.kluge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.kluge.entities.Project;
import de.kluge.model.repositories.ProjectRepository;

@Controller
@RequestMapping( "/projects" )
public class ProjectController {

	@Autowired
	private ProjectRepository myProjectRepository;

	@RequestMapping("/")
	@ResponseBody
	public Iterable<Project> read(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		Iterable<Project> allProjects = myProjectRepository.findAll();

		return allProjects;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getListe(Model model) {
		model.addAttribute("entitiesListe", myProjectRepository.findAll());
		return "upload2";
	}

}
