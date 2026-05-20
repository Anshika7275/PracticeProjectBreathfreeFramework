package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.BaseClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ProgressPage extends BaseClass{

	WebDriverWait wait;

	// =========================================
	// Constructor
	// =========================================

	public ProgressPage(AndroidDriver driver) {

		this.driver = driver;

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	// =========================================
	// OPEN PROGRESS TAB
	// =========================================

	public void openProgressTab() {

		try {

			WebElement progressTab = wait
					.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Progress")));

			progressTab.click();

			System.out.println("Clicked progress tab");

		} catch (Exception e) {

			System.out.println("Already on Progress tab");
		}
	}

	// =========================================
	// HANDLE MORNING TAB
	// =========================================

	public void handleMorningTab() {

		try {

			WebElement morningTab = wait
					.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("MORNING")));

			WebElement eveningTab = driver.findElement(AppiumBy.accessibilityId("EVENING"));

			String eveningSelected = eveningTab.getAttribute("selected");

			if (eveningSelected != null && eveningSelected.equalsIgnoreCase("true")) {

				morningTab.click();

				System.out.println("Switched to Morning tab");

			} else {

				System.out.println("Already on Morning tab");
			}

		} catch (Exception e) {

			System.out.println("Unable to handle Morning tab");
		}
	}

	// =========================================
	// HANDLE PFR POPUP
	// =========================================

	public void handlePFRPopup() {

		try {

			WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));

			WebElement pfrPopup = shortWait.until(ExpectedConditions.visibilityOfElementLocated(
					AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Peak Flow Rate\")")));

			if (pfrPopup.isDisplayed()) {

				System.out.println("PFR popup displayed");

				WebElement noBtn = driver.findElement(AppiumBy.accessibilityId("No"));

				noBtn.click();

				System.out.println("Clicked on NO");
			}

		} catch (Exception e) {

			System.out.println("PFR popup not present");
		}
	}

	// =========================================
	// CLICK SUPPORT
	// =========================================

	public void clickSupportCTA() {

		try {

			WebElement supportBtn = wait
					.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Support")));

			supportBtn.click();

			System.out.println("Clicked Support");

		} catch (Exception e) {

			System.out.println("Unable to click Support");
		}
	}

	// =========================================
	// CLICK DOCTORS CARD
	// =========================================

	public void clickDoctorsCard() {

		try {

			WebElement doctorsCard = wait.until(ExpectedConditions
					.elementToBeClickable(AppiumBy.accessibilityId("List of doctors in your area, For emergencies")));

			doctorsCard.click();

			System.out.println("Clicked doctors card");

		} catch (Exception e) {

			System.out.println("Unable to click doctors card");
		}
	}

	// =========================================
	// ENTER PINCODE
	// =========================================

	public void enterPincode(String pinCode) {

		try {

			WebElement pincodeField = wait.until(ExpectedConditions
					.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@text=\"Enter pincode\"]")));

			pincodeField.click();

			Thread.sleep(1000);

			// Stable method for Xiaomi devices
			pincodeField.sendKeys(pinCode);

			driver.hideKeyboard();

			System.out.println("Pincode entered");

		} catch (Exception e) {

			System.out.println("Unable to enter pincode");

			try {

				driver.hideKeyboard();

				driver.findElement(AppiumBy
						.xpath("//android.widget.Button[@text=\"Location icon Use my current location Right arrow\"]"))
						.click();

			} catch (Exception ex) {

				ex.printStackTrace();
			}
		}
	}

	// =========================================
	// CLICK SEARCH
	// =========================================

	public void clickSearchButton() {

		try {

			WebElement searchBtn = wait.until(ExpectedConditions
					.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Search\")")));

			searchBtn.click();

			System.out.println("Clicked Search");

		} catch (Exception e) {

			System.out.println("Unable to click Search");
		}
	}

	// =========================================
	// BACK NAVIGATION
	// =========================================

	public void navigateBackToProgressPage() {

		try {

			driver.navigate().back();

			Thread.sleep(2000);

			driver.navigate().back();

			Thread.sleep(2000);

			System.out.println("Navigated back to Progress page");

		} catch (Exception e) {

			System.out.println("Unable to navigate back");
		}
	}
}