package Base;
import Pages.MainPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest  extends BaseLibrary{

    MainPage mainPage =new MainPage();


    //before kullanımı: test başlamadan yapılması gereken işlemleri içerir
    @BeforeMethod //testng için
    public void setUp() throws InterruptedException {
        driver=new ChromeDriver();//bu driver nesnesi, chrome tarayıcısını otomatik olarak açacak
        driver.manage().window().maximize(); //açılan chrome penceresini büyütür
        driver.get("https://www.trendyol.com/giris");
        mainPage.clickKabulEtButton();
    }


    //after kullanımı: test işlemi bittikten sonra yapılacak işemleri içerir
    @AfterMethod  //testng için
    public void tearDown(){
        driver.quit(); // WebDriver'ı kapat
    }

}
