package runners;

import org.junit.runner.*;

import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(
features ="src/test/resources/features",
glue = {"stepdefinitions","hooks"},
plugin= {"pretty",
		"html:taget/cucumber.report.html",
		"json:target/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
monochrome=true,
tags ="@regression"


)
public class TestRunner {

}
