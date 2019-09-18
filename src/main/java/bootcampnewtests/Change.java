package bootcampnewtests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Change {

	public static void main(String[] args) throws InterruptedException {
		//setting up property
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		//Declaring object for Chrome driver
		ChromeDriver driver = new ChromeDriver();
		
		//Maximize window
		driver.manage().window().maximize();
		
		//add implicit wait
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		//Launching URL
		driver.get("https://dev77567.service-now.com/");
		

		//Wait
		Thread.sleep(8000);
		
		//Switch to login frame
		driver.switchTo().frame(0);
		
		
		//entering user_name 
		driver.findElementById("user_name").sendKeys("admin");
		
		//entering pass_word
		driver.findElementById("user_password").sendKeys("India@123");
		
		//Clicking Login button
		driver.findElementById("sysverb_login").click();
		
		//search for callers in filter
		driver.findElementById("filter").sendKeys("Change",Keys.ENTER);
		
		//wait
		Thread.sleep(6000);
		
		//Switch to frame
		driver.switchTo().frame("gsft_main");
		
		//Select Normal
		driver.findElementByXPath("(//div[@class='container-fluid wizard-container']//a)[1]").click();
		
		//get number attribute
		String num = driver.findElementById("change_request.number").getAttribute("value");
		System.out.println(num);
		
		//Select category
		WebElement gg = driver.findElementById("change_request.category");
		Select dd = new Select(gg);
		dd.selectByValue("Software");
		
		//entering short description
		driver.findElementById("change_request.short_description").sendKeys("oracleand My SQL change");
		
		//Click the submit button
		driver.findElementByXPath("(//button[text()='Submit'])[2]").click();
		
		//Search for num 
		driver.findElementByXPath("//span[@class='sr-only']/following-sibling::input[1]").sendKeys(num,Keys.ENTER);
		
		// get text
		String txt = driver.findElementByXPath("//td[contains(@class,'list_decoration_cell col-small')]/following-sibling::td[1]").getText();
	
		//compare values
		String tt = driver.findElementByXPath("//td[contains(@class,'list_decoration_cell col-small')]/following-sibling::td[1]").getText();
		if(tt.equals(txt)) {
			System.out.println("Created");
		}
		else {
			System.out.println("Terminated");
		}
		

	}

}
