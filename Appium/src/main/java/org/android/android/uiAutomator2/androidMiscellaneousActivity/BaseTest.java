package org.android.android.uiAutomator2.androidMiscellaneousActivity;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	AppiumDriverLocalService service;
	UiAutomator2Options options;
	AndroidDriver driver;

	@BeforeClass
	public void setUp() {
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

	public void logPress(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 5000));
	}

	public void scrolltoEndAction() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 200, "top", 200, "width", 200, "height", 200, "direction", "down", "percent", 5.0));
		} while (canScrollMore);
	}

	public void swipeAction(WebElement element, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) element).getId(), "direction", direction, "percent", 0.75));
	}

	public void dragDropAction(WebElement element, int x, int y) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "endX", x, "endY", y));

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
