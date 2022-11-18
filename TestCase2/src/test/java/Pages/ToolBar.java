package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ToolBar {
    private final SelenideElement musicButton = $x("//div[@id='music_toolbar_button']");

    public void goToMusic() {
        musicButton.click();
    }
}
