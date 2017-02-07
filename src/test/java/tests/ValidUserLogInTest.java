package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import util.TestRunner;

import static asserts.WebElementAsserts.assertThat;
import static pageobjects.UserAccountPage.user;

public class ValidUserLogInTest extends TestRunner {

    @Test
    public final void testValidUserLogIn() {

        logInPage
                .setEmail()
                .setPassword()
                .doAuthorization();

        assertThat(user).isLogInAs("Vitaliy Pupkin");
    }

    @AfterMethod
    public final void logOut() {

        logInPage
                .doLogOut();
    }
}
