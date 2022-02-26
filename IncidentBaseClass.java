package week5.day1.assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IncidentBaseClass {

	public ChromeDriver driver;

	@BeforeMethod
	public void precondition() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		driver.get("https://dev87145.service-now.com/");	
		WebElement mainframe = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(mainframe);
		Thread.sleep(3000);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Test@2022");
		driver.findElement(By.xpath("//button[text() ='Log in']")).click();
		driver.findElement(By.xpath("//input[@id ='filter']")).sendKeys("incident");
	}

	@AfterMethod
	public void postcondition() {
		driver.close();
	}

}
