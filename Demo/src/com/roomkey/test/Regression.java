package com.roomkey.test;
/**
 * @author reynaldo.duarte
 */
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.globant.app.core.GlobDriver;
import com.globant.app.core.data.util.Assert;
import com.roomkey.page.RoomKeyAboutUsPage;
import com.roomkey.page.RoomKeyHomePage;

public class Regression {

	@BeforeSuite
	public void BeforeSuite(ITestContext context) {
		GlobDriver.getInstance().tearUp(context);
	}
	
	@AfterSuite
	public void afterSuite() {
		GlobDriver.getInstance().tearDown();
	}
	
	
	@Test
	public void AboutUsTest() throws Exception {
		
		RoomKeyHomePage homePage = PageFactory.initElements(GlobDriver.getInstance().getDriver(), RoomKeyHomePage.class);

		homePage.go();
		
		//homePage.fillCitySearch("Chicago ");
//		Thread.sleep(50000);
		
		
		Assert.assertTrue(homePage.getLabel().contains("About Us"));
		homePage.clickLinkAbout();

		RoomKeyAboutUsPage aboutUsPage = PageFactory.initElements(GlobDriver
				.getInstance().getDriver(), RoomKeyAboutUsPage.class);
		
		String t = aboutUsPage.getAboutUsTitle();
		System.out.println(t);
		
		Assert.assertTrue(aboutUsPage.getAboutUsTitle().contains("About Us"));
		
		
		
		
//		TourFlightFinder signInConfirm = PageFactory.initElements(GlobDriver
//				.getInstance().getDriver(), TourFlightFinder.class);
//		Assert.assertTrue(signInConfirm.getSignOffLinkText().contains(
//				"SIGN-OFF"));

	}
}
