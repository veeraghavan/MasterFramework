package functionalprogramming;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterface {

    public static void main(String args[]) {
        //List<String> list = Arrays.asList("Veera", "Raghavan", "Ravi");

        /*for(String temp : list) {
            System.out.println(temp);
            System.out.println(temp.toUpperCase());
            System.out.println(temp.toLowerCase());
        }*/
        /*Consumer<String> c = s -> System.out.println(s);
        Consumer<String> c1 = s -> System.out.println(s.toUpperCase());
        Consumer<String> c2 = s -> System.out.println(s.toLowerCase());
        list.forEach(c.andThen(c1).andThen(c2));*/


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().minimize();
        List<WebElement> list = driver.findElements(By.tagName("a"));
        Consumer<WebElement> consumer = (e) -> {
            if(!e.getText().isBlank())
                System.out.println(e.getText());
        };
        list.forEach(consumer);
        driver.quit();
    }
}
