package com.example;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AlfaBankTest {
    @Test
    void testAlfa() {
        //примеры локаторов
        open("https://alfabank.ru/");//arrange
        $(byText("Вклады")).click();// act
        $("body").shouldHave(Condition.text("Накопительные продукты"));
        $$(byText("Альфа-Вклад")).find(Condition.visible).click();
        $("body").shouldHave(Condition.text("Обратная связь"));
        $("").parent(); // ищет родителя
        $("").parent().parent(); //ищет вверх по дереву ближайший элемент вверх по дереву
        $("").closest("h1"); //ищет ближайший элемент h1 вверх по дереву
        $("").sibling(0); //первый братик эллемента
        $("").preceding(0); // как сиблинг только в обратном порядке
        //CSS "div div" любой ребенок div вне зависимости от вложенности
        //CSS "div>div" первый ребенок div
        $(".product-cell__row_recahrged:not(.disabled)").shouldHave(Condition.text("обратная связь"));//эллемнт с классом roduct-cell__... вкотором нет класса disabled
        $(".some_class_we_need:not(.class_shouls_not_be)"); //должен найти элемент по классу, в котором нет класса 2
        $(".some_class_1.some_class_2"); //ищет эл-т, в котором 2 класса
        $(".some_class_1 .some_class_2"); //ищет эл-т с классом1, в котором элемент с классом2
    }

}
