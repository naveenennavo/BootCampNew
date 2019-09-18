package bootcampnewtests;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Article {

	public static void main(String[] args) throws InterruptedException {
		
		//setting up property
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		//Declaring object for Chrome driver
		ChromeDriver driver = new ChromeDriver();
	   
		//Maximize window
		driver.manage().window().maximize();
		
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
		
		//Selecting filter and entering the task to be done
		driver.findElementByXPath("//input[@id='filter']").sendKeys(" Knowledge",Keys.ENTER);
		
		//wait
		Thread.sleep(5000);
		
		//Click on knowledge
		driver.findElementByLinkText("Knowledge").click();
		
		
		// Switch to the frame
		driver.switchTo().frame("gsft_main");
		
		//wait
		Thread.sleep(10000);
		
		//Click on the article blue icon folder+
        driver.findElementByXPath("(//button[@type='button']//span)[3]").click();
        
        driver.switchTo().defaultContent();
        
        Thread.sleep(2000);
        
        // switching to new frame
        driver.switchTo().frame("gsft_main");
        
        
		
		//Select knowledge base
		driver.findElementByXPath("//button[@id='lookup.kb_knowledge.kb_knowledge_base']").click();
		
		//Switching to new window of knowledge base 
		Set<String> handles = driver.getWindowHandles();
		List<String> bb = new ArrayList<String>();
		bb.addAll(handles);
		System.out.println(driver.getTitle());
		driver.switchTo().window(bb.get(1));
		
		//wait 
		
		//Select Knowledge baseis
		driver.findElementByLinkText("IT").click();
		
		//Get back to actual window
		driver.switchTo().window(bb.get(0));
		
		// switching to new frame
        driver.switchTo().frame("gsft_main");
		
		Thread.sleep(6000);
		driver.findElementById("kb_knowledge.short_description").sendKeys("Selenium automation");
		
		//wait
		Thread.sleep(10000);
		
		//Updating Short description
		
		
		//Selecting drop down of Article type
		WebElement idd = driver.findElementById("kb_knowledge.article_type");
		Select dd = new Select(idd);
		dd.selectByIndex(0);
	   //dd.selectByValue("wiki");
	  //dd.selectByVisibleText("Wiki");
		
		
		//submit the article
		driver.findElementById("sysverb_insert").click();
		
		//close the browser
		driver.close();
		
		
		
	}

}