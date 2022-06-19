package com.restaurant.util;

import com.github.javafaker.Faker;
import java.time.*;
import java.util.Random;

public class Util {
    private static Faker faker = new Faker();

    public static String getFakeFirstName(){
        return faker.name().firstName();
    }
    public static String getFakeLastName() { return faker.name().lastName(); }
    public static String getFakeFullName(){
        return faker.name().fullName();
    }
    public static String getFakeAddress(){ return faker.address().fullAddress();}
    public static String getFakeEmail(){ return faker.name().username() + "@gmail.com"; }
    public static String getFakePhone(){ return faker.phoneNumber().cellPhone(); }
    public static LocalDate getFakeDate(){ return faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); }
    public static LocalTime getFakeTime(){ return faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalTime(); }
    public static int getFakeAmountPerson(){ return faker.number().randomDigitNotZero(); }

    public static int getFakeAge() {
        Random r = new Random();
        int low = 18;
        int high = 88;
        int age = r.nextInt(high - low) + low;
        return age;
    }
}