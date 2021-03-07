package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class testsetup {

    Map<String, Map<String,String>> osMap = new HashMap<>();
    Map<String,String> propertiesMap = new HashMap<>();
    public WebDriver driver = null;

    @BeforeSuite
 public void initDriver(){
     propertyReader();
     System.setProperty("webdriver.chrome.driver",propertiesMap.get("win.chrome"));
     driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.get("https://www.amazon.in/amazonprime?_encoding=UTF8&%2AVersion%2A=1&%2Aentries%2A=0");
 }

 public void propertyReader(){
     Properties prop = new Properties();
     try {
         InputStream input = new FileInputStream("src/config/config.properties");
         prop.load(input);
     }catch (Exception e){
         System.out.println(e);
     }

     for(String key:prop.stringPropertyNames()){
         String value = prop.getProperty(key);
         propertiesMap.put(key,value);
     }
 }

 public void switchToNewTab() throws InterruptedException {
        String parent = driver.getWindowHandle();
        Thread.sleep(5000);
        Set<String> allWindows = driver.getWindowHandles();
        for(String child:allWindows){
            if(!parent.equalsIgnoreCase(child)){
                driver.switchTo().window(child);
            }
        }
 }
}