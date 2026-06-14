# OpenCart Automation Testing Framework

## Overview

This project is an Automation Testing Framework developed for the OpenCart E-commerce application using Selenium WebDriver, Java, TestNG, and Maven. The framework follows the Page Object Model (POM) design pattern and supports Cross-Browser Testing, Data-Driven Testing, Reporting, Logging, and Selenium Grid execution with Docker.

## Tech Stack

* Java 8
* Selenium WebDriver
* TestNG
* Maven
* Page Object Model (POM)
* Apache POI
* Log4j
* Extent Reports
* Selenium Grid
* Docker
* Git & GitHub

## Project Structure

```text
OpenCart121
│
├── src/main/java
├── src/main/resources
│
├── src/test/java
│   ├── pageObjects
│   ├── testBase
│   ├── testCases
│   └── utilities
│
├── src/test/resources
├── logs
├── reports
├── screenshots
├── target
├── testData
├── test-output
│
├── CrossBrowser Testing.xml
├── grid_docker.xml
├── grouping.xml
├── master.xml
├── docker-compose.yaml
└── pom.xml
```

## Framework Features

* Page Object Model (POM) design pattern
* Cross-browser testing (Chrome, Firefox, Edge)
* Data-driven testing using external test data
* Detailed execution reports
* Screenshot capture on test failures
* Logging using Log4j
* Selenium Grid integration
* Docker support for parallel execution
* TestNG suite execution

## Test Scenarios Covered

* User Registration
* Login Functionality
* Logout Functionality
* Product Search
* Add to Cart Validation
* Data-Driven Login Testing
* Validation and Error Message Testing

## How to Run the Project

### Clone the Repository

```bash
git clone <repository-url>
```

### Navigate to Project Directory

```bash
cd OpenCart121
```

### Install Dependencies

```bash
mvn clean install
```

### Run All Tests

```bash
mvn test
```

### Run Master Suite

```bash
mvn test -DsuiteXmlFile=master.xml
```

### Run Cross Browser Suite

```bash
mvn test -DsuiteXmlFile="CrossBrowser Testing.xml"
```

### Run Selenium Grid Tests

```bash
mvn test -DsuiteXmlFile=grid_docker.xml
```

## Reports and Logs

Execution reports are generated in:

```text
reports/
test-output/
```

Screenshots for failed test cases are stored in:

```text
screenshots/
```

Execution logs are available in:

```text
logs/
```

## Author

### Mirzan Uddin

B.Tech CSE (AI & ML)

Software Testing Engineer

Skills: Selenium WebDriver, Java, TestNG, Maven, API Testing, Automation Testing, Manual Testing, Jira, Git, Jenkins, Docker
