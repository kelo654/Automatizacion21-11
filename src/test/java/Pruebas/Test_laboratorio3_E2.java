package Pruebas;

import Paginas.PaginaInicio;
import Paginas.PaginaLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Test_laboratorio3_E2 {
    WebDriver driver;
    String URL ="http://automationpractice.com/index.php";
    String driverPath="..\\Prueba1\\drivers\\chromedriver.exe";

    @BeforeSuite
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver",driverPath);

        driver=new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @Test
    public void Login(){
        PaginaInicio pagina = new PaginaInicio(driver);
        pagina.HacerClickEnSingIn();

        PaginaLogin pagLogin = new PaginaLogin(driver);
        pagLogin.fillEmail("eze654@email.com");
        pagLogin.fillPassword("kelo123");
        pagLogin.clickLogin();
    }

    @AfterSuite
    public void TearDown(){
        driver.close();
    }

}
