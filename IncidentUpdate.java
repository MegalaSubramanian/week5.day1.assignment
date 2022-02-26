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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IncidentUpdate extends IncidentBaseClass{
	
	@Test
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
	
	
	
	
	
	

}
