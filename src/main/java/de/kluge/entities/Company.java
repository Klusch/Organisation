package de.kluge.entities;

import java.util.Collection;

import javax.persistence.OneToMany;

public class Company {

	@OneToMany(mappedBy="company") 
	private Collection<JobApplication> jobApplications;
	
}
