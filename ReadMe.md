# 📘 Demoblaze Web Automation Testing Framework

This project is a Selenium-based test automation framework using **Java**, **TestNG**, and **Cucumber (BDD)**. It automates end-to-end user scenarios on the [Demoblaze](https://demoblaze.com/) demo e-commerce website.

---

## 📂 Project Structure

```
DemoblazeAutomation/
├── src/
│   └── test/
│       ├── java/
│       │   ├── Pages/           # Page Object Model classes
│       │   ├── Steps/           # Step Definitions + Hooks
│       │   └── Runners/         # Test Runner class
│       └── resources/
│           ├── features/        # Feature files written in Gherkin
│           └── config/          # Configuration files (e.g., base URL)
├── pom.xml                      # Maven dependencies
└── testng.xml                   # Optional TestNG test suite
```

---

## ✅ Technologies Used

- **Java 17+**
- **Selenium WebDriver**
- **Cucumber (Gherkin syntax)**
- **TestNG**
- **Maven**
- **WebDriverManager**
- **Extent Reports**

---

## 🔧 Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-username/demoblaze-automation.git
   cd demoblaze-automation
   ```

2. **Install Dependencies**
   ```bash
   mvn clean install
   ```

3. **Run Tests**
   ```bash
   mvn test
   ```
   Or via `TestRunner.java` from your IDE.

---

## 🔪 Sample Test Scenarios

- ✅ User signup flow with validation
- ✅ User login and cart operations
- ✅ Adding multiple products and verifying total
- ✅ Alert/message handling after actions

---

## 🛠️ Configuration

File: `src/test/resources/config/config.properties`

```properties
baseUrl=https://demoblaze.com/
```

Use in code:

```java
String baseUrl = ConfigReader.get("baseUrl");
```

---

## 📋 Reporting

This framework uses **[Extent Reports](https://extentreports.com/)** for detailed and interactive test reports.

- Generated at:
  ```
  /test-output/ExtentReport.html
  ```

- Features:
   - Step-wise results (pass/fail/skip)
   - Screenshots on failure (optional)
   - Timestamped summaries

---

## 👥 Contributors

- [Salma Adel](https://github.com/SalmaAdelll)
- Open to collaboration!

---

## 📄 License

This project is licensed under the **MIT License**.

