package com.news_app.mobile.test;

import com.news_app.mobile.Hooks;
import com.news_app.mobile.constants.Constants;
import com.news_app.mobile.constants.CreateAccountPageConstants;
import com.news_app.mobile.pages.CreateAccountPageFactory;
import com.news_app.mobile.pages.LoginPageFactory;
import com.news_app.mobile.utils.helper.Helper;
import com.news_app.mobile.utils.helper.WaitHelpers;
import org.testng.annotations.AfterClass;
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
        pageFactory.typePassword(Constants.VALID_PASSWORD);
        pageFactory.clickOnTheCreateAccountButton();
        WaitHelpers.waitForElementDisapear(pageFactory.getCreateAccountButton(), 5000);
        assertFalse(pageFactory.getCreateAccountButton().isDisplayed(), CreateAccountPageConstants.FAILED_TO_CREATE_ACCOUNT_MESSAGE);
    }

    @Test
    public void checkCreateAccountFunctionalityWithInvalidEmailFormat() {
        pageFactory.typeEmail(Constants.INVALID_EMAIL);
        pageFactory.typePassword(Constants.VALID_PASSWORD);
        pageFactory.clickOnTheCreateAccountButton();
        assertFalse(pageFactory.getCreateAccountButton().isDisplayed(), CreateAccountPageConstants.ACCOUNT_CREATED_MESSAGE);
    }

    @Test
    public void checkCreateAccountFunctionalityWithOutPassword() {
        pageFactory.typeEmail(Constants.VALID_EMAIL);
        pageFactory.clickOnTheCreateAccountButton();
        assertTrue(pageFactory.getCreateAccountButton().isDisplayed(), CreateAccountPageConstants.SHOULD_NOT_CREATE_ACCOUNT_WITHOUT_PASSWORD_MESSAGE);
    }

    @Test
    public void checkCreateAccountFunctionalityWithOutEmail() {
        pageFactory.typePassword(Constants.VALID_PASSWORD);
        pageFactory.clickOnTheCreateAccountButton();
        assertTrue(pageFactory.getCreateAccountButton().isDisplayed(), CreateAccountPageConstants.SHOULD_NOT_CREATE_ACCOUNT_WITHOUT_EMAIL_MESSAGE);
    }

    @AfterClass
    public void tearDown() {
        super.quitDriver();
    }
}
