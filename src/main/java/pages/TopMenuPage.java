package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TopMenuPage {

    public static SelenideElement homeButton = $x("//div[@id='orb-nav-links']//a[contains(text(), 'Home')]");
    public static SelenideElement newsButton = $x("//div[@id='orb-nav-links']//a[contains(text(), 'News')]");
    public static SelenideElement sportButton = $x("//div[@id='orb-nav-links']//a[contains(text(), 'Sport')]");

}
