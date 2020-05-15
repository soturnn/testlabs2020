package steps;

import cucumber.api.PendingException;
import pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyStepdefs {

    private WebDriver driver;

    private KannonDance pageKannonDance;
    private KinoPoisk pageKinoPoisk;
    private Ossu pageOssu;

    private String kannonDanceAnswer;
    private String kinoPoiskAnswer;
    private String ossuAnswer;

    @Given("^open browser")
    public void openBrowser(){
        WebDriverManager.chromedriver().version("81").setup();
        driver= new ChromeDriver();
    }

    @Given("^open page \"(.*?)\"")
    public void openPage(String url) {
        switch (url){
            case "https://www.kannondance.ru/":
                pageKannonDance = new KannonDance(driver); break;
            case "https://www.kinopoisk.ru//":
                pageKinoPoisk = new KinoPoisk(driver); break;
            case "https://github.com/ossu/computer-science":
                pageOssu = new Ossu(driver); break;
        }

    }

    @When("^search in KannonDance \"(.*?)\"")
    public void searchKannonDance(String text) {

        kannonDanceAnswer=pageKannonDance.search(text);
    }

    @When("^search in KinoPoisk \"(.*?)\"$")
    public void searchKinoPoisk(String text) {

        kinoPoiskAnswer=pageKinoPoisk.search(text);
    }

    @When("^search in Ossu \"(.*?)\"$")
    public void searchOssu(String text) {
      ossuAnswer=pageOssu.searchCourse(text).getText();

    }

    @Then("^first result in KannonDance is \"(.*?)\"$")
    public void firstResultInKannonDanceIs(String text) {
        Assert.assertEquals(text, kannonDanceAnswer);
    }

    @Then("^first result in KinoPoisk is \"(.*?)\"$")
    public void firstResultInKinoPoiskIs(String text) {
        Assert.assertEquals(text, kinoPoiskAnswer);
    }

    @Then("^first result in Ossu is \"(.*?)\"$")
    public void firstResultInOssuIs(String text) {
        Assert.assertEquals(text,ossuAnswer);
    }

    @And("^close browser$")
    public void close_browser() {
        if (driver!=null)
            driver.close();
    }

    @When("^log in to github account with username \"(.*?)\" and password \"(.*?)\"$")
    public void logInToGithubAccountWithUsernameAndPassword(String arg0, String arg1){
        Assert.assertEquals("You're log in",pageOssu.login(arg0,arg1));
    }

    @When("^log in to kinopoisk account with username \"(.*?)\" and password \"(.*?)\"$")
    public void logInToKinopoiskAccountWithUsernameAndPassword(String arg0, String arg1){
        Assert.assertEquals("You're log in",
                 pageKinoPoisk.login(arg0,arg1));
    }


}
