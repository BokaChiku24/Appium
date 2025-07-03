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

public class TotalPriceTestCase extends BaseTest {

	@Test
	public void totalPrice() {
		String country = "Argentina";
		driver.findElement(By.id("android:id/text1")).click();
		scrollToElement(country);
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + country + "\"]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Kunal Chavan");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Male']")).click();
		driver.findElement(By.className("android.widget.Button")).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(
				driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

		List<WebElement> productPrices = driver.findElements(
				By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice']"));
		double priceTotal = 0;
		for (int i = 0; i < productPrices.size(); i++) {
			priceTotal = priceTotal + Double.parseDouble(productPrices.get(i).getText().replace("$", ""));
		}

		double productFinal = Double.parseDouble(driver
				.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().replace("$", ""));
		Assert.assertEquals(productFinal, priceTotal);
	}

}
