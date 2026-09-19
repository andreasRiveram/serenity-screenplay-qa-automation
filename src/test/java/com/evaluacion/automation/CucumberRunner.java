package com.evaluacion.automation;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "classpath:features",
        glue = "com.evaluacion.automation.stepdefinitions"
        //tags = "@web1"

)
public class CucumberRunner {}
