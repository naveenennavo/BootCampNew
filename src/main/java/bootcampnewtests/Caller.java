package bootcampnewtests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Caller {

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
				driver.findElementById("filter").sendKeys("Callers",Keys.ENTER);
				
				//wait
				Thread.sleep(6000);
				
				//Click on caller
				driver.findElementByXPath("//div[text()='Callers']").click();
				
				//Switch to frame
				driver.switchTo().frame("gsft_main");
				
				//Create new caller
				driver.findElementById("sysverb_new").click();
				
				//switch to default frame due to refresh of page
				driver.switchTo().defaultContent();
				
				//wait 
				Thread.sleep(4000);
				
				//Switch to frame
				driver.switchTo().frame("gsft_main");
				
				//Enter First name
				driver.findElementById("sys_user.first_name").sendKeys("Naveen");
				
				//Enter Last name
				driver.findElementById("sys_user.last_name").sendKeys("Elumalai");
				
				//Enter Title
				driver.findElementById("sys_user.title").sendKeys("Chief Executive Officer");

				
				//enter mobile phone
				driver.findElementById("sys_user.mobile_phone").sendKeys("7010309781");
				
				//Select submit form 
                driver.findElementByXPath("(//button[text()='Submit'])[2]").click();
                
                //Enter the value in search option
                driver.findElementByXPath("((//label[text()='Search'])[2]/following::input)[1]").sendKeys("naveen", Keys.ENTER);

                String tt = driver.findElementByXPath("(//a[@class='linked formlink'])[1]").getText();
                
               
                //check whether the caller is created or not
                
                String dd = driver.findElementByXPath("(//a[@class='linked formlink'])[1]").getText();
                if(dd.equals(tt)) {
                	System.out.println("Created");
                }
                else {
                	System.out.println("error occured");
                }
                //close the browser 
                driver.close();
	}}

