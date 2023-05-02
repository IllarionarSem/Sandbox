package com.steam.page;

import com.steam.page.form.SearchResultListForm;
import lombok.Getter;

public class SearchResultPage extends BasePage {
    @Getter
    private SearchResultListForm searchResultList = new SearchResultListForm();
}
