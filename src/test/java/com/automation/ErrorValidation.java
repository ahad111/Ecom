package com.automation;


import Pageobject.Cart;
import Pageobject.Login;
import Pageobject.ProductCatalogue;
import Utils.CommonUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class ErrorValidation extends Standalone  {

   // Standalone standalone = new Standalone();  // Create instance
   // public WebDriver driver = standalone.getWebDriver();  // Get driver
    //  public WebDriver driver = Standalone.getWebDriver();


    //  WebDriverWait wait = new WebDriverWait(driver, 10);
    //private BorrowerRegistrationPO borrowerRegistrationPO = new BorrowerRegistrationPO(driver);

    private Login lg = new Login(driver);
    private Cart carts = new Cart(driver);
    private ProductCatalogue PdCatalouge = new ProductCatalogue(driver);
    private CommonUtils common = new CommonUtils(driver);
    private String productName = "ZARA COAT 3";


    @Test
    public void PerformLogin() {



        lg.gotopage();
        lg.login("abdulahaduitian1@gmail.com", "Test@123");
        Assert.assertEquals("Incorrect email or password.", lg.getErrorMessage());



    }

    @Test
    public void ProductErrorValidation() {
        lg.gotopage();
        lg.login("abdulahaduitian@gmail.com", "Test@123");

        PdCatalouge.getproductList();
        PdCatalouge.Addtocart(productName);

        common.gotoCart();
        List<String> check = carts.Displayallproduct(productName);
        Assert.assertEquals(check.get(0), productName + "A");


    }

}