package com.github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class BestContributorToSelenide {
    @Test
    void firstContributorAndreiSolntsev() {
        // открыть главную страницу
        open("https://github.com/selenide/selenide");
        // подвести мышку к первому аватару из блока contributors
        $("div.Layout-sidebar").$(Selectors.byText("Contributors"))
                .closest(".BorderGrid-cell").$$("ul li").first().hover();
//                 .closest("h2").sibling(0).$$("li").first().hover(); // менее стабильный
        // проверка: во всплывающем окне есть текст Andrei Solntsev
        $$(".Popover").findBy(Condition.visible)
                .shouldHave(Condition.text("Andrei Solntsev"));
    }
}
