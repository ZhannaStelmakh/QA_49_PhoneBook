package ui_tests;

import dto.User;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends ApplicationManager {

    @Test
    public void LoginPositiveTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeder();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("cherry@gmail.com", "Ch12345$");
        Assert.assertTrue(new ContactsPage(getDriver()).isTextContactsPresent("CONTACTS"));

    }

    @Test
    public void LoginNegativeTestWrongPassword(){
        User user = new User("cherry@gmail.com", "ch12345$");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeder();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginFormWithUser(user);
        Assert.assertEquals(loginPage.closeAlertReturnText(), "Wrong email or password");


    }
}
