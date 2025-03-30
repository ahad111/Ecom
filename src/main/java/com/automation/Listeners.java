package com.automation;

import Utils.ExtentReportUtils;
import Utils.SceenshotUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.lang.reflect.Field;

public class Listeners implements ITestListener {

    WebDriver driver;



    ExtentTest test;
    ExtentReports extent = ExtentReportUtils.getReport();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        extentTest.get().log(Status.PASS, "Test Passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {

        extentTest.get().fail(result.getThrowable());

        try {
            driver = ((Standalone) result.getInstance()).driver;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        SceenshotUtils sc = new SceenshotUtils(driver);


        String path = null;

        try {
            path = sc.getScreenshot(result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        extentTest.get().addScreenCaptureFromPath(path,result.getMethod().getMethodName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }

}
