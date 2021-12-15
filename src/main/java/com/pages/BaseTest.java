package com.pages;



import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {
	
	public AppiumDriver<MobileElement> driver;
	public URL url;
	
	@BeforeTest
	public void setup() {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		//We can use below 2 code also
		//caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
		//caps.setCapability("platformName", "ANDROID");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "KIW-L22");
		caps.setCapability(MobileCapabilityType.UDID, "3UMDU17116001328");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		//If we are doing automation on native app then give the absolute path of apk here
		//caps.setCapability(MobileCapabilityType.APP, "");
		//caps.setCapability(MobileCapabilityType.BROWSER_VERSION, "");
		//caps.setCapability(MobileCapabilityType.BROWSER_VERSION, "91.0.4472");
		//caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		
		try {
			 url = new URL("http://127.0.0.1:4723/wd/hub");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver = new AppiumDriver<MobileElement>(url,caps);
		//driver = new AndroidDriver<MobileElement>(url,caps);
		//driver = new IOSDriver<MobileElement>(url,caps);
		
		
	}
	
	@Test
	public void sampletest() {
		System.out.println("This is sample test");
		
	}
	
	@AfterTest
	public void teardown() {
		System.out.println("This is teardown method");
	}
}
