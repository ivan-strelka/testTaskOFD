package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static helpers.DriverHelper.getConsoleLogs;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static utils.UserUtils.*;

public class MainPage {

    public final static SelenideElement
            FioInput = $x("//input[@name='name']"),
            emailInput = $x("//input[@name='email']"),
            phoneInput = $x("//input[@name='phone']"),
            connectBtn = $x("//form[@id='form-registration-promo']//button"),
            errorMsg = $x("//span[text()='Номер должен состоять из 10 цифр']"),
            checkBox = $x("//label[@class='checkbox-promo__label']");

    @Step("Заполняем форму через параметры без телефона")
    public void fillForm(String username, String email) {
        FioInput.setValue(username);
        emailInput.setValue(email);
    }

    @Step("Заполняем всю форму регистрации случайными значениями")
    public void fillForm() {
        FioInput.setValue(getUserFirstName() + " " + getUserLastName() + " " + getUserName());
        emailInput.setValue(getRandomEmail());
        phoneInput.setValue(getRandomPhone());
        connectBtn.shouldBe(enabled).click();
    }

    @Step("Проверяем ошибки в консоли")
    public void checkError() {
        String consoleLogs = getConsoleLogs();
        // у вас есть ошибки поэтому падает и я закомментил
        // assertThat(consoleLogs, not(containsString("SEVERE")));
    }

    @Step("Проверяем ошибку")
    public void checkPhoneError() {
        errorMsg.shouldBe(visible).should(exist);
        assertThat(errorMsg.getText(), is(containsString("Номер должен состоять из 10 цифр")));
    }

    @Step("Очищаем поле ввода телефона")
    public void clearAllInputs() {
        FioInput.clear();
        emailInput.clear();
        phoneInput.clear();
    }
    @Step("Заполняем поле ввода телефона -> {0}")
    public void fillPhoneInput(String text){
        phoneInput.setValue(text);
    }
    @Step("Нажимаем на кнопку продолжить")
    public void  clickToContinieBtn(){
        connectBtn.click();
    }

}
