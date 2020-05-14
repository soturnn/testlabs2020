import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class OssuTest{

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

    @Test
    @Category(SearchSmokeTest.class)
     public void searchCourse() {
        Ossu page=new Ossu(driver);
        WebElement course = page.searchCourse("course");
        Assert.assertEquals("CHANGELOG.md",course.getText());
    }

    @Test
    @Category(LoginSmokeTest.class)
     public void login() {
        Ossu page=new Ossu(driver);
        Assert.assertEquals("You're log in",page.login("soturnn@gmail.com","1234"));
    }


}