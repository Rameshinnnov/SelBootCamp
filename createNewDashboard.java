package testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class createNewDashboard {

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String appURL="https://login.salesforce.com/";
		String name="Ramesh";
		String testcase;
		
		WebDriver driver;
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
		driver.findElement(By.xpath("//*[@class='searchBar slds-form-element']")).sendKeys("Dashboards");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
		Thread.sleep(12000);
//		WebElement ele1=driver.findElement(By.xpath("//p[text()='Dashboards']"));
//		driver.executeScript("arguments[0].scrollIntoView();", ele1);
//		driver.executeScript("arguments[0].click()", ele1);
		
		//Step4 - Click on the New Dashboard option
		driver.findElement(By.xpath("//div[@title='New Dashboard']")).click();
		Thread.sleep(12000);
		
		//Step5 - Enter Name as 'Salesforce Automation by Your Name ' and Click on Create
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='dashboardNameInput']")).sendKeys(name);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='submitBtn']")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		
		//Step6 - Click on Save and Verify Dashboard name
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		System.out.println("Saved");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		System.out.println("Done");
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		WebElement n = driver.findElement(By.xpath("//span[text()='"+name+"']"));
		if (n.getText().equals("Ramesh"))
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


