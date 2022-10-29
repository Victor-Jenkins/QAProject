package Functions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Main {
    public static void swipeElement(WebElement dragElement, int offX, int offY) {
        Actions act = new Actions(getWebDriver());
        act.dragAndDropBy(dragElement, offX, offY).build().perform();
    }

}
