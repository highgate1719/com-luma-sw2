package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Write down the following test into ‘SaleTest’ class
 * 1. verifyTheTotalItemsDisplayedOnTheWomens
 * JacketsPage()
 * * Click on ‘Sale’ Menu tab
 * * Click on ‘Jackets’ link on left side
 * under WOMEN’S DEAL Category
 * * Verify the text ‘Jackets’ is displayed
 * * Count the Total Item Displayed on Page
 * and print the name of all items into
 * console.
 * * Verify total 12 Items displayed on page.
 */

public class SaleTest extends BaseTest {

    static String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheTotalItemDisplayedOntheWomensJacketsPage() throws InterruptedException {
        //click on the sale menu tab
        driver.findElement(By.xpath("//span[text()='Sale']")).click();
        //click on jackets link on the left side under women's deal category
        driver.findElement(By.xpath("//a[text()='Jackets']")).click();

        //verify the text ‘Jackets’ is displayed
        String expectedText = "Jackets";
        String actualText = driver.findElement(By.xpath("//span[@class ='base']")).getText();
        Assert.assertEquals("Text is not displayed", expectedText, actualText);

        //count total item displayed on page and print the name of all items into console
        List<WebElement> list = driver.findElements(By.xpath("//img[@class='product-image-photo']"));
        System.out.println("Items displayed on the page are: " + list.size());
        List<WebElement> names = driver.findElements(By.xpath("//strong[@class='product name product-item-name']"));

        //iterate webElements and print it
        for (WebElement name : names) {
            System.out.println(name.getText());
            Thread.sleep(2000);
        }
        //verify total 12 Items displayed on page.
        List<WebElement> list1 = driver.findElements(By.xpath("//img[@class='product-image-photo']"));
        int actualNo = list1.size();
        int exceptedNo = 12;
        Assert.assertEquals("Product not displayed correctly", exceptedNo, actualNo);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}

