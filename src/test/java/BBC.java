import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

public class BBC {

    SelenideElement topMenuNews = $x("//a[text()='News']");
    SelenideElement searchButton = $("#orb-search-q");

    List<String> newsTitles = new LinkedList<String>();

    public BBC() {
        newsTitles.add("Bodies found in Canada hunt for murder suspects");
        newsTitles.add("Hundreds arrested in Mississippi immigration raids");
        newsTitles.add("Kyrgyzstan troops storm ex-president's home");
    }

//    аннотация
    @BeforeEach
    public void before() {
        open("http://bbc.com");
    }

    @Test
    public void testBBC() {
        topMenuNews.should(Condition.appear).click();

        List<String> articlesTopName = $$x("//div[contains(@class,'top-stories')]//h3[contains(@class,'gs-c-promo-heading')]").texts();

        assertThat(articlesTopName).containsAll(newsTitles);
    }

    @Test
    public void searchBBCNews(){
//        String textToSearch = newsTitles.get(0);
        String textToSearch = "Bla";


//        sendKeys(setValue) - отправляет текст в элемент
        searchButton.setValue(textToSearch).pressEnter();


//        $x("//h1[@itemprop='headline']/a[contains(text(),'Second Ebola death in densely packed DR Congo city')]").should(Condition.appear);
        $x(format("//h1[@itemprop='headline']/a[contains(text(),'%s')]", textToSearch)).should(Condition.appear);
    }

}
