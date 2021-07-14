package com.codecool.hello_selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class HelloSeleniumTest {

    private static WebDriver webDriver;
    private final String URL = "https://www.seleniumeasy.com/test/";

    @BeforeAll
    static void setDriverProperty() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
    }

    @BeforeEach
    void setWebDriver(){
        webDriver = new ChromeDriver();
    }

    @Test
    public void helloWebsite() {
        webDriver.get(URL);
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id=('at-cv-lightbox-close')]"))).click();
        WebElement inputForms = webDriver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > a"));
        inputForms.click();
        WebElement simpleFormDemo = webDriver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > ul > li:nth-child(1) > a"));
        assertTrue(simpleFormDemo.isDisplayed());
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        simpleFormDemo.click();
        String simpleFormDemoURL = URL+"basic-first-form-demo.html";
        assertEquals(simpleFormDemoURL, webDriver.getCurrentUrl());
    }

    @Test
    public void helloInput(){
        helloWebsite();
        By messageField = By.id("user-message");
        webDriver.findElement(messageField).sendKeys("Hello, Selenium");
        webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[2]/form/button")).click();
        By myMessageId = By.id("display");
        String myMessage = webDriver.findElement(myMessageId).getText();
        assertEquals( "Hello, Selenium", myMessage);
    }

    @Test
    public void helloInputs(){
        helloWebsite();
        By enterAField = By.id("sum1");
        By enterBField = By.id("sum2");
        By getTotalField = By.xpath("//*[@id=\"gettotal\"]/button");
        By displayValue = By.id("displayvalue");
        webDriver.findElement(enterAField).sendKeys("5");
        webDriver.findElement(enterBField).sendKeys("6");
        webDriver.findElement(getTotalField).click();
        String total = webDriver.findElement(displayValue).getText();
        assertEquals("11", total);
    }

    @Test
    public void helloInputsHugeNumbers(){
        helloWebsite();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            stringBuilder.append("9999999999999999999999");
        }
        String bigNumberAsString = stringBuilder.toString();
        By enterAField = By.id("sum1");
        By enterBField = By.id("sum2");
        By getTotalField = By.xpath("//*[@id=\"gettotal\"]/button");
        By displayValue = By.id("displayvalue");

        webDriver.findElement(enterAField).sendKeys(bigNumberAsString);
        webDriver.findElement(enterBField).sendKeys(bigNumberAsString);
        webDriver.findElement(getTotalField).click();
        String total = webDriver.findElement(displayValue).getText();
        assertEquals(bigNumberAsString, total);
    }

    @Test
    public void helloCheckbox(){
        webDriver.get(URL);
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id=('at-cv-lightbox-close')]"))).click();
        WebElement inputForms = webDriver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > a"));
        inputForms.click();
        WebElement checkboxDemo = webDriver.findElement(By.xpath("//*[@id=\"treemenu\"]/li/ul/li[1]/ul/li[2]/a"));
        checkboxDemo.click();
        assertEquals("https://www.seleniumeasy.com/test/basic-checkbox-demo.html",webDriver.getCurrentUrl());
        WebElement checkBox = webDriver.findElement(By.id("isAgeSelected"));
        checkBox.click();
        assertTrue(checkBox.isSelected());
        WebElement successMessageContainer = webDriver.findElement(By.id("txtAge"));
        assertEquals("Success - Check box is checked", successMessageContainer.getText());

    }

    @Test
    public void helloSelectList(){
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        webDriver.get(URL);
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id=('at-cv-lightbox-close')]"))).click();
        WebElement inputForms = webDriver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > a"));
        inputForms.click();
        WebElement selectDropdownList = webDriver.findElement(By.xpath("//*[@id=\"treemenu\"]/li/ul/li[1]/ul/li[4]/a"));
        selectDropdownList.click();
        assertEquals("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html", webDriver.getCurrentUrl());
        Select selectList = new Select(webDriver.findElement(By.id("select-demo")));
        selectList.selectByValue("Friday");
        WebElement fridayListElement = webDriver.findElement(By.cssSelector("#select-demo > option:nth-child(7)"));
        assertTrue(fridayListElement.isSelected(), "Select Friday");
        WebElement daySelectedText = webDriver.findElement(By.cssSelector("#easycont > div > div.col-md-6.text-left > div:nth-child(4) > div.panel-body > p.selected-value"));
        assertEquals("Day selected :- Friday", daySelectedText.getText());

    }

    @Test
    public void helloRadioButtons(){
        webDriver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
        webDriver.get(URL);
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id=('at-cv-lightbox-close')]"))).click();
        WebElement inputForms = webDriver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > a"));
        inputForms.click();
        WebElement radioButtonsDemo = webDriver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > ul > li:nth-child(3) > a"));
        radioButtonsDemo.click();
        assertEquals("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html", webDriver.getCurrentUrl());

        WebElement maleButton = webDriver.findElement(By.cssSelector("#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > div:nth-child(2) > label:nth-child(2) > input[type=radio]"));
        WebElement femaleButton = webDriver.findElement(By.cssSelector("#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > div:nth-child(2) > label:nth-child(3) > input[type=radio]"));
        WebElement zeroToFiveButton = webDriver.findElement(By.cssSelector("#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > div:nth-child(3) > label:nth-child(2) > input[type=radio]"));
        WebElement fiveToFifteenButton = webDriver.findElement(By.cssSelector("#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > div:nth-child(3) > label:nth-child(3) > input[type=radio]"));
        WebElement fifteenToFiftyButton = webDriver.findElement(By.cssSelector("#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > div:nth-child(3) > label:nth-child(4) > input[type=radio]"));

        WebElement getValuesButton = webDriver.findElement(By.cssSelector("#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > button"));
        WebElement values = webDriver.findElement(By.cssSelector("#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > p.groupradiobutton"));

        String noValuesSelectedText = "Sex :\nAge group:";
        getValuesButton.click();
        String valuesText = wait.until(ExpectedConditions.visibilityOf(values)).getText();
        assertEquals(noValuesSelectedText, valuesText);

        maleButton.click();
        zeroToFiveButton.click();
        getValuesButton.click();
        String maleZeroToFiveText = "Sex : Male\nAge group: 0 - 5";
        valuesText = wait.until(ExpectedConditions.visibilityOf(values)).getText();
        assertEquals(maleZeroToFiveText, valuesText);


        femaleButton.click();
        fiveToFifteenButton.click();
        getValuesButton.click();
        String femaleFiveToFifteenText = "Sex : Female\nAge group: 5 - 15";
        valuesText = wait.until(ExpectedConditions.visibilityOf(values)).getText();
        assertEquals(femaleFiveToFifteenText, valuesText);

        maleButton.click();
        fifteenToFiftyButton.click();
        getValuesButton.click();
        String maleFifteenToFiftyText = "Sex : Male\nAge group: 15 - 50";
        valuesText = wait.until(ExpectedConditions.visibilityOf(values)).getText();
        assertEquals(maleFifteenToFiftyText, valuesText);
    }



    @AfterEach
    void quitWebDriver(){
        webDriver.quit();
    }
}
