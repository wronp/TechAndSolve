package com.techandsolve.yourlogoweb.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AccountCreationForm {

    public static final Target FIRST_NAME_TXT_FIELD = Target
            .the("Add the user first name.")
            .located(By.id("customer_firstname"));

    public static final Target LAST_NAME_TXT_FIELD = Target
            .the("Add the user last name.")
            .located(By.id("customer_lastname"));

    public static final Target PASSWORD_TXT_FIELD = Target
            .the("Add the user password.")
            .located(By.id("passwd"));

    public static final Target ADDRESS_TXT_FIELD = Target
            .the("Add the user address.")
            .located(By.id("address1"));

    public static final Target CITY_TXT_FIELD = Target
            .the("Add the user city.")
            .located(By.id("city"));

    public static final Target STATE_TXT_FIELD = Target
            .the("Add the user state.")
            .locatedBy("//option[contains(text(), 'Pennsylvania')]");

    public static final Target COUNTRY_TXT_FIELD = Target
            .the("Add the user country.")
            .locatedBy("//option[text() = 'United States']");

    public static final Target POSTAL_CODE_TXT_FIELD = Target
            .the("Add the user postal code.")
            .located(By.id("postcode"));

    public static final Target MOBILE_PHONE_TXT_FIELD = Target
            .the("Add the user mobile phone.")
            .located(By.id("phone_mobile"));

    public static final Target ALIAS_TXT_FIELD = Target
            .the("Add the user alias.")
            .located(By.id("address_alias"));

    public static final Target SUBMIT_BUTTON_FORM = Target
            .the("Submit the form.")
            .located(By.id("submitAccount"));

}
