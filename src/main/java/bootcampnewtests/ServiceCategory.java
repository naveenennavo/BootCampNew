package bootcampnewtests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ServiceCategory {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		// Declaring object for Chrome driver
		ChromeDriver driver = new ChromeDriver();

		// Maximize window
		driver.manage().window().maximize();

		// add implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Launching URL
		driver.get("https://dev77567.service-now.com/");

		// Wait
		Thread.sleep(8000);

		// Switch to login frame
		driver.switchTo().frame(0);

		// entering user_name
		driver.findElementById("user_name").sendKeys("admin");

		// entering pass_word
		driver.findElementById("user_password").sendKeys("India@123");

		// Clicking Login button
		driver.findElementById("sysverb_login").click();

		// search for callers in filter
		driver.findElementById("filter").sendKeys("Service Catalog", Keys.ENTER);
		
		//wait 
		Thread.sleep(5000);
		
		//Select service catalog
		driver.findElementByXPath("(//div[@class='sn-widget-list-title'])[4]").click();

		// wait
		Thread.sleep(6000);

		// Switch to frame
		driver.switchTo().frame("gsft_main");
		
		//Clicking on mobile
		driver.findElementByXPath("//h2[text()[normalize-space()='Mobiles']]").click();
		
		//Selecting apple iphone 6s
		driver.findElementByXPath("//strong[text()='Apple iPhone 6s']").click();
		
		//Select monthly data allowances
		WebElement data = driver.findElementByXPath("(//select[@class='form-control cat_item_option '])[1]");
        Select dd = new Select(data);
        dd.selectByValue("unlimited");
        
        //Select color of iphone
        WebElement clr = driver.findElementByXPath("(//div[contains(@class,'col-xs-6 ')]//select)[2]");
        Select cl = new Select(clr);
        cl.selectByIndex(3);
        
        //Select the storage of the iphone
        WebElement str = driver.findElementByXPath("(//select[@class='form-control cat_item_option '])[3]");
	    Select rg = new Select(str);
	    rg.selectByVisibleText("128GB [add $50.00]");
	    
	    //order iphone
	    driver.findElementById("oi_order_now_button").click();
	    
	    // get attribute 
	    String reqnum = driver.findElementByXPath("(//a[@class='linked requestItemUrl'])[2]").getText();
	    System.out.println(reqnum);
	    
	    //Verify order
	    String verify = driver.findElementByXPath("(//a[@class='linked requestItemUrl'])[2]").getText();
	    if(verify.equals(reqnum)) {
	    	System.out.println("Order is placed");
	    }
	    else {
			System.out.println("error occured");
		}
	
	}
	
	

}
