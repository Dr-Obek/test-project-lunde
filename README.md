# Contact Form – Lundegaard Admission Test Project
## Synopsis
This simple web application processes filling and submitting a contact form at http://localhost:8080.
## Motivation
The application is a result of an admission test project by Lundegaard.
## API
OpenAPI available at http://localhost:8080/swagger-ui.html on application runtime.
## Install & run
The application can be build using ```mvn clean install```.
The built .jar file can be found in ~/target folder and run using ```java -jar test-0.0.1-SNAPSHOT.jar```.
## To be done
<ul>
<li>Connect to real database (PostgreSQL, ...)</li>
<li>Implement security (e.g. java.security, ...)</li>
<li>Dockerize the application</li>
<li>Improve Javadoc</li>
<li>Make FE dynamically defined (BE using Thymeleaf)</li>
<li>Better error handling on FE</li>
</ul>