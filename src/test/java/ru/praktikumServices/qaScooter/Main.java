package ru.praktikumServices.qaScooter;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import static ru.praktikumServices.qaScooter.AccordionItems.*;
import static ru.praktikumServices.qaScooter.PageObject.CheckForAccordion.*;


// Класс с автотестом
public class Main {

    private static WebDriver driver;

    @BeforeClass
    public static void init() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        //driver = new FirefoxDriver();
    }
    @Before
            public void beforeEach() {
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }
    @Test
    public void checkActivity() {


        AccordionItems objAccordionItems = new AccordionItems(driver); // объект класс главной страницы

        objAccordionItems.iHateCookie(); //закрыватель кук
        objAccordionItems.pageScroller(); //прокрутка до нужного элемента
        objAccordionItems.waitForLoadProfileData(); //ожидание прогрузки страницы

        for(int i=0; i<dropDowns.length;i++){
            objAccordionItems.openDropdown(dropDowns[i]); // раскрытие элементов списка
            objAccordionItems.waitForText(xPaths[i], expectedResult[i]); // сравнение текстов
        }
    }

    @Test
    public void makeOrderOne() { //проверка кнопки в шапке
        OrderMaker orderMaker = new OrderMaker(driver);
        orderMaker.clickOrderButton();
        orderMaker.setName("Имя");
        orderMaker.setSurname("Фамилия");
        orderMaker.setAddress("Адрес");
        orderMaker.setMetro("Мякинино");
        orderMaker.setPhoneNumber("79999999999");
        orderMaker.clickNextButton();
        orderMaker.setDate("04.12.2022");
        orderMaker.clickRentTime();
        orderMaker.clickColourCheckbox();
        orderMaker.setCommentInput("комментарий");
        orderMaker.clickFinishButton();
        orderMaker.waitForFinishOrder();
        orderMaker.clickApproveButton();
        orderMaker.waitForFinalText();
    }

    @Test
    public void makeOrderTwo() { //проверка кнопки в середине текста
        OrderMaker orderMaker = new OrderMaker(driver);
        orderMaker.pageScroller();
        orderMaker.clickOrderButton();
        orderMaker.setName("Антон");
        orderMaker.setSurname("Антонов");
        orderMaker.setAddress("Антоновская");
        orderMaker.setMetro("Автозаводская");
        orderMaker.setPhoneNumber("79999999997");
        orderMaker.clickNextButton();
        orderMaker.setDate("05.12.2022");
        orderMaker.clickRentTime();
        orderMaker.clickColourCheckbox();
        orderMaker.setCommentInput("коммент");
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