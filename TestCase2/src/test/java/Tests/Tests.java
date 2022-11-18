package Tests;
import Pages.*;
import com.codeborne.selenide.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.tools.Tool;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests extends BaseTest {
    private final String URL = "https://ok.ru/";
    private final String LOGIN = "technoPol24";
    private final String PASSWORD = "technoPolis2022";
    private final String musicName = "Jambi Tool - 10 000 days";

    @Test
    public void repostMusic() {
        new LoginPage(URL).insertData(LOGIN, PASSWORD);

        new ToolBar().goToMusic();

        MusicPage musicPage = new MusicPage();
            musicPage.insertName(musicName);
            musicPage.setSongHref();
            String songHref = musicPage.returnSongHref();
            musicPage.repostMusic();
            musicPage.closeMusicWindow();

        new OkMenu().goToProfile();

        PersonalPage personalPage = new PersonalPage();
            personalPage.setPostHref();
            String postHref = personalPage.returnPostHref();

        assertEquals(songHref, postHref);
    }
}
