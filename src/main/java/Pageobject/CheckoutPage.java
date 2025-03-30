package Pageobject;

import Utils.WaitUtils;
import com.automation.Standalone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage {
    WebDriver driver;
    WaitUtils waits ;



    @FindBy(xpath = "//button[normalize-space()='Checkout']")
    WebElement checkbtn;

    @FindBy(xpath = "(//input[@placeholder='Select Country'])[1]")
    WebElement SelectCountry;

    By result = By.cssSelector(".ta-results");

    @FindBy(xpath = "//section[contains(@class,'ta-result')]//button")
    List<WebElement> getcountries;

    @FindBy(xpath = "//a[normalize-space()='Place Order']")
    WebElement Placeorderbtn;

    @FindBy(xpath =  " //h1[normalize-space()='Thankyou for the order.']")
    WebElement ordernotes;

    public CheckoutPage( WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        this.waits = new WaitUtils(driver);
    }

    public void fillcheckoutProceed(String Country)  {
        checkbtn.click();
        Actions action = new Actions(driver);
        action.sendKeys(SelectCountry,Country).build().perform();

    }


    public List<WebElement> getallcountries()
    {
        waits.elemetnTobeAppear(result);
        return getcountries;

    }

    public void selectcountry(String Country)
    {
        WebElement country = getallcountries().stream().filter(countries-> countries.getText().equals(Country)).findFirst().orElse(null);
        country.click();

    }

    public String Placeorder()
    {
        Placeorderbtn.click();
        String confirmlabel = ordernotes.getText();
        return confirmlabel;
    }


}
