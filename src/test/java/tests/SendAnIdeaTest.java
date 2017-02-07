package tests;

import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import util.TestRunner;

import static asserts.WebElementAsserts.assertThat;
import static pageobjects.YourIdeasPage.header;

public class SendAnIdeaTest extends TestRunner {

    @Description("Header appeared after an ideas is sent, thus when header is displayed we know that an idea is sent")

    @Test
    public final void testSendAnIdeaTest() {

        logInPage
                .openYourIdeasPage()
                .setTitle()
                .setDescription()
                .setEmail()
                .createAnIdea();

        assertThat(header).isDisplayed();
    }
}
