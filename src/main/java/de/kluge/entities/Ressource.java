package de.kluge.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import de.kluge.common.Priority;
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
public class Ressource {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;

	public String name;

	public String description;

	public String url;

	public String file;

	@Enumerated(EnumType.STRING)
	public Priority priority = Priority.NOT_IMPORTEND_NOT_URGENT_3;

	@Temporal(TemporalType.TIMESTAMP)
	public Date created = new Date();

	@Temporal(TemporalType.TIMESTAMP)
	public Date modified = new Date();

}