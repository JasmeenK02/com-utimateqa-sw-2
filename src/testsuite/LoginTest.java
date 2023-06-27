package testsuite;
/**
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userShouldNavigateToLoginPageSuccessfully
 * * click on the ‘Sign In’ link
 * * Verify the text ‘Welcome Back!’
 * 2. verifyTheErrorMessage
 * * click on the ‘Sign In’ link
 * * Enter invalid username
 * * Enter invalid password
 * * Click on Login button
 * * Verify the error message ‘Invalid email
 * or password.’
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //find the 'Sign In' link and click on it
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        //Verify the text 'Welcome Back!'
        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//h2[@class = 'page__heading']")).getText();
        Assert.assertEquals("Welcome Back text does not match", expectedText, actualText);
    }
    @Test
    public void verifyTheErrorMessage(){
        // find the 'Sign In' link and click on it
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        //Enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("jasmeen144@gmail.com");
        //Enter invalid password
        driver.findElement(By.id("user[password]")).sendKeys("jk1234");
        //Click on Sign In button
        driver.findElement(By.xpath("//button[@class = 'button button-primary g-recaptcha']")).click();
        //Verify the error message ‘Invalid email or password.’
        String expectedMessage = "Invalid email or password.";
        String actualMessage = driver.findElement(By.xpath("//li[@class = 'form-error__list-item']")).getText();
        Assert.assertEquals("Error message not displayed", expectedMessage, actualMessage);

    }

    @After
    public void tearDown(){
        driver.quit();

    }


}
