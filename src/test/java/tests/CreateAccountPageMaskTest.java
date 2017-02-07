package tests;

import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import util.TestRunner;

import static asserts.SoftWebElementAssert.assertThat;
import static pageobjects.CreateAccountPage.*;

public class CreateAccountPageMaskTest extends TestRunner {

    @Description("Test check if input field mask like: 'Email:' is present incite input, " +
            "it important to understand what you should set into current field")

    @Test
    public final void testCreateAccountPageMask() {

        logInPage
                .openCreateAccountPage();

        assertThat(firstNameInput).hasMaskLike("First Name:");

        assertThat(lastNameInput).hasMaskLike("Last Name:");

        assertThat(emailInput).hasMaskLike("Email:");

        assertThat(passInput).hasMaskLike("Password:");

        assertThat(phoneInput).hasMaskLike("+380 39 123 4567");
    }
}
