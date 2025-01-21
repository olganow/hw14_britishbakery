package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class BasketPage {

    private SelenideElement
            header = $("li[aria-current]"),
            productName = $("span[class='basket-product__main-top'] a"),
            xButton = $(".icon-cross"),
            popUpTitle = $("div[class='modal__message']"),
            delButton = $("button[class='btn-del product-remove']"),
            basketButton = $("a[class='btn btn-primary btn-sm btn-icon'] span");

    private final static String TITLE_HEADER = "Моя корзина";
    private final static String PRODUCT_NAME = "Кекс Апельсиновый";
    private final static String TITLE_DEL_WINDOWS = "Вы действительно хотите удалить товар из корзины?";
    private final static String DEL_BUTTON = "Удалить";
    private final static String EMPTY_BASKET = "0 руб.";

    public BasketPage validateTitle() {
        header.shouldHave(text(TITLE_HEADER));
        return this;
    }

    public BasketPage validateProductName() {
        productName.shouldHave(text(PRODUCT_NAME));
        return this;
    }

    public BasketPage clickXButton() {
        xButton.click();
        return this;
    }

    public BasketPage validatePopUpTitle() {
        popUpTitle.shouldHave(text(TITLE_DEL_WINDOWS));
        return this;
    }

    public BasketPage clickDeleteButton() {
        delButton.shouldHave(text(DEL_BUTTON)).click();
        return this;
    }

    public BasketPage validateEmptyBasket() {
        basketButton.shouldHave(text(EMPTY_BASKET));
        return this;
    }
}


