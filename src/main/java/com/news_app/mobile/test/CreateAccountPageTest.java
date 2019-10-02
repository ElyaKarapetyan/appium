package com.news_app.mobile.test;

import com.news_app.mobile.Hooks;
import com.news_app.mobile.pages.CreateAccountPageFactory;
import com.news_app.mobile.pages.LoginPageFactory;
import com.news_app.mobile.utils.helper.Helper;
import com.news_app.mobile.utils.helper.WaitHelpers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CreateAccountPageTest extends Hooks {
    private CreateAccountPageFactory pageFactory;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        super.setUp();
        pageFactory = new LoginPageFactory().clickOnCreateAccountLinkedText();
    }

    @Test
    public void checkCreateAccountFunctionality() {
        pageFactory.typeEmail(Helper.generateEmail());
        pageFactory.typePassword("Tester001!");
        pageFactory.clickOnTheCreateAccountButton();
        WaitHelpers.waitForElementDisapear(pageFactory.getCreateAccountButton(), 5000);
        assertFalse(pageFactory.getCreateAccountButton().isDisplayed(), "Failed account creation");
    }

    @Test
    public void checkCreateAccountFunctionalityWithIncorrectEmailFormat() {
        pageFactory.typeEmail("testUser");
        pageFactory.typePassword("Tester001!");
        pageFactory.clickOnTheCreateAccountButton();
        assertTrue(pageFactory.getCreateAccountButton().isDisplayed(), "Fail: Created account with invalid email/password");
    }

    @AfterClass
    public void tearDown() {
        super.quitDriver();
    }
}
