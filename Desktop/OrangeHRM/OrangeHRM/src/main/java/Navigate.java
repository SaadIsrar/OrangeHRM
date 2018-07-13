import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Navigate {
    @FindBy(xpath ="//*[@id=\"menu_pim_viewPimModule\"]/a/span[2]" )
    private WebElement pimTab;

    public void ClickPIM(){
        pimTab.click();
    }

}
