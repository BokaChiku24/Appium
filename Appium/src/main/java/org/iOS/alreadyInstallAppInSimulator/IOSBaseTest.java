package org.iOS.alreadyInstallAppInSimulator;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class IOSBaseTest {

	AppiumDriverLocalService service;
	XCUITestOptions options;
	IOSDriver driver;

	@BeforeClass
	public void setup() {
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		options = new XCUITestOptions();
		options.setDeviceName("iPhone 16 Pro Max");
		options.setPlatformName("iOS");
		options.setPlatformVersion("18.5");

		// Appium installs WebDriver Agent in the iOS Apps (Simulator)

		options.setWdaLaunchTimeout(Duration.ofSeconds(30));
		try {
			driver = new IOSDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		} catch (MalformedURLException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public void longPressIOS(WebElement element, int duration) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("element", ((RemoteWebElement) element).getId());
		map.put("duration", duration);
		((JavascriptExecutor) driver).executeScript("mobile: touchAndHold", map);
	}

	public void scollIOS(WebElement element, String direction) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("element", ((RemoteWebElement) element).getId());
		map.put("direction", direction);
		((JavascriptExecutor) driver).executeScript("mobile: scroll", map);
	}

	public void launchApp(String appBundle) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("bundleId", appBundle);
		((JavascriptExecutor) driver).executeScript("mobile: launchApp", params);
	}

	public void swipeApp(String direction) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("direction", direction);
		((JavascriptExecutor) driver).executeScript("mobile: swipe", params);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}
}
