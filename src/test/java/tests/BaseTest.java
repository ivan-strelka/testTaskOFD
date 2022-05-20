package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.MainPage;
import pages.RegisterPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static helpers.AttachmentsHelper.*;
import static helpers.DriverHelper.configureDriver;
import static helpers.DriverHelper.getConsoleLogs;


public class BaseTest {
    MainPage mainPage = new MainPage();
    RegisterPage registerPage = new RegisterPage();

    @BeforeAll
    public static void beforeAll() {

    }
    @BeforeEach
    public  void beforeEach() {
        configureDriver();
    }

    @AfterEach
    public void addAttachments() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        clearBrowserLocalStorage();
        clearBrowserCookies();
        closeWebDriver();
    }

    @AfterAll
    static void afterAll() {
        closeWebDriver();
    }
}
