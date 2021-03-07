import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import setup.testsetup;

import java.util.concurrent.TimeUnit;

public class TestDemo extends testsetup {

    @Test
    public void test() throws InterruptedException {
        WebElement searchBar = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
        searchBar.clear();
        searchBar.click();
        searchBar.sendKeys("keychains");
        searchBar.sendKeys(Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement item = driver.findElement(By.xpath("//a[@class = \"a-link-normal a-text-normal\"]"));
        item.click();

        switchToNewTab();
        WebElement buyNow = driver.findElement(By.xpath("//input[@id = \"buy-now-button\"]"));
        buyNow.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement loginField = driver.findElement(By.xpath("//input[@type=\"email\"]"));
        loginField.clear();
        loginField.click();
        loginField.sendKeys("MobileNo");
        loginField.sendKeys(Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement password = driver.findElement(By.xpath("//input[@type=\"password\"]"));
        password.clear();
        password.click();
        password.sendKeys("Password");

        WebElement signInBtn = driver.findElement(By.xpath("//input[@id=\"signInSubmit\"]"));
        signInBtn.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
