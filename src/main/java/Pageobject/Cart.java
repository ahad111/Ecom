package Pageobject;

import Utils.WaitUtils;
import com.automation.Standalone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class Cart  {
    WaitUtils waits;
    WebDriver driver;


    @FindBy(xpath ="//div[@class='cartSection']/h3")
    List<WebElement> getallproduct;

    public Cart(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver,this);
        // this.waits =   new WaitUtils(driver);
    }

    public List<String>  Displayallproduct(String Productname)
    {

      List<String> products =   getallproduct.stream().filter(product -> product.getText().contains(Productname)).map(product->product.getText()).collect(Collectors.toList());


        System.out.println(products.get(0));

        return products;

    }


}
