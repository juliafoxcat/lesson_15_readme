package qa.guru.allure.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlStartingWith;
import static io.qameta.allure.Allure.step;

public class XboxTests extends TestBase {

    @Test
    @Feature("Xbox main page")
    @Story("Looking for Assassin")
    @Owner("juliafoxcat")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Check Assassin's name")
    void lookingForAssassin() {
        step("Open page", () -> {
            open("/ru-RU");
        });
        step("Looking for Assasin", () -> {
            $("#search").click();
            $("#cli_shellHeaderSearchInput").setValue("assassin");
            $("#search").click();
            $("#nav-gamescreatorscollection div h2").shouldHave(Condition.text("Creators Collection"));
        });
    }

    @Test
    @Feature("Xbox main page")
    @Story("Changing the language")
    @Owner("juliafoxcat")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Check language")
    void changeLang() {
        step("Open page", () -> {
            open("/ru-RU");
        });
        step("Language change", () -> {
            $("#locale-picker-link").click();
            $(byText("Argentina - Español")).click();
            $("#c-shellmenu_49").shouldHave(Condition.text("Juegos"));
        });
    }

    @Test
    @Feature("Xbox main page")
    @Story("Redirect to Microsoft")
    @Owner("juliafoxcat")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Check the redirect")
    void redirect() {
        step("Open page", () -> {
            open("/ru-RU");
        });
        step("Go to Microsoft", () -> {
            $("#uhfLogo").click();
            webdriver().shouldHave(urlStartingWith("https://www.microsoft.com/"));
        });
    }

    @Test
    @Feature("Xbox main page")
    @Story("Game Pass")
    @Owner("juliafoxcat")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Check Game Pass")
    void gamePass() {
        step("Open page", () -> {
            open("/ru-RU");
        });
        step("Check Game Pass", () -> {
            $("#ContentBlockList_3 div div a div p span").shouldHave(Condition.text("GAME PASS"));
        });
    }

    @Test
    @Feature("Xbox main page")
    @Story("Going to Login page")
    @Owner("juliafoxcat")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Check opening Login")
    void loginPage() {
        step("Open page", () -> {
            open("/ru-RU");
        });
        step("Going to Login page", () -> {
            $("#mectrl_headerPicture").click();
            webdriver().shouldHave(urlStartingWith("https://login.live.com/"));
        });
    }
}
