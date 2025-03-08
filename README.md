# Selenium Waits Demo

## Introduction
This repository demonstrates different types of **Selenium waits** in a beginner-friendly way. The project is designed to help **new Selenium learners** understand how to handle **dynamic elements** on web pages using waits.

The tests are implemented on a **sample test website** that contains various elements that appear or change state after some time.

🔗 **Project Repository:** [Selenium Waits Demo](https://github.com/ichfaisal/SeleniumWaitsDemo.git)

## Purpose
- The **main goal** of this project is to provide a **clear and simple** implementation of Selenium waits.
- This is **not an advanced framework**, so **no utility functions** or complex structures are used—making it **ideal for beginners**.
- Currently, the project covers **Explicit Waits**, but **Fluent Waits** and **Implicit Waits** will be added in the future.

## Implemented Wait Scenarios
This project includes **four test cases**, each demonstrating a different explicit wait condition:

1. **Waiting for an Element to Become Visible**
   - Clicks a button to trigger an element to appear.
   - Uses `visibilityOfElementLocated` and `elementToBeClickable` conditions.
   - Verifies that the element is visible and clickable.

2. **Waiting for an Alert to Appear**
   - Clicks a button that triggers an alert.
   - Uses `alertIsPresent()` to wait for the alert.
   - Handles the alert by clicking OK.

3. **Waiting for an Element to Change State**
   - Clicks a button that enables a previously disabled button.
   - Uses `elementToBeClickable` to wait for the button to become enabled.
   - Verifies that the button is now enabled.

4. **Waiting for an Element’s Class Attribute to Change**
   - Clicks a button that changes another button’s class attribute.
   - (Future) Will use `attributeToBe` condition to verify class change.

## Future Enhancements
✔ **Adding Fluent Waits & Implicit Waits** to compare their behavior with Explicit Waits.  
✔ More complex scenarios involving **dynamic loading and AJAX elements**.

## How to Run the Tests
1. Clone the repository:
   ```sh
   git clone https://github.com/ichfaisal/SeleniumWaitsDemo.git
   ```
2. Open the project in your favorite **IDE (e.g., IntelliJ, Eclipse)**.
3. Ensure you have **Selenium WebDriver and Java** set up correctly.
4. Run the test cases using **TestNG or JUnit**.

Happy Testing! 🚀

