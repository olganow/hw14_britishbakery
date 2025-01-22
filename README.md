<img src="/readme_resourses/british-bakery_logo.svg" width="166" height="35" alt="Логотип Британские пекарни">

## Описание функционала

Это небольшой проект по автоматизации сайта "Британские пекарни"
https://british-bakery.ru/catalog/keksy/

### Тестирование

В данном проекте реализовано 7 тестов:
- [x] простые тесты:
  - validateAuthorisationFormTest - проверка компонентов страницы авторизации
  - cancelAuthorisationTest - проверка отмены авторизации
  - initialBasketStateTest - проверка начального отображения кнопки корзины
  - validateProductCartTest - проверка компонентов  карточки товара
  - addProductToBasketAndCleanBasketTest - добавление и удаление продуктов в корзину
- [x] параметризованные:
  - mainMenuButtonsTest - тестирование кнопок меню на главной странице
  - catalogSubMenuButtonsTest - тестирование кнопок подменю на странице каталога

### Технологии

![This is an image](/readme_resourses/java_logo.png)![This is an image](/readme_resourses/gradle_logo.png)
![This is an image](/readme_resourses/selenide_logo.png)![This is an image](/readme_resourses/junit_logo.png)
![This is an image](/readme_resourses/allure_logo.png)![This is an image](/readme_resourses/tg_logo.png)

### Запуск

1. Запуск из Jenkins
2. Запуск тестов из консоли:
```
gradle clean simple_test
```

### Отчетность о запусках тестов

- [x] Allure отчет
  - Пример отчета:
<img src="/readme_resourses/allure_report.png" width="960" height="445">

- [x] Отчет о запуске в Telegram
  - Пример отчета:
  <img src="/readme_resourses/tg_report.png" width="850" height="842">



