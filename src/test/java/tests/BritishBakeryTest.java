package tests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.LoginPage;
import pages.MainPage;

public class BritishBakeryTest extends TestBase {
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();


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
    @DisplayName("Menu buttons for [test_data][0]")
    void mainMenuButtonsTest(String buttonName, String link) {
        mainPage.openPage();
        mainPage.validateMainPage();
        mainPage.validateCatalogPage(buttonName, link);
    }

    @Test
    @DisplayName("Validate Authorisation Form")
    void validateAuthorisationFormTest() {
        mainPage.openPage();
        mainPage.clickLogin();
        loginPage.validateTitle();
        loginPage.validatePageComponents();
    }

    @Test
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


}

