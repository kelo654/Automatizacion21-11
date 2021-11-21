import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Laboratorio3 { //1:30:56
    WebDriver driver;
    File screen;
    String driverPath="..\\Prueba1\\drivers\\chromedriver.exe";
    String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    @BeforeSuite
    public void SetUp(){

        System.setProperty("webdriver.chrome.driver",driverPath);
        driver=new ChromeDriver();
        //Abrir pagina y max pantalla
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test(description = "Busqueda simple",priority = 4)
    public void buscarPalabra() throws Exception {
        Assert.assertEquals(driver.getTitle(),"Login - My Store");

        screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen, new File("..\\Prueba1\\Evidencias\\Pagina_principal.png"));

        WebElement txtBuscar= driver.findElement(By.id("search_query_top"));
        txtBuscar.sendKeys("Dress");
        txtBuscar.sendKeys(Keys.ENTER);

        screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen, new File("..\\Prueba1\\Evidencias\\Resultado_busqueda.png"));

        Assert.assertEquals(driver.getTitle(),"Search - My Store");

    }

    @Test(description = "ir a contactos",priority = 2)
    public void IrAContactUs(){
        WebElement lnkContact = driver.findElement(By.linkText("Contact us"));
        lnkContact.click();
    }

    @Test(description = "Crear un usuario nuevo",priority = 1)
    public void crearUsuario(){
        WebElement txtEmail = driver.findElement(By.id("email_create"));
        txtEmail.sendKeys("eze"+ Math.random()+"@email.com");
        driver.findElement(By.name("SubmitCreate")).click();

        WebDriverWait wait = new WebDriverWait (driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='id_gender1']")));

        //Radio boton
        WebElement radMR = driver.findElement(By.xpath("//input[@id='id_gender1']"));
        radMR.click();

        //Txt
        WebElement txtFirtsName =driver.findElement(By.id("customer_firstname"));
        txtFirtsName.sendKeys("Ezequiel");

        WebElement txtLastName =driver.findElement(By.id("customer_lastname"));
        txtLastName.sendKeys("Tomassini");

        WebElement txtPass =driver.findElement(By.id("passwd"));
        txtPass.sendKeys("kelo123");

        //Select
        Select days = new Select(driver.findElement(By.id("days")));
        days.selectByValue("7");

        Select moth = new Select(driver.findElement(By.id("months")));
        moth.selectByValue("2");

        Select year = new Select(driver.findElement(By.id("years")));
        year.selectByValue("1994");

        //CheckBox
        WebElement chkNew = driver.findElement(By.id("newsletter"));
        chkNew.click();

        WebElement txtAddress =driver.findElement(By.id("address1"));
        txtAddress.sendKeys("Rivadavia 123");

        WebElement txtCity =driver.findElement(By.id("city"));
        txtCity.sendKeys("Cordoba");

        Select State = new Select(driver.findElement(By.id("id_state")));
        State.selectByValue("1");


        WebElement txtZip = driver.findElement(By.id("postcode"));
        txtZip.sendKeys("46250");

        WebElement txtPhone = driver.findElement(By.id("phone_mobile"));
        txtPhone.sendKeys("3513393388");

        WebElement txtAlias = driver.findElement(By.id("alias"));
        txtAlias.sendKeys("Rivadavia 3786");

        WebElement btnRegistro =driver.findElement(By.id("submitAccount"));
        btnRegistro.click();


    }

    @AfterSuite
    public void TearDown(){
        driver.close(); // Cerrar ventana

    }
}
