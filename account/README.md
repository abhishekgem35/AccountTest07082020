#Account Management - Spring Boot App

Sample application to build REST APIs needed to view accounts and subsequent transactions on accounts using [Spring Boot](http://projects.spring.io/spring-boot/).

##Requirements
For building and running the application you need:
- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

##Built with
### Data
* 	[MongoDB](https://www.mongodb.com) - JSON-like document based database
 
   Cloud 'MongoDB Atlas' service is used for document data management

### Server - Backend
* 	[JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* 	[Maven](https://maven.apache.org/) - Dependency Management 

###  Libraries and Plugins
* 	[Lombok](https://projectlombok.org/) - Never write another getter or equals method again, with one annotation your class has a fully featured builder, Automate your logging variables, and much more.
* 	[Swagger](https://swagger.io/) - Open-Source software framework backed by a large ecosystem of tools that helps developers design, build, document, and consume RESTful Web services.

### External Tools Used
* 	[Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation)
    
   Use Postman exported file `CustomerAccounts.postman_collection.json` attached in source code

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.anz.account.AccountApplication` class from your IDE.

* 	Download the zip or clone the Git repository.
* 	Unzip the zip file (if you downloaded one)
* 	Open Command Prompt and Change directory (cd) to folder containing pom.xml
* 	Open Eclipse
	* File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
	* Select the project
* 	Choose the Spring Boot Application file (search for @SpringBootApplication)
* 	Right Click on the file and Run as Java Application

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

The app will start running at <http://localhost:8102>

## Documentation
* 	[Postman Collection](https://github.com/abhishekgem35/AccountTest07082020/blob/master/CustomerAccounts.postman_collection.json) - offline
* 	[Swagger](http://localhost:8102/v1/customer/swagger-ui/index.html?configUrl=/v1/customer/v3/api-docs/swagger-config) - Documentation

## Packages
* 	`model` - to hold our response entities;
* 	`service` - to hold our business logic;
* 	`exception` - to hold custom exception handling;
* 	`controller` - to listen to the client;
* 	`resources` - Contains all the static resources, templates and property files;

## Rest APIs

The application defines following CRUD APIs.

### URLs
|  URL |  Method | Remarks |
|----------|--------------|--------------|
|`http://127.0.0.1:8102/v1/customer/createAccount`                 | POST| Create an Account               |
|`http://127.0.0.1:8102/v1/customer/accounts`                      | GET | Get all accounts                |
|`http://127.0.0.1:8102/v1/customer/account/123-11`                | GET | Get account details with number |
|`http://127.0.0.1:8102/v1/customer/createTransaction`             | PUT | Update account with transaction |
|`http://127.0.0.1:8102/v1/customer/transactions/234-22`           | GET | Get transactions of account     |


## Reporting Issues

This Project uses GitHub's integrated issue tracking system to record bugs and feature requests:

* 	To report any issue, [create a new issue](https://github.com/abhishekgem35/AccountTest07082020/issues/new)
