package com.ctco.framework.base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public abstract class PageObject {

    private static final String BODY = "body";

    public SelenideElement shouldBe(Condition condition) {
        return getMainElement().shouldBe(condition);
    }

    public SelenideElement shouldNotBe(Condition condition) {
        return getMainElement().shouldNotBe(condition);
    }

    public SelenideElement shouldNotBe(Condition condition, int sec) {
        return getMainElement().shouldNotBe(condition, Duration.ofSeconds(sec));
    }

    protected abstract SelenideElement getMainElement();

    public void waitUntilPageMainElementsLoad() {
        $(BODY).shouldBe(visible);
    }
}
