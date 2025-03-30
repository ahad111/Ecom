package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class SceenshotUtils
{
    WebDriver driver;


    public SceenshotUtils(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);


    }

    public String getScreenshot(String Testcasename) throws IOException {

        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File getfile = new File(System.getProperty("user.dir")+"//reports/Screenshots//"+Testcasename+".png");
        FileUtils.copyFile(source,getfile);
        return System.getProperty("user.dir")+"//reports/Screenshots//"+Testcasename+".png";


    }
}
