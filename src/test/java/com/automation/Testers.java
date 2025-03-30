package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Testers {


    WebDriver driver;
    Standalone drivermanage = new Standalone();



    @Test
    public void PerformLogins()

    {
      /*  String productname = "ADIDAS ORIGINAL";





       WebElement element  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
        Boolean test = element.isDisplayed();
        System.out.println(test);
        Assert.assertTrue(test);




        List<WebElement> getproducts = driver.findElements(By.cssSelector(".mb-3"));

        WebElement prods =  getproducts.stream().filter(product -> product.findElement(By.cssSelector("b"))
                .getText().equals(productname)).findFirst().orElse(null);


        prods.findElement(By.xpath(".//button[2]")).click();



       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-success")));

     //   wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

        driver.findElement(By.xpath("//button[contains(@routerlink,'cart')]")).click();


        List<WebElement> getvalue = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));

        List<String>  getproduct = getvalue.stream().filter(product -> product.getText().contains(productname)).map(product->product.getText()).collect(Collectors.toList());

        System.out.println(getproduct.get(0));

        Assert.assertEquals( productname,getproduct.get(0));


        driver.findElement(By.xpath(" //button[normalize-space()='Checkout']")).click();

        Actions action = new Actions(driver);

        action.sendKeys(driver.findElement(By.xpath("(//input[@placeholder='Select Country'])[1]")),"India").build().perform();

      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

        List<WebElement> selectoptions =  driver.findElements(By.xpath("//section[contains(@class,'ta-result')]//button"));

        WebElement prodss = selectoptions.stream().filter(country-> country.getText().equals("India")).findFirst().orElse(null);

        prodss.click();

        driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();

        String confirmlabel = driver.findElement(By.xpath(" //h1[normalize-space()='Thankyou for the order.']")).getText();

        Assert.assertTrue(confirmlabel.equalsIgnoreCase("Thankyou for the order."));*/

    }
}
