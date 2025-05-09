package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
WebDriver driver;//variable
Properties p;
//Logger logger;
	
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException
	{
		//logger=LogManager.getLogger(this.getClass());
		//driver=new ChromeDriver();
		//driver=new EdgeDriver();
		//ChromeOptions options=new ChromeOptions();
		//options.addArguments("headless");
		FileReader file=new FileReader("./src//test//resources//config.properties");//To read the file we have to use the Java Filereader and set the path of the properties file.
		p=new Properties();//invoke the properties class
		p.load(file);//Then we have to load the File into the properties using the load method.
		
		switch(br)
		{
		case "chrome" : driver=new ChromeDriver(); break;//invoke the driver class
		case "edge" : driver=new EdgeDriver(); break;
		case "firefox" : driver=new FirefoxDriver(); break;
		}
		driver.manage().deleteAllCookies();
		//Implicit waits are used to provide a default waiting time between each consecutive test steps.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(p.getProperty("appURL"));//we can access the data in the properties file by using the getProperty method 
	}
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	public String randomeString()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	public String randomeNumber()
	{
		String generatednumber = RandomStringUtils.random(10);
		return generatednumber;
	}
	
	public String randomeAlphaNumeric()
	{
		@SuppressWarnings("deprecation")
		String generatedstring = RandomStringUtils.randomAlphabetic(3);
		@SuppressWarnings("deprecation")
		String generatednumber= RandomStringUtils.random(3);
		return (generatedstring+generatednumber);
	}
}
