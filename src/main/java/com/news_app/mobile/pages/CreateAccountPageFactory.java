package com.news_app.mobile.pages;

import com.news_app.mobile.constants.Constants;
import com.news_app.mobile.constants.CreateAccountPageConstants;
import io.appium.java_client.MobileElement;

import static com.news_app.mobile.utils.helper.Helper.findElementById;

public class CreateAccountPageFactory {

    private MobileElement lockIcon;
    private MobileElement emailInputField;
    private MobileElement passwordInputField;
    private MobileElement createAccountButton;
    private MobileElement loginLinkedText;

    public CreateAccountPageFactory() {
        lockIcon = findElementById(CreateAccountPageConstants.LOGO_ID);
        emailInputField = findElementById(CreateAccountPageConstants.EMAIL_INPUT_FIELD_ID);
        passwordInputField = findElementById(CreateAccountPageConstants.PASSWORD_INPUT_FIELD_ID);
        createAccountButton = findElementById(CreateAccountPageConstants.CREATE_ACCOUNT_BUTTON_ID);
        loginLinkedText = findElementById(CreateAccountPageConstants.LOGIN_LINKED_TEXT_ID);
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

    public MobileElement getCreateAccountButton() {
        return createAccountButton;
    }
}
