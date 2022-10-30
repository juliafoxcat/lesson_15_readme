package qa.guru.allure.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverConditions.urlStartingWith;
import static io.qameta.allure.Allure.step;

public class RegistrationFormWithPageObjectsStepsTests extends TestBase {
    private static final String firstName, lastName, email, phone, text, day, month, year, hobbie, file, address, state, city;

    static {
        firstName = "Iuliia";
        lastName = "Kudrina";
        email = "rrr@mail.com";
        phone = "+19674563411";
        text = "randomtext";
        day = "15";
        month = "July";
        year = "1997";
        hobbie = "Music";
        file = "floppa.png";
        address = "My address";
        state = "NCR";
        city = "Delhi";
    }

//    @Test
//    @Feature("Xbox main page")
//    @Story("Looking for Assassin")
//    @Owner("juliafoxcat")
//    @Severity(SeverityLevel.BLOCKER)
//    @DisplayName("Check Assassin's name")
//    void lookingForAssassin() {
//        SelenideLogger.addListener("allure", new AllureSelenide());
//        step("Open page", () -> {
//            open("/ru-RU");
//        });
//        step("Looking for Assasin", () -> {
//            $("#search").click();
//            $("#cli_shellHeaderSearchInput").setValue("assassin");
//            $("#search").click();
//            $("#nav-gamescreatorscollection div h2").shouldHave(Condition.text("Creators Collection"));
//        });
//    }
//
//    @Test
//    @Feature("Xbox main page")
//    @Story("Changing the language")
//    @Owner("juliafoxcat")
//    @Severity(SeverityLevel.BLOCKER)
//    @DisplayName("Check language")
//    void changeLang() {
//        SelenideLogger.addListener("allure", new AllureSelenide());
//        step("Open page", () -> {
//            open("/ru-RU");
//        });
//        step("Language change", () -> {
//            $("#locale-picker-link").click();
//            $(byText("Argentina - Español")).click();
//            $("#c-shellmenu_49").shouldHave(Condition.text("Juegos"));
//        });
//    }

    @Test
    @Feature("Xbox main page")
    @Story("Changing the language")
    @Owner("juliafoxcat")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Check language")
    void changeLang() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Open page", () -> {
            open("/ru-RU");
        });
        step("Language change", () -> {
            $("#uhfLogo").click();
            webdriver().shouldHave(urlStartingWith("https://www.microsoft.com/"));
        });
    }
}
