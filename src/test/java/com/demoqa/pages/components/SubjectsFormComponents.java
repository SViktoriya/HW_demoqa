package com.demoqa.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class SubjectsFormComponents {

    public SubjectsFormComponents setSubjects(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }
}
