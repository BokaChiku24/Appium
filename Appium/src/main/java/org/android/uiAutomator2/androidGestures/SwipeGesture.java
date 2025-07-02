package org.android.uiAutomator2.androidGestures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class SwipeGesture extends BaseTest {

	@Test
	public void swipeGestureTest() {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Photos']")).click();
		WebElement firstImage = driver.findElement(By.xpath(
				"//android.widget.Gallery[@resource-id='io.appium.android.apis:id/gallery']/android.widget.ImageView[1]"));
		Assert.assertEquals(driver.findElement(By.xpath(
				"//android.widget.Gallery[@resource-id='io.appium.android.apis:id/gallery']/android.widget.ImageView[1]"))
				.getAttribute("focusable"), "true");

		// Swipe Code
		swipeAction(firstImage, "left");

		Assert.assertEquals(driver.findElement(By.xpath(
				"//android.widget.Gallery[@resource-id='io.appium.android.apis:id/gallery']/android.widget.ImageView[1]"))
				.getAttribute("focusable"), "false");
	}

}
