package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GeneratedPageWithoutCheckBox extends BasePage {
    public GeneratedPageWithoutCheckBox(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@id='lipsum']/p[1]")
    private WebElement firstParagraphGp;

    public String getTextFromParagraph() {
        return firstParagraphGp.getText();
    }
}
