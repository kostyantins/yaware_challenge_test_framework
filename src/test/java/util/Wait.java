package util;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static util.WebDriverFactory.getDriver;

public final class Wait {

    private Wait() {
    }

    public static WebElement getClickableElement(final WebElement element) {

        int timeout = 30;

        return new WebDriverWait(getDriver(), timeout)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
