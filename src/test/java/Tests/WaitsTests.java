package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitsTests {
	
	@Test
	public void TestWaitToElementVisisble() {
		WebDriver wd = new ChromeDriver();

		wd.get("https://play1.automationcamp.ir/");
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		wd.findElement(By.xpath(
				"//div[@class='card-header' and normalize-space(.)='Wait Conditions']//following-sibling::div/a"))
				.click();

		wd.findElement(By.id("invisibility_trigger")).click();
		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("spinner_gone")));

		String txt = wd.findElement(By.id("spinner_gone")).getText();
		Assert.assertEquals(txt, "Thank God that spinner is gone!");

		try {
			Thread.sleep(Duration.ofSeconds(4));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wd.quit();

	}

	public static void main(String[] args) {
	}
}