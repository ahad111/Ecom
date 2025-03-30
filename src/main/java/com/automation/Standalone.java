package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Standalone {

    protected static WebDriver driver;


    public static WebDriver setUp()  {

 /*
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//GlobalData.properties");
        prop.load(fis);

        String browsername = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
*/
         //add comment
        String browsername = "chrome";
        if (browsername.contains("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (browsername.contains("headless")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\AbdulahadMatloob\\Downloads\\chromedriver1\\chromedriver.exe");
                options.addArguments("headless");
            }
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();

        } else if (browsername.equalsIgnoreCase("firefox")) {
            // System.setProperty("webdriver.gecko.driver","C:\\Users\\AbdulahadMatloob\\Downloads\\gecko\\geckodriver.exe");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }


    public  void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


