package Steps;

import static Functions.Main.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.codeborne.selenide.Configuration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Telefónica {
  @Given("an open browser with www.telefonica.com")
  public void openGoogleSearch() {
    WebDriverManager.chromedriver().setup();
    Configuration.reportsFolder = "target/surefire-reports";
    Configuration.headless = false;
    Configuration.browserSize = "390x850";

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
    open("https://www.telefonica.com/es/");

    waitToLoad(1);
  }

  @When("Check titles and accept cookies")
  public void enterName() {
    String Title3= "//*[@id=\"primary\"]/div[4]/div/div/a";
    String Title4= "//*[@id=\"primary\"]/div[6]/div/div[1]/div/h2";
    String Title2= "//*[@id=\"primary\"]/div[2]/div/div/div[2]/h2/a/span";
    String Title= "//*[@id=\"primary\"]/div[4]/div/div/a";
    String cookies= "//*[@id='onetrust-pc-btn-handler']";
    String cookiesNo= "//*[@id='onetrust-pc-sdk']/div[3]/div[1]/div/button[1]";

    if ($(By.xpath(cookies)).isDisplayed()) {
      $(By.xpath(cookies)).shouldBe(visible).click();
      $x(cookiesNo).click();
    }
    $x(Title).scrollTo().shouldBe(visible);
    waitToLoad(1);
    $x(Title2).scrollTo().shouldBe(visible);  waitToLoad(1);
    $x(Title3).scrollTo().shouldBe(visible);  waitToLoad(1);
    $x(Title4).scrollTo().shouldBe(visible);  waitToLoad(1);

  }

  @Then ("Check main navigation and select Services")
  public void enterPassword() {
    String main= "//*[@id='tf-main-toggle']";

    String cookies= "//*[@id='barritaloca']/div/div/button[2]";
    String cookiesNo= "//*[@id='capa-total']/div/div/div[3]/div/button[1]";

    if ($(By.xpath(cookies)).isDisplayed()) {
      $(By.xpath(cookies)).shouldBe(visible).click();
      $x(cookiesNo).click();
    }

    $x(main).click();

    sleep(1000);
  }

  @Then("Check main navigation and select Particulars")
  public void ChangeFilter() {
    String Part = "//*[@id=\"primary\"]/div[6]/div/div[1]/div/h2";
    $x(Part).scrollTo();

  }
  @Then( "Check the Navigation and scrolling page")
  public void selectResult() {

    String España = "//*[@id=\"primary\"]/div[6]/div/div[4]/div[1]/div/div/h3";
    String Brasil = "//*[@id=\"primary\"]/div[6]/div/div[4]/div[1]/div/div/h3";
    String Alemania = "//*[@id=\"primary\"]/div[6]/div/div[11]/figure/blockquote";
    String UK = "//*[@id=\"primary\"]/div[7]/div/div[1]/div[1]/div/img";
    waitToLoad(1);
    $x(España).scrollTo();
    waitToLoad(1);
    $x(Brasil).scrollTo();
    waitToLoad(1);
    $x(Alemania).scrollTo();
    waitToLoad(1);
    $x(UK).scrollTo();

  }

  @Then("Check the contact button")
  public void lookingOptions() {
    String contact = "//*[@id=\"primary\"]/article/div/div[1]/div[1]/h1";
    $x(contact).scrollTo();
    waitToLoad(2);

  }
  @Then("Click on logo and navigate to stock")
  public void Shopping() {
    String logo = "//*[@id='masthead']/div[2]/div[1]/div";
    String stock = "//*[@id='masthead']/div[2]/div[2]/div[1]";

    $x(logo).click();
    $x(stock).click();
    waitToLoad(2);

  }


}
