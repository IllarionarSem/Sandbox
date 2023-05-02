package com.steam.page;

import com.steam.page.form.PurchaseForm;
import lombok.Getter;

public class GamePage extends BasePage {
    @Getter
    private final PurchaseForm purchaseForm = new PurchaseForm();
}
