package Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import Base.Base;

public class LangLearn extends Base {
	By search = By.xpath(
			"//*[@id=\"rendered-content\"]/div/header/div/div/div/div[1]/div[3]/div/form/div/div/div[1]/div[1]/input");
	By button = By.xpath(
			"//*[@id=\"rendered-content\"]/div/header/div/div/div/div[1]/div[3]/div/form/div/div/div[1]/button[2]/div");
	By lang = By.xpath("//div[text()='Language']");
	By show = By.xpath("//button[text()='Show All']");
	By langs = By.xpath("//*[@id=\"main\"]/div/div[2]/div/div[2]/div[1]/div/div[3]/div/div[3]/div[2]/div/div/button");
	By close = By.xpath("//*[@id=\"main\"]/div/div[2]/div/div[2]/div[1]/div/div[3]/div/div[3]/div[3]/a");
	By label = By.xpath("//*[@class=\"rc-SearchFilterOption\"]");
	By level = By.xpath("//div[text()='Level']");

	public void learningLang() throws InterruptedException, IOException {
		exttest = report.createTest("Extract all languages and levels with counts for Learning Language. ");
		wait(30, search);
		driver.findElement(search).sendKeys("Learning Language");
		driver.findElement(button).click();
		driver.findElement(lang).click();
		driver.findElement(show).click();
		System.out.println("The languages are: ");
		List<WebElement> langsall = driver.findElements(langs);
		for (int j = 0; j < langsall.size(); ++j) {
			System.out.println(langsall.get(j).getText());
		}
		driver.findElement(close).click();
		wait(30, level);
		driver.findElement(level).click();
		exttest.log(Status.PASS, "All Languages are extracted Successfully");
		System.out.println("The levels are: ");
		List<WebElement> labels = driver.findElements(label);
		for (int j = 0; j < labels.size(); ++j) {
			System.out.println(labels.get(j).getText());
		}
		exttest.log(Status.PASS, "All levels are extracted Successfully");
		Thread.sleep(3000);
	}
}
