package com.steam.page;

import com.steam.page.form.NavigationBarForm;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

import static testcontext.TestContext.getInteract;

public abstract class BasePage {
    @Getter
    private final NavigationBarForm navigationBarForm = new NavigationBarForm();
    private final By cartBtnBy = By.id("cart_link");
    private final By cartCountBy = By.id("cart_item_count_value");

    @Step("Go to Cart")
    public CartPage goToCart() {
        getInteract().clickOn(cartBtnBy);
        return new CartPage();
    }

    public int getCartCount() {
        return Integer.parseInt(getInteract().getText(cartCountBy));
    }
}
