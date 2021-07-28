package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WordsResultPage extends BasePage{
    public WordsResultPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@id='generated']")
    private WebElement firstParagraphWp;

    public String getTextFromParagraph() {
        return firstParagraphWp.getText();
    }
}
