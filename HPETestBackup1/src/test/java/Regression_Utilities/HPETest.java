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
	

@Test(priority=1,groups={"Primary","Secondary"},enabled=true)
public void TC_134_ValidateConnectivity()throws Exception
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

@Test(priority=2,groups={"Primary","Secondary"},enabled=true)
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
//HPECommonFunctions.Close_App_HPE(logger);

HPECommonFunctions.screen();
System.out.println("Ending of TC_134_ValidateErrorMessageForWrongUsername");
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






































