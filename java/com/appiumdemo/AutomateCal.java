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

public class AutomateCal {
    private static AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "UIAutomator2");
        capabilities.setCapability("appium:deviceName", "Medium Phone API 30");
        capabilities.setCapability("appium:platformVersion", "11");
        capabilities.setCapability("appium:appPackage", "com.asus.calculator");
        capabilities.setCapability("appium:appActivity", "com.asus.calculator.Calculator");

        URL url = URI.create("http://127.0.0.1:4723/wd/hub").toURL();
        driver = new AndroidDriver(url, capabilities);
    }

    @Test
    public void testCalculatorFunctionality() throws InterruptedException {
        System.out.println("Installed application");

        driver.findElement(By.id("com.asus.calculator:id/digit1")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.asus.calculator:id/plus")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.asus.calculator:id/digit2")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.asus.calculator:id/equal")).click();
        Thread.sleep(3000);

        System.out.println("Worked application");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
