package Pages;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Selenide.$x;

public class MusicPage {
    private final SelenideElement input = $x("//input[@data-tsid='inner_input']");
    private final SelenideElement track = $x("//wm-track[@data-tsid='track']");
    private final SelenideElement options = $x("//wm-track-actions[@data-tsid='track_show_more_options']");
    private final SelenideElement song = $x("//div/a[@data-tsid='track_name']");  // вернули 1-ю песню
    private final SelenideElement shareSong = $x("//wm-tico[@data-tsid='share_track']");
    private final SelenideElement addYourText = $x("//wm-tico[@data-l='t,share-with-text']");
    private final SelenideElement shareButton = $x("//div[@class='posting_submit button-pro']");
    private final SelenideElement closeMusicWindow = $x("//div[@class='toolbar-layer_close js-close-layer']");
    private static String songHref = "https://ok.ru/music/track/123083860775369";

    public void insertName(String musicName) {
        input
                .setValue(musicName)
                .sendKeys(Keys.ENTER);
    }

    public void setSongHref() {
        songHref = song.getAttribute("href");
    }

    public String returnSongHref() {
        return songHref;
    }

    public void repostMusic() {
        track.hover();
        options.hover();
        shareSong.hover().click();
        addYourText.hover().click();
        shareButton.click();
    }

    public void closeMusicWindow() {
        closeMusicWindow.hover().click();
    }
}
