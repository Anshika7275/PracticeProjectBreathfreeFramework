// ===============================
// OnboardingPage.java
// ===============================

package pageObjects;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.BaseClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class OnboardingPage extends BaseClass {

	WebDriverWait wait;

	public OnboardingPage(AndroidDriver driver) {

		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	// =========================
	// NOTIFICATION POPUP
	// =========================

	public void handleNotificationPopup() {

		try {

			Thread.sleep(2000);

			if (driver.findElements(AppiumBy.xpath("//android.widget.Button[@text='ALLOW']")).size() > 0) {

				driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='ALLOW']")).click();

				System.out.println("Notification popup handled");
			}

		} catch (Exception e) {

			System.out.println("Notification popup not displayed");
		}
	}

	// =========================
	// GOOGLE POPUP
	// =========================

	public void handleGooglePopup() {

		try {

			WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));

			WebElement cancelBtn = shortWait.until(ExpectedConditions
					.elementToBeClickable(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Cancel']")));

			cancelBtn.click();

			System.out.println("Google popup closed");

		} catch (Exception e) {

			System.out.println("Google popup not displayed");
		}
	}

	// =========================
	// LOGIN
	// =========================

	public void enterMobileNumber(String mobile) {

		WebElement mobileField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.EditText")));

		mobileField.click();
		mobileField.clear();
		mobileField.sendKeys(mobile);

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Continue']")).click();

		System.out.println("Mobile number entered");
	}

	public void enterOTP(String otp) throws Exception {

		Thread.sleep(3000);

		WebElement otpField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.EditText")));

		otpField.sendKeys(otp);

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Verify']")).click();

		System.out.println("OTP verified");
	}

	// =========================
	// LANGUAGE
	// =========================

	public void selectLanguage() throws Exception {

		Thread.sleep(5000);

		WebElement english = wait
				.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("English, English")));

		english.click();

		Thread.sleep(3000);

		WebElement nextCTA = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Next")));

		safeClick(nextCTA);

		System.out.println("Language selected");
	}

	// =========================
	// MYSELF
	// =========================

	public void selectMyself() throws Exception {

		Thread.sleep(4000);

		WebElement myself = wait
				.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Myself")));

		safeClick(myself);

		System.out.println("Myself selected");
	}

	// =========================
	// BASIC DETAILS
	// =========================

	public void enterBasicDetails() throws Exception {

		Thread.sleep(3000);

		driver.findElement(AppiumBy.xpath("//android.widget.EditText")).sendKeys("Testing");

		// Gender
		driver.findElement(
				AppiumBy.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]")).click();

		// DOB
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='DD']")).sendKeys("11");

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='MM']")).sendKeys("12");

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='YYYY']")).sendKeys("2000");

		driver.hideKeyboard();

		Thread.sleep(2000);

		scrollDown();

		// Height
		driver.findElement(AppiumBy.xpath("(//android.widget.EditText[@text=\"0\"])[1]")).sendKeys("5");
		driver.findElement(AppiumBy.xpath("(//android.widget.EditText[@text=\"0\"])[2]")).click();
		driver.findElement(AppiumBy.xpath("(//android.widget.EditText[@text=\"0\"])[2]")).sendKeys("60");

		driver.hideKeyboard();

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Next']")).click();

		System.out.println("Basic details entered");
	}

	// =========================
	// COHORT
	// =========================

	public void selectCohort() throws Exception {

		Thread.sleep(3000);

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Asthma']")).click();

		driver.findElement(AppiumBy.accessibilityId("Next")).click();

		System.out.println("Cohort selected");
	}

	// =========================
	// SYMPTOMS
	// =========================

	public void selectSymptoms() throws Exception {

		Thread.sleep(3000);

		driver.findElement(AppiumBy.xpath(
				"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]"))
				.click();

		driver.findElement(AppiumBy.xpath(
				"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]"))
				.click();

		driver.findElement(AppiumBy.accessibilityId("Next")).click();

		System.out.println("Symptoms selected");
	}

	// =========================
	// CONDITIONS
	// =========================

	public void selectConditions() throws Exception {

		Thread.sleep(3000);

		// Stable scroll
		scrollDown();

		Thread.sleep(3000);

		// Use UIAutomator instead of XPath
		WebElement noneOption = wait.until(
				ExpectedConditions.visibilityOfElementLocated(
						AppiumBy.androidUIAutomator(
								"new UiSelector().textContains(\"None\")")));

		safeClick(noneOption);

		Thread.sleep(2000);

		WebElement nextBtn = wait.until(
				ExpectedConditions.elementToBeClickable(
						AppiumBy.accessibilityId("Next")));

		safeClick(nextBtn);

		System.out.println("Conditions selected");
	}

	// =========================
	// INHALER
	// =========================

	public void selectNoInhaler() throws Exception {

		Thread.sleep(4000);

		WebElement noInhaler = wait.until(ExpectedConditions.visibilityOfElementLocated(
				AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"No, I dont use any Inhaler\"]")));

		safeClick(noInhaler);

		Thread.sleep(2000);

		WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Next")));

		safeClick(nextBtn);

		System.out.println("No inhaler selected");
	}

	// =========================
	// CONTINUE CTA
	// =========================

	public void clickContinue() throws Exception {

		Thread.sleep(6000);

		WebElement continueBtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.view.View")));

		safeClick(continueBtn);

		System.out.println("Onboarding completed successfully");
	}

	// =========================
	// SAFE CLICK
	// =========================

	public void safeClick(WebElement element) {

		try {

			wait.until(ExpectedConditions.elementToBeClickable(element));

			element.click();

		} catch (Exception e) {

			((JavascriptExecutor) driver).executeScript("mobile: clickGesture",
					Map.of("elementId", ((RemoteWebElement) element).getId()));
		}
	}

	// =========================
	// SCROLL
	// =========================

	public void scrollDown() {

		try {

			((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
					Map.of("left", 100, "top", 300, "width", 500, "height", 1000, "direction", "down", "percent", 0.7));

			Thread.sleep(2000);

		} catch (Exception e) {

			System.out.println("Scroll failed");
		}
	}

	public void hideKeyboardSafe() {

		try {

			driver.hideKeyboard();
			System.out.println("Keyboard hidden");

		} catch (Exception e) {

			System.out.println("Keyboard already hidden or not available");
		}
	}
}