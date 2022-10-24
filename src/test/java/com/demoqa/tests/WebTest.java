package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.pages.WebTestPage;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebTest {
    WebTestPage webTestPage = new WebTestPage();

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("browserName", "chrome");
//        capabilities.setCapability("browserVersion", "100.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
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

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
