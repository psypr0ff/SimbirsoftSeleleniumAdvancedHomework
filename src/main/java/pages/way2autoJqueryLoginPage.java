package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Александр on 27.04.2018.
 */
public class way2autoJqueryLoginPage {
    private WebDriver driver;

    //инициализируем ПэйджФэктори
    public way2autoJqueryLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    //ссылка на форму авторизации
    @FindBy (xpath = "//div[@id='load_box']//a[@class='fancybox']")
    private WebElement loginLink;

    //поле ввода логина
    @FindBy (xpath = "//div[@id='login']//input[@name='username']")
    private WebElement username;

    //поле ввода пароля
    @FindBy (xpath = "//div[@id='login']//input[@name='password']")
    private WebElement password;

    //кнопка submit
    @FindBy (xpath = "//div[@id='login']//input[@type='submit']")
    private WebElement submitBtn;

    //cообщение об ошибке
    //*[@id="alert1"]
    @FindBy (xpath = "//*[@id='alert1']")
    private WebElement alert;

    //обработчик клика
    private void click(WebElement webElement) throws InterruptedException{
        webElement.click();
        Thread.sleep(1000);
    }

    //обработчик ввода текста
    private void sendText(String text, WebElement webElement) throws InterruptedException{
        webElement.sendKeys(text);
        Thread.sleep(1000);
    }

    //жмем на кнопку отправки формы
    private void submitHere(WebElement webElement) {
        webElement.submit();
    }

    //попробуем залогиниться
    public void loginHere(String login, String pass) throws InterruptedException{
        click(loginLink); //кликаем на ссылку Submit
        sendText(login,username); //вводим логин
        sendText(pass, password); //вводим пароль
        submitHere(submitBtn); //отправляем данные формы нажатием на кнопку Submit
        if (alert.getText().contains("Invalid username password.")){ //проверяем не ошиблись ли мы с вводом пары логин/пароль
            System.out.println(alert.getText());
            driver.quit(); //если получили уведомление об ошибке логина/пароля - закрываем браузер
        }
        System.out.println("Мы залогинились");
    }
}
