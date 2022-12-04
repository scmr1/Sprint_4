import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.Objects;


// Класс для проверки аккордеона
class AccordionItems {

    private WebDriver driver;

    //Все элементы с выпадающим списком
    private By firstHeading = By.id("accordion__heading-0");
    private By secondHeading = By.id("accordion__heading-1");
    private By thirdHeading = By.id("accordion__heading-2");
    private By fourthHeading = By.id("accordion__heading-3");
    private By fifthHeading = By.id("accordion__heading-4");
    private By sixthHeading = By.id("accordion__heading-5");
    private By seventhHeading = By.id("accordion__heading-6");
    private By eighthHeading = By.id("accordion__heading-7");


    public AccordionItems(WebDriver driver) {
        this.driver = driver;
    }

    //метод закрыия надоедливых кук, если они есть
    public void iHateCookie() {
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
    }

    //методы для проверки раскрытия аккордионов
    public void discoverFirstDropDown() {
        driver.findElement(firstHeading).click();
    }
    public void discoverSecondDropDown() {
        driver.findElement(secondHeading).click();
    }
    public void discoverThirdDropDown() {
        driver.findElement(thirdHeading).click();
    }
    public void discoverFourthDropDown() {
        driver.findElement(fourthHeading).click();
    }
    public void discoverFifthDropDown() {
        driver.findElement(fifthHeading).click();
    }
    public void discoverSixthDropDown() {
        driver.findElement(sixthHeading).click();
    }
    public void discoverSeventhDropDown() {
        driver.findElement(seventhHeading).click();
    }
    public void discoverEighthDropDown() {
        driver.findElement(eighthHeading).click();
    }

    public void pageScroller() {
        WebElement element = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // метод ожидания прогрузки данных профиля
    public void waitForLoadProfileData() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(driver -> (driver.findElement(firstHeading).getText() != null));
    }

    //сравнение текстов
    public void waitForText(String element, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> (Objects.equals(driver.findElement(By.xpath(element)).getText(), text)));
    }
}

class OrderMaker {
    private WebDriver driver;

    private By makeOrderHeaderButton = By.className("Button_Button__ra12g");
    private By nameInput = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]");
    private By surnameInput = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");
    private By addressInput = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
    private By phoneNumberInput = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");
    private By nextButton = By.xpath("/html/body/div/div/div[2]/div[3]/button");

    public OrderMaker(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOrderButton() {
        driver.findElement(makeOrderHeaderButton).click();
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
    public void setPhoneNumber(String number) {
        driver.findElement(phoneNumberInput).sendKeys(number);
    }
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void firstPage(){ //String name, String surname, String address, String number
        clickOrderButton();
        setName("Имя");
        setSurname("Фамилия");
        setAddress("Мякинино");
        setPhoneNumber("79999999999");
        clickNextButton();
    }
    public void pageScroller() {
        WebElement element = driver.findElement(By.className("Header_Nav__AGCXC"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
}

// Класс с автотестом
public class Main {

    private WebDriver driver;

    @Test
    public void checkActivity() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        String[] expectedResult = {
                "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                "Да, обязательно. Всем самокатов! И Москве, и Московской области."
        };

        String[] xPaths = {
                "/html/body/div/div/div/div[5]/div[2]/div/div[1]/div[2]/p",
                "/html/body/div/div/div/div[5]/div[2]/div/div[2]/div[2]/p",
                "/html/body/div/div/div/div[5]/div[2]/div/div[3]/div[2]/p",
                "/html/body/div/div/div/div[5]/div[2]/div/div[4]/div[2]/p",
                "/html/body/div/div/div/div[5]/div[2]/div/div[5]/div[2]/p",
                "/html/body/div/div/div/div[5]/div[2]/div/div[6]/div[2]/p",
                "/html/body/div/div/div/div[5]/div[2]/div/div[7]/div[2]/p",
                "/html/body/div/div/div/div[5]/div[2]/div/div[8]/div[2]/p"
        };

        AccordionItems objAccordionItems = new AccordionItems(driver); // объект класс главной страницы

        objAccordionItems.iHateCookie(); //закрыватель кук

//        objAccordionItems.pageScroller(); //прокрутка до нужного элемента
//        objAccordionItems.waitForLoadProfileData(); //ожидание прогрузки страницы
//
//        objAccordionItems.discoverFirstDropDown(); // раскрытие первого элемента списка
//        objAccordionItems.waitForText(xPaths[0], expectedResult[0]); // сравнение текстов
//
//        objAccordionItems.discoverSecondDropDown(); // раскрытие второго элемента списка
//        objAccordionItems.waitForText(xPaths[1], expectedResult[1]); // сравнение текстов
//
//        objAccordionItems.discoverThirdDropDown(); // раскрытие третьего элемента списка
//        objAccordionItems.waitForText(xPaths[2], expectedResult[2]); // сравнение текстов
//
//        objAccordionItems.discoverFourthDropDown(); // раскрытие четвертого элемента списка
//        objAccordionItems.waitForText(xPaths[3], expectedResult[3]); // сравнение текстов
//
//        objAccordionItems.discoverFifthDropDown(); // раскрытие пятого элемента списка
//        objAccordionItems.waitForText(xPaths[4], expectedResult[4]); // сравнение текстов
//
//        objAccordionItems.discoverSixthDropDown(); // раскрытие шестого элемента списка
//        objAccordionItems.waitForText(xPaths[5], expectedResult[5]); // сравнение текстов
//
//        objAccordionItems.discoverSeventhDropDown(); // раскрытие седьмого элемента списка
//        objAccordionItems.waitForText(xPaths[6], expectedResult[6]); // сравнение текстов
//
//        objAccordionItems.discoverEighthDropDown(); // раскрытие восьмого элемента списка
//        objAccordionItems.waitForText(xPaths[7], expectedResult[7]); // сравнение текстов

        OrderMaker objOrderMaker = new OrderMaker(driver);
        //objOrderMaker.pageScroller();
        //objOrderMaker.clickNextButton();
        objOrderMaker.firstPage();

    }


    @After
    public void teardown() {
        driver.quit();
    }
}