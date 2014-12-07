package com.roomkey.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RoomKeyAboutUsPage extends RoomKeyHomePage {

	@FindBy(xpath = "/html/body/div[2]/div[6]/div/div[2]/div/h3")
	private WebElement aboutUsTitle;
	
	public String getAboutUsTitle(){
		return aboutUsTitle.getText();
	}

	
}
