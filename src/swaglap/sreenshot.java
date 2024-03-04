package swaglap;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class sreenshot {
	

	String websit = "https://www.google.com/";
	WebDriver driver = new ChromeDriver();
	@BeforeTest
	public void sutup() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));// when loke aproplem wait 3s
		driver.manage().window().maximize();
		driver.get(websit);
		
	}
	
	@Test() // 3shan ttnafth bl2ol
	public void Test() throws IOException {
	Date currentdate= new Date(0);
	String thenae=currentdate.toString().replace(":", "");
	TakesScreenshot src=((TakesScreenshot)driver);
	File srcfile=src.getScreenshotAs(OutputType.FILE);
	File destnation=new File("src/sreen/1"+thenae+".png");
	FileUtils.copyFile(srcfile, destnation);
//		Date currentDate= new Date(0);
//		String TheAcutalDate = currentDate.toString().replace(":", "-");
//
//		TakesScreenshot src = ((TakesScreenshot) driver) ; 
//		
//		File SrcFile = src.getScreenshotAs((OutputType.FILE));
//		
//		File Dest = new File("..//mypictures/"+TheAcutalDate+".png");
//		
//		FileUtils.copyFile (SrcFile,Dest); 
		
	}

@AfterTest
public void endTest() {
}
}