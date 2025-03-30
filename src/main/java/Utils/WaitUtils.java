package Utils;

import com.automation.Standalone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils  {

    WebDriver driver;
    WebDriverWait wait ;
    public WaitUtils(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait( this.driver , Duration.ofSeconds(5));
    }

    public void elemetnTobeAppear(By findby)
    {

        wait.until(ExpectedConditions.visibilityOfElementLocated(findby));


    }

    public void elemetnTobeAppearforWebelement(WebElement find)
    {

        wait.until(ExpectedConditions.visibilityOf(find));


    }

    public void elemetnTobedisapper(WebElement ele)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(ele));


    }
}
