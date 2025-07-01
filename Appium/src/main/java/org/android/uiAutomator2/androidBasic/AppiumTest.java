package org.android.uiAutomator2.androidBasic;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AppiumTest extends BaseTest {

	@Test
	public void androidTest() {
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
	}

}
