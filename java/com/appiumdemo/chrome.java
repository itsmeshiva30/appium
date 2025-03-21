package com.appiumdemo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;

public class chrome {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("platformName","Android");
		cap.setCapability("appium:deviceName","Medium Phone API 30");
		cap.setCapability("appium:automationName","UIAutomator2");
		cap.setCapability("appium:platformVersion","11");
		//cap.setCapability("appium:browserName","chrome");
		//cap.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
		cap.setCapability("appium:appPackage", "com.google.android.youtube");
		cap.setCapability("appium:appActivity", "com.google.android.youtube.app.honeycomb.Shell$HomeActivity");
		URL url=URI.create("http://127.0.0.1:4723/wd/hub").toURL();
		AndroidDriver driver=new AndroidDriver(url,cap);
		Thread.sleep(5000);
		System.out.println("working");
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Search YouTube\"]")).click();
		Thread.sleep(5000);
		System.out.println("working");
		driver.findElement(By.className("android.widget.EditText")).sendKeys("appium");
		Thread.sleep(5000);
		System.out.println("working");
		driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.google.android.youtube:id/search_type_icon\"])[7]")).click();
		Thread.sleep(5000);
		System.out.println("working");
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(5000);
		System.out.println("working");
	}

}
