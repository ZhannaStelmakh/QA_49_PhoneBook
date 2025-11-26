package ui_tests;

import dto.User;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;
import utils.RetryAnalyzer;
import utils.TestNGListener;

@Listeners(TestNGListener.class)
public class LoginTests extends ApplicationManager {

    @Test(groups = {"smoke", "user"})//(retryAnalyzer = RetryAnalyzer.class)
    public void LoginPositiveTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeder();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("cherry@gmail.com", "Ch12345$");
        logger.error("Example error");
        Assert.assertTrue(new ContactsPage(getDriver()).isTextContactsPresent("CONTACTS"));

    }

    @Test(groups = "negative")
    public void LoginNegativeTestWrongPassword(){
        User user = new User("cherry@gmail.com", "ch12345$");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeder();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginFormWithUser(user);
        Assert.assertEquals(loginPage.closeAlertReturnText(),
                "Wrong email or password");
    }
}
