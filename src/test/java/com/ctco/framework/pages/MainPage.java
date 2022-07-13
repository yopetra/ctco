package com.ctco.framework.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.ctco.framework.base.BasePage;
import com.ctco.framework.configuration.Urls;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {

    private final String MAIN_ELEMENT = "main-page";

    @Override
    protected SelenideElement getMainElement() {
        return $(MAIN_ELEMENT).shouldBe(Condition.visible);
    }

    @Override
    protected String getPageUrl(){
        return Urls.EN.getUrl();
    }
}
