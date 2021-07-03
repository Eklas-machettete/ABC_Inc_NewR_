package com.global.abcinc.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.global.abcinc.controllers.ABCInchController;
import com.global.abcinc.entities.Project;
import com.global.abcinc.entities.Task;
import com.global.abcinc.model.Reponse;
import com.global.abcinc.repositories.ProjectRepository;
import com.global.abcinc.repositories.TaskRepository;

@Service
public class ProjectService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectService.class);
	@Autowired
	ProjectRepository projectRepository ;
	

	public ResponseEntity<Reponse> addProject(Project project, String projectKey) {
		
	    Reponse resp = new Reponse();
	    resp.setName("add new project: "+projectKey);
	    resp.setRecords_status("SUCCESS");
		project.setProjectId(projectKey);
		try {
			LOGGER.info("Trying to add project with key: "+projectKey);
			 projectRepository.save(project);
			LOGGER.info("Successfully add project with key: "+projectKey);
		} catch (Exception e) {
			LOGGER.info("Failed to add project with key: "+projectKey);
			LOGGER.error(e.getMessage());
			resp.setRecords_status(e.getMessage());
        	resp.setRecords_failed(resp.getRecords_failed()+1);
        	return new ResponseEntity<Reponse>(resp, HttpStatus.BAD_REQUEST);

		}
       
		return new ResponseEntity<Reponse>(resp, HttpStatus.CREATED);
	}


	public List<Project> getProjects() {
		
		return projectRepository.findAll();
	}


	public ResponseEntity<Reponse> updateProject(String projectKey, Project project) {
	    Reponse resp = new Reponse();
	    resp.setName("update new project: "+projectKey);
	    resp.setRecords_status("SUCCESS");
	    if(!(projectRepository.findById(Long.parseLong(projectKey)).isPresent()))
	    {
	    	resp.setRecords_status("FAILED TO FIND PROJECT WITH KEY: "+projectKey);
	    	LOGGER.info("No existing project for key: "+projectKey);
	    	 return new ResponseEntity<Reponse>(resp, HttpStatus.NOT_FOUND);
	    }
		project.setProjectId(project.getProjectId());
		try {
			LOGGER.info("Trying to update project with key: "+projectKey);
			 projectRepository.save(project);
			LOGGER.info("Successfully update project with key: "+projectKey);
		} catch (Exception e) {
			LOGGER.info("Failed to update project with key: "+projectKey);
			LOGGER.error(e.getMessage());
			resp.setRecords_status(e.getMessage());
        	resp.setRecords_failed(resp.getRecords_failed()+1);
        	return new ResponseEntity<Reponse>(resp, HttpStatus.BAD_REQUEST);

		}
       
	      return new ResponseEntity<Reponse>(resp, HttpStatus.OK);
		
	}

	
	
	
	

	public Project getProject(String projectKey){
		try {
			LOGGER.info("Trying to get project with key: "+projectKey);
			projectRepository.findById(Long.parseLong(projectKey));
			
		} catch (Exception e) {
			LOGGER.info("Failed to get project with key: "+projectKey);
			LOGGER.info(e.getMessage());
		}
		
		return null;
	}


	public ResponseEntity<Reponse> deleteProject(String projectKey) {
        Reponse resp = new Reponse();
        resp.setName("Delete project: "+projectKey);
        resp.setRecords_status("SUCCESS");
		try {
			LOGGER.info("Trying to delete project with key: "+projectKey);
			projectRepository.deleteById(Long.parseLong(projectKey));
			LOGGER.info("Successfully delete project with key: "+projectKey);

		} catch (Exception e) {
			LOGGER.info("Failed to delete project with key: "+projectKey);
			LOGGER.error(e.getMessage());
           	resp.setRecords_status(e.getMessage());
           	resp.setRecords_failed(resp.getRecords_failed()+1);
           	//return "COMMENT: "+commentId+" NOT FOUND";
        	return new ResponseEntity<Reponse>(resp, HttpStatus.BAD_REQUEST);
		}
		
	       return new ResponseEntity<Reponse>(resp, HttpStatus.NO_CONTENT);
	}

	
}
