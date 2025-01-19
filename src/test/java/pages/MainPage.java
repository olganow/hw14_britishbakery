package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static constants.Constants.BASE_URL;


public class MainPage {
    private SelenideElement
            header = $("#cake-TABS_MAIN_REFS div[class = 'h2']"),
            login = $("span[class='login-name']"),
            cart = $("svg[class='icon icon-cart']");

    private final static String TITLE_HEADER = "Торт на заказ – лучший подарок на любой праздник";
    private final static String EXIT = "Войти";

    public MainPage openPage() {
        open(BASE_URL);
        return this;
    }

    public MainPage validateMainPage() {
        header.shouldHave(text(TITLE_HEADER));
        return this;
    }

    public MainPage validateCatalogPage(String buttonName, String link) {
        SelenideElement button = $$("ul[class='header-nav-list'] a").findBy(text(buttonName));
        button.shouldHave(text(buttonName));
        button.shouldHave(attribute("href", BASE_URL + link));
        return this;
    }

    public MainPage clickLogin() {
        login.shouldHave(text(EXIT)).click();
        return this;
    }

    public MainPage clickBasket() {
        cart.click();
        return this;
    }
}