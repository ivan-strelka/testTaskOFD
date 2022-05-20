package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import utils.TestData;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


@Tag("WEB_UI")
@Feature("Phone tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Тесты номера телефона")
public class PhoneTest extends BaseTest {

    @Test
    @DisplayName("Позитивный тест кейс")
    @Description("Проверяем, что переходит на страницу регистрации")
    @Severity(SeverityLevel.CRITICAL)
    void positiveTest() {
        step("Открываем главную страницу", () -> open(""));
        step("Заполняем всю форму регистрации", () -> {
            mainPage.fillForm();
        });
        step("Проверяем элементы страницы регистрации", () -> {
            registerPage.checkVisible();
        });
        step("Заполняем форму регистрации и кликаем чек-бокс", () -> {
            registerPage.checkURL();
        });
        step("Проверяем консольные ошибки", () -> {
            mainPage.checkError();
        });
    }


    @ParameterizedTest(name = "#{index} - Негативный тест с номером телефоном значения -> {0}")
    @Description("Проверяем, что переходит на страницу регистрации")
    @DisplayName("Негативный тест кейс")
    @Severity(SeverityLevel.CRITICAL)
    @ArgumentsSource(TestData.class)
    void negativeTest(String input) {
        step("Открываем главную страницу", () -> open(""));
        step("Заполняем ФИО и email формы регистрации", () -> {
            mainPage.fillForm("Иванова анна", "sdfsd@sdfsd.com");
        });
        step("Заполняем не верный телефон", () -> {
            mainPage.fillPhoneInput(input);
        });

        step("Нажимаем на кнопку", () -> {
            mainPage.clickToContinieBtn();
        });

        step("Проверяем клиентскую ошибку", () -> {
            mainPage.checkPhoneError();
        });
    }

}
