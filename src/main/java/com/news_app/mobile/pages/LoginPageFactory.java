package com.news_app.mobile.pages;

import com.news_app.mobile.constants.Constants;
import com.news_app.mobile.utils.helper.WaitHelpers;
import io.appium.java_client.MobileElement;

import java.util.concurrent.TimeUnit;

import static com.news_app.mobile.utils.helper.Helper.findElementById;

public class LoginPageFactory {

    private static LoginPageFactory loginPageFactory;

    private MobileElement lockIcon;
    private MobileElement emailInputField;
    private MobileElement passwordInputField;
    private MobileElement loginButton;
    private MobileElement createAccountLinkedText;

    public static LoginPageFactory getInstance() {
        if (loginPageFactory == null) {
            loginPageFactory = new LoginPageFactory();
        }
        return loginPageFactory;
    }


    public LoginPageFactory() {
        lockIcon = findElementById("com.example.anush.demo_news:id/imgView_logo");
        emailInputField = findElementById("com.example.anush.demo_news:id/emailText");
        passwordInputField = findElementById("com.example.anush.demo_news:id/passwordText");
        loginButton = findElementById("com.example.anush.demo_news:id/buttonLogin");
        createAccountLinkedText = findElementById("com.example.anush.demo_news:id/buttonRegister");
    }

    public void typeEmail(String email) {
        emailInputField.setValue(email);
        Constants.driver.hideKeyboard();
    }

    public void typePassword(String password) {
        passwordInputField.setValue(password);
        Constants.driver.hideKeyboard();
    }

    public void clickOnLoginButton() {
        loginButton.click();
        WaitHelpers.waitForElementDisapear(loginButton, 5000);
    }

    public MobileElement getLockIcon() {
        return lockIcon;
    }

    public MobileElement getEmailInputField() {
        return emailInputField;
    }

    public MobileElement getPasswordInputField() {
        return passwordInputField;
    }

    public MobileElement getLoginButton() {
        return loginButton;
    }

    public MobileElement getCreateAccountLinkedText() {
        return createAccountLinkedText;
    }

}
