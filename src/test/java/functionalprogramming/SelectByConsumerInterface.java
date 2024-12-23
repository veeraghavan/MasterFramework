package functionalprogramming;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.function.Consumer;

public class SelectByConsumerInterface {
    static WebDriver driver = null;
    public static void main(String[] args) throws InterruptedException {

        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://demoqa.com/select-menu");
            driver.manage().window().maximize();

            // Traditional - old style select dropdown list box
            /*WebElement oldSelect = driver.findElement(By.id("oldSelectMenu"));
            selectOptionInDropdown(oldSelect, "text", "Yellow");
            Thread.sleep(2000);
            selectOptionInDropdown(oldSelect, "value", "4");
            Thread.sleep(2000);
            selectOptionInDropdown(oldSelect, "index", "2");
            Thread.sleep(2000);*/

            // Consumer interface - old style select dropdown list box
            WebElement oldSelect = driver.findElement(By.id("oldSelectMenu"));
            selectFromDropdown((e) -> e.selectByVisibleText("Yellow"), oldSelect);
            Thread.sleep(2000);
            selectFromDropdown(e -> e.selectByValue("4"), oldSelect);
            Thread.sleep(2000);
            selectFromDropdown(e -> e.selectByIndex(2), oldSelect);
            Thread.sleep(2000);

            // Traditional - Multiselect Dropdown options
            // Command to set in console to freeze a webpage to catch the dynamic element that diappears immediatley on any actions "SetTimeout(() => { debugger; }, 2000);"
            /*WebElement multiSelectParent = driver.findElement(By.xpath("//div[text()='Select...']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", multiSelectParent);
            multiSelectParent.click();
            //Thread.sleep(5000);
            List<WebElement> listMultiSelectDropdownOptions = driver.findElements(By.xpath("//div[text()='Select...']/../../..//div[contains(@class, '-menu')]//div[contains(@id, 'react-select-4')]"));
            for (WebElement element : listMultiSelectDropdownOptions) {
                if (element.getText().equalsIgnoreCase("green") || element.getText().equalsIgnoreCase("red"))
                    element.click();
            }*/

            // Customer Interface - Multiselect Dropdown options
            WebElement multiSelectParent = driver.findElement(By.xpath("//div[text()='Select...']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", multiSelectParent);
            multiSelectParent.click();
            List<WebElement> listMultiSelectDropdownOptions = driver.findElements(By.xpath("//div[text()='Select...']/../../..//div[contains(@class, '-menu')]//div[contains(@id, 'react-select-4')]"));


            // -- to select all the elements present in a dropdown ---
            //listMultiSelectDropdownOptions.forEach(element -> element.click());

            // -- to select user desired elements present in a dropdown ---
            // writing logic inside for each
            /*listMultiSelectDropdownOptions.forEach(element -> {
                if(element.getText().equalsIgnoreCase("green") || element.getText().equalsIgnoreCase("red"))
                    element.click();
            });*/

            //writing logic to filter outside for each
            listMultiSelectDropdownOptions.stream().filter(e -> e.getText().equalsIgnoreCase("green")
                    || e.getText().equalsIgnoreCase("red")).forEach(e -> e.click());


            // Traditional standard multi select
            /*WebElement stdMultiSelect = driver.findElement(By.id("cars"));
            selectOptionInDropdown(stdMultiSelect, "text", "Saab");
            Thread.sleep(2000);
            selectOptionInDropdown(stdMultiSelect, "value", "volvo");
            Thread.sleep(2000);
            selectOptionInDropdown(stdMultiSelect, "index", "2");
            Thread.sleep(2000);


            List<WebElement> listStdSelectDropdownOptions = driver.findElements(By.xpath("//select[@id='cars']/option"));
            for (WebElement element : listStdSelectDropdownOptions) {
                if (element.getText().equalsIgnoreCase("audi"))
                    element.click();
            }*/

            // Consumer Interface standard multi select
            List<WebElement> listStdSelectDropdownOptions = new Select(driver.findElement(By.id("cars"))).getOptions();
            //listStdSelectDropdownOptions.forEach(e->e.click());
            listStdSelectDropdownOptions.stream().skip(2).forEach(e -> e.click());
            Thread.sleep(5000);
        } catch (Exception e) {
            new Exception(e);
        } finally {
            driver.quit();
        }
    }

    private static void selectFromDropdown(Consumer<Select> consumer, WebElement element) {
        Select select = new Select(element);
        consumer.accept(select);
    }

    private static void selectOptionInDropdown(WebElement element, String strategyTextOrValueOrIndex, String valueToBeSelected) {
        Select select = new Select(element);
        if (strategyTextOrValueOrIndex.equalsIgnoreCase("text"))
            select.selectByVisibleText(valueToBeSelected);
        else if (strategyTextOrValueOrIndex.equalsIgnoreCase("value"))
            select.selectByValue(valueToBeSelected);
        else if (strategyTextOrValueOrIndex.equalsIgnoreCase("index"))
            select.selectByIndex(Integer.parseInt(valueToBeSelected));
    }
}
