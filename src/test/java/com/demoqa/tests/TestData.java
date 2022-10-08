package com.demoqa.tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    private static final Faker faker = new Faker(new Locale("en-US"));

    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String userEmail = faker.internet().emailAddress();
    public static String genterWrapper = faker.demographic().sex();
    public static String userNumber = faker.phoneNumber().subscriberNumber(10);
    public static String birthDay = String.valueOf(faker.number().numberBetween(1, 29));
    public static String birthMonth = "September";
    public static String birthYear = String.valueOf(faker.number().numberBetween(1990, 2000));
    public static String subjects = "English";
    public static String hobbies = "Reading";
    public static String filePath = "img/1.png";
    public static String fileName = "1.png";
    public static String address = faker.address().fullAddress();
    public static String state = "NCR";
    public static String city = "Delhi";
}
