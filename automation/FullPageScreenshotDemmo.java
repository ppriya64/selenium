package priya.demolocators;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FullPageScreenshotDemmo {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Browser_Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.nopcommerce.com/");	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Full Page ScreenShot
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(".\\screenshots\\homepage.png");
		FileUtils.copyFile(src,target);
		
		//screenshot of section/portion of page
		WebElement section=driver.findElement(By.xpath("//div[@class='product-grid- home-page-product-grid']"));
		File src1=section.getScreenshotAs(OutputType.FILE);
		File target1=new File(".\\screenshots\\Features.png");
		FileUtils.copyFile(src1,target1);
		
		//screenshot of particular WebElement
		WebElement ele=driver.findElement(By.xpath("//img[@alt='nopcommerce demo store']"));
		File src2=ele.getScreenshotAs(OutputType.FILE);
		File target2=new File(".\\screenshots\\Features.png");
		FileUtils.copyFile(src2,target2);	
		
		driver.close();	
		
	}

}
