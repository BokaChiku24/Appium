package org.android.androidEcommerceApp.testCases;

import java.util.List;

import org.android.androidEcommerceApp.util.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductTestCase extends BaseTest {

	String actualProduct = null;
	String productAmount = null;

	@Test
	public void searchProduct() {
		String country = "Argentina";
		String productName = "Jordan 6 Rings";
		driver.findElement(By.id("android:id/text1")).click();
		scrollToElement(country);
		// driver.findElement(AppiumBy
		// .androidUIAutomator("new UiScrollable(new
		// UiSelector()).scrollIntoView(text(\"" + country + "\"))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + country + "\"]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Kunal Chavan");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.className("android.widget.Button")).click();
		// driver.findElement(AppiumBy.androidUIAutomator(
		// "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + productName +
		// "\"))"));
		scrollToElement(productName);
		// int productCount =
		// driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		List<WebElement> list = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
		for (int i = 0; i < list.size(); i++) {
			{
				if (list.get(i).getText().equalsIgnoreCase(productName)) {
					actualProduct = driver.findElements(By.xpath(
							"//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName']"))
							.get(i).getText();
					productAmount = driver.findElements(By.xpath(
							"//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice']"))
							.get(i).getText();
					driver.findElement(By.xpath(
							"(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart'])[\""
									+ i + "\"]"))
							.click();
				}
			}
		}

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Assert.assertEquals(actualProduct, productName);
		Assert.assertEquals(productAmount, "$165.0");
	}

}
