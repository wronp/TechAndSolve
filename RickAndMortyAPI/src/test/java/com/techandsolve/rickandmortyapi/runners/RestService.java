package com.techandsolve.rickandmortyapi.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/rest_service.feature",
        snippets = SnippetType.CAMELCASE,
        glue = "com.techandsolve.rickandmortyapi.stepsdefinitions")

public class RestService {
}
