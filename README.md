
# FanCode Todo API Automation

## Overview
This project automates the validation of users' todo completion rates in the FanCode city (identified by lat/long criteria). 
We use the JSONPlaceholder API as a mock data source.

## Prerequisites
- Java 11 or later
- Maven
- Internet connection (for downloading dependencies)

## Setup
1. Clone the repository.
2. Navigate to the project root directory.
3. Run `mvn clean install` to build the project.

## Running Tests
Run `mvn test` to execute the API tests.

## Technology Stack
- **RestAssured** for API testing.
- **TestNG** as the test framework.
- **Maven** for build and dependency management.

## Project Structure
- `src/test/java`: Contains the test cases.
- `src/main/java`: Contains reusable utilities and logic.
- `pom.xml`: Maven configuration.
