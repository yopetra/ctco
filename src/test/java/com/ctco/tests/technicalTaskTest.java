package com.ctco.tests;

import com.ctco.framework.pages.CareersPage;
import com.ctco.framework.pages.MainPage;
import com.ctco.framework.pages.NavigationHeader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class technicalTaskTest {

    private MainPage mainPage;
    private NavigationHeader navigationHeader;
    private CareersPage careersPage;

    @BeforeEach
    public void prepare() {
        mainPage = new MainPage();
        navigationHeader = new NavigationHeader();
        careersPage = new CareersPage();
    }

    @Test
    public void checkSkillsCountTest() {
        mainPage.open();
        navigationHeader.clickCareersMenu();
        navigationHeader.selectVacancies();
        careersPage.clickVacancieByName("Test Automation Engineer");
        careersPage.checkCountOfSkillsForBlockShouldBe("Professional skills and qualification:", 8);
    }
}
