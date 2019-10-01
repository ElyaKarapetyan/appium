package com.news_app.mobile;

import com.news_app.mobile.constants.Constants;
import com.news_app.mobile.utils.helper.WaitHelpers;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import static com.news_app.mobile.utils.helper.Helper.findElementById;
import static com.news_app.mobile.utils.helper.WaitHelpers.waitForElement;
import static com.news_app.mobile.utils.helper.WaitHelpers.waitForElementDisapear;

public class Hooks {

    MobileDriver driver;

    @BeforeClass
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("version", "9.0");
        capabilities.setCapability("deviceName","Emulator");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage", "com.example.anush.demo_news");
        capabilities.setCapability("appActivity","com.example.anush.demo_news.activities.MainActivity");
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            Constants.driver = driver;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        waitForProgress();
    }

    private void waitForProgress() {
        MobileElement progressBar = findElementById("com.example.anush.demo_news:id/loading_progress");
        waitForElement(progressBar, 3);
        waitForElementDisapear(progressBar, 3);
    }
}
