import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.*;

public class Task2 {

    static SelenideElement generateButton = $("#generate");
    public static String substr1;
    public static String receivedText;

    static {
        Configuration.screenshots = false;
    }

    @BeforeAll
    public static void openLipsum() {
        open("https://www.lipsum.com/");
        $("#amount").setValue("141");
//        $x("//input[@id='generate']").click();
        generateButton.click();

        receivedText = $x("//div[@id='lipsum']").getText();
        substr1 = receivedText.substring(1);
    }

//    @AfterAll
//    public void tearDown() {
//       browser.quite();
//    }

    @Test
    public void verifyAQuastion() {
        open("http://bbc.com");
//        $x("//a[text()='News']").click();
//        $x("//div[@id='orb-nav-links']//a[contains(@href, 'news')]").click();
        $x("//div[@id='orb-nav-links']//a[contains(text(), 'News')]").click();

        $x("//span[@class='gel-long-primer gs-u-ph']").click();
        $x("//span[contains(text(), 'Have Your Say')]").should(Condition.appear).click();
        $x("(//div[contains(@class, 'gs-c-promo-body--primary')]//h3[contains (@class, 'gs-c-promo-heading__title')])[3]/..").click();


        $x("//input[@placeholder='Name']").setValue("Darina");
        $x("//input[@placeholder='Email address']").setValue("donetsdarina95@gmail.com");
        $x("//input[@placeholder='Age']").setValue("24");
        $x("//input[@placeholder='Postcode']").setValue("03057");
        $x("//textarea[contains(@placeholder,'What questions would')]").setValue(substr1);

        Selenide.screenshot("myScreenShot".concat(String.valueOf(LocalDate.now())));

    }
// Далі тести не писала, так як "error msg" на сайті BBC не працюють і тести не доцільні.


}
