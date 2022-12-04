package com.demoqa.tests;

import com.demoqa.pages.WebTestPage;
import org.junit.jupiter.api.Test;

import static com.demoqa.tests.TestData.*;

public class WebTestWithTestData extends TestBase{
    WebTestPage webTestPage = new WebTestPage();

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
