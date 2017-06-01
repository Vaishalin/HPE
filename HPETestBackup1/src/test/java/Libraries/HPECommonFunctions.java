package Libraries;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.apache.poi.hwpf.usermodel.DateAndTime;
import org.junit.Assert;
import org.junit.runners.AllTests;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.seleniumhq.jetty7.util.log.Log;
import org.testng.SkipException;
import org.testng.log4testng.Logger;

import bsh.ParseException;

import com.gargoylesoftware.htmlunit.javascript.host.ScreenOrientation;
import com.google.common.base.Function;
//import com.perfectomobile.PerfectoLabUtils;
import com.perfectomobile.httpclient.utils.FileUtils;
import com.perfectomobile.selenium.MobileCoordinates;
import com.perfectomobile.selenium.MobileDriver;
import com.perfectomobile.selenium.MobilePoint;
import com.perfectomobile.selenium.api.IMobileWebDriver;
import com.perfectomobile.selenium.by.ByMobile;
import com.perfectomobile.selenium.options.MobileDeviceVital;
import com.perfectomobile.selenium.options.rotate.MobileDeviceRotateOptions;
import com.perfectomobile.selenium.options.rotate.MobileDeviceRotateState;

import java.util.Calendar;
import Regression_Utilities.BaseClassHPE;
//import Regression_Utilities.XLS_Reader;


public class HPECommonFunctions extends HPEOperations

{

	public static IMobileWebDriver visualdriver = device.getVisualDriver();
	public static IMobileWebDriver nativedriver = device.getNativeDriver();
	public static IMobileWebDriver domdriver = device.getDOMDriver();
	//public static WebDriver driver =null;
	public static String VersionNo=null;
	public static MobileDriver driver = null; //Interface for getting device,provides methods for uploading and downloading items to/from the media repository, downloading the execution report
	public static String Device_Model=device.getProperty("Model");
	public static String EndCustomerName=null;
	public static String WatchListNumber1=null;	
	public static String WatchListResult1=null;
	public static Date parsedDate = null;
	public static Assert softAssert = null;
	private static final MobileDeviceRotateOptions Landscape = null;
	private static final MobileDeviceRotateOptions Portrait = null; 
	
	private static ScreenOrientation LANDSCAPE = null;
	private static ScreenOrientation PORTRAIT = null;
	
	
    //start of screen
    public static void screen() throws Exception
    {
    	System.out.println("****************************************************************************");
        
    }
    
	//Method to capture screenshot
		public static void CaptureScreenshot(String TCNo) throws Exception
	    {
			if ((config.getProperty("device_iOS"))!=null)
		       {
		           driver = new MobileDriver();
		           device=driver.getDevice(config.getProperty("device_iOS"));
		           System.out.println("Taking Screenshot of failed Test Case");
		           //File scrFile = driver.getDevice((config.getProperty("device_iOS").getScreenshotAs(OutputType.FILE);
		           File scrFile = device.getScreenshotAs(OutputType.FILE);
		           
		           try 
		           {
		                 System.out.println("Entered TRY of Screenshot ");
		                 FileUtils.copyFile(scrFile, new File("C:\\HPE\\FunctionalTesting\\FailedScreenshots\\"+ TCNo +" " + System.currentTimeMillis() +".jpg"));
		                 System.out.println("Screenshot captured sucessfully");
		           } catch (IOException e) {
		                 System.out.println(e.getMessage());
		           }
		       }
			else
			{
	           driver = new MobileDriver();
	           device=driver.getDevice(config.getProperty("device_AN"));
	           System.out.println("Taking Screenshot of failed Test Case");
	           //File scrFile = driver.getDevice((config.getProperty("device_iOS").getScreenshotAs(OutputType.FILE);
	           File scrFile = device.getScreenshotAs(OutputType.FILE);
	           
	           try 
	           {
	                 System.out.println("Entered TRY of Screenshot ");
	                 FileUtils.copyFile(scrFile, new File("C:\\HPE\\FunctionalTesting\\FailedScreenshots\\"+ TCNo +" " + System.currentTimeMillis() +".jpg"));
	                 System.out.println("Screenshot captured sucessfully");
	           } catch (IOException e) {
	                 System.out.println(e.getMessage());
	           }
			}
	    }
		
		/*
		//change orientation to landscape from portrait
				public static void Rotate_Device_Portrait() throws Exception
				{
					Thread.sleep(5000);		
								try{
						
						Orient=device.getOrientation();
						System.out.println("Device Orientation is in  ");
						System.out.println(Orient); 
										
						  if (Orient.value().equals(ScreenOrientation.PORTRAIT.value()))
									
					{
						Thread.sleep(5000);
						System.out.println("Device is already in Portrait mode");
									
					}
						else
						{
							System.out.println("Device Orientation will be changed to Portrait mode1");
							device.rotate(Portrait);
						}
					}
					catch(Exception e)
					{
						System.out.println("Device Orientation will be changed to Portrait mode");
						device.rotate(Portrait);
					
					}
				}
				*/
				
				/*
				//change orientation to landscape from portrait
				public static void Rotate_Device_Landscape() throws Exception
				{
					Thread.sleep(5000);		
								try{
						
						Orient=device.getOrientation();
						System.out.println("Device Orientation is in  ");
						System.out.println(Orient); 
										
						  if (Orient.value().equals(ScreenOrientation.LANDSCAPE.value()))
									
					{
						Thread.sleep(5000);
						System.out.println("Device is already in Landscape mode");
									
					}
						else
						{
							System.out.println("Device Orientation will be changed to Landscape mode1");
							device.rotate(Landscape);
						}
					}
					catch(Exception e)
					{
						System.out.println("Device Orientation will be changed to Landscape mode");
						device.rotate(Landscape);
					
					}
				}
				
				*/
		//Method to open to HPE application
	    public static void Open_App_HPE() throws Exception
			      {
			    	if(Device_Model.contains("Pixel"))
			    	{
			    		Open_App_HPE_AN();
			    	}else if(Device_Model.contains("iPad"))
			    	{
			    		//HPECommonFunctions.Rotate_Device_Portrait();
			  			//Thread.sleep(2000);
			    		Open_App_HPE_iOS_iPad();
			    	}else if(Device_Model.contains("Tab"))
			    	{
			    		Open_App_HPE_AN();
			    	}else if (Device_Model.contains("Galaxy S7"))
                    {
                        Open_App_HPE_AN();
                    }else

			    	{
			    		Open_App_HPE_iOS();
			    	}
			    	          
			      }
		
		
		//Method to Open HPE Application
	    public static void Open_App_HPE_iOS() throws Exception
	    {
          
	    	
	    	try
          {
	    	  Thread.sleep(5000);
        	  //nativedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        	  device.getNativeDriver(config.getProperty("AppName")).open();  	  
    	  	  Thread.sleep(2000);
    	  	  System.out.println("Opened HPE-Go application");  	  
    	  	  Thread.sleep(5000);
        	  
          }catch (Exception e)
          {
        	  HPEOperations.Install_App_HPE_GO_iOS();
        	  //Thread.sleep(5000);
        	  nativedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        	  device.getNativeDriver(config.getProperty("AppName")).open();  	  
        	  nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	  	  System.out.println("Opened HPE-Go application");  	  
    	  	
          }
          /*
	  	  
	    	
	    	nativedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      	  device.getNativeDriver(config.getProperty("AppName")).open();  	  
  	  	  Thread.sleep(2000);
  	  	  System.out.println("Opened HPE-Go application");  	  
  	  	  Thread.sleep(2000);
  	  	  
  	  	  */
	     } 
	    
	    
		//Method to Open HPE Application
	    public static void Open_App_HPE_iOS_iPad() throws Exception
	    {
          
	    	
	    	try
          {
	    		Thread.sleep(2000);
        	  //nativedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        	  device.getNativeDriver(config.getProperty("AppName")).open();  	  
    	  	  Thread.sleep(2000);
    	  	  System.out.println("Opened HPE-Go application");  	  
    	  	  Thread.sleep(2000);
        	  
          }catch (Exception e)
          {
        	  HPEOperations.Install_App_HPE_GO_iPad();
        	  //Thread.sleep(5000);
        	  nativedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        	  device.getNativeDriver(config.getProperty("AppName")).open();  	  
        	  nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	  	  System.out.println("Opened HPE-Go application");  	  
    	  	
          }
          /*
	  	  
	    	
	    	nativedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      	  device.getNativeDriver(config.getProperty("AppName")).open();  	  
  	  	  Thread.sleep(2000);
  	  	  System.out.println("Opened HPE-Go application");  	  
  	  	  Thread.sleep(2000);
  	  	  
  	  	  */
	     } 
	    
	
		//Method to close HPE Application
	    public static void Close_App() throws Exception
	    {
	       	  device.getNativeDriver(config.getProperty("AppName")).close();  	  
	      	  Thread.sleep(2000);
	      	  System.out.println("Closed HPE-Go application");  	  
	      	  Thread.sleep(2000);
	      	  
	      }
	    
	    
	//Method to Open HPE Application
    public static void Open_App_HPE_AN() throws Exception
    {
      try
      {
    	  
    	  Thread.sleep(2000);
    	  device.getNativeDriver(config.getProperty("AppName")).open();  	  
      	  Thread.sleep(2000);
      	  System.out.println("Opened HPE-Go application");  	  
      	  Thread.sleep(2000);
      	  
      }catch(Exception e)
  	  {
    	 
    	 
    	  HPEOperations.Install_App_HPE_GO_AN();
    	  Thread.sleep(2000);
    	  device.getNativeDriver(config.getProperty("AppName")).open();  	  
      	  Thread.sleep(2000);
      	  System.out.println("Opened HPE-Go application");  	  
      	  Thread.sleep(2000);
    	  
  	  }
     }    
	
	//Method to Close HPE Application
    public static void Close_App_HPE() throws Exception
    {

  	  device.getNativeDriver(config.getProperty("AppName")).close();  	  
  	  Thread.sleep(2000);
  	  System.out.println("Closed HPE-Go application");  	  
  	  Thread.sleep(20000);
     }
	
	public static void EnterUserName(String Username) throws Exception
	{
		/*
		Thread.sleep(2000);
		WebElement UNElement; 
		WebDriverWait wait = new WebDriverWait(nativedriver, 20);
		//SearchResultiphone= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(iOS_Objects.getProperty("SearchResultiPhone"))));
		UNElement= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Android_Objects.getProperty("UserID"))));
		UNElement.click();
		Thread.sleep(2000);
		UNElement.sendKeys(Username);
		System.out.println("Entered Username");
		Thread.sleep(3000);
		
		//Actions action=new Actions(nativedriver);
		//action.sendKeys("Some text");
		*/
		
		Thread.sleep(5000);
		//nativedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement UNElement = nativedriver.findElement(By.xpath(Android_Objects.getProperty("UserID")));
		//WebElement UNElement = nativedriver.findElement(By.id(Android_Objects.getProperty("UserIDAN")));
		Thread.sleep(2000);
		//nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		UNElement.click();
		Thread.sleep(1000);
		
		//Actions action=new Actions(nativedriver);
		//action.sendKeys("Some text");
		 
		UNElement.sendKeys(Username);
		System.out.println("Entered Username");
		Thread.sleep(3000);
		
		
		
		
	
	}
	
	public static void EnterUserName_AN(String Username) throws Exception
	{
		
	nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement UNElement = nativedriver.findElement(By.xpath(Android_Objects.getProperty("UserID")));
	//WebElement UNElement = nativedriver.findElement(By.id(Android_Objects.getProperty("UserIDAN")));
	Thread.sleep(5000);
	UNElement.click();
	Thread.sleep(5000);	
	UNElement.sendKeys(Username);	
	System.out.println("Entered Username");
	Thread.sleep(5000);	
	/*
	nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement UNElement1 = nativedriver.findElement(By.xpath(Android_Objects.getProperty("UserID")));
	JavascriptExecutor myExecutor = ((JavascriptExecutor) nativedriver);
	myExecutor.executeScript("arguments[0].value='Kirtesh';", UNElement1);
	*/
	
	}
	
	//Enter Password in Password Field for Android
			public static void EnterPassword_AN(String Password) throws Exception
				{
				
					nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				    WebElement PWDElement = nativedriver.findElement(By.xpath(Android_Objects.getProperty("PasswordAN")));
					Thread.sleep(1000);			
					PWDElement.click();			
					Thread.sleep(1000);
					//PWDElement.clear();
					PWDElement.sendKeys(Password);
					System.out.println("Entered Password");
					Thread.sleep(5000);
				
				
				
				}
			
			//Enter Password in Password Field for iOS 
			public static void EnterPassword_iOS(String Password) throws Exception
				{
				
				    WebElement PWDElement = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("PasswordiOS")));
					Thread.sleep(1000);			
					PWDElement.click();			
					Thread.sleep(1000);
					//PWDElement.clear();
					PWDElement.sendKeys(Password);
					System.out.println("Entered Password");
					nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
					
				
				}
					
			// Method to Enter wrong password
            
            public static void EnterPassword() throws Exception
            {
                   if(Device_Model.contains("iPhone"))
                   {
                          EnterPassword_iOS(config.getProperty("Password"));
                   } else
                   {
                	   EnterPassword_AN(config.getProperty("Password"));
                   }
                                                            
            }
		
		//Method to Click on Sign In Button for iOS
		public static void ClickSignIn_iOS() throws Exception
		{
		WebElement SignInElement = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("SignInIpad")));
		Thread.sleep(2000);
		SignInElement.click();
		try
		{
			CheckServiceError("C://HPE//FunctionalTesting//Images//ServiceErrorOK" +".png");
			
				        
		}catch (Exception e)
		
		{
			try{
				HPECommonFunctions.VerifyErrorMessage(config.getProperty("Access_Denied"));
			}catch(Exception e1)
			{
				Thread.sleep(5000);
				System.out.println("Clicked on SignIn without any error");
			}
		}
}
	
		
		//Method to Click on Sign In Button for Android
		public static void ClickSignIn_AN() throws Exception
		{
			
			//device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("51,87")));
			
			Thread.sleep(2000);
			WebElement SignInElement = nativedriver.findElement(By.xpath(Android_Objects.getProperty("SignIn")));
			Thread.sleep(2000);
			SignInElement.click();
		try
		{
			CheckServiceError("C://HPE//FunctionalTesting//Images//ServiceErrorOK" +".png");
			
				        
		}catch (Exception e)
		
		{
			try{
				HPECommonFunctions.VerifyErrorMessage(config.getProperty("Access_Denied"));
			}catch(Exception e1)
			{
				Thread.sleep(5000);
				System.out.println("Clicked on SignIn without any error");
			}
		}
}
		
		
		//Method to Click on Sign In Button for Android
				public static void ClickSignIn1_AN() throws Exception
				{
					
					if (Device_Model.contains("Pixel"))
                    {
                    //device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("51,87")));
                    
                    Thread.sleep(2000);
                    WebElement SignInElement = nativedriver.findElement(By.xpath(Android_Objects.getProperty("SignIn")));
                    Thread.sleep(2000);
                    SignInElement.click();
                    } else if (Device_Model.contains("Galaxy S6"))
                    {
                           //device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("51,87")));
                           
                           Thread.sleep(2000);
                           WebElement SignInElement = nativedriver.findElement(By.xpath(Android_Objects.getProperty("SignIn")));
                           Thread.sleep(2000);
                           SignInElement.click();
                           } else        if (Device_Model.contains("Galaxy S6"))
                    {
                                  Thread.sleep(2000);
                                  
                                  HPECommonFunctions.ClickOnKeypadGoButton_AN("C://HPE//FunctionalTesting//Images//KeypadGoicon_GalaxyS7"+".png");

                    }

				try
				{
					CheckServiceError("C://HPE//FunctionalTesting//Images//ServiceErrorOK" +".png");
					
						        
				}catch (Exception e)
				
				{
					try{
						HPECommonFunctions.VerifyErrorMessage1(config.getProperty("Access_Denied"));
					}catch(Exception e1)
					{
						Thread.sleep(5000);
						System.out.println("Clicked on SignIn without any error");
					}
				}
		}
		
				
				public static void ClickOnKeypadGoButton_AN(String imagePath) throws Exception
                
                {
                  try
                  {
                             WebElement KeypadGo = visualdriver.findElement(ByMobile.image(imagePath));                              
                             KeypadGo.click();
                             testLog.info("\n Image found is : " + imagePath);
                             testLog.info("Clicked on Keypad Go button");
                       } catch (Exception e) {
                             testLog.info("\nImage not present : " + imagePath);    
                             testLog.info("Go button not present in the keypad");
                             status1 = 1;
                             //Assert.fail();
                             CaptureScreenshot("TC_Fail_");				
                             //ClickSignOut();
                             Close_App_HPE();
                             Thread.sleep(2000);
                             Assert.fail("Go button not present in the keypad");

                       }
              } 
				
				//Method to Click on Sign In Button for Android
				public static void ClickSignIn1_iOS() throws Exception
				{
					
					//device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("51,87")));
					
					Thread.sleep(2000);
					WebElement SignInElement = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("SignIn")));
					Thread.sleep(2000);
					SignInElement.click();
				try
				{
					CheckServiceError("C://HPE//FunctionalTesting//Images//ServiceErrorOK" +".png");
					
						        
				}catch (Exception e)
				
				{
					try{
						HPECommonFunctions.VerifyErrorMessage1(config.getProperty("Access_Denied"));
					}catch(Exception e1)
					{
						Thread.sleep(5000);
						System.out.println("Clicked on SignIn without any error");
					}
				}
		}
		
				
		
	/*
		
		// Method to Click on Sign In Button for Android
		
		public static void ClickSignIn_AN() throws Exception
		{
		WebElement SignInElementAN = nativedriver.findElement(By.xpath(Android_Objects.getProperty("SignIn")));
		Thread.sleep(2000);
		SignInElementAN.click();
		Thread.sleep(20000);
		System.out.println("Successfully Logged In");
		} 

		*/
	
		
		
		//Method to Verify Tutorial page when the user logs for the first time
				public static void VerifyTutorialPage_iOS() throws Exception
						{
							try
							{
								nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								WebElement Skip = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Skip")));
								if(!Skip.isDisplayed())
							{
								
									System.out.println("Tutorial page is displayed");
									Skip.click();
									System.out.println("Clicked on Skip");
									Thread.sleep(2000);
								
							}
							}
							catch(Exception e)
							{
								System.out.println("Tutorial page is not displayed");				
								
							}
						}
		
				//Method to Verify Tutorial page when the user logs for the first time
		        public static void VerifyTutorialPage_AN() throws Exception
		                    {
		                          
		        						SwipeUp();
		        	
		        				try
		                          {
		                                nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		                                WebElement Skip = nativedriver.findElement(By.xpath(Android_Objects.getProperty("Skip")));
		                                if(Skip.isDisplayed())
		                          {
		                                
		                                	  System.out.println("Tutorial page is displayed");
		                                      Skip.click();
		                                      System.out.println("Clicked on Skip");
		                                      Thread.sleep(2000);
		                                
		                          }
		                          }
		                          catch(Exception e)
		                          {
		                                System.out.println("Tutorial page is not displayed");                        
		                                
		                          }
		                    }

				//Method to click on skip on Tutorial page
		        public static void VerifyTutorialPage() throws Exception
					      {
					    	if(Device_Model.contains("iPhone"))
					    	{
					    		VerifyTutorialPage_iOS();
					    		
					    	}else
					    	{
					    		VerifyTutorialPage_AN();
					    	}
					    	          
					      }
					    
			    
		        
	
					
					
		//Method to click on Sign in button
		    public static void ClickSignIn() throws Exception
				      {
				    	if(Device_Model.contains("iPhone"))
				    	{
				    		ClickSignIn_iOS();
				    		
				    	}else if(Device_Model.contains("iPad"))
				    	{
				    		ClickSignIn_iOS();
				    		
				    	}else
				    	{
				    		ClickSignIn_AN();
				    	}
				    	          
				      }
				    
		    
		  //Method to click on Sign in button
		    public static void ClickSignIn1() throws Exception
				      {
				    	if(Device_Model.contains("iPhone"))
				    	{
				    		ClickSignIn1_iOS();
				    		
				    	}else
				    	{
				    		ClickSignIn1_AN();
				    	}
				    	          
				      }
				    
		
		//Method to Verify the Terms & Condition page when the user logs for the first time
		public static void VerifyTermsConditionPage() throws Exception
				{
					try
					{
					
					WebElement TandC = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Accept")));
					if(!TandC.isDisplayed())
					{
						System.out.println("Terms & Condition page is displayed");
						Thread.sleep(2000);
						SwipeUp();
						ClickDecline();
						
					}
					}
					catch(Exception e)
					{
						System.out.println("Terms & Condition page is not displayed");				
						CaptureScreenshot("TC_Fail_");				
						//ClickSignout();
						Close_App_HPE();
                        Thread.sleep(2000);
						Assert.fail("Terms & Condition page is not displayed");
					}
				}
					
				
		//Method to Swipe up the screen on Terms & Conditions page
		public static void SwipeUp_iOS() throws Exception
		{
		
		System.out.println("Swiping up on the screen");
		device.getMobileTouchScreen().swipe(new MobileCoordinates(new MobilePoint("353,1142")), new MobileCoordinates(new MobilePoint("373,359")), 1);
				
		Thread.sleep(5000);		
		
		}
		
		//Method to Swipe up the screen on Terms & Conditions page
		public static void SwipeUp_iOS_iPhone5S() throws Exception
		{
		
		System.out.println("Swiping up on the screen");
		device.getMobileTouchScreen().swipe(new MobileCoordinates(new MobilePoint("313,1058")), new MobileCoordinates(new MobilePoint("300,119")), 1);
				
		Thread.sleep(5000);		
		
		}
		
		//Method to Swipe up the screen on Terms & Conditions page for Android
				public static void SwipeUp_AN() throws Exception
				{
				
				System.out.println("Swiping up on the screen");
				device.getMobileTouchScreen().swipe(new MobileCoordinates(new MobilePoint("506,1580")), new MobileCoordinates(new MobilePoint("525,210")), 1);
				Thread.sleep(5000);		
				
				}
				
                public static void SwipeUp() throws Exception
                {
                       if(Device_Model.equals("iPhone-7"))
                       {
                    	   SwipeUp_iOS();
                       }else if(Device_Model.equals("iPhone-5S"))
                       {
                    	   SwipeUp_iOS_iPhone5S();
                       }else if(Device_Model.equals("iPhone-6S"))
                       {
                    	   SwipeUp_iOS();
                       }
                       else
                       {
                    	   SwipeUp_AN();
                       }
                }

				
		//Method to Verify the Decline button
		public static void VerifyDeclineButton_iOS() throws Exception
		{
			try
			{
			Thread.sleep(5000);
			WebElement Decline = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Decline")));
			if(!Decline.isDisplayed())
			{
				System.out.println("Decline button is Present");
				Thread.sleep(2000);
				
			}
			}
			catch(Exception e)
			{
				System.out.println("Decline button is not Present");				
				CaptureScreenshot("TC_Fail_");				
				//ClickSignOut();
				Close_App_HPE();
                Thread.sleep(2000);
				Assert.fail("Decline button is not Present");
			}
		}
		
		//Method to Verify the Decline button for Android
        public static void VerifyDeclineButton_AN() throws Exception
        {
               try
               {
               Thread.sleep(5000);
               WebElement Decline = nativedriver.findElement(By.xpath(Android_Objects.getProperty("Decline")));
               if(Decline.isDisplayed())
               {
                      System.out.println("Decline button is Present");
                      Thread.sleep(2000);
                      
               }
               }
               catch(Exception e)
               {
                      System.out.println("Decline button is not Present");                        
                      CaptureScreenshot("TC_Fail_");                         
                      //ClickSignOut();
                      Close_App_HPE();
                      Thread.sleep(2000);
                      Assert.fail("Decline button is not Present");
               }
        }

     // Method for Decline Button

        public static void VerifyDeclineButton() throws Exception
        {
               if(Device_Model.contains("iPhone"))
               { 
                      VerifyDeclineButton_iOS();
               }else if(Device_Model.contains("iPad"))
               { 
                   VerifyDeclineButton_iOS();
            }else
               {
                      VerifyDeclineButton_AN();
               }
               
        }

		
		//Method to Verify the Accept button for iOS
		public static void VerifyAcceptButton_iOS() throws Exception
		{
			try
			{
			Thread.sleep(5000);
			WebElement Accept = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Accept")));
			if(!Accept.isDisplayed())
			{
				System.out.println("Accept button is Present");
				Thread.sleep(2000);
				
			}
			}
			catch(Exception e)
			{
				System.out.println("Accept button is not Present");				
				CaptureScreenshot("TC_Fail_");				
				//ClickSignOut();
				Close_App_HPE();
                Thread.sleep(2000);
				Assert.fail("Accept button is not Present");
			}
		}
		
		//Method to Verify the Accept button for Android
        public static void VerifyAcceptButton_AN() throws Exception
        {
              try
              {
              Thread.sleep(5000);
              WebElement Accept = nativedriver.findElement(By.xpath(Android_Objects.getProperty("Accept")));
              if(Accept.isDisplayed())
              {
                     System.out.println("Accept button is Present");
                     Thread.sleep(2000);
                     
              }
              }
              catch(Exception e)
              {
                     System.out.println("Accept button is not Present");                         
                     CaptureScreenshot("TC_Fail_");                         
                     //ClickSignOut();
                     Close_App_HPE();
                     Thread.sleep(2000);
                     Assert.fail("Accept button is not Present");
              }
      }

      //Method to Verify on Accept option
        public static void VerifyAcceptButton() throws Exception
          {
           if(Device_Model.contains("iPhone"))
           {
                  VerifyAcceptButton_iOS();
           }else
           {
                  VerifyAcceptButton_AN();
           }
                     
          }

		
		//Method to Click Allow button
		public static void ClickAllowButton() throws Exception
		{
			try{
				CheckServiceError("C://HPE//FunctionalTesting//Images//ServiceErrorOK" +".png");
				//HPECommonFunctions.VerifyErrorMessage(config.getProperty("Access_Denied"));
		        //HPECommonFunctions.ClickClose();
			}
			catch (Exception e)
			{
				try
				{
					nativedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//Thread.sleep(10000);
			WebElement Allow = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Allow")));
			if(!Allow.isDisplayed())
			{
				System.out.println("Allow button is Present");
				Thread.sleep(5000);
				Allow.click();
				System.out.println("Allow button is Clicked");
				Thread.sleep(10000);
			}
			}
			catch(Exception e1)
			{
				System.out.println("User has already allowed the Location");				
				Thread.sleep(5000);
			}
			}
		}
		
		public static void ClickDecline_iOS() throws Exception
		{
		WebElement Decline = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Decline")));
		Thread.sleep(5000);
		Decline.click();
		System.out.println("Clicked on Decline button");
		Thread.sleep(10000);		
		
		}
		
		//Method to click Decline button in Android
        public static void ClickDecline_AN() throws Exception
        {
        WebElement Decline = nativedriver.findElement(By.xpath(Android_Objects.getProperty("Decline")));
        Thread.sleep(5000);
        Decline.click();
        System.out.println("Clicked on Decline button");
        Thread.sleep(10000);       
        
        }

     // Method to click Decline Button

        public static void ClickDecline() throws Exception
        {
               if(Device_Model.contains("iPhone"))
               { 
            	   ClickDecline_iOS();
               }else if(Device_Model.contains("iPad"))
               { 
            	   ClickDecline_iOS();
               }else
               {
            	   ClickDecline_AN();
               }
               
        }

		
		  //Method to click on Accept option
	    public static void ClickAccept() throws Exception
	      {
	    	if(Device_Model.contains("iPhone"))
	    	{
	    		ClickAccept_iOS();
	    	}else if(Device_Model.contains("iPad"))
	    	{
	    		ClickAccept_iOS();
	    	}else
	    	{
	    		ClickAccept_AN();
	    	}
	    	          
	      }
	    
	    
	    
		// Method to click Accept button in Android

        public static void ClickAccept_AN() throws Exception

        {

           try

           {
                  

          Thread.sleep(5000);
          WebElement Accept = nativedriver.findElement(By.xpath(Android_Objects.getProperty("Accept")));
          Thread.sleep(2000);
          if (Accept.isDisplayed())
          {
          Accept.click();
          Thread.sleep(10000);              
          System.out.println("Clicked on Accept button");
          }
            }catch (Exception e)

        {
               System.out.println("User has already accepted the Terms & Conditions");
        }   
       

    } 

		
		
		public static void ClickAccept_iOS() throws Exception
		{
		   try
		   {
			   /*
		     WebElement Accept; 
	         WebDriverWait wait = new WebDriverWait(nativedriver, 20);
	         //SearchResultiphone= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(iOS_Objects.getProperty("SearchResultiPhone"))));
	         Accept= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Android_Objects.getProperty("Accept"))));
	         Accept.click();
	         Thread.sleep(10000);	         
	         System.out.println("Clicked on Accept button");
	         */
	         
			 Thread.sleep(5000);
	         WebElement Accept = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Accept")));
	         Thread.sleep(2000);
	         if (!Accept.isDisplayed())
	         {
	         Accept.click();
	         Thread.sleep(5000);	         
	         System.out.println("Clicked on Accept button");
	         }
		    }catch (Exception e)
		{
			System.out.println("User has already accepted the Terms & Conditions");
		}   
		
		}	
	
		

//Method to click on Menu bar
public static void ClickMenuBar(String imagePath) throws Exception
{
	/*
	device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("51,87")));
	System.out.println("Clicked on Menu bar");
    Thread.sleep(10000); 
    */
	try
    	{
				nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				WebElement MenuBar = visualdriver.findElement(ByMobile.image(imagePath));					
				MenuBar.click();
				testLog.info("\n Image found is : " + imagePath);
				testLog.info("Clicked on menu bar");
				Thread.sleep(5000); 
			} catch (Exception e) {
				testLog.info("\nImage not present : " + imagePath);	
				testLog.info("3 Line menu bar is not found");
				status1 = 1;
				Close_App_HPE();
				Assert.fail("3 Line menu bar is not found");
			}
		
    
}

//Method to click on Menu bar
public static void ClickSignOut_iOS(String imagePath) throws Exception
{
	/*
	device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("51,87")));
	System.out.println("Clicked on Menu bar");
  Thread.sleep(10000); 
  */
	try
  	{
				nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				WebElement SignOut = visualdriver.findElement(ByMobile.image(imagePath));					
				SignOut.click();
				testLog.info("\n Image found is : " + imagePath);
				testLog.info("Clicked on Sign out");
			} catch (Exception e) {
				testLog.info("\nImage not present : " + imagePath);	
				testLog.info("Sign out button is not found");
				status1 = 1;
				Close_App_HPE();
				Assert.fail("Sign out button is not found");
			}
		
  
}

public static void ClickSignOut_iOS() throws Exception
{
	try{
			
			nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement Signout = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("SignOut")));
			Thread.sleep(5000);
			Signout.click();
			System.out.println("Clicked on Signout button");
			
		}catch (Exception e1)
		{
			
			System.out.println("Sign Out button is not Present");				
			CaptureScreenshot("TC_Fail_");	
			Close_App_HPE();
            Thread.sleep(2000);
			Assert.fail("Sign Out button is not Present");
			
		}
	}


public static void ClickSignOut2_iOS() throws Exception
{
	try
	
	{
		ClickMenuBar("C://HPE//FunctionalTesting//Images//MenuBar" +".png");
		ClickSignOut_iOS("C://HPE//FunctionalTesting//Images//SignOutiOS" +".png");
	
	}
catch (Exception e1)
{
	
	System.out.println("Sign Out button is not Present");				
	CaptureScreenshot("TC_Fail_");	
	Close_App_HPE();
	Thread.sleep(2000);
	Assert.fail("Sign Out button is not Present");
	
}
}

public static void ClickSignOut2_AN() throws Exception
{
	try
    
    {
           ClickMenuBar();
                        
           if (Device_Model.contains("Pixel"))
           {
                  ClickSignOut_AN("C://HPE//FunctionalTesting//Images//SignOut"+".png");
           } else if (Device_Model.contains("Galaxy S6"))
           {
                  ClickSignOut_AN("C://HPE//FunctionalTesting//Images//SignOut_Galaxy"+".png");
           } else if (Device_Model.contains("Galaxy S7"))
           {
                  ClickSignOut_AN("C://HPE//FunctionalTesting//Images//SignOut_GalaxyS7"+".png");
           }
           
    
    }

catch (Exception e1)
{
	
	System.out.println("Sign Out button is not Present");				
	CaptureScreenshot("TC_Fail_");	
	Close_App_HPE();
	Thread.sleep(2000);
	Assert.fail("Sign Out button is not Present");
	
}
}



public static void ClickSignOut1_iOS() throws Exception
{
	try
	
	{		
		ClickSignOut_iOS("C://HPE//FunctionalTesting//Images//SignOutiOS" +".png");
	
	}
catch (Exception e1)
{
	
	System.out.println("Sign Out button is not Present");				
	CaptureScreenshot("TC_Fail_");	
	Close_App_HPE();
	Thread.sleep(2000);
	Assert.fail("Sign Out button is not Present");
	
}
}

public static void ClickSignOut1_AN() throws Exception
{
    try
    
    {
           if (Device_Model.contains("Pixel"))
           { 
    ClickSignOut_AN("C://HPE//FunctionalTesting//Images//SignOut" +".png");
           } else if (Device_Model.contains("Galaxy S6"))
           {
           ClickSignOut_AN("C://HPE//FunctionalTesting//Images//SignOut_Galaxy" +".png");
    } else if (Device_Model.contains("Galaxy S7"))
    { ClickSignOut_AN("C://HPE//FunctionalTesting//Images//SignOut_GalaxyS7" +".png");
    }
                  
    }

catch (Exception e1)
{
	
	System.out.println("Sign Out button is not Present");				
	CaptureScreenshot("TC_Fail_");	
	Close_App_HPE();
	Thread.sleep(2000);
	Assert.fail("Sign Out button is not Present");
	
}
}


//Method to Click Sign Out button in Android
public static void ClickSignOut_AN(String imagePath) throws Exception
   {
	
	try {
		
		visualdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement Cancel = visualdriver.findElement(ByMobile.image(imagePath));					
		testLog.info("\n Image found is : " + imagePath);
		testLog.info("Sign Out Menu option is Present");
		Cancel.click();
		testLog.info("Clicked on Sign Out");
	} catch (Exception e) {
		testLog.info("\nImage not present : " + imagePath);	
		testLog.info("Sign Out Menu option is not Present"); 
		status1 = 1;
		//Assert.fail();
		CaptureScreenshot("TC_Fail_");				
		Close_App_HPE();
		Thread.sleep(2000);
		Assert.fail("Sign Out Menu option is not Present"); 

	}
        }



public static void ClickSignOut() throws Exception
{
       if(Device_Model.contains("iPhone"))
       {
              ClickSignOut2_iOS();
       } else
       {
              ClickSignOut2_AN();
       }
}


public static void ClickSignOut1() throws Exception
{
       if(Device_Model.contains("iPhone"))
       {
              ClickSignOut1_iOS();
       } else
       {
              ClickSignOut1_AN();
       }
}


	
		//Method to Click on Preferences
				public static void ClickPreferences_iOS() throws Exception
				{
					try
					{
					Thread.sleep(5000);
					WebElement Preferences = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Preferences")));
					if(!Preferences.isDisplayed())
					{
						
						Preferences.click();
						System.out.println("CLicked on Preferences");
						Thread.sleep(10000);
					}
					}
					catch(Exception e)
					{
						System.out.println("Preferences tab is not Present");				
						CaptureScreenshot("TC_Fail_");				
						ClickSignOut1();
						Close_App_HPE();
						Thread.sleep(2000);
						Assert.fail("Preferences tab is not Present");
					}
				}
				
				// Method to click on Preference menu option in Android
                public static void ClickPreference_AN(String imagePath) throws Exception
                {
                	Thread.sleep(3000);
                try
                       {
                WebElement PrefOption = visualdriver.findElement(ByMobile.image(imagePath));
                if(PrefOption.isDisplayed());           
                {
                PrefOption .click();
                testLog.info("\n Image found is : " + imagePath);
                testLog.info("Clicked on Preference Option");
                Thread.sleep(3000);
                 } 
                     }catch (Exception e) 
                       {
                testLog.info("\nImage not present : " + imagePath);    
                testLog.info("Preference menu option not found");
                status1 = 1;
                //Assert.fail();
                        }
                }

                
             // Method to verify on menu bar in Android
                public static void VerifyMenuBar_AN() throws Exception
                {
                try
                       {
                	WebElement MenuBar = nativedriver.findElement(By.xpath(Android_Objects.getProperty("Menu")));
                if(MenuBar.isDisplayed());           
                {
                	
                testLog.info("Menu bar is found");
                }
                       } catch (Exception e) 
                       {
                  
                testLog.info("Menu bar is not found");
                status1 = 1;
                //Assert.fail();
                        }
                }

             // Method to verify on menu bar in Android
                public static void ClickMenuBar_AN() throws Exception
                {
                try
                {
                	nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                	WebElement MenuBar = nativedriver.findElement(By.xpath(Android_Objects.getProperty("Menu")));
                if(MenuBar.isDisplayed());           
                {
                	MenuBar.click();
                testLog.info("Menu bar is Clicked");
                }
                       } catch (Exception e) 
                       {
                  
                testLog.info("Menu bar is not found");
                status1 = 1;
                //Assert.fail();
                        }
                }
                
				// Method to click on Preference menu option 
                
                public static void ClickPreference() throws Exception
                {
                       if(Device_Model.contains("iPhone"))
                 {
                              ClickPreferences_iOS();
                 } else if(Device_Model.contains("Pixel"))
                 {
                          ClickPreference_AN("C://HPE//FunctionalTesting//Images//Preferences"+".png");
                 
                }else if(Device_Model.contains("Galaxy S6"))
                {
                    ClickPreference_AN("C://HPE//FunctionalTesting//Images//Preferences_Galaxy"+".png");
                }else if(Device_Model.contains("Galaxy S7"))
                {
                	 ClickPreference_AN("C://HPE//FunctionalTesting//Images//Preferences_GalaxyS7"+".png");
                }
			}

				
				  //Method to Verify the Flag icon on Home page
			    public static void VerifyFlagIcon() throws Exception
			      {
			    	if(Device_Model.contains("iPhone"))
			    	{
			    		VerifyFlagIcon_iOS();
			    	}else if(Device_Model.contains("Tab"))
			    	{
			    		VerifyFlagIcon_AN("C://HPE//FunctionalTesting//Images//FlagIcon_Tab"+".png");
			    	}else  if(Device_Model.contains("Galaxy S6"))
                    {
                        VerifyFlagIcon_AN("C://HPE//FunctionalTesting//Images//FlagIcon_Galaxy"+".png");
                 } else if(Device_Model.contains("Galaxy S7"))
                 {
                        VerifyFlagIcon_AN("C://HPE//FunctionalTesting//Images//FlagIcon_GalaxyS7"+".png");
                 }else

			    	{
			    		VerifyFlagIcon_AN("C://HPE//FunctionalTesting//Images//FlagIcon_AN"+".png");
			    	}
			    	          
			      }
			    
			    /*
				//Method to Verify the Flag icon on Home page in Android
                public static void VerifyFlagIcon_AN() throws Exception

                {
                       try
                       {
                       Thread.sleep(5000);
                       WebElement FlagIcon = nativedriver.findElement(By.xpath(Android_Objects.getProperty("FlagIcon")));
                       if(FlagIcon.isDisplayed())

                       {

                              System.out.println("FlagIcon is Present");
                              Thread.sleep(2000);                      

                       }

                       }catch(Exception e)

                       {

                              System.out.println("FlagIcon is not Present");                    
                              CaptureScreenshot("TC_Fail_");                       
                              //ClickSignOut();
                              Close_App_HPE();
                              Thread.sleep(2000);
                              Assert.fail("FlagIcon is not Present");

                       }

                }

                */
			    
			  //Method to Verify the Flag icon on Home page in Android
                public static void VerifyFlagIcon_AN(String imagePath) throws Exception
                {
                try


                      {
                nativedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                WebElement FlagIcon = visualdriver.findElement(ByMobile.image(imagePath));
                testLog.info("\n Image found is : " + imagePath);
                                
                       } catch (Exception e) 
                       {
                testLog.info("\nImage not present : " + imagePath);    
                status1 = 1;
                //Assert.fail();
                        }
}


		
		//Method to Verify the Flag icon on Home page for iOS
		
		public static void VerifyFlagIcon_iOS() throws Exception
		{
			try
			{
			Thread.sleep(5000);
			WebElement FlagIcon = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("FlagIcon")));
			if(!FlagIcon.isDisplayed())
			{
				System.out.println("FlagIcon is Present");
				Thread.sleep(2000);				
			}
			}
			catch(Exception e)
			{
				System.out.println("FlagIcon is not Present");				
				CaptureScreenshot("TC_Fail_");				
				//ClickSignOut();
				Close_App_HPE();
				Thread.sleep(2000);
				Assert.fail("FlagIcon is not Present");
			}
		}
		
		//Method to click on Watch list on home screen
		public static void ClickWatchList_iOS() throws Exception
		{
			
			
			device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("424,855")));
			System.out.println("Clicked on Watch List Arrow");
		    Thread.sleep(10000); 
		    
		    /*
			try
			{			
			WebElement WatchList = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("WatchListArrow")));
			if(!WatchList.isDisplayed())
			{	
				Thread.sleep(2000);	
				WatchList.click();
				System.out.println("Clicked on Watchlist");
				Thread.sleep(5000);		
				//nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
			}
			catch(Exception e)
			{
				System.out.println("WatchlistArrow is not Present");				
				CaptureScreenshot("TC_Fail_");				
				//ClickSignOut();
				Close_App_HPE();
				Assert.fail("WatchlistArrow is not Present");
			}
			
			*/
			
		}
		
		// Method to click Watch list box in Android

        public static void ClickWatchList_AN() throws Exception
        {
        	
        	//device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("521,1132")));
        	device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("631,1017")));
        	System.out.println("Clicked on Watch List Arrow");
		    Thread.sleep(10000); 
		    
        	
        	/*
               try
               {          
            	   nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
               WebElement WatchList = nativedriver.findElement(By.xpath(Android_Objects.getProperty("WatchListArrow")));
               if(WatchList.isDisplayed())
               {      
                     Thread.sleep(2000);  
                     WatchList.click();
                     System.out.println("Clicked on Watchlist");
                     Thread.sleep(5000);        
                    
               }
               }
               catch(Exception e)
               {
                     System.out.println("WatchlistArrow is not Present");                        
                     CaptureScreenshot("TC_Fail_");                         
                     //ClickSignOut();
                     Close_App_HPE();
                     Thread.sleep(2000);
                     Assert.fail("WatchlistArrow is not Present");
               }
               */
               
        }

		
		//Method to remove orders fromWatch list page
		public static void RemoveWatchListOrders() throws Exception
		{
	
			for(i=0;i<5;i++)
			{
				try
				{
			    ClickGreenFlag1();
				HPECommonFunctions.AlertPopUp_ClickRemove();				
			    }
			
		
		catch (Exception e)
		{
			System.out.println("All the orders are removed");
			break;
		}
							
		}
	}
		
		//Method to click on white flag icon 
	    public static void ClickGreenFlag() throws Exception
			      {
			    	if(Device_Model.equals("iPhone-7"))
			    	{
			    		ClickGreenFlag("C://HPE//FunctionalTesting//Images//Flag_Icon_Green" +".png");
			    	}else if(Device_Model.equals("iPhone-5S"))
			    	{
			    		ClickGreenFlag("C://HPE//FunctionalTesting//Images//Flag_Icon_Green_iPhone5S" +".png");
			    	}else if(Device_Model.contains("Pixel"))
			    	{
			    		ClickGreenFlag("C://HPE//FunctionalTesting//Images//Flag_Icon_Green_AN" +".png");
			    	}else if(Device_Model.contains("Galaxy"))
                    {
                        ClickGreenFlag("C://HPE//FunctionalTesting//Images//Flag_Icon_Green_Galaxy" +".png");
                 }else if(Device_Model.equals("iPhone-7s"))
			    	{
			    		ClickGreenFlag("C://HPE//FunctionalTesting//Images//Flag_Icon_Green" +".png");
			    	}

			    	          
			      }
	    
	    
	    public static void firstOrderClick_Galaxy() throws Exception
        {
                                 
             device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("319,1038")));
                   System.out.println("Clicked on  order in Search Page");
                   Thread.sleep(10000); 
                                                                                                            
                   }

	    
		//Method to click on white flag icon 
	    public static void ClickGreenFlag1() throws Exception
			      {
			    	if(Device_Model.contains("iPhone"))
			    	{
			    		ClickGreenFlag1("C://HPE//FunctionalTesting//Images//Flag_Icon_Green" +".png");
			    	}else if(Device_Model.contains("Pixel"))
			    	{
			    		ClickGreenFlag1("C://HPE//FunctionalTesting//Images//Flag_Icon_Green_AN" +".png");
			    	}else if(Device_Model.contains("Galaxy S6"))
			    	{                        
                        ClickGreenFlag1("C://HPE//FunctionalTesting//Images//Flag_Icon_Green_Galaxy" +".png");
			      	} else if(Device_Model.contains("Galaxy S7"))
			      	{
			      	  ClickGreenFlag1("C://HPE//FunctionalTesting//Images//Flag_Icon_Green_GalaxyS7" +".png");
			      	}
			      }
	    
	    
	  //Method to click on cancel button 
	    public static void ClickOnWatchListGreenFlag() throws Exception
			      {
	    	try{
	    		Find_Text_WatchListTips(config.getProperty("WatchListTips")); 
	    		HPECommonFunctions.Close_App_HPE();
	    		
	    	}catch(Exception e)
	    	{
	    		ClickGreenFlag();
	    		HPECommonFunctions.AlertPopUp_ClickRemove(); 
	    		HPECommonFunctions.ClickSignOut();
	    		HPECommonFunctions.Close_App_HPE();
	    	}
			      }
	    
	  //
	  //Method to click on cancel button 
	    public static void AlertPopUp_ClickCancel() throws Exception
			      {
			    	if(Device_Model.contains("iPhone"))
			    	{
			    		AlertPopUp_ClickCancel("C://HPE//FunctionalTesting//Images//Alert_Cancel" +".png");
			    	}else 
			    	{
			    		AlertPopUp_ClickCancel("C://HPE//FunctionalTesting//Images//Alert_Cancel_AN" +".png");
			    	}
			    	          
			      }
		
		
		//Method to remove orders fromWatch list page for iOS
				public static void SelectingOrdersWithWhiteFlag() throws Exception
				{
			try{
					for(i=0;i<5;i++)
					{
						try
						{
					    ClickWhiteFlag1();
					    break;
						}
					
				
				catch (Exception e)
				{
					SwipeUp();
				}
				
					}
					}catch(Exception e1)
					{
						System.out.println("No orders are flagged in Watchlist ");
					}
				
				}
				
				//Method to click on white flag icon 
			    public static void ClickWhiteFlag() throws Exception
					      {
					    	if(Device_Model.contains("iPhone"))
					    	{
					    		ClickWhiteFlag("C://HPE//FunctionalTesting//Images//Flag_Icon_White" +".png");
					    	}else if(Device_Model.equals("iPhone-5S"))
					    	{
					    		ClickWhiteFlag("C://HPE//FunctionalTesting//Images//Flag_Icon_White_iPhone5S" +".png");
					    	}else if(Device_Model.contains("Pixel"))
					    	{
					    		ClickWhiteFlag("C://HPE//FunctionalTesting//Images//Flag_Icon_White_AN" +".png");
					    	}else if(Device_Model.contains("Galaxy S6"))
                            {
                                ClickWhiteFlag("C://HPE//FunctionalTesting//Images//Flag_Icon_White_Galaxy" +".png");
                         } else if(Device_Model.contains("Galaxy S7"))
                         {
                             ClickWhiteFlag("C://HPE//FunctionalTesting//Images//Flag_Icon_White_GalaxyS7" +".png");
                      }

					    	          
					      }
			    
			  //Method to click on filter icon 
			    public static void ClickFilterIcon() throws Exception
					      {
					    	if(Device_Model.equals("iPhone-7"))
					    	{
					    		ClickFilterIcon("C://HPE//FunctionalTesting//Images//FilterIcon" +".png");
					    	}else if(Device_Model.equals("iPhone-5S"))
					    	{
					    		ClickFilterIcon("C://HPE//FunctionalTesting//Images//FilterIcon_iPhone5S" +".png");
					    	}else if(Device_Model.contains("Pixel"))
					    	{
					    		ClickFilterIcon("C://HPE//FunctionalTesting//Images//FilterIcon_AN" +".png");
					    	}else if(Device_Model.contains("Galaxy S6"))
                            {
                                ClickFilterIcon("C://HPE//FunctionalTesting//Images//FilterIcon_Galaxy" +".png");
                         } else if(Device_Model.contains("Galaxy S7"))
                         {
                             ClickFilterIcon("C://HPE//FunctionalTesting//Images//FilterIcon_GalaxyS7" +".png");
                      }else if(Device_Model.equals("iPhone-6S"))
				    	{
				    		ClickFilterIcon("C://HPE//FunctionalTesting//Images//FilterIcon" +".png");
				    	}

					    	          
					      }
				
			  //Method to click on white flag icon 
			    public static void ClickWhiteFlag1() throws Exception
					      {
					    	if(Device_Model.contains("iPhone"))
					    	{
					    		ClickWhiteFlag1("C://HPE//FunctionalTesting//Images//Flag_Icon_White" +".png");
					    	}else 
					    	{
					    		ClickWhiteFlag1("C://HPE//FunctionalTesting//Images//Flag_Icon_White_AN" +".png");
					    	}
					    	          
					      }
				
		//Method to click on flag icon or any order on Watch list page
		public static void ClickWatchFlagIcon() throws Exception
		{
			try
			{
			
			WebElement WatchFlagIcon = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("WatchFlagIcon")));
			if(!WatchFlagIcon.isDisplayed())
			{
				System.out.println("Watchlist FlagIcon is Present");
				Thread.sleep(2000);
				WatchFlagIcon.click();
				System.out.println("Clicked on Watchlist Flag Icon");
				Thread.sleep(10000);
			}
			}
			catch(Exception e)
			{
				System.out.println("WatchFlagIcon is not Present");				
				CaptureScreenshot("TC_Fail_");				
				//ClickSignOut();
				Close_App_HPE();
				Thread.sleep(2000);
				Assert.fail("WatchFlagIcon is not Present");
			}
			
		}
		
		//Method to Click on 'Remove' button on Alert popup for iOS
		public static void AlertPopUp_ClickRemove_iOS() throws Exception
		{	
		
			device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("482,910")));
			System.out.println("Clicked on Remove button");
		    Thread.sleep(10000); 
		
		} 
		
		//Method to Click on 'Remove' button on Alert popup for Android
		public static void AlertPopUp_ClickRemove_AN() throws Exception
		{	
		
			device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("719,1206")));
			System.out.println("Clicked on Remove button");
		    Thread.sleep(10000); 		    
			
		
		}
		
		
    	//Method to verify the footer on the app
	    public static void AlertPopUp_ClickRemove() throws Exception
	      {
	    	if(Device_Model.contains("iPhone"))
	    	{
	    		//ClickOnSearchIcon_iOS();
	    		AlertPopUp_ClickRemove_iOS();
	    	}else
	    	{
	    		AlertPopUp_ClickRemove_AN();
	    	}
	    	          
	      } 
		
		//Method to Click on 'Cancel' button on Alert popup
		public static void AlertPopUp_ClickCancel(String imagePath) throws Exception
		{	
		/*
			device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("482,910")));
			System.out.println("Clicked on Remove button");
		    Thread.sleep(10000); 		    
			*/
			
			try {
				
				//visualdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				//WebElement Remove = visualdriver.findElement(ByMobile.image(imagePath));
				WebElement Cancel = visualdriver.findElement(ByMobile.image(imagePath));					
				testLog.info("\n Image found is : " + imagePath);
				testLog.info("Cancel button is found");
				Cancel.click();
				testLog.info("Cancel button is clicked");
			} catch (Exception e) {
				testLog.info("\nImage not present : " + imagePath);	
				testLog.info("Cancel button is not found");
				status1 = 1;
				//Assert.fail();
				CaptureScreenshot("TC_Fail_");				
				//ClickSignOut();
				Close_App_HPE();
				Thread.sleep(2000);
				Assert.fail("Cancel button is not found");

			}
			
		
		}
			
		
			
		
		
			
		//Method to Validate the 3 lines menu bar on Home screen	
			public static void VerifyMenuBar(String imagePath) throws Exception
			{	try {
						
						nativedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						//WebElement Remove = visualdriver.findElement(ByMobile.image(imagePath));
						WebElement MenuBar = visualdriver.findElement(ByMobile.image(imagePath));					
						testLog.info("\n Image found is : " + imagePath);
						testLog.info("3 Line menu bar is found");
					} catch (Exception e) {
						testLog.info("\nImage not present : " + imagePath);	
						testLog.info("3 Line menu bar is not found");
						status1 = 1;
						Close_App_HPE();
						Assert.fail("3 Line menu bar is not found");
					}
				} 
	
            //Method to verify menu bar
            public static void VerifyMenuBar() throws Exception
         {
                if(Device_Model.contains("iPhone"))
                { 
                	VerifyMenuBar("C://HPE//FunctionalTesting//Images//MenuBar"+".png");
                }else if(Device_Model.contains("Tab"))
                { 
                	VerifyMenuBar("C://HPE//FunctionalTesting//Images//MenuBar_Tab"+".png");
                }else if (Device_Model.contains("Galaxy S6"))
                    
               {
                    VerifyMenuBar("C://HPE//FunctionalTesting//Images//MenuBar_GalaxyS6"+".png");
                    
               } else if (Device_Model.contains("Galaxy S7"))
               {
                    VerifyMenuBar("C://HPE//FunctionalTesting//Images//MenuBar_GalaxyS7"+".png");
               }else

                {
                	VerifyMenuBar_AN();
                }
                
         }
            
            
          //Method to verify menu bar
            public static void ClickMenuBar() throws Exception
         {
                if(Device_Model.equals("iPhone-7"))
                { 
                	ClickMenuBar("C://HPE//FunctionalTesting//Images//MenuBar"+".png");
                }else if(Device_Model.equals("iPhone-5S"))
                { 
                	ClickMenuBar("C://HPE//FunctionalTesting//Images//MenuBar_iPhone5S"+".png");
                }else if(Device_Model.contains("Tab"))
                { 
                	ClickMenuBar("C://HPE//FunctionalTesting//Images//MenuBar_Tab"+".png");
                }else if(Device_Model.contains("Galaxy S6"))
                {
                    ClickMenuBar("C://HPE//FunctionalTesting//Images//MenuBar_GalaxyS6"+".png");
                    
               } else if(Device_Model.contains("Galaxy S7"))
               {
                    ClickMenuBar("C://HPE//FunctionalTesting//Images//MenuBar_GalaxyS7"+".png");
               }else if(Device_Model.contains("Pixel"))

                {
                	ClickMenuBar("C://HPE//FunctionalTesting//Images//MenuBar_Pixel"+".png");
                }else if(Device_Model.equals("iPhone-6S"))
                { 
                	ClickMenuBar("C://HPE//FunctionalTesting//Images//MenuBar"+".png");
                }
                
         }
		
			//Method to Validate the menu slide from the left side
			public static void VerifyMenuSlide_iOS() throws Exception
			{
				try
				{
				WebElement MenuSlide = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Home")));
				if(!MenuSlide.isDisplayed())
				{				
					System.out.println("User is able to see a menu slide from the left");
					Thread.sleep(5000);				
				}
				}
				catch(Exception e)
				{
					System.out.println("User is not able to see a menu slide from the left");				
					CaptureScreenshot("TC_Fail_");				
					//ClickSignOut();
					Close_App_HPE();
					Thread.sleep(2000);
					Assert.fail("User is able to see a menu slide from the left");
				}
			}
			
			//Method to Validate the connectivity of 4G or Wifi on android
				public static void VerifyConnectivity1() throws Exception
	              {
	                     Thread.sleep(3000);
	                  if(nativedriver.findElement(By.xpath(iOS_Objects.getProperty("SignIn"))).isDisplayed())
	                     {
	                           System.out.println("App is connected to 4g or wifi");
	                     }else {
	                           System.out.println("App is not connected to 4g or wifi");
	                     }
     
			
		}

				
				
	              
	              // Method to click the magnifying icon on Android
                  
                  public static void ClickOnSearchIcon_AN(String imagePath) throws Exception
                  
                  {
                    try
                    {
                               WebElement SearchIcon = visualdriver.findElement(ByMobile.image(imagePath));                              
                               SearchIcon.click();
                               testLog.info("\n Image found is : " + imagePath);
                               testLog.info("Clicked on Search Icon");
                               Thread.sleep(10000);
                         } catch (Exception e) {
                               testLog.info("\nImage not present : " + imagePath);    
                               testLog.info("Unable to click on Search Icon");
                               Close_App_HPE();
                               status1 = 1;
                               Assert.fail("Search Icon is not present");
                         }
               }
        
	              
	           // Method to display " No Search results found " in android
                  
                  public static void VerifyNoSearchResults_AN() throws Exception
                  {
                    try
                    {
                           WebElement NoSearchAlert = nativedriver.findElement(By.xpath(Android_Objects.getProperty("SearchPageTitle")));
                           Thread.sleep(1000);
                           if (NoSearchAlert.isDisplayed())
                           { 
                                 System.out.println(" No Search results found alert is displayed");
                                 Thread.sleep(1000);
                                                             }
                    }
                    catch(Exception e)
                         {
                               System.out.println("No Search results found alert is displayed");                         
                               CaptureScreenshot("TC_Fail_");           
                               ClickSignOut();
                               Close_App_HPE();
                               Thread.sleep(2000);
                               Assert.fail("No Search results found alert is displayed");
                         }
                  }
                  
                //Method to verify the text no results on any page (Checkpoint)
                  public static void Find_Text_NoResultsFound(String linktext) {
                  	try {
                  		IMobileWebDriver Text = device.getVisualDriver();
                  		Text.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);                		
                  		Text.findElement(By.linkText(linktext));
                  		testLog.info("\n Element found is : " + linktext);
                  		testLog.info("No Search results found");
                  		ClickSignOut();
                  		Assert.fail("No Search results found");
                  		status1 = 1;
                  	} catch (Exception e) {
                  		testLog.info("\nElement not found : " + linktext);
                  		testLog.info("\nSearch results found");
                  		
                  	}
                  }
                  
                //Method to verify the text no results on any page (Checkpoint)
                  public static void Find_Text_NoResults(String linktext) throws Exception {
                  
                  		IMobileWebDriver Text = device.getVisualDriver();
                  		Text.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);                		
                  		Text.findElement(By.linkText(linktext));
                  		testLog.info("\n Element found is : " + linktext);
                  		testLog.info("No Search results found");
                  		Close_App_HPE();
                  		//softAssert.assertTrue(false);                  		
                  		status1 = 1;
                  
                  	
                  }
                  

                  //Method to verify the text not found on any page (Checkpoint)
                  public static void Find_No_Text(String linktext) throws Exception {
                  	try {
                  		IMobileWebDriver Text = device.getVisualDriver();
                  		Text.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);                		
                  		Text.findElement(By.linkText(linktext));
                  		testLog.info("\nElement found : " + linktext);
                  		Close_App_HPE();
                  		Assert.fail("'Invoice(s) Available from OSS' icon appeared");
                  		status1 = 0;          
                  		
                  	} catch (Exception e) {
                  		
                  		testLog.info("\n Element not found is : " + linktext);                  		
                  		//ClickSignOut();
                  		//Close_App_HPE();
                  		Thread.sleep(2000);
                  		testLog.info("\n'Invoice(s) Available from OSS' icon did not appear as expected");
                  		status1 = 1;
                  		
                  	}
                  }
        
                  
                  //Method to verify the text not found on any page (Checkpoint)
                  public static void Find_No_Text_Date(String linktext) throws Exception {
                  	try {
                  		IMobileWebDriver Text = device.getVisualDriver();
                  		Text.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);                		
                  		Text.findElement(By.linkText(linktext));
                  		testLog.info("\nElement found : " + linktext);
                  		Close_App_HPE();
                  		Assert.fail("Shipping date appeared");
                  		status1 = 0;          
                  		
                  	} catch (Exception e) {
                  		
                  		testLog.info("\n Element not found is : " + linktext);                  		
                  		//ClickSignOut();
                  		//Close_App_HPE();
                  		Thread.sleep(2000);
                  		testLog.info("\n Shipping date did not appear as expected");
                  		status1 = 1;
                  		
                  	}
                  }
  
                  
	              // Method to Verify the Search Page on android 
	                     public static void VerifySearchPage_AN() throws Exception
	                     {
	                    	 
	                    	 HPECommonFunctions.Find_Text(config.getProperty("Search_PageTitle"));
	                    	 /*
	                    	 try
	                           {
	                                                              
	                    		 WebElement SearchPage = nativedriver.findElement(By.xpath(Android_Objects.getProperty("SearchPageTitle")));
	                    		 Thread.sleep(1000);
	                    		 if (SearchPage.isDisplayed())
	                    		 {
	                    			 System.out.println("Search Page is displayed");
	                    			 Thread.sleep(5000);
	                    		 }
	                           }
	                     
	                     catch(Exception e)
	                     {
	                           System.out.println("Search Page is not displayed");                         
	                           CaptureScreenshot("TC_Fail_");           
	                           Close_App_HPE();
	                           Thread.sleep(2000);
	                           Assert.fail("Search Page is not displayed");
	                     }
	                     
	                     */
	              }
	                     
	                  // Method to Verify the Search Page on iOS  
	                     public static void VerifySearchPage_iOS() throws Exception
	                     {
	                    	 try
	                           {
	                                                              
	                    		 WebElement SearchPage = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("SearchPageTitle")));
	                    		 Thread.sleep(1000);
	                    		 if (!SearchPage.isDisplayed())
	                    		 {
	                    			 System.out.println("Search Page is displayed");
	                    			 Thread.sleep(5000);
	                    		 }
	                           }
	                     
	                     catch(Exception e)
	                     {
	                           System.out.println("Search Page is not displayed");                         
	                           CaptureScreenshot("TC_Fail_");           
	                           Close_App_HPE();
	                           Thread.sleep(2000);
	                           Assert.fail("Search Page is not displayed");
	                     }
	              }
	              
	                     /*
	                      
	              // Method to click on search result
	                     
	                     public static void ClickOnSearchResult_AN() throws Exception
	                     {
	                        try
	                        {
	                    
	                       WebDriverWait wait = new WebDriverWait(nativedriver, 20);
	                       WebElement  Search_Result= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Android_Objects.getProperty("SearchResult"))));
	                       Search_Result.click();
	                       Thread.sleep(10000);              
	                       System.out.println("Clicked on Search Result");
	                       
	                         }catch (Exception e)
	                     {
	                           System.out.println("Search Result not clicked");
	                           CaptureScreenshot("TC_Fail_");           
	                           ClickSignOut();
	                           Assert.fail("Search Result not clicked");
	                     }   
	                     
	                     }  
	                     */
	                     
	                     // Method to click on search result
                         
                         public static void ClickOnSearchResult_AN() throws Exception
                         {
                                      try{ 
                                    	  
                        	 		Find_Text_NoResults(config.getProperty("NoResults"));
                        	 		                      	 		
                                      }
                                      catch(Exception e)
                                      {
                                    device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("306,791")));
                                    System.out.println("Clicked on any order in Search Page");
                                    Thread.sleep(10000); 
                                    try{
               							CheckServiceError("C://HPE//FunctionalTesting//Images//ServiceErrorOK" +".png");
               							}catch (Exception e1)
               						{
               							System.out.println("Service Error did not appear");
               						}
                                       
                                       HPECommonFunctions.Find_Text(config.getProperty("OrderDetails_PageTitle"));
                                       HPECommonFunctions.VerifyBackButton();
                                       HPECommonFunctions.ClickSignOut();
                                       HPECommonFunctions.Close_App_HPE();
                                      
                                         }
                                   
                                      }
                                                                                                                           
    // Method to click on search result in Galaxy S7
                         
                         public static void ClickOnSearchResult_GalaxyS7() throws Exception
                         {
                                      try{ 
                                    	  
                        	 		Find_Text_NoResults(config.getProperty("NoResults"));
                        	 		                      	 		
                                      }
                                      catch(Exception e)
                                      {
                                    device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("568,1150")));
                                    System.out.println("Clicked on any order in Search Page");
                                    Thread.sleep(10000); 
                                    try{
               							CheckServiceError("C://HPE//FunctionalTesting//Images//ServiceErrorOK" +".png");
               							}catch (Exception e1)
               						{
               							System.out.println("Service Error did not appear");
               						}
                                       
                                       HPECommonFunctions.Find_Text(config.getProperty("OrderDetails_PageTitle"));
                                       HPECommonFunctions.VerifyBackButton();
                                       HPECommonFunctions.ClickSignOut();
                                       HPECommonFunctions.Close_App_HPE();
                                      
                                         }
                                   
                                      }

	                     // Method to click on search result
                         
                         public static void ClickOnSearchResult3_AN() throws Exception
                         {
                                      try{ 
                                    	  
                        	 		Find_Text_NoResults(config.getProperty("NoResults"));
                        	 		                      	 		
                                      }
                                      catch(Exception e)
                                      {
                                    device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("306,791")));
                                    System.out.println("Clicked on any order in Search Page");
                                    Thread.sleep(10000); 
                                    HPECommonFunctions.Find_No_Text(config.getProperty("Invoice"));                    
                                    HPECommonFunctions.ClickSignOut();
                                    HPECommonFunctions.Close_App_HPE();
                                    
                                      }
                                                                                                                           
                               }
                         
                         
// Method to click on search result
                         
                         public static void ClickOnSearchResult4_AN() throws Exception
                         {
                                      try{ 
                                    	  
                        	 		Find_Text_NoResults(config.getProperty("NoResults"));
                        	 		                      	 		
                                      }
                                      catch(Exception e)
                                      {
                                    device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("306,791")));
                                    System.out.println("Clicked on any order in Search Page");
                                    Thread.sleep(10000); 
                                    HPECommonFunctions.VerifyDeliveredStatus("C://HPE//FunctionalTesting//Images//Delivered_symbol"+".png");
                                    HPECommonFunctions.Find_Text(config.getProperty("Invoice"));          
                                    HPECommonFunctions.ClickInvoiceAvailableButton();
                                    
                                    HPECommonFunctions.ClickSignOut();
                                    HPECommonFunctions.Close_App_HPE();
                                    
                                      }
                                                                                                                           
                               }

                         
// Method to click on search result
                         
                         public static void ClickOnSearchResult4_iOS() throws Exception
                         {
                                      try{ 
                                    	  
                        	 		Find_Text_NoResults(config.getProperty("NoResults"));
                        	 		                      	 		
                                      }
                                      catch(Exception e)
                                      {
                                    device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("306,791")));
                                    System.out.println("Clicked on any order in Search Page");
                                    Thread.sleep(10000); 
                                    HPECommonFunctions.VerifyDeliveredStatus("C://HPE//FunctionalTesting//Images//Delivered_symbol"+".png");
                                    HPECommonFunctions.Find_Text(config.getProperty("Invoice"));          
                                    HPECommonFunctions.ClickInvoiceAvailableButton();
                                    
                                    HPECommonFunctions.ClickSignOut();
                                    HPECommonFunctions.Close_App_HPE();
                               
                                    
                                      }
                                                                                                                           
                               }

                         
// Method to click on search result
                         
                         public static void ClickOnSearchResult2_AN() throws Exception
                         {
                                      try{ 
                                    	  
                        	 		Find_Text_NoResults(config.getProperty("NoResults"));
                        	 		                      	 		
                                      }
                                      catch(Exception e)
                                      {
                                    device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("306,791")));
                                    System.out.println("Clicked on any order in Search Page");
                                    Thread.sleep(10000); 
                                    HPECommonFunctions.Find_No_Text(config.getProperty("DateShipped"));                    
                              	  	HPECommonFunctions.ClickSignOut();
                              	  	HPECommonFunctions.Close_App_HPE();
                                    
                                      }
                                                                                                                           
                               }

                         
// Method to click on search result
                         
                         public static void ClickOnSearchResult2_iOS() throws Exception
                         {
                                      try{ 
                                    	  
                        	 		Find_Text_NoResults(config.getProperty("NoResults"));
                        	 		                      	 		
                                      }
                                      catch(Exception e)
                                      {
                                    device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("306,791")));
                                    System.out.println("Clicked on any order in Search Page");
                                    Thread.sleep(10000); 
                                    HPECommonFunctions.Find_No_Text_Date(config.getProperty("DateShipped"));                    
                              	  	HPECommonFunctions.ClickSignOut();
                              	  	HPECommonFunctions.Close_App_HPE();
                                                          
                                    
                                      }
                                                                                                                           
                               }
                         
                         
// Method to click on search result
                         
                         public static void ClickOnSearchResult5_AN() throws Exception
                         {
                                      try{ 
                                    	  
                        	 		Find_Text_NoResults(config.getProperty("NoResults"));
                        	 		                      	 		
                                      }
                                      catch(Exception e)
                                      {
                                    device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("306,791")));
                                    System.out.println("Clicked on any order in Search Page");
                                    Thread.sleep(10000); 
                                    HPECommonFunctions.Find_Text(config.getProperty("Invoice"));                    
                              	  	HPECommonFunctions.ClickSignOut();
                              	  	HPECommonFunctions.Close_App_HPE();
                                    
                                      }
                                                                                                                           
                               }

                         
// Method to click on search result
                         
                         public static void ClickOnSearchResult5_iOS() throws Exception
                         {
                                      try{ 
                                    	  
                        	 		Find_Text_NoResults(config.getProperty("NoResults"));
                        	 		                      	 		
                                      }
                                      catch(Exception e)
                                      {
                                    device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("306,791")));
                                    System.out.println("Clicked on any order in Search Page");
                                    Thread.sleep(10000); 
                                    HPECommonFunctions.Find_Text(config.getProperty("Invoice"));                    
                              	    //HPECommonFunctions.ClickSignOut();
                              	  	HPECommonFunctions.Close_App_HPE();
                                                          
                                    
                                      }
                                                                                                                           
                               }
                         
                         //Method to check Invoice available
                         
                         public static void VerifyInvoiceAvailabe() throws Exception {
                        	 try{

                                 Thread.sleep(5000);
                                 WebElement Invoice = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Invoice Available")));
                                 if(!Invoice.isDisplayed())
                                 {
                                	 System.out.println("Invoice is available from OSS");
                            
                                 }
                                       }
                                       catch(Exception e)
                                       {
                                              System.out.println("Invoice is not available from OSS");                        
                                              CaptureScreenshot("TC_Fail_");                         
                                              ClickSignOut1();
                                              Close_App_HPE();
                                              Thread.sleep(2000);
                                              Assert.fail("Invoice is not available from OSS");
                                       }
                        
                         }
                        	 
	                  // Method to click on Order Details Page
                         
                         public static void VerifyOrderDetailsPage() throws Exception
                         {
                               try
                                      {
                                                                  
                         WebElement UNElement = nativedriver.findElement(By.xpath(Android_Objects.getProperty("OrderDetailTitle")));
                         Thread.sleep(3000);
                         System.out.println("Order Details Page displayed");
                         Thread.sleep(5000);
                         }
                         
                         catch(Exception e)
                         {
                               System.out.println("Order Details Page not displayed");                         
                               CaptureScreenshot("TC_Fail_");           
                               //ClickSignOut();
                               Close_App_HPE();
                               Thread.sleep(2000);
                               Assert.fail("Order Details Page not displayed");
                         }
                  }
                     	//Method to verify the version number on the Menu Page
                         public static void VerifyVersionNumber() throws Exception
                     		      {
                     		    	if(Device_Model.contains("iPhone"))
                     		    	{
                     		    		VerifyVersionNumber_iOS();
                     		    	}else
                     		    	{
                     		    		VerifyVersionNumber_AN();
                     		    	}
                     		    	          
                     		      }
                     
                         
                         
                         // Method to verify the version number on the Menu Page for Android
                         public static void VerifyVersionNumber_AN() throws Exception
                             {
                             try
                             {
                                     Thread.sleep(5000);
                                     WebElement VersionNumber = nativedriver.findElement(By.xpath(Android_Objects.getProperty("VersionNumber")));
                                 if(VersionNumber.isDisplayed())
                             {
                                 VersionNo = VersionNumber.getAttribute("name");
                                System.out.println("Version Number is Present & below is the Version Number");
                                System.out.println(VersionNo);
                                Thread.sleep(2000); 
                                
                             }
                                           }
                                           catch(Exception e)
                                           {
                                                  System.out.println("Version Number is not Present");                        
                                                  CaptureScreenshot("TC_Fail_");                         
                                                  Close_App_HPE();
                                                  Thread.sleep(2000);
                                                  Assert.fail("Version Number is not Present");
                                           }
                                                                                
                                              
                                     }

                         
                         
          // Method to verify the version number on the Menu Page for iOS
             public static void VerifyVersionNumber_iOS() throws Exception
                 {
                 try
                 {
                         Thread.sleep(5000);
                         WebElement VersionNumber = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("VersionNumber")));
                         if(!VersionNumber.isDisplayed())
                         {
                        	 VersionNo = VersionNumber.getAttribute("name");
                        	 System.out.println("Version Number is Present & below is the Version Number");
                        	 System.out.println(VersionNo);
                        	 Thread.sleep(2000); 
                        	 
                    
                         }
                               }
                               catch(Exception e)
                               {
                                      System.out.println("Version Number is not Present");                        
                                      CaptureScreenshot("TC_Fail_");                         
                                      //ClickSignOut1();
                                      Close_App_HPE();
                                      Thread.sleep(2000);
                                      Assert.fail("Version Number is not Present");
                               }
                 //return VersionNo;
                 			
                 			
                         }
             
           //Method to verify to display Get Support
                        public static void VerifyGetSupportMenuOption() throws Exception
                        {
                               try
                               {
                               Thread.sleep(5000);
                               WebElement Get_Support = nativedriver.findElement(By.xpath(Android_Objects.getProperty("GetSupportMenuOption")));
                               if(Get_Support.isDisplayed())
                               {
                                      System.out.println("Get Support menu option displayed");
                                      Thread.sleep(10000);
                               }
                               }
                               catch(Exception e)
                               {
                                      System.out.println("Get Support Menu option is not Present");                        
                                      CaptureScreenshot("TC_Fail_");                         
                                      //ClickSignOut();
                                      Close_App_HPE();
                                      Thread.sleep(2000);
                                      Assert.fail("Get Support Menu option is not Present");
                               }
                        }
           
             
                                
                      //Method to Click on Get Support
                        public static void ClickGetSupportOption_iOS() throws Exception
                        {
                               try
                               {
                               Thread.sleep(5000);
                               WebElement GetSupport = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("GetSupport")));
                               if(!GetSupport.isDisplayed())
                               {
                                      
                                      GetSupport.click();
                                      System.out.println("CLicked on Get Support");
                                      Thread.sleep(10000);
                               }
                               }
                               catch(Exception e)
                               {
                                      System.out.println("Unbale to click on Get Support Menu option");                         
                                      CaptureScreenshot("TC_Fail_");                         
                                      //ClickSignOut1();
                                      Close_App_HPE();
                                      Thread.sleep(2000);
                                      Assert.fail("Unbale to click on Get Support Menu option");
                               }
                        }
                        
                        // Method to Verify Get Support Page
             
             public static void VerifyGetSupportPage() throws Exception
             {
            	 
                   try
                          {
                                                      
             //WebElement GetSupport = nativedriver.findElement(By.xpath(Android_Objects.getProperty("GetSupportPage")));
             //Thread.sleep(3000);
             Find_Text(config.getProperty("GetSupport_Button"));
             System.out.println("Get Support Page displayed");
             Thread.sleep(5000);
             }
             
             catch(Exception e)
             {
                   System.out.println("Get Support Page not displayed");                         
                   CaptureScreenshot("TC_Fail_");           
                   //ClickSignOut();
                   Close_App_HPE();
                   Thread.sleep(2000);
                   Assert.fail("Get Support Page not displayed");
             }

      }


	     //Method to verify the Back button
	     public static void VerifyBackButton(String imagePath) throws Exception
	     {
	    	 try {
					
	    		 	Thread.sleep(10000); 
					nativedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					//WebElement Remove = visualdriver.findElement(ByMobile.image(imagePath));
					WebElement BackButton = visualdriver.findElement(ByMobile.image(imagePath));

					testLog.info("\n Image found is : " + imagePath);
					testLog.info("Back button is present");
					status1 = 1;
					
				} catch (Exception e) {
					testLog.info("\nImage not present : " + imagePath);	
					testLog.info("Back button is not present");
					status1 = 0;
					CaptureScreenshot("TC_Fail_"); 
					//ClickSignOut();
					Close_App_HPE();
                    Thread.sleep(2000);
					Assert.fail("Back button is not present");
				}
	   	}
	     
	     //Method to verify the back button on the page
 	    public static void VerifyBackButton() throws Exception
 			      {
 			    	if(Device_Model.equals("iPhone-7"))
 			    	{
 			    		VerifyBackButton("C://HPE//FunctionalTesting//Images//BackButton" +".png");
 			    	}else if(Device_Model.equals("iPhone-5S"))
 			    	{
 			    		VerifyBackButton("C://HPE//FunctionalTesting//Images//BackButton_iPhone5S" +".png");
 			    	}else if(Device_Model.equals("iPhone-5S"))
 			    	{
 			    		VerifyBackButton("C://HPE//FunctionalTesting//Images//BackButton_Tab" +".png");
 			    	}else if(Device_Model.contains("Pixel"))
                    {
 			    		VerifyBackButton("C://HPE//FunctionalTesting//Images//BackButton_AN"+".png");
                    }else if(Device_Model.contains("Galaxy S6"))
                    {
                    	VerifyBackButton("C://HPE//FunctionalTesting//Images//BackButton_Galaxy" +".png");
                    } else if(Device_Model.contains("Galaxy S7"))

                    {
                    	VerifyBackButton("C://HPE//FunctionalTesting//Images//BackButton_GalaxyS7" +".png");
                    }else if(Device_Model.equals("iPhone-6S"))
 			    	{
 			    		VerifyBackButton("C://HPE//FunctionalTesting//Images//BackButton" +".png");
 			    	}
 			      }
 	    
        //Method to click on Terms and Conditions  button
        public static void ClickTnC() throws Exception
     {
            if(Device_Model.contains("iPhone"))
            { 
             
            }else if(Device_Model.contains("Pixel"))
            {
            ClickTnC_AN("C://HPE//FunctionalTesting//Images//TermsAndConditions"+".png");
            } else
            {
            ClickTnC_AN("C://HPE//FunctionalTesting//Images//TermsAndConditions_Galaxy"+".png");
            }
            
     }
        public static void ClickTnC_AN(String imagePath) throws Exception
		{	
		
	    	try {
		    		 	Thread.sleep(10000); 
						//nativedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						//WebElement Remove = visualdriver.findElement(ByMobile.image(imagePath));
						WebElement TnC = visualdriver.findElement(ByMobile.image(imagePath));
						TnC.click();	
						Thread.sleep(5000);
						testLog.info("Clicked on Terms and Condition option");							
						status1 = 1;
						
					} catch (Exception e) {
						testLog.info("\nImage not present : " + imagePath);	
						testLog.info("Terms and Condition option is not present");
						status1 = 0;
						CaptureScreenshot("TC_Fail_"); 
						//ClickSignOut();
						Close_App_HPE();
                        Thread.sleep(2000);
						Assert.fail("Terms and Condition option is not present");
						
					}
		   	}
		   	

	     //Method to click on back button on the page
	    public static void ClickBackButton() throws Exception
			      {
			    	if(Device_Model.equals("iPhone-7"))
			    	{
			    		ClickBackButton("C://HPE//FunctionalTesting//Images//BackButton" +".png");
			    	} else if(Device_Model.equals("iPhone-5S"))
 			    	{
			    		ClickBackButton("C://HPE//FunctionalTesting//Images//BackButton_iPhone5S" +".png");
 			    	}else if(Device_Model.contains("Pixel"))
			    	{
			    		ClickBackButton("C://HPE//FunctionalTesting//Images//BackButton_AN" +".png");
			    	}else if(Device_Model.contains("Galaxy S6"))
                    {
                        ClickBackButton("C://HPE//FunctionalTesting//Images//BackButton_Galaxy" +".png");
                 } else if(Device_Model.contains("Galaxy S7"))
                 {
                        ClickBackButton("C://HPE//FunctionalTesting//Images//BackButton_Galaxy" +".png");
                 }else if(Device_Model.equals("iPhone-6S"))
			    	{
			    		ClickBackButton("C://HPE//FunctionalTesting//Images//BackButton" +".png");
			    	}

			    	          
			      }
	    
 	    
			//Method to Click on Back button button 
			public static void ClickBackButton(String imagePath) throws Exception
			{	
			
		    	try {
			    		 	Thread.sleep(10000); 
							//nativedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
							//WebElement Remove = visualdriver.findElement(ByMobile.image(imagePath));
							WebElement BackButton = visualdriver.findElement(ByMobile.image(imagePath));
							BackButton.click();	
							Thread.sleep(5000);
							testLog.info("Clicked on Back button");							
							status1 = 1;
							
						} catch (Exception e) {
							testLog.info("\nImage not present : " + imagePath);	
							testLog.info("Back button is not present");
							status1 = 0;
							CaptureScreenshot("TC_Fail_"); 
							//ClickSignOut();
							Close_App_HPE();
                            Thread.sleep(2000);
							Assert.fail("Back button is not present");
							
						}
			   	}
			   	
			
			//Method to click on search icon
		    public static void ClickOnSearchIcon() throws Exception
		      {
		    	if(Device_Model.equals("iPhone-7"))
		    	{
		    		//ClickOnSearchIcon_iOS();
		    		ClickSearchIcon_iOS("C://HPE//FunctionalTesting//Images//SearchIcon_iOS" +".png");
		    	}else if(Device_Model.equals("iPhone-5S"))
		    	{
		    		//ClickOnSearchIcon_iOS();
		    		ClickSearchIcon_iOS("C://HPE//FunctionalTesting//Images//SearchIcon_iPhone5S" +".png");
		    	}else if(Device_Model.contains("Tab"))
		    	{
		    		//ClickOnSearchIcon_iOS();
		    		ClickSearchIcon_iOS("C://HPE//FunctionalTesting//Images//SearchIcon_Tab" +".png");
		    	}else if(Device_Model.contains("Galaxy S6"))
                {
                    ClickOnSearchIcon_AN("C://HPE//FunctionalTesting//Images//SearchIcon_Galaxy"+".png");
             } else if(Device_Model.contains("Galaxy S7"))
                           {
                    ClickOnSearchIcon_AN("C://HPE//FunctionalTesting//Images//SearchIcon_GalaxyS7"+".png");
                           }else if(Device_Model.contains("Pixel"))

		    	{
		    		ClickOnSearchIcon_AN("C://HPE//FunctionalTesting//Images//SearchIcon"+".png");
		    	}else if(Device_Model.equals("iPhone-6S"))
		    	{
		    		//ClickOnSearchIcon_iOS();
		    		ClickSearchIcon_iOS("C://HPE//FunctionalTesting//Images//SearchIcon_iOS" +".png");
		    	}
		    	          
		      }   
		
		    
		  //Method to click on search icon
		    public static void VerifySearchPage() throws Exception
		      {
		    	if((Device_Model.contains("iPhone"))||(Device_Model.contains("iPad")))
		    	{
		    		VerifySearchPage_iOS();
		    	}else
		    	{
		    		VerifySearchPage_AN();
		    	}
		    	          
		      }
		    
			  //Method to click on Get Support option
		    public static void ClickGetSupportOption() throws Exception
		      {
		    	if((Device_Model.contains("iPhone"))||(Device_Model.contains("iPad")))
		    	{
		    		ClickGetSupportOption_iOS();
		    	}else if (Device_Model.contains("Pixel"))
                {
                    ClickGetSupportOption_AN("C://HPE//FunctionalTesting//Images//GetSupport"+".png");
             } else if (Device_Model.contains("Galaxy S6"))
             {
                    ClickGetSupportOption_AN("C://HPE//FunctionalTesting//Images//GetSupport_Galaxy"+".png");
             }else if (Device_Model.contains("Galaxy S7"))
             {
            	 ClickGetSupportOption_AN("C://HPE//FunctionalTesting//Images//GetSupport_GalaxyS7"+".png");
             }
	    	          
		      }
		 // Method to click on Apply button in Android 
            
            public static void ClickApply_AN(String imagePath) throws Exception
           {
           try
                  {
           
           nativedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
           WebElement ApplyButton = visualdriver.findElement(ByMobile.image(imagePath));
           ApplyButton.click();
           testLog.info("\n Image found is : " + imagePath);
           testLog.info("Clicked on Apply Button");
           
                  } catch (Exception e) 
                  {
           testLog.info("\nImage not present : " + imagePath);    
           testLog.info("Apply button  not found");
           HPECommonFunctions.ClickCloseIcon("C://HPE//FunctionalTesting//Images//FilterClose_AN" +".png");
           Close_App_HPE();
           status1 = 1;
           Assert.fail("Apply button is not Present");
                   }
           }

public static void ClickApply() throws Exception
          {
                 if(Device_Model.contains("iPhone"))
                 {
                      ClickApply_iOS();
                 }else if(Device_Model.contains("Pixel"))
             
           		 {	
        	   		   ClickApply_AN("C://HPE//FunctionalTesting//Images//ApplyFilter"+".png");
           		 } else if(Device_Model.contains("Galaxy S7"))
                 {
           			ClickApply_AN("C://HPE//FunctionalTesting//Images//ApplyFilter_GalaxyS7" +".png");
                 }if(Device_Model.contains("Galaxy S6"))
                 {
                	 ClickApply_AN("C://HPE//FunctionalTesting//Images//ApplyFilter_Galaxy" +".png");
                 }
          			}

			//Method to Click on Search icon 
			public static void ClickOnSearchIcon_iOS() throws Exception
			{	
			
				device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("702,428")));
				System.out.println("Clicked on Search icon");
			    Thread.sleep(10000); 
			    
			
			} 
			
			//Method to click on Alerts from tool bar
			public static void ClickAlerts_iOS() throws Exception
			{
				try
				{			
				WebElement Alerts = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Alerts")));
				if(!Alerts.isDisplayed())
				{				
					Alerts.click();
					System.out.println("Clicked on Alerts");
					Thread.sleep(5000);				
				}
				}
				catch(Exception e)
				{
					System.out.println("Alerts is not Present");				
					CaptureScreenshot("TC_Fail_");				
					//ClickSignOut();
					Close_App_HPE();
                    Thread.sleep(2000);
					Assert.fail("Alerts is not Present");
				}
				
			}
			
			// Method to click on Alerts from tool bar for Android

            
            public static void ClickAlerts_AN(String imagePath) throws Exception
            
            {
              try
              {
            	  		 nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                         WebElement AlertIcon = visualdriver.findElement(ByMobile.image(imagePath));                              
                         AlertIcon.click();
                         testLog.info("\n Image found is : " + imagePath);
                         testLog.info("Clicked on Alerts");
                   } catch (Exception e) {
                        testLog.info("\nImage not present : " + imagePath);    
                         testLog.info("Alerts not present");
                         status1 = 1;
                         CaptureScreenshot("TC_Fail_"); 
     					 //ClickSignOut();
     					Close_App_HPE();
                        Thread.sleep(2000);
     					 Assert.fail("Alerts not present");
                   }
         }

//Method to click on Alerts
                         public static void ClickAlerts() throws Exception
                           {
                            if(Device_Model.contains("iPhone"))
                            {
                                      ClickAlerts_iOS();
                            }else if(Device_Model.contains("Pixel"))             
                                
                            {
                                ClickAlerts_AN("C://HPE//FunctionalTesting//Images//Alerts_AN" +".png");
                             }else if(Device_Model.contains("Galaxy"))
                                        
                                  {
                                     ClickAlerts_AN("C://HPE//FunctionalTesting//Images//Alerts_Galaxy" +".png");
                                  } else if(Device_Model.contains("Galaxy S7"))
                                      
                                {
                                   ClickAlerts_AN("C://HPE//FunctionalTesting//Images//Alerts_GalaxyS7" +".png");
                                }
                                      
                           }
                         
                         
// Method to click on search result in Galaxy
                         
                         public static void ClickOnSearchResult_Galaxy() throws Exception
                         {
                                      try{ 
                                           
                                         Find_Text_NoResults(config.getProperty("NoResults"));
                                                                                  
                                      }
                                      catch(Exception e)
                                      {
                                    device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("319,1038")));
                                    System.out.println("Clicked on any order in Search Page");
                                    Thread.sleep(10000); 
                                    try{
                                                              CheckServiceError("C://HPE//FunctionalTesting//Images//ServiceErrorOK" +".png");
                                                              }catch (Exception e1)
                                                       {
                                                              System.out.println("Service Error did not appear");
                                                       }
                                       
                                       HPECommonFunctions.Find_Text(config.getProperty("OrderDetails_PageTitle"));
                                       HPECommonFunctions.VerifyBackButton();
                                       HPECommonFunctions.ClickSignOut();
                                       HPECommonFunctions.Close_App_HPE();
                                      
                                         }
                                  
                                      }

                       //Method to click on Recent Search in Watchlist
                         public static void ClickRecentSearches() throws Exception
                           {
                            if(Device_Model.contains("iPhone"))
                            {
                                   ClickRecentSearches_iOS();
                            }else if(Device_Model.contains("Pixel"))          
                                
                            	{
                                         ClickRecentSearches_AN("C://HPE//FunctionalTesting//Images//Recent_Pixel1"+".png");
                                  } else if(Device_Model.contains("Galaxy S6"))  
                                  {
                                         ClickRecentSearches_AN("C://HPE//FunctionalTesting//Images//Recent_Galaxy"+".png");
                                  } else if(Device_Model.contains("Galaxy S7"))  
                                  {
                                      ClickRecentSearches_AN("C://HPE//FunctionalTesting//Images//Recent_GalaxyS7"+".png");
                               }
                                            
                                 }


                         
			//Method to click on WatchList from tool bar
			public static void ClickWatchListOnToolbar_iOS() throws Exception
			{
				try
				{			
				WebElement WatchList = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("WatchList1")));
				if(!WatchList.isDisplayed())
				{				
					WatchList.click();
					System.out.println("Clicked on WatchList");
					Thread.sleep(5000);				
				}
				}
				catch(Exception e)
				{
					System.out.println("WatchList is not Present");				
					CaptureScreenshot("TC_Fail_");				
					//ClickSignOut();
					Close_App_HPE();
                    Thread.sleep(2000);
					Assert.fail("WatchList is not Present");
				}
				
			}
			
			//Method to click on WatchList on Toolbar 
            public static void ClickWatchListOnToolbar() throws Exception
         {
                if(Device_Model.equals("iPhone-7"))
                { 
                	//ClickWatchListOnToolbar_iOS();
                	ClickWatchListonToolbar("C://HPE//FunctionalTesting//Images//WatchList_Toolbar"+".png");
                }else if(Device_Model.equals("iPhone-5S"))
                { 
                	//ClickWatchListOnToolbar_iOS();
                	ClickWatchListonToolbar("C://HPE//FunctionalTesting//Images//WatchList_Toolbar_iPhone5S"+".png");
                }else if(Device_Model.equals("Pixel"))
                {
                	ClickWatchListonToolbar("C://HPE//FunctionalTesting//Images//WatchList_Toolbar_Pixel"+".png");
                } else if(Device_Model.equals("Galaxy S6"))
                {
                	ClickWatchListonToolbar("C://HPE//FunctionalTesting//Images//WatchList_Toolbar_Galaxy"+".png");
                }else if(Device_Model.equals("Galaxy S7"))
                {
                	ClickWatchListonToolbar("C://HPE//FunctionalTesting//Images//WatchList_Toolbar_GalaxyS7"+".png");
                }else if(Device_Model.equals("iPhone-6S"))
                { 
                	//ClickWatchListOnToolbar_iOS();
                	ClickWatchListonToolbar("C://HPE//FunctionalTesting//Images//WatchList_Toolbar"+".png");
                }
                
         } 
			
				// Method to Verify the Alert Page on iOS  
                public static void VerifyAlertsPage_iOS() throws Exception
                {
               	 try
                      {
                                                         
               		 //WebElement AlertsPage = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("AlertsPageTitle")));
               		WebElement AlertsPage = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("AlertsPageTitle")));
               		 
               		Thread.sleep(1000);
               		 if (!AlertsPage.isDisplayed())
               		 {
               			 System.out.println("Alerts Page is displayed");
               			 //Thread.sleep(5000);
               			 nativedriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
               		 }
                      }
                
                catch(Exception e)
                {
                      System.out.println("Alerts Page is not displayed");                         
                      CaptureScreenshot("TC_Fail_");           
                      //ClickSignOut();
                      Close_App_HPE();
                      Thread.sleep(2000);
                      Assert.fail("Alerts Page is not displayed");
                }
                
              
			}
                
                //Method to verify the text on any page (Checkpoint)
                public static void Find_Text(String linktext) throws Exception {
                	try {
                		IMobileWebDriver Text = device.getVisualDriver();
                		Thread.sleep(3000);               		
                		Text.findElement(By.linkText(linktext));
                		testLog.info("\n Element found is : " + linktext);
                		Thread.sleep(2000);
                	} catch (Exception e) {
                		testLog.info("\nElement not found : " + linktext);
                		CaptureScreenshot("TC_Fail_");	
                		//ClickSignOut();
                		Close_App_HPE();
                        Thread.sleep(2000);
                		Assert.fail("\nElement not found : " + linktext);
                		status1 = 1;
                	}
                }
                	
                
              //Method to verify the text on any page (Checkpoint)
                public static void Find_Order_Status(String linktext) throws Exception {
                
                		IMobileWebDriver Text = device.getVisualDriver();
                		Text.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);                		
                		Text.findElement(By.linkText(linktext));
                		testLog.info("\n Element found is : " + linktext);
                		Thread.sleep(5000);
                	
                }
                
                //Method to verify the text on any page (Checkpoint)
                public static void Find_Text_WatchListTips(String linktext) throws Exception {
                	
                		IMobileWebDriver Text = device.getVisualDriver();
                		Text.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);                		
                		Text.findElement(By.linkText(linktext));
                		testLog.info("\n Element found is : " + linktext);
                		testLog.info("There are no orders tagged to Watchlist");
                		Close_App_HPE();
                	
                }
                	public static void VerifyConnectivity(String linktext) throws Exception {
                    	try {
                    		Thread.sleep(2000);
                    		IMobileWebDriver VerifyConnectivity = device.getVisualDriver();
                    		VerifyConnectivity.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    		// device.getVisualDriver().findElementByLinkText(xpath).toString().contains(object_name);
                    		VerifyConnectivity.findElement(By.linkText(linktext));
                    		testLog.info("\n Element found is : " + linktext);
                    		testLog.info("\n User is connected to 4g or wifi");
                    	} catch (Exception e) {
                    		testLog.info("\nElement not found : " + linktext);
                    		testLog.info("\n User is not connected to 4g or wifi");
                    		//CaptureScreenshot("TC_Fail_");	
                    		//Close_App_HPE();
                            Thread.sleep(2000);
                    		Assert.fail("\n User is not connected to 4g or wifi");
                    		status1 = 1;
                    	}

                } 
                	
                	
        //Method to verify the Service error
           	     public static void CheckServiceError(String imagePath) throws Exception
           	     {
           	    	 
           	    	 	Thread.sleep(10000); 
           				//nativedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
           				//WebElement Remove = visualdriver.findElement(ByMobile.image(imagePath));
           				WebElement ServiceErrorOK = visualdriver.findElement(ByMobile.image(imagePath));
           				ServiceErrorOK.click();
           				testLog.info("\n Image found is : " + imagePath);
           				testLog.info("Service Error Appeared");
           				CaptureScreenshot("TC_Fail_");
           				Close_App_HPE();
           				status1 = 1;
           				
           				Assert.fail("Service Error Appeared");
           	     }
      
           	     
           	//Method to click on Search from tool bar
     			public static void ClickSearch_iOS() throws Exception
     			{
     				try
     				{			
     				WebElement Search = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Search")));
     				if(!Search.isDisplayed())
     				{				
     					Thread.sleep(5000);
     					Search.click();
     					System.out.println("Clicked on Search");
     					Thread.sleep(10000);				
     				}
     				}
     				catch(Exception e)
     				{
     					System.out.println("Search is not Present");				
     					CaptureScreenshot("TC_Fail_");				
     					//ClickSignOut();
     					Close_App_HPE();
                        Thread.sleep(2000);
     					Assert.fail("Search is not Present");
     				}
     				
     			}
     			
// Method to click on Search from tool bar for Android

                
                public static void ClickSearch_AN(String imagePath) throws Exception
                
                {
                  try
                  {
                             WebElement SearchIconWatch = visualdriver.findElement(ByMobile.image(imagePath));                              
                             SearchIconWatch.click();
                             testLog.info("\n Image found is : " + imagePath);
                             testLog.info("Clicked on Search");
                             Thread.sleep(10000);
                       } catch (Exception e) {
                             testLog.info("\nImage not present : " + imagePath);    
                             testLog.info("Search not present");
                             status1 = 1;
                             CaptureScreenshot("TC_Fail_");				
          					 //ClickSignOut();
          					Close_App_HPE();
                            Thread.sleep(2000);
                             Assert.fail("Search not present");
                             
                             
                       }
             }

//Method to click on Search in Watchlist
                               public static void ClickSearch() throws Exception
                                 {
                                  if(Device_Model.equals("iPhone-7"))
                                  {
                                	  		ClickSearch_AN("C://HPE//FunctionalTesting//Images//Footer_Search"+".png");
                                  }else  if(Device_Model.equals("iPhone-5S"))
                                  {
                          	  		ClickSearch_AN("C://HPE//FunctionalTesting//Images//SearchWatchList_iPhone5S"+".png");
                                  }else if(Device_Model.contains("Pixel"))           
                                
                                  {
                                          ClickSearch_AN("C://HPE//FunctionalTesting//Images//SearcWatchListPage_Pixel"+".png");
                                  } else if(Device_Model.contains("Galaxy S6"))  
                                  {
                                     ClickSearch_AN("C://HPE//FunctionalTesting//Images//SearcWatchListPage_Galaxy"+".png");   
                                   } else if(Device_Model.contains("Galaxy S7"))  
                                   {
                                	   ClickSearch_AN("C://HPE//FunctionalTesting//Images//SearcWatchListPage_GalaxyS7"+".png");
                                   }else if(Device_Model.equals("iPhone-6S"))
                                   {
                           	  		ClickSearch_AN("C://HPE//FunctionalTesting//Images//Footer_Search"+".png");
                             }

                                            
                                 }

                               
     			//Method to click on Search icon on iOS
     		     public static void ClickSearchIcon_iOS(String imagePath) throws Exception
     		     {
     		    	 try {
     						
     		    		 	
     		    		 	visualdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     						//nativedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     						//WebElement Remove = visualdriver.findElement(ByMobile.image(imagePath));
     						WebElement SearchIcon = visualdriver.findElement(ByMobile.image(imagePath));

     						testLog.info("\n Image found is : " + imagePath);
     						testLog.info("Search icon is present");
     						SearchIcon.click();
     						testLog.info("Clicked on Search icon");
     						Thread.sleep(10000);
     						status1 = 0;
     						
     					} catch (Exception e) {
     						testLog.info("\nImage not present : " + imagePath);	
     						testLog.info("Search Icon is not present");
     						status1 = 1;
     						CaptureScreenshot("TC_Fail_");				
         					 //ClickSignOut();
         					Close_App_HPE();
                            Thread.sleep(2000);
                            Assert.fail("Search Icon is not present");
     					}
     		   	}

				public static void ClickRecentSearches_iOS() throws Exception {
					
					try
     				{	
						nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						WebElement RecentSearch = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("RecentSearches")));
						if(!RecentSearch.isDisplayed())
     				{				
     					Thread.sleep(5000);
     					RecentSearch.click();
     					System.out.println("Clicked on Recent Searches");
     					Thread.sleep(10000);
     					//nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     				}
     				}
     				catch(Exception e)
     				{
     					System.out.println("Recent Searches is not Present");				
     					CaptureScreenshot("TC_Fail_");				
     					//ClickSignOut();
     					Close_App_HPE();
                        Thread.sleep(2000);
     					Assert.fail("Recent Searches is not Present");
     				}
					
				}
				
// Method to click on Recent Search from tool bar for Android

                
                public static void ClickRecentSearches_AN(String imagePath) throws Exception
                
                {
                  try
                  
                  {
                	         nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                	         WebElement RecentSearch = visualdriver.findElement(ByMobile.image(imagePath));                              
                             RecentSearch.click();
                             testLog.info("\n Image found is : " + imagePath);
                             testLog.info("Clicked on Recent Search");
                       } catch (Exception e) {
                             testLog.info("\nImage not present : " + imagePath);    
                             testLog.info("Recent Search not present");
                             status1 = 1;
                             CaptureScreenshot("TC_Fail_");				
          					 //ClickSignOut();
          					Close_App_HPE();
                            Thread.sleep(2000);
                             Assert.fail("Recent Search not present");
                       }
             }

                	//Method to click on Watchlist
                               public static void ClickWatchList() throws Exception
                                 {
                                  if(Device_Model.equals("iPhone-7"))
                                  {
                                	  ClickWatchList("C://HPE//FunctionalTesting//Images//WatchList_Arrow"+".png");
                                  }else if(Device_Model.equals("iPhone-5S"))
                                  {
                                	  ClickWatchList("C://HPE//FunctionalTesting//Images//WatchList_Arrow_iPhone5S"+".png");
                                  }else if(Device_Model.contains("Pixel"))            
                                      
                                  {
                                      //  ClickWatchList_AN();
                                        ClickWatchList("C://HPE//FunctionalTesting//Images//WatchList_Arrow_AN"+".png");
                                  } else if(Device_Model.contains("Galaxy S6"))
                                  {
                                          ClickWatchList("C://HPE//FunctionalTesting//Images//WatchList_Arrow_Galaxy"+".png");
                                   } else if(Device_Model.contains("Galaxy S7"))
                                   {
                                	   ClickWatchList("C://HPE//FunctionalTesting//Images//WatchList_Arrow_GalaxyS7"+".png");
                                   }else if(Device_Model.equals("iPhone-6S"))
                                   {
                                 	  ClickWatchList("C://HPE//FunctionalTesting//Images//WatchList_Arrow"+".png");
                                   }   
                                 }

			
			
			//Method to click on the order in WatchList page for iOS
            public static void ClickWatchListResult1_iOS() throws Exception 
            {
            	try{
                      Find_Text_WatchListTips(config.getProperty("WatchListTips"));
            	}catch(Exception e)
            	{
                       device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("311,543")));
                       System.out.println("Clicked on any order on Page");
                       Thread.sleep(10000); 
                       
                       	HPECommonFunctions.Find_Text(config.getProperty("OrderDetail_PageTitle"));    
                    	HPECommonFunctions.VerifyFooterComponents();
                    	HPECommonFunctions.VerifyBackButton();
                    	HPECommonFunctions.ClickBackButton();
                    	HPECommonFunctions.Find_Text(config.getProperty("WatchList_PageTitle"));
                    	//HPECommonFunctions.ClickWatchListResult1();
                    	device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("311,543")));
                        System.out.println("Clicked on any order on Page");
                        Thread.sleep(10000); 
                    	HPECommonFunctions.Find_Text(config.getProperty("OrderDetail_PageTitle")); 
                    	HPECommonFunctions.VerifyMenuBar();
                    	HPECommonFunctions.ClickMenuBar();
                    	HPECommonFunctions.VerifyMenuSlide();     
                    	HPECommonFunctions.ClickSignOut();
                    	HPECommonFunctions.Close_App_HPE();
            	}
                                                                         
             }
			
			//Method to click on the order in WatchList page in Android
            public static void ClickWatchListResult1_AN() throws Exception 
            {
            	try{
                      Find_Text_WatchListTips(config.getProperty("WatchListTips"));
            	}catch(Exception e)
            	{
                       device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("243,545")));
                       System.out.println("Clicked on any order on Page");
                       Thread.sleep(10000); 
                       
                       	HPECommonFunctions.Find_Text(config.getProperty("OrderDetail_PageTitle"));    
                    	HPECommonFunctions.VerifyFooterComponents();
                    	HPECommonFunctions.VerifyBackButton();
                    	HPECommonFunctions.ClickBackButton();
                    	HPECommonFunctions.Find_Text(config.getProperty("WatchList_PageTitle"));
                    	HPECommonFunctions.ClickWatchListResult1();     
                    	HPECommonFunctions.Find_Text(config.getProperty("OrderDetail_PageTitle")); 
                    	HPECommonFunctions.VerifyMenuBar();
                    	HPECommonFunctions.ClickMenuBar();
                    	HPECommonFunctions.VerifyMenuSlide();     
                    	HPECommonFunctions.ClickSignOut();
                    	HPECommonFunctions.Close_App_HPE();
            	}
                                                                         
             }
            
            
            public static void ClickWatchListResult1() throws Exception
            {
                   if(Device_Model.contains("iPhone"))
             {
                        ClickWatchListResult1_iOS();
             } else
             {
             			ClickWatchListResult1_AN();
               }
            }

            
            
            
          //Method to click on the order in WatchList page	
            public static void ClickWatchListResult2_iOS() throws Exception {
                
                try{
                      Find_Text_WatchListTips(config.getProperty("WatchListTips"));
                      
                } catch (Exception e)
                                  
                {
                            device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("311,543")));
                            System.out.println("Clicked on any order on iphone");
                            Thread.sleep(10000); 
                                  
                            HPECommonFunctions.VerifyEndCustomerName();
                           HPECommonFunctions.Find_Text(config.getProperty("HPEOrderNumber"));
                           HPECommonFunctions.Find_Text(config.getProperty("PONumber"));
                           HPECommonFunctions.Find_Text(config.getProperty("OrderStatus"));
                           HPECommonFunctions.Find_Text_DateShipped(config.getProperty("DateShipped"));
                           HPECommonFunctions.Find_Text_Previously(config.getProperty("Previously"));
                           HPECommonFunctions.ClickBackButton();
                           Thread.sleep(5000); 
                            device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("372,638")));
                            System.out.println("Clicked on another order on iphone");
                            Thread.sleep(10000); 
                           //HPECommonFunctions.ClickWatchListResult2();
                           HPECommonFunctions.VerifyEndCustomerName();
                           HPECommonFunctions.Find_Text(config.getProperty("HPEOrderNumber"));
                           HPECommonFunctions.Find_Text(config.getProperty("PONumber"));
                           HPECommonFunctions.Find_Text(config.getProperty("OrderStatus"));
                           HPECommonFunctions.Find_Text_DateShipped(config.getProperty("DateShipped"));
                           HPECommonFunctions.Find_Text_Previously(config.getProperty("Previously")); 
                           HPECommonFunctions.ClickSignOut();
                           HPECommonFunctions.Close_App_HPE();
                                                                      
                }
                
          }

			
			//Method to click on the order in WatchList page in Android
            public static void ClickWatchListResult2_AN() throws Exception 
            {
            	try{
                      Find_Text_WatchListTips(config.getProperty("WatchListTips"));
            	}catch(Exception e)
            	{
                       device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("243,545")));
                       System.out.println("Clicked on any order on Page");
                       Thread.sleep(10000); 
                       
                       HPECommonFunctions.VerifyEndCustomerName();
                       HPECommonFunctions.Find_Text(config.getProperty("HPEOrderNumber"));
                       HPECommonFunctions.Find_Text(config.getProperty("PONumber"));
                       HPECommonFunctions.Find_Text(config.getProperty("OrderStatus"));
                       HPECommonFunctions.Find_Text_DateShipped(config.getProperty("DateShipped"));
                       HPECommonFunctions.Find_Text_Previously(config.getProperty("Previously"));
                       HPECommonFunctions.ClickBackButton();
                       
                       HPECommonFunctions.ClickWatchListResult2();
                       HPECommonFunctions.VerifyEndCustomerName();
                       HPECommonFunctions.Find_Text(config.getProperty("HPEOrderNumber"));
                       HPECommonFunctions.Find_Text(config.getProperty("PONumber"));
                       HPECommonFunctions.Find_Text(config.getProperty("OrderStatus"));
                       HPECommonFunctions.Find_Text_DateShipped(config.getProperty("DateShipped"));
                       HPECommonFunctions.Find_Text_Previously(config.getProperty("Previously")); 
                       HPECommonFunctions.ClickSignOut();
                       HPECommonFunctions.Close_App_HPE();
            	}
                                                                         
             }
            
            
            
   public static void ClickWatchListResult2() throws Exception
   {
          if(Device_Model.contains("iPhone"))
    {
               ClickWatchListResult2_iOS();
    } else
    {
    			ClickWatchListResult2_AN();
      }
   }

   

				//Method to Click on any order on the Search result page
				public static void ClickOnSearchResult_iOS() throws Exception
				{	
					 try{ 
                               	  
                   	 		Find_Text_NoResults(config.getProperty("NoResults"));
                   	 		                      	 		
                                 }
                      catch(Exception e)
                                 {
                               device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("514,865")));
                               System.out.println("Clicked on any order in Search Page");
                               Thread.sleep(10000); 
                               
                               try{
       							CheckServiceError("C://HPE//FunctionalTesting//Images//ServiceErrorOK" +".png");
       							
       							
       							}catch (Exception e1)
       						{
       							System.out.println("Service Error did not appear");
       						}
                               
                               HPECommonFunctions.Find_Text(config.getProperty("OrderDetails_PageTitle"));
                               HPECommonFunctions.VerifyBackButton();
                               HPECommonFunctions.ClickSignOut();
                               HPECommonFunctions.Close_App_HPE();
                              
                                 }
                                                                                                                      
                          
					
									    				
				}
				
				// Method to click on search result
                
                public static void ClickOnSearchResult3_iOS() throws Exception
                {
                             try{ 
                           	  
                            	 Find_Text_NoResults(config.getProperty("NoResults"));
               	 		                      	 		
                             }
                             catch(Exception e)
                             {
                            	 device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("514,865")));
                            	 System.out.println("Clicked on any order in Search Page");
                            	 Thread.sleep(10000); 
                            	 HPECommonFunctions.Find_No_Text(config.getProperty("Invoice"));                    
                            	 HPECommonFunctions.ClickSignOut();
                            	 HPECommonFunctions.Close_App_HPE();
                           
                             }
                                                                                                                  
                      }
				
				
             
                	
				
				
				//Method to click on search icon
			    public static void ClickOnSearchResult() throws Exception
			      {
			    	if(Device_Model.contains("iPhone"))
			    	{
			    		ClickOnSearchResult_iOS();
			    	}else if(Device_Model.contains("iPad"))
			    	{
			    		ClickOnSearchResult_iOS();
			    	}else if(Device_Model.contains("Pixel"))
			    	{
			    		ClickOnSearchResult_AN();
			    	} else if(Device_Model.contains("Galaxy S7"))
			    	{
			    		ClickOnSearchResult_GalaxyS7();
			    	}
			    	          
			      }
			    
			    //Method to click on search icon
			    public static void ClickOnSearchResult2() throws Exception
			      {
			    	if(Device_Model.contains("iPhone"))
			    	{
			    		ClickOnSearchResult2_iOS();
			    	}else
			    	{
			    		ClickOnSearchResult2_AN();
			    	}
			    	          
			      }
			    
			    
			  //Method to click on search icon
			    public static void ClickOnSearchResult3() throws Exception
			      {
			    	if(Device_Model.contains("iPhone"))
			    	{
			    		ClickOnSearchResult3_iOS();
			    	}else if(Device_Model.contains("iPad"))
			    	{
			    		ClickOnSearchResult3_iOS();
			    	}else if(Device_Model.contains("Pixel"))
			    	{
			    		ClickOnSearchResult3_AN();
			    	}
			    	          
			      }
			    
			    
			  //Method to click on search icon
			    public static void ClickOnSearchResult5() throws Exception
			      {
			    	if(Device_Model.contains("iPhone"))
			    	{
			    		ClickOnSearchResult5_iOS();
			    	}else if(Device_Model.contains("Pixel"))
                    {
                        ClickOnSearchResult5_AN();
                 } else if(Device_Model.contains("Galaxy"))
                 {
                        ClickOnSearchResult5_Galaxy();
                 }
			   }
			    
			    
			 // Method to click on search result in Galaxy
                
                public static void ClickOnSearchResult5_Galaxy() throws Exception
                {
                             try{ 
                                  
                                Find_Text_NoResults(config.getProperty("NoResults"));
                                                                         
                             }
                             catch(Exception e)
                             {
                           device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("672,1023")));
                           System.out.println("Clicked on any order in Search Page");
                           Thread.sleep(10000); 
                           HPECommonFunctions.Find_Text(config.getProperty("Invoice"));                                           
                           HPECommonFunctions.ClickSignOut();
                                HPECommonFunctions.Close_App_HPE();
                           
                             }
                                                                                                                  
                      }

             // Method to click on search result
                
                public static void ClickOnSearchResult3_Galaxy() throws Exception
                {
                             try{ 
                                  
                                Find_Text_NoResults(config.getProperty("NoResults"));
                                                                         
                             }
                             catch(Exception e)
                             {
                           device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("306,791")));
                           System.out.println("Clicked on any order in Search Page");
                           Thread.sleep(10000); 
                           HPECommonFunctions.Find_No_Text(config.getProperty("Invoice"));                    
                           HPECommonFunctions.ClickSignOut();
                           HPECommonFunctions.Close_App_HPE();
                           
                             }
                             
                }

			    
				  //Method to click on search icon
			    public static void ClickOnSearchResult4() throws Exception
			      {
			    	if(Device_Model.contains("iPhone"))
			    	{
			    		ClickOnSearchResult4_iOS();
			    	}else if(Device_Model.contains("iPad"))
			    	{
			    		ClickOnSearchResult4_iOS();
			    	}else if(Device_Model.contains("Galaxy"))
                    {
                        ClickOnSearchResult4_Galaxy();
                        
                    }else if(Device_Model.contains("Pixel"))

			    	{
			    		ClickOnSearchResult4_AN();
			    	}
			    	          
			      }
				
			    public static void ClickOnSearchResult4_Galaxy() throws Exception
                {
                             try{ 
                                  
                                Find_Text_NoResults(config.getProperty("NoResults"));
                                                                         
                             }
                             catch(Exception e)
                             {
                           device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("672,1023")));
                           System.out.println("Clicked on any order in Search Page");
                           Thread.sleep(10000); 
                   //        HPECommonFunctions.VerifyDeliveredStatus("C://HPE//FunctionalTesting//Images//Delivered_symbol"+".png");
                           HPECommonFunctions.Find_Text(config.getProperty("Invoice"));          
                           HPECommonFunctions.ClickInvoiceAvailableButton();
                           
                           HPECommonFunctions.ClickSignOut();
                           HPECommonFunctions.Close_App_HPE();
                           
                             }
                                                                                                                  
                      }

			    
			  //Method to Click on Delete button on Recent Searches page 
				public static void ClickDeleteButton_iOS(String imagePath) throws Exception
				{	
				
			    	try {
			    		 		Thread.sleep(5000);
			    				System.out.println("Swiping left on the screen");
			    				device.getMobileTouchScreen().swipe(new MobileCoordinates(new MobilePoint("583,684")), new MobileCoordinates(new MobilePoint("23,704")), 1);
			    			    Thread.sleep(10000);
			    		        
								//nativedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
								//WebElement Remove = visualdriver.findElement(ByMobile.image(imagePath));
								WebElement DeleteButton = visualdriver.findElement(ByMobile.image(imagePath));
								DeleteButton.click();							
								testLog.info("Clicked on Delete button");	
								testLog.info("Saved Search is deleted from the list");
								status1 = 1;
								
							} catch (Exception e) {
								testLog.info("\nImage not present : " + imagePath);	
								testLog.info("Delete button is not present");
								testLog.info("Saved Search is not deleted from the list");
								status1 = 0;
								CaptureScreenshot("TC_Fail_");				
	         					 //ClickSignOut();
								Close_App_HPE();
	                            Thread.sleep(2000);
	                             Assert.fail("Saved Search is not deleted from the list");
							}
				   	}
				
				//Method to click on Delete button
                public static void ClickDeleteButton() throws Exception
                  {
                   if(Device_Model.equals("iPhone-7"))
                   {
                          ClickDeleteButton_iOS("C://HPE//FunctionalTesting//Images//RemoveButton"+".png");
                   }else if(Device_Model.equals("iPhone-5S"))
                   {
                       ClickDeleteButton_iOS("C://HPE//FunctionalTesting//Images//RemoveButton_iPhone5S"+".png");
                   }  else if (Device_Model.equals("Galaxy S6"))    
                
                	{
                          ClickDeleteButton_AN("C://HPE//FunctionalTesting//Images//RemoveButton_Pixel"+".png");
                   }else if (Device_Model.equals("Galaxy S7"))    
                       
                   			{
                                ClickDeleteButton_AN("C://HPE//FunctionalTesting//Images//RemoveButton_GalaxyS7"+".png");
                         } else if(Device_Model.equals("iPhone-6S"))
                         {
                             ClickDeleteButton_iOS("C://HPE//FunctionalTesting//Images//RemoveButton"+".png");
                      }
                             
                  }

				   	  
				//Method to Click on Delete button on Recent Searches page for Android
                public static void ClickDeleteButton_AN(String imagePath) throws Exception
                {      
                
                 try {
                                      Thread.sleep(5000);
                                     System.out.println("Swiping left on the screen");
                                     device.getMobileTouchScreen().swipe(new MobileCoordinates(new MobilePoint("699,412")), new MobileCoordinates(new MobilePoint("106,430")), 1);
                                   Thread.sleep(10000);
                                
                                            //nativedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                                            //WebElement Remove = visualdriver.findElement(ByMobile.image(imagePath));
                                            WebElement DeleteButton = visualdriver.findElement(ByMobile.image(imagePath));
                                            DeleteButton.click();                                               
                                            testLog.info("Clicked on Delete button"); 
                                            testLog.info("Saved Search is deleted from the list");
                                            status1 = 1;
                                            
                                     } catch (Exception e) {
                                            testLog.info("\nImage not present : " + imagePath);   
                                            testLog.info("Delete button is not present");
                                            testLog.info("Saved Search is not deleted from the list");
                                            status1 = 0;
                                            CaptureScreenshot("TC_Fail_");				
                                            //ClickSignOut();
                                            Close_App_HPE();
                                            Thread.sleep(2000);
                                            Assert.fail("Saved Search is not deleted from the list");

                                     }
                       }

				
				// Method to click on advanced search
	             public static void ClickAdvancedSearch_iOS() throws Exception
	                 {
	                 try
	                 {
	                         Thread.sleep(5000);
	                         WebElement AdvancedSearch = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("AdvancedSearch")));
	                     if(!AdvancedSearch.isDisplayed())
	                 {
	    	            
	                    	 AdvancedSearch.click();
	                    	 System.out.println("Clicked Advanced Search");
	                    	 Thread.sleep(2000); 
	                    
	                 }
	                               }
	                               catch(Exception e)
	                               {
	                                      System.out.println("Advanced Search is not Present");                        
	                                      CaptureScreenshot("TC_Fail_");                         
	                                      //ClickSignOut();
	                                      Close_App_HPE();
	                                      Thread.sleep(2000);
	                                      Assert.fail("Advanced Search is not Present");
	                               }
	                 			                 			
	                 			
	                         }
	          // Method to click on filter icon on search result page
	             public static void ClickFilterIcon(String imagePath) throws Exception
	             {

	             	try
	                 	{
	             				nativedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	             				WebElement FilterIcon = visualdriver.findElement(ByMobile.image(imagePath));					
	             				FilterIcon.click();
	             				testLog.info("\n Image found is : " + imagePath);
	             				testLog.info("Clicked on Filter Icon");
	             				Thread.sleep(2000); 
	             				
	             			} catch (Exception e) {
	             				testLog.info("\nImage not present : " + imagePath);	
	             				testLog.info("Filter Icon is not found");
	             				status1 = 1;
	             				CaptureScreenshot("TC_Fail_");				
	             				//ClickSignOut();
	             				Close_App_HPE();
	                               Thread.sleep(2000);
	             				Assert.fail("Filter Icon is not found");

	             			}
	             		
	                 
	             }
	             
	         
	          // Method to click on close icon on Filter criteria page
	             public static void ClickCloseIcon(String imagePath) throws Exception
	             {

	             	try
	                 	{
	             				WebElement CloseIcon = visualdriver.findElement(ByMobile.image(imagePath));					
	             				CloseIcon.click();
	             				testLog.info("\n Image found is : " + imagePath);
	             				testLog.info("Clicked on Close Icon");
	            				
	             			} catch (Exception e) {
	             				testLog.info("\nImage not present : " + imagePath);	
	             				testLog.info("Close Icon is not found");
	             				status1 = 1;
	             				CaptureScreenshot("TC_Fail_");				
	             				//ClickSignOut();
	             				Close_App_HPE();
	                               Thread.sleep(2000);
	             				Assert.fail("Close Icon is not found");
	             
	             			}
	             		
	                 
	             }

	           //Method to click on close icon
				    public static void ClickCloseIcon() throws Exception
				    {
				    
				    if(Device_Model.contains("iPhone"))
				    	{
				    		ClickCloseIcon("C://HPE//FunctionalTesting//Images//FilterClose"+".png");
				    	}else if(Device_Model.contains("Pixel"))
                        {
                            ClickCloseIcon("C://HPE//FunctionalTesting//Images//FilterClose_AN"+".png");
                     } else if(Device_Model.contains("Galaxy"))
                     {
                            ClickCloseIcon("C://HPE//FunctionalTesting//Images//FilterClose_Galaxy"+".png");
                     }

				    	          
				      }
				
				    
				public static void VerifyErrorMessage(String linktext) throws Exception 
				{
				
					IMobileWebDriver VerifyErrorMessage = device.getVisualDriver();
					VerifyErrorMessage.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            		// device.getVisualDriver().findElementByLinkText(xpath).toString().contains(object_name);
					VerifyErrorMessage.findElement(By.linkText(linktext));
            		testLog.info("\n Element found is : " + linktext);
            		testLog.info("\n Invalid user or password");            		                  
                    Close_App_HPE();
                    Assert.fail("\n Invalid user or password(1)");
            		
			
            	}
				
				
				public static void VerifyErrorMessage1(String linktext) throws Exception 
				{
				
					IMobileWebDriver VerifyErrorMessage = device.getVisualDriver();
					VerifyErrorMessage.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            		// device.getVisualDriver().findElementByLinkText(xpath).toString().contains(object_name);
					VerifyErrorMessage.findElement(By.linkText(linktext));
            		testLog.info("\n Element found is : " + linktext);
            		testLog.info("\n Invalid user or password");            		                  
                               		
			
            	}
				
				
					
				// Method to click on Close button for iOS
	             public static void ClickClose_iOS() throws Exception
	                 {
	                 try
	                 {
	                         Thread.sleep(5000);
	                         WebElement Close = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Close")));
	                         if(!Close.isDisplayed())
	                 {
	    	            
	                        	 CaptureScreenshot("TC_Fail_");                         
	                        	 Close.click();
	                        	 Close_App_HPE();
	                             Thread.sleep(2000); 
	                        	 Assert.fail("Service Error displayed"); 
	                    
	                 }
	                         }
	                         catch(Exception e)
	                               {
	                                      System.out.println("Close button is not Present");                        

	                               }
	                 			                 			
	                 			
	                         }
	             
	          // Method to click on Close button for iOS
	             public static void ClickClose_AN() throws Exception
	                 {
	                 try
	                 {
	                         Thread.sleep(5000);
	                         WebElement Close = nativedriver.findElement(By.xpath(Android_Objects.getProperty("Close")));
	                         if(Close.isDisplayed())
	                 {
	    	            
	                        	 Close.click();
	                        	 System.out.println("Clicked on Close button");
	                        	 Thread.sleep(2000); 
	                    
	                 }
	                         }
	                         catch(Exception e)
	                               {
	                                      System.out.println("Close button is not Present");                        
	                                      CaptureScreenshot("TC_Fail_");                         
	                                      //ClickSignOut();
	                                      Close_App_HPE();
	     	                              Thread.sleep(2000);
	                                      Assert.fail("Close button is not Present");
	                               }
	                 			                 			
	                 			
	                         }
				
				
					//Method to click on close icon
				    public static void ClickClose() throws Exception
				    {
				    
				    if(Device_Model.contains("iPhone"))
				    	{
				    		ClickClose_iOS();
				    	}else
				    	{
				    		ClickClose_AN();
				    	}
				    	          
				      }
				
				    
				  //Method to click on Clear icon in Search Page in Andriod
		              
                    public static void ClickOnClearIcon(String imagePath) throws Exception
                    {      try {
                                         
                                         visualdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                                         //WebElement Remove = visualdriver.findElement(ByMobile.image(imagePath));
                                         WebElement ClearIcon= visualdriver.findElement(ByMobile.image(imagePath));                              
                                         testLog.info("\n Image found is : " + imagePath);
                                         testLog.info("Clear icon displayed");
                                         ClearIcon.click();                                         
                                         testLog.info("Clear icon is clicked");
                                         
                                  } catch (Exception e) {
                                         testLog.info("\nImage not present : " + imagePath);       
                                         testLog.info("Clear icon not displayed");
                                         Close_App_HPE();
                                         status1 = 1;
                                         Assert.fail("Clear icon not displayed");
                                  }
                           }

                    
  	              public static void ClickOnClearIcon() throws Exception

  	             {
  	                    if(Device_Model.equals("iPhone-7"))
  	                    { 
  	                    	ClickOnClearIcon("C://HPE//FunctionalTesting//Images//ClearIconiOS"+".png");
  	                    }else if(Device_Model.equals("iPhone-5S"))
  	                    { 
  	                    	ClickOnClearIcon("C://HPE//FunctionalTesting//Images//ClearIcon_iPhone5S"+".png");
  	                      }else if(Device_Model.contains("Tab"))
  	                      { 
  	                          ClickHome("C://HPE//FunctionalTesting//Images//HomeButton_Tab" +".png");
  	                        }else if(Device_Model.contains("Pixel"))
  	                    {
  	                        	ClickOnClearIcon("C://HPE//FunctionalTesting//Images//ClearIconAN"+".png");
  	                    } else if(Device_Model.contains("Galaxy S6"))
  	                    {
  	                    	ClickOnClearIcon("C://HPE//FunctionalTesting//Images//ClearIcon_Galaxy"+".png");
  	                    } else if(Device_Model.contains("Galaxy S7"))
  	                    {
  	                    	ClickOnClearIcon("C://HPE//FunctionalTesting//Images//ClearIcon_GalaxyS7"+".png");
  	                    }else if(Device_Model.equals("iPhone-6S"))
  	                    { 
  	                    	ClickOnClearIcon("C://HPE//FunctionalTesting//Images//ClearIconiOS"+".png");
  	                    }
  	             } 
                 // Method to uncheck all the check boxes on filter options for iOS
   	             public static void UncheckAllCheckboxes_iOS() throws Exception
   	                 {
   	            	 
   	            	 		 nativedriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
   	                         WebElement Submitted = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Submitted")));
   	                         Submitted.click();  
   	                         System.out.println("Submitted is unchecked");
   	                         
   	                         nativedriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
   	                         WebElement Accepted = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Accepted")));
   	                         Accepted.click(); 
   	                         System.out.println("Accepted is unchecked");
	                        
   	                         nativedriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	                         WebElement InProduction = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("InProduction")));
	                         InProduction.click();
	                         System.out.println("In Production is unchecked");
	                         
	                         nativedriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
   	                         WebElement Shipped = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Shipped")));
   	                         Shipped.click();
   	                         System.out.println("Shipped is unchecked");
   	                         
   	                         nativedriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	                         WebElement Delivered = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Delivered")));
	                         Delivered.click();
	                         System.out.println("Delivered is unchecked");
	                         
	                         nativedriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
   	                         WebElement Cancelled = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Cancelled")));
   	                         Cancelled.click(); 
   	                         System.out.println("Cancelled is unchecked");
	                         
	                         
   	                         }
   	             
   	       // Method to check only Delivered check box on filter options for iOS
   	             public static void CheckDelivered_iOS() throws Exception
   	                 {
   	            	 		 
   	            	         UncheckAllCheckboxes();
   	                         nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	                         WebElement Delivered = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Delivered")));
	                         Delivered.click();   
	                         System.out.println("Delivered is checked");
	                         
	                         
   	                }
   	             
   	   	       // Method to check only Cancelled check box on filter options for iOS
   	             public static void CheckCancelled_iOS() throws Exception
   	                 {
   	            	 		 
   	            	         UncheckAllCheckboxes();
   	                         nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	                         WebElement Cancelled = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Cancelled")));
	                         Cancelled.click();   
	                         System.out.println("Cancelled is checked");
	                         
	                         
   	                }
   	             
   	  	       // Method to check only Submitted check box on filter options for iOS
   	             public static void CheckSubmitted_iOS() throws Exception
   	                 {
   	            	 		 
   	            	         UncheckAllCheckboxes();
   	                         nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	                         WebElement Submitted = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Submitted")));
	                         Submitted.click();   
	                         System.out.println("Submitted is checked");
	                         
	                         
   	                }
   	             
   	       // Method to check only Accepted check box on filter options for iOS
   	             public static void CheckAccepted_iOS() throws Exception
   	                 {
   	            	 		 
   	            	         UncheckAllCheckboxes();
   	                         nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	                         WebElement Accepted = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Accepted")));
	                         Accepted.click();   
	                         System.out.println("Accepted is checked");
	                         
	                         
   	                }
   	             
   	       // Method to check only InProduction check box on filter options for iOS
   	             public static void CheckInProduction_iOS() throws Exception
   	                 {
   	            	 		 
   	            	         UncheckAllCheckboxes();
   	                         nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	                         WebElement InProduction = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("InProduction")));
	                         InProduction.click();   
	                         System.out.println("InProduction is checked");
	                         
	                         
   	                }
   	             
   	       // Method to check only Shipped check box on filter options for iOS
   	             public static void CheckShipped_iOS() throws Exception
   	                 {
   	            	 		 
   	            	         UncheckAllCheckboxes();
   	                         nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	                         WebElement Shipped = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Shipped")));
	                         Shipped.click();   
	                         System.out.println("Shipped is checked");
	                         
	                         
   	                }
   	             
   	             
   	             
   	       // Method to click on Apply button for iOS
	             public static void ClickApply_iOS() throws Exception
	                 {
	            	 /*
	            	 	device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("520,1193")));
	            	 	System.out.println("Clicked on Apply button");
	            	 	Thread.sleep(5000); 
	            	 	
	            	 	*/
	            	 
	            	 
	                 try
	                 {
	                         Thread.sleep(5000);
	                         WebElement Apply = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Apply")));
	                         if(!Apply.isDisplayed())
	                 {
	    	            
	                        	 Apply.click();
	                        	 System.out.println("Clicked on Apply button");
	                        	 Thread.sleep(10000); 
	                    
	                 }
	                         }
	                         catch(Exception e)
	                               {
	                                      System.out.println("Apply button is not Present");                        
	                                      CaptureScreenshot("TC_Fail_"); 
	                                      
	                                      //ClickSignOut();
	                                      Close_App_HPE();
	     	                             Thread.sleep(2000);
	                                      Assert.fail("Apply button is not Present");
	                               }
	                 			                 			
	                 			
	                         }
	             
	           //Method to click on close button on Filter criteria page
		 			public static void ClickFilterClose(String imagePath) throws Exception
		 			{	try {
		 						
		 						//visualdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 						//WebElement Remove = visualdriver.findElement(ByMobile.image(imagePath));
		 						WebElement Close = visualdriver.findElement(ByMobile.image(imagePath));
		 						Close.click();
		 						testLog.info("\n Image found is : " + imagePath);
		 						testLog.info("Clicked o close button");
		 					} catch (Exception e) {
		 						 testLog.info("\nImage not present : " + imagePath);	
		 						 testLog.info("Close button is not found");
		 						 status1 = 1;
		 						 ClickSignOut();
		 						 Assert.fail("Order summary is not in Delivered status");
		 					}
		 				} 
   	                
	           //Method to Validate the Delivered status on order details page
	 			public static void VerifyDeliveredStatus(String imagePath) throws Exception
	 			{	try {
	 						
	 						//visualdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 						//WebElement Remove = visualdriver.findElement(ByMobile.image(imagePath));
	 						WebElement Delivered = visualdriver.findElement(ByMobile.image(imagePath));					
	 						testLog.info("\n Image found is : " + imagePath);
	 						testLog.info("Order summary is in Delivered status");
	 					} catch (Exception e) {
	 						 testLog.info("\nImage not present : " + imagePath);	
	 						 testLog.info("Order summary is not in Delivered status");
	 						 status1 = 1;
	 						 ClickSignOut();
	 						 Assert.fail("Order summary is not in Delivered status");
	 					}
	 				} 
	 			
	 		// Method to click on Invoice Available for iOS
	             public static void ClickInvoiceAvailableButton() throws Exception
	                 {
	                 try
	                 {
	                         Thread.sleep(5000);
	                         WebElement Invoice = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Invoice")));
	                         if(!Invoice.isEnabled())
	                 {
	    	                   	 System.out.println("Invoice Available icon is Clickable");
	                        	 CaptureScreenshot("TC_Fail_");
	                        	 //ClickSignOut();
	                        	 Close_App_HPE();
	                             Thread.sleep(2000);
	                        	 
	                        	 Assert.fail("Invoice Available icon is Clickable");
	                    
	                 }
	                         }
	                         catch(Exception e)
	                               {
	                        	 		  System.out.println("Invoice Available icon is not Clickable");                       
	                                      
	                               }
	                 			                 			
	                 			
	                         }
	             
	             
	              //Method to Validate the Login screen in iOS
	              public static void VerifyLoginPage_iOS() throws Exception
	              {
	                     try
	                     {
	                     WebElement LoginPage = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("SignIn")));
	                     if(!LoginPage.isDisplayed())
	                     {                          
	                           System.out.println("User is on the login page");
	                           Thread.sleep(5000);                      
	                     }
	                     }
	                     catch(Exception e)
	                     {
	                           System.out.println("User is not on the login page");                        
	                           CaptureScreenshot("TC_Fail_");                         
	                           //ClickSignOut();
	                           Close_App_HPE();
	                             Thread.sleep(2000);
	                           Assert.fail("User is not on the login page");
	                     }
	              }
	              
	              // Method to Validate the Login Screen in Android
	              public static void VerifyLoginPage_AN() throws Exception
	              {
	                     try
	                     {
	                    	 Thread.sleep(2000);
	                     WebElement LoginPage = nativedriver.findElement(By.xpath(Android_Objects.getProperty("SignIn")));
	                     if(LoginPage.isDisplayed())
	                     {                          
	                           System.out.println("User is on the login page");
	                           Thread.sleep(5000);                      
	                     }
	                     }
	                     catch(Exception e)
	                     {
	                           System.out.println("User is not on the login page");                        
	                           CaptureScreenshot("TC_Fail_");                         
	                           //ClickSignOut();
	                           Close_App_HPE();
	                             Thread.sleep(2000);
	                           Assert.fail("User is not on the login page");
	                     }
	              }
	              
	              // Method to Verify Login Page
	              
	              public static void VerifyLoginPage() throws Exception
	              {
	                     if(Device_Model.contains("iPhone"))
	                     {
	                           VerifyLoginPage_iOS();
	                     }else
	                     {
	                           VerifyLoginPage_AN();
	                     }
	              }

	            //Method to Click on Get Support menu option in Android
	              public static void ClickGetSupportOption_AN(String imagePath) throws Exception
	              {   
	            	  try
	                        {
	            		  		Thread.sleep(5000);
	            		  		WebElement GetSupport_Button = visualdriver.findElement(ByMobile.image(imagePath));
	                            GetSupport_Button.click();
	                            System.out.println("CLicked on Get Support");
	                            Thread.sleep(10000);
	                                             
	                         }catch(Exception e)
	                         {
	                        	 System.out.println("Unbale to click on Get Support Menu option");                         
	                             CaptureScreenshot("TC_Fail_");                         
	                             //ClickSignOut();
	                             Close_App_HPE();
	                   	         Thread.sleep(2000);
	                   	         Assert.fail("Unbale to click on Get Support Menu option");
	                         }
	                 }

	            //Method to click on signout under Preferences tab in iOS
	                          public static void ClickPreferenceSignout_iOS() throws Exception
	                          {
	                                 try
	                                 {                    
	                                 WebElement SignOut1 = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("PreSignOut")));
	                                 if(!SignOut1.isDisplayed())
	                                 {                          
	                                       SignOut1.click();
	                                       System.out.println("Clicked on SignOut");
	                                       Thread.sleep(5000);                      
	                                 }
	                                 }
	                                 catch(Exception e)
	                                 {
	                                       System.out.println("SignOut is not Present");                        
	                                       CaptureScreenshot("TC_Fail_");                         
	                                       //ClickSignOut();
	                                       Close_App_HPE();
	      	                             Thread.sleep(2000);
	                                       Assert.fail("SignOut is not Present");
	                                 }
	                                 
	                          }

	            // Method to click on Sign out button under preference tab in android

	                          public static void ClickPreferenceSignout_AN(String imagePath) throws Exception
	                        { 
	                            try {
	                          WebElement PrefSignOut = visualdriver.findElement(ByMobile.image(imagePath));
	                          testLog.info("\n Image found is : " + imagePath);
	                          PrefSignOut.click();
	                          {
	                          testLog.info("Sign Out button clicked");
	                           }      
	                          } catch (Exception e) 
	                          {
	                                testLog.info("\nImage not present : " + imagePath);    
	                                testLog.info("Signout button not found");
	                                status1 = 1;
	                                //Assert.fail();
	                          }
	                        }
      
	            // Method to click on Sign Out button under Preference tab
	            public static void ClickPreferenceSignout() throws Exception
	            {
	            if(Device_Model.contains("iPhone"))
	            {
	            ClickPreferenceSignout_iOS();
	            }else
	            {
	            ClickPreferenceSignout_AN("C://HPE//FunctionalTesting//Images//PrefSignOut"+".png");
	            }
	            }
	            
	            /*.
	          //Method to Click on Home in iOS
	            public static void ClickHome_iOS() throws Exception 
	            {
	            try
	            {
	            	nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	           
	            WebElement Home = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Home")));
	            if(!Home.isDisplayed())
	            {      
	            Home.click();
	            System.out.println("Clicked on Home");
	            Thread.sleep(10000);
	            }
	            }
	            catch(Exception e)
	            {
	            System.out.println("Home button is not Present");                          
	            CaptureScreenshot("TC_Fail_");                         
	            ClickSignOut();
	            //Close_App();
	            Assert.fail("Home button is not Present");
	            }
	         }
	         
	         */

	            //Method to Click on Home button in Android
	            public static void ClickHome_AN() throws Exception 
	            {
	                   try
	            {
	            Thread.sleep(10000);
	            WebElement Home = nativedriver.findElement(By.xpath(Android_Objects.getProperty("Home")));
	            if(Home.isDisplayed())
	                                 {
	            Home.click();
	            System.out.println("Clicked on Home");
	            Thread.sleep(10000);
	                   }
	                   }
	            catch(Exception e)
	                   {
	            System.out.println("Home button is not Present");                          
	            CaptureScreenshot("TC_Fail_");                         
	            //ClickSignOut();
	            Close_App_HPE();
                Thread.sleep(2000);
	            Assert.fail("Home button is not Present");
	                    }
	      }

	            //Method to click on Home button
                public static void ClickHome() throws Exception
             {
                    if(Device_Model.equals("iPhone-7"))
                    { 
                      ClickHome("C://HPE//FunctionalTesting//Images//HomeButton" +".png");
                    }else if(Device_Model.equals("iPhone-5S"))
                    { 
                        ClickHome("C://HPE//FunctionalTesting//Images//HomeButton_iPhone5S" +".png");
                      }else if(Device_Model.contains("Tab"))
                      { 
                          ClickHome("C://HPE//FunctionalTesting//Images//HomeButton_Tab" +".png");
                        }else if(Device_Model.contains("Pixel"))
                    {
                    	ClickHome("C://HPE//FunctionalTesting//Images//HomeButton_AN" +".png");
                    } else if(Device_Model.contains("Galaxy S6"))
                    {
                    	ClickHome("C://HPE//FunctionalTesting//Images//HomeButton_Galaxy" +".png");
                    } else if(Device_Model.contains("Galaxy S7"))
                    {
                    	ClickHome("C://HPE//FunctionalTesting//Images//HomeButton_GalaxyS7" +".png");
                    }else if(Device_Model.equals("iPhone-6S"))
                    { 
                        ClickHome("C://HPE//FunctionalTesting//Images//HomeButton" +".png");
                      }
                    
             }    
                
              //Method to verify to display Privacy Statment 
                public static void VerifyPrivacyStatment(String imagePath) throws Exception
       {
               try
                     {
                         Thread.sleep(5000);
                         WebElement PrivacyStatment = visualdriver.findElement(ByMobile.image(imagePath));
                         if(PrivacyStatment .isDisplayed())                         
                         {
                        	 System.out.println("Privacy Statment menu option displayed");
                        	 Thread.sleep(10000);
                         }
                     }catch(Exception e)
                         {
                    	 	System.out.println("Privacy Statment Menu option is not Present");                        
                            CaptureScreenshot("TC_Fail_");                         
                            //ClickSignOut();
                            Close_App_HPE();
                            Thread.sleep(2000);
                            Assert.fail("Privacy Statment Menu option is not Present");
                         }
                    }

             // Method to click on Privacy Statement menu option in Android
                public static void ClickPrivacyStatement_AN(String imagePath) throws Exception
                {
                try
                       {
                WebElement PrivacyStatementOption = visualdriver.findElement(ByMobile.image(imagePath)); 
                PrivacyStatementOption .click();
                testLog.info("\n Image found is : " + imagePath);
                testLog.info("Clicked on PrivacyStatement Option");
                
                } catch (Exception e) 
                {
                     testLog.info("\nImage not present : " + imagePath);    
                     testLog.info("Preference menu option not found");
                     ClickSignOut();
                     Assert.fail("PrivacyStatement menu option not found");
                     status1 = 1;   
                }
                }

                   
                // Method to click on Privacy Statement menu option for iOS
                   public static void ClickPrivacyStatement_iOS() throws Exception
                   {
                   try
                          {
                   
                   WebElement PrivacyStatementOption = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Home")));
                   if(!PrivacyStatementOption.isDisplayed())
                   {
                          PrivacyStatementOption.click();
                          
                          testLog.info("Clicked on Privacy Statement Option");
                   }
                   } catch (Exception e) 
                   {
                	       
                	   testLog.info("Privacy Statement option not found");
                	   ClickSignOut();
                	   Assert.fail("Privacy Statement option not found");
                	    
                   }
                   }
                   
                 //Method to click on Home button
                   public static void ClickPrivacyStatement() throws Exception
                {
                       if(Device_Model.contains("iPhone"))
                       { 
                    	   ClickPrivacyStatement_iOS();
                       }else if(Device_Model.contains("Pixel"))
                       {
                       ClickPrivacyStatement_AN("C://HPE//FunctionalTesting//Images//PrivacyStatement"+".png");
                       } else if(Device_Model.contains("Galaxy S6"))
                       {
                       ClickPrivacyStatement_AN("C://HPE//FunctionalTesting//Images//PrivacyStatement_Galaxy"+".png");
                       }  else if(Device_Model.contains("Galaxy S7"))
                       {
                       ClickPrivacyStatement_AN("C://HPE//FunctionalTesting//Images//PrivacyStatement_GalaxyS7"+".png");
                       }
                       
                } 

                 //Method to click on white flag on search page
   	 			public static void ClickWhiteFlag(String imagePath) throws Exception
   	 			{	try {
   	 						
   	 						visualdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   	 						//WebElement Remove = visualdriver.findElement(ByMobile.image(imagePath));
   	 						WebElement WhiteFlag = visualdriver.findElement(ByMobile.image(imagePath));					
   	 						WhiteFlag.click();
   	 						testLog.info("\n Image found is : " + imagePath);
   	 						testLog.info("Clicked on flag of an order");
   	 					} catch (Exception e) {
   	 						 testLog.info("\nImage not present : " + imagePath);	
   	 						 testLog.info("White flag is not found");
   	 						 Close_App_HPE();
   	 						 status1 = 1;
   	 						 Assert.fail("White flag is not found");
   	 					}
   	 				} 
   	 			
   	 		//Method to click on white flag on search page
   	 			public static void ClickWhiteFlag1(String imagePath) throws Exception
   	 			{	
   	 						visualdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   	 						//WebElement Remove = visualdriver.findElement(ByMobile.image(imagePath));
   	 						WebElement WhiteFlag = visualdriver.findElement(ByMobile.image(imagePath));					
   	 						WhiteFlag.click();
   	 						visualdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   	 						testLog.info("\n Image found is : " + imagePath);
   	 						testLog.info("Clicked on flag of an order");
   	 					
   	 				}
   	 			
   	 		//Method to click on Home button on menu bar
   	 			public static void ClickHome(String imagePath) throws Exception
   	 			{	try {
   	 						
   	 						visualdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   	 						//WebElement Remove = visualdriver.findElement(ByMobile.image(imagePath));
   	 						WebElement Home = visualdriver.findElement(ByMobile.image(imagePath));					
   	 						Home.click();
   	 						Thread.sleep(2000);
   	 						testLog.info("\n Image found is : " + imagePath);
   	 						testLog.info("Clicked on Home");
   	 					} catch (Exception e) {
   	 						 testLog.info("\nImage not present : " + imagePath);	
   	 						 testLog.info("Home button is not found");
   	 						 Close_App_HPE();
   	 						 status1 = 1;
   	 						 Assert.fail("Home button is not found");
   	 					}
   	 				} 
   	 			
   	 		//Method to click on green flag on Watch list page
   	 			public static void ClickGreenFlag(String imagePath) throws Exception
   	 			{	try {
   	 						
   	 						visualdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   	 						//WebElement Remove = visualdriver.findElement(ByMobile.image(imagePath));
   	 						WebElement WhiteFlag = visualdriver.findElement(ByMobile.image(imagePath));					
   	 						WhiteFlag.click();
   	 						testLog.info("\n Image found is : " + imagePath);
   	 						testLog.info("Clicked on green flag of an order");
   	 						testLog.info("Pop up alert displayed");
   	 						Thread.sleep(2000);
   	 					} catch (Exception e) {
   	 						 testLog.info("\nImage not present : " + imagePath);	
   	 						 testLog.info("There are no orders tagged to Watchlist");
   	 						 Close_App_HPE();
   	 						 status1 = 1;
   	 						 
   	 						 //Assert.fail("Green flag is not found");
   	 					}
   	 				} 
   	 			
   	 		//Method to click on Watch list arrow on home page
   	 			public static void ClickWatchList(String imagePath) throws Exception
   	 			{	try {
   	 						Thread.sleep(5000);
   	 						//visualdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   	 						//WebElement Remove = visualdriver.findElement(ByMobile.image(imagePath));
   	 						WebElement WatchListArrow = visualdriver.findElement(ByMobile.image(imagePath));					
   	 						WatchListArrow.click();
   	 						testLog.info("\n Image found is : " + imagePath);
   	 						testLog.info("Clicked on WatchList Arrow");
   	 						Thread.sleep(5000);
   	 						
   	 					} catch (Exception e) {
   	 						 testLog.info("\nImage not present : " + imagePath);	
   	 						 testLog.info("WatchList arrow is not found");
   	 						 Close_App_HPE();
   	 						 status1 = 1;   	 						 
   	 						 Assert.fail("WatchList arrow is not found");
   	 					}
   	 				} 
   	 			
   	 			
   	 		//Method to click on green flag on Watch list page
   	 			public static void ClickGreenFlag1(String imagePath) throws Exception
   	 			{	
   	 						
   	 						visualdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   	 						//WebElement Remove = visualdriver.findElement(ByMobile.image(imagePath));
   	 						WebElement GreenFlag = visualdriver.findElement(ByMobile.image(imagePath));					
   	 						GreenFlag.click();
   	 						testLog.info("\n Image found is : " + imagePath);
   	 						testLog.info("Clicked on green flag of an order");
   	 						testLog.info("Pop up alert displayed");
   	 						Thread.sleep(2000);
   	 					
   	 				} 
   	 			
   	 		// Method to click on FAQ1
                public static void GeneralQuestions(String imagePath) throws Exception
                	{
                		try
                          		{
                                       WebElement FAQ1 = visualdriver.findElement(ByMobile.image(imagePath));                              
                                       FAQ1.click();
                                       testLog.info("\n Image found is : " + imagePath);
                                       testLog.info("Clicked on General App Questions");
                                 } catch (Exception e) {
                                       testLog.info("\nImage not present : " + imagePath);   
                                       testLog.info("Unable to click on General App Questions");
                                       Close_App_HPE();
                                       status1 = 1;
                                       Assert.fail("Unable to click on General App Questions");
                                 }
                       }
              //Method to click General App Questions in Android
                
                public static void GeneralQuestions_AN() throws Exception
                
                {
                  device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("310,488")));
                    System.out.println("Clicked on General App Questions");
                    Thread.sleep(10000); 

                }

              //Method to click General App Questions 
                
                public static void ClickGeneralAppQuestions() throws Exception
                {
                  if(Device_Model.contains("iPhone"))
                  {
                         ClickGeneralApp_iOS();
                  } else 
                  {
                         GeneralQuestions_AN();
                  //GeneralQuestions_AN("C://FunctionalTesting//Images//GeneralAppQuestions"+".png");
                  }
                }

                
             //Method to verify the end customer name on WatchList page for iOS
                public static void VerifyEndCustomerName1_iOS() throws Exception
                    {
                    try
                    {
                            Thread.sleep(5000);
                            WebElement CustomerName = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("EndCustomerName")));
                            if(!CustomerName.isDisplayed())
                            {
                             EndCustomerName = CustomerName.getAttribute("name");
                             System.out.println("End Customer Name is Present & below is the name");
                           	 System.out.println(EndCustomerName);
                           	 Thread.sleep(2000); 
                           	 
                       
                            }
                                  }
                                  catch(Exception e)
                                  {
                                         System.out.println("End Customer Name is not Present");                        
                                         CaptureScreenshot("TC_Fail_");                         
                                         //ClickSignOut();
                                         Close_App_HPE();
        	                             Thread.sleep(2000);
                                         Assert.fail("End Customer Name is not Present");
                                  }
                            }
                
                  
              //Method to verify the End Customer Name on the app
    		    public static void VerifyEndCustomerName() throws Exception
    		      {
    		    	if(Device_Model.contains("iPhone"))
    		    	{
    		    		//ClickOnSearchIcon_iOS();
    		    		VerifyEndCustomerName1_iOS();
    		    	}else
    		    	{
    		    		VerifyEndCustomerName1_AN();
    		    	}
    		    	          
    		      } 
                
              //Method to verify the end customer name on WatchList page for Android
                public static void VerifyEndCustomerName1_AN() throws Exception
                    {
                    try
                    {
                            Thread.sleep(5000);
                            WebElement CustomerName = nativedriver.findElement(By.xpath(Android_Objects.getProperty("EndCustomerName")));
                            if(CustomerName.isDisplayed())
                            {
                             EndCustomerName = CustomerName.getAttribute("contDesc");
                             System.out.println("End Customer Name is Present & below is the name");
                           	 System.out.println(EndCustomerName);
                           	 Thread.sleep(2000); 
                           	 
                       
                            }
                                  }
                                  catch(Exception e)
                                  {
                                         System.out.println("End Customer Name is not Present");                        
                                         CaptureScreenshot("TC_Fail_");                         
                                         //ClickSignOut();
                                         Close_App_HPE();
        	                             Thread.sleep(2000);
                                         Assert.fail("End Customer Name is not Present");
                                  }
                            }

              //Method to verify the text on search results page if available (Checkpoint)
                public static void Find_Text_Previously(String linktext) {
                	try {
                		IMobileWebDriver Text = device.getVisualDriver();
                		Text.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);                		
                		Text.findElement(By.linkText(linktext));
                		testLog.info("\n Element found is : " + linktext);               		               		
                		testLog.info("\nPrevious delivered date is found for the order displayed");
                	} catch (Exception e) {
                		testLog.info("\nElement not found : " + linktext);
                		testLog.info("\nPrevious delivered date is not found for the order displayed");
                		
                	}
                }
                
              //Method to verify the text on watchlist results page if available (Checkpoint)
                public static void Find_Text_DateShipped(String linktext) {
                	try {
                		IMobileWebDriver Text = device.getVisualDriver();
                		Text.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);                		
                		Text.findElement(By.linkText(linktext));
                		testLog.info("\n Element found is : " + linktext);               		               		
                		testLog.info("\nShip Complete / Date Shipped  is found for the order displayed");
                	} catch (Exception e) {
                		testLog.info("\nElement not found : " + linktext);
                		testLog.info("\nShip Complete / Date Shipped  is not found for the order displayed");
                		
                	}
                }
                
             // Method to click on Sort button

                public static void ClickSortButton(String imagePath) throws Exception
                     {
                       try
                           {
                               WebElement SortButton = visualdriver.findElement(ByMobile.image(imagePath));                              
                               SortButton.click();
                               testLog.info("\n Image found is : " + imagePath);
                               testLog.info("Clicked on Sort Button");
                           } catch (Exception e) 
                           {
                               testLog.info("\nImage not present : " + imagePath);       
                               testLog.info("Sort Button not clicked");
                               status1 = 1;
                               Assert.fail("Sort Button not found");
                           }
                                                   
                       }
                
                //Method to click on Home button
                public static void ClickSortButton() throws Exception
             {
                    if(Device_Model.equals("iPhone-7"))
                    { 
                    	ClickSortButton("C://HPE//FunctionalTesting//Images//SortButton_iphone7"+".png");
                    }else if(Device_Model.equals("iPhone-5S"))
                    { 
                    	ClickSortButton("C://HPE//FunctionalTesting//Images//SortButton_iPhone5S"+".png");
                    }else if(Device_Model.contains("Pixel"))
                    {
                    	ClickSortButton("C://HPE//FunctionalTesting//Images//SortButton_Pixel"+".png");
                    }else if(Device_Model.contains("Galaxy S6"))
                    {
                    ClickSortButton("C://HPE//FunctionalTesting//Images//SortButton_Galaxy"+".png");
                    } else if(Device_Model.contains("Galaxy S7"))
                    {
                    ClickSortButton("C://HPE//FunctionalTesting//Images//SortButton_GalaxyS7"+".png");
                    } else if(Device_Model.equals("iPhone-6S"))
                    { 
                    	ClickSortButton("C://HPE//FunctionalTesting//Images//SortButton_iphone7"+".png");
                    }
                    
             } 
                
    			//Method to Click on Save button button 
    			public static void ClickSaveButton(String imagePath) throws Exception
    			{	
    			
    		    	try {
    			    		 	//Thread.sleep(10000); 
    							nativedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    							//WebElement Remove = visualdriver.findElement(ByMobile.image(imagePath));
    							WebElement SaveButton = visualdriver.findElement(ByMobile.image(imagePath));
    							SaveButton.click();							
    							testLog.info("Clicked on Save button");
    							Thread.sleep(3000); 
    							status1 = 1;
    							
    						} catch (Exception e) {
    							testLog.info("\nImage not present : " + imagePath);	
    							testLog.info("Save button is not present");
    							status1 = 0;
    							//Assert.fail();
    						}
    			   	}
    			
    			//Method to click on white flag icon 
    		    public static void ClickSaveButton() throws Exception
    				      {
    				    	if(Device_Model.equals("iPhone-7"))
    				    	{
    				    		ClickSaveButton("C://HPE//FunctionalTesting//Images//Alert_Save" +".png");
    				    	}else if(Device_Model.equals("iPhone-5S"))
    				    	{
    				    		ClickSaveButton("C://HPE//FunctionalTesting//Images//Alert_Save_iPhone5S" +".png");
    				    	} else if(Device_Model.contains("Pixel"))
    				    	{
    				    		ClickSaveButton("C://HPE//FunctionalTesting//Images//Alert_Save_AN" +".png");
    				    	}else if(Device_Model.contains("Galaxy"))
                            {
                                ClickSaveButton("C://HPE//FunctionalTesting//Images//Alert_Save_Galaxy" +".png");
                         }else if(Device_Model.equals("iPhone-6S"))
 				    	{
 				    		ClickSaveButton("C://HPE//FunctionalTesting//Images//Alert_Save" +".png");
 				    	}

    				    	          
    				      }
    		    
    			//Method to Click on Watch List on toolbar 
    			public static void ClickWatchListonToolbar(String imagePath) throws Exception
    			{	
    			
    		    	try {
    			    		 	//Thread.sleep(10000); 
    							nativedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    							WebElement WatchList = visualdriver.findElement(ByMobile.image(imagePath));
    							WatchList.click();							
    							testLog.info("Clicked on Watch List");							
    							status1 = 1;
    							
    						} catch (Exception e) {
    							testLog.info("\nImage not present : " + imagePath);	
    							testLog.info("Watch List is not present");
    							status1 = 0;
    							//Assert.fail();
    						}
    			   	}

    			// Method to click on search box , enter keyword 
	              public static void EnterSearchKeyword(String SearchKeyword) throws Exception
	              {
	                     try
	                           {
	                    	 /*
	                    	 WebElement Search; 
	                    	 WebDriverWait wait = new WebDriverWait(nativedriver, 40);
	                    	 //System.out.println("Searching for the field 1");
	                    	 Search= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Android_Objects.getProperty("SearchTextfield"))));
	                    	 //Search= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Android_Objects.getProperty("SearchTextfield"))));
	                    	 //System.out.println("Searching for the field 2");
	                    	 Search.click();
	                    	 */
	                    	 
	                    	 Thread.sleep(7000);
	                    	 //nativedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);                          
	                    	 WebElement Search = nativedriver.findElement(By.xpath(Android_Objects.getProperty("SearchTextfield")));
	                    	 Thread.sleep(5000);
	                    	 Search.click();
	                    	 
	                    	 //Thread.sleep(5000);
	                    	 Search.sendKeys(SearchKeyword);
	                    	 System.out.println("Entered Search Keyword");
	                    	 Thread.sleep(5000);
	                           }
	              
	              catch(Exception e)
	              {
	                     System.out.println("Search Box not found");                          
	                     CaptureScreenshot("TC_Fail_");           
	                     //ClickSignOut();
	                     Close_App_HPE();
                         Thread.sleep(2000);
	                     Assert.fail("Search Box not found");
	              }
	              }
	              
	              
	           // Method to verify the footer of the page 
	              public static void VerifyFooterComponents() throws Exception
	              {
	            	  	 HPECommonFunctions.Find_Text(config.getProperty("Search"));
	            	     HPECommonFunctions.Find_Text(config.getProperty("Alerts"));
	            	     HPECommonFunctions.Find_Text(config.getProperty("WatchList"));
	            	     HPECommonFunctions.Find_Text(config.getProperty("RecentSearch"));
	              }  
	              
	              
	              public static void VerifySearchTips() throws Exception
                  {
                    try
                    {
                    Thread.sleep(1000);
                           WebElement SearchTips = nativedriver.findElement(By.xpath(Android_Objects.getProperty("SearchTips")));
                           Thread.sleep(1000);
                           if (SearchTips.isDisplayed())
                           { 
                                 System.out.println(" Tips to Search is displayed");
                                 Thread.sleep(1000);
                                                             }
                    }
                    catch(Exception e)
                         {
                               System.out.println("Tips to Search not displayed");                         
                               CaptureScreenshot("TC_Fail_");           
                               //ClickSignOut();
                               Close_App_HPE();
	                             Thread.sleep(2000);
                               Assert.fail("Tips to Search not displayed");
                         }
                  }

	              
	                       
                  // Method to uncheck all the check boxes on filter options for Android
                  public static void UncheckAllCheckboxes_AN() throws Exception
                      {
                    
                              nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                              WebElement Submitted = nativedriver.findElement(By.xpath(Android_Objects.getProperty("Submitted")));
                              Submitted.click();  
                              System.out.println("Submitted is unchecked");
                              
                              nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                              WebElement Accepted = nativedriver.findElement(By.xpath(Android_Objects.getProperty("Accepted")));
                              Accepted.click(); 
                              System.out.println("Accepted is unchecked");
                             
                              nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                              WebElement InProduction = nativedriver.findElement(By.xpath(Android_Objects.getProperty("InProduction")));
                              InProduction.click();
                              System.out.println("In Production is unchecked");
                              
                              nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                              WebElement Shipped = nativedriver.findElement(By.xpath(Android_Objects.getProperty("Shipped")));
                              Shipped.click();
                              System.out.println("Shipped is unchecked");
                              
                              nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                              WebElement Delivered = nativedriver.findElement(By.xpath(Android_Objects.getProperty("Delivered")));
                              Delivered.click();
                              System.out.println("Delivered is unchecked");
                              
                              nativedriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                              WebElement Cancelled = nativedriver.findElement(By.xpath(Android_Objects.getProperty("Cancelled")));
                              Cancelled.click(); 
                              System.out.println("Cancelled is unchecked");
                              
                                                                }



//Method to uncheck all the check boxes on filter options
                       public static void UncheckAllCheckboxes() throws Exception
                         {
                          if(Device_Model.contains("iPhone"))
                          {
                                 UncheckAllCheckboxes_iOS();
                          }else
                          {
                                 UncheckAllCheckboxes_AN();
                          }
                                    
                         }

                    // Method to check only Cancelled check box on filter options for Android
                       public static void CheckCancelled_AN() throws Exception
                           {
                                       
                                 UncheckAllCheckboxes();
                                   nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                                   WebElement Cancelled_AN = nativedriver.findElement(By.xpath(Android_Objects.getProperty("Cancelled")));
                                   Cancelled_AN.click();   
                                   System.out.println("Cancelled is checked");
                                   
                                   
                          }

        // Method to check only Delivered check box on filter options
                          
                       public static void CheckDelivered() throws Exception
                          {
                           if(Device_Model.contains("iPhone"))
                           {
                                  CheckDelivered_iOS();
                           }else
                           {
                                  CheckDelivered_AN();
                           }
                                     
                          
               }
                       
                    // Method to check only Delivered check box on filter options for Android
                          public static void CheckDelivered_AN() throws Exception
                              {
                                          
                                      UncheckAllCheckboxes();
                                      nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                                      WebElement DeliveredButton = nativedriver.findElement(By.xpath(Android_Objects.getProperty("DeliveredUnChecked")));
                                      DeliveredButton.click();   
                                      System.out.println("Delivered is checked");
                                      
                                                          
                             }


          // Method to check only Cancelled check box on filter options
                          
                       public static void CheckCancelled() throws Exception
                          {
                           if(Device_Model.contains("iPhone"))
                           {
                                  CheckCancelled_iOS();
                           }else
                           {
                                  CheckCancelled_AN();
                           }
                                     
                          }
                          
         
           // Method to check only Submitted check box on filter option for Android
                          
                      public static void CheckSubmitted_AN() throws Exception
                          {
                                   
                             UncheckAllCheckboxes();
                             nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                             WebElement Submitted = nativedriver.findElement(By.xpath(Android_Objects.getProperty("SubmittedUnChecked")));
                             Submitted.click();   
                             System.out.println("Submitted is checked");
                        
                        
                          }
                          

      // Method to check only Submitted check box
                      
                      public static void CheckSubmitted() throws Exception
                      {
                           if(Device_Model.contains("iPhone"))
                           { 
                                  CheckSubmitted_iOS();
                           } else
                           {
                                  CheckSubmitted_AN();
                           }
                           }

        // Method to check only Accepted check box on filter option in Android
                          public static void CheckAccepted_AN() throws Exception
                          {
                            UncheckAllCheckboxes();
                              nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                           WebElement Accepted = nativedriver.findElement(By.xpath(Android_Objects.getProperty("AcceptedUnChecked")));
                           Accepted.click();   
                           System.out.println("Accepted is checked");
                          }
                          
                          // Method to check only Accepted check box
                          
                          public static void CheckAccepted() throws Exception
                          {
                           if(Device_Model.contains("iPhone"))
                           {
                                  CheckAccepted_iOS();
                           } else
                           {
                                  CheckAccepted_AN();
                           }
                          }
                  

                          // Method to check only InProduction check box
                          
                          public static void CheckInProduction_AN() throws Exception
                          {
                           UncheckAllCheckboxes();
                          nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                          WebElement InProduction = nativedriver.findElement(By.xpath(Android_Objects.getProperty("InProductionUnChecked")));
                          InProduction.click();   
                          System.out.println("InProduction is checked");
                          }
                          
                          // Method to check on InProduction check box
                          
                          public static void CheckInProduction() throws Exception
                          {
                           if(Device_Model.contains("iPhone"))
                           {
                                  CheckInProduction_iOS();
                           } else
                           {
                                  CheckInProduction_AN();
                           }
                          }
                          
                    // Method to check only Shipped check box on filter option in Android
                       public static void CheckShipped_AN() throws Exception
                       {
                                   
                             UncheckAllCheckboxes();
                               nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                            WebElement Shipped = nativedriver.findElement(By.xpath(Android_Objects.getProperty("ShippedUnChecked")));
                            Shipped.click();   
                            System.out.println("Shipped is checked");
                         
                                       }
                       
               // Method to check only Shipped check box
                       public static void CheckShipped() throws Exception
                       {
                           if(Device_Model.contains("iPhone"))
                           {
                                 CheckShipped_iOS();
                           } else
                           {CheckShipped_AN();
                           
                           }
                       }

      // Method to click on Delivered Status on order detail page for Android
                                 public static void VerifyDeliveredStatus_AN() throws Exception
                                 {

                                   nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                             WebElement DeliveryStatus = nativedriver.findElement(By.xpath(Android_Objects.getProperty("DeliveryStatus")));
                             DeliveryStatus.click();  
                             System.out.println("Submitted is unchecked");
                                 }
                                 
                                  // Method to click on Delivered Status on order detail page
                                 
                                  public static void VerifyDeliveredStatus() throws Exception
                                 {
                                       if(Device_Model.contains("iPhone"))
                                       {
                                              VerifyDeliveredStatus("C://HPE//FunctionalTesting//Images//Delivered_symbol"+".png");
                                       } else
                                       {
                                              VerifyDeliveredStatus_AN();
                                       }
                                 }

                               // Method to verify menu slide
                                  
                                  public static void VerifyMenuSlide() throws Exception
                                  {
                                         if(Device_Model.contains("iPhone"))
                                  {
                                               VerifyMenuSlide_iOS();
                                  }else
                                  {
                                         VerifyMenuSlide_AN("C://HPE//FunctionalTesting//Images//HomeButton_AN"+".png");
                                  }
                                            
                                 }

                                //Method to Validate the menu slide from the left side in Android
                                  public static void VerifyMenuSlide_AN(String imagePath) throws Exception
                                
                                {
                                  try
                                  {
                                             WebElement MenuSlide = visualdriver.findElement(ByMobile.image(imagePath));                              
                                             MenuSlide.click();
                                             Thread.sleep(2000);
                                             testLog.info("\n Image found is : " + imagePath);
                                             testLog.info("User is unable to see a menu slide from the left");
                                       } catch (Exception e) {
                                             testLog.info("\nImage not present : " + imagePath);    
                                             testLog.info("User is able to see a menu slide from the left");
                                             status1 = 1;
                                             //Assert.fail();
                                       }
                             }

                      //Method to click on the order in Search list page	
                      	public static void ClickSearchResult1_iOS_old() throws Exception 
                      	{
                      				
                      		Find_Text_NoResults(config.getProperty("NoResults"));

                      		device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("320,575")));
                      		System.out.println("Clicked on any order on iphone");
                      		Thread.sleep(10000); 
                      						
                      			    				    				
                      	}
                      	
                     // Method to click on search result
                        
                        
                        public static void ClickSearchResult1_iOS() throws Exception
                        {
                                     try{ 
                                      
                                    Find_Text_NoResults(config.getProperty("NoResults"));
                                                                       
                                     }
                                     catch(Exception e)
                                     {
                                           /*
                                   device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("306,791")));
                                   System.out.println("Clicked on any order in Search Page");
                                   Thread.sleep(10000); 
                                   */
                                   // HPECommonFunctions.CheckServiceError("C://HPE//FunctionalTesting//Images//ServiceErrorOK" +".png");
                                   HPEOperations.firstOrderClick();
                                   Thread.sleep(10000); 
                                                                   
                                   HPECommonFunctions.VerifyEndCustomerName();
                                   HPECommonFunctions.Find_Text(config.getProperty("HPEOrderNumber"));
                                   HPECommonFunctions.Find_Text(config.getProperty("PONumber"));
                                   HPECommonFunctions.Find_Text(config.getProperty("OrderStatus"));
                                   HPECommonFunctions.Find_Text(config.getProperty("ShipDate"));
                                   HPECommonFunctions.Find_Text_Previously(config.getProperty("Previously"));
                                   HPECommonFunctions.ClickBackButton();
                                   
                                   //HPECommonFunctions.ClickSearchResult2();
                                   //ClickSearchResult2_iOS();
                                   HPEOperations.SecondOrderClick();
                                   HPECommonFunctions.VerifyEndCustomerName();
                                   HPECommonFunctions.Find_Text(config.getProperty("HPEOrderNumber"));
                                   HPECommonFunctions.Find_Text(config.getProperty("PONumber"));
                                   HPECommonFunctions.Find_Text(config.getProperty("OrderStatus"));
                                   HPECommonFunctions.Find_Text(config.getProperty("ShipDate"));
                                   HPECommonFunctions.Find_Text_Previously(config.getProperty("Previously")); 
                                   HPECommonFunctions.ClickSignOut();
                                   HPECommonFunctions.Close_App_HPE();
                              
                                   
                                     }
                                                                                                                          
                              }

                      	
                        //Method to click on the order in Search list page	
                      	public static void ClickSearchResult1_AN() throws Exception 
                      	{
                      				
                      		Find_Text_NoResults(config.getProperty("NoResults"));

                      		device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("511,1071")));
                      		System.out.println("Clicked on any order on Google Pixel");
                      		Thread.sleep(10000); 
                      		
                      		
                      						
                      			    				    				
                      	}
                      			
                      	
                      //Method to verify the footer on the app
            		    public static void ClickSearchResult1() throws Exception
            		      {
            		    	if(Device_Model.contains("iPhone"))
            		    	{
            		    		//ClickOnSearchIcon_iOS();
            		    		ClickSearchResult1_iOS();
            		    	}else if(Device_Model.contains("Pixel"))
            		    	{
            		    		ClickSearchResult1_Galaxy();
            		    	}
            		    	else if(Device_Model.contains("Galaxy"))
                            {
                                   ClickSearchResult1_Galaxy();
                            }

            		    	          
            		      } 
                    	
            		    
            		  //Method to click on the order in Search list page     
                        public static void ClickSearchResult1_Galaxy() throws Exception 
                         {
                          try{ 
                           
                                Find_Text_NoResults(config.getProperty("NoResults"));
                                                                         
                          }
                          catch(Exception e)
                          {
                                                    
/*
                               device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("511,1071")));
                               System.out.println("Clicked on any order on Google Pixel");
                               Thread.sleep(10000); 
                               */
                               
                                HPEOperations.firstOrderClick();
                               Thread.sleep(10000); 
                                                               
                        //       HPECommonFunctions.VerifyEndCustomerName();
                               HPECommonFunctions.Find_Text(config.getProperty("HPEOrderNumber"));
                               HPECommonFunctions.Find_Text(config.getProperty("PONumber"));
                               HPECommonFunctions.Find_Text(config.getProperty("OrderStatus"));
                               HPECommonFunctions.Find_Text(config.getProperty("ShipDate"));
                       //       HPECommonFunctions.Find_Text_Previously(config.getProperty("Previously"));
                               HPECommonFunctions.ClickBackButton();
                               
                        //       HPECommonFunctions.ClickSearchResult2();
                        //       HPECommonFunctions.VerifyEndCustomerName();

                               HPEOperations.SecondOrderClick();
                               HPECommonFunctions.Find_Text(config.getProperty("HPEOrderNumber"));
                               HPECommonFunctions.Find_Text(config.getProperty("PONumber"));
                               HPECommonFunctions.Find_Text(config.getProperty("OrderStatus"));
                               HPECommonFunctions.Find_Text(config.getProperty("ShipDate"));
                       //';.          HPECommonFunctions.Find_Text_Previously(config.getProperty("Previously")); 
                               
                               HPECommonFunctions.ClickSignOut();
                               HPECommonFunctions.Close_App_HPE();
                          }
                                             
                                                                                            
                        }

                        
                        
                      			//Method to click on another order in Search page
                      			public static void ClickSearchResult2_iOS() throws Exception {
                      				
                      				
                      				//Find_Text_NoResults(config.getProperty("NoResults"));
                      				

                      				device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("306,791")));
                      				Thread.sleep(2000);
                      				//HPECommonFunctions.CheckServiceError("C://HPE//FunctionalTesting//Images//ServiceErrorOK" +".png");
                      				System.out.println("Clicked on another order on iphone");
                      				Thread.sleep(10000); 
                      					
                          				    				
                      			}
                      			
                      		
                              	
                                //Method to click on the order in Search list page	
                              	public static void ClickSearchResult2_AN() throws Exception 
                              	{
                              				
                              		Find_Text_NoResults(config.getProperty("NoResults"));

                              		device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("533,1328")));
                              		System.out.println("Clicked on any order on Google Pixel");
                              		Thread.sleep(10000); 
                              						
                              			    				    				
                              	}
                              			
                              	
                              //Method to verify the footer on the app
                    		    public static void ClickSearchResult2() throws Exception
                    		      {
                    		    	if(Device_Model.contains("iPhone"))
                    		    	{
                    		    		//ClickOnSearchIcon_iOS();
                    		    		ClickSearchResult2_iOS();
                    		    	}else if(Device_Model.contains("Pixel"))
                    		    	{
                    		    		ClickSearchResult2_AN();
                    		    	}else if(Device_Model.contains("Galaxy"))
                                    {
                                        ClickSearchResult2_Galaxy();
                                 }

                    		    	          
                    		      } 
                            	
                    		  //Method to click on the order in Search list page  
                                public static void ClickSearchResult2_Galaxy() throws Exception 
                                {
                                              try
                                              {
                                       Find_Text_NoResults(config.getProperty("NoResults"));
                                              } catch(Exception e)
                                              {

                                       device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("533,1328")));
                                       System.out.println("Clicked on any order");
                                       Thread.sleep(10000); 
                                                                   
                                              }                                               
                                }

  
                          		//Method to Click on 8th paragraph on Terms and Conditions page in iOS
                	            public static void Click8thParagraph() throws Exception 
                	            {
                	            try
                	            {
                	            
                	            	nativedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                	            WebElement Paragraph8 = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("8thParagraph")));
                	            if(Paragraph8.isDisplayed())
                	            {      
                	            	Paragraph8.click();
                	            System.out.println("Clicked on Paragraph 8");
                	            Thread.sleep(10000);
                	            }
                	            	
                	            }
                	            catch(Exception e)
                	            {
                	            System.out.println("Paragraph 8 button is not Present");                          
                	            CaptureScreenshot("TC_Fail_"); 
                	            Open_App_HPE();
                	            //ClickSignOut();
                	            Close_App_HPE();
	                             Thread.sleep(2000);
                	            Assert.fail("Paragraph 8 button is not Present");
                	            }
                	         }
                	            
                	            
        //Method to click on Paragraph8
             public static void ClickParagraph8(String imagePath) throws Exception
             {

            	 try
                     	{
                	   		WebElement Paragraph8 = visualdriver.findElement(ByMobile.image(imagePath));					
                	   		Paragraph8.click();
               				testLog.info("\n Image found is : " + imagePath);
              				testLog.info("Clicked on Paragraph8");
               			} catch (Exception e) 
               			{
                	        testLog.info("\nImage not present : " + imagePath);	
                	        testLog.info("Paragraph8 is not found");
                	        status1 = 1;
                	        //Assert.fail();
               			}
                	   	}
                	      
             public static void ClickParagraph8() throws Exception
             	{
                    if(Device_Model.equals("iPhone-7"))
                    {
                    	ClickParagraph8("C://HPE//FunctionalTesting//Images//Paragraph8" +".png");
                    } else if(Device_Model.equals("iPhone-5S"))
                    {
                    	ClickParagraph8("C://HPE//FunctionalTesting//Images//Paragraph8_iPhone5S" +".png");
                    }else if(Device_Model.contains("Pixel"))
                    {
                    ClickParagraph8("C://HPE//FunctionalTesting//Images//Paragraph8_Pixel" +".png");
                    }else if(Device_Model.contains("Galaxy S6"))
                    {
                    	ClickParagraph8("C://HPE//FunctionalTesting//Images//Paragraph8_Galaxy" +".png");
                    
                    } else if(Device_Model.contains("Galaxy S7"))
                    {
                    	ClickParagraph8("C://HPE//FunctionalTesting//Images//Paragraph8_GalaxyS7" +".png");
                    
                    } else if(Device_Model.equals("iPhone-6S"))
                    {
                    	ClickParagraph8("C://HPE//FunctionalTesting//Images//Paragraph8" +".png");
                    }
             	}

       
             
             
            	// Method to verify the recent searches date & time
                 public static void VerifyRecentSearchDateTime() throws Exception
                     {
                     try
                     {
                             Thread.sleep(5000);
                             WebElement DateTime = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Date")));
                             if(!DateTime.isDisplayed())
                             {
                            	 String DateTime1 = DateTime.getAttribute("name");
                            	 System.out.println("Date & Time is Present & below is the Date & Time");
                            	 System.out.println(DateTime1);
                            	 Thread.sleep(2000); 
                            	 
                        
                             }
                                   }
                                   catch(Exception e)
                                   {
                                          System.out.println("Date & Time is not Present");                        
                                          CaptureScreenshot("TC_Fail_");                         
                                          //ClickSignOut();
                                          Close_App_HPE();
         	                             Thread.sleep(2000);
                                          Assert.fail("Date & Time is not Present");
                                   }
               	             
                   }

               //Method to verify the Watch list number on the Menu Page for iOS
                 public static void VerifyWatchListNumber_iOS() throws Exception
                     {
                	 try
                     {
                             Thread.sleep(5000);
                             WebElement WatchListNumber = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("WatchListNumber")));
                             WatchListNumber1 = WatchListNumber.getAttribute("text");
                             System.out.println("Below is the Watch List Number");
                        	 System.out.println(WatchListNumber1);                          
                           	 Thread.sleep(2000); 
                     }
                           	 
                           	catch(Exception e)
                            {
                                   System.out.println("Watch List Number is not Present");                        
                                   CaptureScreenshot("TC_Fail_");                         
                                   //ClickSignOut();
                                   Close_App_HPE();
  	                             Thread.sleep(2000);
                                   Assert.fail("Watch List Number is not Present");
                            }
                            	 
                        
                             }
                 
               //Method to verify the Watch list number on the Menu Page for android
                 public static void VerifyWatchListNumber_AN() throws Exception
                     {
                	 try
                     {
                             Thread.sleep(5000);
                             WebElement WatchListNumber = nativedriver.findElement(By.xpath(Android_Objects.getProperty("WatchList")));
                             WatchListNumber1 = WatchListNumber.getAttribute("name");
                             System.out.println("Below is the Watch List Number");
                        	 System.out.println(WatchListNumber1);                          
                           	 Thread.sleep(2000); 
                     }
                           	 
                           	catch(Exception e)
                            {
                                   System.out.println("Watch List Number is not Present");                        
                                   CaptureScreenshot("TC_Fail_");                         
                                   //ClickSignOut();
                                   Close_App_HPE();
  	                             Thread.sleep(2000);
                                   Assert.fail("Watch List Number is not Present");
                            }
                            	 
                        
                             }
                 
               //Method to verify the Watch list number on the Menu Page                 
                 public static void VerifyWatchListNumber() throws Exception
                                {
                                 if(Device_Model.contains("iPhone"))
                                 {
                                	 VerifyWatchListNumber_iOS();
                                 }else
                                 {
                                	 VerifyWatchListNumber_AN();
                                 }
                                           
                                }
                 
                 //Method to enter wrong username
                 public static void EnterWrongUserName(String WrongUserName) throws Exception
                 {
                      try
                      {
                 WebElement UNElement = nativedriver.findElement(By.xpath(Android_Objects.getProperty("UserID")));
                 //WebElement UNElement = nativedriver.findElement(By.id(Android_Objects.getProperty("UserIDAN")));
                 Thread.sleep(5000);
                 UNElement.click();
                 Thread.sleep(5000);
                 
                 UNElement.sendKeys(WrongUserName);
                 System.out.println("Entered Username");
                 Thread.sleep(5000);
                      }
                 catch(Exception e)
             	{
             		System.out.println("Unable to find password field");				
             		CaptureScreenshot("TC_Fail_");				
             		//ClickSignout();
             		Close_App_HPE();
                     Thread.sleep(2000);
             		Assert.fail("Unable to find password field");
             	}
                 
                 }

              // Method to enter wrong Password in Android
                 public static void EnterWrongPassword_AN(String WrongPassword) throws Exception
                 {
                 try{
                     	WebElement PWDElement = nativedriver.findElement(By.xpath(Android_Objects.getProperty("PasswordAN")));
                        Thread.sleep(1000);               
                        PWDElement.click();               
                        Thread.sleep(1000);
                        //PWDElement.clear();
                        PWDElement.sendKeys(WrongPassword);
                        System.out.println("Entered Password");
                        Thread.sleep(5000);
                 }
             	catch(Exception e)
            	{
            		System.out.println("Unable to find password field");				
            		CaptureScreenshot("TC_Fail_");				
            		//ClickSignout();
            		Close_App_HPE();
                    Thread.sleep(2000);
            		Assert.fail("Unable to find password field");
            	}
                 
                 }

              // Method to Enter wrong password
                 
                 public static void EnterWrongPassword() throws Exception
                 {
                        if(Device_Model.contains("iPhone"))
                        {
                               EnterPassword_iOS(config.getProperty("WrongPassword"));
                         } else
                         {
                        	 EnterPassword_AN(config.getProperty("WrongPassword"));
                        }
                                                                 
                 }

                 
             
               // Method to click on Order Date range - Start
                               public static void ClickOnOrderStartDate_AN() throws Exception
                                    {      
                                    
                                          device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("484,744")));
                                          System.out.println("Clicked on Calendar");
                                        Thread.sleep(10000);              
                                                        
                                    }
                               
                               public static void ClickOnOrderStartDate_iOS() throws Exception
                               { 
                                    nativedriver.findElement(By.xpath(iOS_Objects.getProperty("OrderStartCalender"))).click();
                                    System.out.println("Clicked on Calendar");
                                   Thread.sleep(2000);
                                    
                                    
                               }
                               
                               
                               public static void ClickOnOrderStartDate() throws Exception
                               {
                                      if(Device_Model.contains("iPhone"))
                                      {
                                           ClickOnOrderStartDate_iOS();
                                           } else
                                                  {
                                           ClickOnOrderStartDate_AN();
                                                                         }
                                                                               
                               }

                               
                       // Method to click on Order start - Today
                               
                             public static void ClickonOrderDateStartDate() throws Exception
                                    {      
                                    
                                         // device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("410,1342")));
                            	 nativedriver.findElement(By.xpath(iOS_Objects.getProperty("OrderStartDate"))).click();
                                          System.out.println("Clicked on start date in Calendar");
                                        Thread.sleep(10000); 
                                    }
                             
                            
                             public static void  ClickonOrderDateStartToday() throws Exception
                             {      
                             
                                  // device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("410,1342")));
                     	 nativedriver.findElement(By.xpath(iOS_Objects.getProperty("OrderStartDateToday"))).click();
                                   System.out.println("Clicked on today in Calendar and its Auto Populated");
                                 Thread.sleep(10000); 
                             }
                                                 
                 // Method to click on Order Date range - End
                             public static void ClickOnOrderEndDate_AN() throws Exception
                                    {      
                                    
                                          device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("1038,740")));
                                          System.out.println("Clicked on Calendar button");
                                        Thread.sleep(10000);              
                                                        
                                    }
                             
                             public static void ClickOnOrderEndDate_iOS() throws Exception
                             { 
                                    nativedriver.findElement(By.xpath(iOS_Objects.getProperty("OrderEndCalender"))).click();
                                    System.out.println("Clicked on Calendar button");
                                   Thread.sleep(2000);
                                    
                                    
                             }
                             
                             public static void ClickOnOrderEndDate() throws Exception
                             {
                                    if(Device_Model.contains("iPhone"))
                                    {
                                         ClickOnOrderEndDate_iOS();
                                         } else
                                                {
                                         ClickOnOrderEndDate_AN();
                                                                       }
                                                                             
                             }
                             


               // Method to click on Order End - Date click
                               
                               public static void ClickonOrderDate_AN() throws Exception

                               {
                                    device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("797,1347")));
                                          System.out.println("Clicked on end date in Calendar");
                                        Thread.sleep(10000); 
                               }

                               

                               public static void ClickonOrderDate_iOS() throws Exception
                               { 
                                    nativedriver.findElement(By.xpath(iOS_Objects.getProperty("OrderEndDate"))).click();
                                    System.out.println("Clicked on end date in Calendar");
                                   Thread.sleep(2000);
                                    
                                    
                               }
                               
                               public static void ClickonOrderDate() throws Exception
                               {
                                      if(Device_Model.contains("iPhone"))
                                      {
                                           ClickonOrderDate_iOS();
                                           } else
                                                  {
                                           ClickonOrderDate_AN();
                                                                         }
                                                                               
                               }


                               

                               
                               // Method to click on Order start Date from Calendar
                               public static void ClickonShippingStartDate_AN() throws Exception
                                                    {      
                               device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("547,792")));
                               System.out.println("Clicked on start date in Calendar");
                                                        Thread.sleep(10000);   
                                                    }

                               public static void ClickonShippingStartDate_iOS() throws Exception{
                            	   
                            	   ClickonStartCalenderIcon_iOS();
                            	   Thread.sleep(10000);
                                   nativedriver.findElement(By.xpath(iOS_Objects.getProperty("CalenderStartDate"))).click();
                                   Thread.sleep(2000);
                              }
                               
                               public static void ClickonStartCalenderIcon_iOS() throws Exception{
                                   nativedriver.findElement(By.xpath(iOS_Objects.getProperty("StartCalenderIcon"))).click();
                                   Thread.sleep(2000);
                              }
                              
                               
                               public static void ClickonEndCalenderIcon_iOS() throws Exception{
                                   nativedriver.findElement(By.xpath(iOS_Objects.getProperty("EndCalenderIcon"))).click();
                                   Thread.sleep(2000);
                              }
                               
                               

                              
                               // Method to click on Order End Date from Calendar
                               public static void ClickonShippingEndDate() throws Exception
                                               {
                              device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("538,875")));
                               System.out.println("Clicked on end date in Calendar");
                               Thread.sleep(5000);                                                   
                                 }
                               

                               public static void ClickonShippingEndDate_iOS() throws Exception{
                            	   
                            	   ClickonEndCalenderIcon_iOS();
                            	   Thread.sleep(10000);
                                   nativedriver.findElement(By.xpath(iOS_Objects.getProperty("CalenderEndDate"))).click();
                                   Thread.sleep(2000);
                              }



                               public static void ClickOnDeliveryStartDateCalendar_iOS() throws Exception
                               {
                                    nativedriver.findElement(By.xpath(iOS_Objects.getProperty("DeliveryDateCalender"))).click();
                                    System.out.println("Clicked on Calendar");
                                   Thread.sleep(2000); 
                                   }
                               
                               public static void ClickOnDateOrderedCalendar_iOS() throws Exception
                               {
                                    nativedriver.findElement(By.xpath(iOS_Objects.getProperty("OrderStartCalender"))).click();
                                    System.out.println("Clicked on Calendar");
                                   Thread.sleep(2000); 
                                   }


                               
                               public static void ClickOnDeliveryEndDateCalendar_iOS() throws Exception
                               {
                                    nativedriver.findElement(By.xpath(iOS_Objects.getProperty("DeliveryEndDateCalender"))).click();
                                    System.out.println("Clicked on Calendar");
                                   Thread.sleep(2000); 
                                   }
                               

                               
                               
                               // Method to click on Delivery start Date from Calendar
                               public static void ClickonDeliveryDate_AN() throws Exception
                                                    {      
                               device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("538,792")));
                               System.out.println("Clicked on start date in Calendar");
                                                        Thread.sleep(10000);   
                                                    }
                               
                               public static void ClickonDeliveryDate_iOS() throws Exception{
                                   
                                   nativedriver.findElement(By.xpath(iOS_Objects.getProperty("DeliveryStartDate"))).click();
                                   System.out.println("Clicked on start date in Calendar");
                                  Thread.sleep(2000); 
                                   
                              }
                              
                              public static void ClickonDeliveryDate() throws Exception
                              {
                               if(Device_Model.contains("iPhone"))
                               {
                               ClickonDeliveryDate_iOS();
                               }else                
                            
                         {
                               ClickonDeliveryDate_AN();
                               }
                                         
                              }

                              

                               // Method to click on Order End Date from Calendar
                               public static void ClickonDeliveryEndDate_AN() throws Exception
                                               {
                               device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("538,796")));
                               System.out.println("Clicked on end date in Calendar");
                               Thread.sleep(10000);                                                   
                                 }
                               
                               public static void ClickonDeliveryEndDate_iOS() throws Exception{
                                   
                                   nativedriver.findElement(By.xpath(iOS_Objects.getProperty("DeliveryEndDate"))).click();
                                   System.out.println("Clicked on End date in Calendar");
                                  Thread.sleep(2000); 
                                   
                              }
                              
                                   public static void ClickonDeliveryEndDate() throws Exception
                                   {
                                    if(Device_Model.contains("iPhone"))
                                    {
                                         ClickonDeliveryEndDate_iOS();
                                    }else                
                                 
                              {
                                         ClickonDeliveryEndDate_AN();
                                    }
                                              
                                   }

                                   
                                   
                               public static void ClickPreviousMonth_AN() throws Exception
                               {
                               WebElement PreviousMonthArrow = nativedriver.findElement(By.xpath(Android_Objects.getProperty("PreviousMonth")));
                               Thread.sleep(5000);
                               PreviousMonthArrow.click();
                               System.out.println("Clicked on Previous Month Arrow");
                               Thread.sleep(10000);       
                               
                               }
                               
                               public static void ClickPreviousMonth_iOS() throws Exception
                               {
                               WebElement PreviousMonthArrow = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("PreviousMonth")));
                               Thread.sleep(5000);
                               PreviousMonthArrow.click();
                               System.out.println("Clicked on Previous Month Arrow");
                               Thread.sleep(10000);       
                               
                               }
                               public static void ClickPreviousMonth() throws Exception
                               {
                                if(Device_Model.contains("iPhone"))
                                {
                                ClickPreviousMonth_iOS();
                                }else                
                             
                          {
                                ClickPreviousMonth_AN();
                                }
                                          
                               }

                               
                               public static void ClickNextMonth_AN() throws Exception
                               {
                               WebElement NextMonthArrow = nativedriver.findElement(By.xpath(Android_Objects.getProperty("NextMonth")));
                               Thread.sleep(5000);
                               NextMonthArrow.click();
                               System.out.println("Clicked on Next Month Arrow");
                               Thread.sleep(10000);       
                               
                               }
                               
                               public static void ClickNextMonth_iOS() throws Exception
                               {
                               WebElement NextMonthArrow = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("NextMonth")));
                               Thread.sleep(5000);
                               NextMonthArrow.click();
                               System.out.println("Clicked on Next Month Arrow");
                               Thread.sleep(10000);       
                               
                               }
                               
                               public static void ClickNextMonth() throws Exception
                               {
                                if(Device_Model.contains("iPhone"))
                                {
                                ClickNextMonth_iOS();
                                }else                
                             
                          {
                                ClickNextMonth_AN();
                                }
                                          
                               }




                            // Method to click on Ship date field

                               public static void ClickShipDateField_AN() throws Exception
                                       {
                                       WebElement ShipDateField= nativedriver.findElement(By.xpath(Android_Objects.getProperty("ShipStartDateField")));
                                       Thread.sleep(5000);
                                       ShipDateField.click();
                                       System.out.println("Clicked on Ship Date area");
                                       Thread.sleep(10000);       
                                       
                                       }
                               
                               public static void ShipCompleteDate() throws Exception
                               {
                            	   WebElement ShipComplete= nativedriver.findElement(By.xpath(Android_Objects.getProperty("ShipStartDateField")));
                            	   Thread.sleep(1000);
                            	   ShipComplete.click();
                            	   System.out.println("Ship Complete Data option selected");
                               }
                               
                               public static void ShippedDate() throws Exception
                               {
                            	   WebElement ShippedDate= nativedriver.findElement(By.xpath(Android_Objects.getProperty("ShippedDate")));
                            	   Thread.sleep(1000);
                            	   ShippedDate.click();
                            	   System.out.println(" Shipped Date option selected");
                               }
                               
                               public static void DeliveredDate() throws Exception
                               {
                            	   WebElement DeliveredDate= nativedriver.findElement(By.xpath(Android_Objects.getProperty("DeliveredDate")));
                               Thread.sleep(1000);
                               DeliveredDate.click();
                               System.out.println(" Delivered Date option selected");
                               }
                               
                               
                               public static void ClickShipDateField_iOS() throws Exception
                               {
                               WebElement ShipDateField= nativedriver.findElement(By.xpath(iOS_Objects.getProperty("ShipStartDateField")));
                               Thread.sleep(5000);
                               ShipDateField.click();
                               System.out.println("Clicked on Ship Date area");
                               Thread.sleep(10000);       
                               
                               }
                               
                               public static void ClickShipDateField() throws Exception
                               {
                                if(Device_Model.contains("iPhone"))
                                {
                                ClickShipDateField_iOS();
                                }else                
                             
                          {
                                ClickShipDateField_AN();
                                }
                                          
                               }


                               // Method to click on Delivery date field

                               public static void ClickDeliveryDateField_AN() throws Exception
                               {
                               WebElement DeliveryStartDateField= nativedriver.findElement(By.xpath(Android_Objects.getProperty("DeliveryStartDateField")));
                               Thread.sleep(5000);
                               DeliveryStartDateField.click();
                               System.out.println("Clicked on Delivery Date area");
                               Thread.sleep(10000);       

                               }

                               public static void ClickDeliveryDateField_iOS() throws Exception
                               {
                               WebElement DeliveryStartDateField= nativedriver.findElement(By.xpath(iOS_Objects.getProperty("DeliveryStartDateField")));
                               Thread.sleep(5000);
                               DeliveryStartDateField.click();
                               System.out.println("Clicked on Delivery Date area");
                               Thread.sleep(10000);       

                               }
                               
                               public static void ClickDeliveryDateField() throws Exception
                               {
                                if(Device_Model.contains("iPhone"))
                                {
                                ClickDeliveryDateField_iOS();
                                }else                
                             
                          {
                                ClickDeliveryDateField_AN();
                                }
                                          
                               }



                             //Method to Verify the Search button for Android in Advance Search screen
                               public static void ClickOnSearchButtonAdvanceSearch_AN() throws Exception

                       {
                               WebElement SearchButton = nativedriver.findElement(By.xpath(Android_Objects.getProperty("SearchButtonAfter")));
                               Thread.sleep(5000);
                               SearchButton.click();
                               System.out.println("Clicked on Search button");
                               Thread.sleep(10000);       
                               
                               }
                               
                               public static void ClickOnSearchButtonAdvanceSearch_iOS() throws Exception

                               {
                                       WebElement SearchButton = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("SearchButtonAfter")));
                                       Thread.sleep(5000);
                                       SearchButton.click();
                                       System.out.println("Clicked on Search button");
                                       Thread.sleep(10000);       
                                       
                                       }
                               
                               public static void ClickOnSearchButtonAdvanceSearch() throws Exception
                               {
                                if(Device_Model.contains("iPhone"))
                                {
                                ClickOnSearchButtonAdvanceSearch_iOS();
                                }else                
                             
                          {
                                ClickOnSearchButtonAdvanceSearch_AN();  
                                }
                                          
                               }


                               public static void ClickOnSearchButtonAfter(String imagePath) throws Exception
                               
                               {
                                 try
                                 {
                                            WebElement SearchIconWatchAfter = visualdriver.findElement(ByMobile.image(imagePath));                              
                                            SearchIconWatchAfter.click();
                                            testLog.info("\n Image found is : " + imagePath);
                                            testLog.info("Clicked on Search button");
                                      } catch (Exception e) {
                                            testLog.info("\nImage not present : " + imagePath);    
                                            testLog.info("Search not present");
                                            status1 = 1;
                                            //Assert.fail();
                                            CaptureScreenshot("TC_Fail_");				
                                            //ClickSignOut();
                                            Close_App_HPE();
           	                             Thread.sleep(2000);
                                            Assert.fail("Search Icon is not present");

                                      }
                             }

 public static void ClickOnKeypadGoButton(String imagePath) throws Exception
                               
                               {
                                 try
                                 {
                                            WebElement KeypadGo = visualdriver.findElement(ByMobile.image(imagePath));                              
                                            KeypadGo.click();
                                            testLog.info("\n Image found is : " + imagePath);
                                            testLog.info("Clicked on Keypad Go button");
                                      } catch (Exception e) {
                                            testLog.info("\nImage not present : " + imagePath);    
                                            testLog.info("Go button not present in the keypad");
                                            status1 = 1;
                                            //Assert.fail();
                                            CaptureScreenshot("TC_Fail_");				
                                            //ClickSignOut();
                                            Close_App_HPE();
           	                             Thread.sleep(2000);
                                            Assert.fail("Go button not present in the keypad");

                                      }
                             }
                               
                               // Method to verify the Watch List Tips
                               
                               
                               public static void VerifyWatchListTips() throws Exception

                               {
                            	   try{
                            		   
                            		   Find_Text_WatchListTips(config.getProperty("WatchListTips")); 
                            		   Close_App_HPE();
                            	   }catch (Exception e)
                            	   {
                            		   RemoveWatchListOrders();
                            		   Find_Text_WatchListTips(config.getProperty("WatchListTips"));
                            		   //HPECommonFunctions.ClickSignOut();
                           	    	   //HPECommonFunctions.Close_App_HPE();
                            	   }
                               }
                               
// Method to verify the Watch List Tips
                               
                               
                               public static void ClickWatchlistCancel() throws Exception

                               {
                            	   try{
                            		   
                            		   Find_Text_WatchListTips(config.getProperty("WatchListTips")); 
                            		   Close_App_HPE();
                            	   }catch (Exception e)
                            	   {
                            		   	HPECommonFunctions.ClickGreenFlag1();
                            		   	HPECommonFunctions.AlertPopUp_ClickCancel();	
                            			HPECommonFunctions.ClickSignOut();
                            			HPECommonFunctions.Close_App_HPE();
                            	   }
                               }
                            // Method to click on Shipping Address 
                               
                               
                               public static void ShippingAddress(String Search_Keyword) throws Exception

                               {
                                      try
                                            {
                                                                        
                               WebElement ShippingAddress = nativedriver.findElement(By.xpath(Android_Objects.getProperty("ShippingAddress")));
                               Thread.sleep(5000);
                               ShippingAddress.click();
                               Thread.sleep(5000);
                               ShippingAddress.sendKeys(Search_Keyword);
                               System.out.println("Entered Shipping Address ");
                               Thread.sleep(5000);
                               }
                               
                               catch(Exception e)
                               {
                                      System.out.println("Shipping Address not entered");                          
                                      CaptureScreenshot("TC_Fail_");           
                                      //ClickSignOut();
                                      Close_App_HPE();
     	                             Thread.sleep(2000);
                                      Assert.fail("Shipping Address not entered");
                               }
                               }
                               
// Method to click on Shipping Address 
                               
                               
                               public static void ShippingAddress_AN(String ShippingAddress) throws Exception

                               {
                                      try
                                            {
                                                                        
                               WebElement ShippingAddressBox = nativedriver.findElement(By.xpath(Android_Objects.getProperty("ShippingAddress")));
                               Thread.sleep(5000);
                               ShippingAddressBox.click();
                               Thread.sleep(5000);
                               ShippingAddressBox.sendKeys(ShippingAddress);
                               System.out.println("Entered Shipping Address ");
                               Thread.sleep(5000);
                               }
                               
                               catch(Exception e)
                               {
                                      System.out.println("Shipping Address not entered");                          
                                      CaptureScreenshot("TC_Fail_");           
                                      // ClickSignOut();
                                      //Close_App();
                                      Assert.fail("Shipping Address not entered");
                               }
                               }
                               
                               
                               public static void ShippingAddress_iOS(String ShippingAddress) throws Exception

                               {
                                      try
                                            {
                                           
                                     Thread.sleep(3000);                                   
                               WebElement ShippingAddressBox = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("CustomerNameField")));
                               Thread.sleep(5000);
                               ShippingAddressBox.click();
                               Thread.sleep(5000);
                               ShippingAddressBox.sendKeys(ShippingAddress);
                               System.out.println("Entered Shipping Address ");
                               Thread.sleep(2000);
                               nativedriver.findElement(By.xpath(iOS_Objects.getProperty("DoneButton"))).click();
                                    Thread.sleep(2000);
                               }
                               
                               catch(Exception e)
                               {
                                      System.out.println("Shipping Address not entered");                          
                                      CaptureScreenshot("TC_Fail_");           
                                      // ClickSignOut();
                                      //Close_App();
                                      Assert.fail("Shipping Address not entered");
                               }
                               }

                               
                               public static void ShippingAddress() throws Exception
                               {
                                      if(Device_Model.contains("iPhone"))
                                      {
                                    	  ShippingAddress_iOS(config.getProperty("ShippingAddress"));
                                           } else
                                                  {
                                          ShippingAddress_AN(config.getProperty("ShippingAddress"));
                                                                         }
                                                                               
                               }

                               
                               
                               
                               
           // Method to click on HPE Product Number 
                             
                               
                               public static void HPEProdcutNumber(String HPEProductNumberSearch) throws Exception

                               {
                                      try
                                            {
                                                                        
                               WebElement HPEProductNumberBox = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("HPEProducttNumber")));
                               Thread.sleep(5000);
                               HPEProductNumberBox.click();
                               Thread.sleep(5000);
                               HPEProductNumberBox.sendKeys(HPEProductNumberSearch);
                               System.out.println("Entered HPE Product Number ");
                               Thread.sleep(5000);                               
                               nativedriver.findElement(By.xpath(iOS_Objects.getProperty("DoneButton"))).click();
                                 Thread.sleep(2000);
                               }
                               
                               catch(Exception e)
                               {
                                      System.out.println("HPE Product Number not entered");                          
                                      CaptureScreenshot("TC_Fail_");           
                                      //ClickSignOut();
                                      Close_App_HPE();
     	                             Thread.sleep(2000);
                                      Assert.fail("HPE Product Number not entered");
                               }
                               }

          
// Method to click on HPE Product Number 
                             
                               
                               public static void HPEProdcutNumber_AN(String HPEProductNumberSearch) throws Exception

                               {
                                      try
                                            {
                                                                        
                               WebElement HPEProductNumberBox = nativedriver.findElement(By.xpath(Android_Objects.getProperty("HPEProducttNumber")));
                               Thread.sleep(5000);
                               HPEProductNumberBox.click();
                               Thread.sleep(5000);
                               HPEProductNumberBox.sendKeys(HPEProductNumberSearch);
                               System.out.println("Entered HPE Product Number ");
                               Thread.sleep(5000);
                               }
                               
                               catch(Exception e)
                               {
                                      System.out.println("HPE Product Number not entered");                          
                                      CaptureScreenshot("TC_Fail_");           
                                      // ClickSignOut();
                                      //Close_App();
                                      Assert.fail("HPE Product Number not entered");
                               }
                               }
                               
                               
                               public static void HPEProdcutNumber_iOS(String HPEProductNumberSearch) throws Exception

                               {
                                      try
                                            {
                                                                        
                               WebElement HPEProductNumberBox = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("HPEProducttNumber")));
                               Thread.sleep(5000);
                               HPEProductNumberBox.click();
                               Thread.sleep(5000);
                               HPEProductNumberBox.sendKeys(HPEProductNumberSearch);
                               System.out.println("Entered HPE Product Number ");
                               Thread.sleep(5000);
                               nativedriver.findElement(By.xpath(iOS_Objects.getProperty("DoneButton"))).click();
                                    Thread.sleep(2000);
                               }
                               
                               catch(Exception e)
                               {
                                      System.out.println("HPE Product Number not entered");                          
                                      CaptureScreenshot("TC_Fail_");           
                                      // ClickSignOut();
                                      //Close_App();
                                      Assert.fail("HPE Product Number not entered");
                               }
                               }

                               
                               
                            // Method to click on Search button, greyed out      
                               public static void ClickSearchAdvanceSearchBefore(String imagePath) throws Exception
                                             
                                             {
                                               try
                                               {
                                            	   		  Thread.sleep(3000);
                                                          WebElement SearchIconWatchBefore = visualdriver.findElement(ByMobile.image(imagePath));                              
                                                          SearchIconWatchBefore.click();
                                                          testLog.info("\n Image found is : " + imagePath);
                                                          testLog.info("Clicked on Search, Search Icon Greyed out");
                                                          Thread.sleep(5000);
                                                    } catch (Exception e) {
                                                          testLog.info("\nImage not present : " + imagePath);    
                                                          testLog.info("Search not present");
                                                          status1 = 1;
                                                          CaptureScreenshot("TC_Fail_");				
                                                          //ClickSignOut();
                                                          Close_App_HPE();
                         	                             Thread.sleep(2000);
                                                          Assert.fail("Search Icon is not present");

                                                    }
                                          }
                               
                               public static void ClickSearchAdvanceSearchBefore() throws Exception
                               {
                                      if(Device_Model.contains("iPhone"))
                                      {
                                    	  ClickSearchAdvanceSearchBefore("C://HPE//FunctionalTesting//Images//SearchButtonBefore"+".png");
                                           } else
                                                  {
                                        	   ClickSearchAdvanceSearchBefore("C://HPE//FunctionalTesting//Images//SearchButtonBefore_AN"+".png");
                                                                         }
                                                                               
                               }
                               
                               public static void ClickOnSearchButtonAfter() throws Exception
                               {
                                      if(Device_Model.equals("iPhone-7"))
                                      {
                                    	  ClickOnSearchButtonAfter("C://HPE//FunctionalTesting//Images//SearchButtonAfter"+".png");
                                      } else if(Device_Model.equals("iPhone-5S"))
                                           {
                                         	  ClickOnSearchButtonAfter("C://HPE//FunctionalTesting//Images//SearchButtonAfter_iPhone5S"+".png");
                                           } else if(Device_Model.contains("Pixel"))
                                                  {
                                        	   ClickOnSearchButtonAfter("C://HPE//FunctionalTesting//Images//SearchButtonAfter_Pixel"+".png");
                                                   }else if(Device_Model.contains("Galaxy"))
                                                   {
                                                       ClickOnSearchButtonAfter("C://HPE//FunctionalTesting//Images//SearchButtonAfter_Galaxy"+".png");
                                                    }else if(Device_Model.equals("iPhone-6S"))
                                                    {
                                                  	  ClickOnSearchButtonAfter("C://HPE//FunctionalTesting//Images//SearchButtonAfter"+".png");
                                                    }

                                                                               
                               }
                               
                               public static void EnterCustomerName() throws Exception
                               {
                                      if(Device_Model.contains("iPhone"))
                                      {
                                    	  EnterCustomerName_iOS(config.getProperty("Search_Keyword"));
                                           } else
                                                  {
                                        	   EnterCustomerName_AN(config.getProperty("Search_Keyword"));
                                                                         }
                                                                               
                               }

                            // Method to click on End Customer name 
                               
                               
                               public static void EnterCustomerName_AN(String Search_Keyword) throws Exception

                               {
                                      try
                                            {
                                                                        
                               WebElement CustomerName = nativedriver.findElement(By.xpath(Android_Objects.getProperty("CustomerNameField")));
                               Thread.sleep(5000);
                               CustomerName.click();
                               Thread.sleep(5000);
                               CustomerName.sendKeys(Search_Keyword);
                               System.out.println("Entered Customer Name ");
                               Thread.sleep(5000);
                               }
                               
                               catch(Exception e)
                               {
                                      System.out.println("Customer Name not entered");                          
                                      CaptureScreenshot("TC_Fail_");           
                                      // ClickSignOut();
                                      //Close_App();
                                      Assert.fail("Customer Name not entered");
                               }
                               }
                               
                               
                               public static void EnterCustomerName_iOS(String Search_Keyword) throws Exception

                               {
                                      try
                                            {
                                                                        
                               WebElement CustomerName = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("CustomerNameField")));
                               Thread.sleep(5000);
                               CustomerName.click();
                               Thread.sleep(5000);
                               CustomerName.sendKeys(Search_Keyword);
                               System.out.println("Entered Customer Name ");
                               Thread.sleep(5000);
                               nativedriver.findElement(By.xpath(iOS_Objects.getProperty("DoneButton"))).click();
                                 Thread.sleep(2000);
                               }
                               
                               catch(Exception e)
                               {
                                      System.out.println("Customer Name not entered");                          
                                      //CaptureScreenshot("TC_Fail_");           
                                      ClickSignOut();
                                     // Close_App();
                                      Assert.fail("Customer Name not entered");
                               }
                               }

                               
                             // Method to click on End Customer name 
                                                
                                                  
                                                  public static void EnterCustomerName(String Search_Keyword) throws Exception

                                                  {
                                                         try
                                                               {
                                                                                           
                                                  WebElement CustomerName = nativedriver.findElement(By.xpath(Android_Objects.getProperty("CustomerNameField")));
                                                  Thread.sleep(5000);
                                                  CustomerName.click();
                                                  Thread.sleep(5000);
                                                  CustomerName.sendKeys(Search_Keyword);
                                                  System.out.println("Entered Customer Name ");
                                                  Thread.sleep(5000);
                                                  }
                                                  
                                                  catch(Exception e)
                                                  {
                                                         System.out.println("Customer Name not entered");                          
                                                         CaptureScreenshot("TC_Fail_");           
                                                         //ClickSignOut();
                                                         Close_App_HPE();
                        	                             Thread.sleep(2000);
                                                         Assert.fail("Customer Name not entered");
                                                  }
                                                  }

                                               // Method to click on Search button, after entering customer name      
                                                  public static void ClickSearchAdvanceSearchAfter(String imagePath) throws Exception
                                                               
                                                               {
                                                                 try
                                                                 {
                                                                            WebElement SearchIconWatchAfter = visualdriver.findElement(ByMobile.image(imagePath));                              
                                                                            SearchIconWatchAfter.click();
                                                                            testLog.info("\n Image found is : " + imagePath);
                                                                            testLog.info("Clicked on Search");
                                                                      } catch (Exception e) {
                                                                            testLog.info("\nImage not present : " + imagePath);    
                                                                            testLog.info("Search not present");
                                                                            status1 = 1;
                                                                            CaptureScreenshot("TC_Fail_");				
                                                                            //ClickSignOut();
                                                                            Close_App_HPE();
                                           	                             Thread.sleep(2000);
                                                                            Assert.fail("Search Icon is not present");

                                                                      }
                                                            }
                                               // Method to click on Search button - After  
                                                  public static void ClickSearchButtonAfter_AN() throws Exception
                                                	{	
                                                	
                                                		device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("547,1220")));
                                                		System.out.println("Clicked on the Search button");
                                                	    Thread.sleep(10000); 		    
                                                				
                                                	}
                                                  
                                                  public static void ClickSearchButtonAfter() throws Exception
                                                  {
                                                         if(Device_Model.contains("iPhone"))
                                                         {
                                                        	 ClickSearchButtonAfter_iOS();
                                                              } else
                                                                     {
                                                            	  ClickSearchButtonAfter_AN();
                                                                                            }
                                                                                                  
                                                  }

                                                  
                                                  public static void ClickSearchButtonAfter_iOS() throws Exception
                                                  {       
                                                  
                                                     nativedriver.findElement(By.xpath(iOS_Objects.getProperty("ClickAdvancedSearchButton"))).click();
                                                           System.out.println("Clicked on the Advance Search button");
                                                      Thread.sleep(10000);                     
                                                                           
                                                   }

                                                  
                 
                                                //Method to verify the Watch list results on the WatchList Page for iOS
                                                  public static void VerifyWatchListResults_iOS() throws Exception
                                                      {
                                                 	 try
                                                      {
                                                              Thread.sleep(5000);
                                                              WebElement WatchListResult = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("WatchListResults")));
                                                              if (!WatchListResult.isDisplayed())
                                                              {
                                                            	  nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                                                            	  WatchListResult1 = WatchListResult.getAttribute("name");
                                                            	  System.out.println("Below is the Watch List Results");
                                                            	  System.out.println(WatchListResult1);                          
                                                            	  Thread.sleep(2000); 
                                                              }
                                                      }
                                                            	 
                                                            	catch(Exception e)
                                                             {
                                                                    System.out.println("Watch List Result is not Present");                        
                                                                    CaptureScreenshot("TC_Fail_");                         
                                                                    //ClickSignOut();
                                                                    Close_App_HPE();
                                   	                             Thread.sleep(2000);
                                                                    Assert.fail("Watch List Result is not Present");
                                                             }
                                                             	 
                                                         
                                                              }
                                                  
                                                //Method to verify the Watch list results on the WatchList Page for iOS
                                                  public static void VerifyWatchListResults_AN() throws Exception
                                                      {
                                                	  /*
                                                 	 try
                                                      {
                                                              Thread.sleep(5000);
                                                              WebElement WatchListResult = nativedriver.findElement(By.xpath(Android_Objects.getProperty("WatchListResults")));
                                                              System.out.println("Found Watch List Results");
                                                            	  nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                                                            	  WatchListResult1 = WatchListResult.getAttribute("contentDesc");
                                                            	  System.out.println("Below is the Watch List Results");
                                                            	  System.out.println(WatchListResult1);                          
                                                            	  Thread.sleep(2000); 
                                                              
                                                      }
                                                            	 
                                                            	catch(Exception e)
                                                             {
                                                                    System.out.println("Watch List Result is not Present");                        
                                                                    CaptureScreenshot("TC_Fail_");                         
                                                                    ClickSignOut();
                                                                    //Close_App();
                                                                    Assert.fail("Watch List Result is not Present");
                                                             }
                                                             	 
                                                         */
                                                	  
                                                	  HPECommonFunctions.Find_Text(config.getProperty("Results"));
                                                        
                                               }
                                                  
                                                  // Method to verify the Watch list results 

                                                  public static void VerifyWatchListResults() throws Exception
                                                          {
                                                            if(Device_Model.contains("iPhone"))
                                                              {
                                                            	VerifyWatchListResults_iOS();
                                                             }else 
                                                             {
                                                            	 VerifyWatchListResults_AN();
                                                             }
                                                         }
              
                                                  
                                                  
                                                  public static void VerifySearchIconHighlight(String imagePath) throws Exception
                                                  {	try {
                                                  			
                                                  			visualdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                                                  			//WebElement Remove = visualdriver.findElement(ByMobile.image(imagePath));
                                                  			WebElement MenuBar = visualdriver.findElement(ByMobile.image(imagePath));					
                                                  			testLog.info("\n Image found is : " + imagePath);
                                                  			testLog.info("Search Icon is Highlighted");
                                                  		} catch (Exception e) {
                                                  			testLog.info("\nImage not present : " + imagePath);	
                                                  			testLog.info("Search Icon is not Highlighted");
                                                  			status1 = 1;
                                                  			
                                                  			CaptureScreenshot("TC_Fail_");				
                                                  			//ClickSignOut();
                                                  			Close_App_HPE();
                           	                             Thread.sleep(2000);
                                                  			Assert.fail("Search Icon is not Highlighted");

                                                  		}
                                                  	} 
                                                  
                                                  // Method to Verify search icon highlighted

                                                  public static void VerifySearchIconHighlight() throws Exception
                                                          {
                                                            if(Device_Model.equals("iPhone-7"))
                                                              {
                                                                	VerifySearchIconHighlight("C://HPE//FunctionalTesting//Images//Footer_Search" +".png");
                                                             }else if(Device_Model.equals("iPhone-5S"))
                                                             {
                                                             	VerifySearchIconHighlight("C://HPE//FunctionalTesting//Images//Footer_Search_iPhone5S" +".png");
                                                          }else if(Device_Model.contains("Pixel"))
                                                             {
                                                               		VerifySearchIconHighlight("C://HPE//FunctionalTesting//Images//Footer_Search_Pixel" +".png");
                                                             } else if(Device_Model.contains("Galaxy S6"))
                                                             {
                                                            	 VerifySearchIconHighlight("C://HPE//FunctionalTesting//Images//Footer_Search_Galaxy" +".png");
                                                             } else if(Device_Model.contains("Galaxy S7"))
                                                             {
                                                            	 VerifySearchIconHighlight("C://HPE//FunctionalTesting//Images//Footer_Search_GalaxyS7" +".png");
                                                             }else if(Device_Model.equals("iPhone-6S"))
                                                             {
                                                             	VerifySearchIconHighlight("C://HPE//FunctionalTesting//Images//Footer_Search" +".png");
                                                          }
                                                         }

                                                  
                                               // Method to Verify WatchList icon highlighted

                                                  public static void VerifyWatchListIconHighlighted() throws Exception
                                                          {
                                                            if(Device_Model.equals("iPhone-7"))
                                                              {
                                                            	VerifyWatchListIconHighlighted("C://HPE//FunctionalTesting//Images//Footer_Watchlist" +".png");
                                                             }else if(Device_Model.equals("iPhone-5S"))
                                                             {
                                                           	VerifyWatchListIconHighlighted("C://HPE//FunctionalTesting//Images//Footer_Watchlist_iPhone5S" +".png");
                                                            }else if(Device_Model.equals("Pixel"))
                                                             {
                                                            	 VerifyWatchListIconHighlighted("C://HPE//FunctionalTesting//Images//Footer_Watchlist_Pixel" +".png");
                                                             } else if(Device_Model.equals("Galaxy S6"))
                                                             {
                                                            	 VerifyWatchListIconHighlighted("C://HPE//FunctionalTesting//Images//Footer_Watchlist_Galaxy" +".png");
                                                             } else if(Device_Model.equals("Galaxy S7"))
                                                             {
                                                            	 VerifyWatchListIconHighlighted("C://HPE//FunctionalTesting//Images//Footer_Watchlist_GalaxyS7" +".png");
                                                             }else if(Device_Model.equals("iPhone-6S"))
                                                             {
                                                           	VerifyWatchListIconHighlighted("C://HPE//FunctionalTesting//Images//Footer_Watchlist" +".png");
                                                            }
                                                         }
                                                  
                                                  
                                                  
                                               // Method to Verify Alerts icon highlighted

                                                  public static void VerifyAlertsIconHighlighted() throws Exception
                                                          {
                                                            if(Device_Model.equals("iPhone-7"))
                                                              {
                                                            	VerifyAlertsIconHighlighted("C://HPE//FunctionalTesting//Images//Footer_Alerts" +".png");
                                                             }else if(Device_Model.equals("iPhone-5S"))
                                                             {
                                                           	VerifyAlertsIconHighlighted("C://HPE//FunctionalTesting//Images//Footer_Alerts_iPhone5S" +".png");
                                                            }else if(Device_Model.equals("iPhone-7"))
                                                            {
                                                          	VerifyAlertsIconHighlighted("C://HPE//FunctionalTesting//Images//Footer_Alerts" +".png");
                                                           }
                                                             else
                                                             {
                                                            	 VerifyAlertsIconHighlighted("C://HPE//FunctionalTesting//Images//Footer_Alerts_Pixel" +".png");
                                                             }
                                                             }
                                                         
              
                                           
                                               // Method to Verify Recent Searches icon highlighted

                                                  public static void VerifyRecentSearchesIconIconHighlighted() throws Exception
                                                          {
                                                            if(Device_Model.equals("iPhone-7"))
                                                              {
                                                            	VerifyRecentSearchesIconIconHighlighted("C://HPE//FunctionalTesting//Images//Footer_RecentSearches" +".png");
                                                             }else if(Device_Model.equals("iPhone-5S"))
                                                             {
                                                           	VerifyRecentSearchesIconIconHighlighted("C://HPE//FunctionalTesting//Images//Footer_RecentSearches_iPhone5S" +".png");
                                                            }else if(Device_Model.equals("Pixel"))
                                                             {
                                                            	 VerifyRecentSearchesIconIconHighlighted("C://HPE//FunctionalTesting//Images//Footer_RecentSearches_Pixel" +".png");
                                                             } else if(Device_Model.equals("Galaxy S6"))
                                                             {
                                                            	 VerifyRecentSearchesIconIconHighlighted("C://HPE//FunctionalTesting//Images//Footer_RecentSearches_Galaxy" +".png");
                                                             } else if(Device_Model.equals("Galaxy S7"))
                                                             {
                                                            	 VerifyRecentSearchesIconIconHighlighted("C://HPE//FunctionalTesting//Images//Footer_RecentSearches_GalaxyS7" +".png");
                                                             }else if(Device_Model.equals("iPhone-6S"))
                                                             {
                                                           	VerifyRecentSearchesIconIconHighlighted("C://HPE//FunctionalTesting//Images//Footer_RecentSearches" +".png");
                                                            }
                                                         }
              
                                                  
                                                  

                                                  public static void VerifyWatchListIconHighlighted(String imagePath) throws Exception
                                                  {	try {
                                                  			
                                                  			visualdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                                                  			//WebElement Remove = visualdriver.findElement(ByMobile.image(imagePath));
                                                  			WebElement Watchlist = visualdriver.findElement(ByMobile.image(imagePath));					
                                                  			testLog.info("\n Image found is : " + imagePath);
                                                  			testLog.info("Watch List Icon is Highlighted");
                                                  		} catch (Exception e) {
                                                  			testLog.info("\nImage not present : " + imagePath);	
                                                  			testLog.info("Watch List Icon is not Highlighted");
                                                  			status1 = 1;
                                                  			CaptureScreenshot("TC_Fail_");				
                                                  			//ClickSignOut();
                                                  			Close_App_HPE();
                           	                             Thread.sleep(2000);
                                                  			Assert.fail("Watch List Icon is not Highlighted");
                                                  		}
                                                  	} 
                                                  public static void VerifyAlertsIconHighlighted(String imagePath) throws Exception
                                                  {	try {
                                                  			
                                                  			visualdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                                                  			//WebElement Remove = visualdriver.findElement(ByMobile.image(imagePath));
                                                  			WebElement Alerts = visualdriver.findElement(ByMobile.image(imagePath));					
                                                  			testLog.info("\n Image found is : " + imagePath);
                                                  			testLog.info("Alerts Icon is Highlighted");
                                                  		} catch (Exception e) {
                                                  			testLog.info("\nImage not present : " + imagePath);	
                                                  			testLog.info("Alerts Icon is not Highlighted");
                                                  			status1 = 1;
                                             
                                                  			CaptureScreenshot("TC_Fail_");				
                                                  			//ClickSignOut();
                                                  			Close_App_HPE();
                           	                             Thread.sleep(2000);
                                                  			Assert.fail("Alerts Icon is not Highlighted");

                                                  		}
                                                  	} 
                                                  public static void VerifyRecentSearchesIconIconHighlighted(String imagePath) throws Exception
                                                  {	try {
                                                  			
                                                  			visualdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                                                  			//WebElement Remove = visualdriver.findElement(ByMobile.image(imagePath));
                                                  			WebElement RecentSearch = visualdriver.findElement(ByMobile.image(imagePath));					
                                                  			testLog.info("\n Image found is : " + imagePath);
                                                  			testLog.info("Recent Searches Icon is Highlighted");
                                                  		} catch (Exception e) {
                                                  			testLog.info("\nImage not present : " + imagePath);	
                                                  			testLog.info("Recent Searches Icon is not Highlighted");
                                                  			status1 = 1;
                                                  			
                                                  			CaptureScreenshot("TC_Fail_");				
                                                  			//ClickSignOut();
                                                  			Close_App_HPE();
                                                  			Thread.sleep(2000);
                                                  			Assert.fail("Recent Searches Icon is not Highlighted");

                                                  		}
                                                  	}
                                                  
                                               // Method to click on Advance Search for Android

                                                  
                                                  public static void ClickAdvancedSearch_AN(String imagePath) throws Exception
                                                  
                                                  {
                                                    try
                                                    {
                                                               WebElement RecentSearch = visualdriver.findElement(ByMobile.image(imagePath));                              
                                                               RecentSearch.click();
                                                               testLog.info("\n Image found is : " + imagePath);
                                                               testLog.info("Clicked Advanced Search");
                                                         } catch (Exception e) {
                                                               testLog.info("\nImage not present : " + imagePath);    
                                                               testLog.info("Advanced Searchnot present");
                                                               status1 = 1;
                                                               CaptureScreenshot("TC_Fail_");				
                                                               //ClickSignOut();
                                                               Close_App_HPE();
                              	                             	Thread.sleep(2000);
                                                               Assert.fail("Advanced Searchnot present");

                                                         }
                                               }

                                                  
                                               // Method to click on Advance Search 

                                                  public static void ClickAdvancedSearch() throws Exception
                                                                               {
                                                                                if(Device_Model.contains("iPhone"))
                                                                                {
                                                                                       ClickAdvancedSearch_iOS();
                                                                                }else  if(Device_Model.contains("Pixel"))          
                                                                                    
                                                                                {
                                                                                            ClickAdvancedSearch_AN("C://HPE//FunctionalTesting//Images//AdvanceSearchArrow"+".png");
                                                                                } else  if(Device_Model.contains("Galaxy"))
                                                                                { 
                                                                                             ClickAdvancedSearch_AN("C://HPE//FunctionalTesting//Images//AdvanceSearchArrow_Galaxy"+".png"); 
                                                                                      }

                                                                                          
                                                                               }

          // Method to Verify Terms and Condition Page
          public static void Find_Text_TandC(String linktext) throws Exception {
            try {

                 IMobileWebDriver TandC = device.getVisualDriver();
                 TandC.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);                    
                 TandC.findElement(By.linkText(linktext));
                 testLog.info("\n Element found is : " + linktext);
                 testLog.info("Terms & COnditions page is present");
                 Thread.sleep(2000);
                 SwipeUp();
                 ClickDecline();
                } catch (Exception e) {
                 testLog.info("\nElement not found : " + linktext);
                 testLog.info("Terms & Conditions page is not present");
                 status1 = 1;
                 CaptureScreenshot("TC_Fail_");				
                 Close_App_HPE();
                 Thread.sleep(2000);
                 Assert.fail("Terms & COnditions pagr is not present");

                }
     }

          //Method to verify the date format on the search result page
          public static Date DatevalidateDateFormat(String dateToValdate) throws java.text.ParseException, ParseException {
        	  try
        	  {
        	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HHmmss");
        	    //To make strict date format validation
        	    formatter.setLenient(false);
        	    
        	    parsedDate = (Date) formatter.parse(dateToValdate);
				System.out.println("++validated DATE TIME ++"+formatter.format(parsedDate));
        	   
        	  }catch(Exception e)
        	  {
        		  System.out.println("Date is not found");
        	  }
        	  return parsedDate;
        	}


          			//Method to Click on Terms & Conditions from Menu in iOS
                                    public static void ClickTermsAndConditions_iOS() throws Exception 
                                    {
                                    try
                                    {
                                      nativedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                                    WebElement TermsAndConditions = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("T&C")));
                                    if(!TermsAndConditions.isDisplayed())
                                    {      
                                      TermsAndConditions.click();
                                    System.out.println("Clicked on TermsAndConditions");
                                    Thread.sleep(10000);
                                    }
                                    }
                                    catch(Exception e)
                                    {
                                    System.out.println("TermsAndConditions button is not Present");                          
                                    CaptureScreenshot("TC_Fail_");                         
                                    //ClickSignOut1();
                                    Close_App_HPE();
   	                             Thread.sleep(2000);
                                    Assert.fail("TermsAndConditions button is not Present");
                                    }
                                 }

          
   public static void ClickTermsAndConditions_AN(String imagePath) throws Exception
   {
          
          try
          {
                              nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                              WebElement TermsAndCondition = visualdriver.findElement(ByMobile.image(imagePath));                              
                              TermsAndCondition.click();
                              testLog.info("\n Image found is : " + imagePath);
                              testLog.info("Clicked on Terms And Conditions");
                        } catch (Exception e) {
                              testLog.info("\nImage not present : " + imagePath);    
                              testLog.info("Terms And Condition Menu option is not found");
                              status1 = 1;
                              CaptureScreenshot("TC_Fail_");
                              Close_App_HPE();
	                             Thread.sleep(2000);
                              Assert.fail("Terms And Condition Menu option is not found");

                        }
            
   }

     //Method to click on Click Terms and Conditions menu option
              public static void ClickTermsAndConditions () throws Exception
                {
                 if(Device_Model.contains("iPhone"))
                 {
                        ClickTermsAndConditions_iOS();
                 }else if(Device_Model.contains("iPad"))
                 {
                        ClickTermsAndConditions_iOS();
                 }else if(Device_Model.contains("Pixel"))
                 {
                     ClickTermsAndConditions_AN("C://HPE//FunctionalTesting//Images//TermsAndConditions"+".png");
                 }else if(Device_Model.contains("Galaxy S6"))
                 {
                   ClickTermsAndConditions_AN("C://HPE//FunctionalTesting//Images//TermsAndConditions_Galaxy"+".png");
                   Thread.sleep(2000);
                 }   else if(Device_Model.contains("Galaxy S7"))
                 {
                 ClickPrivacyStatement_AN("C://HPE//FunctionalTesting//Images//PrivacyStatement_GalaxyS7"+".png");
                 }
                           
                }


              public static void ClickRecentSearchesfirstKeyword_iOS()throws Exception {
                
                try {
                       nativedriver.findElement(By.xpath(iOS_Objects.getProperty("RecentSearchesFirstKeyword")));
                Thread.sleep(2000);
                
                       System.out.println("The Order details page is diaplayed");
                } catch (Exception e) {

                       System.out.println("The Order details page is not diaplayed");                        
                      HPECommonFunctions.CaptureScreenshot("TC_Fail_");                         
                      //ClickSignOut();
                      Close_App_HPE();
                      Thread.sleep(2000);
                      Assert.fail("The Order details page is not diaplayed");
                }
                
              }
              


  public static void ClickRecentSearchesfirstKeyword_AN()throws Exception {
         
         try {
                nativedriver.findElement(By.xpath(Android_Objects.getProperty("RecentSearchesFirstKeyword")));
                Thread.sleep(2000);
                System.out.println("The Order details page is diaplayed");
         } catch (Exception e) {

                System.out.println("The Order details page is not diaplayed");                        
                HPECommonFunctions.CaptureScreenshot("TC_Fail_");                         
                //ClickSignOut();
                Close_App_HPE();
                Thread.sleep(2000);
                Assert.fail("The Order details page is not diaplayed");
         }
         
  }

              
              
  public static void ClickRecentSearchesfirstKeyword() throws Exception
  {
         if(Device_Model.contains("iPhone"))
  {
            ClickRecentSearchesfirstKeyword_iOS();
  } else
  {
         ClickRecentSearchesfirstKeyword_AN();
                                            }
  }
  
  public static void ClickOnShipStartDateCalender_iOS() throws Exception{
      nativedriver.findElement(By.xpath(iOS_Objects.getProperty("ShipStartDateCalender"))).click();
      System.out.println("Clicked on Calendar");
     Thread.sleep(10000);
 }

 public static void ClickOnShipStartDateCalender() throws Exception
 {
  if(Device_Model.contains("iPhone"))
  {
  ClickOnShipStartDateCalender_iOS();
  }else                

{
  //ClickOnShipStartDateCalender_AN();
  }
            
 }
 
 



// Method to click on Ship Date range - End
 public static void ClickOnShipEndDateCalender_AN() throws Exception
                      {      
 device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("1016,901")));
 System.out.println("Clicked on Calendar");
 Thread.sleep(10000);                     
                      }
 public static void ClickOnShipEndDateCalender_iOS() throws Exception{
      nativedriver.findElement(By.xpath(iOS_Objects.getProperty("ShipEndDateCalender"))).click();
    
      Thread.sleep(2000);
      
 }
 
 public static void ClickOnShipEndDateCalender() throws Exception
 {
  if(Device_Model.contains("iPhone"))
  {
  ClickOnShipEndDateCalender_iOS();
  }else                

{
   ClickOnShipEndDateCalender_AN();
  }
            
 }
 
 public static void SecondOrderClick() throws Exception
 {
        if(Device_Model.contains("iPhone"))
        {
              SecondOrderClick_iOS();
        }else {
              firstOrderClick_AN();
        }
 }
 
 public static void ClickOnKeypadGoButton() throws Exception
 {
       if(Device_Model.contains("Pixel"))
       {
              ClickOnKeypadGoButton_AN("C://HPE//FunctionalTesting//Images//KeypadGoicon_Pixel"+".png");
       } else if(Device_Model.contains("iPhone"))
       {
    	   System.out.println("No need to close the keypad in iphone");
       }else 
       {
           ClickOnKeypadGoButton_AN("C://HPE//FunctionalTesting//Images//KeypadGoicon_Galaxy"+".png");
    }
 }

	
 public static void ClickDone_iOS()throws Exception {
     
     try {
    	 WebElement Done = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Done")));
    	 Thread.sleep(2000);
    	 Done.click();
            System.out.println("Clicked on Done");
            Thread.sleep(5000);
     } catch (Exception e) {

            System.out.println("Done is not diaplayed");                        
           HPECommonFunctions.CaptureScreenshot("TC_Fail_");                         
           //ClickSignOut();
           Close_App_HPE();
           Thread.sleep(2000);
           Assert.fail("Done is not diaplayed");
     }
     
   }
   
 

	// Method to click on Ship Date range - Start
    public static void ClickOnDateOrdered() throws Exception
                         { 
    	if(Device_Model.contains("iPhone"))
        {
    		
        	ClickOnDateOrderedCalendar_iOS();
        }else
        {
        	device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("490,774")));
        	System.out.println("Clicked on Date Ordered Calendar, Start");
        	Thread.sleep(10000);                  
        }
     }

    public static void ClickOnEstimatedShipDateCalendar() throws Exception
    {
     if(Device_Model.contains("iPhone"))
     {
     ClickOnDeliveryStartDateCalendar_iOS();
     }else                
  
{
     ClickOnEstimatedShipDate_AN();
     }
               
    }
    
 // Method to click on Delivery Date range - Start
    public static void ClickOnEstimatedShipDate_AN() throws Exception
                         {      
    device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("481,1002")));
    System.out.println("Clicked on Calendar");
    Thread.sleep(10000);                  
    }
    
    public static void ClickOnEstimatedEndDateCalendar() throws Exception
    {
     if(Device_Model.contains("iPhone"))
     {
     ClickOnDeliveryEndDateCalendar_iOS();
     }else                
  
{
     	ClickOnEstimatedEndDateCalendar_AN();
     }
               
    }


 // Method to click on Delivery Date range - End
    public static void ClickOnEstimatedEndDateCalendar_AN() throws Exception
                         {      
    device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("1019,988")));
    System.out.println("Clicked on Calendar");
    Thread.sleep(10000);                     
                         }


    // Method to click on Ship Date range - End
    public static void ClickOnDateOrderedEnd() throws Exception
   {     
    	
    	if(Device_Model.contains("iPhone"))
        {
    		
        	ClickOnDateOrderedEndCalendar_iOS();
        }else
        {
    device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("1032,778")));
    System.out.println("Clicked on Calendar");
    Thread.sleep(10000);                     
       }
   }

    
    public static void ClickOnDateOrderedEndCalendar_iOS() throws Exception
    {
         nativedriver.findElement(By.xpath(iOS_Objects.getProperty("OrderEndCalender"))).click();
         System.out.println("Clicked on Calendar");
        Thread.sleep(2000); 
        }
    
    
    public static void ClickonDateOrderedStartDate() throws Exception
    {
     if(Device_Model.contains("iPhone"))
     {
     ClickonShippingStartDate_iOS();
     }else                
  
{
     ClickonShippingStartDate_AN();
     }
               
    }

    
  //Method to click on Date field, Start


    public static void NinetyDayValidationStart_AN(String PastDate) throws Exception

                        {
                               try
                                     {
   WebElement PastDateCheck = nativedriver.findElement(By.xpath(Android_Objects.getProperty("DateOrderedStart")));
                        Thread.sleep(5000);
                        PastDateCheck.click();
                        Thread.sleep(5000);
                        PastDateCheck.sendKeys(PastDate);
                        System.out.println("Date Entered in Date ordered start field");
                        Thread.sleep(2000);
                                     }
                               catch (Exception e)
                               {
                               	System.out.println("Date not entered");
                               	CaptureScreenshot("TC_Fail_");           
                                   //ClickSignOut();
                                   Close_App_HPE();
   	                             Thread.sleep(2000);
                                   Assert.fail("Date not entered");
                               }
                        }

   //Method to click on Date field, End


   public static void NinetyDayValidationEnd_AN(String FutureDate) throws Exception

                       {
                              try
                                    {
   WebElement FutureDateCheck = nativedriver.findElement(By.xpath(Android_Objects.getProperty("DateOrderedEnd")));
                       Thread.sleep(5000);
                       FutureDateCheck.click();
                       Thread.sleep(5000);
                       FutureDateCheck.sendKeys(FutureDate);
                       System.out.println("Date Entered in Date ordered End field");
                       Thread.sleep(2000);
                                    }
                              catch (Exception e)
                              {
                              	System.out.println("Date not entered");
                              	CaptureScreenshot("TC_Fail_");           
                                  //ClickSignOut();
                                  Close_App_HPE();
   	                             Thread.sleep(2000);
                                  Assert.fail("Date not entered");
                              }
                       }


   //Method to click on Date field, Start


   public static void NinetyDayValidationForShipStart_AN(String PastDate) throws Exception

                      {
                             try
                                   {
   WebElement PastDateCheck = nativedriver.findElement(By.xpath(Android_Objects.getProperty("ShipStartDate")));
                      Thread.sleep(5000);
                      PastDateCheck.click();
                      Thread.sleep(5000);
                      PastDateCheck.sendKeys(PastDate);
                      System.out.println("Date Entered in Shippment start field");
                      Thread.sleep(2000);
                                   }
                             catch (Exception e)
                             {
                             	System.out.println("Date not entered");
                             	CaptureScreenshot("TC_Fail_");           
                                 //ClickSignOut();
                                 Close_App_HPE();
   	                             Thread.sleep(2000);
                                 Assert.fail("Date not entered");
                             }
                      }

   //Method to click on Date field, End


   public static void NinetyDayValidationForShipEnd_AN(String FutureDate) throws Exception

                     {
                            try
                                  {
   WebElement FutureDateCheck = nativedriver.findElement(By.xpath(Android_Objects.getProperty("ShipEndDate")));
                     Thread.sleep(5000);
                     FutureDateCheck.click();
                     Thread.sleep(5000);
                     FutureDateCheck.sendKeys(FutureDate);
                     System.out.println("Date Entered in Shipment end field");
                     Thread.sleep(2000);
                                  }
                            catch (Exception e)
                            {
                            	System.out.println("Date not entered");
                            	CaptureScreenshot("TC_Fail_");           
                                //ClickSignOut();
                                Close_App_HPE();
   	                             Thread.sleep(2000);
                                Assert.fail("Date not entered");
                            }
                     }

   public static void NinetyDayValidationStart_iOS(String PastDate) throws Exception

   {
          try
                {
WebElement PastDateCheck = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("DateOrderedStart")));
   Thread.sleep(5000);
   PastDateCheck.click();
   Thread.sleep(5000);
   PastDateCheck.sendKeys(PastDate);
   System.out.println("Date Entered in Date ordered start field");
   Thread.sleep(2000);
                }
          catch (Exception e)
          {
          	System.out.println("Date not entered");
          	CaptureScreenshot("TC_Fail_");           
              //ClickSignOut();
              Close_App_HPE();
               Thread.sleep(2000);
              Assert.fail("Date not entered");
          }
   }

//Method to click on Date field, End


public static void NinetyDayValidationEnd_iOS(String FutureDate) throws Exception

  {
         try
               {
WebElement FutureDateCheck = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("DateOrderedEnd")));
  Thread.sleep(5000);
  FutureDateCheck.click();
  Thread.sleep(5000);
  FutureDateCheck.sendKeys(FutureDate);
  System.out.println("Date Entered in Date ordered End field");
  Thread.sleep(2000);
               }
         catch (Exception e)
         {
         	System.out.println("Date not entered");
         	CaptureScreenshot("TC_Fail_");           
             //ClickSignOut();
             Close_App_HPE();
               Thread.sleep(2000);
             Assert.fail("Date not entered");
         }
  }


//Method to click on Date field, Start


public static void NinetyDayValidationForShipStart_iOS(String PastDate) throws Exception

 {
        try
              {
WebElement PastDateCheck = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("ShipCompleteStart")));
 Thread.sleep(5000);
 PastDateCheck.click();
 Thread.sleep(5000);
 PastDateCheck.sendKeys(PastDate);
 System.out.println("Date Entered in Shippment start field");
 Thread.sleep(2000);
              }
        catch (Exception e)
        {
        	System.out.println("Date not entered");
        	CaptureScreenshot("TC_Fail_");           
            //ClickSignOut();
            Close_App_HPE();
               Thread.sleep(2000);
            Assert.fail("Date not entered");
        }
 }

//Method to click on Date field, End


public static void NinetyDayValidationForShipEnd_iOS(String FutureDate) throws Exception

{
       try
             {
WebElement FutureDateCheck = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("ShipCompleteEnd")));
Thread.sleep(5000);
FutureDateCheck.click();
Thread.sleep(5000);
FutureDateCheck.sendKeys(FutureDate);
System.out.println("Date Entered in Shipment end field");
Thread.sleep(2000);
             }
       catch (Exception e)
       {
       	System.out.println("Date not entered");
       	CaptureScreenshot("TC_Fail_");           
           //ClickSignOut();
           Close_App_HPE();
               Thread.sleep(2000);
           Assert.fail("Date not entered");
       }
}



public static void NinetyDayValidationStart() throws Exception
  {
	if(Device_Model.contains("iPhone"))
	{

		NinetyDayValidationStart_iOS(config.getProperty("PastDate"));
	}else
	{
		NinetyDayValidationStart_AN(config.getProperty("PastDate"));
	}
	          
  } 

public static void NinetyDayValidationEnd() throws Exception
{
	if(Device_Model.contains("iPhone"))
	{
	
		NinetyDayValidationEnd_iOS(config.getProperty("FutureDate"));
	}else
	{
		NinetyDayValidationEnd_AN(config.getProperty("FutureDate"));
	}
	          
} 

public static void NinetyDayValidationForShipStart() throws Exception
{
	if(Device_Model.contains("iPhone"))
	{
	
		NinetyDayValidationForShipStart_iOS(config.getProperty("PastDate"));
	}else
	{
		NinetyDayValidationForShipStart_AN(config.getProperty("PastDate"));
	}
	          
} 

public static void NinetyDayValidationForShipEnd() throws Exception
{
	if(Device_Model.contains("iPhone"))
	{

		NinetyDayValidationForShipEnd_iOS(config.getProperty("FutureDate"));
	}else
	{
		NinetyDayValidationForShipEnd_AN(config.getProperty("FutureDate"));
	}
	          
} 




/*//change orientation to landscape from portrait
 public static void Rotate_Device() throws Exception
 {
       Thread.sleep(5000);           
                         try{
             
             Orient=device.getOrientation();
             System.out.println("Device Orientation is in  ");
             System.out.println(Orient); 
                                     
               if (Orient.value().equals(ScreenOrientation.LANDSCAPE.value()))
                 //if (Orient.value().equals(ScreenOrientation.PORTRAIT.value()))
                               
       {
             Thread.sleep(5000);
             System.out.println("Device is already in Landscape mode");
                               
       }
             else
             {
                   System.out.println("Device Orientation will be changed to Landscape mode1");
                   device.rotate(Landscape);
             }
       }
       catch(Exception e)
       {
             System.out.println("Device Orientation will be changed to Landscape mode");
             device.rotate(Landscape);
       
       }
 }*/

  
  
  }

                              




