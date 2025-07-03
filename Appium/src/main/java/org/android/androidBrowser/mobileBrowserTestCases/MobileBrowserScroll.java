package org.android.androidBrowser.mobileBrowserTestCases;

import org.android.androidBrowser.utils.MobileBrowserBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserScroll extends MobileBrowserBaseTest {

	@Test
	public void scrollTest() {
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.className("navbar-toggler-icon")).click();
		driver.findElement(By.xpath("(//a[@class='nav-link'])[1]")).click();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,100)", "");
		String name = driver.findElement(By.xpath("//div/ul/div[3]/li/div/div/a")).getText();
		Assert.assertEquals(name, "Devops");
	}

}
