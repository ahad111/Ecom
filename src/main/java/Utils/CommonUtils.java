package Utils;

import com.automation.Standalone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonUtils {

    WaitUtils waitutil ;
    WebDriver driver;


    public CommonUtils(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitutil = new WaitUtils(driver);

    }

    @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
    WebElement cartbtn;


    public void gotoCart()
    {

        waitutil.elemetnTobeAppearforWebelement(cartbtn);
        cartbtn.click();
    }

}