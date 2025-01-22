package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static constants.Constants.*;

public class CatalogPage {

    private SelenideElement
            header = $x("//h1"),
            basket = $("a[class='btn btn-primary btn-sm btn-icon'] span");


    private final static String TITLE_HEADER = "Каталог";
    private final static String EMPTY_BASKET = "0 руб.";

    @Step("Open Catalog Page")
    public CatalogPage openPage() {
        open(BASE_URL + CATALOG);
        return this;
    }

    @Step("Validate a Catalog Title")
    public CatalogPage validateTitle() {
        header.shouldHave(text(TITLE_HEADER));
        return this;

    }

    @Step("Validate a Catalog Page")
    public CatalogPage validateCatalogPage(String buttonName, String link) {
        SelenideElement button = $$("ul[class='page-category-list'] a").findBy(text(buttonName));
        button.shouldHave(text(buttonName));
        button.shouldHave(attribute("href", BASE_URL + link));
        return this;
    }

    @Step("Validate an Initial Basket State")
    public CatalogPage initialBasketState() {
        basket.shouldHave(text(EMPTY_BASKET));
        return this;
    }

}


