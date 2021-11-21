package utilidades;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	
public static void screenshot(String ruta,String nombre, WebDriver driver) throws Exception {
	
	File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(screen,new File(ruta+"\\" +nombre+System.currentTimeMillis()+".png"));
}

}
