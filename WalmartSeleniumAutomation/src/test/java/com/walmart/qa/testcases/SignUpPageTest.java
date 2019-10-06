package com.walmart.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.walmart.qa.base.TestBase;
import com.walmart.qa.pages.MyAccountPage;
import com.walmart.qa.pages.SignUpPage;
import com.walmart.qa.util.TestUtil;

public class SignUpPageTest extends TestBase {

	MyAccountPage myAccountPage;
	SignUpPage signUpPage;
	String sheetName = "Users";

	public SignUpPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		driver.findElement(By.xpath("//span[contains(text(),'Sign in')]")).click();
		signUpPage = new SignUpPage();

	}

	@Test(priority = 1)
	public void SignUpPageTitleTest() {
		String title = signUpPage.ValidateSignUpPageTitle();
		Assert.assertEquals(title, "Walmart Canada");
		System.out.println("equal" + title);
	}
	
	@DataProvider
	public Object[][] getUsersData() {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	
	@Test(priority = 2, dataProvider = "getUsersData")
	public void createAccountTest(String email,String firstName,String lastName, String password, String confirmPassword) {
		myAccountPage = signUpPage.CreateAccount(email,firstName, lastName, password, confirmPassword);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
