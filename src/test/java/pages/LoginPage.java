package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;


public class LoginPage {

    private SelenideElement
            header = $("div[class='text34 auth-form__title'] b"),
            phoneInput = $("#userModalTelephone"),
            sendButton = $("#reg_send"),
            policy = $(".modal-form-policy"),
            emailLogin = $("span[data-tab='email-tab']"),
            closeButton = $("button[title='Close (Esc)']");

    private final static String TITLE_HEADER = "Вход/Регистрация";
    private final static String SEND_BUTTON = "Отправить";
    private final static String POLICY = "Нажимая на кнопку, вы соглашаетесь на обработку персональных данных в соответствии с политикой конфиденциальности";
    private final static String EMAIL_LOGIN = "Войти по e-mail";

    private String phone = "123456789";

    @Step("Validate a Title")
    public LoginPage validateTitle() {
        header.shouldHave(text(TITLE_HEADER));
        return this;
    }

    @Step("Validate Page Components")
    public LoginPage validatePageComponents() {
        phoneInput.shouldBe(visible);
        sendButton.shouldHave(text(SEND_BUTTON));
        policy.shouldHave(text(POLICY));
        emailLogin.shouldHave(text(EMAIL_LOGIN));
        closeButton.shouldBe(visible);
        return this;
    }

    @Step("Set a Phone")
    public LoginPage setPhone() {
        phoneInput.setValue(phone);
        return this;
    }

    @Step("Clear the Phone Field")
    public LoginPage clearPhone() {
        phoneInput.clear();
        return this;
    }

    @Step("Close the Form")
    public LoginPage closeForm() {
        closeButton.click();
        return this;
    }

}
