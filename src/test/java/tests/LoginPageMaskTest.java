package tests;

import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import util.TestRunner;

import static asserts.SoftWebElementAssert.assertThat;
import static pageobjects.LogInPage.emailInput;
import static pageobjects.LogInPage.passInput;

public class LoginPageMaskTest extends TestRunner {

    @Description("Test check if input field mask like: 'Email:' is present incite input, " +
            "it important to understand what you should set into current field")

    @Test
    public final void testLoginPageMaskTest() {

        assertThat(emailInput).hasMaskLike("Email:");

        assertThat(passInput).hasMaskLike("Password:");
    }
}
