package Tests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * WaitsTests class - Contains Selenium test cases related to waiting
 * conditions.
 */
public class WaitsTests extends BaseTest {

	/**
	 * Test: Verify that an element becomes visible after clicking a button.
	 */
	@Test
	public void TestWaitToElementVisible() {
	    // Click on the "Wait Conditions" section to navigate to the test page
	    wd.findElement(By.xpath("//div[@class='card-header' and normalize-space(.)='Wait Conditions']//following-sibling::div/a"))
	      .click();

	    // Click the button that triggers the spinner (loader)
	    wd.findElement(By.id("invisibility_trigger")).click();

	    // Explicit Wait: Wait until the element with ID "spinner_gone" becomes visible
	    WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(15));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("spinner_gone")));

	    // Retrieve the text from the element that appears after the spinner disappears
	    String txt = wd.findElement(By.id("spinner_gone")).getText();

	    // Verify that the expected text is displayed
	    Assert.assertEquals(txt, "Thank God that spinner is gone!");
	}


}
