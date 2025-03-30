package com.automation;

import Pageobject.Cart;
import Pageobject.CheckoutPage;
import Pageobject.Login;
import Pageobject.ProductCatalogue;
import Utils.CommonUtils;
import Utils.DataReaderUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class StepLogin extends Standalone {


    String productname = "ADIDAS ORIGINAL";



    @Test(dataProvider = "getDatas", retryAnalyzer = Retry.class)
    public void order(HashMap<String,String> input) {

        Login lg = new Login(driver);
        Cart carts = new Cart(driver);
        ProductCatalogue PdCatalouge = new ProductCatalogue(driver);
        CommonUtils common = new CommonUtils(driver);
        CheckoutPage chekpage = new CheckoutPage(driver);

        lg.gotopage();
        lg.login(input.get("email"), input.get("password"));

        PdCatalouge.getproductList();
        PdCatalouge.Addtocart(input.get("product"));

        common.gotoCart();

        List<String> check = carts.Displayallproduct(input.get("product"));

        Assert.assertEquals(check.get(0), input.get("product"));

        String Country = "India";

        chekpage.fillcheckoutProceed(Country);
        chekpage.getallcountries();
        chekpage.selectcountry(Country);
        String confirmsg = chekpage.Placeorder();
        Assert.assertTrue(confirmsg.equalsIgnoreCase("Thankyou for the order."));

    }

    @DataProvider
    public Object[][] getData()
    {
        return new Object[][] {{"abdulahaduitian@gmail.com","Test@123","ADIDAS ORIGINAL"},{"abdulahaduitian@gmail.com","Test@123","ADIDAS ORIGINAL"}};
    }

    @DataProvider
    public Object[][] getDatas() throws IOException {

    /*     HashMap<String,String> map = new HashMap<String,String>();
         map.put("email","abdulahaduitian@gmail.com");
        map.put("password","Test@123");
        map.put("product","ADIDAS ORIGINAL");

        HashMap<String,String> map1 = new HashMap<String,String>();
        map1.put("email","abdulahaduitian1@gmail.com");
        map1.put("password","Test@1231");
        map1.put("product","ADIDAS1 ORIGINAL"); */

        DataReaderUtil dataread = new DataReaderUtil();
         List<HashMap<String,String>> data = dataread.getJasontoMap(System.getProperty("user.dir")+"//src//main//java//Utils//Purchase.json");

        return new Object[][] {{data.get(0)},{data.get(1)}};
    }

    @Test
    public void order1() throws InterruptedException {
        driver.get("https://www.google.com");



        String title = driver.getTitle();
        Assert.assertEquals(title, "Wrong Title");
    }




/*



        driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();

        String confirmlabel = driver.findElement(By.xpath(" //h1[normalize-space()='Thankyou for the order.']")).getText();

        Assert.assertTrue(confirmlabel.equalsIgnoreCase("Thankyou for the order."));*/
}


