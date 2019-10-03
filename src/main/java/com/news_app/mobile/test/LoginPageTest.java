package com.news_app.mobile.test;

import com.news_app.mobile.Hooks;
import com.news_app.mobile.constants.Constants;
import com.news_app.mobile.constants.LoginPageConstants;
import com.news_app.mobile.pages.LoginPageFactory;
import com.news_app.mobile.utils.helper.WaitHelpers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LoginPageTest extends Hooks {

    private LoginPageFactory pageFactory;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        super.setUp();
        pageFactory = new LoginPageFactory();
    }

    @Test
    public void checkLoginFunctionality() {
        pageFactory.typeEmail(Constants.VALID_EMAIL);
        pageFactory.typePassword(Constants.VALID_PASSWORD);
        pageFactory.clickOnLoginButton();
        WaitHelpers.waitForElementDisapear(pageFactory.getLoginButton(), 5000);
        assertFalse(pageFactory.getLoginButton().isDisplayed(), LoginPageConstants.FAILED_TO_LOG_IN_MESSAGE);
    }

    @Test
    public void checkLoginFunctionalityWithInvalidPassword() {
        pageFactory.typeEmail(Constants.VALID_EMAIL);
        pageFactory.typePassword(Constants.INVALID_PASSWORD);
        pageFactory.clickOnLoginButton();
        assertTrue(pageFactory.getLoginButton().isDisplayed(), LoginPageConstants.SHOULD_NOT_LOGIN_WITH_INVALID_PASSWORD_MESSAGE);
    }

    @Test
    public void checkLoginFunctionalityWithInvalidEmail() {
        pageFactory.typeEmail(Constants.INVALID_EMAIL);
        pageFactory.typePassword(Constants.VALID_PASSWORD);
        pageFactory.clickOnLoginButton();
        assertTrue(pageFactory.getLoginButton().isDisplayed(), LoginPageConstants.SHOULD_NOT_LOGIN_WITH_INVALID_EMAIL_MESSAGE);
    }

    @Test
    public void checkLoginFunctionalityWithOutEmail() {
        pageFactory.typePassword(Constants.VALID_PASSWORD);
        pageFactory.clickOnLoginButton();
        assertTrue(pageFactory.getLoginButton().isDisplayed(), LoginPageConstants.SHOULD_NOT_LOGIN_WITHOUT_EMAIL_MESSAGE);
    }

    @Test
    public void checkLoginFunctionalityWithOutPassword() {
        pageFactory.typeEmail(Constants.VALID_EMAIL);
        pageFactory.clickOnLoginButton();
        assertTrue(pageFactory.getLoginButton().isDisplayed(), LoginPageConstants.SHOULD_NOT_LOGIN_WITHOUT_PASSWORD_MESSAGE);
    }

    @AfterClass
    public void tearDown() {
        super.quitDriver();
    }
}
