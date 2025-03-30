package Pageobject;

import Utils.WaitUtils;
import com.automation.Standalone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue {


    WaitUtils waits;
    WebDriver driver;



    @FindBy(css = ".mb-3")
    List<WebElement> products;


    By product = By.cssSelector(".mb-3");

    //@FindBy(xpath = ".//button[2]")
    By addTocartbtn = By.xpath(".//button[2]");

    By toastermsg = By.cssSelector(".toast-success");

    public ProductCatalogue(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver,this);
        this.waits =   new WaitUtils(driver);
    }
    @FindBy(css = ".ng-animating")
    WebElement loader;

    public List<WebElement> getproductList() {

        waits.elemetnTobeAppear(product);

        return products;
    }


    public WebElement ProductName(String ProductName)
    {
        WebElement prod = getproductList().stream().filter(product -> product.findElement(By.cssSelector("b"))
                .getText().equals(ProductName)).findFirst().orElse(null);
        return prod;
    }

    public void Addtocart(String Productname) {

        WebElement prod = ProductName(Productname);

        prod.findElement(addTocartbtn).click();

        waits.elemetnTobedisapper(loader);

       //  waits.elemetnTobeAppear(toastermsg);
    }

}
