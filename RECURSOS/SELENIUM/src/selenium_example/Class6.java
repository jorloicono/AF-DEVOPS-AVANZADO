package selenium_example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Class6 {
    public static void main(String[] args) {

        System.setProperty("web-driver.chrome.driver","./drivers/chromedriver.exe");

        // Creo la instancia del navegador

        WebDriver driver = new ChromeDriver();

        try{

            // Navegamos a la web

            driver.get("C:/Users/Jorge/Desktop/AF-DEVOPS-AVANZADO/RECURSOS/index_completo.html");

            // Busco el elemento por id y lo guardo en un webelement

            WebElement buttonImplicitWait = driver.findElement(By.id("implicitWaitButton"));

            // lo clico

            buttonImplicitWait.click();

            // Esperamos 5 segundos a partir de ahora lo usamos simplemente para nosotros verlo de forma detenida no para esperar a los elemento

            Thread.sleep(5000);

            // Esto me va a dar un error, ¿?¿?¿?¿? no ha cargado por que no hay ningun mecanismo de espera y selenium no ha sido capaz de  encontrar ese boton
            // En la class7 veremos como arreglar esto

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
