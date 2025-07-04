package org.iOS.iOS.xcuiTest.iosGestures;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class LongPressGestures extends IOSBaseTest {

	@Test
	public void gestureTest() {
		driver.findElement(AppiumBy.accessibilityId("Steppers")).click();
		WebElement element = driver
				.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label=='Increment'`][3]"));
		longPressIOS(element, 10);
	}
}
