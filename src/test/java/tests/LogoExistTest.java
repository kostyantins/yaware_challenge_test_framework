package tests;

import org.testng.annotations.Test;
import util.TestRunner;

import static asserts.WebElementAsserts.assertThat;
import static pageobjects.LogInPage.logo;

public class LogoExistTest extends TestRunner {

    @Test
    public final void testLogoExist() {

        assertThat(logo).isDisplayed();
    }
}
