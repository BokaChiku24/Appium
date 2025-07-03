package org.android.androidEcommerceApp.testCases;

import org.android.androidEcommerceApp.util.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ToastMessageTestCase extends BaseTest {

	@Test
	public void toastMessage() {
		String country = "Brazil";
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + country + "\"))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + country + "\"]")).click();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Male']")).click();
		driver.findElement(By.className("android.widget.Button")).click();
		String message = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(message, "Please enter your name");
	}

}
