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

public class ParaBankLoanRequestPage {

	@FindBy(id = "amount")
	private WebElement amountField;

	@FindBy(id = "downPayment")
	private WebElement downPaymentField;

	@FindBy(id = "loanStatus")
	private WebElement loanStatusField;

	@FindBy(xpath = "//table/tbody/tr[td[1][normalize-space()=\"Loan Amount: $\"]]/td[2]/input")
	private WebElement field;

	@FindBy(xpath = "//table/tbody/tr[td[1][normalize-space()=\"Down Payment: $\"]]/td[2]/input")
	private WebElement field2;

	@FindBy(css = "input[value='Apply Now']")
	private WebElement applyNowButton;

	@FindBy(linkText = "Log Out")
	private WebElement logOutLink;

	private WebDriver driver;

	private static final int DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT = 10;

	private static final String[] TITLE_WORDS = { "ParaBank", "Loan", "Request" };

	public ParaBankLoanRequestPage(WebDriver driver) {
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

	public void setField(String text) {
		waitUntilClickable(field).clear();
		field.sendKeys(text);
	}

	public void setField2(String text) {
		waitUntilClickable(field2).clear();
		field2.sendKeys(text);
	}

	public void clickApplyNowButton() {
		waitUntilClickable(applyNowButton).click();
	}

	public void clickLogOutLink() {
		waitUntilClickable(logOutLink).click();
	}

	public void setAmountField(String text) {
		waitFor(amountField).clear();
		amountField.sendKeys(text);
	}

	public void setDownPaymentField(String text) {
		waitFor(downPaymentField).clear();
		downPaymentField.sendKeys(text);
	}

	public String getLoanStatusFieldText() {
		return waitFor(loanStatusField).getText();
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

}