package org.iOS.iOS.xcuiTest.iosGestures;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ScrollGesture extends IOSBaseTest {

	@Test
	public void scrollTest() {
		WebElement element = driver.findElement(AppiumBy.accessibilityId("Web View"));
		scollIOS(element, "down");
		element.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(
				driver.findElement(AppiumBy.accessibilityId("This is HTML content inside a WKWebView.")), "name",
				"This is HTML content inside a WKWebView."));
		String message = driver.findElement(AppiumBy.accessibilityId("This is HTML content inside a WKWebView."))
				.getAttribute("name");
		Assert.assertEquals(message, "This is HTML content inside a WKWebView.");
		driver.findElement(AppiumBy.className("XCUIElementTypeButton")).click();
	}

}
