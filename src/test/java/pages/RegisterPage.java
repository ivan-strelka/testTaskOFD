package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class RegisterPage {

    public final static SelenideElement mainPanel = $x("//div[text()='Регистрация']");

    @Step("Проверяем видимость элементов страницы регистрации")
    public void checkVisible() {
        mainPanel.shouldBe(visible);

    }





    @Step("Проверяем URL страницы регистрации")
    public void checkURL() {
        String url = WebDriverRunner.url();
        assertThat(url, is(containsString("https://org.1-ofd.ru/registration/user/new?name")));
    }
}
