package demoPagina;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.app.core.GlobDriver;
import com.globant.app.core.GlobPage;

public class TourSignInPage extends GlobPage {
	
	@FindBy(name="userName")
	private WebElement userName;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement login;
	
	public TourSignInPage fillUserInformation(String userName, String password){
		
		this.userName.sendKeys(userName);
		this.password.sendKeys(password);
	
	return PageFactory.initElements(GlobDriver.getInstance().getDriver(),TourSignInPage.class);
		
	} 

	public void clickSubmit(){
		login.click();
			
	}
	
	
	
	
}
