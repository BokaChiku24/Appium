package org.android.android.uiAutomator2.androidExtractText;

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

public class BaseTest {

	AppiumDriverLocalService service;
	UiAutomator2Options options;
	AndroidDriver driver;

	@BeforeClass
	public void setup() {
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		options = new UiAutomator2Options();
		options.setDeviceName("Pixel 3a XL");
		options.setApp(System.getProperty("user.dir") + "/src/main/resources/ApiDemos-debug.apk");
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
