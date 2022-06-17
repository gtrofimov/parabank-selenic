/**
 * 
 */
package com.parasoft.parabank.tests.page;

import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParaBankAccountsOverviewPage {

	@FindBy(linkText = "Accounts Overview")
	private WebElement accountsOverviewLink;

	@FindBy(linkText = "54321")
	private WebElement link5;

	@FindBy(linkText = "13122")
	private WebElement link4;

	@FindBy(linkText = "13566")
	private WebElement link3;

	@FindBy(linkText = "Open New Account")
	private WebElement openNewAccountLink;

	@FindBy(linkText = "12900")
	private WebElement link;

	@FindBy(linkText = "12345")
	private WebElement link2;

	@FindBy(linkText = "Transfer Funds")
	private WebElement transferFundsLink;

	@FindBy(linkText = "Request Loan")
	private WebElement requestLoanLink;

	@FindBy(linkText = "Bill Pay")
	private WebElement billPayLink;

	private WebDriver driver;

	private static final int DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT = 10;

	private static final String[] TITLE_WORDS = { "ParaBank", "Accounts", "Overview" };

	public ParaBankAccountsOverviewPage(WebDriver driver) {
		this.driver = driver;
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
		Arrays.stream(TITLE_WORDS).forEach(word -> {
			wait.until(attributeContains(By.tagName("title"), "innerHTML", word));
		});
		PageFactory.initElements(driver, this);
	}

	private WebElement waitUntilClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
		return wait.until(elementToBeClickable(element));
	}

	public void clickBillPayLink() {
		waitUntilClickable(billPayLink).click();
	}

	public void clickRequestLoanLink() {
		waitUntilClickable(requestLoanLink).click();
	}

	public void clickTransferFundsLink() {
		waitUntilClickable(transferFundsLink).click();
	}

	public void clickLink() {
		click(link);
	}

	public void clickLink2() {
		click(link2);
	}

	private WebElement waitFor(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
		wait.ignoring(StaleElementReferenceException.class);
		return wait.until(elementToBeClickable(element));
	}

	private WebElement scrollTo(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
		return element;
	}

	protected WebElement click(WebElement element) {
		WebElement webElement = scrollTo(waitFor(element));
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
		return wait.ignoring(ElementClickInterceptedException.class).until(webDriver -> {
			webElement.click();
			return webElement;
		});
	}

	public void clickOpenNewAccountLink() {
		click(openNewAccountLink);
	}

	public void clickLink3() {
		click(link3);
	}

	public void clickLink4() {
		click(link4);
	}

	public void clickLink5() {
		click(link5);
	}

	public void clickAccountsOverviewLink() {
		click(accountsOverviewLink);
	}

}