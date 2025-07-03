package org.android.android.uiAutomator2.androidPopup;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AppiumPopup extends BaseTest {
	@Test
	public void popupTestCase() {
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		// Syntax of Xpath: //tagName[@attribute='value'] OR //tagName
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		driver.findElement(By.id("android:id/edit")).sendKeys("Kunal WiFi");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
	}
}
