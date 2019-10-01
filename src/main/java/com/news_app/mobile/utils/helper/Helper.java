package com.news_app.mobile.utils.helper;

import com.news_app.mobile.constants.Constants;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.NoSuchElementException;

import static java.lang.Thread.sleep;

public class Helper {

    public static MobileElement findElementById(String id) {
        MobileElement mobileElement = null;
        final int TIMEOUT = 3000;
        long startTime, currentTime;
        startTime = currentTime = System.currentTimeMillis();
        while (currentTime - startTime < TIMEOUT) {
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                mobileElement = (MobileElement) Constants.driver.findElementById(id);
                return mobileElement;
            } catch (NoSuchElementException ignore) {
            }
            currentTime = System.currentTimeMillis();
        }
        return mobileElement;
    }
}
