package com.w2a.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class LoginTest extends TestBase{
	
	@Test
	public void loginAsBankManager() throws InterruptedException {
		log.debug("Inside loginAsBankManager()");
		driver.findElement(By.xpath(OR.getProperty("BankManagerLoginXpathBtn"))).click();
		Assert.assertTrue(isElementisPresent(By.xpath(OR.getProperty("AddCustomerBtnXpath"))));
		Thread.sleep(3000);
	}
}
