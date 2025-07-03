package org.android.androidEcommerceApp.testCases;

import java.time.Duration;
import java.util.List;

import org.android.androidEcommerceApp.util.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTestCase extends BaseTest {
	String actualProduct = null;
	String productAmount = null;

	@Test
	public void cartPageTestCase() {
		String country = "Argentina";
		String productName = "Jordan 6 Rings";
		driver.findElement(By.id("android:id/text1")).click();
		scrollToElement(country);
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + country + "\"]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Kunal Chavan");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.className("android.widget.Button")).click();
		scrollToElement(productName);
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

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(
				driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

		String cartProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(cartProduct, productName, "The incorrect product added into the cart");
	}
}
