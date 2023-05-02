package com.steam.page;

import io.qameta.allure.Step;

import static testcontext.TestContext.getBrowser;

public class LandingPage extends BasePage {
    @Step("Open Landing Page")
    public void openPage() {
        getBrowser().navigateTo("https://store.steampowered.com");
    }
}
