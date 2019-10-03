package com.news_app.mobile.pages;

import com.news_app.mobile.constants.Constants;
import com.news_app.mobile.constants.LoginPageConstants;
import io.appium.java_client.MobileElement;

import static com.news_app.mobile.utils.helper.Helper.findElementById;

public class LoginPageFactory {

    private MobileElement lockIcon;
    private MobileElement emailInputField;
    private MobileElement passwordInputField;
    private MobileElement loginButton;
    private MobileElement createAccountLinkedText;

    public LoginPageFactory() {
        lockIcon = findElementById(LoginPageConstants.LOGO_ID);
        emailInputField = findElementById(LoginPageConstants.EMAIL_INPUT_FIELD_ID);
        passwordInputField = findElementById(LoginPageConstants.PASSWORD_INPUT_FIELD_ID);
        loginButton = findElementById(LoginPageConstants.LOGIN_BUTTON_ID);
        createAccountLinkedText = findElementById(LoginPageConstants.CREATE_ACCOUNT_LINKED_TEXT_ID);
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
    }

    public MobileElement getLoginButton() {
        return loginButton;
    }

    public CreateAccountPageFactory clickOnCreateAccountLinkedText() {
        createAccountLinkedText.click();
        return new CreateAccountPageFactory();
    }
}
