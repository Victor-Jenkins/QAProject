package Functions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Main {

    private static final int time = 2;
    public static void swipeElement(WebElement dragElement, int offX, int offY) {
        Actions act = new Actions(getWebDriver());
        act.dragAndDropBy(dragElement, offX, offY).build().perform();
    }
    public static void waitToLoad() {
        waitToLoad(time);
    }

    public static void waitToLoad(int timeInSeconds) {
        try {
            TimeUnit.SECONDS.sleep(timeInSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
