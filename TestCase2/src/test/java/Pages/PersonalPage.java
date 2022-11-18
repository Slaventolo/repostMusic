package Pages;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class PersonalPage {
    private final SelenideElement songInPost = $x(" //div[@class='track-with-cover_line']/a");
    private final SelenideElement notes = $x("//a[4][@class='mctc_navMenuSec ']");
    private final SelenideElement postMenu = $x("//div[@class='feed_menu_ic']/span");
    private final SelenideElement deleteNote = $x("//div[@id='hook_Block_ShortcutMenu']//*[contains(@hrefattrs, 'deleteButton')]");
    private String postHref;

    public void setPostHref() {
        postHref = songInPost.getAttribute("href");
    }

    public String returnPostHref() {
        return postHref;
    }

    public void deleteNote() {
        notes.click();
        postMenu.hover();
        deleteNote.click();
    }
}
