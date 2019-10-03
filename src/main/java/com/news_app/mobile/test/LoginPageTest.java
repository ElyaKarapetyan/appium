package com.news_app.mobile.test;

import com.news_app.mobile.Hooks;
import com.news_app.mobile.constants.Constants;
import com.news_app.mobile.constants.LoginPageConstants;
import com.news_app.mobile.pages.LoginPageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class LoginPageTest extends Hooks {

    private LoginPageFactory pageFactory;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        super.setUp();
        pageFactory = new LoginPageFactory();
    }

    @Test
    public void checkLoginFunctionality() {
        pageFactory.typeEmail(Constants.VALID_EMAIL);
        pageFactory.typePassword(Constants.VALID_PASSWORD);
        pageFactory.clickOnLoginButton();
        assertFalse(pageFactory.getLoginButton().isDisplayed(), LoginPageConstants.FAILED_TO_LOG_IN_MESSAGE);
    }

    @AfterClass
    public void tearDown() {
        super.quitDriver();
    }
}
