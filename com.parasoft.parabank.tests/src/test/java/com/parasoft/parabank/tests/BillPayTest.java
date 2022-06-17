/**
 * 
 */
package com.parasoft.parabank.tests;

import static com.parasoft.annotations.WorkItem.Type.*;

import com.parasoft.annotations.WorkItem;
import com.parasoft.parabank.tests.page.ParaBankAccountsOverviewPage;
import com.parasoft.parabank.tests.page.ParaBankBillPayPage;
import com.parasoft.parabank.tests.page.ParaBankBillPaymentCompletePage;
import com.parasoft.parabank.tests.page.ParaBankWelcomeOnlineBankingPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BillPayTest {

	/**
	 * Parasoft auto generated base URL
	 * Use -DPARABANK_BASE_URL2=http://localhost:8080 from command line
	 * or use System.setProperty("PARABANK_BASE_URL2", "http://localhost:8080") to change base URL at run time.
	 */
	private static final String PARABANK_BASE_URL = "http://54.185.112.201:8090";

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
	 * Name: BillPayTest
	 * Recording file: BillPayTest.json
	 *
	 * Parasoft recorded Selenium test on Wed Oct 06 2021 17:39:20 GMT-0700 (Pacific Daylight Time)
	 */
	@Test
	@WorkItem(type = REQ, id = "PAR-219", url = "https://jira-stage.parasoft.com/browse/PAR-219")
	public void testBillPayTest() throws Throwable {
		driver.get(System.getProperty("PARABANK_BASE_URL", PARABANK_BASE_URL) + "/parabank/index.htm");

		ParaBankWelcomeOnlineBankingPage paraBankWelcomeOnlineBankingPage = new ParaBankWelcomeOnlineBankingPage(
				driver);
		paraBankWelcomeOnlineBankingPage.setUsernameField("john");
		paraBankWelcomeOnlineBankingPage.setPasswordField("demo");
		paraBankWelcomeOnlineBankingPage.clickLogInButton();

		ParaBankAccountsOverviewPage paraBankAccountsOverviewPage = new ParaBankAccountsOverviewPage(driver);
		paraBankAccountsOverviewPage.clickBillPayLink();

		ParaBankBillPayPage paraBankBillPayPage = new ParaBankBillPayPage(driver);
		paraBankBillPayPage.setPayeeNameField("Wilhelm");
		paraBankBillPayPage.clickWebElement2();
		paraBankBillPayPage.setPayeeAddressStreetField("101 E. Huntington Dr.");
		paraBankBillPayPage.setPayeeAddressCityField("Monrovia");
		paraBankBillPayPage.setPayeeAddressStateField("California");
		paraBankBillPayPage.setPayeeAddressZipCodeField("91016");
		paraBankBillPayPage.setPayeePhoneNumberField("6267391734");
		paraBankBillPayPage.clickForm();
		paraBankBillPayPage.setPayeeAccountNumberField("12345");
		paraBankBillPayPage.setVerifyAccountField("12345");
		paraBankBillPayPage.setAmountField("10");
		paraBankBillPayPage.clickSendPaymentButton();

		ParaBankBillPaymentCompletePage paraBankBillPaymentCompletePage = new ParaBankBillPaymentCompletePage(driver);
		paraBankBillPaymentCompletePage.clickAccountsOverviewLink();
	}

}