package org.android.androidBrowser.mobileBrowserTestCases;

import org.android.androidEcommerceApp.util.MobileBrowserBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class MobileBrowserTest extends MobileBrowserBaseTest {

	@Test
	public void mobileTest() {
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("New York");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

}
