package com.ksoft.utilities;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty"},
		//plugin = {"html:target/cucumber-html-report"},
		glue = {"stepdefs"},
		features = {"src/test/features"},
		format = {
		"pretty", // Console with colors
		"html:target/cucumber-reports/cucumber-pretty", // general HTML report
		"json:target/cucumber-reports/CucumberTestReport.json", // JSON report
		"rerun:target/cucumber-reports/rerun.txt" // Contain failed tests
})
public class CucumberTests {}
