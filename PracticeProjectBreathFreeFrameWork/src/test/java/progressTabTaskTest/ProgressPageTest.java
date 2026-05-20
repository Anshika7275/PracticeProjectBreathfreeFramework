package progressTabTaskTest;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.ProgressPage;

public class ProgressPageTest extends BaseClass {

	@Test(priority = 1)
	public void progressPage_MorningTaskTest() throws Exception {

		ProgressPage progress = new ProgressPage(driver);

		progress.openProgressTab();

		Thread.sleep(3000);

		progress.switchToMorningTab();

		Thread.sleep(3000);

		progress.handlePFRPopup();

		Thread.sleep(3000);

		progress.handleMedicineReminder();

		Thread.sleep(3000);

		progress.handleExercise();

		System.out.println("Morning task flow completed");
	}

	@Test(priority = 2)
	public void progressPage_eveningTaskTest() throws Exception {

		ProgressPage progress = new ProgressPage(driver);

		progress.openProgressTab();

		Thread.sleep(3000);

		progress.switchToEveningTab();

		Thread.sleep(4000);

		boolean unlocked = progress.validateEveningUnlock();

		if (!unlocked) {

			return;
		}

		progress.handlePFRPopup();

		Thread.sleep(3000);

		progress.handleMedicineReminder();

		Thread.sleep(3000);

		progress.handleExercise();

		System.out.println("Evening task flow completed");
	}

}
