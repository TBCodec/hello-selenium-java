# Hello, Selenium!

## Story

This exercise is here to help you with your first steps taken on the long way of locating different objects in the browser.
For this, we are going to use a [demo website from Selenium Easy](https://www.seleniumeasy.com/test/).

## What are you going to learn?

- how to locate objects in the browser
- how to interact with them using Selenium

## Tasks

1. On the demo website, navigate to `All Examples / Input Forms / Simple Form Demo` using the `Menu List`
    - The elements are selected from the `Menu List`.
    - The code does not contain `Thread.sleep()`

2. Navigate to `Simple Form Demo`. In "Single Input Field" enter the message `Hello, Selenium` into the field and click the "Show Message" button. Validate that the message appeared.
    - The elements are selected from the `Menu List`.
    - The code does not contain `Thread.sleep()`
    - Running the test method validates `Hello, Selenium` appearing.

3. Navigate to `Simple Form Demo`. In "Two Input Fields" enter the value `a` and `b`, and click the "Get Total" button. Validate that the answer is correct. What could go wrong with entering reaaaally big numbers?
    - The elements are selected from the `Menu List`.
    - The code does not contain `Thread.sleep()`
    - Running the test method validates the sum of numbers appearing.

4. Navigate to Checkbox Demo. In "Single Checkbox Demo" check the checkbox and validate the message.
    - The elements are selected from the `Menu List`.
    - The code does not contain `Thread.sleep()`
    - Running the test method validates the message after checkbox is checked.

5. Navigate to Select Dropdown List. In "Select List Demo" select "Friday" from the dropdown. Validate that it's selected. Try out all the ways you can select a day.
    - The elements are selected from the `Menu List`.
    - The code does not contain `Thread.sleep()`
    - Running the test method validates "Friday" selected.
    - There is more than one way implemented to find "Friday".

6. Navigate to Radio buttons Demo. In "Group Radio Buttons Demo" select a combination and click the "Get values" button. Validate the result. Try to run several combinations in one test.
    - The elements are selected from the `Menu List`.
    - The code does not contain `Thread.sleep()`
    - Running the test method validates "Friday" selected.
    - There is more than one combination implemented.

## General requirements

None

## Hints

- Explore the website’s behavior before you would dive deep into writing script
- When you open the website manually, you shall notice that you need to close a [lightbox](https://en.wikipedia.org/wiki/Lightbox_(JavaScript)) before you could interact with the other elements. But what if your scripts are reaching elements *faster* than you would...? Barney Stinson would say "[Wait for it](https://gifer.com/en/4On9)".

## Background materials

- [Selenium Browser Manipulation](project/curriculum/materials/competencies/selenium-basics/selenium-browser-manipulation.md.html)
- [WebDriver API](project/curriculum/materials/competencies/selenium-basics/selenium-webdriver-api.md.html)
- <i class="far fa-exclamation"></i> [Selenium Locators](project/curriculum/materials/competencies/selenium-basics/selenium-locators.md.html)
- <i class="far fa-exclamation"></i> [Selenium Waits and Alerts](project/curriculum/materials/competencies/selenium-basics/selenium-waits-and-alerts.md.html )
- :exclamation [Step-by-step guide](project/curriculum/materials/pages/step-by-step/step-by-step-hello-selenium.md)
