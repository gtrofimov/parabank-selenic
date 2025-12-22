/**
 * 
 */
package com.parasoft.parabank.tests.page;

import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import java.util.Arrays;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParaBankOpenAccountPage {

	@FindBy(linkText = "13677")
	private WebElement link6;

	@FindBy(linkText = "13899")
	private WebElement link5;

	@FindBy(linkText = "13566")
	private WebElement link4;

	@FindBy(id = "fromAccountId")
	private WebElement fromAccountIdDropdown;

	@FindBy(xpath = "/descendant::p[normalize-space(.)='Your new account number: 13788']")
	private WebElement yourNewAccountNumber;

	@FindBy(linkText = "13788")
	private WebElement link3;

	@FindBy(linkText = "14121")
	private WebElement link;

	@FindBy(id = "newAccountId")
	//@FindBy(linkText = "13566")
	private WebElement link2;

	@FindBy(css = "input[value='Open New Account']")
	private WebElement openNewAccountButton;

	private WebDriver driver;

	private static final int DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT = 15;

	private static final String[] TITLE_WORDS = { "ParaBank", "Open", "Account" };

	public ParaBankOpenAccountPage(WebDriver driver) {
		this.driver = driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT));
		wait.ignoring(StaleElementReferenceException.class);
		Arrays.stream(TITLE_WORDS).forEach(word -> {
			wait.until(attributeContains(By.tagName("title"), "innerHTML", word));
		});
		PageFactory.initElements(driver, this);
	}

	private WebElement waitFor(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT));
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT));
		return wait.ignoring(ElementClickInterceptedException.class).until(webDriver -> {
			webElement.click();
			return webElement;
		});
	}

	public void clickOpenNewAccountButton() {
		click(openNewAccountButton);
	}

	public void clickLink2() {
		click(link2);
	}

	public void clickLink() {
		click(link);
	}

	public void selectFromAccountIdDropdown(String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT));
		wait.ignoring(StaleElementReferenceException.class);
		wait.until(
				webdriver -> new Select(fromAccountIdDropdown).getFirstSelectedOption().getText().trim().length() > 0);
		Select dropdown = new Select(fromAccountIdDropdown);
		dropdown.selectByVisibleText(text);
	}

	public void clickYourNewAccountNumber() {
		click(yourNewAccountNumber);
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

	public void clickLink6() {
		click(link6);
	}

}