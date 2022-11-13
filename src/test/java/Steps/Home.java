package Steps;

import static Functions.Main.swipeElement;
import static Functions.Main.waitToLoad;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import org.openqa.selenium.WebDriver;
import com.codeborne.selenide.Condition;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import com.codeborne.selenide.Configuration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Home {
  @Given("an open browser with google.com")
  public void openGoogleSearch() {


    //WebDriverManager.chromedriver().setup();
    //ChromeOptions options = new ChromeOptions();
    //options.addArguments("--no-sandbox");
    //options.addArguments("--disable-dev-shm-usage");
    //options.addArguments("--headless");
    //ChromeDriver driver = new ChromeDriver(options);
    //driver.manage().window().maximize();
    //driver.manage().timeouts().implicitlyWait(120, TimeUnit.MILLISECONDS);

    open("https://google.es");
    sleep(500);
    if ($(byText("Aceptar todo")).isDisplayed()) {
      $(byText("Aceptar todo")).shouldBe(visible).click();
      $(byText("Aceptar todo")).should(disappear);
    }
  }

  @When("a keyword {string} is entered in input field")
  public void enterKeyword(String keyword) {
    $(By.name("q")).val(keyword).pressEnter();
  }

  @Then("at least top {int} matches should be shown")
  public void topTenMatchesShouldBeShown(int resultsCount) {
    $$("#res .g").shouldHave(sizeGreaterThanOrEqual(resultsCount));
  }

  @Then("the first one should contain {string}")
  public void theFirstOneShouldContainKeyword(String expectedText) {
    $("#res .g").shouldHave(text(expectedText));
  }
  @Then( "CLICK THE FIRST option")
  public void selectResult() {
    String Title2= "//*[@id='rso']/div[1]/div/div/div/div/div/div/div/div[1]/a/h3";
    $x(Title2).shouldBe(visible).click();

  }
  @Then( "Swipe the different elements on slider")
  public void sliderSwipe() {
    String close = "//*[@id='onetrust-reject-all-handler']|//*[@id='onetrust-accept-btn-handler']|//*[@id='onetrust-close-btn-container']/button";
    String Swipe= "/html/body/div[2]/section[1]/div[2]/div/div[2]/ul/li[3]/a/blz-promotion";
    String Swipe1= "/html/body/div[2]/section[1]/div[2]/div/div[2]/ul/li[6]/a/blz-promotion|/html/body/div[2]/section[1]/div[2]/div/div[2]/ul/li[8]/a/blz-promotion";
    String Swipe2= "/html/body/div[2]/section[1]/div[2]/div/div[2]/ul/li[5]/a/blz-promotion|/html/body/div[2]/section[1]/div[2]/div/div[2]/ul/li[7]/a/blz-promotion";
    String Swipe3= "/html/body/div[2]/section[1]/div[2]/div/div[2]/ul/li[4]/a/blz-promotion|/html/body/div[2]/section[1]/div[2]/div/div[2]/ul/li[6]/a/blz-promotion";
      if ($(byText("Aceptar todas las cookies")).isDisplayed()) {
          $(byText("Aceptar todas las cookies")).shouldBe(visible).click();
          $(byText("Aceptar todas las cookies")).should(disappear);
      }
    swipeElement($x(Swipe), -0, 0);
    waitToLoad(2);
    swipeElement($x(Swipe1), -0, 0);
    waitToLoad(2);
    swipeElement($x(Swipe2), -0, 0);
    waitToLoad(2);
    swipeElement($x(Swipe3), -0, 0);
  }
  @Then( "check the titles and images")
  public void checkTitles() {
    String Tit = "/html/body/div[2]/section[1]/blz-section/div[1]/blz-header/h2";
    String Tit2= "//*[@id='products-0']/div[1]/blz-game-card[6]";
    $x(Tit).scrollTo();
    waitToLoad(2);
    assert $x(Tit).equals("Juegos destacados");
    waitToLoad(2);
    Assert.assertTrue("falta poner el titulo correcto", $x(Tit).exists());
  }
}
