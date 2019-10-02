package com.news_app.mobile.test;

import com.news_app.mobile.Hooks;
import com.news_app.mobile.pages.LoginPageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class LoginPageTest extends Hooks {

    private LoginPageFactory pageFactory;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        super.setUp();
        pageFactory = LoginPageFactory.getInstance();
    }

    @Test
    public void checkLoginFunctionality() {
        pageFactory.typeEmail("test@gmail.com");
        pageFactory.typePassword("Tester001!");
        pageFactory.clickOnLoginButton();
        assertFalse(pageFactory.getLoginButton().isDisplayed(), "Failed to log in into app");
    }
}
