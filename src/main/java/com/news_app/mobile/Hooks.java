package com.news_app.mobile;

import com.news_app.mobile.constants.Constants;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
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
        capabilities.setCapability("noReset", false);
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

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result, Method method) {
        if (result.getStatus() == ITestResult.FAILURE) {
            File screenShotFile = ((TakesScreenshot) Constants.driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenShotFile, new File(Constants.SCREENSHOTS_PATH + method.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void quitDriver() {
        Constants.driver.closeApp();
        Constants.driver.quit();
    }

    private void waitForProgress() {
        MobileElement progressBar = findElementById("com.example.anush.demo_news:id/loading_progress");
        waitForElement(progressBar, 3);
        waitForElementDisapear(progressBar, 3);
    }
}
