import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class KinoPoiskTest {

    private WebDriver driver;
    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().version("81").setup();
        driver= new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        if (driver!=null)
            driver.close();
    }

    @Category(SearchSmokeTest.class)
    @Test
    void search() {
        KinoPoisk page=new KinoPoisk(driver);
        Assert.assertEquals("Кролик Джоджо 2019",page.search("Кролик Джоджо"));

    }

    @Category(LoginSmokeTest.class)
    @Test
    void login() {
        KinoPoisk page = new KinoPoisk(driver);
        Assert.assertEquals("You're log in",
                                       page.login("name","12345"));
    }
}