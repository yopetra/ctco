package com.ctco.framework.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.ctco.framework.base.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class NavigationHeader extends BasePage {

    private final String MAIN_ELEMENT = ".navbar-default";
    private final String CAREERS_MENU = "//li/a[text()='Careers']";
    private final String VACANSIES_SUBMENU = "//ul[@class='sub-menu']/li/a[text()='Vacancies']";

    @Override
    protected SelenideElement getMainElement() {
        return $(MAIN_ELEMENT).shouldBe(Condition.visible);
    }

    public void clickCareersMenu() {
        getMainElement();
        $x(CAREERS_MENU).click();
    }

    public void selectVacancies() {
        $x(VACANSIES_SUBMENU).shouldBe(Condition.visible).click();
    }
}
