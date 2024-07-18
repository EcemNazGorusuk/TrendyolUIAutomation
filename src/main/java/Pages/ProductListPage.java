package Pages;

import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductListPage extends BaseLibrary {

    // [class="p-card-wrppr with-campaign-view"]
    //   driver.findElements()).get(0).click();
    @Step("Ürün Listesinden İlk Ürüne Tıklanır")
    public ProductListPage clickFirstProductCard(){
      WebElement element= driver.findElements(By.cssSelector("[class='p-card-wrppr with-campaign-view']")).get(0);
      element.click();
        return this;
    }
}
