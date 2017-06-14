package tests;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import util.TestRunner;

public class FindByTest extends TestRunner {

    @Test
    public final void testFindBy() {

        logInPage
                .getAllElementsInList().get(0).sendKeys("hliurhgfaiugh");
        logInPage
                .getAllElementsInList().get(1).sendKeys("123456789");


    }
}

