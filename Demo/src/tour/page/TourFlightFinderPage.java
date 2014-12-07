package tour.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.app.core.GlobPage;

public class TourFlightFinderPage extends GlobPage{
	
	@FindBy(xpath = "//table/tbody/tr/td[2]/table/tbody/tr[1]/td/img")
	private WebElement flightFindeHeader;
	
	/**
	 * 
	 * @return
	 */
	public WebElement getflightFinderHeaderText(){
		return this.flightFindeHeader;
	}
}
