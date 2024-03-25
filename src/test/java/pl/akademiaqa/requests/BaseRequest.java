package pl.akademiaqa.requests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pl.akademiaqa.properties.ClickUpProperties;
import pl.akademiaqa.url.ClickUpUrl;

public class BaseRequest {

    private static RequestSpecBuilder requestBuilder; //deklaracja zmiennej

    public static RequestSpecification requestSpec() {
        requestBuilder = new RequestSpecBuilder(); //do pola przypisuje wywołanie obiektu
        requestBuilder.setContentType(ContentType.JSON);
        requestBuilder.addHeader("Authorization", ClickUpProperties.getToken());
        requestBuilder.setBaseUri(ClickUpUrl.getBaseUrl());
        requestBuilder.addFilter(new AllureRestAssured()); // dzieki temu za pomocą komendy "mvn allure:serve" generuje sie raport allure

        //w terminalu "mvn clean test" -uruchamia testy z terminala
        return requestBuilder.build();
    }

    public static RequestSpecification requestSpecWithLogs() {
        requestBuilder = new RequestSpecBuilder(); //do pola przypisuje wywołanie obiektu
        requestBuilder.setContentType(ContentType.JSON);
        requestBuilder.addHeader("Authorization", ClickUpProperties.getToken());
        requestBuilder.setBaseUri(ClickUpUrl.getBaseUrl());
        requestBuilder.addFilter(new RequestLoggingFilter());
        requestBuilder.addFilter(new ResponseLoggingFilter());
        requestBuilder.addFilter(new AllureRestAssured());

        return requestBuilder.build();
    }


}
