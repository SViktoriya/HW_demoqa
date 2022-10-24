package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.WebTestPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class WebTest {
    WebTestPage webTestPage = new WebTestPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.browser = "Chrome";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @Test
    void testRegistrationForm () {
        webTestPage.openPage()
                    .setFirstName("Testov")
                    .setlastName("Test")
                    .setUserEmail("Test@com.ru")
                    .setGenterWrapper("Male")
                    .setUserNumber("89999999999")
                    .setBirthDate("22", "September", "1999")
                    .setSubjects("English")
                    .setHobbies("Reading")
                    .setFile("img/1.png")
                    .setAddress("s. Address street address h.6")
                    .setStateCity("NCR","Delhi")
                    .clickSubmit()
                    .checkResultsTable()
                    .checkResult("Student Name", "Testov Test")
                    .checkResult("Student Email", "Test@com.ru")
                    .checkResult("Gender", "Male")
                    .checkResult("Mobile", "8999999999")
                    .checkResult("Date of Birth", "22 September,1999")
                    .checkResult("Subjects", "English")
                    .checkResult("Picture", "1.png")
                    .checkResult("Address", "s. Address street address h.6")
                    .checkResult("State and City", "NCR Delhi");
    }
}
