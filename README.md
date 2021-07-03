                                     REST APIs 

Create Project
Create a project
POST/projects/{projectKey}
Request example:

{
"projectId": "nn",
"description": "ss",
"projectName":"p1",
"status": "d",
"tasks":[{
"taskId": "1002", 
 "projectName" : "p1"  ,
"task_name": "nn",
"status": "dd"

}]
}



Response:
201 created 
404 not found
400 bad request 


Create Task
Create a task
POST/projects/task/{taskKey}
Request example:

{
"
"taskId": "1002", 
 "projectName" : "p1"  ,
"task_name": "nn",
"status": "dd"

}




Response:
201 created 
404 not found
400 bad request 




Update Project
Edit any field of existing project
PUT/project/{projectKey}
Request example:
{
"projectId": "nn",
"description": "ss",
"projectName":"p1",
"status": "d",
"tasks":[{
"taskId": "1002", 
 "projectName" : "p1"  ,
"task_name": "nn",
"status": "dd"

}]
}


Response:
200 OK
Update Task
Edit any field of existing task
PUT/project/task/{taskKey}
Request example:
"taskId": "1002", 
 "projectName" : "p1"  ,
"task_name": "nn",
"status": "dd"

}



Response:
200 OK

Get a Project
GET/projects/{projectKey}
Response:
200 Ok



Delete a project

Get all tasks of a specific project using project id

DELETE/ projects/{projectKey}
Response: 
201 NO CONTENT



1.	https://github.com/Eklas-machettete/stack_Imp
2.	https://github.com/Eklas-machettete/ABC_Inc_NewR_

