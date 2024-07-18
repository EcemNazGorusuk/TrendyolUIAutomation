import Base.BaseTest;
import Pages.*;
import org.testng.annotations.Test;

public class FavoritesTests extends BaseTest {
    //öncelikle login entegrasyonuna ihtiyaç var
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    ProductListPage productListPage = new ProductListPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();
    FavoritesPage favoritesPage = new FavoritesPage();
    @Test(description = "Favorilere Ürün Ekleme")
    public void addFavoriteProduct() throws InterruptedException {
        loginPage.emailDoldur(email)
                 .passwordDoldur(password)
                 .clickLoginButton();
        sleepThread(5000);



        mainPage.fillSearchBar("Laptop");
        productListPage.clickFirstProductCard();
        switchTab(); //2.ekrana geçiş
        productDetailPage.clickAddToFavoritesButton();
        //favoriye eklediğimiz ürün adını favori listesinde bulmak:
        String productTitle=productDetailPage.getProductTitle();
        mainPage.clickFavoritesButton();
        favoritesPage.productControl(productTitle);
    }


}
