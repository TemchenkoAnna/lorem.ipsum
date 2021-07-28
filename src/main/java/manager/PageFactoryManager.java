package manager;

import org.openqa.selenium.WebDriver;
import pages.GeneratedPage;
import pages.GeneratedPageWithoutCheckBox;
import pages.HomePage;
import pages.WordsResultPage;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }
    public GeneratedPage getGeneratedPage(){
        return new GeneratedPage(driver);
    }
    public GeneratedPageWithoutCheckBox getGeneratedPageWithoutCheckbox(){
        return new GeneratedPageWithoutCheckBox(driver);
    }
    public WordsResultPage getWordsResultPage(){
        return new WordsResultPage(driver);
    }
}
