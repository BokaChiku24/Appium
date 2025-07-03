package org.android.android.uiAutomator2.androidMiscellaneousActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class LandscapeMode extends BaseTest {
	@Test
	public void landTest() {
		// Rotation of the device from landscape to portrait mode
		// DeviceRotation landScape = new DeviceRotation(0, 90, 0);
		// driver.rotate(landScape);
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		// Syntax of Xpath: //tagName[@attribute='value'] OR //tagName
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();

		// Rotation of the device to landscape mode
		DeviceRotation landScape = new DeviceRotation(0, 0, 90);
		driver.rotate(landScape);

		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		driver.findElement(By.id("android:id/edit")).sendKeys("Kunal WiFi");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

		// Rotation of the device from landscape to portrait mode
		landScape = new DeviceRotation(0, 90, 0);
		driver.rotate(landScape);

	}
}
