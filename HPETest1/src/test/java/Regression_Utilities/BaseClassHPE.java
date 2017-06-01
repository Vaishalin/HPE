package Regression_Utilities;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
/*
//import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
*/

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
//import org.testng.log4testng.Logger;
//import Regression_Utilities.XLS_Reader;
//import Report.ExcelReportGenerator;
import com.perfectomobile.selenium.MobileDriver;
import com.perfectomobile.selenium.api.IMobileDevice;
import com.perfectomobile.selenium.api.IMobileWebDriver;
import com.perfectomobile.selenium.options.MobileDeviceVital;
import org.apache.log4j.PropertyConfigurator;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;

//import datatable.XLS_Reader;
//import com.PerfectoLabUtils;


public class BaseClassHPE  
{
	
//declaring variables in the common method class file	
public static MobileDriver driver = null; //Interface for getting device,provides methods for uploading and downloading items to/from the media repository, downloading the execution report
public static IMobileDevice device = null; // interface provides methods for working with a device. A typical script gets a mobile device, opens it, works on the device and closes it.
public static FileInputStream fp=null;
public static FileInputStream fp1=null;
public static FileInputStream fp2=null;
public static Logger testLog = Logger.getLogger("debugLogger");
//public static Logger testLog = null;
public static FileInputStream file_Stream_OR=null;
public static Properties config=null;
public static Properties Android_Objects=null;
public static Properties iOS_Objects=null;
public static Properties App_Objects=null;
public static int status1=0;
public static IMobileWebDriver nativedriver=null;
public static IMobileWebDriver domdriver = null;
public static IMobileWebDriver visualdriver = null;
public static String Device_OS=null;
public static String Device_Model=null;
public static String Device_ID=null;
public static String AppName=null;
public static String Device_OS_Version=null;
public static int i;
//public static XLS_Reader datatable=null;
//public static XLS_Reader datatable1=null;

public static WebElement webElement1=null;
public static String DATA_SPLIT="\\|";


public static boolean loggedIn=false;

public static int RowNo=0;
public static WebElement Login_Fail=null;
public static String appname =null;

public static Logger logger = Logger.getLogger(BaseClassHPE.class);




@BeforeSuite(alwaysRun=true)

public static void loadDevice() throws Exception
{
	
	System.out.println("entering inside load device");
	driver = new MobileDriver();
	//Loading Configuration Property files
	config = new Properties();
	Android_Objects = new Properties();
	iOS_Objects = new Properties();
	fp = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//Libraries//config.properties");
    config.load(fp);
    
    fp1 = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//Libraries//Android_Objects.properties");
    Android_Objects.load(fp1);
    
    fp2 = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//Libraries//iOS_Objects.properties");
    iOS_Objects.load(fp2);
    
    //datatable1 = new XLS_Reader(System.getProperty("user.dir")+"//src//ExecutionBatches//iOS.xlsx");
    
    //Loading Log4J property files
    Properties logProperties = new Properties();
	logProperties.load(new FileInputStream(System.getProperty("user.dir") + "//src//test//java//Libraries//"+config.getProperty("log4j")));
	PropertyConfigurator.configure(logProperties);
	//testLog.info("Configuration file loaded");	

	

	if ((config.getProperty("device_iOS"))!=null)
    {
		System.out.println("entering inside load device1");
    //command to select whether AN or iOS device to be selected
			device=driver.getDevice(config.getProperty("device_iOS"));
    device.open();
    Thread.sleep(10000);
    
    Device_Model=device.getProperty("Model");       
    //testLog.info("Device Model is: "+Device_Model);
    Device_ID=device.getDeviceId();       
    //testLog.info("Device ID is: "+Device_ID);
    Device_OS=device.getProperty("OS");       
    //testLog.info("Device OS is: "+Device_OS);
    Device_OS_Version=device.getProperty("osVersion");       
    //testLog.info("Device OS Version is: "+Device_OS_Version);

    } else
    {
    	System.out.println("entering inside load device2");
    device=driver.getDevice(config.getProperty("device_AN"));
    device.open();
    Thread.sleep(10000);
    
    Device_Model=device.getProperty("Model");
	   System.out.println("Device Model: "+ Device_Model);
	   Device_ID=device.getDeviceId();
	   System.out.println("Device ID: "+ Device_ID);
	   
	  	    
    }

	Thread.sleep(10000);
	System.out.println("Opened the Device");
	Thread.sleep(10000);

	//Loading Object repository on the basis of device OS
String Device_OS=device.getProperty("os");
	
	String Device_Model=device.getProperty("Model");
	 //testLog.info("OS is:"+Device_OS);
	    
	    if ((Device_OS.equalsIgnoreCase("Android")||(Device_Model.equalsIgnoreCase("Smart Tab 4G"))))
	    	
	    {	
	    	Load_Properties_File_Android();
	    	
	    }
	    else if((Device_OS.equalsIgnoreCase("iOS")))
	    {
	    	Load_Properties_File_iOS();
	    
	    }    	    
	
}




private static List<MobileDeviceVital> ALL(String string) {
	// TODO Auto-generated method stub
	return null;
}

//loading the properties file for android(config.properties and OR.preoperties)
public static void Load_Properties_File_Android() throws IOException 
{		
		//loading OR.properties
	    //testLog.info(System.getProperty("user.dir") +"//src//Libraries//Android.properties");
	    App_Objects = new Properties();
	    file_Stream_OR = new FileInputStream(System.getProperty("user.dir") +"//src//test//java//Libraries//Android_Objects.properties");
	    App_Objects.load(file_Stream_OR);
		//testLog.info("OR Properties Loading success");
	}


//loading the properties file for iOS
public static void Load_Properties_File_iOS() throws IOException 
{		
		//loading OR.properties
		//testLog.info(System.getProperty("user.dir") +"//src//Libraries//iOS.properties");
		App_Objects = new Properties();
		file_Stream_OR = new FileInputStream(System.getProperty("user.dir") +"//src//test//java//Libraries//iOS_Objects.properties");
		App_Objects.load(file_Stream_OR);
	
	}



@AfterSuite(alwaysRun=true)
public void afterSuite() throws Exception
{ 
	//driver.quit();
	//System.out.println("Downloading Execution report");
	//PerfectoLabUtils.downloadReport(driver,"C:\\HPE\\");
	//Thread.sleep(10000);
	
	//new ExcelReportGenerator();
	//ExcelReportGenerator.GenerateExcelReport("Report.xlsx");
	//System.out.println("Report Generated");


}
				
}



































