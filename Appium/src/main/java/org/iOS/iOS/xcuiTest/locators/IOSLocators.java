package org.iOS.iOS.xcuiTest.locators;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSLocators extends IOSBaseTest {

	@Test()
	public void iOSBasic() {
		// Xpath, className, IOS, iosClassChain, IOSPredicateString, accessiblityID, ID
		driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
		
		// Xpath - XML Language - it is slow in the iOS 
		// iosClassChain - It is very similar to the Xpath but comparatively fast. 
		// driver.findElement(By.xpath("//XCUIElementTypeStaticText[text()='Text Entry']")).click(); - Slow
		
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label =='Text Entry'`]")).click(); // Faster
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).sendKeys("Kunal Chavan");
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'OK'`]")).click();
	}

}
