package org.android.androidEcommerceApp.testCases;

import org.android.androidEcommerceApp.util.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class FillFormTestCase extends BaseTest {

	@Test
	public void fillForm() {
		String country = "Spain";
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + country + "\"))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + country + "\"]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Kunal Chavan");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.className("android.widget.Button")).click();
	}

}
