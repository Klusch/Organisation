package de.kluge.model.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import de.kluge.model.Project;

@Transactional
public interface ProjectRepository extends CrudRepository<Project, Long>, ProjectRepositoryCustom {

	public List<Project> findById(long id);
	
}