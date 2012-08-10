package demo.page;

import org.openqa.selenium.WebElement;

public class WikiArticlePage extends MainPage{
	
	private WebElement firstHeading;
	
	public String getArticleTitle(){
		return firstHeading.getText();
	}

}
