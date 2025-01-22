package tests;


import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.*;


public class BritishBakeryTest extends TestBase {
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    CatalogPage catalogPage = new CatalogPage();
    СupcakePage сupcakePage = new СupcakePage();
    BasketPage basketPage = new BasketPage();

    @CsvSource(value = {
            "Каталог, /catalog/",
            "Торты на заказ, /catalog/torty-na-zakaz/",
            "Начинки, /toppings/",
            "Акции, /stocks/",
            "Доставка и оплата, /delivery/",
            "Компания, /about/",
            "Отзывы, /reviews/",
            "Контакты, /contacts/"
    })
    @ParameterizedTest
    @Feature("British Bakery")
    @Story("Main Page")
    @Owner("Olganow")
    @Link(value = "Testing", url = "https://github.com/olganow")
    @Tag("actual")
    @DisplayName("Menu buttons for [test_data][0]")
    void mainMenuButtonsTest(String buttonName, String link) {
        mainPage.openPage();
        mainPage.validateMainPage();
        mainPage.validateCatalogPage(buttonName, link);
    }

    @Test
    @Feature("British Bakery")
    @Story("Main page")
    @Owner("Olganow")
    @Link(value = "Testing", url = "https://github.com/olganow")
    @Tag("actual")
    @DisplayName("Validate Authorisation Form")
    void validateAuthorisationFormTest() {
        mainPage.openPage();
        mainPage.clickLogin();
        loginPage.validateTitle();
        loginPage.validatePageComponents();
    }

    @Test
    @Feature("British Bakery")
    @Story("Login")
    @Owner("Olganow")
    @Link(value = "Testing", url = "https://github.com/olganow")
    @Tag("actual")
    @DisplayName("Cancel Authorisation")
    void cancelAuthorisationTest() {
        mainPage.openPage();
        mainPage.clickLogin();
        loginPage.validateTitle();
        loginPage.setPhone();
        loginPage.clearPhone();
        loginPage.closeForm();
        mainPage.validateMainPage();
    }


    @CsvSource(value = {
            "Торты | /catalog/torty/",
            "Дополнения к торту | /catalog/dopolneniya-k-tortu/",
            "Пирожные, кексы | /catalog/pirozhnye-keksy/",
            "Новый год | /catalog/novyy-god/",
            "Свежая выпечка и сэндвичи | /catalog/svezhaya-vypechka-i-sendvichi/",
            "Шоколад и конфеты | /catalog/shokolad-shokoladnye-batonchiki/",
            "Печенье | /catalog/pechene/",
            "Чай и кофе | /catalog/chay-i-kofe/",
            "Хлеб  | /catalog/khleb/",
            "Напитки | /catalog/napitki/",
            "Замороженные продукты | /catalog/zamorozka/",
            "Фирменные сувениры | /catalog/firmennyy-suveniry/",
            "Мёд, варенье, пасты | /catalog/myed-varene-pasty/",
            "Предметы интерьера | /catalog/predmety-interera/"

    }, delimiter = '|')
    @ParameterizedTest
    @Feature("British Bakery")
    @Story("Catalog tests")
    @Owner("Olganow")
    @Link(value = "Testing", url = "https://github.com/olganow")
    @Tag("actual")
    @DisplayName("Catalog Sub Menu Buttons  for [test_data][0]")
    void catalogSubMenuButtonsTest(String buttonName, String link) {
        catalogPage.openPage();
        catalogPage.validateTitle();
        catalogPage.validateCatalogPage(buttonName, link);
    }

    @Test
    @Feature("British Bakery")
    @Story("Catalog tests")
    @Owner("Olganow")
    @Link(value = "Testing", url = "https://github.com/olganow")
    @Tag("actual")
    @DisplayName("Initial Basket State")
    void initialBasketStatet() {
        catalogPage.openPage();
        catalogPage.validateTitle();
        catalogPage.initialBasketState();
    }

    @Test
    @Feature("British Bakery")
    @Story("Capcakes page tests")
    @Owner("Olganow")
    @Link(value = "Testing", url = "https://github.com/olganow")
    @Tag("actual")
    @DisplayName("Validate product Card")
    void validateProductCart() {
        сupcakePage.openPage();
        сupcakePage.validateTitle();
        сupcakePage.validateProductCard();
    }

    @Test
    @Feature("British Bakery")
    @Story("Basket tests")
    @Owner("Olganow")
    @Link(value = "Testing", url = "https://github.com/olganow")
    @Tag("actual")
    @DisplayName("Add product Card and clean basket")
    void addProductToBasketAndCleanBasket() {
        сupcakePage.openPage();
        сupcakePage.validateTitle();
        сupcakePage.clickAddProductToBasket();
        сupcakePage.clickBasketButton();
        basketPage.validateTitle();
        basketPage.validateProductName();
        basketPage.clickXButton();
        basketPage.validatePopUpTitle();
        basketPage.clickDeleteButton();
        basketPage.validateEmptyBasket();
    }
}




