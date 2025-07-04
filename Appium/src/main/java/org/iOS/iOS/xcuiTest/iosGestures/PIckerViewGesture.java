package org.iOS.iOS.xcuiTest.iosGestures;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class PIckerViewGesture extends IOSBaseTest {

	@Test
	public void scrollTest() {
		driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
		driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("30");
		driver.findElement(AppiumBy.accessibilityId("Green color component value")).sendKeys("300");
		driver.findElement(AppiumBy.accessibilityId("Blue color component value")).sendKeys("105");
		String number = driver.findElement(AppiumBy.accessibilityId("Blue color component value")).getText();
		Assert.assertEquals(number, "105");
	}

}
