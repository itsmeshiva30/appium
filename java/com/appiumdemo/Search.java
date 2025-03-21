package com.appiumdemo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Search {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("appium:automationName", "UIAutomator2");
		cap.setCapability("appium:deviceName", "Medium Phone API 30");
		cap.setCapability("appium:platformVersion", "11");
		cap.setCapability("appium:appPackage", "com.google.android.googlequicksearchbox");
		cap.setCapability("appium:appActivity", "com.google.android.googlequicksearchbox.SearchActivity");
		cap.setCapability("appium:disableWindowAnimation", true);
		cap.setCapability("appium:noReset", true);
		cap.setCapability("appium:dontStopAppOnReset", true);

		
		URL url = URI.create("http://127.0.0.1:4723/wd/hub").toURL();
		AndroidDriver	driver = new AndroidDriver(url, cap);
		Thread.sleep(3000);
		System.out.println("started");
		driver.findElement(By.id("com.google.android.googlequicksearchbox:id/googleapp_hint_text")).click();
		Thread.sleep(3000);
		System.out.println("started");
		driver.findElement(By.className("android.widget.EditText")).sendKeys("flipkart");
		Thread.sleep(3000);
		System.out.println("started");
		driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.google.android.googlequicksearchbox:id/googleapp_start_icon\"])[1]")).click();
//		driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Search\"]")).click();
	Thread.sleep(3000);
	System.out.println("started");
//	driver.findElement(By.id("com.google.android.googlequicksearchbox:id/googleapp_search_box")).click();
//	Thread.sleep(3000);
	
	}

}
