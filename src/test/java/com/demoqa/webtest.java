package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class webtest {
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.browser = "Chrome";
        Configuration.timeout = 10000;
    }

    @Test
    void testRegistrationForm () {
        open("/automation-practice-form");

        $("#firstName").setValue("Testov");
        $("#lastName").setValue("Test");
        $("#userEmail").setValue("Test@com.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("89999999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--008:not(.react-datepicker__day--selected").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();;
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("s. Address street address h.6");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(text("Testov Test"),
                text("Test@com.ru"),
                text("Male"),
                text("8999999999"),
                text("08 September,1990"),
                text("English"),
                text("Reading"),
                text("1.png"),
                text("s. Address street address h.6"),
                text("NCR Delhi"));
//        $("#closeLargeModal").click();



    }
}
