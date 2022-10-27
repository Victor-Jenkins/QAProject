package Steps;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import com.codeborne.selenide.Configuration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeMenus {

  @Given("an open browser with xbox.com")
  public void openGoogleSearch() {
      WebDriverManager.chromedriver().setup();
    Configuration.reportsFolder = "target/surefire-reports";
    Configuration.headless = false;
    open("https://xbox.com");
    sleep(500);
    if ($(byText("Accept")).isDisplayed()) {
      $(byText("Accept")).shouldBe(visible).click();
      $(byText("Accept")).should(disappear);
    }
  }

  @When("Navigate to Menu")
  public void enterKeyword() {
    String Title2= "//*[@id='uhf-c-nav']/ul/li/div/button/span";
    sleep(1000);
    $x(Title2).shouldBe(visible).click();
  }

  @Then("Click on accessories")
  public void topTenMatchesShouldBeShown() {
    String Title= "//*[@id='shellmenu_18']";
    sleep(1000);
    $x(Title).shouldBe(visible).click();
  }

  @Then("Close popup and check Title")
  public void theFirstOneShouldContainKeyword() {
    String close = "//*[@id='uhfLogo']/img|//*[@id='emailSup-modal']/div/div/div[1]/button";
    String currentStringBoxtitle = "//*[@id='feature-uid1c62']/div/div/div/div/h1";
    $x(close).shouldBe(visible).click();
    sleep(1000);
    assert !currentStringBoxtitle.equals(clipboard().getText());
  }
  @Then( "Check the first image")
  public void selectResult() {

    String Image = "//*[@id='highlight-uid3412']/div[1]/picture/img";
    sleep(1000);
    $x(Image).shouldBe(visible).shouldBe(image);


  }

  @Then("looking {string}")
  public void lookingOption(String write) {
    String search = "//*[@id='search']";

    String input = "//*[@id='cli_shellHeaderSearchInput']";
    sleep(1000);
    $x(search).shouldBe(visible).click();
    //System.out.println("Series x ");
    $(By.id("cli_shellHeaderSearchInput")).val(write).pressEnter();
    sleep(10000);
  }
}
