package testcases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class sortDashboardAscending {

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String appURL="https://login.salesforce.com/";
//		String name="Ramesh";
		String testcase;
		List<String> e1= new ArrayList<String>();
		
		RemoteWebDriver driver;
		ChromeOptions options= new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		
		
		options.addArguments("--disable-notifications");
		
		driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		
		
		//Step1 - Login
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
		driver.findElement(By.id("Login")).click();
		
		//Step2 - Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
		//Step3 - Click View All and click Dashboards from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(5000);
		
		//Step4 - Click on the Dashboards tab
		driver.findElement(By.xpath("//*[@class='searchBar slds-form-element']")).sendKeys("Dashboards");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
		Thread.sleep(12000);
		
		//Step5 - Click the sort arrow in the Dashboard Name.
		//create an empty list
		//Collect all webelements in list and get its text to store in the list using foreach
		//go to UI collect first and last element
		//compare with list and confirm if its sorted
		
		List<WebElement> e=driver.findElements(By.xpath("//th[@data-label='Dashboard Name']"));
//		driver.executeScript("arguments[0].scrollIntoView();", e);
		for(WebElement name:e)
		{
//			List<String> e1= new ArrayList<String>();
			e1.add(name.getText());
		}
		
		driver.executeScript("window.scrollBy(0,1000)");
		
		
		for(String name1:e1) {
			System.out.println(name1);
		}
		
//		driver.findElement(By.xpath("//span[@title='Dashboard Name']")).click();
//		Thread.sleep(3000);
		
		//Step6- Verify the Dashboard displayed in ascending order by Dashboard name.
		
		
		
		//		driver.quit();
		
		
		}
	

	}


