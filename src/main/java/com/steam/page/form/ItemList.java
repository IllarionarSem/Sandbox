package com.steam.page.form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static testcontext.TestContext.getElemStateValidations;
import static testcontext.TestContext.getInteract;

public interface ItemList {
    default WebElement getFilteredElem(By listRowsBy, Predicate<WebElement> predicate) {
        return getResultRowsElements(listRowsBy).stream().filter(predicate).findFirst()
                .orElseThrow(() -> new NoSuchElementException("There are no elements matching filtered conditions"));
    }

    default Predicate<WebElement> filterElementEqualsText(By by, String title) {
        return element -> element.findElement(by).getText().equals(title);
    }

    default Function<WebElement, String> getItemDetails(By rowItem) {
        return element -> element.findElement(rowItem).getText();
    }

    default List<WebElement> getResultRowsElements(By by) {
        return getInteract().findElements(by);
    }

    default List<String> getResultText(By rows, By rowItem) {
        return getResultRowsElements(rows).stream().map(getItemDetails(rowItem)).collect(Collectors.toList());
    }
}
