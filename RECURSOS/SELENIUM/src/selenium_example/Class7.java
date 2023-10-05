package selenium_example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class Class7 {
    public static void main(String[] args) {

        System.setProperty("web-driver.chrome.driver","./drivers/chromedriver.exe");

        // Creo la instancia del navegador

        WebDriver driver = new ChromeDriver();

        // Con esto le indico a selenium que en caso de no aparecer al principio espere 10 segundos hasta encontrarlo

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try{

            // Navegamos a la web

            driver.get("C:/Users/Jorge/Desktop/AF-DEVOPS-AVANZADO/RECURSOS/index_completo.html");

            // Busco el elemento por id y lo guardo en un webelement

            WebElement buttonImplicitWait = driver.findElement(By.id("implicitWaitButton"));

            // lo clico

            buttonImplicitWait.click();

            // Esperamos 5 segundos a partir de ahora lo usamos simplemente para nosotros verlo de forma detenida no para esperar a los elemento

            Thread.sleep(5000);

            // Esto ya no me da error puedo ver en el navegador que me aparece como si se ha publicado el mensaje correctamente


        }catch (Exception e){
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
