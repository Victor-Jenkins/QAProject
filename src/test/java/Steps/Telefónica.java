package Steps;

import static Functions.Main.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;

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
    open("https://www.telefonica.com/es/");

    waitToLoad(1);
  }

  @When("Check titles and accept cookies")
  public void enterName() {
    String Title3= "//*[@id=\"primary\"]/div[8]/div/div[2]/div/div/div[1]/div/div[3]/a/span[1]";
    String Title4= "//*[@id=\"primary\"]/div[8]/div/div[2]/div/div/div[2]/div/div[1]/div[3]/a/span[1]";
    String Title2= "//*[@id=\"primary\"]/div[6]/div/div/a";
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
    String Services="//*[@id='menu-item-418']/button/span";
    String cookies= "//*[@id='barritaloca']/div/div/button[2]";
    String cookiesNo= "//*[@id='capa-total']/div/div/div[3]/div/button[1]";

    if ($(By.xpath(cookies)).isDisplayed()) {
      $(By.xpath(cookies)).shouldBe(visible).click();
      $x(cookiesNo).click();
    }

    $x(main).click();
    $x(Services).click();
    sleep(1000);
  }

  @Then("Check main navigation and select Particulars")
  public void ChangeFilter() {
    String Part = "//*[@id='menu-item-16036']/a";
    $x(Part).click();

  }
  @Then( "Check the Navigation and scrolling page")
  public void selectResult() {

    String España = "//*[@id=\"post-16031\"]/div/div[2]/div[1]/h2";
    String Brasil = "//*[@id=\"post-16031\"]/div/div[4]/div/div/div[1]/h2";
    String Alemania = "//*[@id=\"post-16031\"]/div/div[6]/div[1]/h2";
    String UK = "//*[@id=\"post-16031\"]/div/div[8]/div[1]/h2";
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
    String contact = "//*[@id=\"colophon\"]/div[1]/div[2]/div[3]/ul/li[2]/a";
    $x(contact).scrollTo().click();
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
