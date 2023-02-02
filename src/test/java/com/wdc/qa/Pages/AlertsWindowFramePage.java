package com.wdc.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AlertsWindowFramePage {
    WebDriver driver;
    public AlertsWindowFramePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "SwitchTo") public WebElement SwitchTo;
    @FindBy(linkText = "Alerts") public WebElement Alerts;
    @FindBy(id="aswift_2") public WebElement Frame;
    @FindBy(xpath = "//iframe[@id='ad_iframe']") public WebElement Ad_Frame;

    @FindBy(xpath = "//span[contains(text(),'Close')]") public WebElement Close_btn;

    @FindBy(xpath = "//button[@class='btn btn-danger']") public WebElement AlertOk;

    @FindBy(xpath = "//a[contains(text(),'Windows')]") public WebElement Windows;
    @FindBy(xpath = "(//button[contains(text(),'click')])[1]") public WebElement click_btn;

    @FindBy(xpath = "(//a[contains(text(),'About')])[1]") public WebElement about_tab;
    @FindBy(xpath="(//a[contains(text(),'About Selenium')])[1]") public WebElement about_selenium;

    public void ClickSwitchToTab() throws InterruptedException {
        SwitchTo.click();
        Thread.sleep(2000);
        Alerts.click();
        driver.switchTo().frame(Frame);
        driver.switchTo().frame(Ad_Frame);
        Close_btn.click();
        Thread.sleep(3000);
    }

    public void Alerts() throws InterruptedException {
        AlertOk.click();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();

    }

    public void Windows() throws InterruptedException {
        SwitchTo.click();
        Windows.click();
        click_btn.click();
        Set <String> WindowHandles = driver.getWindowHandles();
        System.out.println(WindowHandles);

        Iterator <String> iterator = WindowHandles.iterator();
        String parentWindow = iterator.next();
        System.out.println("parent Window" + parentWindow);
        String childWindow = iterator.next();
        System.out.println("Child Window" + childWindow);
        driver.switchTo().window(childWindow);
        about_tab.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        about_selenium.click();

        driver.switchTo().window(parentWindow);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }








}
