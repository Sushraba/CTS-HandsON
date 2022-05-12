package Pages;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.google.common.io.Files;

import Base.Base;

public class ErrorCapture extends Base {

	By opt = By.xpath("//a[text()='For Enterprise']");
	By campus = By.xpath("/html/body/div[3]/div[1]/div[2]/ul[1]/li[12]/a");
	By fname = By.id("FirstName");
	By lname = By.id("LastName");
	By func = By.id("C4C_Job_Title__c");
	By title = By.id("Title");
	By email = By.id("Email");
	By phone = By.id("Phone");
	By comp = By.id("Company");
	By type = By.id("Institution_Type__c");
	By disc = By.id("Primary_Discipline__c");
	By country = By.id("Country");
	By submit = By.xpath("//button[text()='Submit']");

	public void error() throws InterruptedException, IOException {
		exttest = report.createTest("Display error during invalid Email Address. ");
		wait(30, opt);
		driver.findElement(opt).click();
		wait(30, campus);
		driver.findElement(campus).click();
		exttest.log(Status.PASS, "Moved to For Campus Successfully");
		driver.findElement(fname).sendKeys("Weber");
		driver.findElement(lname).sendKeys("Antoya");
		driver.findElement(title).sendKeys("Executive");
		driver.findElement(email).sendKeys("antoya.com");
		driver.findElement(phone).sendKeys("9876543210");
		driver.findElement(comp).sendKeys("Beetle");
		Select s2 = new Select(driver.findElement(type));
		s2.selectByVisibleText("Private University");
		Select s3 = new Select(driver.findElement(disc));
		s3.selectByVisibleText("Biochemical Engineering/Biotechnology");
		Select s4 = new Select(driver.findElement(country));
		s4.selectByVisibleText("India");
		driver.findElement(submit).click();
		Thread.sleep(2000);
		exttest.log(Status.PASS, "Data entered and submitted Successfully");
		TakesScreenshot capture = (TakesScreenshot) driver;
		File srcFile = capture.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir") + "/Screenshot/Error.png");
		Files.copy(srcFile, destFile);
		exttest.log(Status.PASS, "Screenshot taken Successfully");
		driver.close();
		System.out.println("Automation Completed Successfully");
		Thread.sleep(3000);
	}
}
