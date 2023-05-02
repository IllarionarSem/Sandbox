package steps;

import com.steam.page.LandingPage;

public class SearchItemSteps {
    private LandingPage landingPage = new LandingPage();

    public void searchForItemAndAddToCartAndContinueShopping(String item) {
        landingPage.getNavigationBarForm()
                .searchForItem(item)
                .getSearchResultList()
                .goToProduct(item)
                .getPurchaseForm().clickAddToCart()
                .clickContinueShopping();
    }
}
