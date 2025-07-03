package org.android.androidEcommerceApp.testCases;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.android.androidEcommerceApp.util.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class HybridBrowserTestCase extends BaseTest {
	@Test
	public void hybridBrowserTest() {
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

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
		WebElement longPress = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		driver.findElement(By.className("android.widget.CheckBox")).click();
		logPress(longPress);
		WebElement alertHeader = driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle"));
		WebElement alertMessage = driver.findElement(By.id("android:id/message"));
		Assert.assertEquals(alertHeader.getText(), "Terms Of Conditions");
		Assert.assertEquals(alertMessage.getText(),
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");
		driver.findElement(By.id("android:id/button1")).click();

		// Hybrid Apps - Native + Browser Support
		driver.findElement(By.className("android.widget.Button")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<String> contexts = driver.getContextHandles();
		for (String context : contexts) {
			System.out.println(context);
		}

		driver.context("WEBVIEW_com.androidsample.generalstore"); // Switch to browser and need to provide chrome driver
		driver.findElement(By.name("q")).sendKeys("New York");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

		// driver.context("Webview"); Default approach to switch driver to the browser
		// but developer can change the context name so not recommended way.

		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP"); // Switch to native app

	}

}
