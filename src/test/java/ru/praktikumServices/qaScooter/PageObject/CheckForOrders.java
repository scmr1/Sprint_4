package ru.praktikumServices.qaScooter.PageObject;

import org.openqa.selenium.By;

public class CheckForOrders {
    public static By makeOrderHeaderButton = By.className("Button_Button__ra12g"); // Кнопка создания заказа
    public static By nameInput = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input"); // Поле ввода имени
    public static By surnameInput = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input"); // Поле ввода фамилии
    public static By addressInput = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input"); // Поле ввода адреса
    public static By metroInput = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div/input"); // Поле ввода метро
    public static By metroPicker = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[1]/button");
    public static By phoneNumberInput = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input"); // Поле ввода телефона
    public static By nextButton = By.xpath("/html/body/div/div/div[2]/div[3]/button"); // Кнопка перехода на следующую страницу
    public static By dateInput = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div/div/input"); // Поле ввода даты
    public static By datePicker = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[7]");
    public static By rentTimeInput = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/div[1]"); // Поле выбора даты
    public static By rentTimePicker = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[1]");
    public static By colourCheckbox = By.className("Checkbox_Input__14A2w"); // Чекбокс выбора цвета
    public static By commentInput = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/input"); // Поле ввода комментария
    public static By finishButton = By.xpath("/html/body/div/div/div[2]/div[3]/button[2]"); // Кнопка завершения создания заказа
    public static By approveButton = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]"); // Кнопка подтверждения создания
    public static By finalText = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button"); // Текст о создании заказа
}
