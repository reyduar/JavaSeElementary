package demo.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import tour.page.TourFlightFinderPage;
import tour.page.TourLoginPage;

import com.globant.app.core.GlobDriver;
import com.globant.app.core.data.util.Assert;

public class TourSmoke {

	@BeforeSuite
	public void BeforeSuite(ITestContext context) {
		GlobDriver.getInstance().tearUp(context);
	}

	@AfterSuite
	public void afterSuite() {
		GlobDriver.getInstance().tearDown();
	}

	@Test
	public void loginTest() {

		TourLoginPage loginPage = PageFactory.initElements(GlobDriver.getInstance().getDriver(), TourLoginPage.class);

		loginPage.go();
		loginPage.fillLoginInformation("juangomez@hotmail.com", "facil");

		TourFlightFinderPage flightFinderPage = loginPage.clickOnSubmitButton();

		System.out.println(flightFinderPage.getflightFinderHeaderText());
		
		Assert.assertTrue(flightFinderPage.getflightFinderHeaderText()
				.isDisplayed());
	}

}
