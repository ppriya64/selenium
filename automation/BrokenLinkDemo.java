package priya.demolocators;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkDemo {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Browser_Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		List<WebElement> all_links=driver.findElements(By.tagName("a"));
		System.out.println("No.of links="+all_links.size());//51
		
		int brokenlinks=0;
		
		for(WebElement links:all_links) {
			String url=links.getAttribute("href");
			if(url==null || url.isEmpty()) {
				System.out.println("Url is empty");
				continue;
			}
			URL link=new URL(url);
			try {
				HttpURLConnection con=(HttpURLConnection) link.openConnection();
				con.connect();
				if(con.getResponseCode()>=400) {
					System.out.println(con.getResponseCode()+"=is a broken link");
					brokenlinks++;
				}
				else {
					System.out.println(con.getResponseCode()+"=is a valid link");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
	}
}
