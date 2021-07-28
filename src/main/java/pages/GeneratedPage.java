package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class GeneratedPage extends BasePage {
    public GeneratedPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@id='lipsum']/p[1]")
    private WebElement firstParagraphGp;
    @FindBy(xpath = "//div/p[1]")
    private List<WebElement> paragraphs;

    public String getTextFromParagraph() {
        return firstParagraphGp.getText();
    }

    public List<WebElement> getResultsList() {
        return paragraphs;
    }
    public int countWords(String word){
    int count = 0;
    for (WebElement p: paragraphs) {
        if ((p.getText().toLowerCase(Locale.ROOT).contains(word))) {
            count++;
        }

    }
        System.out.println(count);
    return count;
    }
}