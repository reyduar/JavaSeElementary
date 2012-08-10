package demo.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.app.core.GlobDriver;
import com.globant.app.core.GlobPage;

public class MainPage extends GlobPage{
	
	private WebElement searchInput;
	
	@FindBy(linkText = "Random article")
	private WebElement linkRandomArticle;
	
	public GlobPage searchFor(String searchString) {
		   searchInput.sendKeys(searchString);
		   searchInput.submit();
		   return PageFactory.initElements(GlobDriver.getInstance().getDriver(), WikiArticlePage.class);
	    }
	
	public WikiArticlePage clickRandomArticle() {
		   linkRandomArticle.click();
		   return PageFactory.initElements(GlobDriver.getInstance().getDriver(), WikiArticlePage.class);
	    }
}
