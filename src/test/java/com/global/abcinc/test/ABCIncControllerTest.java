package com.global.abcinc.test;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import com.global.abcinc.controllers.ABCInchController;
import com.global.abcinc.services.ProjectService;
import com.global.abcinc.services.TaskService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ABCIncControllerTest 
{
    @LocalServerPort
    int randomServerPort;
	@Value("${service.host}")
	String lUri;
	@Autowired
    private MockMvc mockMvc;
    @Mock
    private ProjectService projectService;
    @Mock
    private TaskService taskService;
    @InjectMocks
    ABCInchController abcInchController;
    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(abcInchController)
                .build();
    }

    
    	
    	@Test
    	public void testgetAllProjects() throws URISyntaxException 
    	{
    	    RestTemplate restTemplate = new RestTemplate();
    	    final String baseUrl = lUri+"allProjects";
    	    URI uri = new URI(baseUrl);
    	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
    	    Assert.assertEquals(200, result.getStatusCodeValue());
    	    Assert.assertEquals(true, result.getBody().contains("p1"));
    	}
    	
    	
    
        @Test
        public void testAddProject() throws Exception {

        	String j =  "{\"projectId\":\"nn\",\"description\":\"ss\",\"projectName\":\"p1\",\"status\":\"d\",\"tasks\":[{\"taskId\":\"1002\",\"projectName\":\"p1\",\"task_name\":\"nn\",\"status\":\"dd\"}]}";
            mockMvc.perform(post( "/projects/1001")
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(j))
                    .andExpect(status().isCreated())
                    .andExpect(MockMvcResultMatchers.jsonPath("records_status").exists());

       }
        
        @Test
        public void testAddTask() throws Exception {

        	String j =  "{\"taskId\":\"1002\",\"projectName\":\"p1\",\"task_name\":\"nn\",\"status\":\"dd\"}";
            mockMvc.perform(post( "/projects/task/1002")
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(j))
                    .andExpect(status().isCreated())
                    .andExpect(MockMvcResultMatchers.jsonPath("records_status").exists());

       }
        
       
        
        

    	}
