package com.walmart.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.walmart.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'Hi')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//input[@type='text'and @class='e1xoeh2i1 css-150z6pi eesbt950']")
	WebElement searchClick;

	@FindBy(xpath = "//a[contains(text(),'Halloween')]")
	WebElement halloweenLink;

	@FindBy(xpath = "//a[contains(text(),'Thanksgiving')]")
	WebElement thanksgivingLink;

	@FindBy(xpath = "//a[contains(text(),'Clothing')]")
	WebElement clothingLink;

	// css-1pgwcoa e1xoeh2i2
	@FindBy(xpath = "//button[@type='submit' and @class='css-1pgwcoa e1xoeh2i2']")
	WebElement searchSubmitBtn;
	
	// Initializing the page objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public SearchPage clickOnSearch(){
		searchClick.click();
		searchClick.sendKeys("fruit");
		searchSubmitBtn.click();
		
		List pagination = driver.findElements(By.xpath("//a[@id='loadmore' and @class='page-select-list-btn']")); 
		// checkif pagination link exists 
		if(pagination .size()>0){ 
			System.out.println("pagination exists" + pagination .size()); 

			// click on pagination link 

			for(int i=0; i<pagination .size(); i++){ 
			((WebElement) pagination.get(i)).click(); 
			} 
			} else { 
			System.out.println("pagination not exists"); 
			} 
		
		Select rangeSelector = new Select(driver.findElement(By.xpath("//select[@class='page-select']")));  
		rangeSelector.selectByIndex(1);
		return new SearchPage();
	}

	public SearchPage sortByPrice() {
		searchClick.click();
		searchClick.sendKeys("fruit");
		searchSubmitBtn.click();
		driver.findElement(By.linkText("Price")).click();
		return new SearchPage();
		
	}
	
	public HalloweenPage clickOnHalloweenLink() {
		halloweenLink.click();
		return new HalloweenPage();
	}

	public ThanksGivingPage clickOnThanksGivingLink() {
		thanksgivingLink.click();
		return new ThanksGivingPage();
	}

	public ClothingPage clickOnClothingLink() {
		clothingLink.click();
		return new ClothingPage();
	}

	public void clickOnGender() {
		searchClick.click();
		searchClick.sendKeys("fruit");
		searchSubmitBtn.click();
		
		  driver.findElement(By.cssSelector("#rm-Price > button:nth-child(1) > span:nth-child(1)")).click();
		  System.out.println("done");
		 
		driver.findElement(By.cssSelector("#rmi-brand-id-3 > a:nth-child(1) > label:nth-child(2) > span:nth-child(2)")).click();
		System.out.println("done 11");
		
	
	}

}
