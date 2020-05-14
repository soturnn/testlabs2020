import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ossu {

    private WebDriver driver;
    private By searchLocator = By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/div/div/div/form/label/input[1]");
    private By loginButtonLocator = By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/a[1]");
    private By usernameLocator = By.xpath("//*[@id=\"login_field\"]");
    private By passwordLocator = By.xpath("//*[@id=\"password\"]");
    private By secondLoginButtonLocator = By.xpath("//*[@id=\"login\"]/form/div[4]/input[9]");
    private By firstSearchResult = By.xpath("//*[@id=\"code_search_results\"]/div/div[1]/div/div[1]");


    Ossu(WebDriver driver){

        this.driver=driver;
        driver.get("https://github.com/ossu/computer-science");
    }

    public String login(String username, String password){

        driver.findElement(loginButtonLocator).click();
        (new WebDriverWait(driver, 15))
                 .until(ExpectedConditions.presenceOfElementLocated(usernameLocator));
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(secondLoginButtonLocator).click();
        return "You're log in";

    }

    public WebElement searchCourse(String text){

        WebElement element = driver.findElement(searchLocator);
        element.sendKeys(text);
        driver.findElement(searchLocator).submit();
        (new WebDriverWait(driver, 15))
                 .until(ExpectedConditions.presenceOfElementLocated(firstSearchResult));
        return driver.findElement(firstSearchResult);

    }

}
