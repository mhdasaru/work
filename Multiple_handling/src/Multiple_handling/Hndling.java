package Multiple_handling;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hndling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp");
		
		driver.findElement(By.xpath("//a[contains(text(),'Help')]")).click();
		
		Set<String>wind = driver.getWindowHandles();
		
		Iterator<String>itwind=wind.iterator();
		
		while(itwind.hasNext())
			
		{
			String wind1= itwind.next();
			String wind2= itwind.next();
			driver.switchTo().window(wind1);
			driver.findElement(By.name("firstName")).sendKeys("ashraf");
			Thread.sleep(3000);
			driver.switchTo().window(wind2);
			driver.findElement(By.name("q")).sendKeys("stc");
		}

	}

}
