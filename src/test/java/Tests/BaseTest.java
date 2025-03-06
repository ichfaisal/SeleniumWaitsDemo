package Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * BaseTest class - This class contains common setup and teardown methods and
 * launches the Automation Playground website before each test class.
 */
public class BaseTest {

	protected WebDriver wd;

	@BeforeClass
	public void setUp() {
		wd = new ChromeDriver(); // Launch browser once
		wd.manage().window().maximize(); // Maximize window
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Set implicit wait for all elements
		wd.get("https://play1.automationcamp.ir/"); // Open Automation Playground (only once)
	}
	
	
	/**
     * This method runs ONCE after all test methods in a class.
     * It closes the browser to free up resources.
     */
    @AfterClass
    public void tearDown() {
        if (wd != null) {
            wd.quit(); // Close browser once after all tests
        }
    }
}
