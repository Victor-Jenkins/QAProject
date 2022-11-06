package Steps;

import static Functions.Main.swipeElement;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import com.codeborne.selenide.Configuration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomeMenus {

  @Given("an open browser with xbox.com")
  public void openGoogleSearch() {
     
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
    String OPTION = "//*[@id='coreui-searchresultlist-uis8gf5']/div/div[1]/div[1]/div[1]/h3/a";
    sleep(1000);
    $x(search).shouldBe(visible).click();
    $(By.id("cli_shellHeaderSearchInput")).val(write).pressEnter();
    $x(OPTION).shouldBe(visible).click();
    sleep(1000);

  }
  @Then("navigate to games and swipe element")
  public void Games() {
    String search = "//*[@id='c-shellmenu_58']";
    String game = "//*[@id='c-shellmenu_57']";
    String SWIPE1 = "//*[@id='BodyContent']/div[1]/div/div[2]/ol/li[3]/a/div[2]/div";
    String OPTION = "//*[@id='navMenuItemDealsWeek']";
    String OPTION2 = "//*[@id='ContentBlockList_3']/div/div/a[5]/div/div/img";
    String SWIPE2 = "//*[@id='BodyContent']/div[1]/div/div[2]/ol/li[3]/a/div[2]/div";
    String search1 = "//*[@id='gamepass-root']/div/div/header/div/div[1]/div/div[2]/form/div/div/input";
    sleep(1000);
    $x(game).shouldBe(visible).click();
    $x(search).shouldBe(visible).click();
    $x(OPTION).shouldBe(visible).click();
    $x(OPTION2).shouldBe(visible).click();
    sleep(1000);
    $x(search1).scrollTo();
    swipeElement($x(SWIPE2), -150, 0);
    sleep(2000);
    swipeElement($x(SWIPE1), -150, 0);
    sleep(1000);
  }

  @Then("search the game {string}")
  public void Game(String fall) {
    String search = "//*[@id='gamepass-root']/div/div/header/div/div[1]/div/div[2]/form/div/div/input";
    $x(search).shouldBe(visible).click();
    $x(search).sendKeys(fall);
    $x(search).shouldBe(visible).pressEnter();
    sleep(10000);
  }
}
