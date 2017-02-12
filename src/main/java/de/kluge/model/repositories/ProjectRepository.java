package de.kluge.model.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import de.kluge.entities.Project;

@Transactional
public interface ProjectRepository extends CrudRepository<Project, Long>, ProjectRepositoryCustom {

	public List<Project> findById(long id);
	
}