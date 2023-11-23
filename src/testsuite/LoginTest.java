package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * userShouldLoginSuccessfullyWithValid
 * Credentials()
 * * Click on ‘Sign In’ link
 * * Enter valid Email
 * * Enter valid Password
 * * Click on ‘Sign In’ button
 * * Verify the ‘Welcome’ text is display
 * <p>
 * 2. verifyTheErrorMessageWithInvalidCredentials
 * * Click on ‘Sign In’ link
 * * Enter valid Email
 * * Enter valid Password
 * * Click on ‘Sign In’ button
 * * Verify the error message ‘The account sign-in was
 * incorrect or your account is disabled temporarily. Please wait and try again
 * later.’
 * 3. userShouldLogOutSuccessfully
 * * Click on ‘Sign In’ link
 * * Enter valid Email
 * * Enter valid Password
 * * Click on ‘Sign In’ button
 * * Verify the ‘Welcome’ text is display
 * * Click on down aero near Welcome
 * * Click on Sign Out link
 * * Verify the text ‘You are signed out’
 */
public class LoginTest extends BaseTest {

    static String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {
        //Click on ‘Sign In’ link
        driver.findElement(By.xpath("//div[@class='panel header']//li[@class='authorization-link']")).click();
        //Enter Valid Email Address in Email Address field
        driver.findElement(By.xpath("//input[starts-with(@id,'email')]")).sendKeys("geetajoshi6@gmail.com");
        //Enter valid Password in Password field
        driver.findElement(By.id("pass")).sendKeys("1234A!12");
        //Click on ‘Sign In’ button
        driver.findElement(By.xpath("//button[@id='send2' and @class='action login primary']")).click();

        //Verify the ‘Welcome’ text is display
        String actualText = "Welcome, Geeta Joshi!";
        String expectedText = driver.findElement(By.xpath("//div[@class='panel header']//li[@class='greet welcome']/span[contains(text(),'Welcome')]")).getText();
        Assert.assertEquals(expectedText, actualText);

        Thread.sleep(2000);
    }

    @Test
    public void verifyTheErrorMessageWithInvalidCredentials() throws InterruptedException {
        //Click on ‘Sign In’ button
        driver.findElement(By.xpath("//div[@class='panel header']//li[@class='authorization-link']")).click();
        //Enter Invalid Email Address in Email Address field
        driver.findElement(By.xpath("//input[starts-with(@id,'email')]")).sendKeys("geryjohn@gomail.com");
        //Enter Invalid Password in Password field
        driver.findElement(By.id("pass")).sendKeys("54123@12");
        //Click on ‘Sign In’ button
        driver.findElement(By.xpath("//button[@id='send2' and @class='action login primary']")).click();

        //Verify the error message ‘The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.’
        String actualText1 = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        String expectedText1 = driver.findElement(By.xpath("//div[@role='alert']//div[@class='message-error error message']")).getText();
        Assert.assertEquals("Error Message", actualText1, expectedText1);
        Thread.sleep(2000);
    }

    @Test
    public void userShouldLogOutSuccessfully()throws InterruptedException {
        //Click on ‘Sign In’ link
        driver.findElement(By.xpath("//div[@class='panel header']//li[@class='authorization-link']")).click();
        //Enter Valid Email Address in Email Address field
        driver.findElement(By.xpath("//input[starts-with(@id,'email')]")).sendKeys("geetajoshi6@gmail.com");
        //Enter valid Password in Password field
        driver.findElement(By.id("pass")).sendKeys("1234A!12");
        //Click on ‘Sign In’ button
        driver.findElement(By.xpath("//button[@id='send2' and @class='action login primary']")).click();

        //Verify the ‘Welcome’ text is display
        String actualText = "Welcome, Geeta Joshi!";
        String expectedText = driver.findElement(By.xpath("//div[@class='panel header']//li[@class='greet welcome']/span[contains(text(),'Welcome')]")).getText();
        Assert.assertEquals(expectedText, actualText);
        //Click on drop down aero near Welcome
        driver.findElement(By.xpath("//button[@type ='button']")).click();
        //Click on Sign Out link
        driver.findElement(By.xpath("//a[@href = 'https://magento.softwaretestingboard.com/customer/account/logout/']")).click();


        //Verify the text ‘You are signed out’
        String actualText1 = "You are signed out";
        String expectedText1 = driver.findElement(By.xpath("//span[text()='You are signed out']")).getText();
        Assert.assertEquals("Error Message", actualText1, expectedText1);
    Thread.sleep(2000);
    }

    @After
    public void tearDown() {
        closeBrowser();


    }


}
