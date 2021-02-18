package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registration {

	public static final String URL = "http://webdriveruniversity.com/Contact-Us/contactus.html";
	public static final String FIRSTNAME_XPATH = "//*[@id=\"contact_form\"]/input[1]";
	
	public static void inputFirstname(WebDriver driver, String firstname) {
		driver.findElement(By.xpath(FIRSTNAME_XPATH)).sendKeys(firstname);
		
	}
	
	public static void inputLastname(WebDriver driver, String lastname) {
		driver.findElement(By.name("last_name")).sendKeys(lastname);
		
	}
	
	public static void inputEmail(WebDriver driver, String email) {
		driver.findElement(By.name("email")).sendKeys(email);
		
	}
	
	public static void inputComment(WebDriver driver, String comment) {
		driver.findElement(By.name("message")).sendKeys(comment);
		
	}
	
	public static void submit(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id=\"form_buttons\"]/input[2]")).click();
	}
	
}
