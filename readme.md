# Springboot CRUD Application - Movie
## This is a sample springboot application with CRUD operations on Movie. 

#### Pre-requisites:
- Install java (JDK) - 1.8 or higher
- Install maven
- Install IDE of your choice
- H2 database is used by default. You can change it with any other RDBMS.

#### Run/Start this application in local environment:
- Open terminal and goto the location where pom.xml is present:  
	- <code>$ mvn spring-boot:run</code>
- Open project in IDE and run springboot application

#### Below are Rest endpoints available in the project

GET http://localhost:8080/api/movies  
###  
POST http://localhost:8080/api/movies  
content-type: application/json  

{  
&emsp; "title":"Movie_1",  
&emsp; "director":"Director_1",  
&emsp; "release":"2020-12-21",  
&emsp; "rating": 3.4  
}  
###

GET http://localhost:8080/api/movies/1  
###  

PUT http://localhost:8080/api/movies/1  
content-type: application/json  

{  
&emsp; "title":"Movie_1",  
&emsp; "director":"Director_1",  
&emsp; "release":"2020-12-21",  
&emsp; "rating": 4.5  
}  
###  

DELETE  http://localhost:8080/api/movies/1  
###  



#### To run database queries and see database recoreds visually

Open browser and use below link  
- <a>http://localhost:8080/h2-console</a>  

Database credentials  
- username=sa  
- password=  
