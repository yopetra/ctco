package com.ctco.framework.base;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.commons.lang3.NotImplementedException;

public abstract class BasePage extends PageObject{

    public void open() {
        String url = getPageUrl();
        Selenide.open(url);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    protected String getPageUrl() {
        throw new NotImplementedException();
    }
}
