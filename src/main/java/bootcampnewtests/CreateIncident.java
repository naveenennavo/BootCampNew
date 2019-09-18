package bootcampnewtests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateIncident {

	public static void main(String[] args) throws InterruptedException {

		// Setting up property
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		// Declaring object for Chrome Driver
		ChromeDriver driver = new ChromeDriver();
		

		//Launch the URL
		driver.get("https://dev77567.service-now.com/");

        //Maximize the browser
		driver.manage().window().maximize();

		//Declaring Implicitly wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Switching into frame
		driver.switchTo().frame(driver.findElementByTagName("iframe"));

		//Declaring username 
		driver.findElementById("user_name").sendKeys("admin");
		
		//Declaring password
		driver.findElementById("user_password").sendKeys("India@123");
		
		//Click on login button
		driver.findElementById("sysverb_login").click();

		//apply wait
		Thread.sleep(6000);

		//Search for incidents in filter navigator and click
		driver.findElementByXPath("//span[text()='Service Desk']//following::div[text()='Incidents']").click();

		//Switching to Frame
		driver.switchTo().frame("gsft_main");

		//Create a new incident
		driver.findElementByXPath("//button[text()='New']").click();

		//Selecting caller id
		driver.findElementById("sys_display.incident.caller_id").sendKeys("Abraham Lincoln");

		//Getting attribute of incident number
		String incidentNumber = driver.findElementById("incident.number").getAttribute("value");
		System.out.println(incidentNumber);

		//enter short description
		driver.findElementById("incident.short_description").sendKeys("Hey Sevice Now!! This is Test Description");

		//click on the submit button
		driver.findElementByXPath("(//button[text()='Submit'])[2]").click();

		//Search for the incident number
		driver.findElementByXPath("((//label[text()='Search'])[2]/following::input)[1]").sendKeys(incidentNumber,
				Keys.ENTER);

		//verify whether the created incident is available or not
		String text = driver.findElementByXPath("//a[@class='linked formlink']").getText();
		if (text.equals(incidentNumber)) {
			System.out.println("created");
		} else {
			System.out.println("nope");
		}

	}

}
