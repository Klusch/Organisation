package de.kluge.model.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import de.kluge.entities.JobApplication;

@Transactional
public interface JobApplicationRepository extends CrudRepository<JobApplication, String> {
	
}