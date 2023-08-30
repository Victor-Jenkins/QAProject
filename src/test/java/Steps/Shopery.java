package Steps;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.codeborne.selenide.Configuration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Shopery {
  @Given("open browser with google.com")
  public void openGoogleSearch1() {
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
    open("https://google.es");
    sleep(500);
    if ($(byText("Aceptar todo")).isDisplayed()) {
      $(byText("Aceptar todo")).shouldBe(visible).click();
      $(byText("Aceptar todo")).should(disappear);
    }
  }

  @When("the keyword {string} is entered in input field")
  public void enterKeyword1(String keyword) {
    $(By.name("q")).val(keyword).pressEnter();
  }

  @Then("at a least top {int} matches should be shown")
  public void topTenMatchesShouldBeShown1(int resultsCount) {
    $$("#res .g").shouldHave(sizeGreaterThanOrEqual(resultsCount));
  }

  @Then("a first one should contain {string}")
  public void theFirstOneShouldContainKeyword1(String expectedText) {
    $("#res .g").shouldHave(text(expectedText));
  }
  @Then( "CLICK1 THE FIRST option")
  public void selectResult1() {
    String Title2= "//div[@class ='yuRUbf']";
    sleep(1000);
    $x(Title2).shouldBe(visible).click();
    if ($(byText("Accept")).isDisplayed()) {
      $(byText("Accept")).shouldBe(visible).click();
      $(byText("Accept")).should(disappear);
    }
    sleep(10000);
  }


}
