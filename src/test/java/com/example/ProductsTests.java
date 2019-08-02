package com.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProductsTests {
    public ChromeDriver driver;

    @Before
    public void ChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "/home/gartesk/Documents/qa/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost/product-manager/");
    }

    /*@After
    public void close(){
        driver.quit();
    }*/

    /**
     * Тест проверяет добавление, редактирование и удаление продукта в Products Manager
     */
    @Test
    public void testProducts() {
        WebElement productsButtonsAdd = driver.findElement(By.xpath("//*[@id=\"mat-tab-content-0-0\"]/div/div/mat-card[1]/mat-card-content/div/button[2]"));
        productsButtonsAdd.click();
        WebElement productsTypeName = driver.findElement(By.id("mat-input-0"));
        productsTypeName.sendKeys("Ипоте");
        WebElement productsTypeNameButtonsAdd = driver.findElement(By.xpath("//*[@id=\"cdk-overlay-0\"]/mat-dialog-container/productadddialog/div[2]/button[2]"));
        productsTypeNameButtonsAdd.click();
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'Ипоте')]"));
        assertFalse(list.isEmpty());

        list.get(0).click();
        WebElement productsButtonsEdit = driver.findElement(By.xpath("//*[@id=\"mat-tab-content-0-0\"]/div/div/mat-card[1]/mat-card-content/div/button[1]"));
        productsButtonsEdit.click();
        WebElement productsEditTypeName = driver.findElement(By.id("mat-input-0"));
        productsEditTypeName.sendKeys("ка");
        WebElement productsEditTypeNameSave = driver.findElement(By.xpath("//*[@id=\"cdk-overlay-1\"]/mat-dialog-container/producteditdialog/div[2]/button[2]"));
        productsEditTypeNameSave.click();
        list = driver.findElements(By.xpath("//*[contains(text(),'Ипотека')]"));
        assertFalse(list.isEmpty());

        WebElement productsButtonsDelete = driver.findElement(By.xpath("//*[@id=\"mat-tab-content-0-0\"]/div/div/mat-card[1]/mat-card-content/div/button[3]"));
        productsButtonsDelete.click();
        WebElement productsButtonsDeleteOk = driver.findElement(By.xpath("//*[@id=\"cdk-overlay-2\"]/mat-dialog-container/productdeletedialog/div/button[2]"));
        productsButtonsDeleteOk.click();
        list = driver.findElements(By.xpath("//*[contains(text(),'Ипотека')]"));
        assertTrue(list.isEmpty());
    }

}
