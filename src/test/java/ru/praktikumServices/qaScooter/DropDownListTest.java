package ru.praktikumServices.qaScooter;

import org.junit.*;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;
import static ru.praktikumServices.qaScooter.PageObject.CheckForAccordion.dropDowns;

// Класс с автотестом
@RunWith(Parameterized.class)
public class DropDownListTest {

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
    private final String realText;
    private final String expectedText;
    private final int number;

    public DropDownListTest(String realText, String expectedText, int number) {
        this.realText = realText;
        this.expectedText = expectedText;
        this.number = number;
    }


    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                        "/html/body/div/div/div/div[5]/div[2]/div/div[1]/div[2]/p", 0},
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                        "/html/body/div/div/div/div[5]/div[2]/div/div[2]/div[2]/p", 1},
                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                        "/html/body/div/div/div/div[5]/div[2]/div/div[3]/div[2]/p", 2},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                        "/html/body/div/div/div/div[5]/div[2]/div/div[4]/div[2]/p", 3},
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                        "/html/body/div/div/div/div[5]/div[2]/div/div[5]/div[2]/p", 4},
                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                        "/html/body/div/div/div/div[5]/div[2]/div/div[6]/div[2]/p", 5},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                        "/html/body/div/div/div/div[5]/div[2]/div/div[7]/div[2]/p", 6},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                        "/html/body/div/div/div/div[5]/div[2]/div/div[8]/div[2]/p", 7},
        };
    }

    @Test
    public void checkActivity() {

        DropDownList dropDownLists = new DropDownList(driver); // объект класс главной страницы

        dropDownLists.closeCookiePanel(); //закрыватель кук
        dropDownLists.pageScroller(); //прокрутка до нужного элемента
        dropDownLists.waitForLoadProfileData(); //ожидание прогрузки страницы

        dropDownLists.openDropdown(dropDowns[number]);
        dropDownLists.waitForText(expectedText, realText);

//        for(int i=0; i<dropDowns.length;i++){
//           dropDownLists.openDropdown(dropDowns[i]); // раскрытие элементов списка
//            // сравнение текстов
//        }
    }
    @AfterClass
    public static void teardown() {
        driver.quit();
    }

}
