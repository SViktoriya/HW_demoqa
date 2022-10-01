package com.demoqa.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateAndCityComponents {

    public StateAndCityComponents setState(String state) {
        $("#stateCity-wrapper").$(byText(state)).click();

        return this;
    }
    public StateAndCityComponents setCity(String city) {
        $("#stateCity-wrapper").$(byText(city)).click();

        return this;
    }
}
