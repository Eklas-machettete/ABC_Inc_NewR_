package com.global.abcinc.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.abcinc.entities.Project;
import com.global.abcinc.entities.Task;
import com.global.abcinc.model.Reponse;
import com.global.abcinc.services.ProjectService;
import com.global.abcinc.services.TaskService;

@RestController
@RequestMapping("/projects")
public class ABCInchController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ABCInchController.class);
	
	@Value("${service.host}")
	String hostUrl;
    @Autowired
	ProjectService projectService;
	@Autowired
	TaskService taskService;
	@PostMapping(
  	        value = "/{projectKey}",
  	        consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reponse> addNewProject(@RequestBody Project project, @PathVariable String projectKey) 
         {
    	   LOGGER.trace(hostUrl+projectKey+" access");
   	       return projectService.addProject(project,projectKey) ;
  	    	 
  	     }
     
	
	@PostMapping(
  	        value = "task/{taskKey}",
  	        consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reponse> addNewTask(@RequestBody Task task, @PathVariable String taskKey) 
         {
		 LOGGER.trace(hostUrl+"task/"+taskKey+" access");
   	       return taskService.addNewTask(task,taskKey) ;
  	    	 
  	     }
     
	
	
    @GetMapping(
  	        value = "/allProjects",
  	        produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Project> getProjects( ) 
         {
    	 LOGGER.trace(hostUrl+"/allProjects access");
  	      return (List<Project>) projectService.getProjects();
  	     }
	
	
    @PutMapping(
  	        value = "/{projectKey}",
  	        consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reponse> updateProject(@PathVariable String projectKey, @RequestBody Project project) 
         {
    	   
    	  LOGGER.trace(hostUrl+projectKey +" access");
   	       return projectService.updateProject(projectKey, project) ;
  	    	 
  	     }
    
    @PutMapping(
  	        value = "task/{taskKey}",
  	        consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reponse> updateTask(@RequestBody Task task,@PathVariable String taskKey) 
         {
    	 LOGGER.trace(hostUrl+"task/"+taskKey+" access");
   	       return taskService.updateTask(task,taskKey) ;
  	    	 
  	     }
    
    @GetMapping(
  	        value = "/{projectKey}",
  	        produces = MediaType.APPLICATION_JSON_VALUE)
    public Project getProject(@PathVariable String projectKey) 
         {
    	 LOGGER.trace(hostUrl+projectKey+" access");
    	   return projectService.getProject(projectKey);
  	     }
    
    
    @DeleteMapping(
	        value = "/{projectKey}",
	        produces = MediaType.APPLICATION_JSON_VALUE)
 public ResponseEntity<Reponse> deleteProject(@PathVariable String projectKey ) 
       {
    	   LOGGER.trace(hostUrl+projectKey+" access");
 	       return projectService.deleteProject(projectKey);
	        	
	   }
     

	

}
