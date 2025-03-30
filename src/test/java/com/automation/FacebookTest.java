package com.automation;
import Pageobject.FacebookPage;
import org.testng.annotations.Test;

public class FacebookTest extends BaseTest {


    @Test
    public void testFacebookLogin1() {
        FacebookPage fbPage = new FacebookPage(driver);
        fbPage.openFacebook();
        fbPage.login("testuser@example.com", "password123");

        // لاگ ان ہونے کے بعد چیک کریں کہ URL چینج ہوا یا نہیں
        System.out.println("Facebook Login Test Executed");
    }

    @Test
    public void testFacebookLogin2() {
        FacebookPage fbPage = new FacebookPage(driver);
        fbPage.openFacebook();
        fbPage.login("testuser@example.com", "password123");

        // لاگ ان ہونے کے بعد چیک کریں کہ URL چینج ہوا یا نہیں
        System.out.println("Facebook Login Test Executed");
    }
}
