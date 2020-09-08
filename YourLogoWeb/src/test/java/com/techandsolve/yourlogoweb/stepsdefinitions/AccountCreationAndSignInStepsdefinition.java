package com.techandsolve.yourlogoweb.stepsdefinitions;

import com.techandsolve.yourlogoweb.exceptions.ExceptionError;
import com.techandsolve.yourlogoweb.models.UserData;
import com.techandsolve.yourlogoweb.questions.TheText;
import com.techandsolve.yourlogoweb.tasks.LoggingIn;
import com.techandsolve.yourlogoweb.tasks.Navigate;
import com.techandsolve.yourlogoweb.userinterface.MainPage;
import com.techandsolve.yourlogoweb.utils.MsgError;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import javax.swing.*;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class AccountCreationAndSignInStepsdefinition {

    @Managed
    private WebDriver driver;

    @Before
    public void setUp(){
        setTheStage(Cast.ofStandardActors());
        theActorCalled("Analyst");
        theActorInTheSpotlight().can(BrowseTheWeb.with(driver));
    }

    @Given("^The user is in the main page$")
    public void the_user_is_in_the_main_page() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("http://automationpractice.com/index.php"));
    }


    @When("^The user create the account$")
    public void the_user_create_the_account(List<UserData> data) {
        OnStage.theActorInTheSpotlight().attemptsTo(Navigate.through(data.get(0)));
    }

    @When("^The user add his credentials$")
    public void theUserAddHisCredentials(List<UserData> data) {
        OnStage.theActorInTheSpotlight().attemptsTo(LoggingIn.inside(data.get(0)));
    }

    @Then("^The user can watch his (.*) in the main bar$")
    public void the_user_can_watch_his_name_in_the_main_bar(String name) {
        OnStage.theActorInTheSpotlight().should(seeThat(
                TheText.of(MainPage.HEADER_USER_INFO), is(equalTo(name)))
                .orComplainWith(ExceptionError.class, MsgError.MSG_CODE_ERROR.getMsg()));
    }

}
