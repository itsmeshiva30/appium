package com.appiumdemo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class mobile {
    private static AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:platformName", "Android");
        capabilities.setCapability("appium:automationName", "UIAutomator2");
        capabilities.setCapability("appium:deviceName", "Medium Phone API 30");
        capabilities.setCapability("appium:platformVersion", "11");
        capabilities.setCapability("appium:appPackage", "com.android.dialer");
        capabilities.setCapability("appium:appActivity", "com.android.dialer.main.impl.MainActivity");
        capabilities.setCapability("appium:noReset", true);

        URL url = URI.create("http://127.0.0.1:4723/wd/hub").toURL();
        driver = new AndroidDriver(url, capabilities);
    }

    @Test
    public void testDialerFunctionality() throws InterruptedException {
        System.out.println("Installed application");
        
        driver.findElement(By.id("com.android.dialer:id/fab")).click();
        Thread.sleep(3000);
        
        for (int i = 0; i < 10; i++) {
            driver.findElement(By.id("com.android.dialer:id/nine")).click();
            Thread.sleep(3000);
        }
        
        driver.findElement(By.id("com.android.dialer:id/dialpad_floating_action_button")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.android.dialer:id/incall_end_call")).click();
        Thread.sleep(3000);
        
        System.out.println("Completed");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
