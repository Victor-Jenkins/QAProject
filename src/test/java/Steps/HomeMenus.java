package Steps;

import static Functions.Main.*;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;

import com.codeborne.selenide.Configuration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
public class HomeMenus {

  @Given("open browser with xbox.com")
  public void openGoogleSearch() {
    Configuration.reportsFolder = "target/surefire-reports";
    WebDriverManager.chromedriver().setup();
    Configuration.reportsFolder = "target/surefire-reports";
    Configuration.headless = false;

    //Coment if you execute on local, just for pipelines configuration
    //-------------------------------------------------------------------------
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--headless");
    ChromeDriver driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(120, TimeUnit.MILLISECONDS);

    //-------------------------------------------------------------------------
    open("https://www.xbox.com/es-ES/");
    sleep(500);
    if ($(byText("Accept")).isDisplayed()) {
      $(byText("Accept")).shouldBe(visible).click();
      $(byText("Accept")).should(disappear);
    }
  }

  @When("Navigate to Menu1")
  public void enterKeyword() {
    String Title2= "//*[@id='uhf-c-nav']/ul/li/div/button/span";
    sleep(1000);
    $x(Title2).shouldBe(visible).click();
  }

  @Then("Click on accessories1")
  public void topTenMatchesShouldBeShown() {
    String Title= "//*[@id='shellmenu_18']";
    sleep(1000);
    $x(Title).shouldBe(visible).click();
  }

  @Then("Close popup and check Title1")
  public void theFirstOneShouldContainKeyword() {
    String close = "//*[@id=\"wcpConsentBannerCtrl\"]/div[2]/button[1]";
    String currentStringBoxtitle = "//*[@id='feature-uid1c62']/div/div/div/div/h1";
    
       if ($(byText("Accept")).isDisplayed()) {
      $(byText("Accept")).shouldBe(visible).click();
      $(byText("Accept")).should(disappear);
    }
    $x(close).shouldBe(visible).click();
    sleep(1000);
    assert !currentStringBoxtitle.equals(clipboard().getText());
  }
  @Then( "Check the first image1")
  public void selectResult() {

    String Image = "//*[@id='content-card-uid3f2e']/div/div[1]/div/picture/img";
    waitToLoad(2);
    $x(Image).shouldBe(visible).shouldBe(image);;


  }

  @Then("looking {string}")
  public void lookingOption(String write) {
    String search = "//*[@id='search']";
    String OPTION = "//*[@id=\"uhfCatLogo\"]";
    
    waitToLoad(2);
   
    $x(search).shouldBe(visible).click();

    $(By.id("cli_shellHeaderSearchInput")).val(write).pressEnter();
    back();
    back();
    $x(OPTION).shouldBe(visible).click();
 
    waitToLoad(2);

  }
  @Then("navigate to games and swipe element")
  public void Games() {
if ($(byText("Español")).isDisplayed()) {
      $(byText("Español")).shouldBe(visible).click();
      $(byText("Español")).should(disappear);
    }


    String search = "//*[@id=\"ContentBlockList_3\"]/div/div/a[5]/div/div/img";
   
    String SWIPE1 = "//*[@id=\"BodyContent\"]/div[1]/div/div[2]/ol/li[2]";
    
    String SWIPE2 = "//*[@id=\"BodyContent\"]/div[1]/div/div[2]/ol/li[6]";
    String SWIPE3 = "//*[@id=\"BodyContent\"]/div[1]/div/div[2]/ol/li[9]";
    sleep(1000);
  
    $x(search).shouldBe(visible).click();
    
    waitToLoad(2);
    swipeElement($x(SWIPE2), 0, 0);
    waitToLoad(2);


  }

  @Then("search the name {string}")
  public void Name(String name) {
    String search = "//*[@id=\"gamepass-root\"]/div/div/header/div/div[1]/div/div[2]/form/div/div/input";
    $x(search).shouldBe(visible).click();
    $x(search).sendKeys(name);
    $x(search).shouldBe(visible).pressEnter();
    waitToLoad(2);
  }
  @Then("search the game {string}")
  public void Game(String fall) {
    String search = "//*[@id='gamepass-root']/div/div/header/div/div[1]/div/div[2]/form/div/div/input";
    back();
    $x(search).shouldBe(visible).click();
    $x(search).sendKeys(fall);
    $x(search).shouldBe(visible).pressEnter();
    waitToLoad(2);
    WebDriverManager.chromedriver().quit();
  }
}
