package com.wdc.qa.Tests;

import com.wdc.qa.Pages.AlertsWindowFramePage;
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

public class AlertsWindowFramesTest {
    WebDriver driver;
    Properties prop = new Properties();
    InputStream input = new FileInputStream("C://Users/7342020/IdeaProjects/Register/src/test/java/core/config.properties");

    public AlertsWindowFramesTest() throws IOException {
        prop.load(input);
    }


    @BeforeTest
    public void BrowserInvoke () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void ClickSwitchTo() throws InterruptedException {
        AlertsWindowFramePage alertWinFrame = new AlertsWindowFramePage(driver);
        alertWinFrame.ClickSwitchToTab();
        alertWinFrame.Alerts();
        alertWinFrame.Windows();
    }


    @AfterTest
    public void BrowserClose () {
        driver.quit();
    }


}
