package com.wdc.qa.Pages;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@placeholder = 'First Name']") public WebElement FirstName;
    @FindBy(xpath = "//input[@placeholder = 'Last Name']") public WebElement LastName;
    @FindBy(xpath ="//*[@id='basicBootstrapForm']/div[2]/div/textarea") public WebElement Address;
    @FindBy(xpath ="//input[@type='email']") public WebElement EmailAddress;
    @FindBy(xpath ="//input[@type='tel']") public WebElement Phone;
    @FindBy(xpath ="//input[@value='Male']") public WebElement Gender1;
    @FindBy(xpath ="//input[@value='FeMale']") public WebElement Gender2;
    @FindBy(id ="checkbox1") public WebElement Hobbies1;
    @FindBy(id = "checkbox2") public WebElement Hobbies2;
    @FindBy(id = "checkbox3") public WebElement Hobbies3;
    @FindBy(xpath = "//button[@id ='submitbtn']") public WebElement Submit_btn;
    @FindBy(id = "msdd") public WebElement Lang_dropdown;
    @FindBy(xpath = "//label[contains(text(), 'Languages')]") public WebElement LanguageText;
    @FindBy(id = "Skills") public WebElement Skill_dropdown;
    @FindBy(xpath = "//option[@value='Client Server']") public WebElement ClientServerElement;
    
    public void EnterFirstName(String firstName){FirstName.sendKeys(firstName);}
    public void EnterLastName(String lastName){
        LastName.sendKeys(lastName);
    }
    public void EnterAddress(String address){
        Address.sendKeys(address);
    }
    public void EnterEmailAddress(String emailAddress){
        EmailAddress.sendKeys(emailAddress);
    }
    public void EnterPhoneNo(String phoneNo){
        Phone.sendKeys(phoneNo);
    }


    public boolean SelectGender1(){
        Gender1.click();
        boolean RadioBtn1 = Gender1.isSelected();
        return RadioBtn1;
    }
    public boolean SelectGender2(){
        Gender2.click();
        boolean RadioBtn2 = Gender2.isSelected();
        return RadioBtn2;
    }
    public void Scroll(){
        WebElement scroll = Submit_btn;
        Actions actions = new Actions(driver);
        actions.moveToElement(scroll);
        actions.perform();
    }

    public boolean HobbiesCricket(){
        Hobbies1.click();
        boolean ChkBox1 = Hobbies1.isSelected();
        return ChkBox1;
    }

    public boolean HobbiesMovies(){
        Hobbies2.click();
        boolean ChkBox2 = Hobbies2.isSelected();
        return ChkBox2;
    }

    public boolean HobbiesHockey(){
        Hobbies3.click();
        boolean ChkBox3 = Hobbies3.isSelected();
        return ChkBox3;
    }

    public void LangInput() throws InterruptedException {
        Lang_dropdown.click();
        Thread.sleep(2000);
        List<WebElement> ListOfElements = driver.findElements(By.xpath("//li[@class='ng-scope']"));

        for (WebElement webElement : ListOfElements) {
            if(webElement.getText().trim().equals("English")){
                webElement.click();
            break;
            }
        }
        for (WebElement webElement : ListOfElements) {
            if(webElement.getText().trim().equals("Czech")){
                webElement.click();
                break;
            }
        }
        LanguageText.click();
    }


    public void SkillSelection() throws InterruptedException {
        Skill_dropdown.click();
        /*
        Select select =new Select((WebElement) Skill_dropdown);
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClientServerElement));
        select.selectByVisibleText("Client Server");
        */
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ClientServerElement.click();
    }


}
