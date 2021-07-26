package testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class editDashboard {

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String appURL="https://login.salesforce.com/";
		String name="Salesforce";
		String testcase;
		
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
//		WebElement ele1=driver.findElement(By.xpath("//p[text()='Dashboards']"));
//		driver.executeScript("arguments[0].scrollIntoView();", ele1);
//		driver.executeScript("arguments[0].click()", ele1);
		
		//Step5 - Search the Dashboard 'Salesforce Automation by Your Name'
		driver.findElement(By.xpath("//input[starts-with(@class,'search-text-field slds-input')]")).sendKeys("Ramesh");
		Thread.sleep(2000);
		
		WebElement e1=driver.findElement(By.xpath("(//a[@title='Ramesh'])[1]"));
		driver.executeScript("arguments[0].click();", e1);
		Thread.sleep(5000);
		
		//Step6 - Click on the Dropdown icon and Select Edit
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_neutral edit']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		//Step7 - Click on the Edit Dashboard Properties icon
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@class='slds-form-element editTitle']//button")).click();
		Thread.sleep(5000);
		
		//Step8 - Enter Description as 'SalesForce' and click on save
		driver.findElement(By.id("edit-dashboard-title")).clear();
		driver.findElement(By.id("edit-dashboard-title")).sendKeys("Salesforce");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		System.out.println("Saved");
		Thread.sleep(5000);
		
		//Step9:Click on Done and  Click on save in the popup window displayed.
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		System.out.println("Done");
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		
		//Step10:Verify the Description
		driver.switchTo().frame(0);
		WebElement n = driver.findElement(By.xpath("//span[text()='"+name+"']"));
		if (n.getText().equals("Salesforce"))
		{
			testcase="Successful";
		}
		else
		{
			testcase="Failed";
		}
		System.out.println(testcase);
		driver.switchTo().defaultContent();
		driver.quit();
		
		}
	

	}


