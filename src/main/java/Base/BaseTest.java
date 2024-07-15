package Base;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest  extends Data{


    public static WebDriver driver=new ChromeDriver();

    //before kullanımı: test başlamadan yapılması gereken işlemleri içerir
    @Before
    public void setUp(){
        driver=new ChromeDriver();//bu driver nesnesi, chrome tarayıcısını otomatik olarak açacak
        driver.manage().window().maximize(); //açılan chrome penceresini büyütür
        driver.get("https://www.trendyol.com/giris");
    }


    //after kullanımı: test işlemi bittikten sonra yapılacak işemleri içerir
    @After
    public void tearDown(){
        driver.quit(); // WebDriver'ı kapat
    }

}
