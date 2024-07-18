package Pages;

import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class MainPage extends BaseLibrary {

    @Step("Kabul Et Alanı Kontrolü")
    public MainPage clickKabulEtButton() throws InterruptedException {
      //elemanın gelmesi durumunda tıklanacak,gelmemesi durumuda tıklanmayacak:
        sleepThread(4000); //önemli
        WebElement element=driver.findElement(By.id("onetrust-accept-btn-handler")); //[id="onetrust-accept-btn-handler"]
        if(element.isDisplayed())
           driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        return this;
    }

    @Step("Arama İşlemi Sağlanır")
    public MainPage fillSearchBar(String searchText){
        //[data-testid="suggestion"]
        WebElement element= driver.findElement(By.cssSelector("[data-testid='suggestion']"));
        element.sendKeys(searchText, Keys.ENTER); //Keys.ENTER ; kelimeyi yazıp klavyede enter yapmayı sağlar
        return this;
    }

    @Step("Favorilere Ekle Butonuna Tıklanır")
    public MainPage clickFavoritesButton(){
        // [class="account-nav-item account-favorites"]
        WebElement element = driver.findElement(By.cssSelector("[class='account-nav-item account-favorites']"));
        element.click();
        return this;
    }
}
