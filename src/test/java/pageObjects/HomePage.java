package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		//super() as well as this() keyword both are used to make constructor calls. 
		//super() is used to call Base class’s constructor(i.e, Parent’s class) while this() is used to call the current class’s constructor.
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//a[@title='My Account']")
	WebElement lnkMyaccnt;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	WebElement lnkReg;

public void clickMyAccount()
{
	lnkMyaccnt.click();
}
public void clickRegister()
{
	lnkReg.click();
}
}
