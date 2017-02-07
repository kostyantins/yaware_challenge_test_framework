package tests;

import org.testng.annotations.Test;
import util.DataProvider;
import util.TestRunner;

import static asserts.WebElementAsserts.assertThat;
import static pageobjects.LogInPage.invalidUser;


public class InvalidUserLogInTest extends TestRunner {

    @Test(dataProvider = "testInvalidDataLogIn", dataProviderClass = DataProvider.class)
    public final void testInvalidUserLogIn(final String invalidEmail, final String InvalidPass) {

        logInPage
                .setInvalidEmail(invalidEmail)
                .setInvalidPassword(InvalidPass)
                .doAuthorization();

        assertThat(invalidUser).isNotLogIn();
    }
}
