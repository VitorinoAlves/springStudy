package com.example.endToEndTesting.runs;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        tags = "@Smoke2",
        glue = {"com.example.endToEndTesting.stepDefinitions", "com.example.endToEndTesting"}
)
public class CucumberSmokeTest {
}
