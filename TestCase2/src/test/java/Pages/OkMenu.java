package Pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class OkMenu {
    private final SelenideElement goToProfile = $x("//div[@class='tico ellip']");

    public void goToProfile() {
        goToProfile.click();
    }
}
