package Pages;
import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductDetailPage  extends BaseLibrary {


    @Step("Favorilere Ekle Butonuna Tıklanır")
    public ProductDetailPage clickAddToFavoritesButton(){
        // [class="fv"]
        WebElement element = driver.findElement(By.cssSelector("[class='fv']"));
        element.click();
        return this;
    }


    @Step("Ürün Başlığını Getir")
    public String getProductTitle(){
        //[class="pr-in-cn"] span
        WebElement element = driver.findElements(By.cssSelector("[class='pr-in-cn'] span")).get(0); //1.div yani 0.index
        String text=element.getText();
        return text;
    }


}
