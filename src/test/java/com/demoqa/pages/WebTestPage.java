package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultTableComponent;
import com.demoqa.pages.components.StateAndCityComponent;
import com.demoqa.pages.components.SubjectsFormComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebTestPage {

    //Добавлены компоненты
    private CalendarComponent calendarComponent = new CalendarComponent();
    private SubjectsFormComponent subjectsFormComponent = new SubjectsFormComponent();
    private StateAndCityComponent stateAndCityComponent = new StateAndCityComponent();
    private ResultTableComponent resultTableComponent = new ResultTableComponent();

    //Вынесла все ID в переменные
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapperInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            fileInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitInput = $("#submit");

    public WebTestPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public WebTestPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public WebTestPage setlastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public WebTestPage setUserEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public WebTestPage setGenterWrapper(String value) {
        genderWrapperInput.$(byText(value)).click();

        return this;
    }

    public WebTestPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public WebTestPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public WebTestPage setSubjects(String value) {
        subjectsFormComponent.setSubjects(value);

        return this;
    }

    public WebTestPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();

        return this;
    }

    public WebTestPage setFile(String value) {
        fileInput.uploadFromClasspath(value);

        return this;
    }

    public WebTestPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public WebTestPage setStateCity(String state, String city) {
        stateInput.click();
        stateAndCityComponent.setState(state);
        cityInput.click();
        stateAndCityComponent.setCity(city);

        return this;
    }

    public WebTestPage clickSubmit() {
        submitInput.click();

        return this;
    }

    public WebTestPage checkResultsTable() {
        resultTableComponent.checkVisible();

        return this;
    }

    public WebTestPage checkResult(String key, String value) {
        resultTableComponent.checkResult(key, value);

        return this;
    }
}
