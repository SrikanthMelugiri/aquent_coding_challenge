**Design decisions made:**

Used Spring MVC with Controller, Service and Repository layers. In future, the repository layer can be extended to connect to any Database to do similar functionality.
Current Application will also handle file path upload through web interface i.e., thorugh FileController. If needed, front end can be modified to take Multipart file as 
input through web interface.

Used JUnit and Mockito (to handle Dependency Injection) for writing test cases.

**Input and Output:**

Data can be inserted either by running the web application or through command line.

Input considered: _sample_data_ordered.txt_

Corresponding output: _sample_data_ordered_result.txt_
 
**To use Web Application:** 

Run the Spring Boot Application. Once the application is started, using POSTMAN (or any similar tool), create a POST request as below. 

URL: _localhost:8080/file/sort_

Request params sent through body:

_inputFilePath_: <<< input file path >>
_outputFilePath_: <<< output file path >>

**Using Command line** 

In command line, once you are in the project location, run **_mvn clean install_** to create the runnable jar in target folder.

To run Jar file:

java -jar aquent-1.0-SNAPSHOT-spring-boot.jar <<< inputFileWithPath >>  <<< outputFileWithPath >>

Use **_mvn test_** to test the application using command line
