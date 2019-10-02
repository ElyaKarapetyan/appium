package com.news_app.mobile;

import com.news_app.mobile.constants.Constants;
import com.news_app.mobile.utils.helper.WaitHelpers;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

import static com.news_app.mobile.utils.helper.Helper.findElementById;
import static com.news_app.mobile.utils.helper.WaitHelpers.waitForElement;
import static com.news_app.mobile.utils.helper.WaitHelpers.waitForElementDisapear;

public class Hooks {

    MobileDriver driver;

    @BeforeClass(alwaysRun = true)
    @Parameters({"platformName", "deviceName", "osVersion", "appPath", "deviceID"})
    public void setUp(String platformName, String deviceName, String osVersion, String appPath, String deviceID) {
        System.setProperty("osVersion", osVersion);
        System.setProperty("deviceName", deviceName);
        System.setProperty("udid", deviceID);
        System.setProperty("platformName", platformName);
        System.setProperty("app", appPath);
    }

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("version", System.getProperty("osVersion"));
        capabilities.setCapability("deviceName",System.getProperty("deviceName"));
        capabilities.setCapability("platformName",System.getProperty("platformName"));
        capabilities.setCapability("udid", System.getProperty("udid"));
        capabilities.setCapability("app", System.getProperty("app"));
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
