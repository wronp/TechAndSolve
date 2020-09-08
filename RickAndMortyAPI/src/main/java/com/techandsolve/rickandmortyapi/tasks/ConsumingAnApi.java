package com.techandsolve.rickandmortyapi.tasks;

import com.techandsolve.rickandmortyapi.models.CharacterData;
import io.restassured.RestAssured;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.path.json.config.JsonPathConfig.NumberReturnType.BIG_DECIMAL;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class ConsumingAnApi implements Task {

    private String url;
    private String id;

    public ConsumingAnApi(String url, String id) {
        this.url = url;
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        theActorInTheSpotlight().whoCan(CallAnApi.at("https://rickandmortyapi.com/api"));

        given().
                config(RestAssured.config().jsonConfig(jsonConfig().numberReturnType(BIG_DECIMAL))).
                when().
                get("https://rickandmortyapi.com/api/character").
                then().log().all().getClass().getName().toString();

        //String ApiList = SerenityRest.lastResponse().prettyPrint();
    }

    public static ConsumingAnApi Searching(String url, String id){
        return Tasks.instrumented(ConsumingAnApi.class, url, id);
    }
}
