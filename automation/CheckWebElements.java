package priya.demolocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckWebElements {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Browser_Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");		
		
		//isDisplayed(),isEnabled()
		
	/*	WebElement search_store=driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		System.out.println("Dispalyed Status="+search_store.isDisplayed());
		System.out.println("Enabled Status="+search_store.isEnabled());  */
		
		//isSelected()---radio buttons,checkboxes and dropdown
		
		driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
		
		WebElement male=driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female=driver.findElement(By.xpath("//input[@id='gender-female']"));
 
		//not seelcted any radio button
	   
		System.out.println("Male:"+male.isSelected());
		System.out.println("Female:"+female.isSelected());
		
		//After selecting male radio button
		male.click();
		Thread.sleep(2000);
		System.out.println("Male:"+male.isSelected());
		System.out.println("Female:"+female.isSelected());
		
		//After selecting female radio button
		female.click();
		Thread.sleep(2000);
		System.out.println("Male:"+male.isSelected());
		System.out.println("Female:"+female.isSelected());     		
	}

}
