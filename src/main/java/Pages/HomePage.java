package Pages;
//Home sayfasına ait gerekli tüm kodlar burada olacak

import Base.BaseLibrary;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * return this;  Metodun, mevcut LoginPage nesnesini geri döndürmesini sağlar.
 * Bu, metodu zincirleme (method chaining) için kullanmanıza olanak tanır; bu sayede birden fazla metoda art arda çağrı yapabiliriz.
 **/

public class HomePage extends BaseLibrary {

    public HomePage hesabimControl(){
        //LoginPage türündeki metod
        String value= driver.findElement(By.cssSelector("[class=\"link account-user\"] p")).getText(); //value değişkeni gelen texti tutacak
        Assert.assertEquals("Hesabım", value);
        System.out.println(value);
        return this;
    }
}
