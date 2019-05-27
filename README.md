# codacyTests

## Requirements
  ### To run directly from the project 
   * Java
   * Maven
   * Chrome and Firefox webdriver or Remote webdriver
    
  ### To run with docker-compose   
   * Docker
   * Selenium Grid 

## Getting Started
    
   I divided the work in two parts: the fwk (bugcatcher) that deals with the wraper arround the Selenium and RestAssured packages, 
    and codacyTests, that uses that fwk as a dependency and it's where the tests are. In order to install the fwk you have to 
    go to the build directory and run the following command:
   * '$mvn install:install-file -Dfile=bugcatcher-1.0-SNAPSHOT.jar -DgroupId=QAE -DartifactId=bugcatcher -Dversion=1.0-SNAPSHOT -Dpackaging=jar'
    
   
   You can also find the projects on the following url:
    -> Bugcatcher https://github.com/jonacarvalheiro/bugcatcher
    -> CodacyTests https://github.com/jonacarvalheiro/codacyTests

## 1 - Configuration

### 1.1 - Remote Webdriver vs Local Webdriver
   * To run with remote webdriver, please go to the selenium/selenium-config.json and set the remote to true. 
        NOTE: Please don't forget to put the Selenium Grid url on the url variable ( default is http://localhost:4444/wd/hub).
   * To run with local webdriver please set remote to false, and make sure you have the webdrivers downloaded and 
        the add  the folder that contains the webdriver to the Path in the system environment variables (e.g. C:/Webdrivers)
### 1.2 - Chrome of Firefox
   * You can choose between firefox and chrome browser. You can set this on the selenium-config.json in "browserName"

## 2 - Tests
     
### 2.1 - Tags

#### 2.1.1 @Login 
   * Login test with google account in Codacy
#### 2.1.2 @CommitStatus  
   * API test. Makes a commit with a file through the jgit package on a dummy repository in Github, make a api request with a await for the response to be "Analysed". On the final, do another commit to delete that file.
#### 2.1.3 @AddRemoveProject  
   * End to end scenario. Login -> Add a project -> Remove a project;
      
      NOTE: Since we don't have many api endpoint to satisfy the tests pre condition had to put the Add and Remove functionality on the same
      test.T The delete project endpoint is not working as expected, more information on the BUG TAB ( please see 3.4 )
      
      
## 3 - Challenge questions

   
   You'll find the answer to the questions on this [Google Sheet](https://docs.google.com/spreadsheets/d/1fnQsB2RpwlVcAyIbQfD89vLer4uHOk4jYirLqub8CMg/edit#gid=701704961).
    
### 3.1 - PART 1 - Test Plan
   * Is specificated with two diagrams, one with the types of tests we could do on the application, another with the testing workflow ( All the QA work that could be involved in all phases)
### 3.2 - PART 1 - Tools Integration
   * Example of tools we can use in order to achieve the previous Test Plan
### 3.3 - PART 2 - Test Definition
   * A Tests definition battery with most of the application features specified and wich kind of tests we could do on each one.
     Is also specified to which test battery it bellongs and if it's manual or automated tests.
### 3.4 - PART 1 - BUGS
   * Description of some bugs I found during the challenge
        
 
## 4 - Execution
   You can run tests in 3 different ways:
	
* Docker-compose
* Maven;
	
###	4.1 - Feature file (Intellij IDEA)
* Right-click on the feature you want to run and click run.

###	4.2 - Docker-compose
   * Please make sure you have the Docker Image already build (see 5)
   * Define the tag you want to run, and add it to the CUCUMBER_OPTIONS in env-file.env.
   * Go to selenium-grid folder and run docker-compose up -d to raise Selenium Grid
   * Run the command docker-compose up -d
### 4.3 - Maven
   * Open cmd or Git Bash in your project directory;
   * Run the following command:
		 'mvn clean test -Dcucumber.options="--tags @ExampleTag"'.

## 5 - Build Docker Image

   * Inside the build folder you will find 4 files and one folder :
        - codacyTests.tar.gz
        - selenium-grid/
        - docker-compose.yml
        - Dockerfile
        - env-file.env
   * To build the docker image by running the following command:
        - '$docker build -t codacy-test-image .'
        
        
## 6 - TO DO
    
   * Unit tests on the bugcatcher fwk
   * Integration with Report Portal
   * Add more browsers possibilities ( ie and safari)
   * Add more environment variables on docker-compose ( Change the Selenium grid URL)
   * Automatic put the files in a tar.gz
   * Increase the automation tests suite
   * Improve the Page Object pattern on the codacyTests ( Add a class just to the top and side bar )
   * Use API for the tests preconditions
   * Integration with Gatling for load/performance tests
   * Build sitespeed.io solution with graphana to test UI performance tests
   * Parallelization 
   * Headless browser 