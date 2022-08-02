package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Юлия");
        $("#userEmail").setValue("iuliia@mail.com");
        $("#currentAddress").setValue("SPb, Zheleznaya 10, 56");
        $("#permanentAddress").setValue("SPb, Zheleznaya 10, 56");
        $("#submit").click();

        $("#output #name").shouldHave(text("Юлия"));
//        $("#output").$("#name").shouldHave(text("Юлия"));
//        $("#output").shouldHave(text("Юлия"));
//        $("#name").shouldHave(text("Юлия"));
        $("#output #email").shouldHave(text("iuliia@mail.com"));
        $("#output #currentAddress").shouldHave(text("SPb, Zheleznaya 10, 56"));
        $("#output #permanentAddress").shouldHave(text("SPb, Zheleznaya 10, 56"));

    }
}
