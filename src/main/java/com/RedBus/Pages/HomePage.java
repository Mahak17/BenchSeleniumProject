package com.RedBus.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	
	public static WebDriver driver;
	
	public HomePage (WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	@FindBy (how = How.ID, using = "redBus")
	WebElement redBus;
	
	@FindBy (how = How.ID, using = "rYde")
	WebElement ride;
	


public void clickBusTicket() {
	
	redBus.click();
}
	
public void clickOnRideButton() {
	ride.click();
}
}


