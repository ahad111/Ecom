package com.automation.stepDefinitions;

import Pageobject.Cart;
import Pageobject.CheckoutPage;
import Pageobject.Login;
import Pageobject.ProductCatalogue;
import Utils.CommonUtils;
import com.automation.Standalone;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;


public class Orders  {
    public WebDriver driver = Standalone.setUp();


    private Login lg = new Login(driver);
    private ProductCatalogue PdCatalouge = new ProductCatalogue(driver);
    private CommonUtils common = new CommonUtils(driver);
    private Cart carts = new Cart(driver);
    private CheckoutPage chekpage = new CheckoutPage(driver);

    @Given("Landed in ecommerce website")
    public void Landed() {

        lg.gotopage();

    }

    @Given("^Enter the username (.+) and password (.+)$")
    public void Login(String username, String password) {

        lg.login(username, password);

    }


    @When("^Select the product (.+) from the product catalouge$")
    public void addtocart(String product) {



        PdCatalouge.getproductList();
        PdCatalouge.Addtocart(product);
        common.gotoCart();

    }

    @And("^Checkout with the product (.+) and submit order$")
    public void Checkout(String product) {


        List<String> check = carts.Displayallproduct(product);

        Assert.assertEquals(check.get(0), product);

        String Country = "India";

        chekpage.fillcheckoutProceed(Country);
        chekpage.getallcountries();
        chekpage.selectcountry(Country);

    }


    @Then("{string} message is displayed in confirmation page")
    public void ConfirmOrder(String msg) {

        String confirmsg = chekpage.Placeorder();
        Assert.assertTrue(confirmsg.equalsIgnoreCase(msg));
    }


  /*

    @Test
    public void order1() throws InterruptedException {
        driver.get("https://www.google.com");



        String title = driver.getTitle();
        Assert.assertEquals(title, "Wrong Title");
    }
*/

}


