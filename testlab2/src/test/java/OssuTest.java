import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class OssuTest{

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
    void searchCourse() {
        Ossu page=new Ossu(driver);
        WebElement course = page.searchCourse("course");
        Assert.assertEquals("CHANGELOG.md",course.getText());
    }

    @Category(LoginSmokeTest.class)
    @Test
    void login() {
        Ossu page=new Ossu(driver);
        Assert.assertEquals("You're log in",page.login("soturnn@gmail.com","1234"));
    }


}