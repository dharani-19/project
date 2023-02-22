package week3.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Amazon {
     public static void main(String[] args) throws IOException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
	    WebElement price=driver.findElement(By.xpath("//span[@class='a-price-whole']"));
	    String mobile=price.getText();
	    System.out.println(price);
	    WebElement rating = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-none a-spacing-top-micro']//div[@class='a-row a-size-small'])[1]"));
	    String mobile1=rating.getText();
	    System.out.println(rating);
	    driver.findElement(By.xpath("(//a[@class='a-link-normal s-no-outline'])[1]")).click();
	    Set<String> s1=driver.getWindowHandles();		
        Iterator<String> i1=s1.iterator();		
        		
        while(i1.hasNext())			
        {		
            String ChildWindow=i1.next();		
            	  
                    // Switching to Child window
                    driver.switchTo().window(ChildWindow);	                                                                                                           
                    driver.get("https://www.amazon.in/Renewed-OnePlus-Pro-5G-Storage/dp/B0BS74XLTB/ref=sr_1_1?keywords=oneplus+9+pro&qid=1677049599&sr=8-1");   
                    File scrmob = driver.getScreenshotAs(OutputType.FILE);
                    File dest = new File("/.snaps/img.png");
                    FileHandler.copy(scrmob, dest);
        }
        driver.findElement(By.name("submit.add-to-cart")).click();
        WebElement card=driver.findElement(By.xpath("//span[@class='a-price-whole']"));
        String rate=card.getText();
        System.out.println(rate);
        if(card.equals(rate)) {
        	System.out.println("correct");
        }else
        {
        	System.out.println("not correct");
        }
      
        
        
}
     }


	    