package com.automation;


import Pageobject.GooglePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

    @Test
    public void testGoogleSearch1() {
        GooglePage googlePage = new GooglePage(driver);
        googlePage.openGoogle();
        googlePage.search("Selenium WebDriver");

        // چیک کریں کہ سرچ ہونے کے بعد یو آر ایل چینج ہوا یا نہیں
        Assert.assertTrue(driver.getTitle().contains("Selenium WebDriver"), "Search result not displayed!");
        System.out.println("Google Search Test Executed");
    }

    @Test
    public void testGoogleSearch2() {
        GooglePage googlePage = new GooglePage(driver);
        googlePage.openGoogle();
        googlePage.search("Selenium WebDriver");

        // چیک کریں کہ سرچ ہونے کے بعد یو آر ایل چینج ہوا یا نہیں
        Assert.assertTrue(driver.getTitle().contains("Selenium WebDriver"), "Search result not displayed!");
        System.out.println("Google Search Test Executed");
    }


}
