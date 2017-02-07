package tests;

import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import util.TestRunner;

import static asserts.WebElementAsserts.assertThat;
import static pageobjects.CreateAccountPage.emailExistAlert;

public class CreateInvalidAccountTest extends TestRunner {

    @Description("Current test check that system can not create a new user account if it was create " +
            "In case we can check it via 'email input field', which throws alert that says: current email (account) is exist " +
            "Thus if alert is displayed - account is not created")

    @Test
    public final void testCreateInvalidAccount() {

        logInPage
                .openCreateAccountPage()
                .setFirstName()
                .setLastName()
                .setEmail()
                .setPassword()
                .setPhone()
                .invalidCreation();

        assertThat(emailExistAlert).isDisplayed();
    }
}
