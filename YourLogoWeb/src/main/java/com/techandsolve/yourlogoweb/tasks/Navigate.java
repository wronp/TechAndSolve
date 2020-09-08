package com.techandsolve.yourlogoweb.tasks;

import com.techandsolve.yourlogoweb.models.UserData;
import com.techandsolve.yourlogoweb.userinterface.AccountCreationForm;
import com.techandsolve.yourlogoweb.userinterface.MainPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;


public class Navigate implements Task {

    private UserData userData;

    public Navigate(UserData userData) {
        this.userData = userData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(MainPage.SIGN_IN_BUTTON),
                Enter.theValue(userData.getEmail()).into(MainPage.EMAIL_FIELD),
                Click.on(MainPage.SUBMIT_BUTTON),
                Enter.theValue(userData.getFirstName()).into(AccountCreationForm.FIRST_NAME_TXT_FIELD),
                Enter.theValue(userData.getLastName()).into(AccountCreationForm.LAST_NAME_TXT_FIELD),
                Enter.theValue(userData.getPassword()).into(AccountCreationForm.PASSWORD_TXT_FIELD),
                Enter.theValue(userData.getAddress()).into(AccountCreationForm.ADDRESS_TXT_FIELD),
                Click.on(AccountCreationForm.COUNTRY_TXT_FIELD.called(AccountCreationForm.STATE_TXT_FIELD.toString())),
                Click.on(AccountCreationForm.COUNTRY_TXT_FIELD),
                Enter.theValue(userData.getCity()).into(AccountCreationForm.CITY_TXT_FIELD),
                Click.on(AccountCreationForm.STATE_TXT_FIELD),
                Click.on(AccountCreationForm.STATE_TXT_FIELD),
                Enter.theValue(userData.getPostalCode()).into(AccountCreationForm.POSTAL_CODE_TXT_FIELD),
                Enter.theValue(userData.getMobilePhone()).into(AccountCreationForm.MOBILE_PHONE_TXT_FIELD),
                WaitUntil.the(AccountCreationForm.SUBMIT_BUTTON_FORM,
                        WebElementStateMatchers.isPresent()),
                Click.on(AccountCreationForm.SUBMIT_BUTTON_FORM));
    }

    public static Navigate through(UserData data){
        return Tasks.instrumented(Navigate.class, data);
    }

}
