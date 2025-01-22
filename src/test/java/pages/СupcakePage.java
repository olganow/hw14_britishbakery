package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static constants.Constants.*;

public class СupcakePage {

    private SelenideElement
            header = $x("//h1"),
            productName = $x("//*[text()=' Кекс Апельсиновый']"),
            productDescription = $x("//*[text()=' Кекс Апельсиновый']/parent::div//p"),
            picture = $x("//*[text()=' Кекс Апельсиновый']/parent::div/preceding-sibling::a/img"),
            badge = $x("//*[text()=' Кекс Апельсиновый']/parent::div/preceding-sibling::div/span"),
            price = $x("//*[text()=' Кекс Апельсиновый']/parent::div/following-sibling::div//span[@class='product-price']"),
            addToBasketButton = $x("//*[text()=' Кекс Апельсиновый']/parent::div/following-sibling::div//a"),
            basketButton = $("a[class='btn btn-primary btn-sm btn-icon']");


    private final static String TITLE_HEADER = "Кексы";
    private final static String PRODUCT_BADGE = "Vegan";
    private final static String PRODUCT_NAME = "Кекс Апельсиновый";
    private final static String PRODUCT_DESCRIPTION = "Бисквит с апельсиновым вкусом ";
    private final static String PRODUCT_PRICE = "390 руб.";
    private final static String PRODUCT_ADD_BASKET = "\n" +
            "                                                Добавить в корзину                                             ";
    private String expectedSrc = "https://british-bakery.ru/upload/resize_cache/iblock/249/400_400_1/2492002434bd161f64a24f7f47bc709c.jpg";

    @Step("Open Сupcakes Page")
    public СupcakePage openPage() {
        open(BASE_URL + CATALOG + KEKSY);
        return this;
    }

    @Step("Validate a Сupcakes Title")
    public СupcakePage validateTitle() {
        header.shouldHave(text(TITLE_HEADER));
        return this;
    }

    @Step("Validate a Product Card")
    public СupcakePage validateProductCard() {
        header.shouldHave(text(TITLE_HEADER));
        productName.scrollIntoView(true).shouldHave(text(PRODUCT_NAME));
        badge.shouldHave(text(PRODUCT_BADGE));
        productDescription.shouldHave(text(PRODUCT_DESCRIPTION));
        price.shouldHave(text(PRODUCT_PRICE));
        String actualSrc = picture.getAttribute("src");
        Assertions.assertEquals(expectedSrc, actualSrc, "Image src does not match");
        return this;
    }

    @Step("Click Add Product To Basket")
    public СupcakePage clickAddProductToBasket() {
        addToBasketButton.scrollIntoView(true).shouldBe(visible).shouldHave(text(PRODUCT_ADD_BASKET)).click();
        return this;
    }

    @Step("Click Basket Button")
    public СupcakePage clickBasketButton() {
        basketButton.shouldBe(visible).click();
        return this;
    }

}


