package com.qa.jambocloud.pages;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.jambocloud.utils.ElementUtil;
import com.qa.jambocloud.utils.TimeUtil;
import com.qa.jambocloud.constants.AppConstants;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	// Page Objects: By locators -> All By locator should be private
	
	private By EmailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	
	// 2. public constr... of the page
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		
	}
	
	public String getLoginPageURL() throws TimeoutException {
		String url = eleUtil.waitForURLContains(AppConstants.LOGIN_PAGE_FRACTION_URL, TimeUtil.DEFAULT_TIME);
		System.out.println("login page url : " + url);
		return url;
	}
		
	
	public TasksPage doLogin(String username,String pwd) {
		eleUtil.doActionSendKeysWithPause(EmailId, username, TimeUtil.DEFAULT_MEDIUM_TIME);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		return new TasksPage(driver);
	}

}
