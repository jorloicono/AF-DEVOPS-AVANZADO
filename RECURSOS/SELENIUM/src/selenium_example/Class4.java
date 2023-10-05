package selenium_example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Class4 {
    public static void main(String[] args) {

        System.setProperty("web-driver.chrome.driver","./drivers/chromedriver.exe");

        // Creo la instancia del navegador

        WebDriver driver = new ChromeDriver();

        try{

            // Navegamos a la web

            driver.get("https://www.wikipedia.es");

            // Esperamos 2 segundos

            Thread.sleep(1000);

            // Busco el elemento con ese tag name y lo guardo en un webelement

            WebElement titleElement = driver.findElement(By.tagName("title"));

            // Obtengo el atributo inner text de ese webelement

            String titulo = titleElement.getAttribute("innerText");

            // Printeo el titulo de esa nueva pagina, veo que es el historial de la pagina

            System.out.println(titulo);

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}