package week5.day1.assessment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IncidentDelete extends IncidentBaseClass{

	@Test
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
		Thread.sleep(3000);
		WebElement search = driver.findElement(By.xpath("(//label[text()='Search'])[2]/following::input"));
		search.click();
		search.sendKeys(number, Keys.ENTER);
	}

}
