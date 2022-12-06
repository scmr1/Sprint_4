package ru.praktikumServices.qaScooter;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static ru.praktikumServices.qaScooter.PageObject.CheckForOrders.*;

class OrderMaker {
    private final WebDriver driver;

    public OrderMaker(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderButton() {
        driver.findElement(makeOrderHeaderButton).click();
    }

    public void clickBodyButton() {
        driver.findElement(makeOrderBodyButton).click();
    }

    public void setName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(surnameInput).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }

    public void setMetro(String metro) {
        driver.findElement(metroInput).sendKeys(metro);
        driver.findElement(metroPicker).click();
    }

    public void setPhoneNumber(String number) {
        driver.findElement(phoneNumberInput).sendKeys(number);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void waitForFinishOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(driver -> (driver.findElement(dateInput).isDisplayed()));
    }

    public void setDate(String date) {
        driver.findElement(dateInput).sendKeys(date);
        driver.findElement(datePicker).click();
    }

    public void clickRentTime() {
        driver.findElement(rentTimeInput).click();
        driver.findElement(rentTimePicker).click();
    }

    public void clickColourCheckbox() {
        driver.findElement(colourCheckbox).click();
    }

    public void setCommentInput(String comment) {
        driver.findElement(commentInput).sendKeys(comment);
    }

    public void clickFinishButton() {
        driver.findElement(finishButton).click();
    }


    public void waitForFinalText() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(driver -> (
                driver.findElement(finalText).getText().equals("Посмотреть статус")));
    }

    public void clickApproveButton() {
        driver.findElement(approveButton).click();
    }


    public void pageScroller() {
        ((JavascriptExecutor) driver).executeScript("document.querySelector('#root > div > div > div.Home_ThirdPart__LSTEE > div.Home_RoadMap__2tal_ > div.Home_FinishButton__1_cWm > button').scrollIntoView();");
    }
}

