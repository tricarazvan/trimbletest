package com.example.steps;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( features= {"src/test/resources/features"}, monochrome = true, plugin = { "pretty", "html:target/HtmlReport.html", "junit:target/report.xml" }, glue = "com.example.steps")

public class RunnerTest {


}
