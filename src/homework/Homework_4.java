package homework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Homework_4 extends BaseClass{
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheText(){
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
        String expectedMessage = "Welcome Andrei";
        WebElement message = driver.findElement(By.xpath("//a[contains(text(),'Welcome')]"));
        String actualMessage = message.getText();
        Assert.assertEquals("Error - welcome message not displayed ", expectedMessage, actualMessage);
        driver.findElement(By.xpath("//a[@id='welcome']")).click();
        //driver.findElement(By.className("panelTrigger")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
        String expectedMessage1 = "LOGIN Panel";
        WebElement message1 = driver.findElement(By.xpath("//div[@id='logInPanelHeading']"));
        String actualMessage1 = message1.getText();
        Assert.assertEquals("Error - Incorrect message display", expectedMessage1, actualMessage1);
    }
    @After
    public void close(){
        closeBrowser();
    }
}
