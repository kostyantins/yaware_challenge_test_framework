package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import util.TestRunner;

import static asserts.WebElementAsserts.assertThat;
import static pageobjects.UserAccountPage.user;

public class CreateNewAccountTest extends TestRunner {

    @Test
    public final void testCreateNewAccount() {

        logInPage
                .openCreateAccountPage()
                .setFirstName()
                .setLastName()
                .setEmail()
                .setPassword()
                .setPhone()
                .createNewAccount();

        assertThat(user).isCreatedAs("Vasiliy Pupkin");
    }

    @AfterMethod
    public final void logOut() {

        logInPage
                .doLogOut();

        //method which delete user from database
    }
}
