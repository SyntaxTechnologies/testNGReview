package reviewClass01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataDrivenTesting {
    WebDriver webDriver;
    @DataProvider(name="credentials")
    public Object [][] data(){
        Object [][] login ={
                {"unknown@codility.com","password","You shall not pass! Arr!"},
                {"unknowncodility.com","password","Enter a valid email"},
                {"","password","Email is required"},
                {"login@codility.com","","Password is required"}
        };
        return login;
    }
//validate for credentials
    @Test(dataProvider = "credentials")
    public void validateCredentials(String email, String password, String expectedMsg){
        WebElement Email = webDriver.findElement(By.id("email-input"));
        WebElement Password = webDriver.findElement(By.id("password-input"));
        WebElement loginBtn = webDriver.findElement(By.id("login-button"));
//        send the credentials
        Email.sendKeys(email);
        Password.sendKeys(password);
        loginBtn.click();
        WebElement actualMsg = webDriver.findElement(By.xpath("//div[@id='messages']/div"));
        String actualmessage = actualMsg.getText();

//        Assert and check
        Assert.assertEquals(actualmessage,expectedMsg);

    }
    
//    check for valid credenitals
    @Test 
    public void verifyCorrectCredentials(){
        WebElement Email = webDriver.findElement(By.id("email-input"));
        WebElement Password = webDriver.findElement(By.id("password-input"));
        WebElement loginBtn = webDriver.findElement(By.id("login-button"));
//        send the credentials
        Email.sendKeys("login@codility.com");
        Password.sendKeys("password");
        loginBtn.click();
        WebElement actualMsg = webDriver.findElement(By.xpath("//div[@class='message success']"));
        String actualmessage = actualMsg.getText();
        String expectedMsg = "Welcome to Codility";
//        Assert and check
        Assert.assertEquals(actualmessage,expectedMsg);
    }
    
//    check the visibility of the elements
    @Test
    public void Visibilityofelements(){
        WebElement email = webDriver.findElement(By.id("email-input"));
        WebElement password = webDriver.findElement(By.id("password-input"));
        boolean isEmailDisplayed = email.isDisplayed();
        boolean isPaswrdDisplayed = password.isDisplayed();
        Assert.assertTrue(isEmailDisplayed);
        Assert.assertTrue(isPaswrdDisplayed);
    }


    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");

    }
    @AfterMethod
    public  void closebrowser(){
        webDriver.quit();
    }
}
