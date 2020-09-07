package com.techandsolve.yourlogoweb.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MainPage {

    public static final Target SIGN_IN_BUTTON = Target
            .the("Sign in button.")
            .locatedBy("//*[@class = 'login']");

    public static final Target EMAIL_FIELD = Target
            .the("Add the user email.")
            .located(By.id("email_create"));

    public static final Target SUBMIT_BUTTON =Target
            .the("Button to start to create the account.")
            .located(By.id("SubmitCreate"));



    public static final Target HEADER_USER_INFO = Target
            .the("The user name appear in the main bar.")
            .locatedBy("//*[contains(text(), 'Charlie')]");

}
