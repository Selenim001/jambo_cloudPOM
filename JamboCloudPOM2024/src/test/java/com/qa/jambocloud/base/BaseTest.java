package com.qa.jambocloud.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.jambocloud.factory.Driverfactory;
import com.qa.jambocloud.pages.LoginPage;
import com.qa.jambocloud.pages.TasksPage;

public class BaseTest {
	
	Driverfactory df;
	WebDriver driver;
	protected Properties prop;
	protected LoginPage loginPage;
	protected TasksPage taskPage;

	
	@BeforeTest
	
	public void setUp() {
		df = new Driverfactory();
		prop = df.initProp();
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
