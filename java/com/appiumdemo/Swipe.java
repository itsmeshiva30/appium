package com.appiumdemo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Swipe {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

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

		URL url = URI.create("http://127.0.0.1:4723/").toURL();
		AndroidDriver driver = new AndroidDriver(url, capabilities);

		Thread.sleep(2000);

		System.out.println("Application Started");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement viewsOption = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")));
		viewsOption.click();

		Dimension size = driver.manage().window().getSize();

		int startX = size.getWidth() / 2;
		int startY = size.getHeight() / 2;

		int endX = startX;
		int endY = (int) (size.getHeight() * 0.25);

		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

		Sequence sequence = new Sequence(finger1, 1)
				.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
				.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger1, Duration.ofMillis(200)))
				.addAction(
						finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
				.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(Collections.singletonList(sequence));

		Thread.sleep(2000);
		driver.quit();

	}

}
