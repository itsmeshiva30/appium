		package com.appiumdemo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class api {
	private static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appium:automationName", "UIAutomator2");
		capabilities.setCapability("appium:deviceName", "Medium Phone API 30");
		capabilities.setCapability("appium:platformVersion", "11");
		capabilities.setCapability("appium:appPackage", "io.appium.android.apis");
		capabilities.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");
		capabilities.setCapability("appium:disableWindowAnimation", true);
		capabilities.setCapability("appium:noReset", true);
		capabilities.setCapability("appium:dontStopAppOnReset", true);

		URL url = URI.create("http://127.0.0.1:4723/wd/hub").toURL();
		driver = new AndroidDriver(url, capabilities);

		Thread.sleep(3000);
		System.out.println("Application started");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
		String mobelement = "Switches";

		WebElement element = driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""
						+ mobelement + "\"))"));

		Thread.sleep(2000);
		element.click();
		Thread.sleep(2000);
		System.out.println("Element clicked successfully");
	}
}
