package selenium_example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class Class9 {
    public static void main(String[] args) {

        System.setProperty("web-driver.chrome.driver","./drivers/chromedriver.exe");

        // Creo la instancia del navegador

        WebDriver driver = new ChromeDriver();

        try{

            // Navegamos a la web

            driver.get("C:/Users/Jorge/Desktop/AF-DEVOPS-AVANZADO/RECURSOS/index_completo.html");

            // Es un wait generico

            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(Exception.class);

            // Busco el elemento por id y lo guardo en un webelement utilizando los mecanismos de espera

            WebElement buttonExplicitWait2 = wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver webDriver) {
                    return driver.findElement(By.id("explicitWaitButton"));
                }
            });

            // lo clico

            buttonExplicitWait2.click();

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
