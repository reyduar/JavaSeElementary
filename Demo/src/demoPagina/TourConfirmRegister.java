package demoPagina;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.app.core.GlobDriver;
import com.globant.app.core.GlobPage;

public class TourConfirmRegister extends GlobPage {

	// title under flight finder
	@FindBy(xpath = "html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font")
	private WebElement confirmRegister;


	public String getConfirmRegister() {
		return this.confirmRegister.getText();
	}
}
