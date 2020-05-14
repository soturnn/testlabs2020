import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class KannonDanceTest {

    private WebDriver driver;
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
    public void searchTest() {

        KannonDance page=new KannonDance(driver);
        Assert.assertEquals("Курс с нуля по contemporary dance",page.search("contemporary"));
    }

    @Test
    public void subscribeToNewsTest() {
        KannonDance page=new KannonDance(driver);
        Assert.assertEquals("Subscribed",page.subscribeToNews("soturnn@gmail.com"));
    }
}