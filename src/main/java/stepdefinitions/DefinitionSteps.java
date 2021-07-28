package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GeneratedPage;
import pages.GeneratedPageWithoutCheckBox;
import pages.HomePage;
import pages.WordsResultPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {
    WebDriver driver;
    HomePage homePage;
    GeneratedPage generatedPage;
    WordsResultPage wordsResultPage;
    GeneratedPageWithoutCheckBox generatedPageWithoutCheckBox;
    PageFactoryManager pageFactoryManager;
    private static final long DEFAULT_TIMEOUT = 60;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @When("User switches to Russian language")
    public void userSwitchesToRussianLanguage() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickLanguageButton();
    }

    @Then("User verifies that the text of the first  element, contains  word {string}")
    public void userVerifiesThatTheTextOfTheFirstElementContainsWordKeyword(final String expectedText) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(homePage.getTextFromParagraph().contains(expectedText));
    }

    @When("User presses button “Generate Lorem Ipsum”")
    public void userPressButtonGenerateLoremIpsum() {
        homePage.clickGenerateLoremIpsumButton();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks that the first paragraph starts with {string}")
    public void userChecksThatTheFirstParagraphStartsWithKeyword(final String expectedText) {
        generatedPage = pageFactoryManager.getGeneratedPage();
        Assert.assertTrue(generatedPage.getTextFromParagraph().startsWith(expectedText));
    }

    @And("User clicks on button Words")
    public void userClicksOnButtonWords() {
        homePage.clickWordsButton();
    }

    @When("User inputs {string} into the number field")
    public void userInputsKeywordIntoTheNumberField(final String expectedText) {
        homePage.enterTextToField(expectedText);
    }


    @Then("User checks the result has {string} words")
    public void userChecksTheResultHasKeywordWords(final String expectedText) {
        wordsResultPage = pageFactoryManager.getWordsResultPage();
        Assert.assertTrue(wordsResultPage.getTextFromParagraph().contains(expectedText));
    }

    @And("User clicks on button bytes")
    public void userClicksOnButtonBytes() {
        homePage.clickBytesButton();
    }


    @And("User unchecks start with Lorem Ipsum checkbox")
    public void userUnchecksStartWithLoremIpsumCheckbox() {
        homePage.clickCheckBoxButton();
    }

    @Then("User checks that the first paragraph no longer starts with {string}")
    public void userChecksThatTheFirstParagraphNoLongerStartsWithKeyword(final String expectedText) {
        generatedPageWithoutCheckBox = pageFactoryManager.getGeneratedPageWithoutCheckbox();
        Assert.assertFalse(generatedPageWithoutCheckBox.getTextFromParagraph().startsWith(expectedText));
    }

    @And("User gets text from each paragraph and determine the number of paragraphs containing the word {string}")
    public void userGetsTextFromEachParagraphAndDetermineTheNumberOfParagraphsContainingTheWordLorem(final String word) {
        generatedPage = pageFactoryManager.getGeneratedPage();
        Assert.assertTrue(generatedPage.countWords(word) >= 2);
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
