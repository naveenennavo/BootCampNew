package bootcampnewtests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UpdateIncident {

	public static void main(String[] args) throws InterruptedException {

		// Setting up property
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		// Declaring object for Chrome Driver
		ChromeDriver driver = new ChromeDriver();

		// Launch the URL
		driver.get("https://dev77567.service-now.com/");

		// Maximize the browser
		driver.manage().window().maximize();

		// Declaring Implicitly wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Switching into frame
		driver.switchTo().frame(driver.findElementByTagName("iframe"));

		// Declaring user name
		driver.findElementById("user_name").sendKeys("admin");

		// Declaring password
		driver.findElementById("user_password").sendKeys("India@123");

		// Click on login button
		driver.findElementById("sysverb_login").click();

		// apply wait
		Thread.sleep(6000);

		// Search for incidents in filter navigator and click
		driver.findElementByXPath("//span[text()='Service Desk']//following::div[text()='Incidents']").click();

		// Switching to frame
		driver.switchTo().frame("gsft_main");

		// Enter and search the existing created incident number
		driver.findElementByXPath("((//label[text()='Search'])[2]/following::input)[1]").sendKeys("INC0010005",
				Keys.ENTER);

		// Click on the search incident number
		driver.findElementByXPath("//td[contains(@class,'list_decoration_cell col-small')]/following-sibling::td[1]")
				.click();

		// Get the attribute of existing incident number
		String att = driver.findElementById("incident.number").getAttribute("value");
		System.out.println(att);

		// Set urgency to high
		WebElement urg = driver.findElementById("incident.urgency");
		Select uu = new Select(urg);
		uu.selectByIndex(0);

		// Select state as in progress
		WebElement sts = driver.findElementById("incident.state");
		Select ss = new Select(sts);
		ss.selectByValue("2");

		// Click on the update button
		driver.findElementById("sysverb_update").click();

		// Search for the updated existing incident number
		driver.findElementByXPath("((//label[text()='Search'])[2]/following::input)[1]").sendKeys("att", Keys.ENTER);

		// get text of displayed number
		String num = driver.findElementByXPath("(//tr[@data-list_id='incident']//td)[3]").getText();

		// verify whether the incident is updated
		String numb = driver.findElementByXPath("(//tr[@data-list_id='incident']//td)[3]").getText();
        if(numb.equals(num)) {
        	System.out.println("Incident is updated");
        }
        else {
			System.out.println("Error occured");
		}
        
        //close the browser
        driver.close();
	}

}
