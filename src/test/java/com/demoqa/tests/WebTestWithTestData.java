package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.WebTestPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.demoqa.tests.TestData.*;

public class WebTestWithTestData {
    WebTestPage webTestPage = new WebTestPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.browser = "Chrome";
    }

    @Test
    void testRegistrationForm() {
        webTestPage.openPage()
                .setFirstName(firstName)
                .setlastName(lastName)
                .setUserEmail(userEmail)
                .setGenterWrapper(genterWrapper)
                .setUserNumber(userNumber)
                .setBirthDate(birthDay, birthMonth, birthYear)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setFile(filePath)
                .setAddress(address)
                .setStateCity(state, city)
                .clickSubmit()
                .checkResultsTable()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", genterWrapper)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .checkResult("Subjects", subjects)
                .checkResult("Picture", fileName)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);
    }
}
