package com.RedBus.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	public static void takeScreenShot(WebDriver driver, String FailCases) {
		//String screenshotFileName = System.getProperty("user.dir") + "\\Screenshots\\"+FailCases+".jpg";
		//File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(srcFile, new File("./Screenshots/"+FailCases+".png"));
			

		} catch (IOException e) {

		// TODO Auto-generated catch block

		System.out.println("Exception while taking ss" +e.getMessage());

		}
			

		}
		}


