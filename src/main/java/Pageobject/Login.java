package Pageobject;

import Utils.WaitUtils;
import com.automation.Standalone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login  {

    private WebDriver driver;



    WaitUtils waits ;

    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement emails;

    @FindBy(xpath = "//input[@id='userPassword']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='login']")
    private WebElement loginbutton;

    @FindBy(css="[class*='flyInOut']")
    private WebElement Errormsg;

    public Login(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waits = new WaitUtils(driver);
    }


    public void login(String email, String Password)
    {
        emails.click();
        password.click();
         emails.clear();
         password.clear();

         emails.sendKeys(email);
         password.sendKeys(Password);
         loginbutton.click();

    }

    public void gotopage()
    {
        driver.get("https://rahulshettyacademy.com/client/");


    }

    public void gotopagegoogle()
    {
        driver.get("https://google.com");


    }

    public String getErrorMessage()
    {
      //  waits.elemetnTobeAppearforWebelement(Errormsg);
        String msg = Errormsg.getText();
        return msg;

    }





}
