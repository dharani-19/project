package week3.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class nykaa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement ele = driver.findElement(By.xpath("//a[text()='brands']"));
        //Creating object of an Actions class
		Actions action = new Actions(driver);
        //Performing the mouse over action on the target element
		action.moveToElement(ele).perform();
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris",Keys.ENTER);
		driver.findElement(By.linkText("L'Oreal Paris")).click();
		driver.get("https://www.nykaa.com/brands/loreal-paris/c/595?ptype=brand&id=595&root=brand_menu,top_brands,L%27Oreal%20Paris");
	    // getTitle() to obtain page title
	    System.out.println("Page title is : " + driver.getTitle());
		driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
        driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
        driver.findElement(By.xpath("//span[text()='Category']")).click();
        driver.findElement(By.xpath("//span[text()='Hair']")).click();
        driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
        driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
        driver.findElement(By.xpath("//span[text()='Concern']")).click();
        driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
        WebElement filter = driver.findElement(By.xpath("//span[text()='Filters Applied']"));
        String product=filter.getText();
        if(filter.getText().contains(product)) {
        	System.out.println("Filters Applied");
        }	

	}

}
