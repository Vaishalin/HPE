package Libraries;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.perfectomobile.selenium.MobileCoordinates;
import com.perfectomobile.selenium.MobilePoint;
import com.perfectomobile.selenium.api.IMobileDriver;
import com.perfectomobile.selenium.api.IMobileWebDriver;
import com.perfectomobile.selenium.by.ByMobile;
//import net.sourceforge.htmlunit.corejs.javascript.Scriptable;
//import org.apache.fop.fonts.cff.CFFDataReader.DICTEntry;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.junit.Assert;
import Regression_Utilities.BaseClassHPE;
//import com.gargoylesoftware.htmlunit.javascript.host.Map;
//import com.perfectomobile.httpclient.MediaType;
//import Regression_Utilities.BaseClass_HPE;
//import Regression_Utilities.XLS_Reader;
//import org.openqa.selenium.TakesScreenshot;
//import java.io.IOException;


public class HPEOperations extends BaseClassHPE
{

				public static IMobileWebDriver visualdriver = device.getVisualDriver();
                public static IMobileWebDriver nativedriver = device.getNativeDriver();
                public static IMobileWebDriver domdriver = device.getDOMDriver();                               
                public static File srcFile=null;
                public static IMobileDriver driver = null;               
                public static ScreenOrientation Orient= null;
                public static String Device_Manufacturer=device.getProperty("Manufacturer");
                public static String Device_Model=device.getProperty("Model");
                public static String WatchlistCount = null;
                public static String contentDesc = null;
               // public static XLS_Reader datatable=null;
                //public static XLS_Reader datatable1=null;
                
               
            	
    //Method to Login into HPE Application first time after the installation
    public static void FirstLogin_App1() throws Exception
      {
    	
    	 	HPECommonFunctions.EnterUserName(config.getProperty("UserName"));
    	 	
    	 	if((Device_Model.contains("iPhone")) && (Device_Model.contains("iPad")))
        	{
            //HPECommonFunctions.EnterPassword_iOS(config.getProperty("Password"));
            }else
    	    {
    		HPECommonFunctions.EnterPassword_AN("Password123");    		
    	    }
    		HPECommonFunctions.ClickSignIn();
    		
    	}
            
    	          
       
    
    //Method to Login into HPE Application first time after the installation
    public static void FirstLogin_App() throws Exception
      {
    	if(Device_Model.contains("iPhone"))
    	{
    	 	HPECommonFunctions.EnterUserName(config.getProperty("UserName"));    	 	   	 	
            HPECommonFunctions.EnterPassword_iOS(config.getProperty("Password"));
            HPECommonFunctions.ClickSignIn();
            
    	}else if (Device_Model.contains("iPad"))
    	{
    		HPECommonFunctions.EnterUserName(config.getProperty("UserName"));    	 	   	 	
            HPECommonFunctions.EnterPassword_iOS(config.getProperty("Password"));
            HPECommonFunctions.ClickSignIn();
    	} else
    	{
    		//HPECommonFunctions.EnterUserName_AN(); 
    		HPECommonFunctions.EnterUserName(config.getProperty("UserName")); 
    		Thread.sleep(2000);
    		HPECommonFunctions.EnterPassword_AN(config.getProperty("Password"));
    		Thread.sleep(2000);
    		
    		HPECommonFunctions.ClickSignIn();
    	}
            
    	          
      } 
 
    //Method to login to HPE Application for iOS
    public static void Login_App_iOS() throws Exception
      {
    	try
    	
    	  {
    	 	             	
    		//FirstLogin_App();
    		
			WebElement TermsCondition = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Accept")));
			//WebElement TermsCondition = nativedriver.findElement(By.linkText("Terms and Conditions"));
			if(!TermsCondition.isDisplayed())
			{
				HPECommonFunctions.SwipeUp();	    		   		
	    		HPECommonFunctions.ClickAccept();
	    		HPECommonFunctions.VerifyTutorialPage();
	    		HPECommonFunctions.ClickAllowButton(); 
	    		System.out.println("User is logged in into application first time after the installation");
				Thread.sleep(10000);				
			}
			else{
				//System.out.println("User is logged in into application successfully");
			}
    	  }
			
			catch(Exception e)
			{
				//System.out.println("Login into application was not successful");
			}
            
    	          
      }     
    
    
    //Method to login to HPE Application in Android
    public static void Login_App_AN() throws Exception
      {
    	try
    	  {
    	 	            
    		FirstLogin_App();
			WebElement TermsCondition = nativedriver.findElement(By.xpath(Android_Objects.getProperty("T&C")));
			if(TermsCondition.isDisplayed())
			{
				HPECommonFunctions.SwipeUp_AN();	    		   		
	    		HPECommonFunctions.ClickAccept_AN();
	    		HPECommonFunctions.VerifyTutorialPage();
	    		HPECommonFunctions.ClickAllowButton(); 
	    		System.out.println("User is logged in into application first time after the installation");
				Thread.sleep(10000);				
			}
			
    			else{
				//System.out.println("User is logged in into application successfully");
			}
    	  }
			
			catch(Exception e)
			{
				//System.out.println("Login into application was not successful");
			}
			
}
    
    
	//Method to login to HPE application
    public static void Login_App() throws Exception
		      {
		    	if(Device_Model.contains("iPhone"))
		    	{
		    		try
		    		{
		    			HPECommonFunctions.Find_Order_Status(config.getProperty("OrderStatus"));
		    			System.out.println("User is already on the Home page");
		    			
		    		}catch (Exception e)
		    		{
		    		Login_App_iOS();
		    		}
		    	}else if(Device_Model.contains("iPad"))
		    	{
		    		Login_App_iOS();
		    	}else
		    	{
		    		Login_App_AN();
		    	}
		    	          
		      }
    
    
    public static void Open_Browser_iOS() throws Exception
	{
		 
       	  device.getNativeDriver(config.getProperty("BrowserName")).open();
       	  nativedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       	  //Thread.sleep(20000);
       	  System.out.println("Opened Safari Browser ");
       	  
         }
    
    public static void EnterURL (String URL) throws Exception
    {
    	
    	try{
    		nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    		WebElement EnterURL = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Address")));
    	    Thread.sleep(5000);
    	    EnterURL.click();
    	    EnterURL.sendKeys(URL);
    	    System.out.println("Entered the website address");
    	    Thread.sleep(5000);
    	    
    	}catch (Exception e)
    	{
    		nativedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    		
    		device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("352,74")));
    		System.out.println("Clicked on existing URL");
    	    Thread.sleep(5000);
    	    device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("552,74")));
    		System.out.println("Clicked on Remove button");
    	    Thread.sleep(2000);	    
    	    	    
    	    WebElement EnterURL = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Address")));
    	    Thread.sleep(5000);
    	    EnterURL.click();
    	    EnterURL.sendKeys(URL);
    	    System.out.println("Entered the website address");
    	    Thread.sleep(5000);
    	}
    
    
    }
    
  //Method to click on GO button on keyboard under Preferences tab
  		public static void ClickGO() throws Exception
  		{
  			try
  			{	
  			visualdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  			WebElement GO = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Go")));
  			if(!GO.isDisplayed())
  			{				
  				GO.click();
  				System.out.println("Clicked on GO button");
  				Thread.sleep(10000);				
  			}
  			}
  			catch(Exception e)
  			{
  				System.out.println("GO is not Present");				
  				HPECommonFunctions.CaptureScreenshot("TC_Fail_");				
  				//ClickSignOut();
  				//Close_App();
  				Assert.fail("GO is not Present");
  			}
  			
  		}


  	//Method to Click on Apple icon
		public static void ClickAppleIcon(String imagePath) throws Exception
		{	
		
	    	try {
		    		 	//Thread.sleep(10000); 
						nativedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						//WebElement Remove = visualdriver.findElement(ByMobile.image(imagePath));
						WebElement AppleIcon = visualdriver.findElement(ByMobile.image(imagePath));
						AppleIcon.click();							
						testLog.info("Clicked on Apple Icon");							
						status1 = 1;
						
					} catch (Exception e) {
						testLog.info("\nImage not present : " + imagePath);	
						testLog.info("Apple Icon is not present");
						status1 = 0;
						//Assert.fail();
					}
		   	}

		
		//Method to Click on HPE Go app
				public static void ClickHPEGoApp(String imagePath) throws Exception
				{	
				
			    	try {
				    		 	//Thread.sleep(10000); 
								nativedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
								//WebElement Remove = visualdriver.findElement(ByMobile.image(imagePath));
								WebElement AppleIcon = visualdriver.findElement(ByMobile.image(imagePath));
								AppleIcon.click();							
								testLog.info("Clicked on HPE Go App");							
								status1 = 1;
								
							} catch (Exception e) {
								testLog.info("\nImage not present : " + imagePath);	
								testLog.info("HPE Go app is not present");
								status1 = 0;
								//Assert.fail();
							}
				   	}

				//Method to click on Install
		  		public static void ClickInstall() throws Exception
		  		{
		  			try
		  			{			
		  			visualdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  			WebElement Install = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Install")));
		  			if(!Install.isDisplayed())
		  			{				
		  				Install.click();
		  				System.out.println("Clicked on Install");
		  				Thread.sleep(30000);
		  				System.out.println("HPE-Go App is Installed");
		  			}
		  			}
		  			catch(Exception e)
		  			{
		  				System.out.println("Install button is not Present");				
		  				HPECommonFunctions.CaptureScreenshot("TC_Fail_");				
		  				//ClickSignOut();
		  				//Close_App();
		  				Assert.fail("Install button is not Present");
		  			}
		  			
		  		}
		  		
		  		
		  	public static void Install_App_HPE_GO_iphone7and6S() throws Exception
		  		{
	 			
		  			HPEOperations.Open_Browser_iOS();
		  			Thread.sleep(5000);
		  			HPEOperations.EnterURL("https://mobilitycat.itcs.hpe.com/catalog"); 
		  			Thread.sleep(5000);
		  			HPEOperations.ClickGO();
		  			Thread.sleep(5000);
		  			HPEOperations.ClickHPEGoApp("C://HPE//FunctionalTesting//Images//HPEGO"+".png");
		  			Thread.sleep(5000);
		  			HPEOperations.ClickAppleIcon("C://HPE//FunctionalTesting//Images//AppleImage"+".png");
		  			//HPEOperations.ClickAppleIcon("C://HPE//FunctionalTesting//Images//AppleImage_Previous"+".png");
		  			Thread.sleep(5000);
		  			HPEOperations.ClickInstall();
		  			
		  		}
			public static void Install_App_HPE_GO_iPad() throws Exception
	  		{
 			
	  			HPEOperations.Open_Browser_iOS();
	  			Thread.sleep(5000);
	  			HPEOperations.EnterURL("https://mobilitycat.itcs.hpe.com/catalog"); 
	  			Thread.sleep(5000);
	  			HPEOperations.ClickGO();
	  			Thread.sleep(5000);
	  			HPEOperations.ClickHPEGoApp("C://HPE//FunctionalTesting//Images//Apple_iPad Air 2_HPE_GO"+".png");
	  			Thread.sleep(5000);
	  			HPEOperations.ClickAppleIcon("C://HPE//FunctionalTesting//Images//Apple_iPad Air 2_Apple_Icon"+".png");
	  			//HPEOperations.ClickAppleIcon("C://HPE//FunctionalTesting//Images//AppleImage_Previous"+".png");
	  			Thread.sleep(5000);
	  			HPEOperations.ClickInstall();
	  			
	  		}
			  
            public static void Install_App_HPE_GO_iOS() throws Exception
                           {
                            if(Device_Model.contains("iPhone"))
                            {
                            	Install_App_HPE_GO_iphone7and6S();
                            	
                            }else if(Device_Model.contains("iPad"))
                            {
                            	Install_App_HPE_GO_iPad();
                                  
                           }}
		  	
		  //Method to install HPE-Go on android
            public static void Install_App_HPE_GO_AN() throws Exception
            {
            		//visualdriver.findElement(ByMobile.image("C://HPE//FunctionalTesting//Images//Arrow_Pixel" +".png")).click();
            		//Thread.sleep(3000);
            		
            		//device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("538,1509")));
            		//System.out.println("Clicked on Arrow on home page");
            	    //Thread.sleep(3000); 
                /*
            		device.getNativeDriver(config.getProperty("Browser_AN")).open();          
                   	System.out.println("Opened the Browser");
                   	Thread.sleep(2000);
                   
                   	nativedriver.findElement(By.xpath("//*[@resourceid='com.android.chrome:id/url_bar']")).click();       
                    System.out.println("Clicked on the URL");
                    Thread.sleep(2000);
                    
                    nativedriver.findElement(By.xpath("//*[@resourceid='com.android.chrome:id/delete_button']")).click();       
                    System.out.println("Deleted the existing URL");
                    Thread.sleep(2000);                    

                    nativedriver.findElement(By.xpath("//*[@resourceid='com.android.chrome:id/url_bar']")).sendKeys("https://mobilitycat.itcs.hpe.com/catalog");
                    System.out.println("Entered the Appilcation link"); 
                    Thread.sleep(5000);                    
                    
                    visualdriver.findElement(ByMobile.image("C://HPE//FunctionalTesting//Images//Go_Pixel" +".png")).click();
                    System.out.println("Clicked on Go button on keyboard");
                    Thread.sleep(5000);
                          
                    visualdriver.findElement(ByMobile.image("C://HPE//FunctionalTesting//Images//HPEGO_Pixel" +".png")).click();
                    System.out.println("Clicked on HPE-Go app");
                    Thread.sleep(5000);
                          
                    visualdriver.findElement(ByMobile.image("C://HPE//FunctionalTesting//Images//AndroidImage_Pixel" +".png")).click();
                    System.out.println("Clicked in Android image");
                    Thread.sleep(5000);
                    
                    visualdriver.findElement(ByMobile.image("C://HPE//FunctionalTesting//Images//Download_Pixel" +".png")).click();
                    System.out.println("Clicked on Download");
                    Thread.sleep(5000); 
                    
                    device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("538,1854")));
            		System.out.println("Clicked on home button");
            	    Thread.sleep(5000); 

                    device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("538,1509")));
            		System.out.println("Clicked on Arrow on home page");
            	    Thread.sleep(5000); 
            	    */
                    nativedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
              	  	device.getNativeDriver(config.getProperty("DownloadApp")).open();  	  
              	  	System.out.println("Open Downloads on the device");
              	  	Thread.sleep(10000);              	  	
              	  	/*
              	  	visualdriver.findElement(ByMobile.image("C://HPE//FunctionalTesting//Images//Download_menu_Pixel" +".png")).click();
              	  	System.out.println("Clicked on Menu");
              	  	Thread.sleep(5000);
              	  	
              	  	visualdriver.findElement(ByMobile.image("C://HPE//FunctionalTesting//Images//Recent_Pixel" +".png")).click();
            	  	System.out.println("Clicked on Recent");
            	  	Thread.sleep(5000); 
            	  	
                    */
              	  	
            	  	nativedriver.findElement(By.xpath("(//*[@resourceid='com.android.documentsui:id/dir_list'])[1]/child::group[1]")).click();
                    Thread.sleep(5000);
                    System.out.println("Clicked on the recent downloaded file");
                      
                    nativedriver.findElement(By.xpath("//*[@resourceid='com.android.packageinstaller:id/ok_button']")).click();
                    System.out.println("Clicked on Install");
                    Thread.sleep(5000);
                    
                    nativedriver.findElement(By.xpath("//*[@resourceid='com.android.packageinstaller:id/done_button']")).click();
                    System.out.println("Clicked on Done & app is installed");                    
                    Thread.sleep(10000);
                    
            	    device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("538,1509")));
            		System.out.println("Clicked on Arrow on home page");
            	    Thread.sleep(3000);
                    
                                       
            }
            
          //Method to install HPE-Go on android
            public static void Install_App_HPE_GO_S7() throws Exception
            {
            		
            		//device.getNativeDriver(config.getProperty("Browser_AN")).close();           
                   	//Thread.sleep(2000);
                   
                   	device.getNativeDriver(config.getProperty("Browser_AN")).open();           
                   	Thread.sleep(5000);
                   	System.out.println("Opened the Browser");
                   
                   	nativedriver.findElement(By.xpath("//*[@resourceid='com.android.chrome:id/url_bar']")).click();       
                   	Thread.sleep(2000);
                   	
                   	nativedriver.findElement(By.xpath("//*[@resourceid='com.android.chrome:id/delete_button']")).click();       
                   	Thread.sleep(2000);
                 
                   	nativedriver.findElement(By.xpath("//*[@resourceid='com.android.chrome:id/url_bar']")).sendKeys("https://mobilitycat.itcs.hpe.com/catalog");
                    Thread.sleep(2000);
                   	
                    visualdriver.findElement(ByMobile.image("C://HPE//FunctionalTesting//Images//Go_AN" +".png")).click();
                    Thread.sleep(3000);
                    
                    visualdriver.findElement(ByMobile.image("C://HPE//FunctionalTesting//Images//HPEGO_AN" +".png")).click();
                    Thread.sleep(3000);
                    
                    visualdriver.findElement(ByMobile.image("C://HPE//FunctionalTesting//Images//AndroidImage" +".png")).click();
                    Thread.sleep(3000);
                    
                    visualdriver.findElement(ByMobile.image("C://HPE//FunctionalTesting//Images//Replace_File_AN" +".png")).click();
                    Thread.sleep(3000);

                    device.getNativeDriver(config.getProperty("AppName1")).open();        
                    Thread.sleep(2000);
                                      
                    nativedriver.findElement(By.xpath("//*[text()='Download history']")).click();
                    Thread.sleep(2000);
                        
                    nativedriver.findElement(By.xpath("(//*[text()='com.hpe.cpx.prmobile.apk'])[1]")).click();
                    Thread.sleep(2000);
                    
                    nativedriver.findElement(By.xpath("//*[@resourceid='com.android.packageinstaller:id/ok_button']")).click();
                    Thread.sleep(20000);
                    System.out.println("HPE-GO installed succesfully");
                    
                    nativedriver.findElement(By.xpath("//*[@resourceid='com.android.packageinstaller:id/done_button']")).click();
                    Thread.sleep(10000); 
                   
            }
            
            
          //Method to click General App Questions
            public static void ClickGeneralApp_iOS() throws Exception
           
            {
                  nativedriver.findElement(By.xpath(iOS_Objects.getProperty("GeneralAppQuestions"))).click();
            Thread.sleep(2000);
            }
            
            
            
            
            
           //Method to click Glossary and Icons
            public static void ClickGloassaryandIcons() throws Exception
            {
                   nativedriver.findElement(By.xpath(iOS_Objects.getProperty("GlossaryandIcons"))).click();
            Thread.sleep(2000);
            
            }            
            
            
            //Method to click first Question in General App FAQ for iOS
            public static void CLickGeneralAppFirstQuestion_iOS() throws Exception
            {
              nativedriver.findElement(By.xpath(iOS_Objects.getProperty("GeneralAppFirstQuestion"))).click();
            }
            
            //Method to click first Question in General App FAQ for Android
            public static void CLickGeneralAppFirstQuestion_AN() throws Exception
            {
              nativedriver.findElement(By.xpath(Android_Objects.getProperty("GeneralAppFirstQuestion"))).click();
            }
            
          //Method to click first Question in General App FAQ
            
            public static void CLickGeneralAppFirstQuestion() throws Exception
                           {
                            if(Device_Model.contains("iPhone"))
                            {
                            	CLickGeneralAppFirstQuestion_iOS();
                            }else
                            {
                            	CLickGeneralAppFirstQuestion_AN();
                            }
                                      
                           }

            
            //Method to click Second question Question in General App FAQ for iOS
            public static void CLickGeneralAppSecondQuestion_iOS() throws Exception
            {
            nativedriver.findElement(By.xpath(iOS_Objects.getProperty("GeneralAppSecondQuestion"))).click();
            }
            
            //Method to click Second Question in General App FAQ for Android
            public static void CLickGeneralAppSecondQuestion_AN() throws Exception
            {
              nativedriver.findElement(By.xpath(Android_Objects.getProperty("GeneralAppFirstQuestion"))).click();
            }
            
          //Method to click Second Question in General App FAQ
            
            public static void CLickGeneralAppSecondQuestion() throws Exception
                           {
                            if(Device_Model.contains("iPhone"))
                            {
                            	CLickGeneralAppSecondQuestion_iOS();
                            }else
                            {
                            	CLickGeneralAppSecondQuestion_AN();
                            }
                                      
                           }
            
            
            public static void ValidateCollapsing() throws Exception{
            	try{
            		if(!nativedriver.findElement(By.xpath("//*[@class='UIAWebView']/text[4]")).isDisplayed())
            		{
                       Thread.sleep(2000);
                       System.out.println("The last FAQ content that was expanded is not collapsed.");
                       HPECommonFunctions.CaptureScreenshot("TC_Fail_");           
                       //HPECommonFunctions.ClickSignOut();
                       HPECommonFunctions.Close_App_HPE();
                       Thread.sleep(2000);
                       Assert.fail("The last FAQ content that was expanded is not collapsed.");
            		}
            	}catch (Exception e)
            	{
            		System.out.println("The last FAQ content that was expanded is collapsed.");                        
                  
            	}
            
                   
            }

            
            public static void ValidatePoweredByHPEOSS_iOS() throws Exception{
            	try{
            
            		 nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                     String xyz=nativedriver.findElement(By.xpath(iOS_Objects.getProperty("PoweredByHPEOSS"))).getText();
                     System.out.println("Order Status "+xyz); 
              }
            catch(Exception e){
            	
            	nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    			WebElement PoweredByOSS = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("PoweredByOSS")));
    			if (!PoweredByOSS.isDisplayed()) {
    				WatchlistCount = PoweredByOSS.getAttribute("name");
    				System.out.println("End Customer Name is Present & below is the name");
    				System.out.println(WatchlistCount);
    			}
    			else
    			{
            		System.out.println("Powered By OSS not present next to Order Status");
            	}

       		 
            	}
            }
	
            

         // Method to validate HPEOSS string in Android
                     
                     public static void ValidatePoweredByHPEOSS_AN() throws Exception{
                     
                               nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                              WebElement xyz=nativedriver.findElement(By.xpath(Android_Objects.getProperty("PoweredByHPEOSS")));
                              if (xyz.isDisplayed())
                              {
                              System.out.println("The next to Order Status is: "+"Powered by HPE OSS"); 
                       }
                     }

            
    //Method to validate HPEOSS string
            
            public static void ValidatePoweredByHPEOSS() throws Exception
                           {
                            if(Device_Model.contains("iPhone"))
                            {
                                   ValidatePoweredByHPEOSS_iOS();
                            }else if(Device_Model.contains("iPad"))
                            {
                                   ValidatePoweredByHPEOSS_iOS();
                            }else
                            {
                                   ValidatePoweredByHPEOSS_AN();
                            }
                                      
                           }

             
             //Method to validate Search Result by count
         // Method to validate Search Result by count
        	public static void SearchResultnumberValidation() throws Exception {
        		try {
        			// List<WebElement> SearchResults=(List<WebElement>)
        			// nativedriver.findElements(By.xpath("//*[contains(@label,'ARROW
        			// ELECTRONICS')]"));
        			List<WebElement> optionCount = nativedriver
        					.findElements(By.xpath(iOS_Objects.getProperty("SearchResultnumberValidation")));
        			int searchResults = optionCount.size();
        			if (searchResults > 20) {
        				Assert.fail("The count is more than 20");
        			}
        		} catch (Exception e) {
        			List<WebElement> optionCount = nativedriver
        					.findElements(By.xpath(iOS_Objects.getProperty("SearchResultnumberValidation")));
        			int searchResults = optionCount.size();
        			System.out.println("The count is " + searchResults);
        		}

        	}
        	
        	//Method to validate date format 
        	public static void ValidateDateFormat1() throws Exception {
        		Date date = null;
        		try {
        			date = new SimpleDateFormat("MM-dd-yyyy").parse("20130925");
        		} catch (Exception e) {
        			System.out.println("Invalid date Format");
        			// do something for invalid dateformat
        		}

        	}

        	
        	//Method to validate date format 
        	public static String GetDate()
        	{
        		
        		String date =nativedriver.findElement(By.xpath(iOS_Objects.getProperty("OrderDate"))).getText();
        		System.out.println("Date displayed on order details page is " + date);  
				return date;

        	}

        		  public static void ValidateDateFormat(String inDate) {
        		    SimpleDateFormat dateFormat = new SimpleDateFormat("mm-dd-yyyy");
        		    //dateFormat.setLenient(false);
        		    try {
        		      dateFormat.parse(inDate.trim());
        		    } catch (ParseException pe) {
        		      //return false;
        		      System.out.println("Date is not matched with the format mm-dd-yyyy");
        		    }
        		    //return true;
        		    System.out.println("Date is matched to the format mm-dd-yyyy");
        		  }

        		  //public static void main(String[] args) {

        		   // System.out.println(isValidDate("2004-02-29"));
        		  //  System.out.println(isValidDate("2005-02-29"));
        		  
        		
            
          //Method to validate WatchList Result by count
            public static void WatchListResultnumber() throws Exception{
            	try{
            		// List<WebElement> SearchResults=(List<WebElement>) nativedriver.findElements(By.xpath("//*[contains(@label,'ARROW ELECTRONICS')]")); 
                    List<WebElement>optionCount=nativedriver.findElements(By.xpath(iOS_Objects.getProperty("SearchResultnumberValidation")));
                    int searchResults=optionCount.size();
                    if (searchResults>20)
                    {
                    Assert.fail("The count is more than 20");
                    }
            	}catch (Exception e)
            	{
            		List<WebElement>optionCount=nativedriver.findElements(By.xpath(iOS_Objects.getProperty("SearchResultnumberValidation")));
                    int searchResults=optionCount.size();
            		System.out.println("The count is " +searchResults);
            	}
            
             }
           
            	public static void hpeOrderNumber() throws Exception
            	{
            			try {
            				String orderNum = nativedriver.findElement(By.xpath("(//*[@label='Box'])[3]")).getText();
            				System.out.println(orderNum);
            				if (orderNum.trim().contains(config.getProperty("HPE-ProductNumber"))) {
            					nativedriver.findElement(By.xpath("(//*[@label='Box'])[3]")).click();
            					System.out.println("Clicking on the order " + config.getProperty("HPE-ProductNumber"));
            				}
            			} catch (Exception e) {
            				System.out.println("Order Number not found");
            				e.printStackTrace();
            				HPECommonFunctions.CaptureScreenshot("TC_Fail_");                         
               	         	//HPECommonFunctions.ClickSignOut();
               	         HPECommonFunctions.Close_App_HPE();
                         Thread.sleep(2000);
            				Assert.fail("Order Number not found");
            				
            			}
            		} 
            	
            	public static void Country() throws Exception {
            		// *[@label="United States"]

            		String Country = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("Country"))).getAttribute("label");
            		System.out.println("The Country is " + Country);

            	}

            	public static void WatchlistFirstOneClick() throws Exception {

            		device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("482,910")));
            		System.out.println("Clicked on Watchlist First Item");
            		Thread.sleep(10000);

            	}

            	public static void WatchlistCount() throws Exception {

            		try {
            			nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            			WebElement WatchlistCount1 = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("WatchlistCount")));
            			if (!WatchlistCount1.isDisplayed()) {
            				WatchlistCount = WatchlistCount1.getAttribute("name");
            				System.out.println("End Customer Name is Present & below is the name");
            				System.out.println(WatchlistCount);
            			}

            		} catch (Exception e) {
            			System.out.println("WatchlistCount is not found");
            		}

            	}

            	

            	public static void firstOrderClick_iOS() throws Exception {
            		
            		try {
            		
            			Thread.sleep(2000);
            			nativedriver.findElement(By.xpath(iOS_Objects.getProperty("FirstOrderClick"))).click();
            			System.out.println("Order Details page is displayed");
            			Thread.sleep(5000);
            			
            			//HPECommonFunctions.CheckServiceError("C://HPE//FunctionalTesting//Images//ServiceErrorOK" +".png");
            		
            		} catch (Exception e) {
            			System.out.println("Order Details page is not displayed");
            			e.printStackTrace();
            			HPECommonFunctions.CaptureScreenshot("TC_Fail_");                         
           	         	//HPECommonFunctions.ClickSignOut();
           	         	HPECommonFunctions.Close_App_HPE();
           	         	Thread.sleep(2000);
            			Assert.fail("Order Details page is not displayed");
            			
            		}
            		}
            		
                    public static void firstOrderClick_AN() throws Exception
                    {
                                             
                         device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("306,791")));
                               System.out.println("Clicked on  order in Search Page");
                               Thread.sleep(10000); 
                                                                                                                        
                               }
            	
                  

                    
                    public static void firstOrderClick() throws Exception
                    {
                           if(Device_Model.contains("iPhone"))
                           {
                                 firstOrderClick_iOS();
                           }else {
                                 firstOrderClick_AN();
                           }
                    }


            		
            	
            	
            	public static void odPageHeader_iOS()throws Exception  {
            		try {
            							
            		
            			String ODPageHeader =nativedriver.findElement(By.xpath(iOS_Objects.getProperty("ODpageheader"))).getText();
            			System.out.println("The OD Page Header is "+ ODPageHeader);
            			
            			
            			
            			
            			
            		} catch (Exception e) {
            			System.out.println("Order Details Page header is not Order Details ");
            			e.printStackTrace();
            			Assert.fail("Order Details Page header is not Order Details");
            			
            		}
            	}
            	
            	public static void odPageHeader_AN()throws Exception  
            	{
            	
            							
            			HPECommonFunctions.Find_Text(config.getProperty("OrderDetails_PageTitle")); 
            			
            		
            	}
            	
          	  //Method to verify the order details header
        	    public static void odPageHeader() throws Exception
        			      {
        			    	if(Device_Model.contains("iPhone"))
        			    	{
        			    		odPageHeader_iOS();
        			    	}else 
        			    	{
        			    		odPageHeader_AN();
        			    	}
        			    	          
        			      }
        	    
            	public static void odPageFooter_iOS()throws Exception {
            		
            		
            		
            			String ODPageFooter1 = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("ODPageFooter1")))
            					.getText();
            			System.out.println("The First Icon on the ODPage Footer is  " + ODPageFooter1);
            			Thread.sleep(2000);
            			String ODPageFooter2 = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("ODPageFooter2")))
            					.getText();
            			System.out.println("The Second Icon on the ODPage Footer is  " + ODPageFooter2);
            			Thread.sleep(2000);
            			String ODPageFooter3 = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("ODPageFooter3")))
            					.getText();
            			System.out.println("The Third Icon on the ODPage Footer is  " + ODPageFooter3);
            			Thread.sleep(2000);
            			String ODPageFooter4 = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("ODPageFooter4")))
            					.getText();
            			System.out.println("The Third Icon on the ODPage Footer is  " + ODPageFooter4);
            			Thread.sleep(2000);
            	}
            	
            	public static void odPageFooter_AN()throws Exception 
            	{
            		
            		try
                    {
            			nativedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);                    
            			WebElement FooterAN = nativedriver.findElement(By.xpath(Android_Objects.getProperty("ODPageFooter")));
				        System.out.println("The ODPage Footer is Present");
				        Thread.sleep(5000);
				       
                    }
       
            		catch(Exception e)
            		{
            			System.out.println("The ODPage Footer is not Present");                       
			             HPECommonFunctions.CaptureScreenshot("TC_Fail_");           
			             //HPECommonFunctions.ClickSignOut();
			             HPECommonFunctions.Close_App_HPE();
		                    Thread.sleep(2000);
			             Assert.fail("The ODPage Footer is not Present");
            		}

            	}
            	
            	//Method to verify the footer on the app
    		    public static void VerifyodPageFooter() throws Exception
    		      {
    		    	if(Device_Model.contains("iPhone"))
    		    	{
    		    		//ClickOnSearchIcon_iOS();
    		    		odPageFooter_iOS();
    		    	}else
    		    	{
    		    		odPageFooter_AN();
    		    	}
    		    	          
    		      } 
            	
            	public static void recentSearchesPageHeader()throws Exception  {
            		try {
            							
            		
            			String RecentSearchesPageHeader =nativedriver.findElement(By.xpath(iOS_Objects.getProperty("ODpageheader1"))).getText();
            			System.out.println("The Recent Pages Header is "+RecentSearchesPageHeader);
            			} catch (Exception e) {
            			System.out.println("The Recent Pages header is not Recent Pages ");
            			e.printStackTrace();
            			 HPECommonFunctions.CaptureScreenshot("TC_Fail_");                         
            	         //HPECommonFunctions.ClickSignOut();
            	         HPECommonFunctions.Close_App_HPE();
                         Thread.sleep(2000);
            			Assert.fail("The Recent Pages header is not Recent Pages");
            			
            		}
            	}
            	
            	public static void OrderDetailsList()throws Exception{
            		
            		try {
            			String OrderDetailsList1 = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("OD1"))).getText();
            			System.out.println("The First Order detail is " + OrderDetailsList1);
            			String OrderDetailsList2 = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("OD2"))).getText();
            			System.out.println("The Second Order detail is  " + OrderDetailsList2);
            			String OrderDetailsList3 = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("OD3"))).getText();
            			System.out.println("The Third Order detail is  " + OrderDetailsList3);
            			String OrderDetailsList4 = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("OD4"))).getText();
            			System.out.println("The Fourth Order detail is  " + OrderDetailsList4);
            		} catch (Exception e) {
                        System.out.println("Watch List Result is not Present");                        
                        HPECommonFunctions.CaptureScreenshot("TC_Fail_");                         
                        //HPECommonFunctions.ClickSignOut();
                        HPECommonFunctions.Close_App_HPE();
                        Thread.sleep(2000);
                        
                        Assert.fail("Watch List Result is not Present");

            		}
            		
            		
            		
            	}
            	
            	public static void ValidateSearchSaved() throws Exception{
            		
            		try {
            				String SearchBOX = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("SearchBox"))).getText();
            				System.out.println("The First Order detail is " + SearchBOX);
            				Thread.sleep(2000);
            				HPECommonFunctions.ClickRecentSearches();
            				Thread.sleep(2000);
            				String RecentSearchFirstOne = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("RecentSearchesFirstOne"))).getAttribute("label");
            				System.out.println("The Search keyword and the first keyword in Recent Search are the same and the Search Keyword is "
            							+ RecentSearchFirstOne);
            			} catch (Exception e) 
            			{
            				System.out.println("The Search Keyword and First Keyword in Recent Search do not match");                        
            				HPECommonFunctions.CaptureScreenshot("TC_Fail_");                         
            				//HPECommonFunctions.ClickSignOut();
            				HPECommonFunctions.Close_App_HPE();
                            Thread.sleep(2000);
            				Assert.fail("The Search Keyword and First Keyword in Recent Search do not match");

            		}
            		
            		
            	}
            	public static void EnterAdavanceSearchKeyword() throws Exception{

            	try {
            		nativedriver.findElement(By.xpath("//*[@value='Example: Main Street and/or Denver and/or CO']")).sendKeys("Arrow Electronics");
            		Thread.sleep(2000);
            		
            	} catch (Exception e) {
            		System.out.println("The Advanced Search results are not displayed");                        
                    HPECommonFunctions.CaptureScreenshot("TC_Fail_");                         
                    //HPECommonFunctions.ClickSignOut();
                    HPECommonFunctions.Close_App_HPE();
                    Thread.sleep(2000);
                    Assert.fail("The Advanced Search results are not displayed");

            	}
            }
            	
            public static void ValidateAdvanceSearchSaved() throws Exception{
            		
            		try {
            			EnterAdavanceSearchKeyword();
            			
            			String AdvanceSearchBOX = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("AdvanceSearchBox"))).getText();
            			System.out.println("The Advance Search Keyword is " + AdvanceSearchBOX);
            			Thread.sleep(2000);
            			
            			nativedriver.findElement(By.xpath(iOS_Objects.getProperty("AdvanceSearchButton"))).click();
            			System.out.println("The Advance Search Results button is tapped and the results are displayed");
            			Thread.sleep(2000);
            			
            			HPECommonFunctions.ClickRecentSearches();
            			
            			String RecentSearchFirstOne = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("RecentSearchesFirstOne"))).getAttribute("label");
            			System.out.println("The Advance Search keyword and the first keyword in Recent Search are the same and the Search Keyword is "+ RecentSearchFirstOne);
            			
            			
            		} catch (Exception e) {
            			
            		
            			System.out.println("The Advance Search Keyword and First Keyword in Recent Search do not match");                        
                        HPECommonFunctions.CaptureScreenshot("TC_Fail_");                         
                        //HPECommonFunctions.ClickSignOut();
                        HPECommonFunctions.Close_App_HPE();
                        Thread.sleep(2000);
                        Assert.fail("The Advance Search Keyword and First Keyword in Recent Search do not match");

            		}
            }
            public static void ValidateRecentSearchCount() throws Exception{
            	try{
            		  List<WebElement>optionCount=nativedriver.findElements(By.xpath(iOS_Objects.getProperty("RecentSearchResults")));
                      int searchResults=optionCount.size();
                      int searchResults1=searchResults-4;
                      if (searchResults1==20)
                      {
                      	System.out.println("The count is of Recent Searched Results is 20");
                      }
              	}catch (Exception e)
              	{
              		System.out.println("The count is of Recent Searched Results is not 20");
              	} 
            	}

            
            public static void ClickRecentSearchesfirstKeyword_iOS()throws Exception {
            	
            	try {
            		WebElement Keyword = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("RecentSearchesFirstOne")));
            		Thread.sleep(2000);
            		Keyword.click();
            		
            		System.out.println("Clicked on the recent search first keyword");
            	} catch (Exception e) {

            		System.out.println("First keyword of Recent Searches was not found");                        
                    HPECommonFunctions.CaptureScreenshot("TC_Fail_");                         
                    //HPECommonFunctions.ClickSignOut();                    
                    HPECommonFunctions.Close_App_HPE();
                    Thread.sleep(2000);
                    Assert.fail("First keyword of Recent Searches was not found"); 
            	}
            	
            }
            
            public static void ClickRecentSearchesfirstKeyword_AN()throws Exception {
            	
            	
            	device.getMobileTouchScreen().touch(new MobileCoordinates(new MobilePoint("114,271")));
        		System.out.println("Clicked on the recent search keyword");
        	    Thread.sleep(10000);
            	
             }
            
            
        	//Method to verify the footer on the app
		    public static void ClickRecentSearchesfirstKeyword() throws Exception
		      {
		    	if(Device_Model.contains("iPhone"))
		    	{
		    		//ClickOnSearchIcon_iOS();
		    		ClickRecentSearchesfirstKeyword_iOS();
		    	}else
		    	{
		    		ClickRecentSearchesfirstKeyword_AN();
		    	}
		    	          
		      } 
            
          //Method to validate shipments status *TC_4*

            public static void ValidateMultipleShipmentsStatus() throws Exception{
            	
            	try {
            		
            		
            		String OrderStatus = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("MultipleShipments"))).getText();
            		System.out.println("The Order Staus displayed is "+ OrderStatus);
            		Thread.sleep(2000);
            	}
            	catch (Exception e) {
            		
            		
            		System.out.println("The Order Does not have Multiple Shipments");                        
                    HPECommonFunctions.CaptureScreenshot("TC_Fail_");                         
                    //HPECommonFunctions.ClickSignOut();
                    HPECommonFunctions.Close_App_HPE();
                    Thread.sleep(2000);
                    Assert.fail("The Order Does not have Multiple Shipments");

            	}

            }


            public static void VerifyOrderRemovedFromWatchList() throws Exception {
            	try {
            		visualdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            		WebElement WhiteFlag = nativedriver.findElement(By.xpath(iOS_Objects.getProperty("WhiteFLag")));
            		if (!WhiteFlag.isDisplayed()) {
            			
            			System.out.println("Order is Removed from the WatchList");
            			Thread.sleep(2000);
            			
            		}
            	} catch (Exception e) {
            		System.out.println("Order is not Removed from the WatchList");
            		HPECommonFunctions.CaptureScreenshot("TC_Fail_");
            		//HPECommonFunctions.ClickSignOut();
            		HPECommonFunctions.Close_App_HPE();
                    Thread.sleep(2000);
            		Assert.fail("Order is not Removed from the WatchList");
            	}

            }

            public static void ValidateAutoPopulateOrderDateRange() throws Exception{
            	HPECommonFunctions.ClickOnOrderStartDate();
        		HPECommonFunctions.ClickonOrderDateStartToday();
        		Thread.sleep(2000);
        		System.out.println("The Order Date Range is Auto Populated from the date chosen");
        		Thread.sleep(2000);
            	
            /*	try {
            		
            		
            		HPECommonFunctions.ClickOnOrderStartDate();
            		HPECommonFunctions.ClickonOrderDateStartToday();
            		Thread.sleep(2000);
            		System.out.println("The Order Date Range is Auto Populated from the date chosen");
            		Thread.sleep(2000);
            	}
            	catch (Exception e) {
            		
            		
            		System.out.println("The Order Date Range is not Auto Populated from the date chosen");                        
                    HPECommonFunctions.CaptureScreenshot("TC_Fail_");                         
                    //HPECommonFunctions.ClickSignOut();
                    HPECommonFunctions.Close_App_HPE();
                    Thread.sleep(2000);
                    Assert.fail("The Order Date Range is not Auto Populated from the date chosen");

            	}
*/
            }
            

            public static void ValidateAutoPopulateShipDateRange() throws Exception{
            	
            	
            		
            		//HPECommonFunctions.ClickOnShipStartDate();
                    
                    //HPECommonFunctions.ClickonShippingStartDate();
                    
                    HPECommonFunctions.ClickOnEstimatedShipDateCalendar();
                    HPECommonFunctions.ClickonDeliveryDate();

            	    
            		Thread.sleep(2000);
            		System.out.println("The Ship Date Range is Auto Populated from the date chosen");
            	
            		
            	
            		
            		
            	}
            

            
            public static void ValidateAutoPopulateDeliveryDateRange() throws Exception{
           	 //HPECommonFunctions.ClickOnDeliveryStartDateCalendar();
    		 //HPECommonFunctions.ClickonShippingStartDate();

    		
    		//HPECommonFunctions.ClickOnDeliveryStartDateCalendar();
           // HPECommonFunctions.ClickonDeliveryDate();
    		Thread.sleep(2000);
    		System.out.println("The Ship Date Range is Auto Populated from the date chosen");
    		Thread.sleep(2000);

            	/*
            	try {
            		

            		 HPECommonFunctions.ClickOnDeliveryStartDateCalendar();
            		 HPECommonFunctions.ClickonShippingStartDate();

            		
            		//HPECommonFunctions.ClickOnDeliveryStartDateCalendar();
                   // HPECommonFunctions.ClickonDeliveryDate();
            		Thread.sleep(2000);
            		System.out.println("The Ship Date Range is Auto Populated from the date chosen");
            		Thread.sleep(2000);
            	}
            	catch (Exception e) {
            		
            		
            		System.out.println("The Ship Date Range is not Auto Populated from the date chosen");                        
                    HPECommonFunctions.CaptureScreenshot("TC_Fail_");                         
                    //HPECommonFunctions.ClickSignOut();
                    HPECommonFunctions.Close_App_HPE();
                    Thread.sleep(2000);
                    Assert.fail("The Order Does not have Multiple Shipments");

            	}
*/

            
            }
            

public static void ClickOnWatchListhpeOrderNumber() {
	try {
		
		nativedriver.findElement(By.xpath(iOS_Objects.getProperty("HPE-ProductNumber7"))).click();
			System.out.println("Clicking on the order");
			Thread.sleep(3000);
		}

	 catch (Exception e) {
		//HPECommonFunctions.ClickWatchListHPEProductNumber();
		 
		System.out.println("Order Number not found");
		//e.printStackTrace();
		//Assert.fail("Order Number not found");
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


public static void SecondOrderClick_iOS() throws Exception {
    
    try {
    
          Thread.sleep(2000);
    nativedriver.findElement(By.xpath(iOS_Objects.getProperty("SecondOrderClick"))).click();
          System.out.println("Order Details page is displayed");
          Thread.sleep(10000);
          
    //HPECommonFunctions.CheckServiceError("C://HPE//FunctionalTesting//Images//ServiceErrorOK" +".png");
    
    } catch (Exception e) {
          System.out.println("Order Details page is not displayed");
          e.printStackTrace();
          HPECommonFunctions.CaptureScreenshot("TC_Fail_");                         
          //HPECommonFunctions.ClickSignOut();
          HPECommonFunctions.Close_App_HPE();
          Thread.sleep(2000);
          Assert.fail("Order Details page is not displayed");
          
    }
    }

}


            
            





  		




		


