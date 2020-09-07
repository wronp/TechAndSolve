package com.techandsolve.yourlogoweb.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/account_creation.feature",
                snippets = SnippetType.CAMELCASE,
                glue = "com.techandsolve.yourlogoweb.stepsdefinitions")

public class AccountCreation {
}
