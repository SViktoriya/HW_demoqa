package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponents;
import com.demoqa.pages.components.ResultTableComponents;
import com.demoqa.pages.components.StateAndCityComponents;
import com.demoqa.pages.components.SubjectsFormComponents;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebTestPages {

    //Добавлены компоненты
    private CalendarComponents calendarComponents = new CalendarComponents();
    private SubjectsFormComponents subjectsFormComponents = new SubjectsFormComponents();
    private StateAndCityComponents stateAndCityComponents = new StateAndCityComponents();
    private ResultTableComponents resultTableComponents = new ResultTableComponents();

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

    public WebTestPages openPage() {
        open("/automation-practice-form");

        return this;
    }

    public WebTestPages setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public WebTestPages setlastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public WebTestPages setUserEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public WebTestPages setGenterWrapper(String value) {
        genderWrapperInput.$(byText(value)).click();

        return this;
    }
    public WebTestPages setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public WebTestPages setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponents.setDate(day, month, year);

        return this;
    }

    public WebTestPages setSubjects(String value) {
        subjectsFormComponents.setSubjects(value);

        return this;
    }

    public WebTestPages setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();

        return this;
    }

    public WebTestPages setFile(String value) {
        fileInput.uploadFromClasspath(value);

        return this;
    }

    public WebTestPages setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public WebTestPages setStateCity(String state, String city) {
        stateInput.click();
        stateAndCityComponents.setState(state);
        cityInput.click();
        stateAndCityComponents.setCity(city);

        return this;
    }

    public WebTestPages clickSubmit () {
        submitInput.click();

        return this;
    }

    public WebTestPages checkResultsTable () {
        resultTableComponents.checkVisible();

        return this;
    }

    public WebTestPages checkResult(String key, String value) {
        resultTableComponents.checkResult(key, value);

        return this;
    }
}
