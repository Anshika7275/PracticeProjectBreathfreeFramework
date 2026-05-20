package serviceTabPage;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.ServicePage;

public class ServicesTabTest extends BaseClass {

	@Test
	public void servicestabTest() throws Throwable {

		ServicePage service = new ServicePage(driver);

		// =========================
		// SERVICES TAB
		// =========================

		service.clickServicesTab();

		// =========================
		// LCP
		// =========================

		service.openLCP();

		service.clickJoinCTA("Join");

		service.exitProgramFlow();

		service.clickKnowMore();

		service.clickWhatsapp();

		service.navigateBackTwice();

		service.clickBackArrow();

		// =========================
		// PHYSIO
		// =========================

		service.openPhysio();

		service.clickJoinCTA("Enroll");

		service.exitProgramFlow();

		service.clickKnowMore();

		service.clickWhatsapp();

		service.navigateBackTwice();

		service.clickBackArrow();

		// =========================
		// DIET
		// =========================

		service.openDiet();

		service.clickJoinCTA("Join");

		service.exitProgramFlow();

		service.clickKnowMore();

		service.clickWhatsapp();

		service.navigateBackTwice();

		service.clickBackArrow();

		// =========================
		// YOGA
		// =========================

		service.openYoga();

		service.clickJoinCTA("Join");

		service.exitProgramFlow();

		service.clickKnowMore();

		service.clickWhatsapp();

		service.navigateBackTwice();

		service.clickBackArrow();

		// =========================
		// MEDICINES
		// =========================

		service.openMedicine();

		service.clickBackArrow();

		// =========================
		// SCROLL DOWN
		// =========================

		service.scrollTillBottom();

		// =========================
		// LAB TEST
		// =========================

		service.openLabTest();

		service.clickBackArrow();

		System.out.println("All Services Flow Completed Successfully");
	}
}
