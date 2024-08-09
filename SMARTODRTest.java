package smartODR;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SMARTODRTest
{
	WebDriver driver;
	
	@BeforeMethod(description="This is broeser setup")
	public void browserSetup() 
	{
		// Open the browser		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
				
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
		// Navigate to the login page
		driver.get("https://dev.smartodr.in/login");
	}
	
	@Test(description="Login to the application")
	public void smartODR()
	{
		// Enter the username and password		
		driver.findElement(By.id("email")).sendKeys("pradipkshimpi@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Tester@999");
		
		//Click on Login enter OTP
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.findElement(By.id("OTP")).sendKeys("144869");		
		System.out.println("Login is successful");
		
		// checking the presence of a logout button
		List<WebElement> menu=driver.findElements(By.xpath(("//div[@class='flex flex-col pl-2 pb-10']")));
		System.out.println("******Menu button options are******");
		
		for(WebElement i:menu)
		{
			System.out.println(i.getText());
			if(i.getText().contains("Logout")) 
			{
				System.out.println("Logout exist");
				i.click();
				break;
			}
			
		}
		
		System.out.println("Program finish");
	
	}
}
