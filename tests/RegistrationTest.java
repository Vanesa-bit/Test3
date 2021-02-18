package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.Home;
import objects.Registration;

public class RegistrationTest {

	public static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Desk\\Desktop\\chromedriver\\ChromeDriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void testContactUsBtn() {
		driver.navigate().to(Home.URL);
		//Home.clickContactUsBtn(driver);
		String actual = driver.getCurrentUrl();
		String expected = Registration.URL;
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testRegForm() {

		File f = new File("data.xlsx");
		try {
			InputStream inp = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(inp);
			Sheet sheet = wb.getSheetAt(0); 
			
			SoftAssert sa = new SoftAssert();

			for (int i = 0; i < 4; i++) {

				Row row = sheet.getRow(i);

				Cell cell1 = row.getCell(0);
				Cell cell2 = row.getCell(1);
				Cell cell3 = row.getCell(2);
				Cell cell4 = row.getCell(3);

				String firstname = cell1.toString();
				String lastname = cell2.toString();
				String email = cell3.toString();
				String comment = cell4.toString();

				driver.navigate().to(Registration.URL);
				Registration.inputFirstname(driver, firstname);
				Registration.inputLastname(driver, lastname);
				Registration.inputEmail(driver, email);
				Registration.inputComment(driver, comment);
				Registration.submit(driver);

				String actual = driver.getCurrentUrl();
				String expected = "http://webdriveruniversity.com/Contact-Us/contact-form-thank-you.html";

				sa.assertEquals(actual, expected);
				
				

				
			}
			
			sa.assertAll();

			wb.close();

		} catch (IOException e) {
			System.out.println("Nije pronadjen fajl!");
			e.printStackTrace();
		}

	}

}