package com.am.testrunner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features= "src/test/java/com/am/feature",
glue={
		"com.am.pages",
		"com.am.stepdefinition",
		"com.am.testrunner"
},
tags = "@login, @MiniPanel",
monochrome=true,
strict=true,
dryRun=true

		)

/** CUCUMBER TEST RUNNER CLASS*/
public class TestRunner 
{
	@BeforeClass
	public static void setup() 
	{

	}

}	
