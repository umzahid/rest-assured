
```markdown
# Rest-Assured and Selenium Test Project

This project demonstrates the use of Rest-Assured for API testing and Selenium for UI testing, integrated with Extent Reports for detailed test reporting.

## Prerequisites

- Java 11 or higher
- Maven 3.6.3 or higher
- ChromeDriver (compatible with your Chrome browser version)

## Setup

1. Clone the repository:
    ```sh
    git clone https://github.com/umzahid/rest-assured.git
    cd rest-assured
    ```

2. Install dependencies:
    ```sh
    mvn clean install
    ```

3. Update the `chromedriver` path if necessary.

## Running Tests

To run the tests, use the following command:
```sh
mvn test
```

## Reports

### Extent Reports

After running the tests, the Extent Report will be generated at:
```
target/extent.html
```

### Serenity Reports

Serenity reports will be generated at:
```
target/site/serenity/index.html
```

## Project Structure

- `src/test/java/Runner/testRunner.java`: Configures the test runner using Serenity and JUnit.
- `src/test/resources/features/example.feature`: Contains the Cucumber feature file.
- `src/test/java/test/Steps.java`: Implements the step definitions for the Cucumber feature.
- `src/test/java/test/Rest.java`: Demonstrates a simple Rest-Assured API test.

## Dependencies

Add the following dependencies to your `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>4.4.0</version>
    </dependency>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.1.0</version>
    </dependency>
    <dependency>
        <groupId>com.aventstack</groupId>
        <artifactId>extentreports</artifactId>
        <version>4.1.6</version>
    </dependency>
    <dependency>
        <groupId>commons-io</groupId>
        <artifactId>commons-io</artifactId>
        <version>2.11.0</version>
    </dependency>
    <dependency>
        <groupId>net.serenity-bdd</groupId>
        <artifactId>serenity-core</artifactId>
        <version>3.2.0</version>
    </dependency>
    <dependency>
        <groupId>net.serenity-bdd</groupId>
        <artifactId>serenity-junit</artifactId>
        <version>3.2.0</version>
    </dependency>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>7.0.0</version>
    </dependency>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-junit-platform-engine</artifactId>
        <version>7.0.0</version>
    </dependency>
</dependencies>
```
