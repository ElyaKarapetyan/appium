package com.news_app.mobile.utils.helper;

import com.news_app.mobile.constants.Constants;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.NoSuchElementException;
import java.sql.Timestamp;
import static java.lang.Thread.sleep;

public class Helper {

    public static MobileElement findElementById(String id) {
        return findElementById(id, 3000);
    }

    public static MobileElement findElementById(String id, int timeout) {
        MobileElement mobileElement = null;
        long startTime, currentTime;
        startTime = currentTime = System.currentTimeMillis();
        while (currentTime - startTime < timeout) {
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

    public static String generateEmail() {
        return String.format("test_%s@gmail.com", getCurrentTimestamp());
    }

    public static String getCurrentTimestamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return String.valueOf(timestamp.getTime());
    }
}
