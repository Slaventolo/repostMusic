package Pages;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private final SelenideElement loginInput = $x("//input[@name='st.email']");
    private final SelenideElement passwordInput = $x("//input[@name='st.password']");

    public LoginPage(String url) {
        Selenide.open(url);
    }

    public void insertData(String login, String password) {
        loginInput.setValue(login);
        passwordInput.setValue(password);
        passwordInput.sendKeys(Keys.ENTER);
    }
}
