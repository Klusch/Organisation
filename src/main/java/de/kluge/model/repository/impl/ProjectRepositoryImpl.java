package de.kluge.model.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import de.kluge.model.repository.ProjectRepository;
import de.kluge.model.repository.ProjectRepositoryCustom;

public class ProjectRepositoryImpl implements ProjectRepositoryCustom {

	@Autowired
	ProjectRepository hsmInstRepo;
	
    @PersistenceContext
    private EntityManager em;
	
    @Override
    @Transactional
	public void deleteChildAssignment(long id) {
		Query q = em.createNativeQuery("DELETE FROM hsm_installation_children WHERE children_id = " + id);
		q.executeUpdate();
	}


}
