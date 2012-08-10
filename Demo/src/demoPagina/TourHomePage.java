package demoPagina;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.app.core.GlobDriver;
import com.globant.app.core.GlobPage;


public class TourHomePage extends GlobPage{
	
	@FindBy (linkText = "SIGN-ON")
	private WebElement linkSign;

	@FindBy (linkText = "REGISTER")
	private WebElement linkReg;
	
	
	
	
	public void go(){
		GlobDriver.getInstance().getDriver().get("http://newtours.demoaut.com");
	}
	
	//metodo click para SIgn-In
	public TourArticlePage clickLinkSign(){
		linkSign.click();
		return PageFactory.initElements(GlobDriver.getInstance().getDriver(),TourArticlePage.class);		
		
	}
	
	//metodo click para Register
	
	public TourArticlePage clickLinkReg(){
		linkReg.click();
		return PageFactory.initElements(GlobDriver.getInstance().getDriver(),TourArticlePage.class);
				
	}
	
	
	
	
}
