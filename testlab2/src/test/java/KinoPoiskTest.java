import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KinoPoiskTest {

    private static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().version("81").setup();
        driver= new ChromeDriver();
    }

    @After
    public void tearDown() {
        if (driver!=null)
            driver.close();
    }

    @Category(SearchSmokeTest.class)
    @Test
    public void search() {
        KinoPoisk page=new KinoPoisk(driver);
        Assert.assertEquals("Кролик Джоджо 2019",page.search("Кролик Джоджо"));

    }

    @Category(LoginSmokeTest.class)
    @Test
    public void login() {
        KinoPoisk page = new KinoPoisk(driver);
        Assert.assertEquals("You're log in",
                 page.login("name","12345"));
    }
}