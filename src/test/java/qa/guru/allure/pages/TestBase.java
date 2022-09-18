package qa.guru.allure.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("browserName", "chrome");
        //capabilities.setCapability("browserVersion", "100.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        if(System.getProperty("selenide.remote") != null) {
            Configuration.remote = System.getProperty("selenide.remote");
        }
        if(System.getProperty("browserName") != null) {
            Configuration.browser = System.getProperty("browserName");
        }
        if(System.getProperty("browserSize") != null) {
            Configuration.browserSize = System.getProperty("browserSize");
        }
        if(System.getProperty("browserVersion") != null) {
            Configuration.browserVersion = System.getProperty("browserVersion");
            capabilities.setCapability("browserVersion", Configuration.browserVersion);
        }
        capabilities.setCapability("browserName", Configuration.browser);
        capabilities.setCapability("browserSize", Configuration.browserSize);
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}