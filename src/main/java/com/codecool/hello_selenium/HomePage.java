package com.codecool.hello_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLink(String linkText) {driver.findElement(By.linkText(linkText)).click();}

    public HelloWebsite clickInputForms(){
        clickLink("Input Forms");
        return new HelloWebsite(driver);
    }
}
