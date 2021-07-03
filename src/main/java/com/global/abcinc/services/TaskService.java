package com.global.abcinc.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.global.abcinc.entities.Task;
import com.global.abcinc.model.Reponse;
import com.global.abcinc.repositories.TaskRepository;

@Service
public class TaskService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectService.class);
	@Autowired
	TaskRepository taskRepository;
	public ResponseEntity<Reponse> addNewTask(Task task, String taskKey) {
        Reponse resp = new Reponse();
        resp.setName("add new task: "+taskKey);
        resp.setRecords_status("SUCCESS");
		try {
			LOGGER.info("Trying to add task with key: "+taskKey);
			task.setTaskId(taskKey);
			taskRepository.save(task);
			LOGGER.info("Successfully add task with key: "+taskKey);
		} catch (Exception e) {
			LOGGER.info("Failed to add task with key: "+taskKey);
			LOGGER.error(e.getMessage());
			resp.setRecords_status(e.getMessage());
        	resp.setRecords_failed(resp.getRecords_failed()+1);
        	return new ResponseEntity<Reponse>(resp, HttpStatus.BAD_REQUEST);

		}
		
		return null;
	}
	public ResponseEntity<Reponse> updateTask(Task task, String taskKey) {
        Reponse resp = new Reponse();
        resp.setName("add new project: "+taskKey);
        resp.setRecords_status("SUCCESS");
        if(!(taskRepository.findById(Long.parseLong(taskKey)).isPresent()))
	    {
	    	resp.setRecords_status("FAILED TO FIND PROJECT WITH KEY: "+taskKey);
	    	LOGGER.info("No existing project for key: "+taskKey);
	    	 return new ResponseEntity<Reponse>(resp, HttpStatus.NOT_FOUND);
	    }
		task.setTaskId(task.getTaskId());
		try {
			LOGGER.info("Trying to update task with key: "+taskKey);
			 task.setTaskId(taskKey);
			 taskRepository.save(task);
			LOGGER.info("Successfully update project with key: "+taskKey);

		} catch (Exception e) {
			LOGGER.info("Failed to update task with key: "+taskKey);
			LOGGER.error(e.getMessage());
			resp.setRecords_status(e.getMessage());
        	resp.setRecords_failed(resp.getRecords_failed()+1);
        	return new ResponseEntity<Reponse>(resp, HttpStatus.BAD_REQUEST);

			
		}
		 return null;
	}


}
