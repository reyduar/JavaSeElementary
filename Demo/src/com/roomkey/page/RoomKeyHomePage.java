package com.roomkey.page;

/**
 * @author reynaldo.duarte
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.globant.app.core.GlobDriver;
import com.globant.app.core.GlobPage;


public class RoomKeyHomePage extends GlobPage {

	@FindBy(linkText = "About Us")
	private WebElement linkAbout;
	
//	@FindBy(name = "copter-autofill-1346443180821")
//	private WebElement searchFieldInput;
	
	@FindBy(xpath = "//*[@id='copter-autofill-1346443180821']")
	private WebElement searchFieldInput;
	
//	@FindBy(name = "login")
//	private WebElement loginButton;

	public void go() {
		GlobDriver.getInstance().getDriver().get("http://www.roomkey.com/");
	}
	
public RoomKeyHomePage fillCitySearch(String citySearch){
		
//		this.searchFieldInput.clear();
	System.out.println("Hello I there! "+citySearch);
		this.searchFieldInput.sendKeys(citySearch);
				
		return PageFactory.initElements(GlobDriver.getInstance().getDriver(), RoomKeyHomePage.class);
	}

	public RoomKeyHomePage clickLinkAbout() {
		linkAbout.click();
		return PageFactory.initElements(GlobDriver.getInstance().getDriver(),RoomKeyHomePage.class);

	}
	
	public String getLabel(){
		return linkAbout.getText();
	}
	

}
