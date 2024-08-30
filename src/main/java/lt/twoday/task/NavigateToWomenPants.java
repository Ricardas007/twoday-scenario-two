package lt.twoday.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class NavigateToWomenPants extends BasePage {

    @FindBy(css = "[data-action] > [role] > [role='presentation']:nth-of-type(2) > [tabindex] span:nth-of-type(2)")
    WebElement hoverOverWomenMeniu;

    @FindBy (id = "ui-id-10")
    WebElement hoverOverBottoms;

    @FindBy (id = "ui-id-15")
    WebElement hoverOverPants;

    @FindBy (className = "base")
    WebElement sectionName;
    
    public NavigateToWomenPants(WebDriver driver) {
        super(driver);
    }

    public void selectWomenPants() {
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOverWomenMeniu).perform();
        actions.moveToElement(hoverOverBottoms).moveToElement(hoverOverPants).perform();
        actions.click().build().perform();
    }

    public String sectionName() {
        return sectionName.getText();
    }
}
