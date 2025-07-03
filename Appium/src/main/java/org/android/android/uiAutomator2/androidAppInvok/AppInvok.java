package org.android.android.uiAutomator2.androidAppInvok;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

public class AppInvok extends BaseTest {

	// @SuppressWarnings("deprecation")
	@Test
	public void appInvoke() {
		// App Package - Full App with Package and Activities
		// App Activity - Specific APp Activity

		/*
		 * Activity activity = new Activity("io.appium.android.apis",
		 * "io.appium.android.apis.preference.PreferenceDependencies");
		 * driver.startActivity(activity);
		 */
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of("intent",
				"io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
		try {
			Thread.sleep(Duration.ofSeconds(10));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
