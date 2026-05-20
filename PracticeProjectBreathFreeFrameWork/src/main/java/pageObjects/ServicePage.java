// ===============================
// ServicesPage.java
// ===============================

package pageObjects;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.BaseClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ServicePage extends BaseClass {


		WebDriverWait wait;

		public ServicePage(AndroidDriver driver)
		{
			
			this.driver=driver;
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		}

		// =========================
		// LOCATORS
		// =========================

		By servicesTab = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='Services']");

		By lcpBanner = AppiumBy.xpath(
				"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView");

		By physioBanner = AppiumBy.xpath(
				"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView");

		By dietBanner = AppiumBy.xpath(
				"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView");

		By yogaBanner = AppiumBy.xpath(
				"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView");

		By medicineBanner = AppiumBy.xpath(
				"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView");

		By labTestBanner = AppiumBy.xpath(
				"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView");

		By knowMoreCTA = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='Know More']");

		By chatWhatsapp = AppiumBy.xpath("//android.widget.TextView[@text='Chat on Whatsapp']");

		By goBackBtn = AppiumBy.xpath("//android.widget.Button[@text='Go back']");

		By yesExitBtn = AppiumBy.xpath("//android.widget.Button[@text='Yes, exit']");

		By okayBtn = AppiumBy.xpath("//android.widget.TextView[@text='Okay']");

		By backArrow = AppiumBy.xpath(
				"//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView");

		// =========================
		// COMMON METHODS
		// =========================

		public void clickServicesTab() {

			wait.until(ExpectedConditions.elementToBeClickable(servicesTab)).click();

			System.out.println("Clicked Services Tab");
		}

		public void openLCP() {

			wait.until(ExpectedConditions.elementToBeClickable(lcpBanner)).click();

			System.out.println("Navigate to LCP page");
		}

		public void openPhysio() {

			wait.until(ExpectedConditions.elementToBeClickable(physioBanner)).click();

			System.out.println("Navigate to Physio page");
		}

		public void openDiet() {

			wait.until(ExpectedConditions.elementToBeClickable(dietBanner)).click();

			System.out.println("Navigate to Diet page");
		}

		public void openYoga() {

			wait.until(ExpectedConditions.elementToBeClickable(yogaBanner)).click();

			System.out.println("Navigate to Yoga page");
		}

		public void openMedicine() {

			wait.until(ExpectedConditions.elementToBeClickable(medicineBanner)).click();

			System.out.println("Navigate to Medicine page");
		}

		public void openLabTest() {

			wait.until(ExpectedConditions.elementToBeClickable(labTestBanner)).click();

			System.out.println("Navigate to Lab Test page");
		}

		// =========================
		// CLICK JOIN / ENROLL CTA
		// =========================

		public void clickJoinCTA(String text) {

			try {

				WebElement joinCTA = wait.until(ExpectedConditions.presenceOfElementLocated(
						AppiumBy.xpath("//android.view.ViewGroup[contains(@content-desc,'" + text + "')]")));

				((JavascriptExecutor) driver).executeScript("mobile: clickGesture",
						Map.of("elementId", ((RemoteWebElement) joinCTA).getId()));

				System.out.println("Clicked CTA : " + text);

			} catch (Exception e) {

				System.out.println("Unable to click CTA : " + text);
				e.printStackTrace();
			}
		}

		// =========================
		// EXIT FLOW
		// =========================

		public void exitProgramFlow() {

			try {

				wait.until(ExpectedConditions.elementToBeClickable(goBackBtn)).click();

				wait.until(ExpectedConditions.elementToBeClickable(yesExitBtn)).click();

				wait.until(ExpectedConditions.elementToBeClickable(okayBtn)).click();

				System.out.println("Exited program flow");

			} catch (Exception e) {

				System.out.println("Unable to exit program flow");
			}
		}

		// =========================
		// KNOW MORE FLOW
		// =========================

		public void clickKnowMore() {

			wait.until(ExpectedConditions.elementToBeClickable(knowMoreCTA)).click();

			System.out.println("Clicked Know More");
		}

		public void clickWhatsapp() {

			wait.until(ExpectedConditions.elementToBeClickable(chatWhatsapp)).click();

			System.out.println("Clicked Chat on Whatsapp");
		}

		public void navigateBackTwice() throws InterruptedException {

			Thread.sleep(2000);

			driver.navigate().back();

			Thread.sleep(2000);

			driver.navigate().back();

			System.out.println("Navigated back");
		}

		public void clickBackArrow() {

			wait.until(ExpectedConditions.elementToBeClickable(backArrow)).click();

			System.out.println("Clicked Back Arrow");
		}

		// =========================
		// SCROLL BOTTOM
		// =========================

		public void scrollTillBottom() throws InterruptedException {

			boolean canScrollMore = true;

			while (canScrollMore) {

				canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
						Map.of("left", 100, "top", 100, "width", 500, "height", 1200, "direction", "down",
								"percent", 0.85));

				Thread.sleep(2000);
			}

			System.out.println("Reached bottom of page");
		}

	}
	

