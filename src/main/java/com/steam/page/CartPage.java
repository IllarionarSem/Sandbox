package com.steam.page;

import com.steam.page.form.CartItemListForm;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

import static testcontext.TestContext.getInteract;

public class CartPage extends BasePage {
    @Getter
    private final CartItemListForm cartItemListForm = new CartItemListForm();

    private final By continueShoppingBtnBy = By.cssSelector("div.continue_shopping_ctn a");

    @Step("Click continue shopping")
    public void clickContinueShopping() {
        getInteract().clickOn(continueShoppingBtnBy);
    }
}
