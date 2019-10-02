package com.news_app.mobile.test;

import com.news_app.mobile.Hooks;
import com.news_app.mobile.pages.LoginPageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends Hooks {

    private LoginPageFactory pageFactory;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        super.setUp();
        pageFactory = LoginPageFactory.getInstance();
    }

    @Test
    public void checkLoginFunctionality() {
        pageFactory.typeEmail("testuser@gmail.com");
        pageFactory.typePassword("Tester001!");
    }
}
