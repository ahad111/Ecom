package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {
    WebDriver driver;

    By searchBox = By.name("q");
    By searchButton = By.name("btnK");

    public GooglePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void openGoogle() {
        driver.get("https://www.google.com");
    }

    public void search(String query) {
        WebElement searchInput = driver.findElement(searchBox);
        searchInput.sendKeys(query);
        searchInput.submit();  // Google میں Enter پریس کرنے کے لیے
    }
}
