package Steps;

import static Functions.Main.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import io.cucumber.junit.Cucumber;
import org.junit.Assert;
import org.junit.runner.RunWith;
import io.github.bonigarcia.wdm.WebDriverManager;

import com.codeborne.selenide.Configuration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

/**
 *
 */
@RunWith(Cucumber.class)
public class Movistar {

  @Given("an open browser with Movistar.com")
  public void openURLSearch() {
    Configuration.reportsFolder = "target/surefire-reports";
    Configuration.reportsFolder = "target/surefire-reports";
    Configuration.headless = false;

    open("https://www.movistar.es/particulares/movistarplus/");
    sleep(500);

  }

  @When("Complete input with {string} and check cookies")
  public void enterName(String name1) {
    String cookies= "//*[@id='onetrust-pc-btn-handler']";
   String cookiesNo= "//*[@id='onetrust-pc-sdk']/div/div[3]/div[1]/button";
    String name= "//*[@id='inputsupportadnsearch']";
    String Title= "//*[@id='__next']/header/div[2]/div/div/div[1]/div[2]/a/span";
    waitToLoad(2);

    if ($(By.xpath(cookies)).isDisplayed()) {
      $(By.xpath(cookies)).shouldBe(visible).click();
      $x(cookiesNo).click();
    }
    Assert.assertTrue("productos y servicios", $x(Title).exists());
    $x(name).sendKeys(name1);
    waitToLoad(2);
  }

  @Then ("Complete input with {string}")
  public void enterPassword(String password) {
    String Title2= "//*[@id='inputsupportadnsearch']";
    $x(Title2).sendKeys(password);
  }

  @Then("Check Title and click play video")
  public void ChangeFilter() {
    String playVid = "//*[@id='__next']/div/div[1]/div/div/div[2]";
    String currentStringBoxtitle = "//*[@id='__next']/div/div[1]/div/div/div[1]/div/div[2]/p";
    assert !currentStringBoxtitle.equals(clipboard().getText());
    $x(playVid).click();
    waitToLoad(5);

  }


  @Then( "Check the navigation and add Zipcode {string}")
  public void selectResult(String zipcode) {

    String Configure = "//*[@id='__next']/div/div[1]/div/div/div[1]/div/div[6]/div[1]/a";
    String zip = "//*[@id='postalCode']";
    String send = "//*[@id='rfs']/div/div/div/div[1]/button";
    String cookies= "//*[@id='onetrust-pc-btn-handler']";
    String cookiesNo= "//*[@id='onetrust-pc-sdk']/div/div[3]/div[1]/button";
    if ($(By.xpath(cookies)).isDisplayed()) {
      $(By.xpath(cookies)).shouldBe(visible).click();
      $x(cookiesNo).click();
    }
    waitToLoad(3);
    $x(Configure).shouldBe(visible).click();
    $x(zip).sendKeys(zipcode);
    $x(send).click();
    waitToLoad(3);

  }

  @Then("Check previous Steps for contracting")
  public void lookingOptions() {
    String search = "//*[@id='__next']/section/div/div[1]/div/div/div/div[1]/button";
    String continuar= "//*[@id='__next']/div[2]/section/div/div/div/div/div/div[2]/div/div/article/div/div[3]/div/div/div[2]/button";
    String Selection= "//*[@id='__next']/div[2]/section/div/div/div/div/div/div[2]/div/div/article/div/div[3]/div/div/div[2]/div/button/div/div/span";
    String close="//*[@id='nextfusion']/div[1]/div/div/div[1]/div/span";
    String cookies= "//*[@id='onetrust-pc-btn-handler']";
    String cookiesNo= "//*[@id='onetrust-pc-sdk']/div/div[3]/div[1]/button";

    waitToLoad(2);
    if ($(By.xpath(cookies)).isDisplayed()) {
      $(By.xpath(cookies)).shouldBe(visible).click();
      $x(cookiesNo).click();
    }
    $x(search).click();
    $x(continuar).scrollTo().click();
    $x(Selection).click();
    $x(close).click();
    waitToLoad(2);

  }
  @Then("Check previous Steps for contracting1")
  public void Shopping() {
    String go = "//*[@id='__next']/div[3]/div/section/div/div/div[2]/div/button";
    String esencial = "//*[@id='__next']/div[4]/div[1]/section/div/div/div/div/article/div/div[5]/div/div/div[2]/button";
    String scrollToButton="//*[@id='__next']/div[4]/div[2]/section/div/div/div[2]/div/button/span[1]";
    String Dispositivo = "//*[@id='__next']/div[4]/div[3]/div/button";
    String scrollToButton2="//*[@id='__next']/div[5]/div/section/div/div[1]/div[2]/div/ul" ;
    String NoDisp = "//*[@id='__next']/div[5]/div/section/div/div[2]/div/button";
    String Resumen = "//*[@id='__next']/aside/div/div/div/button";
    String Price="//*[@id='nextfusion']/div[1]/div/div/div[1]/div[2]/article[1]/div/div/div/div[2]/div/div/div[2]/div/span";
    String Confirmation="//*[@id='nextfusion']/div[1]/div/div/div[2]/div/div[2]/a";
    $x(go).scrollTo().click();
    waitToLoad(2);

    $x(esencial).scrollTo().click();
    $x(scrollToButton).scrollTo();
    waitToLoad(2);
    $x(Dispositivo).scrollTo().click();
    $x(scrollToButton2).scrollTo();

    $x(NoDisp).scrollTo().click();
    $x(Resumen).click();
    waitToLoad(3);
    Assert.assertTrue("74,90", $x(Price).exists());
    waitToLoad(3);
    $x(Confirmation).click();
  }
  @Then("Finish Shopping {string}{string}{string}{string}{string}{string}")
  public void FinishShopping(String string, String string2, String string3,String string4, String string5, String string6) {

    String nif = "//*[@id='formID_documentNumber']";
    String name = "//*[@id='formID_name']";
    String surname = "//*[@id='formID_firstSurname']";
    String surname2 = "//*[@id='formID_secondSurname']";
    String email = "//*[@id='formID_email']";
    String mobile = "//*[@id='formID_contactPhone']";
    String backHome = "//*[@id='CustomLink-19']|//*[@id='rfs']/div/span";

    $x(nif).sendKeys(string);
    $x(name).sendKeys(string2);
    $x(surname).sendKeys(string3);
    $x(surname2).sendKeys(string4);
    $x(email).sendKeys(string5);
    $x(mobile).sendKeys(string6);
    waitToLoad(3);

    $x(backHome).scrollTo().click();
  }

}
