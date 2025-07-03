package org.android.android.uiAutomator2.androidDragAndDrop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class DragAndDrop extends BaseTest {

	@Test
	public void dragAndDropTest() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		int x = driver.findElement(By.xpath("//android.view.View[@resource-id='io.appium.android.apis:id/drag_dot_2']"))
				.getRect().getX();
		int y = driver.findElement(By.xpath("//android.view.View[@resource-id='io.appium.android.apis:id/drag_dot_2']"))
				.getRect().getY();

		// OR in the appium inspector select the option Tap/Swipe By Coordinate
		// X = 831, Y= 788

		// dragDropAction(source, 727, 3147);
		dragDropAction(source, 650, 0);
		Assert.assertEquals(driver.findElement(By.xpath("//android.widget.TextView[@text='Dragging...']")).getText(),
				"Dragging...");
		WebElement ass = driver.findElement(By.xpath("//android.widget.TextView[@text='No drop']"));
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(ass));
		String text = ass.getText();
		Assert.assertEquals(text, "No drop");
		dragDropAction(source, x, y);
		Assert.assertEquals(driver.findElement(By.xpath("//android.widget.TextView[@text='Dropped!']")).getText(),
				"Dropped!");

	}

}
