package com.wdc.qa.Tests;
import com.wdc.qa.Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class HomeTest {
    WebDriver driver;
    Properties prop = new Properties();
    InputStream input = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\core\\config.properties");

    public HomeTest() throws IOException {
        prop.load(input);
    }


    @BeforeTest
    public void BrowserInvoke () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(prop.getProperty("url"));
        //driver.get("https://demoqa.com/select-menu");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }



    @Test
    public void EnterData() throws InterruptedException, IOException {
        HomePage name = new HomePage(driver);
        name.EnterFirstName(prop.getProperty("first.Name"));
        name.EnterLastName(prop.getProperty("last.Name"));
        name.EnterAddress(prop.getProperty("address"));
        name.EnterEmailAddress(prop.getProperty("email"));
        name.EnterPhoneNo(prop.getProperty("phoneNo"));

    }
    @Test
    public void RadioButton() throws InterruptedException {
        HomePage btn = new HomePage(driver);
        //System.out.println("Male is selected"+ btn.SelectGender1());
        System.out.println("Female is selected"+ btn.SelectGender2());
    }
    @Test
    public void ScrollDown(){
        HomePage scroll = new HomePage(driver);
        scroll.Scroll();
    }

    @Test
    public void CheckBox() throws InterruptedException {
        HomePage chk_box = new HomePage(driver);
        System.out.println("Cricket is selected"+ chk_box.HobbiesCricket());
        System.out.println("Movies is selected"+ chk_box.HobbiesMovies());
        System.out.println("Hockey is selected"+ chk_box.HobbiesHockey());
    }

    @Test
    public void SelectLanguage() throws InterruptedException {
        HomePage dropdown = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        dropdown.Scroll();
        dropdown.LangInput();
    }

    @Test
    public void SelectSkill() throws InterruptedException {
        HomePage skill_dropdown = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        skill_dropdown.Scroll();
        skill_dropdown.SkillSelection();
    }


    @AfterTest
    public void BrowserClose () {
        driver.quit();
    }

}
