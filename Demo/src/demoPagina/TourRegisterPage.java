package demoPagina;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.app.core.GlobDriver;
import com.globant.app.core.GlobPage;

public class TourRegisterPage extends GlobPage{
	
	//CONTACT INFORMATION
	
	@FindBy(name="firstName")
	private WebElement firstName;

	@FindBy(name="lastName")
	private WebElement lastName;
	
	@FindBy(name="phone")
	private WebElement phone;
	
	@FindBy(name="userName")
	private WebElement userName;
	
	//MAILING INFORMATION
	
	@FindBy(name="address1")
	private WebElement address1;
	
	@FindBy(name="city")
	private WebElement city;
	
	@FindBy(name= "state")
	private WebElement state;
	
	@FindBy(name="postalCode")
	private WebElement postalCode;
	
	@FindBy(name="country")
	private WebElement country;
	
	//USER INFORMATION
	
	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(name="confirmPassword")
	private WebElement confirmPassword;
	
	@FindBy(name="register")
	private WebElement submit;
	
	//Contact Information
	public TourRegisterPage fillContactInformation(String firstName, String lastName,String phone, String userName){
		
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		this.phone.sendKeys(phone);
		this.userName.sendKeys(userName);
		
		return PageFactory.initElements(GlobDriver.getInstance().getDriver(),TourRegisterPage.class);
	}
	//Mailing Information
	public TourRegisterPage fillMailingInformation(String address1, String city, String state, String postalCode, String country){
		
		this.address1.sendKeys(address1);
		this.city.sendKeys(city);
		this.state.sendKeys(state);
		this.postalCode.sendKeys(postalCode);
		this.country.sendKeys(country);
		
		return PageFactory.initElements(GlobDriver.getInstance().getDriver(),TourRegisterPage.class);
		
	}
	
	public TourRegisterPage fillUserInformation(String email, String password, String confirmPassword){
		this.email.sendKeys(email);
		this.password.sendKeys(password);
		this.confirmPassword.sendKeys(confirmPassword);
		
		return PageFactory.initElements(GlobDriver.getInstance().getDriver(),TourRegisterPage.class);
		
				
	}
		
	public void clickSubmit(){
		submit.click();
	}
	
	
	
	//Obtener texto
	public String getFirstName(){
		return this.firstName.getText();
	}

}
