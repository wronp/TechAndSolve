package com.techandsolve.yourlogoweb.tasks;


import com.techandsolve.yourlogoweb.models.UserData;
import com.techandsolve.yourlogoweb.userinterface.MainPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;


public class LoggingIn implements Task {

    private UserData userData;

    public LoggingIn(UserData userData) {
        this.userData = userData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(MainPage.SIGN_IN_BUTTON),
                Enter.theValue(userData.getEmail()).into(MainPage.EMAIL_SIGN_IN_FIELD),
                Enter.theValue(userData.getPassword()).into(MainPage.PASSWORD_SIGN_IN_FIELD),
                Click.on(MainPage.LOGIN_BUTTON),
                WaitUntil.the(MainPage.HEADER_USER_INFO, WebElementStateMatchers.isPresent()));
    }

    public static LoggingIn inside(UserData data) {
        return Tasks.instrumented(LoggingIn.class, data);
    }
}
