package de.kluge.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import de.kluge.model.Project;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProjectControllerTest {

	@Autowired
	private ProjectController myProjectController;

	private Project parent;
	private Project child;
	
	@Before
	public void createSampleParentProject() {
		parent = new Project();
	}
	
	@Before
	public void createSampleChildProject() {
		child = new Project();
	}	
	
	private void updateParent(Project parent, Project child) {
		Collection<Project> children = parent.getChildren();
		children.add(child);
		parent.setChildren(children);
		
//		myProjectController.createOrUpdate(parent);
	}
	
	@Test
	public void testIfChildAndParentNotEquals() {
//		myProjectController.createOrUpdate(parent);
//		myProjectController.createOrUpdate(child);
		
		updateParent(parent, child);
		assertThat(parent).isNotEqualTo(child);
	}

	@Test
	public void testIfChildIsEqualsAfterPersistence() {
		
	}
	
	@Test
	public void testIfParentIsEqualsAfterPersistence() {
		
	}	
	
}
