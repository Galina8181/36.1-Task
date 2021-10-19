package tests;

import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.pages.factory.OnboardingPageFactory;
import lib.ui.pages.factory.SearchPageFactory;
import lib.ui.pages.factory.StartPageFactory;
import lib.ui.pages.interfaces.IOnboardingPageObject;
import lib.ui.pages.interfaces.ISearchPageObject;
import lib.ui.pages.interfaces.IStartPageObject;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.lang.reflect.MalformedParameterizedTypeException;

public class SearchTest extends CoreTestCase {

    public SearchTest() {
    }

    @Test
    public void testFindJava() {

        //org.wikipedia:id/search_container

        //org.wikipedia:id/search_bar
        MainPageObject mainPO = new MainPageObject(this.driver);

        WebElement searchInit = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/search_container",
                "Cannot find Search Wikipedia init search input"
        );
        searchInit.click();

       WebElement searchInput = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/search_src_text",
                "Cannot find search input"
        );
        searchInput.sendKeys("Java");

        WebElement expectedResult = mainPO.waitForElementPresent(
                "xpath://*[./*[contains(@text,'Island of Indonesia')]] ",
                "Cannot find result 'Island of Indonesia' on 'Java' search"
        );
        expectedResult.click();


        //1 Нажать "х"
        //2. Ввести текст "wfewfewfwegweg"

        //3. проверить результат org.wikipedia:id/search_src_text

         WebElement clickButton = mainPO.waitForElementPresent(
                 "xpath://android.widget.ImageButton[@content-desc=\"Navigate up\"]",
                 "Cannot find button"
         );
         clickButton.click();

        WebElement againSearchInit = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/search_container",
                "Cannot find Search Wikipedia againInit search input"
        );
        againSearchInit.click();


        WebElement textInput = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/search_src_text",
                "Cannot find search text"
        );
        textInput.sendKeys("wfewfewfwegweg");


        WebElement checkResult = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/fragment_search_results",
                "Cannot find result "
        );
             checkResult.getText();
    }
}

