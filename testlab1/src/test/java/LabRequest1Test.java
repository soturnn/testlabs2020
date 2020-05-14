import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
//import org.testng.annotations.Test;


class LabRequest1Test {

    static WebDriver driver;

    @Test
    public void testRequest() {

        WebDriverManager.chromedriver().version("81").setup();
        // System.setProperty("webdriver.chrome.driver","C:\\Users\\Sofia\\Documents\\repo\\libs\\chromedriver_win32\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.google.com");

        WebElement element=driver.findElement(By
                 .xpath("/html/body/div/div[3]/form/div[2]/div[1]/div[1]/div/div[2]/input"));
        element.sendKeys("greenpeace");
        element.submit();

        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                     .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3")));

        Assert.assertEquals("Greenpeace" , dynamicElement.getText());
        driver.close();

    }

}