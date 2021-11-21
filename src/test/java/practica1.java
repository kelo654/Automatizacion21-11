        import org.testng.annotations.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.chrome.ChromeOptions;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.Select;
        import org.openqa.selenium.support.ui.WebDriverWait;

public class practica1 {
    String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    String driverPath ="..\\EducacionIT\\drivers\\chromedriver.exe";

    @Test
    public void RegistrarUsuario() {

        System.setProperty("webdriver.chrome.driver", driverPath);

   //     ChromeOptions options =new ChromeOptions();
     //   options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        WebDriver driver = new ChromeDriver();

        //driver.navigate().to(url);
        driver.get(url);
        driver.manage().window().maximize();

        WebElement txtEmail = driver.findElement(By.id("email_create"));
        txtEmail.sendKeys("eze"+ Math.random()+"@email.com");
        driver.findElement(By.name("SubmitCreate")).click();

        WebDriverWait wait = new WebDriverWait (driver,20);
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
}
