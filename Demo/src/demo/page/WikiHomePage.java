package demo.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.globant.app.core.GlobDriver;
import com.globant.app.core.GlobPage;

public class WikiHomePage extends GlobPage{
	
	@FindBy(linkText = "English")
	private WebElement linkEnglish;
	
	@FindBy(linkText = "Espa–ol")
	private WebElement linkSpanish;
	

	public void go(){
		GlobDriver.getInstance().getDriver().get("http://wikipedia.org");
	}
	
	public WikiArticlePage clickLinkEnglish(){
		linkEnglish.click();
		return PageFactory.initElements(GlobDriver.getInstance().getDriver(), WikiArticlePage.class);
	}
	
	public WikiArticlePage clickLinkSpanish(){
		linkSpanish.click();
		return PageFactory.initElements(GlobDriver.getInstance().getDriver(), WikiArticlePage.class);
	}

	
	























}
