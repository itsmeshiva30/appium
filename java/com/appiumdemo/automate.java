package com.appiumdemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class automate {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        // Set up DesiredCapabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        
        // Prefix Appium-specific capabilities with 'appium:'
        capabilities.setCapability("appium:platformName", "Android");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:deviceName", "Medium Phone API 30"); // Ensure this matches the emulator name
        capabilities.setCapability("appium:platformVersion", "11");  // Ensure this matches your emulator's version
       // capabilities.setCapability("appium:browserName", "chrome");
        capabilities.setCapability("appium:appPackage", "com.android.chrome");
        capabilities.setCapability("appium:appActivity", "com.google.android.apps.chrome.Main");
        capabilities.setCapability("appium:noReset", true);  // Keep app data between sessions
        
        // URL for Appium server
        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        // Initialize AndroidDriver
        AndroidDriver driver = new AndroidDriver(url, capabilities);
        
        // Wait for the app to open and be ready
        Thread.sleep(3000);  // It's better to use explicit waits instead of Thread.sleep
        
        System.out.println("Chrome launched");
        
        // Navigate to a URL
       // driver.get("https://www.google.com");
        
        // Wait for the page to load
        Thread.sleep(3000);  // Again, use waits instead of Thread.sleep if possible
        
        System.out.println("Google opened successfully");

        // Close the session
        driver.quit();
    }
}
