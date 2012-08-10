package demoPagina;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.app.core.GlobDriver;
import com.globant.app.core.GlobPage;

public class TourFlightFinder extends GlobPage {

	@FindBy(xpath = "html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font")
	private WebElement flightFinder;
	
	@FindBy(linkText = "SIGN-OFF")
	private WebElement signOff;	

	// Flight details

	@FindBy(xpath = "(//input[@name='tripType'])[1]")
	private WebElement roundtrip;

	@FindBy(xpath = "(//input[@name='tripType'])[2]")
	private WebElement oneway;

	@FindBy(name = "passCount")
	private WebElement passenger;

	@FindBy(name = "fromPort")
	private WebElement departFrom;

	@FindBy(name = "fromMonth")
	private WebElement fromMonth;

	@FindBy(name = "fromDay")
	private WebElement fromDay;

	@FindBy(name = "toPort")
	private WebElement arriveiN;

	@FindBy(name = "toMonth")
	private WebElement month;

	@FindBy(name = "toDay")
	private WebElement day;

	// Preferences

	@FindBy(xpath = "//input[@name='tripType'])[1]")
	private WebElement economy;

	@FindBy(xpath = "//input[@name='tripType'])[2]")
	private WebElement business;

	@FindBy(xpath = "//input[@name='tripType'])[3]")
	private WebElement firtClass;

	@FindBy(name = "airline")
	private WebElement airline;

	public TourFlightFinder fillFlightDetails(boolean roundTrip,
			String passenger, String departingFrom, String monthDeparture,
			String dateDeparture, String arrivingIn, String monthReturn,
			String dateReturn) {

		if (roundTrip) {
			this.roundtrip.click();
		} else {
			this.oneway.click();
		}

		this.passenger.sendKeys(passenger);
		this.departFrom.sendKeys(departingFrom);
		this.fromMonth.sendKeys(monthDeparture);
		this.fromDay.sendKeys(dateDeparture);
		this.arriveiN.sendKeys(arrivingIn);
		this.month.sendKeys(monthReturn);
		this.day.sendKeys(dateReturn);

		return PageFactory.initElements(GlobDriver.getInstance().getDriver(),
				TourFlightFinder.class);
	}

	public TourFlightFinder fillFlightPreferences(boolean service,
			String airline) {
		if (service) {
			this.economy.click();
		} else {
			this.business.click();
		}

		this.airline.sendKeys(airline);

		return PageFactory.initElements(GlobDriver.getInstance().getDriver(),
				TourFlightFinder.class);

	}

	public String getConfirmSignIn() {
		return this.flightFinder.getText();
	}
	
	public String getSignOffLinkText(){
		return this.signOff.getText();
	}

}
