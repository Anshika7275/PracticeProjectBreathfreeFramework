// ===============================
// BaseClass2.java
// ===============================

package baseClass;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;

public class BaseClass {

	public AndroidDriver driver;

	@BeforeClass
	public void setup() throws Exception {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Android Device");
		caps.setCapability("platformName", "Android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("noReset", true);
		caps.setCapability("appWaitActivity", "*");
		caps.setCapability("autoGrantPermissions", false);
		caps.setCapability("ignoreHiddenApiPolicyError", true);
		caps.setCapability("disableWindowAnimation", true);
		caps.setCapability("uiautomator2ServerInstallTimeout", 120000);
		caps.setCapability("uiautomator2ServerLaunchTimeout", 120000);
		caps.setCapability("adbExecTimeout", 120000);
		caps.setCapability("newCommandTimeout", 300);

		URL u = new URL("http://127.0.0.1:4723");

		driver = new AndroidDriver(u, caps);
		driver.activateApp("breathefree.lung.health.asthma.breathing");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		System.out.println("App launched successfully");
	}

	@AfterClass
	public void tearDown() {

		if (driver != null) {
			// driver.quit();
		}
	}
}