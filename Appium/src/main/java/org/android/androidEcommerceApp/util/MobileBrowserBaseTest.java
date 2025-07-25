package org.android.androidEcommerceApp.util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MobileBrowserBaseTest {
	AppiumDriverLocalService service;
	UiAutomator2Options options;
	public AndroidDriver driver;

	@BeforeClass
	public void setup() {
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		options = new UiAutomator2Options();
		options.setChromedriverExecutable("/Users/kunalchavan/Documents/chromedriver");
		options.setDeviceName("Pixel 8");
		options.setCapability("browserName", "Chrome");
		try {
			driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		} catch (MalformedURLException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
