package com.news_app.mobile.utils.helper;

import io.appium.java_client.MobileElement;

import static java.lang.Thread.sleep;

public class WaitHelpers {

    public static boolean waitForElement(MobileElement element, int timeout) {
        return element != null && waitForElementAction(element.isDisplayed(), timeout);
    }

    public static boolean waitForElementDisapear(MobileElement element, int timeout) {
        return element != null && waitForElementAction(!element.isDisplayed(), timeout);
    }

    public static boolean waitForElementAction(boolean condition, int timeout) {
        long startTime, currentTime;
        startTime = currentTime = System.currentTimeMillis();
        while (currentTime - startTime < timeout * 1000) {
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (condition) {
                return true;
            }
            currentTime = System.currentTimeMillis();
        }
        return false;
    }
}
