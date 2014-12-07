package tour.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.app.core.GlobDriver;
import com.globant.app.core.GlobPage;

public class TourLoginPage extends GlobPage {

	@FindBy(name = "userName")
	private WebElement userNameInput;
	
	@FindBy(name = "password")
	private WebElement passwordInput;
	
	@FindBy(name = "login")
	private WebElement loginButton;
	
	
	public void go(){
		GlobDriver.getInstance().getDriver().get("http://newtours.demoaut.com/mercurysignon.php");
	}
	
	/**
	 * 
	 * @param user
	 * @param password
	 * @return
	 */
	public TourLoginPage fillLoginInformation(String user, String password){
		
		this.userNameInput.clear();
		this.userNameInput.sendKeys(user);
		this.passwordInput.clear();
		this.passwordInput.sendKeys(password);
		
		return PageFactory.initElements(GlobDriver.getInstance().getDriver(), TourLoginPage.class);
	}
	
	/**
	 * 
	 * @return
	 */
	public TourFlightFinderPage clickOnSubmitButton(){
		
		this.loginButton.click();
		
		return PageFactory.initElements(GlobDriver.getInstance().getDriver(), TourFlightFinderPage.class);
		
	}
	
}
