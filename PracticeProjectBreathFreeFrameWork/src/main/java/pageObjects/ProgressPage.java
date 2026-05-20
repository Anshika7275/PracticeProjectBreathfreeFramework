package pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.BaseClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ProgressPage extends BaseClass {

	WebDriverWait wait;

	// =========================================
	// Constructor
	// =========================================

	public ProgressPage(AndroidDriver driver) {

		this.driver = driver;

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	// ==========================================
	// LOCATORS
	// ==========================================

	AppiumBy progressTab = (AppiumBy) AppiumBy.accessibilityId("Progress");

	AppiumBy morningTab = (AppiumBy) AppiumBy.accessibilityId("MORNING");

	AppiumBy eveningTab = (AppiumBy) AppiumBy.accessibilityId("EVENING");

	AppiumBy supportBtn = (AppiumBy) AppiumBy.accessibilityId("Support");

	AppiumBy startExerciseCTA = (AppiumBy) AppiumBy.accessibilityId("Start breathing exercise");

	AppiumBy startBtn = (AppiumBy) AppiumBy.accessibilityId("Start");

	AppiumBy stopBtn = (AppiumBy) AppiumBy.accessibilityId("Stop");

	AppiumBy quitHalfwayBtn = (AppiumBy) AppiumBy.accessibilityId("I am okay to quit halfway");

	AppiumBy markTakenBtn = (AppiumBy) AppiumBy.accessibilityId("Mark taken");

	AppiumBy yesBtn = (AppiumBy) AppiumBy.accessibilityId("Yes");

	AppiumBy noBtn = (AppiumBy) AppiumBy.accessibilityId("No");

	// ==========================================
	// OPEN PROGRESS TAB
	// ==========================================

	public void openProgressTab() {

		try {

			WebElement progress = wait.until(ExpectedConditions.elementToBeClickable(progressTab));

			progress.click();

			System.out.println("Clicked Progress tab");

		} catch (Exception e) {

			System.out.println("Already on Progress tab");
		}
	}

	// ==========================================
	// SWITCH TO MORNING TAB
	// ==========================================

	public void switchToMorningTab() throws Exception {

		WebElement morning = wait.until(ExpectedConditions.visibilityOfElementLocated(morningTab));

		String selected = morning.getAttribute("selected");

		if (selected != null && selected.equalsIgnoreCase("true")) {

			System.out.println("Already on Morning tab");
		}

		else {

			((JavascriptExecutor) driver).executeScript("mobile: clickGesture",
					Map.of("elementId", ((RemoteWebElement) morning).getId()));

			System.out.println("Switched to Morning tab");
		}
	}

	// ==========================================
	// SWITCH TO EVENING TAB
	// ==========================================

	public void switchToEveningTab() {

		try {

			WebElement evening = wait.until(ExpectedConditions.elementToBeClickable(eveningTab));

			((JavascriptExecutor) driver).executeScript("mobile: clickGesture",
					Map.of("elementId", ((RemoteWebElement) evening).getId()));

			System.out.println("Switched to Evening tab");

		} catch (Exception e) {

			System.out.println("Unable to switch Evening tab");
		}
	}

	// ==========================================
	// HANDLE PFR POPUP
	// ==========================================

	public void handlePFRPopup() {

		try {

			List<WebElement> popup = driver
					.findElements(AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Peak Flow Rate\")"));

			if (popup.size() > 0) {

				System.out.println("PFR popup displayed");

				List<WebElement> noCTA = driver.findElements(noBtn);

				List<WebElement> yesCTA = driver.findElements(yesBtn);

				if (noCTA.size() > 0) {

					noCTA.get(0).click();

					System.out.println("Clicked NO CTA");
				}

				else if (yesCTA.size() > 0) {

					yesCTA.get(0).click();

					System.out.println("Clicked YES CTA");
				}
			}

			else {

				System.out.println("PFR popup not present");
			}

		} catch (Exception e) {

			System.out.println("Unable to handle PFR popup");
		}
	}

	// ==========================================
	// VALIDATE EVENING LOCK / UNLOCK
	// ==========================================

	public boolean validateEveningUnlock() {

		boolean eveningUnlocked = false;

		try {

			List<WebElement> startExercise = driver.findElements(startExerciseCTA);

			List<WebElement> medicine = driver.findElements(markTakenBtn);

			List<WebElement> yesCTA = driver.findElements(yesBtn);

			List<WebElement> noCTA = driver.findElements(noBtn);

			List<WebElement> startCTA = driver.findElements(startBtn);

			if (startExercise.size() > 0 || medicine.size() > 0 || yesCTA.size() > 0 || noCTA.size() > 0
					|| startCTA.size() > 0) {

				eveningUnlocked = true;
			}

			if (!eveningUnlocked) {

				System.out.println("Your evening tab is locked. Come back after 4 PM");

				WebElement morning = wait.until(ExpectedConditions.elementToBeClickable(morningTab));

				morning.click();

				System.out.println("Switched back to Morning tab");

				return false;
			}

			System.out.println("Evening tasks unlocked");

		} catch (Exception e) {

			System.out.println("Unable to validate evening state");
		}

		return true;
	}

	// ==========================================
	// HANDLE MEDICINE REMINDER
	// ==========================================

	public void handleMedicineReminder() {

		try {

			boolean medicineFound = false;

			for (int i = 0; i < 4; i++) {

				List<WebElement> medicineReminder = driver.findElements(
						AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Medicine reminder\")"));

				if (medicineReminder.size() > 0) {

					medicineFound = true;

					System.out.println("Medicine reminder found");

					break;
				}

				scrollDown();
			}

			if (medicineFound) {

				List<WebElement> markTaken = driver.findElements(markTakenBtn);

				if (markTaken.size() > 0) {

					((JavascriptExecutor) driver).executeScript("mobile: clickGesture",
							Map.of("elementId", ((RemoteWebElement) markTaken.get(0)).getId()));

					System.out.println("Medicine marked as taken");
				}
			}

		} catch (Exception e) {

			System.out.println("Unable to handle medicine reminder");
		}
	}

	// ==========================================
	// HANDLE EXERCISE
	// ==========================================

	public void handleExercise() {

		try {

			boolean exerciseFound = false;

			for (int i = 0; i < 4; i++) {

				List<WebElement> exercise = driver.findElements(startExerciseCTA);

				if (exercise.size() > 0) {

					exerciseFound = true;

					((JavascriptExecutor) driver).executeScript("mobile: clickGesture",
							Map.of("elementId", ((RemoteWebElement) exercise.get(0)).getId()));

					System.out.println("Exercise opened");

					break;
				}

				scrollDown();
			}

			if (exerciseFound) {

				Thread.sleep(3000);

				WebElement start = wait.until(ExpectedConditions.elementToBeClickable(startBtn));

				start.click();

				System.out.println("Exercise started");

				Thread.sleep(5000);

				driver.navigate().back();

				System.out.println("Pressed back");

				Thread.sleep(2000);

				List<WebElement> quitBtn = driver.findElements(quitHalfwayBtn);

				if (quitBtn.size() > 0) {

					quitBtn.get(0).click();

					System.out.println("Quit halfway clicked");
				}
			}

			else {

				System.out.println("Exercise CTA not present");
			}

		} catch (Exception e) {

			System.out.println("Unable to handle exercise");
		}
	}

	// ==========================================
	// SCROLL DOWN
	// ==========================================

	public void scrollDown() throws Exception {

		Dimension size = driver.manage().window().getSize();

		int left = size.width / 2;

		int top = (int) (size.height * 0.75);

		int height = (int) (size.height * 0.50);

		driver.executeScript("mobile: swipeGesture",
				Map.of("left", left, "top", top, "width", 100, "height", height, "direction", "up", "percent", 0.75));

		Thread.sleep(2000);
	}
}