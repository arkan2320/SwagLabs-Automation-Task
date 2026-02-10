# 🚀 Swag Labs Automation Framework (POM & TestNG)

### **Developed by: Arkan Essam**
**Dual-Certified QA Automation Engineer (ISTQB & Agile)**

---

## 📝 Project Description
This project is a robust, scalable automation framework designed to test the **Swag Labs** (SauceDemo) e-commerce website. It is built using **Selenium WebDriver** with **Java**, strictly following the **Page Object Model (POM)** design pattern and **Data-Driven Testing** approach using external **JSON** files.

The framework ensures thread-safe execution and high maintainability by separating test logic, page objects, and test data.

---

## 🛠️ Tech Stack & Tools

| Category | Technology |
| :--- | :--- |
| **Language** | Java 21 |
| **Automation Tool** | Selenium WebDriver (4.x) |
| **Test Framework** | TestNG |
| **Build Tool** | Maven |
| **Data Format** | JSON (via Jackson Databind) |
| **Design Pattern** | Page Object Model (POM) |

---

## 🏗️ Framework Architecture

The framework is architected into three distinct layers to ensure modularity:

### **1. Foundation Layer (Base & Factory)**
* **BaseTest:** Manages the browser lifecycle (`@BeforeMethod` / `@AfterMethod`) to ensure a clean state for every test.
* **DriverFactory:** Implements a **ThreadLocal** WebDriver instance, allowing for thread-safe parallel execution in the future.

### **2. Actor Layer (Page Objects)**
* **Locators:** Utilizes **By Locators** strategy (instead of PageFactory) to avoid `StaleElementReferenceException` and handle dynamic elements efficiently.
* **Pages:** Separate classes for `LoginPage` and `InventoryPage` containing specific actions and verifications.

### **3. Data Layer (Data-Driven)**
* **JSON Engine:** Decouples test data from test logic.
* **DataDriven Utility:** A custom utility (`DataDriven.java`) reads credentials and expected results from `src/test/resources/testData/testData.json`.

---

## 📂 Project Structure

```text
src
├── main
│   └── java
│       ├── factory
│       │   └── DriverFactory.java      # Thread-Safe WebDriver management
│       ├── pages
│       │   ├── LoginPage.java         # Login page actions & locators
│       │   └── InventoryPage.java     # Inventory page actions & locators
│       └── utils
│           └── DataDriven.java        # JSON file reader utility
└── test
    ├── java
    │   ├── base
    │   │   └── BaseTest.java          # Setup & Teardown logic
    │   └── tests
    │       ├── LoginTest.java         # Valid, Invalid & Empty password tests
    │       └── InventoryTest.java     # Product & UI verification tests
    └── resources
        └── testData
            └── testData.json          # External test data source
```
## 🧪 Test Scenarios Covered
✅ Verify Successful Login:

Logs in with valid credentials from JSON.

Asserts redirection to the Inventory page.

❌ Verify Invalid Login:

Attempts login with wrong credentials.

Asserts that the error message contains: "Username and password do not match".

⚠️ Verify Login Without Password:

Leaves the password field empty.

Asserts that the error message contains: "Password is required".

🛒 Verify Inventory Page Elements:

Checks that the Page Title is "Swag Labs".

Verifies the Cart Icon is displayed.

Asserts that exactly 6 Products are displayed.


## How to Run
Clone the repository:git clone [https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git](https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git)
Navigate to the project directory:cd SwagLabs-Automation-Task
Run tests using Maven:mvn test
## Or run the testng.xml file directly from your IDE.

## 👤 Author
Arkan Essam

Role: Software QA Automation Engineer

Certifications: ISTQB CTFL, ISTQB Agile Tester

Specialties: Selenium, API Testing, CI/CD, Java
