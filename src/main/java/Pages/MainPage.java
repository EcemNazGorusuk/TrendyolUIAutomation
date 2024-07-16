package Pages;

import Base.BaseLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends BaseLibrary {

    public MainPage clickKabulEtButton() throws InterruptedException {
      //elemanın gelmesi durumunda tıklanacak,gelmemesi durumuda tıklanmayacak:
        sleepThread(4000);
        WebElement element=driver.findElement(By.id("onetrust-accept-btn-handler")); //[id="onetrust-accept-btn-handler"]
        if(element.isDisplayed())
           driver.findElement(By.id("onetrust-accept-btn-handler")).click(); //

        return this;
    }

}
