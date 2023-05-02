package com.steam.page.form;

import org.openqa.selenium.By;

import java.util.List;

public class CartItemListForm implements ItemList {
    private final By itemRowBy = By.cssSelector("div.cart_item_list div.cart_item");
    private final By itemTitleBy = By.cssSelector("div.cart_item_desc a");

    public List<String> getItemTitles() {
        return getResultText(itemRowBy, itemTitleBy);
    }
}
