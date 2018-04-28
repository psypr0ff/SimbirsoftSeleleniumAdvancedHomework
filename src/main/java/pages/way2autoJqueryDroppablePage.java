package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by Александр on 28.04.2018.
 */
public class way2autoJqueryDroppablePage {
    private WebDriver driver;
    private Actions actions;

    //инициализируем ПейджФэктори
    public way2autoJqueryDroppablePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    //нужный нам фрейм
    @FindBy(xpath = "//iframe[@src='droppable/default.html']" )
    private WebElement frame;

    //перетаскиваемый элемент
    @FindBy(xpath = "//div[@id='draggable']")
    private WebElement draggable;

    //целевой элемент
    @FindBy (xpath = "//div[@id='droppable']")
    private WebElement droppable;

    public void dragAndDrop(){
        System.out.println("Зашли на страничку Droppable");
        driver.switchTo().frame(frame); //переключаемся на нужный фрейм
        System.out.println("Переключились на нужный фрейм");
        actions = new Actions(driver);
        actions
                .dragAndDrop(draggable,droppable)   //перетаскиваем нужный элемент на целевой элемент
                .build()                            //собираем
                .perform();                         //исполняем
        Assert.assertTrue(droppable.getText().equals("Dropped!")); //проверяем, соответствет ли надпись на целевом элементе
        System.out.println("Перетащили элемент драгэндропом");
    }
}
