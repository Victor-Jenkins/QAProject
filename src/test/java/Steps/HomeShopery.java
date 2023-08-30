package Steps;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.*;
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

public class HomeShopery {
  @Given("an open browser with Shopery.com")
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



    open("https://shopery.com");
    sleep(500);
    if ($(byText("Accept")).isDisplayed()) {
      $(byText("Accept")).shouldBe(visible).click();
      $(byText("Accept")).should(disappear);
    }
  }

  @When("Navigate to Menu")
  public void enterKeyword() {
    String Title2= "//div[@class ='button-text']";
    sleep(1000);
    $x(Title2).shouldBe(visible).click();
  }

  @Then("tres")
  public void topTenMatchesShouldBeShown() {
    String Title= "/html/body/div[1]/div[1]/a/img";
    sleep(1000);
    $x(Title).shouldBe(visible).click();
  }

  @Then("cuatro")
  public void theFirstOneShouldContainKeyword() {
    String currentStringBoxtitle = "/html/body/div[3]/div[1]/h1";
    sleep(1000);
    assert !currentStringBoxtitle.equals(clipboard().getText());
  }
  @Then( "CLICK THE FIRST option1")
  public void selectResult() {
    String Image = "//*[@id='w-node-_964c9ab6-f570-fd51-5727-bf12e53c4a2c-e53c4a29']/a/img";
    sleep(1000);
    $x(Image).shouldBe(visible).shouldBe(image);


  }
}
