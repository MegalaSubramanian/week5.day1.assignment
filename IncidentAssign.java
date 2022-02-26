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


public class IncidentAssign extends IncidentBaseClass{

	@Test
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

}
