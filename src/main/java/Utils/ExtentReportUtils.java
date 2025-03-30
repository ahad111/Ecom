package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtils {


    public static ExtentReports getReport()
    {
        String path = System.getProperty("user.dir")+"//reports//index.html";
        //File getfile = new File(System.getProperty("user.dir")+"//report//"+Testcasename+".png");
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("TESTER");
        reporter.config().setDocumentTitle("Web automation");
        reporter.config().setTheme(Theme.DARK);

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Abdul Ahad");
        return  extent;

    }
}
