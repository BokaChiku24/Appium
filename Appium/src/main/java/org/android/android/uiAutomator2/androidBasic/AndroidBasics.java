package org.android.android.uiAutomator2.androidBasic;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AndroidBasics {

	@Test
	public void appiumTest() throws MalformedURLException, URISyntaxException {
		// Code to start the appium server
		// AndroidDriver
		// Appium Code -> Appium Server -> Mobile
		// First start the Appium server
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 3a XL");
		options.setApp(System.getProperty("user.dir") + "/src/main/resources/ApiDemos-debug.apk");
		AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
		// Actual Automation
		driver.quit();
		// Stop the appium server
	}

}
