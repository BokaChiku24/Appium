package org.android.android.uiAutomator2.androidGestures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class LongPressGesture extends BaseTest {

	@Test
	public void gesturesTest() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Custom Adapter']")).click();

		// appium github gestures
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		logPress(element);

		String text = driver.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']")).getText();
		Assert.assertEquals(text, "Sample menu");
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
	}

}
