import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SimpleTest {

    public static void main(String[] args)  {

        //Change path to your chromedriver!
        System.setProperty("webdriver.chrome.driver", "/Users/yevheniizubriichuk/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://helpcrunch.com");

        WebElement widget = driver.findElement(By.xpath(ChatLocators.ChatWidget));
        widget.click();

        driver.switchTo().frame(widget);

        WebElement messageTextField = driver.findElement(By.xpath(ChatLocators.MessageTextField));
        messageTextField.sendKeys("Hello qa test!");

        WebElement sendButton = driver.findElement(By.className(ChatLocators.SendButton));
        sendButton.click();

        WebElement nameField = driver.findElement(By.name(ChatLocators.NameField));
        nameField.sendKeys("Yevhenii");

        WebElement emailField = driver.findElement(By.name(ChatLocators.EmailField));
        emailField.sendKeys("boyhawk1805@gmail.com");

        WebElement continueButton = driver.findElement(By.cssSelector(ChatLocators.ContinueButton));
        continueButton.click();

        driver.quit();
    }

}