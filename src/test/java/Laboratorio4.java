        import Paginas.PaginaInicio;
        import Paginas.PaginaLogin;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.annotations.AfterSuite;
        import org.testng.annotations.BeforeSuite;
        import org.testng.annotations.DataProvider;
        import org.testng.annotations.Test;

public class Laboratorio4 { // 1:46:04
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

    @Test(dataProvider = "datos_registro")
    public void Login(String email, String password){
        PaginaInicio pagina = new PaginaInicio(driver);
        pagina.HacerClickEnSingIn();

        PaginaLogin pagLogin = new PaginaLogin(driver);
        pagLogin.fillEmail(email);
        pagLogin.fillPassword(password);
        pagLogin.clickLogin();
    }
    @DataProvider(name = "datos_registro")
    public Object[][] obtenerDatos(){
        Object[][] datos= new Object[3][2];

        datos[0][0]="kelo123@gmail.com";
        datos[0][1]="gjñsad34";

        datos[1][0]="kelo345@gmail.com";
        datos[1][1]="132fds654";

        datos[2][0]="kelo132@gmail.com";
        datos[2][1]="l.-fdsdsa";

        return datos;
    }

    @AfterSuite
    public void TearDown(){
        driver.close();
    }

}
