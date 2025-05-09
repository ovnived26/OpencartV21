package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTlp;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPsswrd;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtCnfpsswrd;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkAgree;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnSubmit;
	
	@FindBy(xpath="//p[text()='Congratulations! Your new account has been successfully created!']")
	WebElement msgCnfrmtn;
	
	public void setFirstName(String fname) {
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String telephone) {
		txtTlp.sendKeys(telephone);
	}
	
	public void setPassword(String password) {
		txtPsswrd.sendKeys(password);
	}
	
	public void setConfirmPassword(String password) {
		txtCnfpsswrd.sendKeys(password);
	}
	
	public void clickPrivacyPolicy() {
		chkAgree.click();
	}
	
	public void clickContinue() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(btnSubmit)).click();
		//btnSubmit.click();
	}
	//The try-catch block in Java is used to handle exceptions, ensuring that the program continues to run
	//even when an error occurs. The try block contains code that might throw an exception, 
	//while the catch block handles the exception if it occurs.
	public String getConfirmationMsg() {
		try {
			return(msgCnfrmtn.getText());
		}
		catch (Exception e) {
			return(e.getMessage());
		}
	}
}
