import Base.BaseLibrary;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.Test;
//BaseTests classımız bizim parent classımız olduğu için onun temel özelliklerini, child (sub) class olan bu classta kullanıcaz (inheritance)
//böylece Basetests içindeki ögeleri ( @before , @after ) doğrudan burada kullanabiliriz

public class UserTests extends BaseLibrary {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();


    //test senaryosu için login successful metodu:
    @Test(description ="Başarılı Login Kullanıcı Giriş Kontrolü")  // import org.junit.Test;  bunun yerine bunu kullan ---->   import org.testng.annotations.Test;
    public void loginSuccessful() throws InterruptedException {
        //email ve password alanlarına erişimi şu inheritance düzeni sağlıyor ---> BaseLibrary > Data  > BaseTests  > UserTests
        loginPage.emailDoldur(email); //loginPage'in türündeki bu metodu BaseLibrary'deki driver & Data'daki email ile doldurulur
        loginPage.passwordDoldur( password);  //loginPage'in türündeki bu metodu BaseLibrary'deki driver & Data'daki password ile doldurulur
        loginPage.clickLoginButton();   //loginPage'in türündeki bu metodu BaseLibrary'deki driver ile doldurulur

        /*Bu kullanım da doğru:
        /* loginPage.emailDoldur(email)
                    .passwordDoldur(password)
                    .clickLoginButton();
        */

       //trendyol sayasında "Giriş yap" textinin login olunca "Hesabım" textine dönüşüp dönüşmediğinin kontrolü için: getText()  (bekleme de eklenmeli)
        sleepThread(3000); //* throws InterruptedException  -> çok önemli
        homePage.hesabimControl();
    }


  //test senaryosu için login unsuccessful (yanlış password) metodu:
    @Test
    public void notValidLoginWithWrongPassword() throws InterruptedException {
        loginPage.emailDoldur(email)
                 .passwordDoldur("431457")   // (hata vermesi bekleniyor)
                 .clickLoginButton();

        sleepThread(3000); //* throws InterruptedException  -> çok önemli
        loginPage.getErrorMessage(errMsg1);
    }


    //test senaryosu için login unsuccessful (yanlış e-mail) metodu:
    @Test
    public void notValidLoginWithWrongEMail() throws InterruptedException {
        loginPage.emailDoldur("ecemnaz@gmail.com") // (hata vermesi bekleniyor)
                 .passwordDoldur("431457ecem")
                 .clickLoginButton();

        sleepThread(3000); //* throws InterruptedException  -> çok önemli
        loginPage.getErrorMessage(errMsg1);
    }


    //test senaryosu için login unsuccessful (boşluk kontrolü  ) metodu:
    @Test
    public void notValidLoginRequiredBlankControl() throws InterruptedException {
        //email & password alanlarının boş girilmesi
        loginPage.emailDoldur("")       // (hata vermesi bekleniyor)
                 .passwordDoldur("") //(hata vermesi bekleniyor)
                 .clickLoginButton();
        sleepThread(3000); //* throws InterruptedException  -> çok önemli
        loginPage.getErrorMessage(errMsgEmail);


        //password alanının boş girilmesi
        loginPage.emailDoldur(email)
                 .clickLoginButton();
        sleepThread(3000); //* throws InterruptedException  -> çok önemli
        loginPage.getErrorMessage(errMsgPassword);


        //emaili doğru doldurulmuş alana doğru şifre girelmesi
        loginPage.passwordDoldur("431457ecem")
                 .clickLoginButton();

        sleepThread(3000); //* throws InterruptedException  -> çok önemli
        homePage.hesabimControl();
    }


    //test senaryosu için login minimum karakter kontrolü (e-mail - password için) metodu:
    @Test
    public void minCharacterControl() throws InterruptedException {
        //email & password alanlarının min karakter kontrolü
        loginPage.emailDoldur("1")
                 .passwordDoldur("12")
                 .clickLoginButton();

        sleepThread(3000);//* throws InterruptedException  -> çok önemli
        loginPage.getErrorMessage(errMsgEmail);

        loginPage.passwordClean();
        loginPage.emailClean();


        //password alanının min karakter kontrolü
        loginPage.emailDoldur(email);
        loginPage.passwordClean(); //eğer kontrol edilecek alan password ise 2.kere temizleme işlemini hemen üstünde yap ki önceki karakteri de eklemesin
        loginPage.passwordDoldur("12")
                 .clickLoginButton();
        sleepThread(3000); //* throws InterruptedException  -> çok önemli
        loginPage.getErrorMessage(errMsg1);
    }


    //test senaryosu için login maximum karakter kontrolü (e-mail - password için) metodu:
    @Test
    public void maxCharacterControl() throws InterruptedException {
        //email & password alanlarının max karakter kontrolü
        loginPage.emailDoldur("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@gmail.com") //(hata vermesi bekleniyor)
                 .passwordDoldur("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")//(hata vermesi bekleniyor)
                 .clickLoginButton();
        sleepThread(3000); //* throws InterruptedException  -> çok önemli
        loginPage.getErrorMessage(errMsg1);
        loginPage.passwordClean();
        loginPage.emailClean();



        //password alanının max karakter kontrolü
        loginPage.emailDoldur("ecemnazgorusuk@gmail.com")
                 .passwordDoldur("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@gmail.com") //(hata vermesi bekleniyor)
                 .clickLoginButton();
        sleepThread(3000); //* throws InterruptedException  -> çok önemli
        loginPage.getErrorMessage(errMsg1);
        loginPage.passwordClean();
        loginPage.emailClean();



        //eğer 2 alan da doğru girilmiş olsaydı:
        loginPage.emailClean(); //eğer kontrol edilecek alan email ise 2.kere temizleme işlemini hemen üstünde yap ki önceki karakteri de eklemesin
        loginPage.emailDoldur("ecemnazgorusuk@gmail.com");   //idsi login-email olan input alanına mail adresini yazar (hata vermesi bekleniyor)
        loginPage.passwordClean(); //eğer kontrol edilecek alan password ise 2.kere temizleme işlemini hemen üstünde yap ki önceki karakteri de eklemesin
        loginPage.passwordDoldur("431457ecem")
                 .clickLoginButton();
        // trendyol sayasında "Giriş yap" textinin login olunca "Hesabım" textine dönüşüp dönüşmediğinin kontrolü için: getText()  (bekleme de eklenmeli)
        sleepThread(3000); //* throws InterruptedException  -> çok önemli
        homePage.hesabimControl();
    }



}
