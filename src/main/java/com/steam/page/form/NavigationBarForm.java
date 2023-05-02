package com.steam.page.form;

import com.steam.page.SearchResultPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static testcontext.TestContext.getInteract;

public class NavigationBarForm {
    private final By searchFieldBy = By.id("store_nav_search_term");
    private final By searchBtnBy = By.id("store_search_link");

    @Step("Type '{0}' into a search field and click search btn")
    public SearchResultPage searchForItem(String text) {
        getInteract().clearAndType(searchFieldBy, text);
        getInteract().clickOn(searchBtnBy);
        return new SearchResultPage();
    }
}
