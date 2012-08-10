package demoPagina;

import org.openqa.selenium.WebElement;

public class TourArticlePage extends TourMainPage {
	
	private WebElement firstHeading;
	
	public String getArticleTitle(){
		return firstHeading.getText();
	}












}
