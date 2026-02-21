# Simple UI App - Web Version with Selenium Tests

This project converts the original Swing-based SimpleUIApp to a Spring Boot web application with automated Selenium tests using TestNG.

## Project Structure

```
MyJavaProject/
├── src/
│   ├── main/
│   │   ├── java/com/example/
│   │   │   ├── Application.java          # Spring Boot main class
│   │   │   └── controller/
│   │   │       └── SimpleUIController.java # Web endpoint controller
│   │   └── resources/
│   │       ├── templates/
│   │       │   └── index.html            # Web UI template
│   │       └── application.properties    # Spring Boot configuration
│   └── test/
│       └── java/com/example/
│           └── SimpleUIAppTest.java      # Selenium TestNG tests
├── pom.xml                              # Maven dependencies
├── testng.xml                           # TestNG configuration
├── SimpleUIApp.java                     # Original Swing app (reference)
└── README.md                            # This file
```

## Prerequisites

- **Java 11+** installed
- **Maven 3.6+** installed
- **Chrome browser** installed (for Selenium tests)
- **Git** (optional)

Check versions:
```bash
java -version
mvn -version
```

## Getting Started

### 1. Build the Project

```bash
cd MyJavaProject
mvn clean install
```

This will:
- Download all dependencies (Spring Boot, Selenium, TestNG, etc.)
- Compile the source code
- Build the project

### 2. Run the Web Application

#### Option A: Using Maven
```bash
mvn spring-boot:run
```

#### Option B: Using Java
```bash
java -jar target/simple-ui-app-1.0.0.jar
```

The application will start on **http://localhost:8080**

Open your browser and navigate to `http://localhost:8080` - you'll see the web version of the UI with:
- Input field for entering text
- Display button to submit
- Output label showing results

### 3. Run the Selenium Tests

While the application is running (in another terminal), execute the tests:

```bash
mvn test
```

Or run specific test:
```bash
mvn test -Dtest=SimpleUIAppTest
```

## Test Coverage

The `SimpleUIAppTest` includes 8 automated test scenarios:

1. **testPageLoads** - Verifies page loads with correct title
2. **testDisplayButtonWithValidText** - Tests displaying user input
3. **testDisplayButtonWithEmptyText** - Tests error handling for empty input
4. **testDisplayButtonWithWhitespaceOnly** - Tests whitespace validation
5. **testDisplayButtonWithSpecialCharacters** - Tests special character handling
6. **testMultipleInputs** - Tests multiple sequential inputs
7. **testFormSubmissionViaEnterKey** - Tests form submission via keyboard
8. **testLongTextInput** - Tests handling of long text input
9. **testInitialPageState** - Tests default page state

## Key Features

### Web Application Features
- Clean, responsive UI built with HTML5 and CSS3
- Spring Boot backend handling form submissions
- Real-time output feedback with color-coded messages
- Professional styling with gradient background

### Test Automation
- Uses **Selenium WebDriver** for browser automation
- Uses **TestNG** framework for test organization
- Uses **WebDriverManager** for automatic driver updates
- Comprehensive test scenarios covering happy paths and edge cases
- Clear test descriptions for better readability

## Dependencies

### Main Application
- **Spring Boot 2.7.14** - Web framework
- **Thymeleaf** - Template engine for HTML rendering

### Testing
- **Selenium WebDriver 4.13** - Browser automation
- **TestNG 7.8.1** - Testing framework
- **WebDriverManager 5.6.3** - Automatic driver management

## Troubleshooting

### Issue: Chrome driver not found
**Solution:** WebDriverManager should automatically download it. If not:
```bash
mvn dependency:resolve
```

### Issue: Port 8080 already in use
**Solution:** Change the port in `application.properties`:
```properties
server.port=9090
```
Then update BASE_URL in test: `http://localhost:9090`

### Issue: Tests fail with "Cannot connect to server"
**Solution:** Make sure the Spring Boot application is running in another terminal before running tests

### Issue: Maven command not found
**Solution:** Ensure Maven is in your PATH or use the full path to mvn

## Running Both Application and Tests

In Terminal 1:
```bash
mvn spring-boot:run
```

In Terminal 2:
```bash
mvn test
```

## Project Comparison

| Aspect | Original (Swing) | Web Version |
|--------|------------------|------------|
| Platform | Desktop | Web Browser |
| Framework | Java Swing | Spring Boot + Thymeleaf |
| Testing | GUI testing tools | Selenium + TestNG |
| Deployment | JAR file | Web server |
| UI Framework | AWT/Swing components | HTML5 + CSS3 |

## Next Steps

To extend this project:
1. Add database integration (JPA/Hibernate)
2. Add more complex form validation
3. Add REST API endpoints
4. Add user authentication
5. Add more test scenarios and edge cases
6. Deploy to cloud (AWS, Azure, GCP)

## Author Notes

This web version maintains the same functionality as the original Swing application while providing:
- Better cross-platform support
- Modern web-based UI
- Comprehensive automated testing
- Easier deployment and scaling
