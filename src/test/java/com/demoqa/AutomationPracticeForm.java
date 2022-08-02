package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.byText;

public class AutomationPracticeForm {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "400x1028";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Юлия");
        $("#lastName").setValue("Кудрина");
        $("#userEmail").setValue("iuliia@mail.com");
        $("[for=\"gender-radio-2\"]").click();
        $("#userNumber").setValue("89675635111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(6);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionContainingText("1997");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__day--015").click();
//        $("#dateOfBirthInput").sendKeys(Keys.CONTROL+"a");
//        $("#dateOfBirthInput").clear();
//        $("#dateOfBirthInput").setValue("15 Jul 1997");
        $("[for=\"hobbies-checkbox-2\"]").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/img.png"));
        $("#currentAddress").setValue("СПб");
        $("#state").click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Agra")).click();
        $("#submit").click();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(
                text("Юлия"),
                text("Кудрина"),
                text("iuliia@mail.com"),
                text("Female"),
                text("89675635111"),
                text("15 July,1997"),
                text("Reading"),
                text("img.png"),
                text("СПб"),
                text("Uttar Pradesh Agra"));
    }
}
