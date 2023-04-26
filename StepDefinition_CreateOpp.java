package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition_CreateOpp 
{
	public ChromeDriver driver;
	String oppName;
	@Given ("Launch Browser and load the sales url an maximize screen")
	public void launch() 
	{
		ChromeOptions apt=new ChromeOptions();
		apt.addArguments("--disable-notifications");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	@And ("Enter the username as {string}")
	public void username(String name)
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(name);
		
	}
	
	@And ("Enter the password as {string}")
	public void password(String password)
	{
		driver.findElement(By.xpath("//input[@name='pw']")).sendKeys(password);
		
	}
	
	@And ("click on LoginButton")
	public void login()
	{
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		
	}
	
	@And ("click on App Launcher")
	public void appLauncher()
	{
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
	}
	
	@And ("click on View All")
	public void viewAll() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
	}
	
	@When ("click on Sales")
	public void sales() throws InterruptedException
	{
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(2000);
		
	}
	
	@And ("click on Opportunities")
	public void oppLink()
	{
		WebElement click = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click()", click);
		
	}
	
	@And ("click on New Button")
	public void newButton() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@class='forceActionLink']")).click();
		Thread.sleep(3000);
		
	}
	
	@And ("Enter the opportunities name as Salesforce Automation By Santhya")
	public void oppName()
	{
		WebElement name = driver.findElement(By.xpath("(//div[@class='slds-form-element__control slds-grow']/input)[2]"));
		name.sendKeys("Salesforce Automation By Santhya");
		 oppName = name.getText();
		System.out.println(oppName);
		
	}
	
	@And ("Enter Date as {string}")
	public void date(String date)
	{
		driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).sendKeys(date);
		
		
	}
	
	@And ("Enter stage as Need Analysis")
	public void stage() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input slds-input_faux')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		
	}
	
	@And ("click on save button")
	public void save()
	{
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
	}
	
	@Then ("verify opportunity created successfully")
	public void verify() throws InterruptedException
	{
		Thread.sleep(3000);
		String afterName = driver.findElement(By.xpath("//lightning-formatted-text[text()='Salesforce Automation By Santhya']")).getText();
		System.out.println(afterName);
		if(oppName.equals(afterName))
		{
			System.out.println("Name verified sucessfully");
		}
		else
		{
			System.out.println("Name verification not matched");
		}
		driver.close();

	}

}
