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
    public static String[] expectedResult = {
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };

    public static String[] xPaths = {
            "/html/body/div/div/div/div[5]/div[2]/div/div[1]/div[2]/p",
            "/html/body/div/div/div/div[5]/div[2]/div/div[2]/div[2]/p",
            "/html/body/div/div/div/div[5]/div[2]/div/div[3]/div[2]/p",
            "/html/body/div/div/div/div[5]/div[2]/div/div[4]/div[2]/p",
            "/html/body/div/div/div/div[5]/div[2]/div/div[5]/div[2]/p",
            "/html/body/div/div/div/div[5]/div[2]/div/div[6]/div[2]/p",
            "/html/body/div/div/div/div[5]/div[2]/div/div[7]/div[2]/p",
            "/html/body/div/div/div/div[5]/div[2]/div/div[8]/div[2]/p"
    };
    private final WebDriver driver;

    public DropDownList(WebDriver driver) {
        this.driver = driver;
    }

    //метод закрыия надоедливых кук, если они есть
    public void closeCookiePanel() {
        driver.findElement(cookieButton).click();
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
