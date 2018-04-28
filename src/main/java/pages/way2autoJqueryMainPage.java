package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Александр on 28.04.2018.
 */
public class way2autoJqueryMainPage {
    private WebDriver driver;
    private Actions actions;

    //инициализируем ПейджФэктори
    public way2autoJqueryMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    //элемент interacton menu
    @FindBy(xpath = "//ul[@id='toggleNav']//a[text()='Interaction']")
    private WebElement interaction;

    //элемент droppable в меню interaction
    @FindBy(xpath = "//ul[@id='toggleNav']//a[text()='Droppable']")
    private WebElement droppable;

    public void goToDroppable() throws InterruptedException{
        actions = new Actions(driver);
        actions
                .moveToElement(interaction) //переходим на элемент Interaction
                .pause(1000)                //ждем 1 сек
                .moveToElement(droppable)   //переходим на элемент Droppable
                .click()                    //кликаем
                .build()                    //собираем
                .perform();                 //исполняем собранное
        System.out.println("Нашли элемент выпадающего меню Interaction/Droppable на главной страничке");
    }
}
