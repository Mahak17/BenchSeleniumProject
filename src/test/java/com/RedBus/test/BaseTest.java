package com.RedBus.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import com.RedBus.utilities.ExtentReport;
import com.RedBus.utilities.Screenshot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest extends ExtentReport {
	
	//ExtentTest: By using this class we could generate the logs in the report
    public static ExtentTest test;
	
	// EXTENT REPORTS: By using this class we set the path where our reports need to generate.
	public static ExtentReports extent;
	
	// To initialize, select(Firefox, Chrome, IE), open and quit browser.
    public static WebDriver driver;
    
    public static Properties prop = new Properties();
	public static File file = new File("./Resources/configuration.properties");
	public static FileInputStream fis = null;
	public final static Logger log = Logger.getLogger(BaseTest.class);
	

	// Creating and using properties file
		static { 

			// Exception Handling for FIS
			try {

				fis = new FileInputStream(file);
			}catch(FileNotFoundException e){

			}

			// Exception Handling for Prop
			try {

				prop.load(fis);
			}catch(IOException e) {

			
			}
		}
		
		
@BeforeMethod
		public static void Initializer() {
				
				 String browsername = prop.getProperty("browser");
				 

					// Set a mode in which the code is supposed to run 
					
					String runOption = prop.getProperty ("runoption");
					System.out.println("Option for running the program is : " + runOption);
					
					if (browsername.equals("chrome")) {
						
						//System.setProperty("webdriver.chrome.driver",prop.getProperty("chromePath"));
						System.setProperty("webdriver.chrome.driver",prop.getProperty("chromePath"));
						if (runOption.equalsIgnoreCase("headless")) {
							//Create object of ChromeOption  Class
							ChromeOptions options = new ChromeOptions();
							options.addArguments("--remote-allow-origins=*");
							 //Set the SetHeadless is equal to true which will run test in Headless mode
							options.setHeadless (true);
							driver = new ChromeDriver (options);
						}
					
						else {
							ChromeOptions options = new ChromeOptions();
							options.addArguments("--remote-allow-origins=*");
							
							
							//ChromeDriverService options = null;
							driver = new ChromeDriver(options);
							
						}
					}
					else if (browsername.equals("edge")){
						
						//System.out.println (ReadingPropertiesFile.getProperty("IEPath"));
						System.setProperty("webdriver.edge.driver", prop.getProperty("edgePath"));
						driver = new EdgeDriver();
						driver.manage().window().maximize();
						
					}
			
					else if (browsername.equals("firefox")){
					
					System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxPath"));
					driver  = new FirefoxDriver();
					}
					
					else
						System.out.println("Browser not present...");
				}


				 

				@BeforeMethod
					public static void openBrowser(){
					       // driver.get("https://demo.guru99.com/test/newtours/");   // get url 
							//prop.getProperty("url");
					  driver.get(prop.getProperty("url"));
					  //driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("globalWait")), TimeUnit.SECONDS);
					 // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("globalWait"))));	
					  driver.manage().window().maximize();
					  driver.manage().deleteAllCookies();
					 
						}
				
				public void beforeMethod(Method method) {
					
					test = extent.startTest(method.getName());
					System.out.println ("Name of the method we get :"+ method.getName());
				}
						
				@AfterMethod

				public static void closeBrowser(ITestResult result) {
					
					if(ITestResult.FAILURE==result.getStatus())
					{
						Screenshot.takeScreenShot(driver, result.getName());
					}
					
					driver.quit();
					
				}

			}


			




