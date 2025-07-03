package org.android.android.uiAutomator2.appiumLocators;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AppiumLocators extends BaseTest {

	@Test
	public void firstTestCase() {
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		// Syntax of Xpath: //tagName[@attribute='value'] OR //tagName
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
	}

}
