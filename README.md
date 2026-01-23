# ToolsQA Selenium Automation Project

## Overview
This project automates functional and end-to-end test cases for the ToolsQA Demo website using Selenium WebDriver, TestNG, and Maven.

## Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Maven
- Chrome & Firefox
- GitHub Actions (CI)

 ## Test Coverage
- User Registration
- Login (Positive & Negative)
- Navigation
- Delete Account
- Cross-browser testing

## Project Structure
toolsqa_selenium/
│
├── src/
│   ├── main/java/
│   │   └── com/qa/toolsqa/
│   │       ├── pages/              # Page Object classes
│   │       │   ├── BasePage.java
│   │       │   ├──LoginPage.java
│   │       │   ├── RegistrationPage.java
│   │       │   └── NavigationPage.java
│   │       │
│   │       └── utils/              # Utility classes (optional)
│   │           └── ConfigReader.java
│   │
│   └── test/java/
│       └── com/qa/toolsqa/
│           ├── tests/              # Test classes
│           │   ├── BaseTest.java
│           │   ├── LoginTest.java
│           │   ├── RegistrationTest.java
│           │   ├── NavigationTest.java
│           │   └── AccountDeletionTest.java
│           │
│           └── testdata/           # Test data classes
│               ├── LoginTestData.java
│               └── RegistrationTestData.java
│               ├── DeleteTestData.java
│
├── test-output/                    # TestNG reports (auto-generated)
├── target/                         # Compiled classes (auto-generated)
├── pom.xml                         # Maven configuration
├── testng.xml                      # TestNG suite configuration
├── .gitignore                      # Git ignore file
└── README.md                       # This file

## How to Run Tests

### Run locally
```bash
mvn clean test
