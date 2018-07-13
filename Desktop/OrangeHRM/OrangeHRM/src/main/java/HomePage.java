import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage {

    private String url;

    @FindBy(name = "txtUsername")
    private WebElement usernameBox;

    @FindBy(name = "txtPassword")
    private WebElement passwordBox;

    @FindBy(name = "Submit")
    private WebElement submitbutton;

    public void gotoPage(WebDriver driver, String url){
        driver.get(url);
    }

    public void enterLoginPagedetails(String username, String password) {

        usernameBox.sendKeys("Admin");
        passwordBox.sendKeys("AdminAdmin");
        usernameBox.submit();
    }
}


