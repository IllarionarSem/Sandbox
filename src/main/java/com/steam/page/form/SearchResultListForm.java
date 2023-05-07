package com.steam.page.form;

import com.steam.page.GamePage;
import element.ElemStateValidation;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static testcontext.TestContext.getElemStateValidations;
import static testcontext.TestContext.getInteract;

public class SearchResultListForm implements ItemList {
    private final By resultRowsBy = By.cssSelector("#search_resultsRows a");
    private final By productTitleBy = By.cssSelector("span.title");
    private final By searchResultContainer = By.id("search_result_container");

    @Step("On Search Result list click on item '{0}'")
    public GamePage goToProduct(String text) {
        getElemStateValidations().performWait(getInteract().findElement(searchResultContainer), ElemStateValidation.State.BEFORE_EXTRACT_TEXT);
        getInteract().clickOn(getFilteredElem(resultRowsBy, filterElementEqualsText(productTitleBy, text)));
        return new GamePage();
    }
}
