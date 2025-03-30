package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FacebookPage {
    WebDriver driver;

    By emailField = By.id("email");
    By passwordField = By.id("pass");
    By loginButton = By.name("login");

    public FacebookPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void openFacebook() {
        driver.get("https://www.facebook.com");
    }

    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
