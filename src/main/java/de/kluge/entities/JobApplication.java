package de.kluge.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import de.kluge.common.JobApplicationState;

@Entity
public class JobApplication {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    @Temporal(TemporalType.TIMESTAMP)
	private Date created;
    
	@Enumerated
	private JobApplicationState state;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Company company;
}
