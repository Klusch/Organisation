package de.kluge.entities;

import java.net.URL;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import de.kluge.common.JobApplicationState;
import de.kluge.common.JobLocation;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "jobs")
public class JobApplication {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Company company;
	
	private String jobTitle;

	private String reference;

	private String recruiter;

	@Enumerated(EnumType.STRING)
	private JobLocation location;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Temporal(TemporalType.TIMESTAMP)
	private Date runTill;

	@Temporal(TemporalType.TIMESTAMP)
	private Date done;
	
	@Enumerated(EnumType.STRING)
	private JobApplicationState state;

	private URL url;
}
