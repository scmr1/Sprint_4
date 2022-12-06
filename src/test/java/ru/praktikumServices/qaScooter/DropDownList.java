package ru.praktikumServices.qaScooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

import static ru.praktikumServices.qaScooter.PageObject.CheckForAccordion.*;

public class DropDownList {
    private final WebDriver driver;

    public DropDownList(WebDriver driver) {
        this.driver = driver;
    }

    //метод закрыия надоедливых кук, если они есть
    Boolean isPresent;

    public void closeCookiePanel() {
        if (isPresent = driver.findElements(cookieButton).size() > 0) {
            driver.findElement(cookieButton).click();
        }
    }

    //метод для проверки раскрытия аккордионов
    public void openDropdown(By dropdown) {
        driver.findElement(dropdown).click();
    }

    //метод перемотки страницы до выпадающего списка
    public void pageScroller() {

        WebElement element = driver.findElement(dropDowns[0]);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

    }

    // метод ожидания прогрузки данных профиля
    public void waitForLoadProfileData() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(driver -> (driver.findElement(dropDowns[0]).getText() != null));
    }

    //сравнение текстов
    public void waitForText(String element, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> (Objects.equals(driver.findElement(By.xpath(element)).getText(), text)));
    }

}
