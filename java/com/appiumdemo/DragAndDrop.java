package com.appiumdemo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragAndDrop {

	private AndroidDriver driver;
	private WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException {
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

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		System.out.println("Application started");
	}

	@Test
	public void testDragAndDrop() {

		WebElement viewsOption = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")));
		viewsOption.click();

		WebElement dragAndDropOption = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]")));
		dragAndDropOption.click();

		WebElement source = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_1\"]")));
		WebElement target = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_3\"]")));

		TouchAction action = new TouchAction(driver);
		action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(source)))
				.moveTo(ElementOption.element(target)).release().perform();

		System.out.println("Drag and drop performed successfully");
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			System.out.println("Driver closed");
		}
	}
}
