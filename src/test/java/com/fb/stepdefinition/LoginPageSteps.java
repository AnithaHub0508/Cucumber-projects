package com.fb.stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.it.Data;
import io.cucumber.datatable.DataTable;
import junit.framework.Assert;


public class LoginPageSteps{
	
	WebDriver driver;
	@Given("User is on Registration page")
	public void user_is_on_Registration_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anitha\\eclipse-workspace\\Live\\src\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		
	    
	}

	@When("User enters the details")
	public void user_enters_the_details(io.cucumber.datatable.DataTable data) throws AWTException {
	 
	
	List<String> ae=data.asList();
	
	  driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(ae.get(0));
	  driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(ae.get(1));
	  driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys(ae.get(2));
	  driver.findElement(By.xpath("//input[@type='email']")).sendKeys(ae.get(3));;
	  driver.findElement(By.xpath("//input[@type='tel']")).sendKeys(ae.get(4));
	  WebElement gen = driver.findElement(By.xpath("//input[@value='FeMale']"));
	 gen.click();
	 WebElement hby = driver.findElement(By.id("checkbox2"));
	 hby.click();
	 
	 WebElement skl = driver.findElement(By.id("Skills"));
	 Select s=new Select(skl);
	 s.selectByVisibleText("Android");
	 WebElement coun = driver.findElement(By.id("countries"));
	 Select a=new Select(coun);
	 a.selectByVisibleText("Australia");
	 	  
	 WebElement c = driver.findElement(By.xpath("//span[@aria-labelledby='select2-country-container']"));
	 c.click();
	 Robot r=new Robot();
	 r.keyPress(KeyEvent.VK_DOWN);
	 r.keyRelease(KeyEvent.VK_DOWN);
	 r.keyPress(KeyEvent.VK_ENTER);
	 r.keyRelease(KeyEvent.VK_ENTER);
	 WebElement yr = driver.findElement(By.id("yearbox"));
	 Select b=new Select(yr);
	 b.selectByVisibleText("1916");
	 WebElement mo = driver.findElement(By.xpath("//select[@placeholder='Month']"));
	 Select d=new Select(mo);
	 d.selectByVisibleText("January");
	 WebElement da = driver.findElement(By.id("daybox"));
	 Select e1=new Select(da);
	 e1.selectByVisibleText("2");
	  driver.findElement(By.id("firstpassword")).sendKeys(ae.get(5));
	 
	  driver.findElement(By.id("secondpassword")).sendKeys(ae.get(6));
	 
	 WebElement btn = driver.findElement(By.id("submitbtn"));
	 btn.click();
	 System.out.println("done");
	 
	 }

	@Then("verify url contains Register")
	public void verify_url_contains_Register() {
		Assert.assertTrue(driver.getCurrentUrl().contains("automationtesting"));
	    
	}


}
	

