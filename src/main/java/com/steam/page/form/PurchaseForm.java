package com.steam.page.form;

import com.steam.page.CartPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static testcontext.TestContext.getInteract;

public class PurchaseForm {
    private final By addToCartBtnBy = By.xpath("//a[contains(@id,'btn_add_to_cart')]");

    @Step("Add item to cart")
    public CartPage clickAddToCart() {
        getInteract().clickOn(addToCartBtnBy);
        return new CartPage();
    }
}
