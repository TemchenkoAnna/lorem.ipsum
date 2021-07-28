package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[contains(text(), 'Pyccкий')]")
    private WebElement languageButton;

    @FindBy(xpath = "//div[1]/p")
    private WebElement firstParagraph;

    @FindBy(xpath = "//input[@type = 'submit']")
    private WebElement generateLoremIpsumButton;

    @FindBy(xpath = "//input[@id='words']")
    private WebElement wordsRadioButton;
    @FindBy(xpath = "//input[@id='bytes']")
    private WebElement bytesRadioButton;

    @FindBy(xpath = "//input[@id='amount']")
    private WebElement amountField;

    @FindBy(xpath = "//input[@type = 'checkbox']")
    private WebElement checkBoxButton;

    public void openHomePage(String url) {
        driver.get(url);
    }
    public void clickLanguageButton() {
        languageButton.click();
    }
    public String getTextFromParagraph() {
        return firstParagraph.getText();
    }
    public void clickGenerateLoremIpsumButton(){
        generateLoremIpsumButton.click();
    }
    public void clickWordsButton() {
        wordsRadioButton.click();
    }
    public void clickBytesButton() {
        bytesRadioButton.click();
    }
    public void enterTextToField(final String checkNumber) {
        amountField.clear();
        amountField.sendKeys(checkNumber);
    }
    public void clickCheckBoxButton() {
        checkBoxButton.click();
    }
}
