package tests;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import util.TestRunner;

import static asserts.WebElementAsserts.assertThat;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static pageobjects.UserAccountPage.user;

public class ValidUserLogInTest extends TestRunner {

//    @Test
//    public final void testValidUserLogIn() {
//        logInPage
//                .setEmail()
//                .setPassword()
//                .doAuthorization();
//
//        //custom assert
//        assertThat(user).isLogInAs("Vitaliy Pupkin");
//
//        //assert with selenide
//        $(user).shouldHave(text("Vitaliy Pupkin"));
//    }
//
//    @AfterMethod
//    public final void logOut() {
//        logInPage
//                .doLogOut();
//    }

    @Test
    public void testLogIn() {
        $(By.id("username")).sendKeys("Igor.Tazylyak");
        $(By.id("password")).sendKeys("1236456");
        $(By.id("submit")).click();


//        $(homePage.getHomePageLocators().getUserLoginText().getText()).shouldHave(Condition.text("Igor.Tazylyak"));
    }
}
