package progressTabTaskTest;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.ProgressPage;

public class ProgressPageTest extends BaseClass {

	@Test
	public void progressTaskTest() throws Exception {

		ProgressPage progress = new ProgressPage(driver);

		// =========================
		// OPEN PROGRESS TAB
		// =========================

		progress.openProgressTab();

		Thread.sleep(3000);

		// =========================
		// MORNING TAB
		// =========================

		progress.handleMorningTab();

		Thread.sleep(2000);

		// =========================
		// PFR POPUP
		// =========================

		progress.handlePFRPopup();

		Thread.sleep(3000);

		// =========================
		// SUPPORT FLOW
		// =========================

		progress.clickSupportCTA();

		Thread.sleep(2000);

		progress.clickDoctorsCard();

		Thread.sleep(3000);

		progress.enterPincode("410013");

		Thread.sleep(2000);

		progress.clickSearchButton();

		Thread.sleep(5000);

		progress.navigateBackToProgressPage();
	}

}
