package com.code.herokuapp.tests;

import com.code.herokuap.pages.MainPage;
import com.code.herokuap.pages.TablePage;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

public class TableTest extends BaseTest {

    @Test
    public void hashMapTest() {

        HashMap<String, String> map = new HashMap<>();
        map.put("Pon", "Testing");
        map.put("Uto", "Development");

        System.out.println(map.get("Pon"));

    }

    @Test
    public void readTableData() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.selectOption("Sortable Data Tables");

        TablePage tablePage = new TablePage(driver);
        List<HashMap<String, String>> tableMap =  tablePage.getTableData("Email");
        System.out.println("TEST");
    }

}
