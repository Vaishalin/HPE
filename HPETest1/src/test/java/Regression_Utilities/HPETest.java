package Regression_Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;

//import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import org.testng.annotations.Parameters;

import Libraries.HPECommonFunctions;

import Libraries.HPEOperations;
//import Report.ExcelReportGenerator;

import com.beust.jcommander.Parameter;
//import com.beust.jcommander.Parameters;
import com.perfectomobile.httpclient.utils.FileUtils;
import com.perfectomobile.selenium.MobileCoordinates;
import com.perfectomobile.selenium.MobileDriver;
import com.perfectomobile.selenium.MobilePoint;
import com.perfectomobile.selenium.api.IMobileDevice;
import com.perfectomobile.selenium.api.IMobileWebDriver;
import com.perfectomobile.selenium.by.ByMobile;
import com.perfectomobile.selenium.options.MobileDeviceVital;
import com.perfectomobile.selenium.options.rotate.MobileDeviceRotateOptions;
import com.perfectomobile.httpclient.MediaType;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

//import datatable.XLS_Reader;
//import com.perfectomobile.PerfectoLabUtils;

public class HPETest extends BaseClassHPE
{	
	
	public static String date=null;
	@Test(priority=1,groups={"Primary","Secondary"},enabled=true)
	public void TC_136_ValidateConnectivity()throws Exception
	{    	   	
		    HPECommonFunctions.screen();
			System.out.println("Starting of TC_136_ValidateConnectivity");
			HPECommonFunctions.screen();
		    
		    HPECommonFunctions.Open_App_HPE();
		    HPECommonFunctions.VerifyConnectivity("Sign In");	
		    HPECommonFunctions.Close_App_HPE();
			
			HPECommonFunctions.screen();
		    System.out.println("Ending of TC_136_ValidateConnectivity");
		    HPECommonFunctions.screen();
		    
	}
	
@Test(priority=2,groups={"Primary","Secondary"},enabled=false)
public void TC_134_ValidateErrorMessageForWrongUsername()throws Exception
{             
              
          HPECommonFunctions.screen();
          System.out.println("Starting of TC_134_ValidateErrorMessageForWrongUsername");
          HPECommonFunctions.screen();
           
          
          HPECommonFunctions.Open_App_HPE();
          HPECommonFunctions.EnterWrongUserName(config.getProperty("WrongUserName"));
          HPECommonFunctions.EnterPassword();
          HPECommonFunctions.ClickSignIn1();        
          //HPECommonFunctions.VerifyErrorMessage(config.getProperty("Access_Denied"));
          HPECommonFunctions.Close_App_HPE();
         
               
          HPECommonFunctions.screen();
          System.out.println("Ending of TC_134_ValidateErrorMessageForWrongUsername");
          HPECommonFunctions.screen();
           
}



@Test(priority=3,groups={"Primary"},enabled=false)
public void TC_135_ValidateErrorMessageForWrongPassword()throws Exception
{             
       
            HPECommonFunctions.screen();
            System.out.println("Starting of TC_135_ValidateErrorMessageForWrongPassword");
            HPECommonFunctions.screen();
                       
            HPECommonFunctions.Open_App_HPE();
            HPECommonFunctions.EnterUserName(config.getProperty("UserName"));                          
            //HPECommonFunctions.EnterPassword();
           	HPECommonFunctions.EnterWrongPassword();
           	HPECommonFunctions.ClickSignIn1();        
        	//HPECommonFunctions.VerifyErrorMessage(config.getProperty("Access_Denied"));
           	HPECommonFunctions.Close_App_HPE();
        
        	HPECommonFunctions.screen();
            System.out.println("Ending of TC_135_ValidateErrorMessageForWrongPassword");
            HPECommonFunctions.screen();
           
}

	
	@Test(priority=4, groups={"Primary","Secondary"},enabled=false)
    public void TC_140_ValidateDeclineButton()throws Exception
    {    	
    	
    	    HPECommonFunctions.screen();
		    System.out.println("Starting of TC_140_ValidateDeclineButton");
		    HPECommonFunctions.screen();
		    
		   
		    HPECommonFunctions.Open_App_HPE();
    	    HPEOperations.FirstLogin_App();
    		HPECommonFunctions.SwipeUp();
    		HPECommonFunctions.VerifyDeclineButton();
    		HPECommonFunctions.ClickDecline(); 
    		HPECommonFunctions.Close_App_HPE();
    		
    		HPECommonFunctions.screen();
    		System.out.println("Ending of TC_140_ValidateDeclineButton");
    		HPECommonFunctions.screen();
    	
    		
    }
	
    
    @Test(priority=5,groups={"Primary","Secondary"},enabled=false)
    public void TC_139_ValidateAcceptButton()throws Exception
    {    	   	
    	
    	    HPECommonFunctions.screen();
    		System.out.println("Starting of TC_139_ValidateAcceptButton");
    		HPECommonFunctions.screen();
    	    
    	    HPECommonFunctions.Open_App_HPE();
    		HPEOperations.FirstLogin_App();
    		HPECommonFunctions.SwipeUp();
    		HPECommonFunctions.VerifyAcceptButton(); 
    		//HPECommonFunctions.SwipeUp();
    		HPECommonFunctions.ClickDecline();
    		
    		HPECommonFunctions.Close_App_HPE();

			HPECommonFunctions.screen();
		    System.out.println("Ending of TC_139_ValidateAcceptButton");
		    HPECommonFunctions.screen();

    	
    }
    
    @Test(priority=6, groups={"Primary"},enabled=false)
    public void TC_138_ValidateTermsConditionPage()throws Exception
    {    	
    	
    	
    	    HPECommonFunctions.screen();
		    System.out.println("Starting of TC_138_ValidateTermsConditionPage");
		    HPECommonFunctions.screen();
		
    		HPECommonFunctions.Open_App_HPE();
    		HPEOperations.FirstLogin_App();
    		//HPECommonFunctions.VerifyTermsConditionPage(); 
    		HPECommonFunctions.Find_Text(config.getProperty("TermsAndConditions"));
            HPECommonFunctions.SwipeUp();
            HPECommonFunctions.ClickDecline(); 
            HPECommonFunctions.Close_App_HPE();

    		
    		HPECommonFunctions.screen();
    		System.out.println("Ending of TC_138_ValidateTermsConditionPage");
    		HPECommonFunctions.screen();
    	
    		
    }
    
    
    @Test(priority=7,groups={"Primary","Secondary"},enabled=false)
    public void TC_123_ValidateFlagIcon_Home()throws Exception
    {    	   	
    	
    	    HPECommonFunctions.screen();
    		System.out.println("Starting of TC_123_ValidateFlagIcon_Home");
    		HPECommonFunctions.screen();
    	    
    	    		
    	    HPECommonFunctions.Open_App_HPE();
    		HPEOperations.Login_App();    		 		
    		HPECommonFunctions.ClickMenuBar();
    		HPECommonFunctions.ClickHome();
    		HPECommonFunctions.VerifyFlagIcon(); 
    		HPECommonFunctions.ClickSignOut();
    		HPECommonFunctions.Close_App_HPE();

			HPECommonFunctions.screen();
		    System.out.println("Ending of TC_123_ValidateFlagIcon_Home");
		    HPECommonFunctions.screen();

    	
    }
    
    
    
    @Test(priority=8,groups={"Primary"},enabled=false)
    public void TC_125_ValidateOrderDeletionFromWatchlist()throws Exception
    {    	   	
    	
    	    HPECommonFunctions.screen();
    		System.out.println("Starting of TC_125_ValidateOrderDeletionFromWatchlist");
    		HPECommonFunctions.screen();
    	    
    		
    	    HPECommonFunctions.Open_App_HPE();
    		HPEOperations.Login_App(); 
    		HPECommonFunctions.ClickWatchList(); 
    		HPECommonFunctions.ClickOnWatchListGreenFlag();
    		
			HPECommonFunctions.screen();
		    System.out.println("Ending of TC_125_ValidateOrderDeletionFromWatchlist");
		    HPECommonFunctions.screen();

    	
    }
    
    @Test(priority=9,groups={"Primary","Secondary"},enabled=false)
    public void TC_5_ValidateOrderDetailsPage()throws Exception
    {                
       
              HPECommonFunctions.screen();
              System.out.println("Starting of TC_5_ValidateOrderDetailsPage");
              HPECommonFunctions.screen();
           
              HPECommonFunctions.Open_App_HPE();
              HPEOperations.Login_App();
              HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword"));             
              HPECommonFunctions.ClickOnSearchIcon();              
              //HPECommonFunctions.VerifySearchPage();
              HPECommonFunctions.Find_Text(config.getProperty("Search_PageTitle"));              
              HPECommonFunctions.ClickOnSearchResult();
     
              HPECommonFunctions.screen();
              System.out.println("Ending of TC_5_ValidateOrderDetailsPage");
              HPECommonFunctions.screen();
  
    }
    
  
    @Test(priority=10,groups={"Primary"},enabled=false)
    public void TC_115_Validate3LineMenu()throws Exception
    {    	   	
    	
    	    HPECommonFunctions.screen();
    		System.out.println("Starting of TC_115_Validate3LineMenu");
    		HPECommonFunctions.screen();
    	    
    	    HPECommonFunctions.Open_App_HPE();
    		HPEOperations.Login_App();
    		
    		HPECommonFunctions.VerifyMenuBar();
    		HPECommonFunctions.ClickMenuBar();
    		HPECommonFunctions.VerifyMenuSlide();
    		
    		HPECommonFunctions.ClickSignOut1();
    		HPECommonFunctions.Close_App_HPE();
    		
			HPECommonFunctions.screen();
		    System.out.println("Ending of TC_115_Validate3LineMenu");
		    HPECommonFunctions.screen();
		    
    }
    
    
    @Test(priority=11,groups={"Primary"},enabled=false)
    public void TC_93_BackButtonFromWatchListPage()throws Exception
    {    	   	
    	
    	    HPECommonFunctions.screen();
    		System.out.println("Starting of TC_93_BackButtonFromWatchListPage");
    		HPECommonFunctions.screen();
    	    	
    	    HPECommonFunctions.Open_App_HPE();
    		HPEOperations.Login_App(); 
    		HPECommonFunctions.ClickWatchList();
    		
    		HPECommonFunctions.VerifyBackButton();
    		HPECommonFunctions.ClickBackButton();    	
    		HPECommonFunctions.ClickSignOut();
    		HPECommonFunctions.Close_App_HPE();
    		
			HPECommonFunctions.screen();
		    System.out.println("Ending of TC_93_BackButtonFromWatchListPage");
		    HPECommonFunctions.screen();
		    
    }
    
    @Test(priority=12,groups={"Primary","Secondary"},enabled=false)
    public void TC_96_VerifyVersionNumberOnMenuPage()throws Exception
    {                
       
              HPECommonFunctions.screen();
              System.out.println("Starting of TC_96_VerifyVersionNumberOnMenuPage");
              HPECommonFunctions.screen();
           
              HPECommonFunctions.Open_App_HPE();
              HPEOperations.Login_App(); 
              HPECommonFunctions.VerifyMenuBar();
              HPECommonFunctions.ClickMenuBar();
              HPECommonFunctions.VerifyMenuSlide();             
              HPECommonFunctions.VerifyVersionNumber();
              HPECommonFunctions.ClickSignOut1();
              HPECommonFunctions.Close_App_HPE();
              
              HPECommonFunctions.screen();
              System.out.println("Ending of TC_96_VerifyVersionNumberOnMenuPage");
              HPECommonFunctions.screen();
                  
    }
    
    @Test(priority=13,groups={"Primary"},enabled=false)
    public void TC_105_VerifyGetSupportOption()throws Exception
    {                
       
              HPECommonFunctions.screen();
              System.out.println("Starting of TC_105_VerifyGetSupportOption");
              HPECommonFunctions.screen();
             
              HPECommonFunctions.Open_App_HPE();
              HPEOperations.Login_App(); 
              HPECommonFunctions.VerifyMenuBar();
              HPECommonFunctions.ClickMenuBar();
              HPECommonFunctions.VerifyMenuSlide();
              HPECommonFunctions.Find_Text(config.getProperty("GetSupport_Button"));
              //HPECommonFunctions.VerifyGetSupportMenuOption();
              HPECommonFunctions.ClickSignOut1();
              HPECommonFunctions.Close_App_HPE();
              
              HPECommonFunctions.screen();
              System.out.println("Ending of TC_105_VerifyGetSupportOption");
              HPECommonFunctions.screen();
                  
    }
    
    @Test(priority=14,groups={"Primary"},enabled=false)
    public void TC_106_ClickGetSupportOption()throws Exception
    {                
       
    	      HPECommonFunctions.screen();
              System.out.println("Starting of TC_106_ClickGetSupportOption");
              HPECommonFunctions.screen();
           
              HPECommonFunctions.Open_App_HPE();
              HPEOperations.Login_App(); 
              HPECommonFunctions.VerifyMenuBar();
              HPECommonFunctions.ClickMenuBar();
              HPECommonFunctions.VerifyMenuSlide(); 
              HPECommonFunctions.Find_Text(config.getProperty("GetSupport_Button"));
             
              HPECommonFunctions.ClickGetSupportOption();              
              HPECommonFunctions.VerifyGetSupportPage();
              HPECommonFunctions.ClickSignOut();
              HPECommonFunctions.Close_App_HPE();
              
              HPECommonFunctions.screen();
              System.out.println("Starting of TC_106_ClickGetSupportOption");
                  
    }
    
    
    @Test(priority=15,groups={"Primary"},enabled=false)
    public void TC_91_BackButtonFromSearchResultsPage()throws Exception
    {    	   	
    	
    	    HPECommonFunctions.screen();
    		System.out.println("Starting of TC_91_BackButtonFromSearchResultsPage");
    		HPECommonFunctions.screen();
    		
    		//HPECommonFunctions.Open_App_HPE();
    	    HPECommonFunctions.Open_App_HPE();
    		HPEOperations.Login_App();
    		
            HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword"));
            HPECommonFunctions.ClickOnSearchIcon();            
            HPECommonFunctions.VerifySearchPage();            
    		HPECommonFunctions.VerifyBackButton();
    		HPECommonFunctions.ClickBackButton();   	
    		HPECommonFunctions.ClickSignOut();
    		HPECommonFunctions.Close_App_HPE();
    		
			HPECommonFunctions.screen();
		    System.out.println("Ending of TC_91_BackButtonFromSearchResultsPage");
		    HPECommonFunctions.screen();
		    
    }
    
    
    @Test(priority=16,groups={"Primary"},enabled=false)
    public void TC_92_BackButtonFromAlertsPage()throws Exception
    {    	   	
    	
    	    HPECommonFunctions.screen();
    		System.out.println("Starting of TC_92_BackButtonFromAlertsPage");
    		HPECommonFunctions.screen();
    	    
    		HPECommonFunctions.Open_App_HPE();
    	   
    		HPEOperations.Login_App(); 
    		HPECommonFunctions.ClickWatchList();
    		HPECommonFunctions.ClickAlerts();  
    		HPECommonFunctions.Find_Text(config.getProperty("Alerts_PageTitle"));
    		HPECommonFunctions.VerifyBackButton();
    		HPECommonFunctions.ClickBackButton(); 
    		
    		HPECommonFunctions.ClickSignOut();
    		HPECommonFunctions.Close_App_HPE();
    		
			HPECommonFunctions.screen();
		    System.out.println("Ending of TC_92_BackButtonFromAlertsPage");
		    HPECommonFunctions.screen();
		    
    }    


@Test(priority=17,groups={"Primary"},enabled=false)
public void TC_94_BackButtonFromOrderDetailScreen()throws Exception
{    	   	
	
	    HPECommonFunctions.screen();
		System.out.println("Starting of TC_94_BackButtonFromOrderDetailScreen");
		HPECommonFunctions.screen();
	    
	    HPECommonFunctions.Open_App_HPE();
		HPEOperations.Login_App();
		
		HPECommonFunctions.ClickWatchList();		
		HPECommonFunctions.ClickSearch(); 
		HPECommonFunctions.Find_Text(config.getProperty("Search_PageTitle"));
		HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword"));        
		HPECommonFunctions.ClickOnSearchIcon();		
		HPECommonFunctions.ClickOnSearchResult();		
				
		HPECommonFunctions.screen();
	    System.out.println("Ending of TC_94_BackButtonFromOrderDetailScreen");
	    HPECommonFunctions.screen();
	    
}

@Test(priority=18,groups={"Primary"},enabled=false)
public void TC_95_BackButtonFromRecentSearchesScreen()throws Exception
{    	   	
	
	    HPECommonFunctions.screen();
		System.out.println("Starting of TC_95_BackButtonFromRecentSearchesScreen");
		HPECommonFunctions.screen();
	    
	    HPECommonFunctions.Open_App_HPE();
		HPEOperations.Login_App();		 
		HPECommonFunctions.ClickWatchList();		
		HPECommonFunctions.ClickRecentSearches(); 		 		
		HPECommonFunctions.VerifyBackButton();
		HPECommonFunctions.ClickBackButton(); 
		HPECommonFunctions.ClickSignOut();
		HPECommonFunctions.Close_App_HPE();
		
		HPECommonFunctions.screen();
	    System.out.println("Ending of TC_95_BackButtonFromRecentSearchesScreen");
	    HPECommonFunctions.screen();
	    
}

  

@Test(priority=19,groups={"Primary","Secondary"},enabled=false)
public void TC_32_ValidateDeletionOfSearchFromRecentSearchesScreen()throws Exception
{             
       
              HPECommonFunctions.screen();
              System.out.println("Starting of TC_32_ValidateDeletionOfSearchFromRecentSearchesScreen");
              HPECommonFunctions.screen();
           
              HPECommonFunctions.Open_App_HPE();
           
              HPEOperations.Login_App();       
              HPECommonFunctions.ClickWatchList();
              HPECommonFunctions.ClickSearch();
              HPECommonFunctions.Find_Text(config.getProperty("Search_PageTitle"));
              HPECommonFunctions.ClickRecentSearches(); 
              HPECommonFunctions.Find_Text(config.getProperty("RecentSearch_PageTitle"));            
              HPECommonFunctions.ClickDeleteButton();
              HPECommonFunctions.ClickSignOut();
              HPECommonFunctions.Close_App_HPE();
              
              HPECommonFunctions.screen();
              System.out.println("Ending of TC_32_ValidateDeletionOfSearchFromRecentSearchesScreen");
              HPECommonFunctions.screen();
           
}



@Test(priority=20,groups={"Primary","Secondary"},enabled=false)
public void TC_17_ValidateAdvanceSearchFunctionality()throws Exception
{    	   	
	
	    HPECommonFunctions.screen();
		System.out.println("Starting of TC_17_ValidateAdvanceSearchFunctionality");
		HPECommonFunctions.screen();
	    
	    HPECommonFunctions.Open_App_HPE();
		HPEOperations.Login_App();		
		HPECommonFunctions.ClickWatchList(); 		
        HPECommonFunctions.ClickSearch();
        HPECommonFunctions.ClickAdvancedSearch();
		HPECommonFunctions.Find_Text(config.getProperty("Advanced_Search"));		
		HPECommonFunctions.ClickSignOut();
		HPECommonFunctions.Close_App_HPE();
		
		HPECommonFunctions.screen();
	    System.out.println("Ending of TC_17_ValidateAdvanceSearchFunctionality");
	    HPECommonFunctions.screen();
	    
}

@Test(priority=21,groups={"Primary","Secondary"},enabled=false)
public void TC_19_ValidateFilterIconFunctionality()throws Exception
{    	   	
	
	    HPECommonFunctions.screen();
		System.out.println("Starting of TC_19_ValidateFilterIconFunctionality");
		HPECommonFunctions.screen();
		 
	    HPECommonFunctions.Open_App_HPE();
		HPEOperations.Login_App();		
		HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword"));
        HPECommonFunctions.ClickOnSearchIcon();
        HPECommonFunctions.ClickFilterIcon();
        HPECommonFunctions.Find_Text(config.getProperty("Filter_Criteria"));
        HPECommonFunctions.ClickCloseIcon();
		HPECommonFunctions.ClickSignOut();
		HPECommonFunctions.Close_App_HPE();
		
		HPECommonFunctions.screen();
	    System.out.println("Ending of TC_19_ValidateFilterIconFunctionality");
	    HPECommonFunctions.screen();
	    
}

@Test(priority=22,groups={"Primary","Secondary"},enabled=false)
public void TC_55_CommonPageLayoutForAlerts()throws Exception
{    	   	
	
	    HPECommonFunctions.screen();
		System.out.println("Starting of TC_55_CommonPageLayoutForAlerts");
		HPECommonFunctions.screen();
	    
	    HPECommonFunctions.Open_App_HPE();
		HPEOperations.Login_App();       
        HPECommonFunctions.ClickWatchList();
        HPECommonFunctions.ClickAlerts();           
		HPECommonFunctions.Find_Text(config.getProperty("Alerts_PageTitle"));		
		HPECommonFunctions.ClickSignOut();
		HPECommonFunctions.Close_App_HPE();
		
		HPECommonFunctions.screen();
	    System.out.println("Ending of TC_55_CommonPageLayoutForAlerts");
	    HPECommonFunctions.screen();
	    
}

@Test(priority=23,groups={"Primary","Secondary"},enabled=false)
public void TC_16_ValidateBackArrowButton()throws Exception
{                
   
          HPECommonFunctions.screen();
          System.out.println("Starting of TC_16_ValidateBackArrowButton");
          HPECommonFunctions.screen();
       
          HPECommonFunctions.Open_App_HPE();
          HPEOperations.Login_App();
          HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword"));
          HPECommonFunctions.ClickOnSearchIcon();
          HPECommonFunctions.VerifySearchPage();
          //HPECommonFunctions.ClickOnBack();
          HPECommonFunctions.ClickBackButton();
          HPECommonFunctions.ClickSignOut();
          HPECommonFunctions.Close_App_HPE();

          HPECommonFunctions.screen();
          System.out.println("Ending of TC_16_ValidateBackArrowButton");
          HPECommonFunctions.screen();

   
}

@Test(priority=24,groups={"Primary","Secondary"},enabled=false)
public void TC_98_ValidateInvoiceAvailableDeliveredOrders()throws Exception
{                
   
          HPECommonFunctions.screen();
          System.out.println("Starting of TC_98_ValidateInvoiceAvailableDeliveredOrders");
          HPECommonFunctions.screen();          
         
          HPECommonFunctions.Open_App_HPE();   
          HPEOperations.Login_App();
          HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword"));          
          HPECommonFunctions.ClickOnSearchIcon();
          HPECommonFunctions.ClickFilterIcon();
          HPECommonFunctions.CheckDelivered();          
          HPECommonFunctions.ClickApply();          
          HPECommonFunctions.ClickOnSearchResult5();
          
    	  HPECommonFunctions.screen();
          System.out.println("Ending of TC_98_ValidateInvoiceAvailableDeliveredOrders");
          HPECommonFunctions.screen();

   
}

@Test(priority=25,groups={"Primary","Secondary"},enabled=false)
public void TC_18_ValidateSortIcon()throws Exception
{                
   
          HPECommonFunctions.screen();
          System.out.println("Starting of TC_18_ValidateSortIcon");
          HPECommonFunctions.screen();
          
          
          HPECommonFunctions.Open_App_HPE();
          HPEOperations.Login_App();
          HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword"));  
          HPECommonFunctions.ClickOnSearchIcon(); 
          HPECommonFunctions.Find_Text(config.getProperty("Search_PageTitle"));  
          HPECommonFunctions.ClickSortButton();
          HPECommonFunctions.ClickSignOut();
          HPECommonFunctions.Close_App_HPE();

          HPECommonFunctions.screen();
          System.out.println("Ending of TC_18_ValidateSortIcon");
          HPECommonFunctions.screen();

   
}

@Test(priority=26,groups={"Primary"},enabled=false)
public void TC_99_ValidateInvoiceDoesnotAvailableCancelledOrders()throws Exception
{                
   
          HPECommonFunctions.screen();
          System.out.println("Starting of TC_99_ValidateInvoiceDoesnotAvailableCancelledOrders");
          HPECommonFunctions.screen();
       
          HPECommonFunctions.Open_App_HPE();
          HPEOperations.Login_App();
          HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword"));          
          HPECommonFunctions.ClickOnSearchIcon();
          HPECommonFunctions.ClickFilterIcon();          
          HPECommonFunctions.CheckCancelled();
          HPECommonFunctions.ClickApply();          
          HPECommonFunctions.ClickOnSearchResult3();
          
	
            
          HPECommonFunctions.screen();
          System.out.println("Ending of TC_99_ValidateInvoiceDoesnotAvailableCancelledOrders");
          HPECommonFunctions.screen();

   
}


@Test(priority=27,groups={"Primary"},enabled=false)
public void TC_100_ValidateInvoiceDoesnotAvailableSubmittedOrders()throws Exception
{                
   
          HPECommonFunctions.screen();
          System.out.println("Starting of TC_100_ValidateInvoiceDoesnotAvailableSubmittedOrders");
          HPECommonFunctions.screen();
      
          HPECommonFunctions.Open_App_HPE();
          HPEOperations.Login_App();
          HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword"));          
          HPECommonFunctions.ClickOnSearchIcon();
          HPECommonFunctions.ClickFilterIcon();
          HPECommonFunctions.CheckSubmitted();
          HPECommonFunctions.ClickApply(); 
          
          HPECommonFunctions.ClickOnSearchResult3();  
         
          HPECommonFunctions.screen();
          System.out.println("Ending of TC_100_ValidateInvoiceDoesnotAvailableSubmittedOrders");
          HPECommonFunctions.screen();

   
}

@Test(priority=28,groups={"Primary"},enabled=false)
public void TC_101_ValidateInvoiceDoesnotAvailableAcceptedOrders()throws Exception
{                
   
          HPECommonFunctions.screen();
          System.out.println("Starting of TC_101_ValidateInvoiceDoesnotAvailableAcceptedOrders");
          HPECommonFunctions.screen();
       
          HPECommonFunctions.Open_App_HPE();
          HPEOperations.Login_App();
          HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword"));          
          HPECommonFunctions.ClickOnSearchIcon();
          HPECommonFunctions.ClickFilterIcon();
          HPECommonFunctions.CheckAccepted();
          HPECommonFunctions.ClickApply(); 
          
          HPECommonFunctions.ClickOnSearchResult3(); 

          HPECommonFunctions.screen();
          System.out.println("Ending of TC_101_ValidateInvoiceDoesnotAvailableAcceptedOrders");
          HPECommonFunctions.screen();

   
}

@Test(priority=29,groups={"Primary"},enabled=false)
public void TC_102_ValidateInvoiceDoesnotAvailableInProductionOrders()throws Exception
{                
   
          HPECommonFunctions.screen();
          System.out.println("Starting of TC_102_ValidateInvoiceDoesnotAvailableInProductionOrders");
          HPECommonFunctions.screen();
       
          HPECommonFunctions.Open_App_HPE();
          HPEOperations.Login_App();
          HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword"));          
          HPECommonFunctions.ClickOnSearchIcon();
          HPECommonFunctions.ClickFilterIcon();
          HPECommonFunctions.CheckInProduction();
          HPECommonFunctions.ClickApply(); 
          
          HPECommonFunctions.ClickOnSearchResult3(); 

          HPECommonFunctions.screen();
          System.out.println("Ending of TC_102_ValidateInvoiceDoesnotAvailableInProductionOrders");
          HPECommonFunctions.screen();

   
}

@Test(priority=30,groups={"Primary"},enabled=false)
public void TC_103_ValidateInvoiceDoesnotAvailableShippedOrders()throws Exception
{                
   
          HPECommonFunctions.screen();
          System.out.println("Starting of TC_103_ValidateInvoiceDoesnotAvailableShippedOrders");
          HPECommonFunctions.screen();
       
          HPECommonFunctions.Open_App_HPE();
          HPEOperations.Login_App();
          HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword"));          
          HPECommonFunctions.ClickOnSearchIcon();
          HPECommonFunctions.ClickFilterIcon();
          HPECommonFunctions.CheckShipped();
          HPECommonFunctions.ClickApply(); 
          
          HPECommonFunctions.ClickOnSearchResult3();  

          HPECommonFunctions.screen();
          System.out.println("Ending of TC_103_ValidateInvoiceDoesnotAvailableShippedOrders");
          HPECommonFunctions.screen();

   
}

@Test(priority=31,groups={"Primary"},enabled=false)
public void TC_104_ValidateInvoiceAvailableIsNotClickable()throws Exception
{                
   
          HPECommonFunctions.screen();
          System.out.println("Starting of TC_104_ValidateInvoiceAvailableIsNotClickable");
          HPECommonFunctions.screen();
       
          HPECommonFunctions.Open_App_HPE();
          HPEOperations.Login_App();
          HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword"));          
          HPECommonFunctions.ClickOnSearchIcon();
          HPECommonFunctions.ClickFilterIcon();
          HPECommonFunctions.CheckDelivered();
          HPECommonFunctions.ClickApply();            
          HPECommonFunctions.ClickOnSearchResult4();

          HPECommonFunctions.screen();
          System.out.println("Ending of TC_104_ValidateInvoiceAvailableIsNotClickable");
          HPECommonFunctions.screen();

   
}



@Test(priority=32,groups={"Primary"},enabled=false)
public void TC_116_ValidatetheMenuItems()throws Exception

{
     HPECommonFunctions.screen();
     System.out.println("Starting of TC_116_ValidatetheMenuItems");
     HPECommonFunctions.screen(); 
     
     HPECommonFunctions.Open_App_HPE();
     HPEOperations.Login_App();
     HPECommonFunctions.ClickMenuBar();     
     HPECommonFunctions.Find_Text(config.getProperty("Home"));
     HPECommonFunctions.Find_Text(config.getProperty("Preferences"));
     HPECommonFunctions.Find_Text(config.getProperty("GetSupport_Button"));
     HPECommonFunctions.Find_Text(config.getProperty("PrivacyStatement"));
     HPECommonFunctions.Find_Text(config.getProperty("SignOut_Button"));
     HPECommonFunctions.Find_Text(config.getProperty("TermsAndConditions"));     
     HPECommonFunctions.ClickSignOut1();
     HPECommonFunctions.Close_App_HPE();

     HPECommonFunctions.screen();
     System.out.println("Ending of TC_116_ValidatetheMenuItems");
     HPECommonFunctions.screen();


}

@Test(priority=33,groups={"Primary","Secondary"},enabled=false)
public void TC_117_MainMenuPages()throws Exception
{                
   
          HPECommonFunctions.screen();
          System.out.println("Starting of TC_117_MainMenuPages");
          HPECommonFunctions.screen();
       
          //HPECommonFunctions.Close_App_HPE();
          HPECommonFunctions.Open_App_HPE();
          HPEOperations.Login_App();
          HPECommonFunctions.ClickMenuBar();
          HPECommonFunctions.Find_Text(config.getProperty("Home"));
          HPECommonFunctions.ClickHome();
          HPECommonFunctions.ClickMenuBar();          
          HPECommonFunctions.Find_Text(config.getProperty("GetSupport_Button"));          
          HPECommonFunctions.ClickGetSupportOption();
          HPECommonFunctions.ClickMenuBar();
          //HPECommonFunctions.VerifyPreferenceMenuOption("C://HPE//FunctionalTesting//Images//GetSupport"+".png");
          HPECommonFunctions.Find_Text(config.getProperty("Preferences"));
          HPECommonFunctions.ClickPreference();
          HPECommonFunctions.ClickMenuBar();
          HPECommonFunctions.Find_Text(config.getProperty("PrivacyStatement"));
          //HPECommonFunctions.VerifyPrivacyStatment("C://HPE//FunctionalTesting//Images//PrivacyStatement"+".png");
          HPECommonFunctions.ClickPrivacyStatement();           
          HPECommonFunctions.ClickSignOut();
          HPECommonFunctions.Close_App_HPE();
          

          HPECommonFunctions.screen();
          System.out.println("Ending of TC_117_MainMenuPages");
          HPECommonFunctions.screen();

   
}

@Test(priority=34,groups={"Primary"},enabled=false)
public void TC_108_ValidateContactUS()throws Exception
{
		HPECommonFunctions.screen();
		System.out.println("Starting of TC_108_ValidateContactUS");
		HPECommonFunctions.screen();   
    
		HPECommonFunctions.Open_App_HPE();
        HPEOperations.Login_App();          
        HPECommonFunctions.ClickMenuBar();
        HPECommonFunctions.Find_Text(config.getProperty("GetSupport_Button"));
        HPECommonFunctions.ClickGetSupportOption();
        HPECommonFunctions.Find_Text(config.getProperty("ContactUs"));          
        HPECommonFunctions.ClickSignOut();
        HPECommonFunctions.Close_App_HPE();
        
        HPECommonFunctions.screen();
        System.out.println("Ending of TC_108_ValidateContactUS");
        HPECommonFunctions.screen();   
    
}


@Test(priority=35,groups={"Primary"},enabled=false)
public void TC_1_ValidateSearchResultPageInformation()throws Exception
{    	   	
	
	    HPECommonFunctions.screen();
		System.out.println("Starting of TC_1_ValidateSearchResultPageInformation");
		HPECommonFunctions.screen();
	    
	    HPECommonFunctions.Open_App_HPE();
		HPEOperations.Login_App();		
		HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword"));        
		HPECommonFunctions.ClickOnSearchIcon();
        HPECommonFunctions.VerifyFlagIcon();
        
        HPECommonFunctions.Find_Text(config.getProperty("HPEOrderNumber"));
        HPECommonFunctions.Find_Text(config.getProperty("PONumber"));
        HPECommonFunctions.Find_Text(config.getProperty("OrderStatus"));
        HPECommonFunctions.Find_Text(config.getProperty("ShipDate"));
        HPECommonFunctions.Find_Text_Previously(config.getProperty("Previously"));
        HPECommonFunctions.VerifyEndCustomerName();
        HPECommonFunctions.ClickSignOut();
        HPECommonFunctions.Close_App_HPE();
        
		HPECommonFunctions.screen();
	    System.out.println("Ending of TC_1_ValidateSearchResultPageInformation");
	    HPECommonFunctions.screen();
	    
}



@Test(priority=36,groups={"Primary","Secondary"},enabled=false)
public void TC_107_ValidateFAQsection()throws Exception
{
       HPECommonFunctions.screen();
     System.out.println("Starting of TC_107_ValidateFAQsection");
     HPECommonFunctions.screen();
     
     //HPECommonFunctions.Close_App_HPE();
     HPECommonFunctions.Open_App_HPE();
     
     HPEOperations.Login_App();
     HPECommonFunctions.ClickMenuBar();
     HPECommonFunctions.ClickGetSupportOption();
     HPECommonFunctions.Find_Text(config.getProperty("FAQ")); 
     HPECommonFunctions.Find_Text(config.getProperty("FAQtopic1"));  
     HPECommonFunctions.Find_Text(config.getProperty("FAQtopic2"));        
     HPECommonFunctions.ClickGeneralAppQuestions();
     HPECommonFunctions.Find_Text(config.getProperty("GeneralAppQuestions"));
     HPEOperations.CLickGeneralAppFirstQuestion();
     HPECommonFunctions.Find_Text(config.getProperty("GeneralAppFirstQuestion"));
     HPEOperations.CLickGeneralAppSecondQuestion();    
     //HPEOperations.ValidateCollapsing(); 
     HPECommonFunctions.ClickSignOut();
     HPECommonFunctions.Close_App_HPE();
     
     HPECommonFunctions.screen();
     System.out.println("Ending of TC_107_ValidateFAQsection");
     HPECommonFunctions.screen();
     
    
    }

@Test(priority=37,groups={"Primary","Secondary"},enabled=false)
public void TC_65_ValidatePoweredByHPEOSS()throws Exception
{
	
     HPECommonFunctions.screen();
     System.out.println("Starting of TC_65_ValidatePoweredByHPEOSS");
     HPECommonFunctions.screen();
     
     HPECommonFunctions.Open_App_HPE();
     HPEOperations.Login_App();     
     HPEOperations.ValidatePoweredByHPEOSS();
     HPECommonFunctions.ClickWatchList();
     HPECommonFunctions.ClickBackButton();
     HPEOperations.ValidatePoweredByHPEOSS();
     HPECommonFunctions.ClickSignOut();
    
     
     HPECommonFunctions.screen();
     System.out.println("Ending of TC_65_ValidatePoweredByHPEOSS");
     HPECommonFunctions.screen();
     
}


@Test(priority=38,groups={"Primary"},enabled=false)
public void TC_10_SearchResultnumberValidation()throws Exception{
       
       
     HPECommonFunctions.screen();
     System.out.println("Starting of TC_10_SearchResultnumberValidation");
     HPECommonFunctions.screen();
     
     HPECommonFunctions.Open_App_HPE();
     HPEOperations.Login_App();     
     HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword10"));
     HPECommonFunctions.ClickOnSearchIcon();     
     HPEOperations.SearchResultnumberValidation();
     HPECommonFunctions.ClickSignOut();
     HPECommonFunctions.Close_App_HPE();
     
     HPECommonFunctions.screen();
     System.out.println("Ending of TC_10_SearchResultnumberValidation");
     HPECommonFunctions.screen();
       
}

@Test(priority=39,groups={"Primary"},enabled=false)
public void TC_62_VerifyOrderDetailsfromWatchListpage()throws Exception{
       
       
     HPECommonFunctions.screen();
     System.out.println("Starting of TC_62_VerifyOrderDetailsfromWatchListpage");
     HPECommonFunctions.screen();

     HPECommonFunctions.Open_App_HPE();
     HPEOperations.Login_App();     
     HPECommonFunctions.ClickWatchList();     
     HPECommonFunctions.ClickWatchListResult2();
    
     HPECommonFunctions.screen();
     System.out.println("Ending of TC_62_VerifyOrderDetailsfromWatchListpage");
     HPECommonFunctions.screen();
       
}


@Test(priority=40,groups={"Primary"},enabled=false)
public void TC_15_ValidateClearIconSearchPage()throws Exception
{                
   
          HPECommonFunctions.screen();
          System.out.println("Starting of TC_15_ValidateClearIconSearchPage");
          HPECommonFunctions.screen();
       
          HPECommonFunctions.Open_App_HPE();
          HPEOperations.Login_App();
          HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword"));
          HPECommonFunctions.ClickOnSearchIcon();
          HPECommonFunctions.VerifySearchPage();          
          HPECommonFunctions.ClickOnClearIcon();
          HPECommonFunctions.ClickSignOut();
          HPECommonFunctions.Close_App_HPE();

          HPECommonFunctions.screen();
          System.out.println("Ending of TC_15_ValidateClearIconSearchPage");
          HPECommonFunctions.screen();

   
}

@Test(priority=41,groups={"Primary","Secondary"},enabled=false)
public void TC_14_ValidateSearchBarFunctionality()throws Exception
{                
   
          HPECommonFunctions.screen();
          System.out.println("Starting of TC_14_ValidateSearchBarFunctionality");
          HPECommonFunctions.screen();
       
          HPECommonFunctions.Open_App_HPE();
          HPEOperations.Login_App();
          HPECommonFunctions.EnterSearchKeyword(config.getProperty("SearchNoReturn_Keyword"));
          HPECommonFunctions.ClickOnSearchIcon();
          
          HPECommonFunctions.ClickOnClearIcon();
          HPECommonFunctions.Find_Text(config.getProperty("SearchTips"));
          HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword"));
          HPECommonFunctions.ClickOnSearchIcon();
          HPECommonFunctions.VerifySearchPage();
          //HPECommonFunctions.ValidateTipsToSearch(config.getProperty("SearchNoReturn_Keyword"));
          HPECommonFunctions.ClickSignOut();
          HPECommonFunctions.Close_App_HPE();

          HPECommonFunctions.screen();
          System.out.println("Ending of TC_14_ValidateSearchBarFunctionality");
          HPECommonFunctions.screen();
   
}


	
@Test(priority=42,groups={"Primary"},enabled=false)
public void TC_61_VerifyUIOrderDetailsPageFromWatchList()throws Exception
{
       
       
     	HPECommonFunctions.screen();
     	System.out.println("Starting of TC_61_VerifyUIOrderDetailsPageFromWatchList");
     	HPECommonFunctions.screen();
     	
     	HPECommonFunctions.Open_App_HPE();
     	HPEOperations.Login_App();     
     	HPECommonFunctions.ClickWatchList();
     	HPECommonFunctions.Find_Text(config.getProperty("WatchList_PageTitle"));     
     	HPECommonFunctions.ClickWatchListResult1();
     	

         HPECommonFunctions.screen();
         System.out.println("Ending of TC_61_VerifyUIOrderDetailsPageFromWatchList");
         HPECommonFunctions.screen();
       
}


@Test(priority=43,groups={"Primary"},enabled=false)
public void TC_8_ValidateSearchTips()throws Exception
{      
       HPECommonFunctions.screen();
       System.out.println("Starting of TC_8_ValidateSearchTips");
       HPECommonFunctions.screen();

       HPECommonFunctions.Open_App_HPE();
       HPEOperations.Login_App();
       HPECommonFunctions.EnterSearchKeyword(config.getProperty("SearchNoReturn_Keyword"));             
       HPECommonFunctions.ClickOnSearchIcon();       
       
       HPECommonFunctions.ClickOnClearIcon(); 
       HPECommonFunctions.Find_Text(config.getProperty("SearchTips"));    
       HPECommonFunctions.ClickSignOut();
       HPECommonFunctions.Close_App_HPE();
       
       HPECommonFunctions.screen();
       System.out.println("Ending of TC_8_ValidateSearchTips");
       HPECommonFunctions.screen();

    
}


@Test(priority=44,groups={"Primary"},enabled=false)
public void TC_60_VerifyBasicInfoOrderDetailsfromSearchPage()throws Exception{
       
       
     HPECommonFunctions.screen();
     System.out.println("Starting of TC_60_VerifyBasicInfoOrderDetailsfromSearchPage");
     HPECommonFunctions.screen();     
     
     HPECommonFunctions.Open_App_HPE();
     HPEOperations.Login_App();      
     HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword"));             
     HPECommonFunctions.ClickOnSearchIcon(); 
     HPECommonFunctions.ClickSearchResult1();     
     HPECommonFunctions.VerifyEndCustomerName();
     HPECommonFunctions.Find_Text(config.getProperty("HPEOrderNumber"));
     HPECommonFunctions.Find_Text(config.getProperty("PONumber"));
     HPECommonFunctions.Find_Text(config.getProperty("OrderStatus"));
     HPECommonFunctions.Find_Text(config.getProperty("ShipDate"));
     HPECommonFunctions.Find_Text_Previously(config.getProperty("Previously")); 
     HPECommonFunctions.ClickSignOut();
     HPECommonFunctions.Close_App_HPE();
     

     HPECommonFunctions.screen();
     System.out.println("Ending of TC_60_VerifyBasicInfoOrderDetailsfromSearchPage");
     HPECommonFunctions.screen();
       
}



@Test(priority=45,groups={"Primary","Secondary"},enabled=false)
public void TC_77_ValidateTermsAndConditionPageFromMenu()throws Exception
{      
       HPECommonFunctions.screen();
       System.out.println("Starting of TC_77_ValidateTermsAndConditionPageFromMenu");
       HPECommonFunctions.screen();
      
       //HPECommonFunctions.Close_App_HPE();
       HPECommonFunctions.Open_App_HPE();
       
       HPEOperations.Login_App();
       
       HPECommonFunctions.ClickMenuBar(); 
       HPECommonFunctions.ClickTermsAndConditions();       
       HPECommonFunctions.SwipeUp();
       HPECommonFunctions.SwipeUp();        
       HPECommonFunctions.ClickParagraph8();
       HPECommonFunctions.Find_Text(config.getProperty("HPE"));    
       HPECommonFunctions.Open_App_HPE();
       HPECommonFunctions.ClickSignOut1(); 
       HPECommonFunctions.Close_App_HPE();
       
       HPECommonFunctions.screen();
       System.out.println("Ending of TC_77_ValidateTermsAndConditionPageFromMenu");
       HPECommonFunctions.screen();
    
}

@Test(priority=46,groups={"Primary"},enabled=false)
public void TC_9_ValidateOrderSearchDateAndTime()throws Exception
{    	   	
	
	    HPECommonFunctions.screen();
		System.out.println("Starting of TC_9_ValidateOrderSearchDateAndTime");
		HPECommonFunctions.screen();
	    
	    HPECommonFunctions.Open_App_HPE();	    
		HPEOperations.Login_App();		
        HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword"));
        HPECommonFunctions.ClickOnSearchIcon();            
        HPECommonFunctions.VerifySearchPage(); 
        HPECommonFunctions.ClickRecentSearches();         
        HPECommonFunctions.VerifyRecentSearchDateTime();         
		HPECommonFunctions.ClickSignOut();
		HPECommonFunctions.Close_App_HPE();
		
		
		HPECommonFunctions.screen();
	    System.out.println("Ending of TC_9_ValidateOrderSearchDateAndTime");
	    HPECommonFunctions.screen();
	    
}


@Test(priority=47,groups={"Primary"},enabled=false)
public void TC_126_ValidateNumberOfOrdersWatchList()throws Exception
{    	   	
	
	    HPECommonFunctions.screen();
		System.out.println("Starting of TC_126_ValidateNumberOfOrdersWatchList");
		HPECommonFunctions.screen();	 
	
	    HPECommonFunctions.Open_App_HPE();
		HPEOperations.Login_App();		
		HPECommonFunctions.VerifyWatchListNumber();		 
		HPECommonFunctions.ClickSignOut();
		HPECommonFunctions.Close_App_HPE();

		HPECommonFunctions.screen();
	    System.out.println("Ending of TC_126_ValidateNumberOfOrdersWatchList");
	    HPECommonFunctions.screen();

	
}

@Test(priority=48,groups={"Primary"},enabled=false)
public void TC_127_ValidateOrdersAddedReflectWatchList()throws Exception
{    	   	
	
	    HPECommonFunctions.screen();
		System.out.println("Starting of TC_127_ValidateOrdersAddedReflectWatchList");
		HPECommonFunctions.screen();	    
		
	    HPECommonFunctions.Open_App_HPE();
		HPEOperations.Login_App();			
		HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword"));
        HPECommonFunctions.ClickOnSearchIcon();        
        HPECommonFunctions.ClickFilterIcon();
        //HPECommonFunctions.SelectingOrdersWithWhiteFlag();        
        HPECommonFunctions.CheckAccepted();
        HPECommonFunctions.ClickApply();
        HPECommonFunctions.ClickWhiteFlag();
        HPECommonFunctions.ClickSaveButton();
		HPECommonFunctions.Close_App_HPE();
	    HPECommonFunctions.Open_App_HPE();
		HPEOperations.Login_App();	
		HPECommonFunctions.VerifyWatchListNumber();	
		HPECommonFunctions.ClickSignOut();
		HPECommonFunctions.Close_App_HPE();

		HPECommonFunctions.screen();
	    System.out.println("Ending of TC_127_ValidateOrdersAddedReflectWatchList");
	    HPECommonFunctions.screen();
	
}

@Test(priority=49,groups={"Primary"},enabled=false)
public void TC_128_ValidateOrdersemovedReflectWatchList()throws Exception
{    	   	
	
	    HPECommonFunctions.screen();
		System.out.println("Starting of TC_128_ValidateOrdersemovedReflectWatchList");
		HPECommonFunctions.screen();
	    
	    HPECommonFunctions.Open_App_HPE();
		HPEOperations.Login_App();	
		HPECommonFunctions.ClickWatchList();
		HPECommonFunctions.ClickGreenFlag();
		//HPECommonFunctions.ClickWatchFlagIcon();		
		HPECommonFunctions.AlertPopUp_ClickRemove();
		HPECommonFunctions.Close_App_HPE();
	    HPECommonFunctions.Open_App_HPE();
		HPEOperations.Login_App();
		HPECommonFunctions.VerifyWatchListNumber();		 
		HPECommonFunctions.ClickSignOut();
		HPECommonFunctions.Close_App_HPE();
		 
		HPECommonFunctions.screen();
	    System.out.println("Ending of TC_128_ValidateOrdersemovedReflectWatchList");
	    HPECommonFunctions.screen();

	
}

@Test(priority=50,groups={"Primary","Secondary"},enabled=false)
public void TC_130_ValidateOrderElements()throws Exception{
        
        
        HPECommonFunctions.screen();
        System.out.println("Starting TC_130_ValidateOrderElements");
        HPECommonFunctions.screen();        

        HPECommonFunctions.Open_App_HPE();
        HPEOperations.Login_App();
        HPECommonFunctions.ClickMenuBar(); 
        HPECommonFunctions.VerifyMenuSlide();
        HPECommonFunctions.ClickHome();
        HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword54"));
        HPECommonFunctions.ClickOnSearchIcon();
        HPEOperations.firstOrderClick();
        //HPEOperations.OrderDetailsList(); 
        HPECommonFunctions.Find_Text(config.getProperty("HPEOrderNumber"));
        HPECommonFunctions.Find_Text(config.getProperty("PONumber"));
        HPECommonFunctions.Find_Text(config.getProperty("OrderStatus"));
        HPECommonFunctions.Find_Text(config.getProperty("ShipDate"));        
        HPECommonFunctions.ClickSignOut();
        HPECommonFunctions.Close_App_HPE();

        HPECommonFunctions.screen();
        System.out.println("Ending TC_130_ValidateOrderElements");
        HPECommonFunctions.screen();
        
}

@Test(priority=51,groups={"Primary"},enabled=false)
public void TC_33_ValidateOrderSearchDateAndTimeinSavedSearches()throws Exception

{               
        
            HPECommonFunctions.screen();
            System.out.println("Starting of TC_33_ValidateOrderSearchDateAndTimeinSavedSearches");
            HPECommonFunctions.screen();            
           
            HPECommonFunctions.Open_App_HPE();            
            HPEOperations.Login_App();              
            HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword"));
            HPECommonFunctions.ClickOnSearchIcon();            
            HPECommonFunctions.VerifySearchPage(); 
            HPECommonFunctions.ClickRecentSearches();         
            HPECommonFunctions.VerifyRecentSearchDateTime();         
            HPECommonFunctions.ClickSignOut(); 
            HPECommonFunctions.Close_App_HPE();
                
            HPECommonFunctions.screen();
            System.out.println("Ending of TC_33_ValidateOrderSearchDateAndTimeinSavedSearches");
            HPECommonFunctions.screen();
            
}


@Test(priority=52,groups={"Primary"},enabled=false)
public void TC_118_ValidateWatchListPopUpScreen()throws Exception{

	HPECommonFunctions.screen();
	System.out.println("Starting TC_118_ValidateWatchListPopUpScreen");
	HPECommonFunctions.screen();	
	
    HPECommonFunctions.Open_App_HPE();
	HPEOperations.Login_App();	
	HPECommonFunctions.ClickMenuBar();
	HPECommonFunctions.ClickHome();
	HPECommonFunctions.ClickWatchList();
	HPECommonFunctions.ClickWatchlistCancel();

	HPECommonFunctions.screen();
    System.out.println("Ending TC_118_ValidateWatchListPopUpScreen");
	HPECommonFunctions.screen();

}

@Test(priority=53,groups={"Primary"},enabled=false)
public void TC_23_ValidateDateOrdered()throws Exception
{
         HPECommonFunctions.screen();
         System.out.println("Starting of TC_23_ValidateDateOrdered");
         HPECommonFunctions.screen();
      
         HPECommonFunctions.Open_App_HPE();
         HPEOperations.Login_App();
         HPECommonFunctions.ClickWatchList();           
         HPECommonFunctions.ClickSearch();
       	 HPECommonFunctions.ClickAdvancedSearch();
         HPECommonFunctions.Find_Text(config.getProperty("Advanced_Search"));
         //HPECommonFunctions.ClickSearchAdvanceSearchBefore();        
         HPECommonFunctions.ClickOnDateOrdered();         
         HPECommonFunctions.ClickonDateOrderedStartDate();         
         HPECommonFunctions.ClickOnDateOrderedEnd();
         HPECommonFunctions.ClickonShippingEndDate();         
         Thread.sleep(1000);        
   		 HPECommonFunctions.ClickOnSearchButtonAfter();
         HPECommonFunctions.Find_Text(config.getProperty("Search_PageTitle"));          
         HPECommonFunctions.ClickSignOut();
         HPECommonFunctions.Close_App_HPE();

         HPECommonFunctions.screen();
         System.out.println("Ending of TC_23_ValidateDateOrdered");
         HPECommonFunctions.screen();

}

@Test(priority=54,groups={"Primary"},enabled=false)
public void TC_24_ValidateEstimatedShipCompleteDate()throws Exception
{
         HPECommonFunctions.screen();
         System.out.println("Starting of TC_24_ValidateEstimatedShipCompleteDate");
     	 HPECommonFunctions.screen();
     	 
      	 HPECommonFunctions.Open_App_HPE();
       	 HPEOperations.Login_App();
     	 HPECommonFunctions.ClickWatchList();            
     	 HPECommonFunctions.ClickSearch();
     	 HPECommonFunctions.ClickAdvancedSearch();
     	 HPECommonFunctions.Find_Text(config.getProperty("Advanced_Search"));
         //HPECommonFunctions.ClickSearchAdvanceSearchBefore();        
     	 HPECommonFunctions.ClickOnEstimatedShipDateCalendar();
		 HPECommonFunctions.ClickonDeliveryDate();
         HPECommonFunctions.ClickOnEstimatedEndDateCalendar();
         HPECommonFunctions.ClickonDeliveryEndDate();	
         HPECommonFunctions.ClickSearchButtonAfter();
         HPECommonFunctions.Find_Text(config.getProperty("Search_PageTitle"));          
         HPECommonFunctions.ClickSignOut();
         HPECommonFunctions.Close_App_HPE();

         HPECommonFunctions.screen();
         System.out.println("Ending of TC_24_ValidateEstimatedShipCompleteDate");
         HPECommonFunctions.screen();

}


@Test(priority=55,groups={"Primary"},enabled=false)
public void TC_22_ValidateHPEProductNumber()throws Exception
{
       		HPECommonFunctions.screen();
       		System.out.println("Starting of TC_22_ValidateHPEProductNumber");
       		HPECommonFunctions.screen();
       		
       		HPECommonFunctions.Open_App_HPE();
       		HPEOperations.Login_App();
       		HPECommonFunctions.ClickWatchList();          
       		HPECommonFunctions.ClickSearch();
       	    HPECommonFunctions.ClickAdvancedSearch();
       		HPECommonFunctions.Find_Text(config.getProperty("Advanced_Search"));
       		//HPECommonFunctions.ClickSearchAdvanceSearchBefore();
       		HPECommonFunctions.HPEProdcutNumber();
       	    HPECommonFunctions.ClickOnKeypadGoButton();
      		HPECommonFunctions.ClickOnSearchButtonAfter();
      		HPECommonFunctions.Find_Text(config.getProperty("Search_PageTitle"));        
      		HPECommonFunctions.ClickSignOut();
      		HPECommonFunctions.Close_App_HPE();			
       	
       		HPECommonFunctions.screen();
       		System.out.println("Ending of TC_22_ValidateHPEProductNumber");
       		HPECommonFunctions.screen();

}


@Test(priority=56,groups={"Primary","Secondary"},enabled=false)
public void TC_21_AdvanceSearchShipAddress()throws Exception
{
       		HPECommonFunctions.screen();
       		System.out.println("Starting of TC_21_AdvanceSearchShipAddress");
       		HPECommonFunctions.screen();
       		
       		
       		HPECommonFunctions.Open_App_HPE();
    		HPEOperations.Login_App();
       		HPECommonFunctions.ClickWatchList();          
       		HPECommonFunctions.ClickSearch();
      		HPECommonFunctions.ClickAdvancedSearch();
      		HPECommonFunctions.Find_Text(config.getProperty("Advanced_Search"));       		
      		HPECommonFunctions.ShippingAddress();
      	    HPECommonFunctions.ClickOnKeypadGoButton();
       		HPECommonFunctions.ClickOnSearchButtonAfter();
       		HPECommonFunctions.Find_Text(config.getProperty("Search_PageTitle"));          
       		HPECommonFunctions.ClickSignOut();
       		HPECommonFunctions.Close_App_HPE();

       		HPECommonFunctions.screen();
       		System.out.println("Ending of TC_21_AdvanceSearchShipAddress");
       		HPECommonFunctions.screen();

}


@Test(priority=57,groups={"Primary"},enabled=false)
public void TC_26_AdvanceSearchMultipleConditions()throws Exception
{
       		HPECommonFunctions.screen();
       		System.out.println("Starting of TC_26_AdvanceSearchMultipleConditions");
       		HPECommonFunctions.screen();
  
       		HPECommonFunctions.Open_App_HPE();
       		HPEOperations.Login_App();
       		HPECommonFunctions.ClickWatchList();           
       		HPECommonFunctions.ClickSearch();
       		HPECommonFunctions.ClickAdvancedSearch();
       		HPECommonFunctions.Find_Text(config.getProperty("Advanced_Search"));
       		//HPECommonFunctions.ClickSearchAdvanceSearchBefore();
       		HPECommonFunctions.HPEProdcutNumber(config.getProperty("HPEProductNumberSearch"));       		
       		HPECommonFunctions.ClickOnEstimatedShipDateCalendar();
   		    HPECommonFunctions.ClickonDeliveryDate();
            HPECommonFunctions.ClickOnEstimatedEndDateCalendar();
            HPECommonFunctions.ClickonDeliveryEndDate();            
       		HPECommonFunctions.ClickSearchButtonAfter();
       		HPECommonFunctions.Find_Text(config.getProperty("Search_PageTitle"));          
       		HPECommonFunctions.ClickSignOut();
       		HPECommonFunctions.Close_App_HPE();

       		HPECommonFunctions.screen();
       		System.out.println("Ending of TC_26_AdvanceSearchMultipleConditions");
       		HPECommonFunctions.screen();

}


@Test(priority=58,groups={"Primary"},enabled=false)
public void TC_20_AdvanceSearchEndCustomer()throws Exception
{
       		HPECommonFunctions.screen();
       		System.out.println("Starting of TC_20_AdvanceSearchEndCustomer");
       		HPECommonFunctions.screen();
       		
       		HPECommonFunctions.Open_App_HPE();
       		HPEOperations.Login_App();
       		HPECommonFunctions.ClickWatchList();       		
       		HPECommonFunctions.ClickSearch();
       		HPECommonFunctions.ClickAdvancedSearch();
       		HPECommonFunctions.Find_Text(config.getProperty("Advanced_Search"));
       		//HPECommonFunctions.ClickSearchAdvanceSearchBefore();       		
       		HPECommonFunctions.EnterCustomerName();       		
       		HPECommonFunctions.ClickOnKeypadGoButton();       		
      		HPECommonFunctions.ClickOnSearchButtonAfter();
       		HPECommonFunctions.Find_Text(config.getProperty("Search_PageTitle")); 
       		HPECommonFunctions.ClickSignOut();
       		HPECommonFunctions.Close_App_HPE();

       		HPECommonFunctions.screen();
       		System.out.println("Ending of TC_20_AdvanceSearchEndCustomer");
       		HPECommonFunctions.screen();

}


@Test(priority=59,groups={"Primary"},enabled=false)
public void TC_51_CheckWatchListPageAfterOrdersFlgged()throws Exception
{    	   	
	
	    	HPECommonFunctions.screen();
	    	System.out.println("Starting of TC_51_CheckWatchListPageAfterOrdersFlgged");
	    	HPECommonFunctions.screen();	
	    	
	    	
	    	HPECommonFunctions.Open_App_HPE();
	    	HPEOperations.Login_App();		
	    	HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword"));
	    	HPECommonFunctions.ClickOnSearchIcon();
	    	HPECommonFunctions.ClickFilterIcon();
	        HPECommonFunctions.CheckAccepted();
	        HPECommonFunctions.ClickApply();	          
	    	HPECommonFunctions.ClickWhiteFlag();
	    	HPECommonFunctions.ClickSaveButton();
	    	HPECommonFunctions.ClickWatchListOnToolbar();
	    	HPECommonFunctions.VerifyWatchListResults();	    	
	    	HPECommonFunctions.ClickSignOut();
	    	HPECommonFunctions.Close_App_HPE();
		
	    	HPECommonFunctions.screen();
	    	System.out.println("Ending of TC_51_CheckWatchListPageAfterOrdersFlgged");
	    	HPECommonFunctions.screen();
}

@Test(priority=60,groups={"Primary","Secondary"},enabled=false)
public void TC_35_ValidateUserPreferencesPage()throws Exception
{    	   	
	
	    	HPECommonFunctions.screen();
	    	System.out.println("Starting of TC_35_ValidateUserPreferencesPage");
	    	HPECommonFunctions.screen();	    
		
	    	HPECommonFunctions.Open_App_HPE();
	    	HPEOperations.Login_App();	
	    	
	    	HPECommonFunctions.ClickMenuBar();
	    	HPECommonFunctions.ClickPreference();	        
	    	HPECommonFunctions.Find_Text(config.getProperty("Country")); 
	    	HPECommonFunctions.Find_Text(config.getProperty("Email")); 
	    	//HPECommonFunctions.Find_Text(config.getProperty("Signout")); 
	    	HPECommonFunctions.Find_Text(config.getProperty("WatchListAlert1")); 
	    	HPECommonFunctions.Find_Text(config.getProperty("WatchListAlert2")); 
	    	HPECommonFunctions.Find_Text(config.getProperty("WatchListAlert3")); 
	    	HPECommonFunctions.Find_Text(config.getProperty("WatchListAlert4")); 
	    	//HPECommonFunctions.Find_Text(config.getProperty("KeepMeLoggedIn")); 
	    	//HPECommonFunctions.ClickPreferenceSignout();
	    	HPECommonFunctions.ClickSignOut();
	    	HPECommonFunctions.Close_App_HPE();
		
	    	HPECommonFunctions.screen();
	    	System.out.println("Ending of TC_35_ValidateUserPreferencesPage");
	    	HPECommonFunctions.screen();
}

@Test(priority=61,groups={"Primary"},enabled=false)
public void TC_50_CheckWatchListPageWhenNoOrdersFlgged()throws Exception
{    	   	
	
	    	HPECommonFunctions.screen();
	    	System.out.println("Starting of TC_50_CheckWatchListPageWhenNoOrdersFlgged");
	    	HPECommonFunctions.screen();	
	    	
	    	HPECommonFunctions.Open_App_HPE();
    		HPEOperations.Login_App(); 
    		HPECommonFunctions.ClickWatchList();    		
    		HPECommonFunctions.VerifyWatchListTips();    		
	    	//HPECommonFunctions.ClickSignOut();
	    	//HPECommonFunctions.Close_App_HPE();
		
	    	HPECommonFunctions.screen();
	    	System.out.println("Ending of TC_50_CheckWatchListPageWhenNoOrdersFlgged");
	    	HPECommonFunctions.screen();
}


@Test(priority=62,groups={"Primary"},enabled=false)
public void TC_27_ValidateCalendarArrows()throws Exception
{
       		 HPECommonFunctions.screen();
       		 System.out.println("Starting of TC_27_ValidateCalendarArrows");
       		 HPECommonFunctions.screen(); 
       		 
       		
       		 HPECommonFunctions.Open_App_HPE();
             HPEOperations.Login_App();
      		 HPECommonFunctions.ClickWatchList();         
      		 HPECommonFunctions.ClickSearch();	
      		 HPECommonFunctions.ClickAdvancedSearch();
			 HPECommonFunctions.Find_Text(config.getProperty("Advanced_Search"));
			 //HPECommonFunctions.ClickSearchAdvanceSearchBefore();
			 
			 HPECommonFunctions.ClickOnDateOrdered();
			 HPECommonFunctions.Find_Text(config.getProperty("CurrentMonth"));
			 HPECommonFunctions.ClickPreviousMonth();
			 
			 HPECommonFunctions.ClickNextMonth();
			 HPECommonFunctions.ClickNextMonth();
			 HPECommonFunctions.ClickPreviousMonth();
			 HPECommonFunctions.ClickonDateOrderedStartDate();

			 HPECommonFunctions.ClickOnDateOrderedEnd();
			 HPECommonFunctions.Find_Text(config.getProperty("CurrentMonth"));
			 HPECommonFunctions.ClickPreviousMonth();
			 HPECommonFunctions.ClickNextMonth();
			 HPECommonFunctions.ClickNextMonth();
			 HPECommonFunctions.ClickPreviousMonth();
			 
			 HPECommonFunctions.ClickonShippingEndDate();

			 HPECommonFunctions.ClickOnEstimatedShipDateCalendar();
			 HPECommonFunctions.Find_Text(config.getProperty("CurrentMonth"));
			 HPECommonFunctions.ClickPreviousMonth();
			 HPECommonFunctions.ClickNextMonth();
			 HPECommonFunctions.ClickNextMonth();
			 HPECommonFunctions.ClickPreviousMonth();
			 HPECommonFunctions.ClickonDeliveryDate();

			 HPECommonFunctions.ClickOnEstimatedEndDateCalendar();
			 HPECommonFunctions.Find_Text(config.getProperty("CurrentMonth"));
			 HPECommonFunctions.ClickPreviousMonth();
			 HPECommonFunctions.ClickNextMonth();
			 HPECommonFunctions.ClickNextMonth();
			 HPECommonFunctions.ClickPreviousMonth();
			 HPECommonFunctions.ClickonDeliveryEndDate();			 
	         
	         HPECommonFunctions.Find_Text(config.getProperty("Search_PageTitle"));
	         HPECommonFunctions.ClickSignOut();
	         HPECommonFunctions.Close_App_HPE();
	
	       	 HPECommonFunctions.screen();
	         System.out.println("Ending of TC_27_ValidateCalendarArrows");
	         HPECommonFunctions.screen();

}

@Test(priority=63,groups={"Primary","Secondary"},enabled=false)
public void TC_129_ValidateOrderDetails()throws Exception
{                
   
          HPECommonFunctions.screen();
          System.out.println("Starting of TC_129_ValidateOrderDetails");
          HPECommonFunctions.screen();
       
          HPECommonFunctions.Open_App_HPE();
          HPEOperations.Login_App();
          HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword"));             
          HPECommonFunctions.ClickOnSearchIcon();              
          //HPECommonFunctions.VerifySearchPage();
          HPECommonFunctions.Find_Text(config.getProperty("Search_PageTitle"));              
          HPECommonFunctions.ClickOnSearchResult();
        
          HPECommonFunctions.screen();
          System.out.println("Ending of TC_129_ValidateOrderDetails");
          HPECommonFunctions.screen();

}


@Test(priority=64,groups={"Primary"},enabled=false)
public void TC_57_VerifyLayoutCommonPageForSearch()throws Exception
{                
   
          HPECommonFunctions.screen();
          System.out.println("Starting of TC_57_VerifyLayoutCommonPageForSearch");
          HPECommonFunctions.screen();
          
          HPECommonFunctions.Open_App_HPE();
          HPEOperations.Login_App();
          HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword"));             
          HPECommonFunctions.ClickOnSearchIcon();              
          //HPECommonFunctions.VerifySearchPage();
          HPECommonFunctions.Find_Text(config.getProperty("Search_PageTitle"));              
          HPECommonFunctions.ClickSignOut();
          HPECommonFunctions.Close_App_HPE();

          HPECommonFunctions.screen();
          System.out.println("Ending of TC_57_VerifyLayoutCommonPageForSearch");
          HPECommonFunctions.screen();

}

@Test(priority=65,groups={"Primary"},enabled=false)
public void TC_58_VerifyLayoutCommonPageForWatchList()throws Exception
{                
   
          HPECommonFunctions.screen();
          System.out.println("Starting of TC_58_VerifyLayoutCommonPageForWatchList");
          HPECommonFunctions.screen();
       
          HPECommonFunctions.Open_App_HPE();
          HPEOperations.Login_App();
          HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword"));             
          HPECommonFunctions.ClickOnSearchIcon();              
          //HPECommonFunctions.VerifySearchPage();
          HPECommonFunctions.Find_Text(config.getProperty("Search_PageTitle"));              
          HPECommonFunctions.ClickWatchListOnToolbar();
          HPECommonFunctions.Find_Text(config.getProperty("WatchList_PageTitle"));  
          HPECommonFunctions.ClickSignOut();
          HPECommonFunctions.Close_App_HPE();

          HPECommonFunctions.screen();
          System.out.println("Ending of TC_58_VerifyLayoutCommonPageForWatchList");
          HPECommonFunctions.screen();

}

@Test(priority=66,groups={"Primary"},enabled=false)
public void TC_59_VerifyLayoutCommonPageForOrderDetailsPage()throws Exception
{                
   
          HPECommonFunctions.screen();
          System.out.println("Starting of TC_59_VerifyLayoutCommonPageForOrderDetailsPage");
          HPECommonFunctions.screen();

          HPECommonFunctions.Open_App_HPE();
          HPEOperations.Login_App();
          HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword59"));
          HPECommonFunctions.ClickOnSearchIcon();
          Thread.sleep(5000);
          HPECommonFunctions.firstOrderClick();          
          HPEOperations.odPageHeader();
          HPEOperations.VerifyodPageFooter();          
          HPECommonFunctions.VerifyBackButton();
          HPECommonFunctions.ClickBackButton();  
          HPECommonFunctions.firstOrderClick();
          HPECommonFunctions.VerifyMenuBar();
          HPECommonFunctions.ClickMenuBar();
          HPECommonFunctions.VerifyMenuSlide(); 
          HPECommonFunctions.ClickSignOut();
          HPECommonFunctions.Close_App_HPE();
          
          HPECommonFunctions.screen();
          System.out.println("Ending of TC_59_VerifyLayoutCommonPageForOrderDetailsPage");
          HPECommonFunctions.screen();

}

@Test(priority=67,groups={"Primary"},enabled=false)
public void TC_124_ValidateOrderAddedToWatchList()throws Exception
{                
   
          HPECommonFunctions.screen();
          System.out.println("Starting of TC_124_ValidateOrderAddedToWatchList");
          HPECommonFunctions.screen();
          
          HPECommonFunctions.Open_App_HPE();
          HPEOperations.Login_App();          
          HPECommonFunctions.ClickMenuBar();
  		  HPECommonFunctions.ClickHome();
  		  HPECommonFunctions.VerifyFlagIcon();  		  
          HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword"));          
          HPECommonFunctions.ClickOnSearchIcon(); 
          HPECommonFunctions.SelectingOrdersWithWhiteFlag();
          HPECommonFunctions.ClickSaveButton();
          HPECommonFunctions.ClickSignOut();
          HPECommonFunctions.Close_App_HPE();

          HPECommonFunctions.screen();
          System.out.println("Ending of TC_124_ValidateOrderAddedToWatchList");
          HPECommonFunctions.screen();

   
}

//No test Data, so Incomplete

@Test(priority=68,groups={"Primary"},enabled=false)
public void TC_3_ValidatingNoShippingDatesForCancelledOrders()throws Exception
{
	  HPECommonFunctions.screen();
	  System.out.println("Starting of TC_3_ValidatingNoShippingDatesForCancelledOrders");
	  HPECommonFunctions.screen();	  
	  
	  HPECommonFunctions.Open_App_HPE();
	  HPEOperations.Login_App();
	  HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword"));          
	  HPECommonFunctions.ClickOnSearchIcon();
	  HPECommonFunctions.ClickFilterIcon();
	  HPECommonFunctions.CheckCancelled();
	  HPECommonFunctions.ClickApply();          
	  HPECommonFunctions.ClickOnSearchResult2(); 
	  
	  HPECommonFunctions.screen();
	  System.out.println("Ending of TC_3_ValidatingNoShippingDatesForCancelledOrders");
	  HPECommonFunctions.screen();
	
}

@Test(priority=69,groups={"Primary"},enabled=false)
public void TC_2_ValidatingDateFormat()throws Exception{
	
	HPECommonFunctions.screen();
    System.out.println("Starting of TC_2_ValidatingDateFormat");
    HPECommonFunctions.screen();
    
    HPECommonFunctions.Open_App_HPE();
    HPEOperations.Login_App();
    HPECommonFunctions.ClickMenuBar();
    HPECommonFunctions.ClickPreference();
    //HPEOperations.Country();
    //HPECommonFunctions.Find_Text(config.getProperty("Country"));
    HPECommonFunctions.ClickBackButton();
    HPECommonFunctions.ClickHome();
    HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword"));          
    HPECommonFunctions.ClickOnSearchIcon();
    HPEOperations.firstOrderClick();     
    date=HPEOperations.GetDate();
    HPEOperations.ValidateDateFormat(date);    
    HPECommonFunctions.ClickSignOut();
    HPECommonFunctions.Close_App_HPE();

    HPECommonFunctions.screen();
    System.out.println("Ending TC_2_ValidatingDateFormat");
    HPECommonFunctions.screen();
    
}


@Test(priority=70,groups={"Primary"},enabled=false)
public void TC_56_ValidateLayoutofCommonPageSavedSearches()throws Exception{
	
	HPECommonFunctions.screen();
	System.out.println("Starting of TC_56_ValidateLayoutofCommonPageSavedSearches");
	HPECommonFunctions.screen();
		
	HPECommonFunctions.Open_App_HPE();
	HPEOperations.Login_App();	
	HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword56"));
	HPECommonFunctions.ClickOnSearchIcon();
	HPECommonFunctions.ClickRecentSearches();
	//HPEOperations.recentSearchesPageHeader();
	HPECommonFunctions.Find_Text(config.getProperty("RecentSearch_PageTitle"));            
	HPECommonFunctions.ClickSignOut();
	HPECommonFunctions.Close_App_HPE();
	
	HPECommonFunctions.screen();
    System.out.println("Ending TC_56_ValidateLayoutofCommonPageSavedSearches");
	HPECommonFunctions.screen();
}


@Test(priority=71,groups={"Primary","Secondary"},enabled=false)
public void TC_54_ValidateCommonPageFooterFunctionality()throws Exception{
	
	HPECommonFunctions.screen();
	System.out.println("Starting TC_54_ValidateCommonPageFooterFunctionality");
	HPECommonFunctions.screen();
	
	HPECommonFunctions.Open_App_HPE();
	HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword54"));
	HPECommonFunctions.ClickOnSearchIcon();	
	HPEOperations.VerifyodPageFooter();
	HPECommonFunctions.VerifySearchIconHighlight();
	HPECommonFunctions.ClickWatchListOnToolbar();
	HPECommonFunctions.VerifyWatchListIconHighlighted();
	HPECommonFunctions.ClickAlerts();
	HPECommonFunctions.VerifyAlertsIconHighlighted();
	HPECommonFunctions.ClickRecentSearches();
	HPECommonFunctions.VerifyRecentSearchesIconIconHighlighted();	
	HPECommonFunctions.ClickSignOut();
	HPECommonFunctions.Close_App_HPE();

	HPECommonFunctions.screen();	
    System.out.println("Ending TC_54_ValidateCommonPageFooterFunctionality");
	HPECommonFunctions.screen();
}

@Test(priority=72,groups={"Primary"},enabled=false)
public void TC_53_RemoveOrdersfromWatchlist()throws Exception{
	
	HPECommonFunctions.screen();
	System.out.println("Starting TC_53_RemoveOrdersfromWatchlist");
	HPECommonFunctions.screen();

	HPECommonFunctions.Open_App_HPE();
	HPEOperations.Login_App();	
	HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword54"));
	HPECommonFunctions.ClickOnSearchIcon();	
	HPECommonFunctions.ClickWhiteFlag();
    HPECommonFunctions.ClickSaveButton();
    HPECommonFunctions.ClickWatchListOnToolbar();
	HPECommonFunctions.ClickGreenFlag();
	HPECommonFunctions.AlertPopUp_ClickRemove();	
	HPECommonFunctions.ClickSignOut();
	HPECommonFunctions.Close_App_HPE();
	
	HPECommonFunctions.screen();
    System.out.println("Ending TC_53_RemoveOrdersfromWatchlist");
	HPECommonFunctions.screen();
}

@Test(priority=73,groups={"Primary"},enabled=false)
public void TC_31_ValidateSearchSavedInRecentSearches()throws Exception{
	HPECommonFunctions.screen();
	System.out.println("Starting TC_31_ValidateSearchSavedInRecentSearches");
	HPECommonFunctions.screen();
	
	HPECommonFunctions.Open_App_HPE();
	HPEOperations.Login_App();	
	HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword54"));
	HPECommonFunctions.ClickOnSearchIcon();	
	HPEOperations.ValidateSearchSaved();
	//HPECommonFunctions.ClickBackButton();
	//HPECommonFunctions.ClickAdvancedSearch();
	//HPEOperations.ValidateAdvanceSearchSaved();
	HPEOperations.ValidateRecentSearchCount();
	HPECommonFunctions.ClickSignOut();
	HPECommonFunctions.Close_App_HPE();
	
	HPECommonFunctions.screen();
    System.out.println("Ending TC_31_ValidateSearchSavedInRecentSearches");
	HPECommonFunctions.screen();

}

@Test(priority=74,groups={"Primary"},enabled=false)
public void TC_34_ValidateSearchUsingSavedSearches()throws Exception{
	
	HPECommonFunctions.screen();
	System.out.println("Starting TC_34_ValidateSearchUsingSavedSearches");
	HPECommonFunctions.screen();

	HPECommonFunctions.Open_App_HPE();
	HPEOperations.Login_App();	
	HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword54"));
	HPECommonFunctions.ClickOnSearchIcon();
	HPECommonFunctions.ClickRecentSearches();
	HPEOperations.ClickRecentSearchesfirstKeyword();
	HPECommonFunctions.Find_Text(config.getProperty("Search_PageTitle"));
	HPECommonFunctions.ClickSignOut();
	HPECommonFunctions.Close_App_HPE();
	
	HPECommonFunctions.screen();
    System.out.println("Ending TC_34_ValidateSearchUsingSavedSearches");
	HPECommonFunctions.screen();
}



@Test(priority=75,groups={"Primary"},enabled=false)
public void TC_28_Validate90daysinCalendar()throws Exception
{
   HPECommonFunctions.screen();
   System.out.println("Starting of TC_28_Validate90daysinCalendar");
   HPECommonFunctions.screen();
  
   HPECommonFunctions.Open_App_HPE();
   HPEOperations.Login_App();
   HPECommonFunctions.ClickWatchList();         
   HPECommonFunctions.ClickSearch();
   HPECommonFunctions.ClickAdvancedSearch();
   HPECommonFunctions.Find_Text(config.getProperty("Advanced_Search"));
   //HPECommonFunctions.ClickSearchAdvanceSearchBefore(); 
   HPECommonFunctions.NinetyDayValidationStart();
   HPECommonFunctions.NinetyDayValidationEnd();
   HPECommonFunctions.NinetyDayValidationForShipStart();
   HPECommonFunctions.NinetyDayValidationForShipEnd();                            
   HPECommonFunctions.Find_Text(config.getProperty("Search_PageTitle"));
   //HPECommonFunctions.ClickSignOut();
   HPECommonFunctions.Close_App_HPE();
       
   HPECommonFunctions.screen();
   System.out.println("Ending of TC_28_Validate90daysinCalendar");
   HPECommonFunctions.screen();

}


@Test(priority=76,groups={"Primary","Secondary"},enabled=false)
public void TC_7_ValidateClickFunctionOfWatchListFlag()throws Exception{
	
	HPECommonFunctions.screen();
	System.out.println("Starting TC_7_ValidateClickFunctionOfWatchListFlag");
	HPECommonFunctions.screen();
	
	HPECommonFunctions.Open_App_HPE();
	HPEOperations.Login_App();	
	HPECommonFunctions.EnterSearchKeyword(config.getProperty("Search_Keyword"));
	HPECommonFunctions.ClickOnSearchIcon();
    HPECommonFunctions.ClickWhiteFlag();
    HPECommonFunctions.ClickSaveButton();
    HPECommonFunctions.ClickWatchListOnToolbar();
    //HPEOperations.ClickOnWatchListhpeOrderNumber();
    HPECommonFunctions.ClickGreenFlag();
	HPECommonFunctions.AlertPopUp_ClickRemove();
	HPECommonFunctions.ClickSignOut();
	HPECommonFunctions.Close_App_HPE();
	
	
	HPECommonFunctions.screen();
    System.out.println("Ending TC_7_ValidateClickFunctionOfWatchListFlag");
	HPECommonFunctions.screen();
} 

@Test(priority=77,groups={"Primary"},enabled=false)
public void TC_29_ValidateAutoPopulateOfDateinAdvancedSearch()throws Exception{

	HPECommonFunctions.screen();
	System.out.println("Starting TC_29_ValidateAutoPopulateOfDateinAdvancedSearch");
	HPECommonFunctions.screen();	
	
	HPECommonFunctions.Open_App_HPE();
	HPEOperations.Login_App();
	HPECommonFunctions.ClickWatchList();
	HPECommonFunctions.ClickSearch();
	HPECommonFunctions.ClickAdvancedSearch();	
	HPEOperations.ValidateAutoPopulateOrderDateRange();	
	HPEOperations.ValidateAutoPopulateShipDateRange();
	
	HPECommonFunctions.ClickSignOut();
	HPECommonFunctions.Close_App_HPE();
	
	HPECommonFunctions.screen();
    System.out.println("Ending TC_29_ValidateAutoPopulateOfDateinAdvancedSearch");
	HPECommonFunctions.screen();

}







/*
@AfterClass()
public void afterClass() throws Exception
{
new ExcelReportGenerator();
ExcelReportGenerator.GenerateExcelReport("Report_.xlsx");
System.out.println("Report Generated");
}
*/
    
    

/*
public static void main(String[] args) throws Exception  {
	
	try {
		
		new ExcelReportGenerator();
		ExcelReportGenerator.GenerateExcelReport("Report.xlsx");
		//ExcelReportGenerator.refresh();
		
		
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
			catch(SAXException e)
			{
				e.printStackTrace();
			}
		 	catch(IOException e) 
		 	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		 	} 
		

}
*/

}






































