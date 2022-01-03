package Dayone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTestOne 
{
	
	WebDriver driver;
	SoftAssert as;
	
	@BeforeTest
	public void setup() 
	{
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		as = new SoftAssert();
		
	}
	
	@Test
	public void login() throws InterruptedException
	{
		driver.get("http://demo.guru99.com/insurance/v1/index.php");
		as.assertEquals(driver.findElement(By.xpath("//div[@class='content']/h3")).getText(), "Login");
		driver.findElement(By.xpath("//div[@class='content']/a")).click();
		
		// fill the register form
		as.assertEquals(driver.findElement(By.xpath("//div[@class='content']/h1")).getText(), "Sign up as a new user");
		
		// Title dropdown
		Select Title = new Select(driver.findElement(By.id("user_title")));
		Title.selectByVisibleText("Miss");
		
		// First name,surname,phone number
		driver.findElement(By.id("user_firstname")).sendKeys("Geha");
		driver.findElement(By.id("user_surname")).sendKeys("Dil");
		driver.findElement(By.name("phone")).sendKeys("0112789456");
		
		//Date of Birth
		Select year = new Select(driver.findElement(By.id("user_dateofbirth_1i")));
		year.selectByVisibleText("1995");
		Select month = new Select(driver.findElement(By.id("user_dateofbirth_2i")));
		month.selectByVisibleText("January");
		Select date = new Select(driver.findElement(By.id("user_dateofbirth_3i")));
		date.selectByVisibleText("1");
		
		Thread.sleep(1000);
		
		//Radio button
		driver.findElement(By.id("licencetype_t")).click();
		
		//Licence Period
		Select period = new Select(driver.findElement(By.id("user_licenceperiod")));
		period.selectByVisibleText("1");
		
		Thread.sleep(1000);
		
		//Occupation
		Select occupation = new Select(driver.findElement(By.id("user_occupation_id")));
		occupation.selectByVisibleText("Student");
		
		//address
		driver.findElement(By.name("street")).sendKeys("12/A");
		driver.findElement(By.name("city")).sendKeys("Kottawa");
		driver.findElement(By.name("county")).sendKeys("Sri Lanka");
		
		//passcode, email
		driver.findElement(By.name("post_code")).sendKeys("123456");
		driver.findElement(By.name("email")).sendKeys("abc@gmail.com");
		
		//password
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("c_password")).sendKeys("123456");
		
		Thread.sleep(1000);
		
		//click create
		driver.findElement(By.name("submit")).click();
		
		//login page validate
		as.assertEquals(driver.findElement(By.xpath("//div[@class='content']/h3")).getText(), "Login");
		
		//login
		driver.findElement(By.name("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("submit")).click();
		
		//confirm login page
		as.assertEquals(driver.findElement(By.xpath("//div[@id='tabs-1']/h2")).getText(), "Broker Insurance WebPage");
	}
	
	@AfterTest
	public void close() 
	{
		driver.close();
	}

}
