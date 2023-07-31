package com.github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.editable;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {
    @Test
    void shouldFindSelenideRepositoryAtTheTop() {
        // открыть главную страницу
        open("https://github.com/");
        // ввести в поле поиска selenide и нажать enter
        $(".header-search-button span").click();
        $("#query-builder-test").shouldBe(editable).setValue("selenide").pressEnter();
        // кликнуть на первый репозиторий из списка найденых
        $$("h3").first().$("a").click();
        //$$("h3").get(0).$("a").click();
        // .classname, #id, [],  a[href=abc].red эллемент а с атрибутом href = abc и одновременно с классом red
        // проверка: заголовок selenide/selenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));

    }
}
