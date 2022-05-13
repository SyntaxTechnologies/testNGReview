package reviewClass01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class hardAndSoftAssertion {
    WebDriver driver;
    @BeforeMethod
    public void openbrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://alternativebrewing.com.au/blogs/coffee-guides/coffee-grinding-guide");
    }
//  
@Test    
    public void testTitle(){
//        /get the title from the webPage and store in a string
    SoftAssert soft=new SoftAssert();
    String actualTitle = driver.findElement(By.xpath("//h1[@class='page__title heading h1']")).getText();
    String expectedTitle="Coffee Grinding Guide 12";
//    Assert.assertEquals(actualTitle,expectedTitle);
    soft.assertEquals(actualTitle,expectedTitle);

    String title2 = driver.findElement(By.id("coffeefreshnessisfleetingHeader")).getText();
    String expectedTitle2 = "Coffee Freshness Is Fleeting";
    System.out.println("hello");
//    Assert.assertEquals( title2,expectedTitle2);
    soft.assertEquals(title2,expectedTitle2);
    soft.assertAll();

    }
}
