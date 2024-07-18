package Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class BaseLibrary extends Data {

    public static WebDriver driver;

    public void sleepThread(int time) throws InterruptedException {
       Thread.sleep(time);
   }

   //sekme değişikliği için (örneğin bir ürüne tıklayınca yeni bir sayfaya geçip açıyorsa)
    public void switchTab(){
        ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

    }
}
