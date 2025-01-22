package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static constants.Constants.BASE_URL;


public class MainPage {
    private SelenideElement
            header = $("#cake-TABS_MAIN_REFS div[class = 'h2']"),
            login = $("span[class='login-name']");

    private final static String TITLE_HEADER = "Торт на заказ – лучший подарок на любой праздник";
    private final static String EXIT = "Войти";

    @Step("Validate the Main Page")
    public MainPage openPage() {
        open(BASE_URL);
        return this;
    }

    @Step("Validate a Main Page Title")
    public MainPage validateMainPage() {
        header.shouldHave(text(TITLE_HEADER));
        return this;
    }

    @Step("Validate a Catalog Page")
    public MainPage validateCatalogPage(String buttonName, String link) {
        SelenideElement button = $$("ul[class='header-nav-list'] a").findBy(text(buttonName));
        button.shouldHave(text(buttonName));
        button.shouldHave(attribute("href", BASE_URL + link));
        return this;
    }

    @Step("Click Login")
    public MainPage clickLogin() {
        login.shouldHave(text(EXIT)).click();
        return this;
    }

}