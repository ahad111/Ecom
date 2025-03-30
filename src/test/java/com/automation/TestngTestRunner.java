package com.automation;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features", // path of feature files
        glue = "com.automation.stepDefinitions", // path of web step definitions
        tags = "@Regression", // Run scenarios with these tags
        monochrome = true,
        plugin = {

                "html:target/cucumber-reports/cucumber.html"

        }
)
public class TestngTestRunner extends AbstractTestNGCucumberTests {
}
