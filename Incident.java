package week5.day1.assessment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Incident extends IncidentBaseClass{
	
	@Test(priority=-4, invocationCount=6, threadPoolSize=3,enabled=false)
	public void create() throws IOException, InterruptedException {
		driver.findElement(By.xpath("(//div[text() ='All'])[2]")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		String home = driver.getWindowHandle();
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		Set<String> window = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(window);
		String secondWindow = list.get(1);
		driver.switchTo().window(secondWindow);
		driver.findElement(By.xpath ("//a[@sys_id ='62826bf03710200044e0bfc8bcbe5df1']")).click();
		driver.switchTo().window(home);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("(//input[contains(@name,'incident.short_description')])[4]")).sendKeys("Testing");
		WebElement number = driver.findElement(By.id("incident.number"));
		String incidentID = number.getAttribute("value");
		System.out.println(incidentID);
		driver.findElement(By.xpath("//button[text() ='Submit']")).click();
		//driver.switchTo().window(home);
		//driver.switchTo().frame(0);
		WebElement search = driver.findElement(By.xpath("(//label[text()='Search'])[2]/following::input"));
		search.sendKeys(incidentID, Keys.ENTER);
	}

@Test(invocationCount=2, threadPoolSize=1)
public void update() throws IOException, InterruptedException {

	driver.findElement(By.xpath("(//div[text() ='All'])[2]")).click();
	driver.switchTo().frame(0);
	driver.findElement(By.xpath("(//tbody[@class='list2_body'])/tr[2]/td[3]")).click();
	WebElement value = driver.findElement(By.id("incident.number"));
	String number = value.getAttribute("value");
	System.out.println(number);
	Select dropdown = new Select((driver.findElement(By.xpath("//Select[@name='incident.state']"))));
	dropdown.selectByValue("2");		
	Select dropdown1 = new Select((driver.findElement(By.xpath("//Select[@name='incident.urgency']"))));
	dropdown.selectByValue("1");
	//driver.switchTo().frame(1);
	driver.findElement(By.xpath("(//button[text()='Update'])[1]")).click();
	WebElement search = driver.findElement(By.xpath("(//label[text()='Search'])[2]/following::input"));
	search.sendKeys(number, Keys.ENTER);
}
	
@Test(priority=2, invocationCount=3, threadPoolSize=1,enabled=true)
public void assign() throws IOException, InterruptedException {
	driver.findElement(By.xpath("(//div[text()='Open'])[1]")).click();
	driver.switchTo().frame(0);
	WebElement search = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
	Actions builder = new Actions(driver);
	builder.click(search).perform();
	search.sendKeys("INC0000018", Keys.ENTER);
	driver.findElement(By.xpath("(//tbody[@class='list2_body'])/tr[1]/td[3]")).click();
	WebElement assign = driver.findElement(By.id("lookup.incident.assignment_group"));
	builder.click(assign).perform();
	Set<String> window = driver.getWindowHandles();
	List<String> list = new ArrayList<String>(window);
	String Home = list.get(0);
	String NewWindow = list.get(1);
	driver.switchTo().window(NewWindow);
	driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("software", Keys.ENTER);
	driver.findElement(By.xpath("//a[text()='Software']")).click();
	driver.switchTo().window(Home);
	driver.switchTo().frame(0);
	driver.findElement(By.id("activity-stream-textarea")).sendKeys("Testing");
	driver.findElement(By.xpath("(//button[text()='Update'])[1]")).click();
}

	@Test(priority=-1)
	public void delete() throws InterruptedException {
		driver.findElement(By.xpath("(//div[text() ='All'])[2]")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("(//tbody[@class='list2_body'])/tr[9]/td[3]")).click();
		WebElement value = driver.findElement(By.id("incident.number"));
		String number = value.getAttribute("value");
		System.out.println(number);
		driver.findElement(By.xpath("(//button[text()='Delete'])[1]")).click();
		//driver.findElement(By.id("cancel_button")).click();
		driver.findElement(By.id("ok_button")).click();
		//WebElement search = driver.findElement(By.xpath("(//label[text()='Search'])[2]/following::input"));
		//search.click();
		//search.sendKeys(number, Keys.ENTER);
	}
	

}
