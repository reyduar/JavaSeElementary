package demoPagina;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.globant.app.core.GlobDriver;
import com.globant.app.core.GlobPage;

public class TourMainPage extends GlobPage {
	
	public WebElement searchInput;
	
	@FindBy (linkText = "randomLink")
	private WebElement randomLink;
	
	
	public GlobPage searchFor (String searchString){
		searchInput.sendKeys(searchString);
		searchInput.submit();
		return PageFactory.initElements(GlobDriver.getInstance().getDriver(),TourArticlePage.class);
		
	}
	
	
	public TourArticlePage clickRandomLink(){
		randomLink.click();
		return PageFactory.initElements(GlobDriver.getInstance().getDriver(),TourArticlePage.class);
		
	}
	
	
	
	
	
}
