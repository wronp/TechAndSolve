package com.techandsolve.rickandmortyapi.stepsdefinitions;

import com.techandsolve.rickandmortyapi.exceptions.ExceptionError;
import com.techandsolve.rickandmortyapi.models.CharacterData;
import com.techandsolve.rickandmortyapi.questions.TheText;
import com.techandsolve.rickandmortyapi.tasks.ConsumingAnApi;
import com.techandsolve.rickandmortyapi.utils.MsgError;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class RestServiceStepsdefinition {


    @Before
    public void setUp(){
        setTheStage(Cast.ofStandardActors());
        theActorCalled("Analyst");
    }

    @Given("^The user add the url of the end point$")
    public void theUserAddTheUrlOfTheEndPoint() {
        theActorInTheSpotlight().whoCan(CallAnApi.at("https://rickandmortyapi.com/api"));
    }

    @When("^The user provide the name of the (.*) to get all the data about him$")
    public void theUserProvideTheNameOfTheCharacterToGetAllTheDataAboutHim(String url, List<CharacterData> data) {
        OnStage.theActorInTheSpotlight().attemptsTo(ConsumingAnApi.Searching(url, data.get(0).getId()));
    }

    @Then("^The user verify that (.*) character was in the get method$")
    public void theUserVerifyThatNameCharacterWasInTheGetMethod(String name) {
        theActorInTheSpotlight()
                .should(seeThatResponse(response -> response.body("Results.name",
                        equalTo(name))).orComplainWith(ExceptionError.class,
                        MsgError.MSG_VALUE_ERROR.getMsg()));
    }


}
