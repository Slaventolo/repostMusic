package Tests;

import Pages.MusicPage;
import Pages.OkMenu;
import Pages.PersonalPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class BaseTest {
    private final String URL = "https://ok.ru/";
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1024x780";
        Configuration.headless = false;
    }

    @BeforeEach
    public void init() {
        setUp();
    }

    @AfterEach
    public void deleteData() {
        Selenide.open(URL);

        // получаем href песни из поста на стене
        new OkMenu().goToProfile();
        PersonalPage personalPage = new PersonalPage();
        personalPage.setPostHref();
        String postHref = personalPage.returnPostHref();

        MusicPage musicPage = new MusicPage();
            String songHref = musicPage.returnSongHref();

        assertEquals(postHref, songHref);
        personalPage.deleteNote();

        Selenide.closeWebDriver();

        /*

        ElementsCollection selenideElements = $$x("");
        SelenideElement selenideElement = selenideElements.get(1);

        //паттерн обертка
        Conditional<WebDriver> webdriver = Selenide.webdriver();
        Driver driver = webdriver.driver();
        List<WebElement> elements = driver.getAndCheckWebDriver().findElements(By.xpath(""));
        List<TrackWrapper> tracks;
        for(WebElement element : elements) {
            tracks.add(new TrackWrapper(element));
        }
        tracks.get(0)
*/

    }
}
