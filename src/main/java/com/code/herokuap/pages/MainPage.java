package com.code.herokuap.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        this.driver.get("http://the-internet.herokuapp.com/");
        this.driver.manage().window().maximize();
    }

    public WebElement getListRoot() {
        return this.driver.findElement(By.xpath("//ul"));
    }

    public void selectOption(String optionName) {
        WebElement listRoot = this.getListRoot();
        List<WebElement> listItems = listRoot.findElements(By.xpath(".//a"));

        for(int i = 0; i < listItems.size(); i++) {
            if(listItems.get(i).getText().equals(optionName)) {
                listItems.get(i).click();
                break;
            }
        }
    }


}
