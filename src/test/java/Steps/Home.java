package Steps;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import java.util.concurrent.TimeUnit;

import io.cucumber.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.codeborne.selenide.Configuration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class Home {
  @Given("an open browser with google.com")
  public void openGoogleSearch() {
    WebDriverManager.chromedriver().setup();
    Configuration.reportsFolder = "target/surefire-reports";
    Configuration.headless = false;

  //Coment if you execute on local, just for pipelines configuration
    //-------------------------------------------------------------------------
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
   
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
    if ($(byText("Aceptar")).isDisplayed()) {
      $(byText("Aceptar")).shouldBe(visible).click();
      $(byText("Aceptar")).should(disappear);
    }
    $("#res .g").shouldHave(text(expectedText));
  }

  @Then( "CLICK THE FIRST option")
  public void selectResult() {
    String Title2= "//*[@id='rso']/div[1]/div/div/div/div/div/div/div/div[1]/a/h3|//div[@class ='LC20lb MBeuO DKV0Md']/h3";
    sleep(1000);
    $x(Title2).shouldBe(visible).click();
    if ($(byText("Accept")).isDisplayed()) {
      $(byText("Accept")).shouldBe(visible).click();
      $(byText("Accept")).should(disappear);
    }
    sleep(10000);
  }


}
