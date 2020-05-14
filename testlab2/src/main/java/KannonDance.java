import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

 public class KannonDance {

    private WebDriver driver;


    private By searchLocator=By.className("search-field");
    private By searchButtonLocator = By.xpath("//*[@id=\"search-2\"]/form/input");
    private By subscribeLocator= By.xpath("//*[@id=\"mc4wp-form-1\"]/div[1]/p[1]/input");
    private By subscribeButtonLocator = By.xpath("//*[@id=\"mc4wp-form-1\"]/div[1]/p[2]/input");

    public KannonDance(WebDriver driver){

        this.driver=driver;
        driver.get("https://www.kannondance.ru/");

    }

    public String search(String text){

        driver.findElement(searchLocator).sendKeys(text);
        driver.findElement(searchButtonLocator).click();

        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                 .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"post-2886\"]/header/h2/a")));
        return dynamicElement.getText();
    }

    public String subscribeToNews(String email){

        driver.findElement(subscribeLocator).sendKeys(email);
        driver.findElement(subscribeButtonLocator).click();

        return "Subscribed";
    }
}
