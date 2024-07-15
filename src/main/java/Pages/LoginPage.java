package Pages;
//Login sayfasına ait gerekli tüm kodlar burada olacak
import Base.BaseLibrary;
import org.junit.Assert;
import org.openqa.selenium.By;

/**
  * return this;  Metodun, mevcut LoginPage nesnesini geri döndürmesini sağlar.
  * Bu, metodu zincirleme (method chaining) için kullanmanıza olanak tanır; bu sayede birden fazla metoda art arda çağrı yapabiliriz.
 **/

public class LoginPage extends BaseLibrary {


    public LoginPage emailDoldur(String email){
        //LoginPage türündeki metod
        driver.findElement(By.id("login-email")).sendKeys(email);   //idsi login-email olan input alanına mail adresini yazar
        return this;
    }
    public LoginPage emailClean(){
        //LoginPage türündeki metod
        driver.findElement(By.id("login-email")).clear();   //idsi login-email olan input alanını temizler
        return this;
    }

    public LoginPage passwordDoldur(String password){
        //LoginPage türündeki metod
        driver.findElement(By.id("login-password-input")).sendKeys(password);   //idsi login-password-input olan input alanına şifreyi yazar
        return this;
    }

    public LoginPage passwordClean(){
        //LoginPage türündeki metod
        driver.findElement(By.id("login-password-input")).clear();   //idsi login-password-input olan input alanını temizler
        return this;
    }

    public LoginPage clickLoginButton(){
        //LoginPage türündeki metod
        driver.findElement(By.xpath("//*[@id=\"login-register\"]/div[3]/div[1]/form/button")).submit(); //giriş yap butonu için
        return this;
    }

    public LoginPage getErrorMessage(String errMsg){
        //LoginPage türündeki metod
        String value= driver.findElement(By.cssSelector("[class='message']")).getText(); //value değişkeni gelen texti tutacak (actual result)
        Assert.assertEquals(errMsg, value);  //beklenen ve gerçek durumları karşılaştırırken kullanırız. (expected result)
        System.out.println(value);
        return this;
    }
}
