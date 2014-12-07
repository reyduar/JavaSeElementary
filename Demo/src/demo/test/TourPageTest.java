package demo.test;

import it.sauronsoftware.jave.Video;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.globant.app.core.GlobDriver;
import com.globant.app.core.data.factory.XmlDataFactory;
import com.globant.app.core.data.util.Assert;
import demoPagina.TourConfirmRegister;
import demoPagina.TourFlightFinder;
import demoPagina.TourHomePage;
import demoPagina.TourRegisterPage;
import demoPagina.TourSignInPage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TourPageTest {

	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeSuite
	public void BeforeSuite(ITestContext context) {
		GlobDriver.getInstance().tearUp(context);
	}
	
	@AfterSuite
	public void afterSuite() {
		GlobDriver.getInstance().tearDown();
	}

	@DataProvider(name = "fillRegister")
	public Object[][] fillRegister() throws IOException {
		XmlDataFactory xmlFactory = XmlDataFactory.getInstance();
		xmlFactory.initialize("./src/demo/data/");
		return xmlFactory.getArrayFromDataRow("createUserCriteria");
	}

	@Test(dataProvider = "fillRegister")
	public void AddNewUser(String firstName, String lastName, String phone,
			String userName, String address, String city, String state,
			String postalCode, String country, String email, String password,
			String confirmPassword) throws Exception {
		
		TourHomePage homePage = PageFactory.initElements(GlobDriver
				.getInstance().getDriver(), TourHomePage.class);

		homePage.go();
		homePage.clickLinkReg();

		TourRegisterPage TourPage = PageFactory.initElements(GlobDriver
				.getInstance().getDriver(), TourRegisterPage.class);

		TourPage.fillContactInformation(firstName, lastName, phone, userName);
		TourPage.fillMailingInformation(address, city, state, postalCode,
				country);
		TourPage.fillUserInformation(userName, password, confirmPassword);

		TourPage.clickSubmit();

		TourConfirmRegister registerConf = PageFactory.initElements(GlobDriver
				.getInstance().getDriver(), TourConfirmRegister.class);
		
		Assert.assertTrue(
				registerConf
						.getConfirmRegister()
						.contains(
								"Thank you for registering. You may now sign-in using the user name and password you've just entered."),
				"El texto deseado no existe.");

	}

	

	@Test
	public void SignIn() throws Exception {
		
		TourHomePage homePage = PageFactory.initElements(GlobDriver.getInstance().getDriver(), TourHomePage.class);

		homePage.go();
		homePage.clickLinkSign();

		TourSignInPage sign = PageFactory.initElements(GlobDriver.getInstance()
				.getDriver(), TourSignInPage.class);

		sign.fillUserInformation("juangomez@hotmail.com", "facil");
		sign.clickSubmit();

		TourFlightFinder signInConfirm = PageFactory.initElements(GlobDriver
				.getInstance().getDriver(), TourFlightFinder.class);
		Assert.assertTrue(signInConfirm.getSignOffLinkText().contains(
				"SIGN-OFF"));

	}

}
