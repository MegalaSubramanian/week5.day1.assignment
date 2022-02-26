package week5.day1.assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assessment2Child {

	public ChromeDriver driver;

	@BeforeMethod
	public void beforemethod() throws InterruptedException {
		
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	Thread.sleep(3000);
	driver.get("http://leaftaps.com/opentaps/");	
	Thread.sleep(4000);
	driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
	driver.findElement(By.id("password")).sendKeys("crmsfa");
	driver.findElement(By.className("decorativeSubmit")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("CRM/SFA")).click();
	Thread.sleep(4000);
	driver.findElement(By.linkText("Leads")).click();
	}
	@AfterMethod
	public void aftermethod() {
		driver.close();
	}
}
