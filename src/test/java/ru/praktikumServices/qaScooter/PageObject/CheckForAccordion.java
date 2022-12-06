package ru.praktikumServices.qaScooter.PageObject;

import org.openqa.selenium.By;

public class CheckForAccordion {
    public static final By[] dropDowns = {
            By.id("accordion__heading-0"),  //Первый элемент выпадающего списка
            By.id("accordion__heading-1"),
            By.id("accordion__heading-2"),
            By.id("accordion__heading-3"),
            By.id("accordion__heading-4"),
            By.id("accordion__heading-5"),
            By.id("accordion__heading-6"),
            By.id("accordion__heading-7"),  //Последний элемент выпадающего списка
    };
    public static By cookieButton = By.className("App_CookieButton__3cvqF"); // Кнопка куков
}
