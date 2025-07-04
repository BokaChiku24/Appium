package org.iOS.alreadyInstallAppInSimulator;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class SwipePhotoTest extends IOSBaseTest {

	@Test
	public void swipeDemo() {
		// In iOS identify app by using - Bundle ID
		// We can get Bundle ID with help of the developer
		launchApp("com.apple.mobileslideshow");
		driver.findElement(AppiumBy.iOSNsPredicateString("label == 'All Photos' ")).click();
		List<WebElement> allPhotos = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"));
		int totalPhoto = allPhotos.size();
		System.out.println("Total Photos count: " + totalPhoto);
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeCell[1]")).click();
		for (int i = 0; i < totalPhoto; i++) {
			System.out.println(driver.findElement(By.xpath("//XCUIElementTypeNavigationBar")).getAttribute("name"));
			swipeApp("left");
		}
		driver.navigate().back();
		// Clean Up Test Case By This is important because when we open the app then app perform test without fail
		driver.findElement(AppiumBy.accessibilityId("Album")).click();
	}

}
