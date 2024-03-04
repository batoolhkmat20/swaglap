package swaglap;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class teatSwag {

	String websit = "https://www.saucedemo.com/";
	WebDriver driver = new ChromeDriver();
	String username = "standard_user";
	String passwprd = "secret_sauce";

	@BeforeTest
	public void sutup() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));// when loke aproplem wait 3s
		driver.manage().window().maximize();
		driver.get(websit);
	}

	@Test(priority = 1) // 3shan ttnafth bl2ol
	public void TestLogin() {
		// driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(username);
		// driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(passwprd);
		// driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		WebElement usernam = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement batoun = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
	usernam.sendKeys(username);
	password.sendKeys(passwprd);
	batoun.click();
	WebElement welo = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
	Assert.assertEquals(welo.getText().contains("Products"), true,
			"this is to check if Welcome msg is there or no ");
//		String []user= {"batool","laaaa"};
//		String []pass= {"batool","laaaa"};
//		Random rand =new Random();
//		int ndomname=rand.nextInt(user.length);
//		int randompaa=rand.nextInt(pass.length);
//		usernam.sendKeys(user[ndomname]);
//		password.sendKeys(pass[randompaa]);
	}

	@Test(priority = 2, enabled = false)
	public void printname() {
		WebElement firstitem = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
		String itemfirst = firstitem.getText();
		System.out.print(itemfirst);

	}

	@Test(enabled = false)
	public void printallitem() {
		List<WebElement> allitem = driver.findElements(By.className("inventory_item_name"));
		for (int i = 0; i < allitem.size(); i++) {
			System.out.println(allitem.get(i).getText());

		}

	}

	@Test(priority = 3,enabled=false)
	public void addallitem() throws InterruptedException {
		// List<WebElement>
		// clicallitem=driver.findElements(By.className("btn_inventory"));
//	for(int i=0;i<clicallitem.size();i++)//add all item
//	{if(i%2==0)// add even odd number 2%!=0
		// clicallitem.get(i).click();

//		}
		// when i waent add item mohadd
		List<WebElement> clicallitem = driver.findElements(By.className("btn_inventory"));
		List<WebElement> itemnames = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> priceitem = driver.findElements(By.className("inventory_item_price"));

		String itemname;
		String itemprice;
		for (int i = 0; i < clicallitem.size(); i++) {
			itemname = itemnames.get(i).getText();
			itemprice = priceitem.get(i).getText();
			double theitempriceasdouble = Double.parseDouble(itemprice.replace("$", ""));//to conver string to double ans reblace $ to space
			double tax = .08;
			double pricraftertax = (theitempriceasdouble * tax)+theitempriceasdouble;
			if (itemname.contains("Bike") || itemname.contains("Backpack")) {
				clicallitem.get(i).click();
				System.out.println("the item" + itemname + "orgenal praice" + itemprice + "the price after tax is"
						+ pricraftertax);
			}
		}
	}

	@Test(priority = 5, enabled = false)
	public void removellitem() throws InterruptedException {
//		WebElement removeitem=driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]"));
//		removeitem.click();
		{
			List<WebElement> clicallitemremove = driver.findElements(By.className("btn_secondary"));
			for (int i = 0; i < clicallitemremove.size(); i++)// add all item

				clicallitemremove.get(i).click();
		}

	}

	@Test(priority = 6, enabled = false)

	public void addtocart() {
		WebElement addcard = driver.findElement(By.className("shopping_cart_link"));
		addcard.click();

	}

	@Test(priority = 7, enabled = false)

	public void shoping() {

		WebElement countinuo = driver.findElement(By.xpath("//*[@id=\"checkout\"]"));
		countinuo.click();
		WebElement firstname = driver.findElement(By.xpath("//*[@id=\"first-name\"]"));
		WebElement secoundname = driver.findElement(By.xpath("//*[@id=\"last-name\"]"));
		WebElement post = driver.findElement(By.xpath("//*[@id=\"postal-code\"]"));
		WebElement conn = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
		WebElement finsh = driver.findElement(By.xpath("//*[@id=\"finish\"]"));

		firstname.sendKeys("batool");
		secoundname.sendKeys("hikmat");
		post.sendKeys("2506");
		conn.click();
		finsh.click();
	}

	@AfterTest
	public void endTest() {
	}

}
