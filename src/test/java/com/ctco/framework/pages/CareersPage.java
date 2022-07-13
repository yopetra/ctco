package com.ctco.framework.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.ctco.framework.base.BasePage;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.*;

public class CareersPage extends BasePage {

    private final String MAIN_ELEMENT = ".vacancies-main";
    private final String LIST_ITEM = "//div[contains(@class, 'vacancies-item vacancies-menu-block table-cell-display')]//li/a";
    private final String SKILLS_BLOCK = "//strong[text()='%s']//ancestor::p//following-sibling::ul[1]";
    private final String BULLET_ITEM = "./li";

    @Override
    protected SelenideElement getMainElement() {
        return $(MAIN_ELEMENT).shouldBe(Condition.visible);
    }

    public void clickVacancieByName(String vacancieName) {
        getMainElement();
        for (SelenideElement element : $$x(LIST_ITEM)) {
            if (element.getText().toLowerCase().contains(vacancieName.toLowerCase())) {
                element.click();
            }
        }
    }

    public void checkCountOfSkillsForBlockShouldBe(String blockName, int bulletCount) {
        SelenideElement element = $x(String.format(SKILLS_BLOCK, blockName)).shouldBe(Condition.visible);
        ElementsCollection bulletList = element.$$x(BULLET_ITEM);
        Assertions.assertEquals(bulletCount, bulletList.size(),
                String.format("Expected bullet count for block %s is wrong", blockName));
    }
}
