package com.code.herokuap.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TablePage {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public TablePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTable() {
        return this.driver.findElement(By.xpath(".//table[@id='table1']"));
    }

    public List<HashMap<String, String>> getTableData(String excludedColumn) {
        List<HashMap<String, String>> toReturn = new ArrayList<>();

        WebElement table = this.getTable();

        List<String> header = new ArrayList<>();
        List<WebElement> headerList = table.findElements(By.xpath(".//span"));
        for(int i = 0; i < headerList.size(); i++) {
            header.add(headerList.get(i).getText());
        }

        WebElement tBody = table.findElement(By.xpath(".//tbody"));
        List<WebElement> tRow = tBody.findElements(By.xpath(".//tr"));
        for(int j = 0; j < tRow.size(); j++) {
            HashMap<String, String> map = new HashMap<>();
            List<WebElement> tData = tRow.get(j).findElements(By.xpath(".//td"));
            for(int k = 0; k < tData.size(); k++) {
                if(!header.get(k).equals(excludedColumn)) {
                    map.put(header.get(k), tData.get(k).getText());
                }

            }
            toReturn.add(map);
        }
        return toReturn;
    }

}