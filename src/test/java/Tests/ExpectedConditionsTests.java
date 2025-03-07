package Tests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * WaitsTests class - Contains Selenium test cases related to waiting
 * conditions.
 */
public class ExpectedConditionsTests extends BaseTest {

	/**
	 * Test: Verify that an element loader becomes Invisible after clicking a button.
	 */

	@Test
	public void TestWaitToElementIsInVisible() {
		// Click on the "Wait Conditions" section to navigate to the test page
		wd.findElement(By.xpath("//div[@class='card-header' and normalize-space(.)='Wait Conditions']//following-sibling::div/a"))
		.click();
		
		WebElement triggerButton = wd.findElement(By.id("invisibility_trigger"));
		
		// JavaScript se scroll karo element ke pass
		((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView({block: 'center'});", triggerButton);
		
		triggerButton.click();
		
		// Explicit Wait: Wait until the element with ID "spinner_gone" becomes visible
		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("invisibility_target")));
		
		// Retrieve the text from the element that appears after the spinner disappears
		String txt = wd.findElement(By.id("spinner_gone")).getText();
		
		// Verify that the expected text is displayed
		Assert.assertEquals(txt, "Thank God that spinner is gone!");
	}
	
	
	@Test
	public void TestWaitToElementIsVisible() {
	    // Locate the button that triggers the visibility test
	    WebElement triggerButton = wd.findElement(By.id("visibility_trigger"));

	    // Scroll to the button to ensure it’s in view before clicking (helps avoid hidden element issues)
	    ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView({block: 'center'});", triggerButton);

	    // Click the trigger button to start the process
	    triggerButton.click();

	    // Explicit Wait: Wait until the target element becomes visible and clickable
	    WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(15));
	    wait.until(ExpectedConditions.and(
	        ExpectedConditions.visibilityOfElementLocated(By.id("visibility_target")), // Wait until element is visible
	        ExpectedConditions.elementToBeClickable(By.id("visibility_target"))       // Wait until element is clickable
	    ));

	    // Locate the now-visible and clickable element
	    WebElement btn = wd.findElement(By.id("visibility_target"));

	    // Check if the button is displayed and enabled
	    boolean btnEnabled = btn.isDisplayed() && btn.isEnabled();

	    // Assertion: Verify that the button is indeed visible and clickable
	    Assert.assertTrue(btnEnabled, "The expected button did not appear or is not clickable!");
	}


}
