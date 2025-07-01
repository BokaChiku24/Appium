package org.android.uiAutomator2.androidBasic;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumLocators {

	@Test
	public void appiumTest() throws MalformedURLException, URISyntaxException {
		AppiumDriverLocalService service = new AppiumServiceBuilder()
				.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();

		service.start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 3a XL");
		options.setApp(System.getProperty("user.dir") + "/src/main/resources/ApiDemos-debug.apk");
		AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.quit();
		service.stop();
	}

}
