import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class OrangeHRM {
    WebDriver driver;
    HomePage HomePage1;
    Navigate Navi;
    AddEmployee Emp;

    private String username ="Admin";
    private String password = "AdminAdmin";


    String url = "https://qa-trials641.orangehrmlive.com/auth/login";

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Development\\web_driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("^the login page$")
    public void the_login_page(){
        driver.get(url);
        assertEquals(url, driver.getCurrentUrl());
    }

    @When("^I login$")
    public void i_login() {
        HomePage1 = PageFactory.initElements(driver, HomePage.class);
        HomePage1.enterLoginPagedetails(username,password);
    }

    @When("^I click the PIM tab$")
    public void i_click_the_PIM_tab(){
        driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/a"));
    }

    @When("^then the Add Employee Tab$")
    public void then_the_Add_Employee_Tab(){
        WebElement myDynamicElement = (new WebDriverWait(driver, 25)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"menu_pim_addEmployee\"]")));
        driver.findElement(By.xpath("//*[@id=\"menu_pim_addEmployee\"]")).click();
    }

    @When("^I fill out the Employee Details correctly$")
    public void i_fill_out_the_Employee_Details_correctly() {
        WebElement myDynamicElement = (new WebDriverWait(driver,30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"addEmployeeModal\"]/h4")));
        driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("saad");
        driver.findElement(By.xpath("//*[@id=\"middleName\"]")).sendKeys("pal");
        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("Israr");
        driver.findElement(By.xpath("//*[@id=\"employeeId\"]")).sendKeys("015521");
        driver.findElement(By.xpath("//*[@id=\"location_inputfileddiv\"]/div/input")).sendKeys("London Office");
    }

    @When("^I choose to create Login Details by clicking the appropriate button$")
    public void i_choose_to_create_Login_Details_by_clicking_the_appropriate_button() {
    }

    @When("^I fill out the Login Details correctly$")
    public void i_fill_out_the_Login_Details_correctly() {
        AddEmployee.createUserName(username);
        AddEmployee.createPassword(password);
        AddEmployee.confirmPassword(password);
    }

    @When("^I click the Save button$")
    public void i_click_the_Save_button() {
        AddEmployee.clickSave();
    }

    @Then("^I can search for the Employee I have just created$")
    public void i_can_search_for_the_Employee_I_have_just_created() {
        EmployeeListPage = PageFactory.initElements(driver, AddEmployee.class);
        System.out.println(EmployeeListPage.EmployeeListPage.checkonDetailsPage);
    }

    @Then("^select them for inspection$")
    public void select_them_for_inspection() {

    }

    @After
    public void teardown(){driver.quit();}

}
