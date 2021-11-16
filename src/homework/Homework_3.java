package homework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Homework_3 extends BaseClass{
    String baseUrl = " http://automationpractice.com/index.php";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void signIn(){
        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("xyz@gmail.com");
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("abc@123");
        driver.findElement(By.id("SubmitLogin")).click();
        String expectedMessage = "There is 1 error";
        WebElement message = driver.findElement(By.xpath("//p[contains(text(),'There is 1 error')]"));
        String actualMessage = message.getText();
        Assert.assertEquals("Incorrect Password", expectedMessage, actualMessage);
    }
    @After
    public void close(){
        closeBrowser();
    }
}
