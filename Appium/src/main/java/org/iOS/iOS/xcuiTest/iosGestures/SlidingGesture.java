package org.iOS.iOS.xcuiTest.iosGestures;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class SlidingGesture extends IOSBaseTestApp {

	@Test
	public void slideTest() {
		WebElement element = driver
				.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`name == 'AppElem'`]"));
		element.sendKeys("0%");
		Assert.assertEquals(element.getAttribute("value"), "0%");
		System.out.println("Full Slide upto 100%");
		element.sendKeys("1%");
		Assert.assertEquals(element.getAttribute("value"), "100%");

	}

}
