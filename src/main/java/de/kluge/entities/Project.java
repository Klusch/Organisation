package de.kluge.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import de.kluge.common.Priority;

@Entity
@Table(name = "project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private Priority priority;
	
	@OneToMany(mappedBy = "parent")
	private Collection<Project> children;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Project parent;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Collection<Project> getChildren() {
		return children;
	}

	public void setChildren(Collection<Project> children) {
		this.children = children;
	}

	public Project getParent() {
		return parent;
	}

	public void setParent(Project parent) {
		this.parent = parent;
	}

}
