/**
 * 
 */
package com.parasoft.parabank.tests;

import static com.parasoft.annotations.WorkItem.Type.*;
import static org.junit.Assert.assertEquals;

import com.parasoft.annotations.WorkItem;
import com.parasoft.parabank.tests.page.ParaBankAccountActivityPage;
import com.parasoft.parabank.tests.page.ParaBankAccountsOverviewPage;
import com.parasoft.parabank.tests.page.ParaBankOpenAccountPage;
import com.parasoft.parabank.tests.page.ParaBankWelcomeOnlineBankingPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateAccountTest {

	/**
	 * Parasoft auto generated base URL
	 * Use -DPARABANK_BASE_URL2=http://localhost:8080 from command line
	 * or use System.setProperty("PARABANK_BASE_URL2", "http://localhost:8080") to change base URL at run time.
	 */
	private static final String PARABANK_BASE_URL = "http://dev1.parasoft.com:8091";

	private WebDriver driver;

	@Before
	public void beforeTest() {
		ChromeOptions opts = new ChromeOptions();
		opts.addArguments("--start-maximized");
		opts.addArguments("--disable-geolocation");
		opts.addArguments("--incognito");
		opts.addArguments("--enable-strict-powerful-feature-restrictions");
		driver = new ChromeDriver(opts);
		driver.manage().window().maximize();
	}

	@After
	public void afterTest() {
		if (driver != null) {
			driver.quit();
		}
	}

	/**
	 * Name: CreateAccountDemo
	 * Recording file: CreateAccountDemo (1).json
	 *
	 * Parasoft recorded Selenium test on Thu Dec 09 2021 14:24:16 GMT-0800 (Pacific Standard Time)
	 */
	@Test
	@WorkItem(type = REQ, id = "PAR-220")
	public void testCreateAccountDemo() throws Throwable {
		driver.get(System.getProperty("PARABANK_BASE_URL", PARABANK_BASE_URL) + "/parabank/index.htm?ConnType=JDBC");

		ParaBankWelcomeOnlineBankingPage paraBankWelcomeOnlineBankingPage = new ParaBankWelcomeOnlineBankingPage(
				driver);
		paraBankWelcomeOnlineBankingPage.setUsernameField("john");
		paraBankWelcomeOnlineBankingPage.setPasswordField("demo");
		paraBankWelcomeOnlineBankingPage.clickLogInButton();

		ParaBankAccountsOverviewPage paraBankAccountsOverviewPage = new ParaBankAccountsOverviewPage(driver);
		paraBankAccountsOverviewPage.clickOpenNewAccountLink();

		ParaBankOpenAccountPage paraBankOpenAccountPage = new ParaBankOpenAccountPage(driver);
		paraBankOpenAccountPage.selectFromAccountIdDropdown("12789");
		paraBankOpenAccountPage.clickOpenNewAccountButton();
		paraBankOpenAccountPage.clickLink2();

		ParaBankAccountActivityPage paraBankAccountActivityPage = new ParaBankAccountActivityPage(driver);
		assertEquals("$100.00", paraBankAccountActivityPage.getAvailableBalanceFieldText());
		paraBankAccountActivityPage.clickAccountsOverviewLink();
	}

}