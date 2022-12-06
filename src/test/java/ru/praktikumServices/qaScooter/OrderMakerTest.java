package ru.praktikumServices.qaScooter;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class OrderMakerTest {

    private static WebDriver driver;

    @BeforeClass
    public static void init() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        //driver = new ChromeDriver(options);
        driver = new FirefoxDriver();
    }

    @Before
    public void beforeEach() {
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phoneNumber;
    private final String date;
    private final String comment;
    private final int id;

    public OrderMakerTest(String name, String surname, String address, String metro, String phoneNumber, String date, String comment, int id) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.comment = comment;
        this.id = id;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Имя", "Фамилия", "Адрес", "Мякинино", "79999999999", "04.12.2022", "комментарий", 1},
                {"Антон", "Антонов", "Антоновская", "Планерная", "79999999997", "10.12.2022", "антон", 2},
        };
    }

    @Test
    public void makeOrderTest() {
        OrderMaker orderMaker = new OrderMaker(driver);
        if (id%2==0){
            orderMaker.pageScroller();
            orderMaker.clickBodyButton();
        } else {
            orderMaker.clickOrderButton();
        }
        orderMaker.setName(name);
        orderMaker.setSurname(surname);
        orderMaker.setAddress(address);
        orderMaker.setMetro(metro);
        orderMaker.setPhoneNumber(phoneNumber);
        orderMaker.clickNextButton();
        orderMaker.setDate(date);
        orderMaker.clickRentTime();
        orderMaker.clickColourCheckbox();
        orderMaker.setCommentInput(comment);
        orderMaker.clickFinishButton();
        orderMaker.waitForFinishOrder();
        orderMaker.clickApproveButton();
        orderMaker.waitForFinalText();
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}