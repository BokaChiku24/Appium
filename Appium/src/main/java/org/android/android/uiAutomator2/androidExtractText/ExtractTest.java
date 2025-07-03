package org.android.android.uiAutomator2.androidExtractText;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ExtractTest extends BaseTest {

	@Test
	public void extractText() {
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		// Syntax of Xpath: //tagName[@attribute='value'] OR //tagName
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		System.out.println(driver.findElement(AppiumBy.className("android.widget.TextView")).getText());
		Assert.assertEquals(driver.findElement(AppiumBy.className("android.widget.TextView")).getText(), "WiFi settings");
	}

}
