WhetherApp

A Spring Boot application that integrates with a third-party API to retrieve weather data. 
The application should allow users to search for weather data by city name. 
Use Hibernate to persist weather data to a local database. Using Spring Scheduler to periodically 
refresh weather data from the third-party API.


## Getting Started

### Prerequisites

- Java 
- Maven 
- MySQL Database
- SonarQube (optional, for static code analysis)

### Local Development

1. Clone the repository:

   git clone https://github.com/rparyian/whetherApp.git
   cd whetherApp

2. Configure Database:

    - Open src/main/resources/application.properties.
    - Update the database properties (url, username, password).

3. Configure SonarQube (optional):

    - Open pom.xml (Maven) or build.gradle (Gradle).
    - Set SonarQube server URL and authentication token(or login and password)

4. Configure whether api key. Open application.properties and set weather.api.key(from https://www.weatherapi.com/)  

5. Build and Run the Application:

    - Maven:
      mvn clean install
      mvn spring-boot:run

    - Gradle:
      ./gradlew clean build
      ./gradlew bootRun

## Running Tests

Run the tests using the following commands:

- Maven:
  mvn test

- Gradle:
  ./gradlew test

## Code Coverage

Check the code coverage using JaCoCo. Generate the report with:

- Maven:
  mvn jacoco:report

- Gradle:
  ./gradlew jacocoTestReport

View the HTML report in target/site/jacoco/index.html (Maven) or build/reports/jacoco/test/html/index.html (Gradle).

## Static Code Analysis

Analyze the code with SonarQube using the following commands:

- Maven:
  mvn clean verify sonar:sonar -Dsonar.login=your_token_here

- Gradle:
  ./gradlew clean build sonarqube -Dsonar.login=your_token_here

View the analysis results on the SonarQube dashboard.

## API Endpoints

Here is a list of available API endpoints:

- Retrieves weather data for a specific location  (GET /weather/{location}
- Example: /weather/NewYork


## Contributing

Feel free to contribute by opening issues or creating pull requests. Follow the Contributing Guidelines for details.

## License

This project is licensed under the MIT License.

## Short feedback

-It was not very easy to complete the task using AI

-~6hours
