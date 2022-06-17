/**
 * 
 */
package com.parasoft.parabank.tests;

import static com.parasoft.annotations.WorkItem.Type.*;

import com.parasoft.annotations.WorkItem;
import com.parasoft.parabank.tests.page.ParaBankAccountActivityPage;
import com.parasoft.parabank.tests.page.ParaBankAccountsOverviewPage;
import com.parasoft.parabank.tests.page.ParaBankBillPayPage;
import com.parasoft.parabank.tests.page.ParaBankBillPaymentCompletePage;
import com.parasoft.parabank.tests.page.ParaBankErrorPage;
import com.parasoft.parabank.tests.page.ParaBankLoanRequestPage;
import com.parasoft.parabank.tests.page.ParaBankOpenAccountPage;
import com.parasoft.parabank.tests.page.ParaBankTransferFundsPage;
import com.parasoft.parabank.tests.page.ParaBankWelcomeOnlineBankingPage;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RegressionTests {

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

	/**
	 * Name: RequestLoanTest
	 * Recording file: RequestLoanTest.json
	 *
	 * Parasoft recorded Selenium test on Wed Dec 08 2021 14:51:07 GMT-0800 (Pacific Standard Time)
	 */
	@Test
	@WorkItem(type = REQ, id = "PAR-222")
	public void testRequestLoanTest() throws Throwable {
		driver.get(System.getProperty("PARABANK_BASE_URL", PARABANK_BASE_URL) + "/parabank/index.htm?ConnType=JDBC");
	
		ParaBankWelcomeOnlineBankingPage paraBankWelcomeOnlineBankingPage = new ParaBankWelcomeOnlineBankingPage(
				driver);
		paraBankWelcomeOnlineBankingPage.setUsernameField("john");
		paraBankWelcomeOnlineBankingPage.setPasswordField("demo");
		paraBankWelcomeOnlineBankingPage.clickLogInButton();
	
		ParaBankAccountsOverviewPage paraBankAccountsOverviewPage = new ParaBankAccountsOverviewPage(driver);
		paraBankAccountsOverviewPage.clickRequestLoanLink();
	
		ParaBankLoanRequestPage paraBankLoanRequestPage = new ParaBankLoanRequestPage(driver);
		paraBankLoanRequestPage.setAmountField("1000");
		paraBankLoanRequestPage.setDownPaymentField("100");
		paraBankLoanRequestPage.clickApplyNowButton();
		assertEquals("Approved", paraBankLoanRequestPage.getLoanStatusFieldText());
	}

	/**
	 * Name: Parabank_Transfer_Funds
	 *
	 * Parasoft recorded Selenium test on Tue Nov 19 2019 06:21:36 GMT-0800 (Pacific Standard Time)
	 */
	@WorkItem(type=WorkItem.Type.REQ, id="PAR-221", url="https://jira-stage.parasoft.com/browse/PAR-221")
	@Test
	@Ignore
	public void testParabank_Transfer_Funds() throws Throwable {
		driver.get(System.getProperty("PARABANK_BASE_URL", PARABANK_BASE_URL) + "/parabank/");
	
		ParaBankErrorPage paraBankErrorPage = new ParaBankErrorPage(driver);
		paraBankErrorPage.setUsernameField("john");
	
		paraBankErrorPage.setPasswordField("demo");
	
		paraBankErrorPage.clickLogInButton();
	
		ParaBankAccountsOverviewPage paraBankAccountsOverviewPage = new ParaBankAccountsOverviewPage(driver);
		paraBankAccountsOverviewPage.clickTransferFundsLink();
	
		ParaBankTransferFundsPage paraBankTransferFundsPage = new ParaBankTransferFundsPage(driver);
		paraBankTransferFundsPage.setInputField("1");
	
		paraBankTransferFundsPage.clickFORM();
	
		paraBankTransferFundsPage.clickFORM();
	
		paraBankTransferFundsPage.selectFromAccountIdDropdown("12900");
	
		paraBankTransferFundsPage.selectNgUntouchedDropdown("13233");
	
		paraBankTransferFundsPage.clickTransferButton();
	
		paraBankTransferFundsPage.clickAccountsOverviewLink();
	
	}

}