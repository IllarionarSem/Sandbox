package tests;

import com.steam.page.CartPage;
import com.steam.page.LandingPage;
import dataprovider.DataSetProvider;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import steps.SearchItemSteps;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static assertions.CustomAssertion.assertEquals;

@Epic("Regression tests")
@Feature("Cart Tests")
public class SteamCartTest extends BaseTest {

    private LandingPage landingPage = new LandingPage();
    private SearchItemSteps searchItemSteps = new SearchItemSteps();

    @Test(dataProviderClass = DataSetProvider.class,
            dataProvider = "game",
            description = "Check possibility to add item/items into a cart")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Add items to cart, check cart and cart count")
    @Story("Add item to cart")
    public void addProductToCartAndCheck(List<HashMap<String, String>> input) {
        input.forEach(map -> searchItemSteps.searchForItemAndAddToCartAndContinueShopping(map.get("name")));
        List<String> itemTitlesSorted = input.stream().map(m -> m.get("name")).sorted().collect(Collectors.toList());
        CartPage cartPage = landingPage.goToCart();
        List<String> actualCartItems = cartPage.getCartItemListForm().getItemTitles();
        Collections.sort(actualCartItems);
        assertEquals(actualCartItems, itemTitlesSorted, "Check that added game's are in the cart");
        assertEquals(cartPage.getCartCount(), 1, "Check that cart shown added items count");
    }
}
