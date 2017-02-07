package tests;

import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import util.TestRunner;

import static asserts.SoftWebElementAssert.assertThat;
import static pageobjects.RemindPasswordPage.emailInput;

public class RemindPasswordPageMaskTest extends TestRunner {

    @Description("Test check if input field mask like: 'Email:' is present incite input, " +
            "it important to understand what you should set into current field")

    @Test
    public final void testRemindPasswordPageMask() {

        logInPage
                .openRemindPasswordPage();

        assertThat(emailInput).hasMaskLike("Email:");
    }
}
