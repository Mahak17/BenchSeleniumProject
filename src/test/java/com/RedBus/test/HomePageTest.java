package com.RedBus.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.RedBus.Pages.HomePage;
import com.relevantcodes.extentreports.model.Log;

public class HomePageTest extends BaseTest {
	
	@Test
	public void whenUserclickOnRedBusLogo() throws InterruptedException
	{
		
		log.info("Verify the title for Test Case 1");
		HomePage homepage = new HomePage (driver);
		
		homepage.clickBusTicket();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(),"Online Bus Ticket Booking with best offers - redBus");
//		//log.info(driver.getTitle()+ " driver get the title");
	//Log.info(driver.getTitle() + " Get the title");
		log.info(driver.getTitle() + "Get the title");
		
		//System.out.println ("Hello ")
	}
	
	
	@Test
	public void whenClickOnRide() {
		
		log.info("Verify the title for Test Case 2");
		HomePage homepage = new HomePage (driver);
		homepage.clickOnRideButton();
		Assert.assertFalse(driver.getTitle().contains("Ryde: Car Rentals"));
		log.info(driver.getTitle() + "Get the title");
	}

}
