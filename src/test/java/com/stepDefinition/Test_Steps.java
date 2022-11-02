package com.stepDefinition;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageForPageObject.LoginPage;

public class Test_Steps {
	static LoginPage lg;
	
	public static WebDriver driver;
	//public String ExpectedOutput="Hello vasuvespag!";
	
	@Given("User is on HotelApp homepage")
	public void user_is_on_hotel_app_homepage() {
		System.setProperty("webdriver.chrome.driver", "C:\\Naman\\chromedriver102win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://adactinhotelapp.com");
		driver.manage().window().maximize();
		lg = new LoginPage(driver);
	}

	@When("User enters Username")
	public void user_enters_username() {
//		driver.findElement(By.id("username")).clear();
//		driver.findElement(By.id("username")).sendKeys("vasuvespag");
		
		lg.Enter_username("vasuvespag");
		System.out.println("USER ENTER THE USRER NAME !");
	}

	@When("User enters Password")
	public void user_enters_password() {
//		driver.findElement(By.name("password")).clear();
//		driver.findElement(By.name("password")).sendKeys("vasu1234");
		lg.Enter_passWord("vasu1234");
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
//		driver.findElement(By.className("login_button")).click();
		lg.Click_Login_btn();
	}

	@Then("Login is Successful")
	public void login_is_successful() {
//		WebElement Greeting = driver.findElement(By.name("username_show"));
//		String actualOutput = Greeting.getAttribute("value");
//		assertEquals(ExpectedOutput, actualOutput);
		System.out.println("------------------------LOGIN SUCCESSFULLY------------------------");
		
	}
	

	@When("User selects location from dropdown")
	public void user_selects_location_from_dropdown() {
		new Select(driver.findElement(By.name("location"))).selectByIndex(2);
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() {
		driver.findElement(By.name("Submit")).click();
	}

	@Then("List of hotels is displayed")
	public void list_of_hotels_is_displayed() {
		String expectedOutput = "Adactin.com - Select Hotel";
	    String actualTitle = driver.getTitle();
	    assertEquals(expectedOutput,actualTitle);
	}
		
	@When("User selects a radio button")
	public void user_selects_a_radio_button() {
		driver.findElement(By.xpath("//*[@id=\"radiobutton_1\"]")).click();
	}

	@When("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		driver.findElement(By.id("continue")).click();
	}

	@Then("Book a hotel is displayed")
	public void book_a_hotel_is_displayed() {
		String expectedTitle="Adactin.com - Book A Hotel";
		String actualTitle=driver.getTitle();
		assertEquals(expectedTitle, actualTitle);
	}
	
	
	@When("User enters Username {string}")
	public void user_enters_username(String string) {
		WebElement uname = driver.findElement(By.id("username"));
		uname.clear();
		uname.sendKeys(string);
	}
	
	@When("User enters Password {string}")
	public void user_enters_password(String string) {
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(string);
	}
	
	
	@When("User enters Username as <{string}>")
	public void user_enters_username_as(String string) {
		WebElement uname = driver.findElement(By.id("username"));
		uname.clear();
		uname.sendKeys(string);
	    
	}
	
	@When("User enters Password as <{string}>")
	public void user_enters_password_as(String string) {
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(string);
	   
	}
	
	
	@When("User enters Username and Password")
	public void user_enters_username_and_password(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> data1:data) {
			String userName=data1.get("username");
			WebElement uname=driver.findElement(By.id("username"));	
			uname.clear();
			uname.sendKeys(userName);
			String password=data1.get("password");
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys(password);
		}
		
		
	}

		
}

	
	