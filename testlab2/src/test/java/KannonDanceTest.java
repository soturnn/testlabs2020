import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class KannonDanceTest {

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
    void searchTest() {

        KannonDance page=new KannonDance(driver);
        Assert.assertEquals("Курс с нуля по contemporary dance",page.search("contemporary"));
    }

    @Test
    void subscribeToNewsTest() {
        KannonDance page=new KannonDance(driver);
        Assert.assertEquals("Subscribed",page.subscribeToNews("soturnn@gmail.com"));
    }
}