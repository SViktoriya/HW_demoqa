package com.demoqa.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateAndCityComponent {

    public StateAndCityComponent setState(String state) {
        $("#stateCity-wrapper").$(byText(state)).click();

        return this;
    }
    public StateAndCityComponent setCity(String city) {
        $("#stateCity-wrapper").$(byText(city)).click();

        return this;
    }
}
