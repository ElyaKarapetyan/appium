package com.news_app.mobile.pages;

import com.news_app.mobile.constants.Constants;
import com.news_app.mobile.utils.helper.WaitHelpers;
import io.appium.java_client.MobileElement;

import static com.news_app.mobile.utils.helper.Helper.findElementById;

public class CreateAccountPageFactory {

    private static CreateAccountPageFactory createAccountPageFactory;

    private MobileElement lockIcon;
    private MobileElement emailInputField;
    private MobileElement passwordInputField;
    private MobileElement createAccountButton;
    private MobileElement loginLinkedText;

    public CreateAccountPageFactory() {
        lockIcon = findElementById("com.example.anush.demo_news:id/imgView_logo");
        emailInputField = findElementById("com.example.anush.demo_news:id/emailText");
        passwordInputField = findElementById("com.example.anush.demo_news:id/passwordText");
        createAccountButton = findElementById("com.example.anush.demo_news:id/buttonRegister");
        loginLinkedText = findElementById("com.example.anush.demo_news:id/buttonLogin");
    }

    public void typeEmail(String email) {
        emailInputField.setValue(email);
        Constants.driver.hideKeyboard();
    }

    public void typePassword(String password) {
        passwordInputField.setValue(password);
        Constants.driver.hideKeyboard();
    }

    public void clickOnTheCreateAccountButton() {
        createAccountButton.click();
    }

    public MobileElement clickOnTheLoginLinkedText() {
        loginLinkedText.click();
        return findElementById("");
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

    public MobileElement getCreateAccountButton() {
        return createAccountButton;
    }

    public MobileElement getLoginLinkedText() {
        return loginLinkedText;
    }
}
