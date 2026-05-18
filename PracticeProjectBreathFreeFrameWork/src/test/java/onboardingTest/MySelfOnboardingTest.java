package onboardingTest;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.OnboardingPage;

public class MySelfOnboardingTest extends BaseClass{
	
	@Test
	public void onboardingFlow() throws Exception {

		OnboardingPage onboarding = new OnboardingPage(driver);

		onboarding.handleNotificationPopup();

		onboarding.handleGooglePopup();

		onboarding.enterMobileNumber("9999999901");

		onboarding.enterOTP("1122");

		onboarding.selectLanguage();

		onboarding.selectMyself();

		onboarding.enterBasicDetails();

		onboarding.selectCohort();

		onboarding.selectSymptoms();

		onboarding.selectConditions();

		onboarding.selectNoInhaler();

		onboarding.clickContinue();
	}

}
