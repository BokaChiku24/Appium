package org.android.uiAutomator2.androidGestures;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ScrollGesture extends BaseTest {

	@Test
	public void scrollGesture() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		// Scroll to click on the mobile element

		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
	}

}
