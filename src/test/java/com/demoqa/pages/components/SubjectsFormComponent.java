package com.demoqa.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class SubjectsFormComponent {

    public SubjectsFormComponent setSubjects(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }
}
