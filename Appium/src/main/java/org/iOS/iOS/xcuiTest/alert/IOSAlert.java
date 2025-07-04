package org.iOS.iOS.xcuiTest.alert;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSAlert extends IOSBaseTest {

	@Test()
	public void iOSBasic() {
		// Xpath, className, IOS, iosClassChain, IOSPredicateString, accessiblityID, ID
		driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();

		// Xpath - XML Language - it is slow in the iOS
		// iosClassChain - It is very similar to the Xpath but comparatively fast.
		// driver.findElement(By.xpath("//XCUIElementTypeStaticText[text()='Text
		// Entry']")).click(); - Slow

		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label =='Text Entry'`]")).click(); // Faster
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).sendKeys("Kunal Chavan");
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'OK'`]")).click();
		/*
		 * iOSNsPredicateString: 
		 * 
		   driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Confirm / Cancel'")).click();
		   
		   Regular Expression iOSNsPredicateString:
		
		driver.findElement(
				AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value ENDSWITH[c] 'Cancel' "))
				.click();
		*/
		 driver.findElement(
					AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm' "))
					.click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.attributeContains(driver.findElement(AppiumBy.accessibilityId("A message should be a short, complete sentence.")), "name", "A message should be a short, complete sentence."));
		String alertMessage = driver.findElement(AppiumBy.accessibilityId("A message should be a short, complete sentence.")).getText();
		Assert.assertEquals(alertMessage, "A message should be a short, complete sentence.");
		driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Confirm'")).click();
	}

}
