package lt.twoday.task;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class NavigateToWomenPantsTest extends BaseTest {

    @Description("Using navigation menu, find women pants section.")
    @Test
    public void NavigateToWomenPants() {
        NavigateToWomenPants navigate = new NavigateToWomenPants(driver);
        navigate.selectWomenPants();
        navigate.sectionName();
        String sectionWomenPantsName = navigate.sectionName();
        Assertions.assertEquals("Pants", sectionWomenPantsName, "Name of section should match the name which user navigate to");
    }
}
