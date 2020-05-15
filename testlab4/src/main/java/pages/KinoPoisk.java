package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KinoPoisk {
    private WebDriver driver;
    private By searchLocator = By
             .xpath("/html/body/div[1]/div/div[5]/header/div/div/div[2]/div/div[2]/div/form/div/input");
    private By filmNameLocator = By.className("name");
    private By loginButtonLocator = By.xpath("/html/body/div[1]/div/div[5]/header/div/div/div[3]/div/div/button");
    private By usernameLocator=By.xpath("//*[@id=\"passp-field-login\"]");
    private By passwordLocator=By.xpath("//*[@id=\"passp-field-passwd\"]");



    public KinoPoisk(WebDriver driver){

        this.driver=driver;
        driver.get("https://www.kinopoisk.ru//");
        (new WebDriverWait(driver, 10))
                 .until(ExpectedConditions
                          .presenceOfElementLocated(searchLocator));
    }

    public String search(String text){

        WebElement element =driver.findElement(searchLocator);
        element.sendKeys(text);
        element.submit();

        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                 .until(ExpectedConditions.presenceOfElementLocated(filmNameLocator));
        return dynamicElement.getText();
    }

    public String login(String username, String password){

        driver.findElement(loginButtonLocator).click();

        WebElement nameElem=(new WebDriverWait(driver, 15))
                 .until(ExpectedConditions.presenceOfElementLocated(usernameLocator));
        nameElem.sendKeys(username);
        nameElem.submit();

        WebElement passwordElem=(new WebDriverWait(driver, 15))
                 .until(ExpectedConditions.presenceOfElementLocated(passwordLocator));
        passwordElem.sendKeys(password);
        passwordElem.submit();

        return "You're log in";
    }

}
